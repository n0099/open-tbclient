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
/* loaded from: classes17.dex */
public class h {
    private SurfaceView bMe;
    private int bNI;
    private int bNJ;
    private int dhi;
    private RecordVideoActivity mAP;
    private Bitmap mAQ;
    private a mAR;
    private FrameLayout mAS;
    private List<String> mAT;
    private g mAW;
    protected List<String> mAX;
    private b mAY;
    private com.baidu.tieba.video.record.b mAZ;
    private GLVideoPreviewView.a mAv;
    private GLVideoPreviewView.a mBa;
    private c mBb;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private com.baidu.tieba.k.h mgu;
    protected String myf;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int mAU = 0;
    private Camera.Parameters mAV = null;

    /* loaded from: classes17.dex */
    public interface b {
        void dDv();
    }

    /* loaded from: classes17.dex */
    public interface c {
        void dt(int i, int i2);
    }

    public void aj(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.ih(false);
        aVar.ns(R.string.request_permission_default_title);
        aVar.nt(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.i.I(activity));
        aVar.bhg();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mgu = lVar.cRu();
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
                        if (h.this.mAP != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aj(h.this.mAP);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.mAP, R.string.disallow_camera_permission);
                            if (h.this.mgu != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.mAP.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.mgu.bm(1, string);
                            }
                            h.this.mAP.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.mAP != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.mAP, R.string.disallow_audio_record_permission);
                            if (h.this.mgu != null) {
                                h.this.mgu.bm(2, h.this.mAP.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.mAP.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mBa = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void wN(final boolean z) {
                if (h.this.mAv != null) {
                    com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.mAv.wN(z);
                        }
                    });
                }
            }
        };
        this.mAP = recordVideoActivity;
        dDt();
        this.mAQ = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dhi = displayMetrics.heightPixels;
        this.mAS = this.mAP.dDL();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bMe = gLVideoPreviewView;
            this.mAW = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bMe).setFaceIdentifyStateListener(this.mBa);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bMe = videoPreviewView;
            this.mAW = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dDL() != null) {
            recordVideoActivity.dDL().addView(this.bMe, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.mAW.e(this.mCamera);
    }

    public void startRecord() {
        this.mAW.f(this.mCamera);
    }

    public void stopRecord() {
        this.mAW.g(this.mCamera);
    }

    public g dDg() {
        return this.mAW;
    }

    public String dDh() {
        if (this.mAX == null) {
            this.mAX = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.mtS);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.mtS + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.mAX.add(str);
        return str;
    }

    public void dDi() {
        if (this.mAX != null && this.mAX.size() != 0) {
            String remove = this.mAX.remove(this.mAX.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dDj() {
        File file = new File(com.baidu.tieba.video.c.mtS);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.myf = com.baidu.tieba.video.c.mtS + "f_" + System.currentTimeMillis() + ".mp4";
        return this.myf;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.mAY != null && motionEvent.getAction() == 0) {
            this.mAY.dDv();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dDu();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.mAY = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dhi && x >= com.baidu.adp.lib.util.l.getDimens(this.mAP, R.dimen.ds60)) {
                    int width = this.mAQ.getWidth();
                    int height = this.mAQ.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dhi - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.mAS == null) {
                            this.mAS = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.mAS.getChildCount()) {
                                if (this.mAR != this.mAS.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.mAS.removeViewAt(i);
                                }
                            }
                        }
                        this.mAR = new a(this.mAP, clamp - (width / 2), clamp2 - (height / 2), this.mAQ);
                        this.mAS.addView(this.mAR, new ViewGroup.LayoutParams(-2, -2));
                        ds(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dDu();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dDk() {
        int i;
        int i2;
        if (this.mCamera == null && this.mAP != null) {
            this.mAP.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mAP.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.mAP.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.bNI = c2.width;
            this.bNJ = c2.height;
            this.mAV.setPreviewSize(this.bNI, this.bNJ);
            if (this.mAW != null) {
                this.mAW.setPreviewSize(this.bNI, this.bNJ);
            }
        }
        this.mAV.setPreviewFormat(17);
        dDl();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.mAP, this.mCameraId));
        this.mAT = this.mAV.getSupportedFocusModes();
        if (this.mAT != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.mAT.contains("continuous-picture")) {
                this.mAV.setFocusMode("continuous-picture");
            } else if (this.mAT.contains("continuous-video")) {
                this.mAV.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.mAV);
        if (this.mAP != null && this.mAP.dDL() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.bNJ * 1.0f) / this.bNI;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMe.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.bMe.setLayoutParams(layoutParams);
            this.bMe.invalidate();
            if (this.mBb != null) {
                this.mBb.dt(layoutParams.width, layoutParams.height);
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

    private void dDl() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.mAV.getSupportedPreviewFpsRange()) {
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
        this.mAV.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void wO(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.wK(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.wK(z)) {
                    dDo();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.wL(z);
            if (-1 != this.mCameraId) {
                dDn();
                this.mAZ = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dDo();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dDo();
            if (this.mgu != null) {
                this.mgu.bm(8, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dDm() {
        return this.mAZ;
    }

    private void dDn() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.mAV = this.mCamera.getParameters();
            dDk();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dDo() {
        if (this.mAP != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mAP.getPageContext().getPageActivity());
            aVar.nt(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.mAP != null) {
                        h.this.mAP.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ig(true);
            aVar.b(this.mAP.getPageContext());
            aVar.bhg();
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
                if (this.mgu != null) {
                    this.mgu.bm(6, com.baidu.tieba.k.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dDp() {
        try {
            if (this.mCamera != null) {
                if (this.mAV == null) {
                    this.mAV = this.mCamera.getParameters();
                }
                if ("off".equals(this.mAV.getFlashMode())) {
                    this.mAV.setFlashMode("torch");
                } else {
                    this.mAV.setFlashMode("off");
                }
                this.mCamera.setParameters(this.mAV);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mgu != null) {
                this.mgu.bm(7, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public boolean dDq() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.mAV == null) {
                this.mAV = this.mCamera.getParameters();
            }
            return !"off".equals(this.mAV.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mgu != null) {
                this.mgu.bm(7, com.baidu.tieba.k.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dDr() {
        if (this.bMe != null && (this.bMe instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bMe;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dCZ();
            this.mAU = this.mAU == 0 ? 1 : 0;
            wO(this.mAU == 1);
            gLVideoPreviewView.dDa();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bMe != null && (this.bMe instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bMe).h(this.mCamera);
            releaseCamera();
            this.mAU = this.mAU == 0 ? 1 : 0;
            wO(this.mAU == 1);
            startPreview();
        }
    }

    public boolean dDs() {
        return this.mAU == 1;
    }

    private void dDt() {
        this.bNI = 720;
        this.bNJ = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDu() {
        if (this.mAS != null && this.mAR != null && this.mAR.getParent() != null) {
            this.mAS.removeView(this.mAR);
        }
    }

    private void ds(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.mAT.contains("auto")) {
                this.mAV = this.mCamera.getParameters();
                this.mAV.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.mAV);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mgu != null) {
                this.mgu.bm(9, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
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
        if (this.bMe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bMe).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.bMe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bMe).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.bMe instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bMe).setSticker(stickerItem);
        }
    }

    public void onResume() {
        wO(this.mAU == 1);
        if (this.bMe != null && (this.bMe instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bMe).onResume();
        }
        if (this.bMe != null && (this.bMe instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bMe).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dCU()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.mAW.h(this.mCamera);
        if (this.bMe != null && (this.bMe instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bMe).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.mBb = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.mAv = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.mAW instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.mAW != null) {
                        h.this.mAW.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.mAW.a(aVar);
        }
    }

    public boolean dDe() {
        return this.mCameraId == 0;
    }
}
