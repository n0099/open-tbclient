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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class h {
    private SurfaceView btL;
    private int cCL;
    private com.baidu.tieba.k.h kTM;
    protected String liB;
    private RecordVideoActivity lnL;
    private Bitmap lnM;
    private a lnN;
    private FrameLayout lnO;
    private List<String> lnP;
    private g lnS;
    protected List<String> lnT;
    private b lnU;
    private com.baidu.tieba.video.record.b lnV;
    private GLVideoPreviewView.a lnW;
    private c lnX;
    private GLVideoPreviewView.a lnr;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int lnQ = 0;
    private Camera.Parameters lnR = null;

    /* loaded from: classes10.dex */
    public interface b {
        void dcN();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void cY(int i, int i2);
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.gF(false);
        aVar.kc(R.string.request_permission_default_title);
        aVar.kd(R.string.request_permission_camera);
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.video.record.h.3
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
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(com.baidu.adp.base.i.G(activity));
        aVar.aMS();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.kTM = lVar.crX();
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
                        if (h.this.lnL != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ah(h.this.lnL);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.lnL, (int) R.string.disallow_camera_permission);
                            if (h.this.kTM != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.lnL.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.kTM.be(1, string);
                            }
                            h.this.lnL.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.lnL != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.lnL, (int) R.string.disallow_audio_record_permission);
                            if (h.this.kTM != null) {
                                h.this.kTM.be(2, h.this.lnL.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.lnL.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lnW = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void uC(final boolean z) {
                if (h.this.lnr != null) {
                    com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.lnr.uC(z);
                        }
                    });
                }
            }
        };
        this.lnL = recordVideoActivity;
        dcL();
        this.lnM = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cCL = displayMetrics.heightPixels;
        this.lnO = this.lnL.ddd();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.btL = gLVideoPreviewView;
            this.lnS = gLVideoPreviewView;
            ((GLVideoPreviewView) this.btL).setFaceIdentifyStateListener(this.lnW);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.btL = videoPreviewView;
            this.lnS = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.ddd() != null) {
            recordVideoActivity.ddd().addView(this.btL, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.lnS.e(this.mCamera);
    }

    public void startRecord() {
        this.lnS.f(this.mCamera);
    }

    public void stopRecord() {
        this.lnS.g(this.mCamera);
    }

    public g dcy() {
        return this.lnS;
    }

    public String dcz() {
        if (this.lnT == null) {
            this.lnT = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.lgU);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.lgU + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.lnT.add(str);
        return str;
    }

    public void dcA() {
        if (this.lnT != null && this.lnT.size() != 0) {
            String remove = this.lnT.remove(this.lnT.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dcB() {
        File file = new File(com.baidu.tieba.video.c.lgU);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.liB = com.baidu.tieba.video.c.lgU + "f_" + System.currentTimeMillis() + ".mp4";
        return this.liB;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.lnU != null && motionEvent.getAction() == 0) {
            this.lnU.dcN();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dcM();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.lnU = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cCL && x >= com.baidu.adp.lib.util.l.getDimens(this.lnL, R.dimen.ds60)) {
                    int width = this.lnM.getWidth();
                    int height = this.lnM.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cCL - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.lnO == null) {
                            this.lnO = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.lnO.getChildCount()) {
                                if (this.lnN != this.lnO.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.lnO.removeViewAt(i);
                                }
                            }
                        }
                        this.lnN = new a(this.lnL, clamp - (width / 2), clamp2 - (height / 2), this.lnM);
                        this.lnO.addView(this.lnN, new ViewGroup.LayoutParams(-2, -2));
                        cX(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dcM();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dcC() {
        int i;
        int i2;
        if (this.mCamera == null && this.lnL != null) {
            this.lnL.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lnL.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.lnL.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.lnR.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.lnS != null) {
                this.lnS.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.lnR.setPreviewFormat(17);
        dcD();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.j(this.lnL, this.mCameraId));
        this.lnP = this.lnR.getSupportedFocusModes();
        if (this.lnP != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.lnP.contains("continuous-picture")) {
                this.lnR.setFocusMode("continuous-picture");
            } else if (this.lnP.contains("continuous-video")) {
                this.lnR.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.lnR);
        if (this.lnL != null && this.lnL.ddd() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.btL.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.btL.setLayoutParams(layoutParams);
            this.btL.invalidate();
            if (this.lnX != null) {
                this.lnX.cY(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int getScreenHeight(Context context) {
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
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
        }
        return i;
    }

    private void dcD() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.lnR.getSupportedPreviewFpsRange()) {
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
        this.lnR.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void uD(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.uz(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.uz(z)) {
                    dcG();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.uA(z);
            if (-1 != this.mCameraId) {
                dcF();
                this.lnV = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dcG();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dcG();
            if (this.kTM != null) {
                this.kTM.be(8, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dcE() {
        return this.lnV;
    }

    private void dcF() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.lnR = this.mCamera.getParameters();
            dcC();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.s(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dcG() {
        if (this.lnL != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lnL.getPageContext().getPageActivity());
            aVar.kd(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.lnL != null) {
                        h.this.lnL.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.gE(true);
            aVar.b(this.lnL.getPageContext());
            aVar.aMS();
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
                if (this.kTM != null) {
                    this.kTM.be(6, com.baidu.tieba.k.a.s(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dcH() {
        try {
            if (this.mCamera != null) {
                if (this.lnR == null) {
                    this.lnR = this.mCamera.getParameters();
                }
                if ("off".equals(this.lnR.getFlashMode())) {
                    this.lnR.setFlashMode("torch");
                } else {
                    this.lnR.setFlashMode("off");
                }
                this.mCamera.setParameters(this.lnR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kTM != null) {
                this.kTM.be(7, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    public boolean dcI() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.lnR == null) {
                this.lnR = this.mCamera.getParameters();
            }
            return !"off".equals(this.lnR.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kTM != null) {
                this.kTM.be(7, com.baidu.tieba.k.a.s(e));
                return false;
            }
            return false;
        }
    }

    public void dcJ() {
        if (this.btL != null && (this.btL instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.btL;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dcr();
            this.lnQ = this.lnQ == 0 ? 1 : 0;
            uD(this.lnQ == 1);
            gLVideoPreviewView.dcs();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.btL != null && (this.btL instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.btL).h(this.mCamera);
            releaseCamera();
            this.lnQ = this.lnQ == 0 ? 1 : 0;
            uD(this.lnQ == 1);
            startPreview();
        }
    }

    public boolean dcK() {
        return this.lnQ == 1;
    }

    private void dcL() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcM() {
        if (this.lnO != null && this.lnN != null && this.lnN.getParent() != null) {
            this.lnO.removeView(this.lnN);
        }
    }

    private void cX(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.lnP.contains("auto")) {
                this.lnR = this.mCamera.getParameters();
                this.lnR.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.lnR);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.kTM != null) {
                this.kTM.be(9, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;

        /* renamed from: top  reason: collision with root package name */
        int f1026top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.f1026top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.f1026top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.btL instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.btL).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.btL instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.btL).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.btL instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.btL).setSticker(stickerItem);
        }
    }

    public void onResume() {
        uD(this.lnQ == 1);
        if (this.btL != null && (this.btL instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.btL).onResume();
        }
        if (this.btL != null && (this.btL instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.btL).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dcm()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.lnS.h(this.mCamera);
        if (this.btL != null && (this.btL instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.btL).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.lnX = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.lnr = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.lnS instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.lnS != null) {
                        h.this.lnS.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.lnS.a(aVar);
        }
    }

    public boolean dcw() {
        return this.mCameraId == 0;
    }
}
