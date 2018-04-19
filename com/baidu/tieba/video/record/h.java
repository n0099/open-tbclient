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
    private int cSQ;
    private int cSR;
    private int dmq;
    protected String gLv;
    private RecordVideoActivity gQO;
    private Bitmap gQP;
    private a gQQ;
    private FrameLayout gQR;
    private List<String> gQS;
    protected boolean gQT;
    private g gQW;
    private SurfaceView gQX;
    protected List<String> gQY;
    private b gQZ;
    private GLVideoPreviewView.a gQu;
    private com.baidu.tieba.video.record.b gRa;
    private GLVideoPreviewView.a gRb;
    private c gRc;
    private com.baidu.tieba.j.h gxw;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int gQU = 0;
    private Camera.Parameters gQV = null;

    /* loaded from: classes2.dex */
    public interface b {
        void byr();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bR(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
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
                        if (h.this.gQO != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.gQO, d.k.disallow_camera_permission);
                            if (h.this.gxw != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.gQO.getResources().getString(d.k.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gxw.ac(1, string);
                            }
                            h.this.gQO.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.gQO != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.gQO, d.k.disallow_audio_record_permission);
                            if (h.this.gxw != null) {
                                h.this.gxw.ac(2, h.this.gQO.getResources().getString(d.k.disallow_audio_record_permission));
                            }
                            h.this.gQO.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gRb = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void mY(final boolean z) {
                if (h.this.gQu != null) {
                    com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.gQu.mY(z);
                        }
                    });
                }
            }
        };
        this.gQO = recordVideoActivity;
        byp();
        this.gQP = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dmq = displayMetrics.heightPixels;
        this.gQR = this.gQO.byJ();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.gQX = gLVideoPreviewView;
            this.gQW = gLVideoPreviewView;
            ((GLVideoPreviewView) this.gQX).setFaceIdentifyStateListener(this.gRb);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.gQX = videoPreviewView;
            this.gQW = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.byJ() != null) {
            recordVideoActivity.byJ().addView(this.gQX, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gQW.g(this.mCamera);
    }

    public void startRecord() {
        this.gQW.h(this.mCamera);
    }

    public void stopRecord() {
        this.gQW.i(this.mCamera);
    }

    public g byc() {
        return this.gQW;
    }

    public String byd() {
        if (this.gQY == null) {
            this.gQY = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gJJ);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gJJ + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gQY.add(str);
        return str;
    }

    public void bye() {
        if (this.gQY != null && this.gQY.size() != 0) {
            String remove = this.gQY.remove(this.gQY.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String byf() {
        File file = new File(com.baidu.tieba.video.b.gJJ);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gLv = com.baidu.tieba.video.b.gJJ + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gLv;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.gQZ != null && motionEvent.getAction() == 0) {
            this.gQZ.byr();
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
        this.gQZ = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dmq && x >= com.baidu.adp.lib.util.l.e(this.gQO, d.e.ds60)) {
                    int width = this.gQP.getWidth();
                    int height = this.gQP.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dmq - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gQR == null) {
                            this.gQR = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gQR.getChildCount()) {
                                if (this.gQQ != this.gQR.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gQR.removeViewAt(i);
                                }
                            }
                        }
                        this.gQQ = new a(this.gQO, clamp - (width / 2), clamp2 - (height / 2), this.gQP);
                        this.gQR.addView(this.gQQ, new ViewGroup.LayoutParams(-2, -2));
                        bQ(clamp, clamp2);
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
        if (this.mCamera == null && this.gQO != null) {
            this.gQO.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.gQO.getPageContext().getPageActivity());
        int bB = bB(this.gQO.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bB * 1.0f) / af)));
        if (a2 != null) {
            this.cSQ = a2.width;
            this.cSR = a2.height;
            this.gQV.setPreviewSize(this.cSQ, this.cSR);
            if (this.gQW != null) {
                this.gQW.setPreviewSize(this.cSQ, this.cSR);
            }
        }
        this.gQV.setPreviewFormat(17);
        byh();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.gQO, this.mCameraId));
        this.gQS = this.gQV.getSupportedFocusModes();
        if (this.gQS != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gQS.contains("continuous-picture")) {
                this.gQV.setFocusMode("continuous-picture");
            } else if (this.gQS.contains("continuous-video")) {
                this.gQV.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gQV);
        if (this.gQO != null && this.gQO.byJ() != null) {
            float f = (af * 1.0f) / bB;
            float f2 = (this.cSR * 1.0f) / this.cSQ;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (bB * f2);
                i2 = bB;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gQX.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gQX.setLayoutParams(layoutParams);
            this.gQX.invalidate();
            if (this.gRc != null) {
                this.gRc.bR(layoutParams.width, layoutParams.height);
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
        for (int[] iArr3 : this.gQV.getSupportedPreviewFpsRange()) {
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
        this.gQV.setPreviewFpsRange(iArr2[0], iArr2[1]);
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
                this.gRa = new com.baidu.tieba.video.record.b(this.mCamera);
                this.gQT = z;
            } else {
                byk();
            }
        } catch (Exception e) {
            e.printStackTrace();
            byk();
            if (this.gxw != null) {
                this.gxw.ac(8, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b byi() {
        return this.gRa;
    }

    private void byj() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gQV = this.mCamera.getParameters();
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
        if (this.gQO != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gQO.getPageContext().getPageActivity());
            aVar.bZ(d.k.video_quit_confirm);
            aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gQO != null) {
                        h.this.gQO.finish();
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
            aVar.b(this.gQO.getPageContext());
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
                if (this.gxw != null) {
                    this.gxw.ac(6, com.baidu.tieba.j.a.g(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void byl() {
        try {
            if (this.mCamera != null) {
                if (this.gQV == null) {
                    this.gQV = this.mCamera.getParameters();
                }
                if ("off".equals(this.gQV.getFlashMode())) {
                    this.gQV.setFlashMode("torch");
                } else {
                    this.gQV.setFlashMode("off");
                }
                this.mCamera.setParameters(this.gQV);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxw != null) {
                this.gxw.ac(7, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    public boolean bym() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.gQV == null) {
                this.gQV = this.mCamera.getParameters();
            }
            return !"off".equals(this.gQV.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxw != null) {
                this.gxw.ac(7, com.baidu.tieba.j.a.g(e));
                return false;
            }
            return false;
        }
    }

    public void byn() {
        if (this.gQX != null && (this.gQX instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.gQX;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bxW();
            this.gQU = this.gQU == 0 ? 1 : 0;
            mZ(this.gQU == 1);
            gLVideoPreviewView.bxX();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.gQX != null && (this.gQX instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.gQX).j(this.mCamera);
            releaseCamera();
            this.gQU = this.gQU == 0 ? 1 : 0;
            mZ(this.gQU == 1);
            startPreview();
        }
    }

    public boolean byo() {
        return this.gQU == 1;
    }

    private void byp() {
        this.cSQ = 720;
        this.cSR = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byq() {
        if (this.gQR != null && this.gQQ != null && this.gQQ.getParent() != null) {
            this.gQR.removeView(this.gQQ);
        }
    }

    private void bQ(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gQS.contains("auto")) {
                this.gQV = this.mCamera.getParameters();
                this.gQV.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gQV);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gxw != null) {
                this.gxw.ac(9, com.baidu.tieba.j.a.g(e));
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
        if (this.gQX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gQX).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gQX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gQX).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gQX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gQX).setSticker(stickerItem);
        }
    }

    public void onResume() {
        mZ(this.gQU == 1);
        if (this.gQX != null && (this.gQX instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.gQX).onResume();
        }
        if (this.gQX != null && (this.gQX instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.gQX).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bxR()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.gQW.j(this.mCamera);
        if (this.gQX != null && (this.gQX instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.gQX).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gRc = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.gQu = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.gQW instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.gQW != null) {
                        h.this.gQW.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.gQW.a(aVar);
        }
    }

    public boolean bya() {
        return this.mCameraId == 0;
    }
}
