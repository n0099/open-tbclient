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
    private int cSN;
    private int cSO;
    private int dmn;
    protected String gLs;
    private RecordVideoActivity gQL;
    private Bitmap gQM;
    private a gQN;
    private FrameLayout gQO;
    private List<String> gQP;
    protected boolean gQQ;
    private g gQT;
    private SurfaceView gQU;
    protected List<String> gQV;
    private b gQW;
    private com.baidu.tieba.video.record.b gQX;
    private GLVideoPreviewView.a gQY;
    private c gQZ;
    private GLVideoPreviewView.a gQr;
    private com.baidu.tieba.j.h gxt;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int gQR = 0;
    private Camera.Parameters gQS = null;

    /* loaded from: classes2.dex */
    public interface b {
        void byr();
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
            this.gxt = kVar.aSb();
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
                        if (h.this.gQL != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.gQL, d.k.disallow_camera_permission);
                            if (h.this.gxt != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.gQL.getResources().getString(d.k.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gxt.ac(1, string);
                            }
                            h.this.gQL.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.gQL != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.gQL, d.k.disallow_audio_record_permission);
                            if (h.this.gxt != null) {
                                h.this.gxt.ac(2, h.this.gQL.getResources().getString(d.k.disallow_audio_record_permission));
                            }
                            h.this.gQL.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gQY = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void mY(final boolean z) {
                if (h.this.gQr != null) {
                    com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.gQr.mY(z);
                        }
                    });
                }
            }
        };
        this.gQL = recordVideoActivity;
        byp();
        this.gQM = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dmn = displayMetrics.heightPixels;
        this.gQO = this.gQL.byJ();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.gQU = gLVideoPreviewView;
            this.gQT = gLVideoPreviewView;
            ((GLVideoPreviewView) this.gQU).setFaceIdentifyStateListener(this.gQY);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.gQU = videoPreviewView;
            this.gQT = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.byJ() != null) {
            recordVideoActivity.byJ().addView(this.gQU, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gQT.g(this.mCamera);
    }

    public void startRecord() {
        this.gQT.h(this.mCamera);
    }

    public void stopRecord() {
        this.gQT.i(this.mCamera);
    }

    public g byc() {
        return this.gQT;
    }

    public String byd() {
        if (this.gQV == null) {
            this.gQV = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gJG);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gJG + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gQV.add(str);
        return str;
    }

    public void bye() {
        if (this.gQV != null && this.gQV.size() != 0) {
            String remove = this.gQV.remove(this.gQV.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String byf() {
        File file = new File(com.baidu.tieba.video.b.gJG);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gLs = com.baidu.tieba.video.b.gJG + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gLs;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.gQW != null && motionEvent.getAction() == 0) {
            this.gQW.byr();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.byq();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.gQW = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dmn && x >= com.baidu.adp.lib.util.l.e(this.gQL, d.e.ds60)) {
                    int width = this.gQM.getWidth();
                    int height = this.gQM.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dmn - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gQO == null) {
                            this.gQO = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gQO.getChildCount()) {
                                if (this.gQN != this.gQO.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gQO.removeViewAt(i);
                                }
                            }
                        }
                        this.gQN = new a(this.gQL, clamp - (width / 2), clamp2 - (height / 2), this.gQM);
                        this.gQO.addView(this.gQN, new ViewGroup.LayoutParams(-2, -2));
                        bP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.byq();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void byg() {
        int i;
        int i2;
        if (this.mCamera == null && this.gQL != null) {
            this.gQL.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.gQL.getPageContext().getPageActivity());
        int bB = bB(this.gQL.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bB * 1.0f) / af)));
        if (a2 != null) {
            this.cSN = a2.width;
            this.cSO = a2.height;
            this.gQS.setPreviewSize(this.cSN, this.cSO);
            if (this.gQT != null) {
                this.gQT.setPreviewSize(this.cSN, this.cSO);
            }
        }
        this.gQS.setPreviewFormat(17);
        byh();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.gQL, this.mCameraId));
        this.gQP = this.gQS.getSupportedFocusModes();
        if (this.gQP != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gQP.contains("continuous-picture")) {
                this.gQS.setFocusMode("continuous-picture");
            } else if (this.gQP.contains("continuous-video")) {
                this.gQS.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gQS);
        if (this.gQL != null && this.gQL.byJ() != null) {
            float f = (af * 1.0f) / bB;
            float f2 = (this.cSO * 1.0f) / this.cSN;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (bB * f2);
                i2 = bB;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gQU.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gQU.setLayoutParams(layoutParams);
            this.gQU.invalidate();
            if (this.gQZ != null) {
                this.gQZ.bQ(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bB(Context context) {
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
            return com.baidu.adp.lib.util.l.ah(context);
        }
        return i;
    }

    private void byh() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gQS.getSupportedPreviewFpsRange()) {
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
        this.gQS.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void mZ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.mW(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.mW(z)) {
                    byk();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                byj();
                this.gQX = new com.baidu.tieba.video.record.b(this.mCamera);
                this.gQQ = z;
            } else {
                byk();
            }
        } catch (Exception e) {
            e.printStackTrace();
            byk();
            if (this.gxt != null) {
                this.gxt.ac(8, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b byi() {
        return this.gQX;
    }

    private void byj() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gQS = this.mCamera.getParameters();
            byg();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.g(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void byk() {
        if (this.gQL != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gQL.getPageContext().getPageActivity());
            aVar.bZ(d.k.video_quit_confirm);
            aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gQL != null) {
                        h.this.gQL.finish();
                    }
                }
            });
            aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(this.gQL.getPageContext());
            aVar.tD();
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
                if (this.gxt != null) {
                    this.gxt.ac(6, com.baidu.tieba.j.a.g(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void byl() {
        try {
            if (this.mCamera != null) {
                if (this.gQS == null) {
                    this.gQS = this.mCamera.getParameters();
                }
                if ("off".equals(this.gQS.getFlashMode())) {
                    this.gQS.setFlashMode("torch");
                } else {
                    this.gQS.setFlashMode("off");
                }
                this.mCamera.setParameters(this.gQS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxt != null) {
                this.gxt.ac(7, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    public boolean bym() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.gQS == null) {
                this.gQS = this.mCamera.getParameters();
            }
            return !"off".equals(this.gQS.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxt != null) {
                this.gxt.ac(7, com.baidu.tieba.j.a.g(e));
                return false;
            }
            return false;
        }
    }

    public void byn() {
        if (this.gQU != null && (this.gQU instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.gQU;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bxW();
            this.gQR = this.gQR == 0 ? 1 : 0;
            mZ(this.gQR == 1);
            gLVideoPreviewView.bxX();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.gQU != null && (this.gQU instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.gQU).j(this.mCamera);
            releaseCamera();
            this.gQR = this.gQR == 0 ? 1 : 0;
            mZ(this.gQR == 1);
            startPreview();
        }
    }

    public boolean byo() {
        return this.gQR == 1;
    }

    private void byp() {
        this.cSN = 720;
        this.cSO = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byq() {
        if (this.gQO != null && this.gQN != null && this.gQN.getParent() != null) {
            this.gQO.removeView(this.gQN);
        }
    }

    private void bP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gQP.contains("auto")) {
                this.gQS = this.mCamera.getParameters();
                this.gQS.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gQS);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxt != null) {
                this.gxt.ac(9, com.baidu.tieba.j.a.g(e));
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
        if (this.gQU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gQU).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gQU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gQU).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gQU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gQU).setSticker(stickerItem);
        }
    }

    public void onResume() {
        mZ(this.gQR == 1);
        if (this.gQU != null && (this.gQU instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.gQU).onResume();
        }
        if (this.gQU != null && (this.gQU instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.gQU).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bxR()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.gQT.j(this.mCamera);
        if (this.gQU != null && (this.gQU instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.gQU).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gQZ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.gQr = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.gQT instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.gQT != null) {
                        h.this.gQT.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.gQT.a(aVar);
        }
    }

    public boolean bya() {
        return this.mCameraId == 0;
    }
}
