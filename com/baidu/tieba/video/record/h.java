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
    private int cTU;
    private int cTV;
    private int dnv;
    protected String gMv;
    private RecordVideoActivity gRP;
    private Bitmap gRQ;
    private a gRR;
    private FrameLayout gRS;
    private List<String> gRT;
    protected boolean gRU;
    private g gRX;
    private SurfaceView gRY;
    protected List<String> gRZ;
    private GLVideoPreviewView.a gRv;
    private b gSa;
    private com.baidu.tieba.video.record.b gSb;
    private GLVideoPreviewView.a gSc;
    private c gSd;
    private com.baidu.tieba.j.h gyx;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int gRV = 0;
    private Camera.Parameters gRW = null;

    /* loaded from: classes2.dex */
    public interface b {
        void byp();
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
            this.gyx = kVar.aSb();
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
                        if (h.this.gRP != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.gRP, d.k.disallow_camera_permission);
                            if (h.this.gyx != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.gRP.getResources().getString(d.k.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gyx.ac(1, string);
                            }
                            h.this.gRP.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.gRP != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.gRP, d.k.disallow_audio_record_permission);
                            if (h.this.gyx != null) {
                                h.this.gyx.ac(2, h.this.gRP.getResources().getString(d.k.disallow_audio_record_permission));
                            }
                            h.this.gRP.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gSc = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void mZ(final boolean z) {
                if (h.this.gRv != null) {
                    com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.gRv.mZ(z);
                        }
                    });
                }
            }
        };
        this.gRP = recordVideoActivity;
        byn();
        this.gRQ = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dnv = displayMetrics.heightPixels;
        this.gRS = this.gRP.byH();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.gRY = gLVideoPreviewView;
            this.gRX = gLVideoPreviewView;
            ((GLVideoPreviewView) this.gRY).setFaceIdentifyStateListener(this.gSc);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.gRY = videoPreviewView;
            this.gRX = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.byH() != null) {
            recordVideoActivity.byH().addView(this.gRY, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gRX.g(this.mCamera);
    }

    public void startRecord() {
        this.gRX.h(this.mCamera);
    }

    public void stopRecord() {
        this.gRX.i(this.mCamera);
    }

    public g bya() {
        return this.gRX;
    }

    public String byb() {
        if (this.gRZ == null) {
            this.gRZ = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gKJ);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gKJ + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gRZ.add(str);
        return str;
    }

    public void byc() {
        if (this.gRZ != null && this.gRZ.size() != 0) {
            String remove = this.gRZ.remove(this.gRZ.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String byd() {
        File file = new File(com.baidu.tieba.video.b.gKJ);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gMv = com.baidu.tieba.video.b.gKJ + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gMv;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.gSa != null && motionEvent.getAction() == 0) {
            this.gSa.byp();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.byo();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.gSa = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dnv && x >= com.baidu.adp.lib.util.l.e(this.gRP, d.e.ds60)) {
                    int width = this.gRQ.getWidth();
                    int height = this.gRQ.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dnv - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gRS == null) {
                            this.gRS = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gRS.getChildCount()) {
                                if (this.gRR != this.gRS.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gRS.removeViewAt(i);
                                }
                            }
                        }
                        this.gRR = new a(this.gRP, clamp - (width / 2), clamp2 - (height / 2), this.gRQ);
                        this.gRS.addView(this.gRR, new ViewGroup.LayoutParams(-2, -2));
                        bP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.byo();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bye() {
        int i;
        int i2;
        if (this.mCamera == null && this.gRP != null) {
            this.gRP.finish();
            return;
        }
        int af = com.baidu.adp.lib.util.l.af(this.gRP.getPageContext().getPageActivity());
        int bB = bB(this.gRP.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bB * 1.0f) / af)));
        if (a2 != null) {
            this.cTU = a2.width;
            this.cTV = a2.height;
            this.gRW.setPreviewSize(this.cTU, this.cTV);
            if (this.gRX != null) {
                this.gRX.setPreviewSize(this.cTU, this.cTV);
            }
        }
        this.gRW.setPreviewFormat(17);
        byf();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.gRP, this.mCameraId));
        this.gRT = this.gRW.getSupportedFocusModes();
        if (this.gRT != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gRT.contains("continuous-picture")) {
                this.gRW.setFocusMode("continuous-picture");
            } else if (this.gRT.contains("continuous-video")) {
                this.gRW.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gRW);
        if (this.gRP != null && this.gRP.byH() != null) {
            float f = (af * 1.0f) / bB;
            float f2 = (this.cTV * 1.0f) / this.cTU;
            if (f > f2) {
                i = af;
                i2 = (int) (af / f2);
            } else {
                i = (int) (bB * f2);
                i2 = bB;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gRY.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gRY.setLayoutParams(layoutParams);
            this.gRY.invalidate();
            if (this.gSd != null) {
                this.gSd.bQ(layoutParams.width, layoutParams.height);
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

    private void byf() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gRW.getSupportedPreviewFpsRange()) {
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
        this.gRW.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void na(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.mX(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.mX(z)) {
                    byi();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                byh();
                this.gSb = new com.baidu.tieba.video.record.b(this.mCamera);
                this.gRU = z;
            } else {
                byi();
            }
        } catch (Exception e) {
            e.printStackTrace();
            byi();
            if (this.gyx != null) {
                this.gyx.ac(8, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b byg() {
        return this.gSb;
    }

    private void byh() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gRW = this.mCamera.getParameters();
            bye();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.g(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void byi() {
        if (this.gRP != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gRP.getPageContext().getPageActivity());
            aVar.ca(d.k.video_quit_confirm);
            aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gRP != null) {
                        h.this.gRP.finish();
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
            aVar.b(this.gRP.getPageContext());
            aVar.tC();
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
                if (this.gyx != null) {
                    this.gyx.ac(6, com.baidu.tieba.j.a.g(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void byj() {
        try {
            if (this.mCamera != null) {
                if (this.gRW == null) {
                    this.gRW = this.mCamera.getParameters();
                }
                if ("off".equals(this.gRW.getFlashMode())) {
                    this.gRW.setFlashMode("torch");
                } else {
                    this.gRW.setFlashMode("off");
                }
                this.mCamera.setParameters(this.gRW);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gyx != null) {
                this.gyx.ac(7, com.baidu.tieba.j.a.g(e));
            }
        }
    }

    public boolean byk() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.gRW == null) {
                this.gRW = this.mCamera.getParameters();
            }
            return !"off".equals(this.gRW.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gyx != null) {
                this.gyx.ac(7, com.baidu.tieba.j.a.g(e));
                return false;
            }
            return false;
        }
    }

    public void byl() {
        if (this.gRY != null && (this.gRY instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.gRY;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bxU();
            this.gRV = this.gRV == 0 ? 1 : 0;
            na(this.gRV == 1);
            gLVideoPreviewView.bxV();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.gRY != null && (this.gRY instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.gRY).j(this.mCamera);
            releaseCamera();
            this.gRV = this.gRV == 0 ? 1 : 0;
            na(this.gRV == 1);
            startPreview();
        }
    }

    public boolean bym() {
        return this.gRV == 1;
    }

    private void byn() {
        this.cTU = 720;
        this.cTV = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byo() {
        if (this.gRS != null && this.gRR != null && this.gRR.getParent() != null) {
            this.gRS.removeView(this.gRR);
        }
    }

    private void bP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gRT.contains("auto")) {
                this.gRW = this.mCamera.getParameters();
                this.gRW.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gRW);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gyx != null) {
                this.gyx.ac(9, com.baidu.tieba.j.a.g(e));
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
        if (this.gRY instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gRY).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gRY instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gRY).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gRY instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.gRY).setSticker(stickerItem);
        }
    }

    public void onResume() {
        na(this.gRV == 1);
        if (this.gRY != null && (this.gRY instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.gRY).onResume();
        }
        if (this.gRY != null && (this.gRY instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.gRY).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bxP()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.gRX.j(this.mCamera);
        if (this.gRY != null && (this.gRY instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.gRY).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gSd = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.gRv = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.gRX instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.gRX != null) {
                        h.this.gRX.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.gRX.a(aVar);
        }
    }

    public boolean bxY() {
        return this.mCameraId == 0;
    }
}
