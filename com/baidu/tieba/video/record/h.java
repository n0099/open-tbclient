package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.net.Uri;
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
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private int dCi;
    private int dCj;
    protected String hEE;
    private RecordVideoActivity hJV;
    private Bitmap hJW;
    private a hJX;
    private FrameLayout hJY;
    private List<String> hJZ;
    private GLVideoPreviewView.a hJz;
    protected boolean hKa;
    private g hKd;
    private SurfaceView hKe;
    protected List<String> hKf;
    private b hKg;
    private com.baidu.tieba.video.record.b hKh;
    private GLVideoPreviewView.a hKi;
    private c hKj;
    private com.baidu.tieba.j.h hpD;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenHeight;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hKb = 0;
    private Camera.Parameters hKc = null;

    /* loaded from: classes5.dex */
    public interface b {
        void bLe();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void bZ(int i, int i2);
    }

    public void U(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.bg(false);
        aVar.da(e.j.request_permission_default_title);
        aVar.db(e.j.request_permission_camera);
        aVar.a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.video.record.h.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                activity.finish();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(com.baidu.adp.base.i.aK(activity));
        aVar.BF();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
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
                        if (h.this.hJV != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.U(h.this.hJV);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hJV, e.j.disallow_camera_permission);
                            if (h.this.hpD != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hJV.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.hpD.Y(1, string);
                            }
                            h.this.hJV.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hJV != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hJV, e.j.disallow_audio_record_permission);
                            if (h.this.hpD != null) {
                                h.this.hpD.Y(2, h.this.hJV.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hJV.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hKi = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void oh(final boolean z) {
                if (h.this.hJz != null) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hJz.oh(z);
                        }
                    });
                }
            }
        };
        this.hJV = recordVideoActivity;
        bLc();
        this.hJW = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.hJY = this.hJV.bLu();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hKe = gLVideoPreviewView;
            this.hKd = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hKe).setFaceIdentifyStateListener(this.hKi);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hKe = videoPreviewView;
            this.hKd = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bLu() != null) {
            recordVideoActivity.bLu().addView(this.hKe, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hKd.e(this.mCamera);
    }

    public void startRecord() {
        this.hKd.f(this.mCamera);
    }

    public void stopRecord() {
        this.hKd.g(this.mCamera);
    }

    public g bKP() {
        return this.hKd;
    }

    public String bKQ() {
        if (this.hKf == null) {
            this.hKf = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hCT);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hCT + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hKf.add(str);
        return str;
    }

    public void bKR() {
        if (this.hKf != null && this.hKf.size() != 0) {
            String remove = this.hKf.remove(this.hKf.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bKS() {
        File file = new File(com.baidu.tieba.video.c.hCT);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hEE = com.baidu.tieba.video.c.hCT + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hEE;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hKg != null && motionEvent.getAction() == 0) {
            this.hKg.bLe();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bLd();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hKg = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.screenHeight && x >= com.baidu.adp.lib.util.l.h(this.hJV, e.C0210e.ds60)) {
                    int width = this.hJW.getWidth();
                    int height = this.hJW.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.screenHeight - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hJY == null) {
                            this.hJY = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hJY.getChildCount()) {
                                if (this.hJX != this.hJY.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hJY.removeViewAt(i);
                                }
                            }
                        }
                        this.hJX = new a(this.hJV, clamp - (width / 2), clamp2 - (height / 2), this.hJW);
                        this.hJY.addView(this.hJX, new ViewGroup.LayoutParams(-2, -2));
                        bY(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bLd();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bKT() {
        int i;
        int i2;
        if (this.mCamera == null && this.hJV != null) {
            this.hJV.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hJV.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hJV.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.dCi = a2.width;
            this.dCj = a2.height;
            this.hKc.setPreviewSize(this.dCi, this.dCj);
            if (this.hKd != null) {
                this.hKd.setPreviewSize(this.dCi, this.dCj);
            }
        }
        this.hKc.setPreviewFormat(17);
        bKU();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.hJV, this.mCameraId));
        this.hJZ = this.hKc.getSupportedFocusModes();
        if (this.hJZ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hJZ.contains("continuous-picture")) {
                this.hKc.setFocusMode("continuous-picture");
            } else if (this.hJZ.contains("continuous-video")) {
                this.hKc.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hKc);
        if (this.hJV != null && this.hJV.bLu() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.dCj * 1.0f) / this.dCi;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hKe.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hKe.setLayoutParams(layoutParams);
            this.hKe.invalidate();
            if (this.hKj != null) {
                this.hKj.bZ(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.l.aQ(context);
        }
        return i;
    }

    private void bKU() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hKc.getSupportedPreviewFpsRange()) {
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
        this.hKc.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void oi(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.oe(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.oe(z)) {
                    bKX();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.of(z);
            if (-1 != this.mCameraId) {
                bKW();
                this.hKh = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hKa = z;
            } else {
                bKX();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bKX();
            if (this.hpD != null) {
                this.hpD.Y(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bKV() {
        return this.hKh;
    }

    private void bKW() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hKc = this.mCamera.getParameters();
            bKT();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bKX() {
        if (this.hJV != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hJV.getPageContext().getPageActivity());
            aVar.db(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hJV != null) {
                        h.this.hJV.finish();
                    }
                }
            });
            aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.bf(true);
            aVar.b(this.hJV.getPageContext());
            aVar.BF();
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
                if (this.hpD != null) {
                    this.hpD.Y(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bKY() {
        try {
            if (this.mCamera != null) {
                if (this.hKc == null) {
                    this.hKc = this.mCamera.getParameters();
                }
                if (ARCameraAttr.FlashType.FLASH_OFF.equals(this.hKc.getFlashMode())) {
                    this.hKc.setFlashMode("torch");
                } else {
                    this.hKc.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                }
                this.mCamera.setParameters(this.hKc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hpD != null) {
                this.hpD.Y(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean bKZ() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hKc == null) {
                this.hKc = this.mCamera.getParameters();
            }
            return !ARCameraAttr.FlashType.FLASH_OFF.equals(this.hKc.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hpD != null) {
                this.hpD.Y(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void bLa() {
        if (this.hKe != null && (this.hKe instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hKe;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bKI();
            this.hKb = this.hKb == 0 ? 1 : 0;
            oi(this.hKb == 1);
            gLVideoPreviewView.bKJ();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hKe != null && (this.hKe instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hKe).h(this.mCamera);
            releaseCamera();
            this.hKb = this.hKb == 0 ? 1 : 0;
            oi(this.hKb == 1);
            startPreview();
        }
    }

    public boolean bLb() {
        return this.hKb == 1;
    }

    private void bLc() {
        this.dCi = 720;
        this.dCj = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLd() {
        if (this.hJY != null && this.hJX != null && this.hJX.getParent() != null) {
            this.hJY.removeView(this.hJX);
        }
    }

    private void bY(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hJZ.contains("auto")) {
                this.hKc = this.mCamera.getParameters();
                this.hKc.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hKc);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hpD != null) {
                this.hpD.Y(9, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
        if (this.hKe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hKe).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hKe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hKe).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hKe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hKe).setSticker(stickerItem);
        }
    }

    public void onResume() {
        oi(this.hKb == 1);
        if (this.hKe != null && (this.hKe instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hKe).onResume();
        }
        if (this.hKe != null && (this.hKe instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hKe).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bKD()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hKd.h(this.mCamera);
        if (this.hKe != null && (this.hKe instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hKe).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hKj = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hJz = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hKd instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hKd != null) {
                        h.this.hKd.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hKd.a(aVar);
        }
    }

    public boolean bKN() {
        return this.mCameraId == 0;
    }
}
