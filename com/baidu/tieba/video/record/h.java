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
    private int dzv;
    private int dzw;
    protected String hBt;
    private RecordVideoActivity hGK;
    private Bitmap hGL;
    private a hGM;
    private FrameLayout hGN;
    private List<String> hGO;
    protected boolean hGP;
    private g hGS;
    private SurfaceView hGT;
    protected List<String> hGU;
    private b hGV;
    private com.baidu.tieba.video.record.b hGW;
    private GLVideoPreviewView.a hGX;
    private c hGY;
    private GLVideoPreviewView.a hGo;
    private com.baidu.tieba.j.h hms;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenHeight;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hGQ = 0;
    private Camera.Parameters hGR = null;

    /* loaded from: classes5.dex */
    public interface b {
        void bKo();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void bY(int i, int i2);
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
            this.hms = lVar.bcL();
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
                        if (h.this.hGK != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.U(h.this.hGK);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hGK, e.j.disallow_camera_permission);
                            if (h.this.hms != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hGK.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.hms.X(1, string);
                            }
                            h.this.hGK.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hGK != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hGK, e.j.disallow_audio_record_permission);
                            if (h.this.hms != null) {
                                h.this.hms.X(2, h.this.hGK.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hGK.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hGX = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void oe(final boolean z) {
                if (h.this.hGo != null) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hGo.oe(z);
                        }
                    });
                }
            }
        };
        this.hGK = recordVideoActivity;
        bKm();
        this.hGL = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.hGN = this.hGK.bKE();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hGT = gLVideoPreviewView;
            this.hGS = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hGT).setFaceIdentifyStateListener(this.hGX);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hGT = videoPreviewView;
            this.hGS = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bKE() != null) {
            recordVideoActivity.bKE().addView(this.hGT, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hGS.e(this.mCamera);
    }

    public void startRecord() {
        this.hGS.f(this.mCamera);
    }

    public void stopRecord() {
        this.hGS.g(this.mCamera);
    }

    public g bJZ() {
        return this.hGS;
    }

    public String bKa() {
        if (this.hGU == null) {
            this.hGU = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hzI);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hzI + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hGU.add(str);
        return str;
    }

    public void bKb() {
        if (this.hGU != null && this.hGU.size() != 0) {
            String remove = this.hGU.remove(this.hGU.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bKc() {
        File file = new File(com.baidu.tieba.video.c.hzI);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hBt = com.baidu.tieba.video.c.hzI + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hBt;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hGV != null && motionEvent.getAction() == 0) {
            this.hGV.bKo();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bKn();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hGV = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.screenHeight && x >= com.baidu.adp.lib.util.l.h(this.hGK, e.C0210e.ds60)) {
                    int width = this.hGL.getWidth();
                    int height = this.hGL.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.screenHeight - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hGN == null) {
                            this.hGN = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hGN.getChildCount()) {
                                if (this.hGM != this.hGN.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hGN.removeViewAt(i);
                                }
                            }
                        }
                        this.hGM = new a(this.hGK, clamp - (width / 2), clamp2 - (height / 2), this.hGL);
                        this.hGN.addView(this.hGM, new ViewGroup.LayoutParams(-2, -2));
                        bX(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bKn();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bKd() {
        int i;
        int i2;
        if (this.mCamera == null && this.hGK != null) {
            this.hGK.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hGK.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hGK.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.dzv = a2.width;
            this.dzw = a2.height;
            this.hGR.setPreviewSize(this.dzv, this.dzw);
            if (this.hGS != null) {
                this.hGS.setPreviewSize(this.dzv, this.dzw);
            }
        }
        this.hGR.setPreviewFormat(17);
        bKe();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.hGK, this.mCameraId));
        this.hGO = this.hGR.getSupportedFocusModes();
        if (this.hGO != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hGO.contains("continuous-picture")) {
                this.hGR.setFocusMode("continuous-picture");
            } else if (this.hGO.contains("continuous-video")) {
                this.hGR.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hGR);
        if (this.hGK != null && this.hGK.bKE() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.dzw * 1.0f) / this.dzv;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hGT.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hGT.setLayoutParams(layoutParams);
            this.hGT.invalidate();
            if (this.hGY != null) {
                this.hGY.bY(layoutParams.width, layoutParams.height);
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

    private void bKe() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hGR.getSupportedPreviewFpsRange()) {
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
        this.hGR.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void of(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.ob(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.ob(z)) {
                    bKh();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.oc(z);
            if (-1 != this.mCameraId) {
                bKg();
                this.hGW = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hGP = z;
            } else {
                bKh();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bKh();
            if (this.hms != null) {
                this.hms.X(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bKf() {
        return this.hGW;
    }

    private void bKg() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hGR = this.mCamera.getParameters();
            bKd();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bKh() {
        if (this.hGK != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGK.getPageContext().getPageActivity());
            aVar.db(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hGK != null) {
                        h.this.hGK.finish();
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
            aVar.b(this.hGK.getPageContext());
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
                if (this.hms != null) {
                    this.hms.X(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bKi() {
        try {
            if (this.mCamera != null) {
                if (this.hGR == null) {
                    this.hGR = this.mCamera.getParameters();
                }
                if (ARCameraAttr.FlashType.FLASH_OFF.equals(this.hGR.getFlashMode())) {
                    this.hGR.setFlashMode("torch");
                } else {
                    this.hGR.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                }
                this.mCamera.setParameters(this.hGR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hms != null) {
                this.hms.X(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean bKj() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hGR == null) {
                this.hGR = this.mCamera.getParameters();
            }
            return !ARCameraAttr.FlashType.FLASH_OFF.equals(this.hGR.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hms != null) {
                this.hms.X(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void bKk() {
        if (this.hGT != null && (this.hGT instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hGT;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bJS();
            this.hGQ = this.hGQ == 0 ? 1 : 0;
            of(this.hGQ == 1);
            gLVideoPreviewView.bJT();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hGT != null && (this.hGT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hGT).h(this.mCamera);
            releaseCamera();
            this.hGQ = this.hGQ == 0 ? 1 : 0;
            of(this.hGQ == 1);
            startPreview();
        }
    }

    public boolean bKl() {
        return this.hGQ == 1;
    }

    private void bKm() {
        this.dzv = 720;
        this.dzw = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKn() {
        if (this.hGN != null && this.hGM != null && this.hGM.getParent() != null) {
            this.hGN.removeView(this.hGM);
        }
    }

    private void bX(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hGO.contains("auto")) {
                this.hGR = this.mCamera.getParameters();
                this.hGR.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hGR);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hms != null) {
                this.hms.X(9, com.baidu.tieba.j.a.o(e));
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
        if (this.hGT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hGT).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hGT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hGT).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hGT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hGT).setSticker(stickerItem);
        }
    }

    public void onResume() {
        of(this.hGQ == 1);
        if (this.hGT != null && (this.hGT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hGT).onResume();
        }
        if (this.hGT != null && (this.hGT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hGT).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bJN()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hGS.h(this.mCamera);
        if (this.hGT != null && (this.hGT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hGT).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hGY = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hGo = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hGS instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hGS != null) {
                        h.this.hGS.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hGS.a(aVar);
        }
    }

    public boolean bJX() {
        return this.mCameraId == 0;
    }
}
