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
/* loaded from: classes22.dex */
public class h {
    private SurfaceView chl;
    private int clM;
    private int clN;
    private int dHY;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private com.baidu.tieba.l.h mZc;
    protected String nrg;
    private RecordVideoActivity ntQ;
    private Bitmap ntR;
    private a ntS;
    private FrameLayout ntT;
    private List<String> ntU;
    private g ntX;
    protected List<String> ntY;
    private b ntZ;
    private GLVideoPreviewView.a ntw;
    private com.baidu.tieba.video.record.b nua;
    private GLVideoPreviewView.a nub;
    private c nuc;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int ntV = 0;
    private Camera.Parameters ntW = null;

    /* loaded from: classes22.dex */
    public interface b {
        void dQK();
    }

    /* loaded from: classes22.dex */
    public interface c {
        void dC(int i, int i2);
    }

    public void an(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iX(false);
        aVar.or(R.string.request_permission_default_title);
        aVar.os(R.string.request_permission_camera);
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
        aVar.bog();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.mZc = lVar.ddQ();
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
                        if (h.this.ntQ != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.an(h.this.ntQ);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.ntQ, R.string.disallow_camera_permission);
                            if (h.this.mZc != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.ntQ.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.mZc.bD(1, string);
                            }
                            h.this.ntQ.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.ntQ != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.ntQ, R.string.disallow_audio_record_permission);
                            if (h.this.mZc != null) {
                                h.this.mZc.bD(2, h.this.ntQ.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.ntQ.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nub = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yk(final boolean z) {
                if (h.this.ntw != null) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.ntw.yk(z);
                        }
                    });
                }
            }
        };
        this.ntQ = recordVideoActivity;
        dQI();
        this.ntR = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dHY = displayMetrics.heightPixels;
        this.ntT = this.ntQ.dRa();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.chl = gLVideoPreviewView;
            this.ntX = gLVideoPreviewView;
            ((GLVideoPreviewView) this.chl).setFaceIdentifyStateListener(this.nub);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.chl = videoPreviewView;
            this.ntX = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dRa() != null) {
            recordVideoActivity.dRa().addView(this.chl, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.ntX.e(this.mCamera);
    }

    public void startRecord() {
        this.ntX.f(this.mCamera);
    }

    public void stopRecord() {
        this.ntX.g(this.mCamera);
    }

    public g dQv() {
        return this.ntX;
    }

    public String dQw() {
        if (this.ntY == null) {
            this.ntY = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nmU);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nmU + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.ntY.add(str);
        return str;
    }

    public void dQx() {
        if (this.ntY != null && this.ntY.size() != 0) {
            String remove = this.ntY.remove(this.ntY.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dQy() {
        File file = new File(com.baidu.tieba.video.c.nmU);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nrg = com.baidu.tieba.video.c.nmU + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nrg;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.ntZ != null && motionEvent.getAction() == 0) {
            this.ntZ.dQK();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dQJ();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.ntZ = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dHY && x >= com.baidu.adp.lib.util.l.getDimens(this.ntQ, R.dimen.ds60)) {
                    int width = this.ntR.getWidth();
                    int height = this.ntR.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dHY - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.ntT == null) {
                            this.ntT = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.ntT.getChildCount()) {
                                if (this.ntS != this.ntT.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.ntT.removeViewAt(i);
                                }
                            }
                        }
                        this.ntS = new a(this.ntQ, clamp - (width / 2), clamp2 - (height / 2), this.ntR);
                        this.ntT.addView(this.ntS, new ViewGroup.LayoutParams(-2, -2));
                        dB(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dQJ();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dQz() {
        int i;
        int i2;
        if (this.mCamera == null && this.ntQ != null) {
            this.ntQ.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ntQ.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.ntQ.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.clM = c2.width;
            this.clN = c2.height;
            this.ntW.setPreviewSize(this.clM, this.clN);
            if (this.ntX != null) {
                this.ntX.setPreviewSize(this.clM, this.clN);
            }
        }
        this.ntW.setPreviewFormat(17);
        dQA();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.ntQ, this.mCameraId));
        this.ntU = this.ntW.getSupportedFocusModes();
        if (this.ntU != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.ntU.contains("continuous-picture")) {
                this.ntW.setFocusMode("continuous-picture");
            } else if (this.ntU.contains("continuous-video")) {
                this.ntW.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.ntW);
        if (this.ntQ != null && this.ntQ.dRa() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.clN * 1.0f) / this.clM;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.chl.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.chl.setLayoutParams(layoutParams);
            this.chl.invalidate();
            if (this.nuc != null) {
                this.nuc.dC(layoutParams.width, layoutParams.height);
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

    private void dQA() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.ntW.getSupportedPreviewFpsRange()) {
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
        this.ntW.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void yl(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.yh(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.yh(z)) {
                    dQD();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yi(z);
            if (-1 != this.mCameraId) {
                dQC();
                this.nua = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dQD();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dQD();
            if (this.mZc != null) {
                this.mZc.bD(8, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dQB() {
        return this.nua;
    }

    private void dQC() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.ntW = this.mCamera.getParameters();
            dQz();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dQD() {
        if (this.ntQ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ntQ.getPageContext().getPageActivity());
            aVar.os(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.ntQ != null) {
                        h.this.ntQ.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.iW(true);
            aVar.b(this.ntQ.getPageContext());
            aVar.bog();
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
                if (this.mZc != null) {
                    this.mZc.bD(6, com.baidu.tieba.l.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dQE() {
        try {
            if (this.mCamera != null) {
                if (this.ntW == null) {
                    this.ntW = this.mCamera.getParameters();
                }
                if ("off".equals(this.ntW.getFlashMode())) {
                    this.ntW.setFlashMode("torch");
                } else {
                    this.ntW.setFlashMode("off");
                }
                this.mCamera.setParameters(this.ntW);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mZc != null) {
                this.mZc.bD(7, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    public boolean dQF() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.ntW == null) {
                this.ntW = this.mCamera.getParameters();
            }
            return !"off".equals(this.ntW.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mZc != null) {
                this.mZc.bD(7, com.baidu.tieba.l.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dQG() {
        if (this.chl != null && (this.chl instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.chl;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dQo();
            this.ntV = this.ntV == 0 ? 1 : 0;
            yl(this.ntV == 1);
            gLVideoPreviewView.dQp();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.chl != null && (this.chl instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.chl).h(this.mCamera);
            releaseCamera();
            this.ntV = this.ntV == 0 ? 1 : 0;
            yl(this.ntV == 1);
            startPreview();
        }
    }

    public boolean dQH() {
        return this.ntV == 1;
    }

    private void dQI() {
        this.clM = 720;
        this.clN = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQJ() {
        if (this.ntT != null && this.ntS != null && this.ntS.getParent() != null) {
            this.ntT.removeView(this.ntS);
        }
    }

    private void dB(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.ntU.contains("auto")) {
                this.ntW = this.mCamera.getParameters();
                this.ntW.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.ntW);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mZc != null) {
                this.mZc.bD(9, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
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
        if (this.chl instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.chl).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.chl instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.chl).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.chl instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.chl).setSticker(stickerItem);
        }
    }

    public void onResume() {
        yl(this.ntV == 1);
        if (this.chl != null && (this.chl instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.chl).onResume();
        }
        if (this.chl != null && (this.chl instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.chl).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dQj()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.ntX.h(this.mCamera);
        if (this.chl != null && (this.chl instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.chl).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nuc = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.ntw = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.ntX instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.ntX != null) {
                        h.this.ntX.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.ntX.a(aVar);
        }
    }

    public boolean dQt() {
        return this.mCameraId == 0;
    }
}
