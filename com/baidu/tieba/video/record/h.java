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
    private SurfaceView cnT;
    private int dOW;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    protected String nFh;
    private RecordVideoActivity nHS;
    private Bitmap nHT;
    private a nHU;
    private FrameLayout nHV;
    private List<String> nHW;
    private g nHZ;
    private GLVideoPreviewView.a nHy;
    protected List<String> nIa;
    private b nIb;
    private com.baidu.tieba.video.record.b nIc;
    private GLVideoPreviewView.a nId;
    private c nIe;
    private com.baidu.tieba.l.h nnb;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nHX = 0;
    private Camera.Parameters nHY = null;

    /* loaded from: classes23.dex */
    public interface b {
        void dWe();
    }

    /* loaded from: classes23.dex */
    public interface c {
        void dH(int i, int i2);
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jm(false);
        aVar.oP(R.string.request_permission_default_title);
        aVar.oQ(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.i.J(activity));
        aVar.brv();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnb = lVar.djb();
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
                        if (h.this.nHS != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ao(h.this.nHS);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nHS, R.string.disallow_camera_permission);
                            if (h.this.nnb != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nHS.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.nnb.bD(1, string);
                            }
                            h.this.nHS.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nHS != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nHS, R.string.disallow_audio_record_permission);
                            if (h.this.nnb != null) {
                                h.this.nnb.bD(2, h.this.nHS.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nHS.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nId = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yP(final boolean z) {
                if (h.this.nHy != null) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nHy.yP(z);
                        }
                    });
                }
            }
        };
        this.nHS = recordVideoActivity;
        dWc();
        this.nHT = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dOW = displayMetrics.heightPixels;
        this.nHV = this.nHS.dWu();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.cnT = gLVideoPreviewView;
            this.nHZ = gLVideoPreviewView;
            ((GLVideoPreviewView) this.cnT).setFaceIdentifyStateListener(this.nId);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.cnT = videoPreviewView;
            this.nHZ = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dWu() != null) {
            recordVideoActivity.dWu().addView(this.cnT, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nHZ.e(this.mCamera);
    }

    public void startRecord() {
        this.nHZ.f(this.mCamera);
    }

    public void stopRecord() {
        this.nHZ.g(this.mCamera);
    }

    public g dVP() {
        return this.nHZ;
    }

    public String dVQ() {
        if (this.nIa == null) {
            this.nIa = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nAX);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nAX + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nIa.add(str);
        return str;
    }

    public void dVR() {
        if (this.nIa != null && this.nIa.size() != 0) {
            String remove = this.nIa.remove(this.nIa.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dVS() {
        File file = new File(com.baidu.tieba.video.c.nAX);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nFh = com.baidu.tieba.video.c.nAX + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nFh;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nIb != null && motionEvent.getAction() == 0) {
            this.nIb.dWe();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dWd();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nIb = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dOW && x >= com.baidu.adp.lib.util.l.getDimens(this.nHS, R.dimen.ds60)) {
                    int width = this.nHT.getWidth();
                    int height = this.nHT.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dOW - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nHV == null) {
                            this.nHV = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nHV.getChildCount()) {
                                if (this.nHU != this.nHV.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nHV.removeViewAt(i);
                                }
                            }
                        }
                        this.nHU = new a(this.nHS, clamp - (width / 2), clamp2 - (height / 2), this.nHT);
                        this.nHV.addView(this.nHU, new ViewGroup.LayoutParams(-2, -2));
                        dG(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dWd();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dVT() {
        int i;
        int i2;
        if (this.mCamera == null && this.nHS != null) {
            this.nHS.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nHS.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nHS.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.nHY.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nHZ != null) {
                this.nHZ.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nHY.setPreviewFormat(17);
        dVU();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nHS, this.mCameraId));
        this.nHW = this.nHY.getSupportedFocusModes();
        if (this.nHW != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nHW.contains("continuous-picture")) {
                this.nHY.setFocusMode("continuous-picture");
            } else if (this.nHW.contains("continuous-video")) {
                this.nHY.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nHY);
        if (this.nHS != null && this.nHS.dWu() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cnT.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.cnT.setLayoutParams(layoutParams);
            this.cnT.invalidate();
            if (this.nIe != null) {
                this.nIe.dH(layoutParams.width, layoutParams.height);
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

    private void dVU() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.nHY.getSupportedPreviewFpsRange()) {
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
        this.nHY.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void yQ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.yM(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.yM(z)) {
                    dVX();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yN(z);
            if (-1 != this.mCameraId) {
                dVW();
                this.nIc = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dVX();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dVX();
            if (this.nnb != null) {
                this.nnb.bD(8, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dVV() {
        return this.nIc;
    }

    private void dVW() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nHY = this.mCamera.getParameters();
            dVT();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dVX() {
        if (this.nHS != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nHS.getPageContext().getPageActivity());
            aVar.oQ(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nHS != null) {
                        h.this.nHS.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jl(true);
            aVar.b(this.nHS.getPageContext());
            aVar.brv();
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
                if (this.nnb != null) {
                    this.nnb.bD(6, com.baidu.tieba.l.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dVY() {
        try {
            if (this.mCamera != null) {
                if (this.nHY == null) {
                    this.nHY = this.mCamera.getParameters();
                }
                if ("off".equals(this.nHY.getFlashMode())) {
                    this.nHY.setFlashMode("torch");
                } else {
                    this.nHY.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nHY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnb != null) {
                this.nnb.bD(7, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    public boolean dVZ() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nHY == null) {
                this.nHY = this.mCamera.getParameters();
            }
            return !"off".equals(this.nHY.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnb != null) {
                this.nnb.bD(7, com.baidu.tieba.l.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dWa() {
        if (this.cnT != null && (this.cnT instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.cnT;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dVI();
            this.nHX = this.nHX == 0 ? 1 : 0;
            yQ(this.nHX == 1);
            gLVideoPreviewView.dVJ();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.cnT != null && (this.cnT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cnT).h(this.mCamera);
            releaseCamera();
            this.nHX = this.nHX == 0 ? 1 : 0;
            yQ(this.nHX == 1);
            startPreview();
        }
    }

    public boolean dWb() {
        return this.nHX == 1;
    }

    private void dWc() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWd() {
        if (this.nHV != null && this.nHU != null && this.nHU.getParent() != null) {
            this.nHV.removeView(this.nHU);
        }
    }

    private void dG(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nHW.contains("auto")) {
                this.nHY = this.mCamera.getParameters();
                this.nHY.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nHY);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnb != null) {
                this.nnb.bD(9, com.baidu.tieba.l.a.r(e));
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
        if (this.cnT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cnT).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.cnT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cnT).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.cnT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cnT).setSticker(stickerItem);
        }
    }

    public void onResume() {
        yQ(this.nHX == 1);
        if (this.cnT != null && (this.cnT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cnT).onResume();
        }
        if (this.cnT != null && (this.cnT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cnT).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dVD()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nHZ.h(this.mCamera);
        if (this.cnT != null && (this.cnT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cnT).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nIe = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nHy = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nHZ instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nHZ != null) {
                        h.this.nHZ.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nHZ.a(aVar);
        }
    }

    public boolean dVN() {
        return this.mCameraId == 0;
    }
}
