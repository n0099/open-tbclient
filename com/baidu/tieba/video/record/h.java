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
/* loaded from: classes23.dex */
public class h {
    private SurfaceView ciX;
    private int cny;
    private int cnz;
    private int dJG;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private com.baidu.tieba.k.h mYk;
    protected String npZ;
    private RecordVideoActivity nsJ;
    private Bitmap nsK;
    private a nsL;
    private FrameLayout nsM;
    private List<String> nsN;
    private g nsQ;
    protected List<String> nsR;
    private b nsS;
    private com.baidu.tieba.video.record.b nsT;
    private GLVideoPreviewView.a nsU;
    private c nsV;
    private GLVideoPreviewView.a nsp;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nsO = 0;
    private Camera.Parameters nsP = null;

    /* loaded from: classes23.dex */
    public interface b {
        void dQL();
    }

    /* loaded from: classes23.dex */
    public interface c {
        void dB(int i, int i2);
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iW(false);
        aVar.ov(R.string.request_permission_default_title);
        aVar.ow(R.string.request_permission_camera);
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
        aVar.bpc();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
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
                        if (h.this.nsJ != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ao(h.this.nsJ);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nsJ, R.string.disallow_camera_permission);
                            if (h.this.mYk != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nsJ.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.mYk.bF(1, string);
                            }
                            h.this.nsJ.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nsJ != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nsJ, R.string.disallow_audio_record_permission);
                            if (h.this.mYk != null) {
                                h.this.mYk.bF(2, h.this.nsJ.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nsJ.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nsU = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yd(final boolean z) {
                if (h.this.nsp != null) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nsp.yd(z);
                        }
                    });
                }
            }
        };
        this.nsJ = recordVideoActivity;
        dQJ();
        this.nsK = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dJG = displayMetrics.heightPixels;
        this.nsM = this.nsJ.dRb();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.ciX = gLVideoPreviewView;
            this.nsQ = gLVideoPreviewView;
            ((GLVideoPreviewView) this.ciX).setFaceIdentifyStateListener(this.nsU);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.ciX = videoPreviewView;
            this.nsQ = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dRb() != null) {
            recordVideoActivity.dRb().addView(this.ciX, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nsQ.e(this.mCamera);
    }

    public void startRecord() {
        this.nsQ.f(this.mCamera);
    }

    public void stopRecord() {
        this.nsQ.g(this.mCamera);
    }

    public g dQw() {
        return this.nsQ;
    }

    public String dQx() {
        if (this.nsR == null) {
            this.nsR = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nlN);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nlN + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nsR.add(str);
        return str;
    }

    public void dQy() {
        if (this.nsR != null && this.nsR.size() != 0) {
            String remove = this.nsR.remove(this.nsR.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dQz() {
        File file = new File(com.baidu.tieba.video.c.nlN);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.npZ = com.baidu.tieba.video.c.nlN + "f_" + System.currentTimeMillis() + ".mp4";
        return this.npZ;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nsS != null && motionEvent.getAction() == 0) {
            this.nsS.dQL();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dQK();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nsS = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dJG && x >= com.baidu.adp.lib.util.l.getDimens(this.nsJ, R.dimen.ds60)) {
                    int width = this.nsK.getWidth();
                    int height = this.nsK.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dJG - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nsM == null) {
                            this.nsM = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nsM.getChildCount()) {
                                if (this.nsL != this.nsM.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nsM.removeViewAt(i);
                                }
                            }
                        }
                        this.nsL = new a(this.nsJ, clamp - (width / 2), clamp2 - (height / 2), this.nsK);
                        this.nsM.addView(this.nsL, new ViewGroup.LayoutParams(-2, -2));
                        dA(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dQK();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dQA() {
        int i;
        int i2;
        if (this.mCamera == null && this.nsJ != null) {
            this.nsJ.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nsJ.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nsJ.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.cny = c2.width;
            this.cnz = c2.height;
            this.nsP.setPreviewSize(this.cny, this.cnz);
            if (this.nsQ != null) {
                this.nsQ.setPreviewSize(this.cny, this.cnz);
            }
        }
        this.nsP.setPreviewFormat(17);
        dQB();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nsJ, this.mCameraId));
        this.nsN = this.nsP.getSupportedFocusModes();
        if (this.nsN != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nsN.contains("continuous-picture")) {
                this.nsP.setFocusMode("continuous-picture");
            } else if (this.nsN.contains("continuous-video")) {
                this.nsP.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nsP);
        if (this.nsJ != null && this.nsJ.dRb() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.cnz * 1.0f) / this.cny;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ciX.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.ciX.setLayoutParams(layoutParams);
            this.ciX.invalidate();
            if (this.nsV != null) {
                this.nsV.dB(layoutParams.width, layoutParams.height);
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

    private void dQB() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.nsP.getSupportedPreviewFpsRange()) {
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
        this.nsP.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ye(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.ya(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.ya(z)) {
                    dQE();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yb(z);
            if (-1 != this.mCameraId) {
                dQD();
                this.nsT = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dQE();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dQE();
            if (this.mYk != null) {
                this.mYk.bF(8, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dQC() {
        return this.nsT;
    }

    private void dQD() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nsP = this.mCamera.getParameters();
            dQA();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dQE() {
        if (this.nsJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nsJ.getPageContext().getPageActivity());
            aVar.ow(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nsJ != null) {
                        h.this.nsJ.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.iV(true);
            aVar.b(this.nsJ.getPageContext());
            aVar.bpc();
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
                if (this.mYk != null) {
                    this.mYk.bF(6, com.baidu.tieba.k.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dQF() {
        try {
            if (this.mCamera != null) {
                if (this.nsP == null) {
                    this.nsP = this.mCamera.getParameters();
                }
                if ("off".equals(this.nsP.getFlashMode())) {
                    this.nsP.setFlashMode("torch");
                } else {
                    this.nsP.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nsP);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mYk != null) {
                this.mYk.bF(7, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public boolean dQG() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nsP == null) {
                this.nsP = this.mCamera.getParameters();
            }
            return !"off".equals(this.nsP.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mYk != null) {
                this.mYk.bF(7, com.baidu.tieba.k.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dQH() {
        if (this.ciX != null && (this.ciX instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.ciX;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dQp();
            this.nsO = this.nsO == 0 ? 1 : 0;
            ye(this.nsO == 1);
            gLVideoPreviewView.dQq();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.ciX != null && (this.ciX instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.ciX).h(this.mCamera);
            releaseCamera();
            this.nsO = this.nsO == 0 ? 1 : 0;
            ye(this.nsO == 1);
            startPreview();
        }
    }

    public boolean dQI() {
        return this.nsO == 1;
    }

    private void dQJ() {
        this.cny = 720;
        this.cnz = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQK() {
        if (this.nsM != null && this.nsL != null && this.nsL.getParent() != null) {
            this.nsM.removeView(this.nsL);
        }
    }

    private void dA(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nsN.contains("auto")) {
                this.nsP = this.mCamera.getParameters();
                this.nsP.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nsP);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mYk != null) {
                this.mYk.bF(9, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
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
        if (this.ciX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.ciX).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.ciX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.ciX).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.ciX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.ciX).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ye(this.nsO == 1);
        if (this.ciX != null && (this.ciX instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.ciX).onResume();
        }
        if (this.ciX != null && (this.ciX instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.ciX).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dQk()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nsQ.h(this.mCamera);
        if (this.ciX != null && (this.ciX instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.ciX).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nsV = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nsp = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nsQ instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nsQ != null) {
                        h.this.nsQ.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nsQ.a(aVar);
        }
    }

    public boolean dQu() {
        return this.mCameraId == 0;
    }
}
