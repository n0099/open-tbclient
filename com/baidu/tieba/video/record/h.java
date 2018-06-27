package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private int dbe;
    private int dbf;
    private int dzX;
    private com.baidu.tieba.j.h gOa;
    protected String hcc;
    protected boolean hhA;
    private g hhD;
    private SurfaceView hhE;
    protected List<String> hhF;
    private b hhG;
    private com.baidu.tieba.video.record.b hhH;
    private GLVideoPreviewView.a hhI;
    private c hhJ;
    private GLVideoPreviewView.a hhb;
    private RecordVideoActivity hhv;
    private Bitmap hhw;
    private a hhx;
    private FrameLayout hhy;
    private List<String> hhz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hhB = 0;
    private Camera.Parameters hhC = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDV();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bQ(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        this.mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String string;
                switch (message.what) {
                    case 1:
                        h.this.startPreview();
                        return;
                    case 2:
                        if (h.this.hhv != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hhv, d.k.disallow_camera_permission);
                            if (h.this.gOa != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hhv.getResources().getString(d.k.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gOa.Z(1, string);
                            }
                            h.this.hhv.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hhv != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hhv, d.k.disallow_audio_record_permission);
                            if (h.this.gOa != null) {
                                h.this.gOa.Z(2, h.this.hhv.getResources().getString(d.k.disallow_audio_record_permission));
                            }
                            h.this.hhv.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hhI = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void nn(final boolean z) {
                if (h.this.hhb != null) {
                    com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hhb.nn(z);
                        }
                    });
                }
            }
        };
        this.hhv = recordVideoActivity;
        bDT();
        this.hhw = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dzX = displayMetrics.heightPixels;
        this.hhy = this.hhv.bEn();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hhE = gLVideoPreviewView;
            this.hhD = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hhE).setFaceIdentifyStateListener(this.hhI);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hhE = videoPreviewView;
            this.hhD = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bEn() != null) {
            recordVideoActivity.bEn().addView(this.hhE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hhD.g(this.mCamera);
    }

    public void startRecord() {
        this.hhD.h(this.mCamera);
    }

    public void stopRecord() {
        this.hhD.i(this.mCamera);
    }

    public g bDG() {
        return this.hhD;
    }

    public String bDH() {
        if (this.hhF == null) {
            this.hhF = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.haq);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.haq + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hhF.add(str);
        return str;
    }

    public void bDI() {
        if (this.hhF != null && this.hhF.size() != 0) {
            String remove = this.hhF.remove(this.hhF.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDJ() {
        File file = new File(com.baidu.tieba.video.b.haq);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hcc = com.baidu.tieba.video.b.haq + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hcc;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hhG != null && motionEvent.getAction() == 0) {
            this.hhG.bDV();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bDU();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hhG = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dzX && x >= com.baidu.adp.lib.util.l.e(this.hhv, d.e.ds60)) {
                    int width = this.hhw.getWidth();
                    int height = this.hhw.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dzX - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hhy == null) {
                            this.hhy = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hhy.getChildCount()) {
                                if (this.hhx != this.hhy.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hhy.removeViewAt(i);
                                }
                            }
                        }
                        this.hhx = new a(this.hhv, clamp - (width / 2), clamp2 - (height / 2), this.hhw);
                        this.hhy.addView(this.hhx, new ViewGroup.LayoutParams(-2, -2));
                        bP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bDU();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bDK() {
        int i;
        int i2;
        if (this.mCamera == null && this.hhv != null) {
            this.hhv.finish();
            return;
        }
        int ah = com.baidu.adp.lib.util.l.ah(this.hhv.getPageContext().getPageActivity());
        int bL = bL(this.hhv.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bL * 1.0f) / ah)));
        if (a2 != null) {
            this.dbe = a2.width;
            this.dbf = a2.height;
            this.hhC.setPreviewSize(this.dbe, this.dbf);
            if (this.hhD != null) {
                this.hhD.setPreviewSize(this.dbe, this.dbf);
            }
        }
        this.hhC.setPreviewFormat(17);
        bDL();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hhv, this.mCameraId));
        this.hhz = this.hhC.getSupportedFocusModes();
        if (this.hhz != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hhz.contains("continuous-picture")) {
                this.hhC.setFocusMode("continuous-picture");
            } else if (this.hhz.contains("continuous-video")) {
                this.hhC.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hhC);
        if (this.hhv != null && this.hhv.bEn() != null) {
            float f = (ah * 1.0f) / bL;
            float f2 = (this.dbf * 1.0f) / this.dbe;
            if (f > f2) {
                i = ah;
                i2 = (int) (ah / f2);
            } else {
                i = (int) (bL * f2);
                i2 = bL;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hhE.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hhE.setLayoutParams(layoutParams);
            this.hhE.invalidate();
            if (this.hhJ != null) {
                this.hhJ.bQ(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bL(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.l.aj(context);
        }
        return i;
    }

    private void bDL() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hhC.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr3[1]) > i4 || Math.abs(15000 - iArr3[0]) > i3) {
                i = i3;
                i2 = i4;
                iArr = iArr2;
            } else {
                i2 = Math.abs(20000 - iArr3[1]);
                iArr = iArr3;
                i = Math.abs(15000 - iArr3[0]);
            }
            iArr2 = iArr;
            i4 = i2;
            i3 = i;
        }
        this.hhC.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void no(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nl(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nl(z)) {
                    bDO();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bDN();
                this.hhH = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hhA = z;
            } else {
                bDO();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDO();
            if (this.gOa != null) {
                this.gOa.Z(8, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDM() {
        return this.hhH;
    }

    private void bDN() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hhC = this.mCamera.getParameters();
            bDK();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.m(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bDO() {
        if (this.hhv != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hhv.getPageContext().getPageActivity());
            aVar.cd(d.k.video_quit_confirm);
            aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hhv != null) {
                        h.this.hhv.finish();
                    }
                }
            });
            aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aw(true);
            aVar.b(this.hhv.getPageContext());
            aVar.xn();
        }
    }

    private void releaseCamera() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gOa != null) {
                    this.gOa.Z(6, com.baidu.tieba.j.a.m(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDP() {
        try {
            if (this.mCamera != null) {
                if (this.hhC == null) {
                    this.hhC = this.mCamera.getParameters();
                }
                if ("off".equals(this.hhC.getFlashMode())) {
                    this.hhC.setFlashMode("torch");
                } else {
                    this.hhC.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hhC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOa != null) {
                this.gOa.Z(7, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public boolean bDQ() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hhC == null) {
                this.hhC = this.mCamera.getParameters();
            }
            return !"off".equals(this.hhC.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOa != null) {
                this.gOa.Z(7, com.baidu.tieba.j.a.m(e));
                return false;
            }
            return false;
        }
    }

    public void bDR() {
        if (this.hhE != null && (this.hhE instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hhE;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bDA();
            this.hhB = this.hhB == 0 ? 1 : 0;
            no(this.hhB == 1);
            gLVideoPreviewView.bDB();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hhE != null && (this.hhE instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hhE).j(this.mCamera);
            releaseCamera();
            this.hhB = this.hhB == 0 ? 1 : 0;
            no(this.hhB == 1);
            startPreview();
        }
    }

    public boolean bDS() {
        return this.hhB == 1;
    }

    private void bDT() {
        this.dbe = 720;
        this.dbf = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
        if (this.hhy != null && this.hhx != null && this.hhx.getParent() != null) {
            this.hhy.removeView(this.hhx);
        }
    }

    private void bP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hhz.contains("auto")) {
                this.hhC = this.mCamera.getParameters();
                this.hhC.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hhC);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOa != null) {
                this.gOa.Z(9, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;
        int top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.hhE instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hhE).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hhE instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hhE).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hhE instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hhE).setSticker(stickerItem);
        }
    }

    public void onResume() {
        no(this.hhB == 1);
        if (this.hhE != null && (this.hhE instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hhE).onResume();
        }
        if (this.hhE != null && (this.hhE instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hhE).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bDv()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hhD.j(this.mCamera);
        if (this.hhE != null && (this.hhE instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hhE).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hhJ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hhb = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hhD instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hhD != null) {
                        h.this.hhD.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hhD.a(aVar);
        }
    }

    public boolean bDE() {
        return this.mCameraId == 0;
    }
}
