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
    private int dsV;
    private int dsW;
    private com.baidu.tieba.j.h hfy;
    protected String huh;
    private a hzA;
    private FrameLayout hzB;
    private List<String> hzC;
    protected boolean hzD;
    private g hzG;
    private SurfaceView hzH;
    protected List<String> hzI;
    private b hzJ;
    private com.baidu.tieba.video.record.b hzK;
    private GLVideoPreviewView.a hzL;
    private c hzM;
    private GLVideoPreviewView.a hzc;
    private RecordVideoActivity hzy;
    private Bitmap hzz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenHeight;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hzE = 0;
    private Camera.Parameters hzF = null;

    /* loaded from: classes5.dex */
    public interface b {
        void bIk();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void ca(int i, int i2);
    }

    public void R(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.bf(false);
        aVar.cM(e.j.request_permission_default_title);
        aVar.cN(e.j.request_permission_camera);
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
        aVar.AB();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
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
                        if (h.this.hzy != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.R(h.this.hzy);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hzy, e.j.disallow_camera_permission);
                            if (h.this.hfy != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hzy.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.hfy.X(1, string);
                            }
                            h.this.hzy.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hzy != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hzy, e.j.disallow_audio_record_permission);
                            if (h.this.hfy != null) {
                                h.this.hfy.X(2, h.this.hzy.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hzy.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hzL = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void oc(final boolean z) {
                if (h.this.hzc != null) {
                    com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hzc.oc(z);
                        }
                    });
                }
            }
        };
        this.hzy = recordVideoActivity;
        bIi();
        this.hzz = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.hzB = this.hzy.bIA();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hzH = gLVideoPreviewView;
            this.hzG = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hzH).setFaceIdentifyStateListener(this.hzL);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hzH = videoPreviewView;
            this.hzG = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bIA() != null) {
            recordVideoActivity.bIA().addView(this.hzH, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hzG.e(this.mCamera);
    }

    public void startRecord() {
        this.hzG.f(this.mCamera);
    }

    public void stopRecord() {
        this.hzG.g(this.mCamera);
    }

    public g bHV() {
        return this.hzG;
    }

    public String bHW() {
        if (this.hzI == null) {
            this.hzI = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hsw);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hsw + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hzI.add(str);
        return str;
    }

    public void bHX() {
        if (this.hzI != null && this.hzI.size() != 0) {
            String remove = this.hzI.remove(this.hzI.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bHY() {
        File file = new File(com.baidu.tieba.video.c.hsw);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.huh = com.baidu.tieba.video.c.hsw + "f_" + System.currentTimeMillis() + ".mp4";
        return this.huh;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hzJ != null && motionEvent.getAction() == 0) {
            this.hzJ.bIk();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bIj();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hzJ = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.screenHeight && x >= com.baidu.adp.lib.util.l.h(this.hzy, e.C0200e.ds60)) {
                    int width = this.hzz.getWidth();
                    int height = this.hzz.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.screenHeight - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hzB == null) {
                            this.hzB = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hzB.getChildCount()) {
                                if (this.hzA != this.hzB.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hzB.removeViewAt(i);
                                }
                            }
                        }
                        this.hzA = new a(this.hzy, clamp - (width / 2), clamp2 - (height / 2), this.hzz);
                        this.hzB.addView(this.hzA, new ViewGroup.LayoutParams(-2, -2));
                        bZ(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bIj();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bHZ() {
        int i;
        int i2;
        if (this.mCamera == null && this.hzy != null) {
            this.hzy.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hzy.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hzy.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.dsV = a2.width;
            this.dsW = a2.height;
            this.hzF.setPreviewSize(this.dsV, this.dsW);
            if (this.hzG != null) {
                this.hzG.setPreviewSize(this.dsV, this.dsW);
            }
        }
        this.hzF.setPreviewFormat(17);
        bIa();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.hzy, this.mCameraId));
        this.hzC = this.hzF.getSupportedFocusModes();
        if (this.hzC != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hzC.contains("continuous-picture")) {
                this.hzF.setFocusMode("continuous-picture");
            } else if (this.hzC.contains("continuous-video")) {
                this.hzF.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hzF);
        if (this.hzy != null && this.hzy.bIA() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.dsW * 1.0f) / this.dsV;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hzH.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hzH.setLayoutParams(layoutParams);
            this.hzH.invalidate();
            if (this.hzM != null) {
                this.hzM.ca(layoutParams.width, layoutParams.height);
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

    private void bIa() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hzF.getSupportedPreviewFpsRange()) {
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
        this.hzF.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void od(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nZ(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nZ(z)) {
                    bId();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.oa(z);
            if (-1 != this.mCameraId) {
                bIc();
                this.hzK = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hzD = z;
            } else {
                bId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bId();
            if (this.hfy != null) {
                this.hfy.X(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bIb() {
        return this.hzK;
    }

    private void bIc() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hzF = this.mCamera.getParameters();
            bHZ();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bId() {
        if (this.hzy != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hzy.getPageContext().getPageActivity());
            aVar.cN(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hzy != null) {
                        h.this.hzy.finish();
                    }
                }
            });
            aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.be(true);
            aVar.b(this.hzy.getPageContext());
            aVar.AB();
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
                if (this.hfy != null) {
                    this.hfy.X(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bIe() {
        try {
            if (this.mCamera != null) {
                if (this.hzF == null) {
                    this.hzF = this.mCamera.getParameters();
                }
                if (ARCameraAttr.FlashType.FLASH_OFF.equals(this.hzF.getFlashMode())) {
                    this.hzF.setFlashMode("torch");
                } else {
                    this.hzF.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                }
                this.mCamera.setParameters(this.hzF);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hfy != null) {
                this.hfy.X(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean bIf() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hzF == null) {
                this.hzF = this.mCamera.getParameters();
            }
            return !ARCameraAttr.FlashType.FLASH_OFF.equals(this.hzF.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hfy != null) {
                this.hfy.X(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void bIg() {
        if (this.hzH != null && (this.hzH instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hzH;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bHO();
            this.hzE = this.hzE == 0 ? 1 : 0;
            od(this.hzE == 1);
            gLVideoPreviewView.bHP();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hzH != null && (this.hzH instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hzH).h(this.mCamera);
            releaseCamera();
            this.hzE = this.hzE == 0 ? 1 : 0;
            od(this.hzE == 1);
            startPreview();
        }
    }

    public boolean bIh() {
        return this.hzE == 1;
    }

    private void bIi() {
        this.dsV = 720;
        this.dsW = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        if (this.hzB != null && this.hzA != null && this.hzA.getParent() != null) {
            this.hzB.removeView(this.hzA);
        }
    }

    private void bZ(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hzC.contains("auto")) {
                this.hzF = this.mCamera.getParameters();
                this.hzF.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hzF);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hfy != null) {
                this.hfy.X(9, com.baidu.tieba.j.a.o(e));
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
        if (this.hzH instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hzH).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hzH instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hzH).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hzH instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hzH).setSticker(stickerItem);
        }
    }

    public void onResume() {
        od(this.hzE == 1);
        if (this.hzH != null && (this.hzH instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hzH).onResume();
        }
        if (this.hzH != null && (this.hzH instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hzH).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bHJ()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hzG.h(this.mCamera);
        if (this.hzH != null && (this.hzH instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hzH).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hzM = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hzc = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hzG instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hzG != null) {
                        h.this.hzG.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hzG.a(aVar);
        }
    }

    public boolean bHT() {
        return this.mCameraId == 0;
    }
}
