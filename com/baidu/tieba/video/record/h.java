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
    protected String nFj;
    private GLVideoPreviewView.a nHA;
    private RecordVideoActivity nHU;
    private Bitmap nHV;
    private a nHW;
    private FrameLayout nHX;
    private List<String> nHY;
    private g nIb;
    protected List<String> nIc;
    private b nId;
    private com.baidu.tieba.video.record.b nIe;
    private GLVideoPreviewView.a nIf;
    private c nIg;
    private com.baidu.tieba.l.h nnd;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nHZ = 0;
    private Camera.Parameters nIa = null;

    /* loaded from: classes23.dex */
    public interface b {
        void dWf();
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
            this.nnd = lVar.djc();
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
                        if (h.this.nHU != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ao(h.this.nHU);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nHU, R.string.disallow_camera_permission);
                            if (h.this.nnd != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nHU.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.nnd.bD(1, string);
                            }
                            h.this.nHU.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nHU != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nHU, R.string.disallow_audio_record_permission);
                            if (h.this.nnd != null) {
                                h.this.nnd.bD(2, h.this.nHU.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nHU.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nIf = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yP(final boolean z) {
                if (h.this.nHA != null) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nHA.yP(z);
                        }
                    });
                }
            }
        };
        this.nHU = recordVideoActivity;
        dWd();
        this.nHV = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dOW = displayMetrics.heightPixels;
        this.nHX = this.nHU.dWv();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.cnT = gLVideoPreviewView;
            this.nIb = gLVideoPreviewView;
            ((GLVideoPreviewView) this.cnT).setFaceIdentifyStateListener(this.nIf);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.cnT = videoPreviewView;
            this.nIb = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dWv() != null) {
            recordVideoActivity.dWv().addView(this.cnT, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nIb.e(this.mCamera);
    }

    public void startRecord() {
        this.nIb.f(this.mCamera);
    }

    public void stopRecord() {
        this.nIb.g(this.mCamera);
    }

    public g dVQ() {
        return this.nIb;
    }

    public String dVR() {
        if (this.nIc == null) {
            this.nIc = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nAZ);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nAZ + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nIc.add(str);
        return str;
    }

    public void dVS() {
        if (this.nIc != null && this.nIc.size() != 0) {
            String remove = this.nIc.remove(this.nIc.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dVT() {
        File file = new File(com.baidu.tieba.video.c.nAZ);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nFj = com.baidu.tieba.video.c.nAZ + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nFj;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nId != null && motionEvent.getAction() == 0) {
            this.nId.dWf();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dWe();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nId = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dOW && x >= com.baidu.adp.lib.util.l.getDimens(this.nHU, R.dimen.ds60)) {
                    int width = this.nHV.getWidth();
                    int height = this.nHV.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dOW - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nHX == null) {
                            this.nHX = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nHX.getChildCount()) {
                                if (this.nHW != this.nHX.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nHX.removeViewAt(i);
                                }
                            }
                        }
                        this.nHW = new a(this.nHU, clamp - (width / 2), clamp2 - (height / 2), this.nHV);
                        this.nHX.addView(this.nHW, new ViewGroup.LayoutParams(-2, -2));
                        dG(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dWe();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dVU() {
        int i;
        int i2;
        if (this.mCamera == null && this.nHU != null) {
            this.nHU.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nHU.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nHU.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.nIa.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nIb != null) {
                this.nIb.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nIa.setPreviewFormat(17);
        dVV();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nHU, this.mCameraId));
        this.nHY = this.nIa.getSupportedFocusModes();
        if (this.nHY != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nHY.contains("continuous-picture")) {
                this.nIa.setFocusMode("continuous-picture");
            } else if (this.nHY.contains("continuous-video")) {
                this.nIa.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nIa);
        if (this.nHU != null && this.nHU.dWv() != null) {
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
            if (this.nIg != null) {
                this.nIg.dH(layoutParams.width, layoutParams.height);
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

    private void dVV() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.nIa.getSupportedPreviewFpsRange()) {
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
        this.nIa.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void yQ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.yM(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.yM(z)) {
                    dVY();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yN(z);
            if (-1 != this.mCameraId) {
                dVX();
                this.nIe = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dVY();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dVY();
            if (this.nnd != null) {
                this.nnd.bD(8, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dVW() {
        return this.nIe;
    }

    private void dVX() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nIa = this.mCamera.getParameters();
            dVU();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dVY() {
        if (this.nHU != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nHU.getPageContext().getPageActivity());
            aVar.oQ(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nHU != null) {
                        h.this.nHU.finish();
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
            aVar.b(this.nHU.getPageContext());
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
                if (this.nnd != null) {
                    this.nnd.bD(6, com.baidu.tieba.l.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dVZ() {
        try {
            if (this.mCamera != null) {
                if (this.nIa == null) {
                    this.nIa = this.mCamera.getParameters();
                }
                if ("off".equals(this.nIa.getFlashMode())) {
                    this.nIa.setFlashMode("torch");
                } else {
                    this.nIa.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nIa);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnd != null) {
                this.nnd.bD(7, com.baidu.tieba.l.a.r(e));
            }
        }
    }

    public boolean dWa() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nIa == null) {
                this.nIa = this.mCamera.getParameters();
            }
            return !"off".equals(this.nIa.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnd != null) {
                this.nnd.bD(7, com.baidu.tieba.l.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dWb() {
        if (this.cnT != null && (this.cnT instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.cnT;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dVJ();
            this.nHZ = this.nHZ == 0 ? 1 : 0;
            yQ(this.nHZ == 1);
            gLVideoPreviewView.dVK();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.cnT != null && (this.cnT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cnT).h(this.mCamera);
            releaseCamera();
            this.nHZ = this.nHZ == 0 ? 1 : 0;
            yQ(this.nHZ == 1);
            startPreview();
        }
    }

    public boolean dWc() {
        return this.nHZ == 1;
    }

    private void dWd() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWe() {
        if (this.nHX != null && this.nHW != null && this.nHW.getParent() != null) {
            this.nHX.removeView(this.nHW);
        }
    }

    private void dG(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nHY.contains("auto")) {
                this.nIa = this.mCamera.getParameters();
                this.nIa.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nIa);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nnd != null) {
                this.nnd.bD(9, com.baidu.tieba.l.a.r(e));
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
        yQ(this.nHZ == 1);
        if (this.cnT != null && (this.cnT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cnT).onResume();
        }
        if (this.cnT != null && (this.cnT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cnT).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dVE()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nIb.h(this.mCamera);
        if (this.cnT != null && (this.cnT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cnT).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nIg = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nHA = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nIb instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nIb != null) {
                        h.this.nIb.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nIb.a(aVar);
        }
    }

    public boolean dVO() {
        return this.mCameraId == 0;
    }
}
