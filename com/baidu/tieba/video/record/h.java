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
    private SurfaceView cdm;
    private int chC;
    private int chD;
    private int dDO;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private com.baidu.tieba.k.h mSh;
    protected String nkc;
    private RecordVideoActivity nmM;
    private Bitmap nmN;
    private a nmO;
    private FrameLayout nmP;
    private List<String> nmQ;
    private g nmT;
    protected List<String> nmU;
    private b nmV;
    private com.baidu.tieba.video.record.b nmW;
    private GLVideoPreviewView.a nmX;
    private c nmY;
    private GLVideoPreviewView.a nms;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nmR = 0;
    private Camera.Parameters nmS = null;

    /* loaded from: classes23.dex */
    public interface b {
        void dOj();
    }

    /* loaded from: classes23.dex */
    public interface c {
        void dz(int i, int i2);
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iN(false);
        aVar.ol(R.string.request_permission_default_title);
        aVar.om(R.string.request_permission_camera);
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
        aVar.bmC();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
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
                        if (h.this.nmM != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ao(h.this.nmM);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nmM, R.string.disallow_camera_permission);
                            if (h.this.mSh != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nmM.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.mSh.bB(1, string);
                            }
                            h.this.nmM.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nmM != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nmM, R.string.disallow_audio_record_permission);
                            if (h.this.mSh != null) {
                                h.this.mSh.bB(2, h.this.nmM.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nmM.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nmX = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void xU(final boolean z) {
                if (h.this.nms != null) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nms.xU(z);
                        }
                    });
                }
            }
        };
        this.nmM = recordVideoActivity;
        dOh();
        this.nmN = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dDO = displayMetrics.heightPixels;
        this.nmP = this.nmM.dOz();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.cdm = gLVideoPreviewView;
            this.nmT = gLVideoPreviewView;
            ((GLVideoPreviewView) this.cdm).setFaceIdentifyStateListener(this.nmX);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.cdm = videoPreviewView;
            this.nmT = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dOz() != null) {
            recordVideoActivity.dOz().addView(this.cdm, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nmT.e(this.mCamera);
    }

    public void startRecord() {
        this.nmT.f(this.mCamera);
    }

    public void stopRecord() {
        this.nmT.g(this.mCamera);
    }

    public g dNU() {
        return this.nmT;
    }

    public String dNV() {
        if (this.nmU == null) {
            this.nmU = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nfR);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nfR + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nmU.add(str);
        return str;
    }

    public void dNW() {
        if (this.nmU != null && this.nmU.size() != 0) {
            String remove = this.nmU.remove(this.nmU.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dNX() {
        File file = new File(com.baidu.tieba.video.c.nfR);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nkc = com.baidu.tieba.video.c.nfR + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nkc;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nmV != null && motionEvent.getAction() == 0) {
            this.nmV.dOj();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dOi();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nmV = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dDO && x >= com.baidu.adp.lib.util.l.getDimens(this.nmM, R.dimen.ds60)) {
                    int width = this.nmN.getWidth();
                    int height = this.nmN.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dDO - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nmP == null) {
                            this.nmP = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nmP.getChildCount()) {
                                if (this.nmO != this.nmP.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nmP.removeViewAt(i);
                                }
                            }
                        }
                        this.nmO = new a(this.nmM, clamp - (width / 2), clamp2 - (height / 2), this.nmN);
                        this.nmP.addView(this.nmO, new ViewGroup.LayoutParams(-2, -2));
                        dy(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dOi();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dNY() {
        int i;
        int i2;
        if (this.mCamera == null && this.nmM != null) {
            this.nmM.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nmM.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nmM.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.chC = c2.width;
            this.chD = c2.height;
            this.nmS.setPreviewSize(this.chC, this.chD);
            if (this.nmT != null) {
                this.nmT.setPreviewSize(this.chC, this.chD);
            }
        }
        this.nmS.setPreviewFormat(17);
        dNZ();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nmM, this.mCameraId));
        this.nmQ = this.nmS.getSupportedFocusModes();
        if (this.nmQ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nmQ.contains("continuous-picture")) {
                this.nmS.setFocusMode("continuous-picture");
            } else if (this.nmQ.contains("continuous-video")) {
                this.nmS.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nmS);
        if (this.nmM != null && this.nmM.dOz() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.chD * 1.0f) / this.chC;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cdm.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.cdm.setLayoutParams(layoutParams);
            this.cdm.invalidate();
            if (this.nmY != null) {
                this.nmY.dz(layoutParams.width, layoutParams.height);
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

    private void dNZ() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.nmS.getSupportedPreviewFpsRange()) {
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
        this.nmS.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void xV(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.xR(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.xR(z)) {
                    dOc();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.xS(z);
            if (-1 != this.mCameraId) {
                dOb();
                this.nmW = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dOc();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dOc();
            if (this.mSh != null) {
                this.mSh.bB(8, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dOa() {
        return this.nmW;
    }

    private void dOb() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nmS = this.mCamera.getParameters();
            dNY();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.r(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dOc() {
        if (this.nmM != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nmM.getPageContext().getPageActivity());
            aVar.om(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nmM != null) {
                        h.this.nmM.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.iM(true);
            aVar.b(this.nmM.getPageContext());
            aVar.bmC();
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
                if (this.mSh != null) {
                    this.mSh.bB(6, com.baidu.tieba.k.a.r(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dOd() {
        try {
            if (this.mCamera != null) {
                if (this.nmS == null) {
                    this.nmS = this.mCamera.getParameters();
                }
                if ("off".equals(this.nmS.getFlashMode())) {
                    this.nmS.setFlashMode("torch");
                } else {
                    this.nmS.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nmS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mSh != null) {
                this.mSh.bB(7, com.baidu.tieba.k.a.r(e));
            }
        }
    }

    public boolean dOe() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nmS == null) {
                this.nmS = this.mCamera.getParameters();
            }
            return !"off".equals(this.nmS.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mSh != null) {
                this.mSh.bB(7, com.baidu.tieba.k.a.r(e));
                return false;
            }
            return false;
        }
    }

    public void dOf() {
        if (this.cdm != null && (this.cdm instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.cdm;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dNN();
            this.nmR = this.nmR == 0 ? 1 : 0;
            xV(this.nmR == 1);
            gLVideoPreviewView.dNO();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.cdm != null && (this.cdm instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cdm).h(this.mCamera);
            releaseCamera();
            this.nmR = this.nmR == 0 ? 1 : 0;
            xV(this.nmR == 1);
            startPreview();
        }
    }

    public boolean dOg() {
        return this.nmR == 1;
    }

    private void dOh() {
        this.chC = 720;
        this.chD = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOi() {
        if (this.nmP != null && this.nmO != null && this.nmO.getParent() != null) {
            this.nmP.removeView(this.nmO);
        }
    }

    private void dy(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nmQ.contains("auto")) {
                this.nmS = this.mCamera.getParameters();
                this.nmS.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nmS);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mSh != null) {
                this.mSh.bB(9, com.baidu.tieba.k.a.r(e));
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
        if (this.cdm instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cdm).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.cdm instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cdm).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.cdm instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cdm).setSticker(stickerItem);
        }
    }

    public void onResume() {
        xV(this.nmR == 1);
        if (this.cdm != null && (this.cdm instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cdm).onResume();
        }
        if (this.cdm != null && (this.cdm instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cdm).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dNI()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nmT.h(this.mCamera);
        if (this.cdm != null && (this.cdm instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cdm).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nmY = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nms = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nmT instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nmT != null) {
                        h.this.nmT.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nmT.a(aVar);
        }
    }

    public boolean dNS() {
        return this.mCameraId == 0;
    }
}
