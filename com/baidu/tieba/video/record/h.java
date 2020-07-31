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
    private SurfaceView bGA;
    private int cXV;
    private com.baidu.tieba.k.h lOt;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    protected String mgb;
    private RecordVideoActivity miN;
    private Bitmap miO;
    private a miP;
    private FrameLayout miQ;
    private List<String> miR;
    private g miU;
    protected List<String> miV;
    private b miW;
    private com.baidu.tieba.video.record.b miX;
    private GLVideoPreviewView.a miY;
    private c miZ;
    private GLVideoPreviewView.a mit;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int miS = 0;
    private Camera.Parameters miT = null;

    /* loaded from: classes17.dex */
    public interface b {
        void drQ();
    }

    /* loaded from: classes17.dex */
    public interface c {
        void dl(int i, int i2);
    }

    public void ai(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.hK(false);
        aVar.lm(R.string.request_permission_default_title);
        aVar.ln(R.string.request_permission_camera);
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
        aVar.aYL();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lOt = lVar.cGE();
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
                        if (h.this.miN != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ai(h.this.miN);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.miN, R.string.disallow_camera_permission);
                            if (h.this.lOt != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.miN.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.lOt.bp(1, string);
                            }
                            h.this.miN.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.miN != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.miN, R.string.disallow_audio_record_permission);
                            if (h.this.lOt != null) {
                                h.this.lOt.bp(2, h.this.miN.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.miN.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.miY = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void vW(final boolean z) {
                if (h.this.mit != null) {
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.mit.vW(z);
                        }
                    });
                }
            }
        };
        this.miN = recordVideoActivity;
        drO();
        this.miO = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cXV = displayMetrics.heightPixels;
        this.miQ = this.miN.dsg();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.bGA = gLVideoPreviewView;
            this.miU = gLVideoPreviewView;
            ((GLVideoPreviewView) this.bGA).setFaceIdentifyStateListener(this.miY);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.bGA = videoPreviewView;
            this.miU = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dsg() != null) {
            recordVideoActivity.dsg().addView(this.bGA, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.miU.e(this.mCamera);
    }

    public void startRecord() {
        this.miU.f(this.mCamera);
    }

    public void stopRecord() {
        this.miU.g(this.mCamera);
    }

    public g drB() {
        return this.miU;
    }

    public String drC() {
        if (this.miV == null) {
            this.miV = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.mbN);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.mbN + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.miV.add(str);
        return str;
    }

    public void drD() {
        if (this.miV != null && this.miV.size() != 0) {
            String remove = this.miV.remove(this.miV.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String drE() {
        File file = new File(com.baidu.tieba.video.c.mbN);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mgb = com.baidu.tieba.video.c.mbN + "f_" + System.currentTimeMillis() + ".mp4";
        return this.mgb;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.miW != null && motionEvent.getAction() == 0) {
            this.miW.drQ();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.drP();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.miW = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cXV && x >= com.baidu.adp.lib.util.l.getDimens(this.miN, R.dimen.ds60)) {
                    int width = this.miO.getWidth();
                    int height = this.miO.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cXV - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.miQ == null) {
                            this.miQ = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.miQ.getChildCount()) {
                                if (this.miP != this.miQ.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.miQ.removeViewAt(i);
                                }
                            }
                        }
                        this.miP = new a(this.miN, clamp - (width / 2), clamp2 - (height / 2), this.miO);
                        this.miQ.addView(this.miP, new ViewGroup.LayoutParams(-2, -2));
                        dk(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.drP();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void drF() {
        int i;
        int i2;
        if (this.mCamera == null && this.miN != null) {
            this.miN.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.miN.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.miN.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.miT.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.miU != null) {
                this.miU.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.miT.setPreviewFormat(17);
        drG();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.miN, this.mCameraId));
        this.miR = this.miT.getSupportedFocusModes();
        if (this.miR != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.miR.contains("continuous-picture")) {
                this.miT.setFocusMode("continuous-picture");
            } else if (this.miR.contains("continuous-video")) {
                this.miT.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.miT);
        if (this.miN != null && this.miN.dsg() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bGA.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.bGA.setLayoutParams(layoutParams);
            this.bGA.invalidate();
            if (this.miZ != null) {
                this.miZ.dl(layoutParams.width, layoutParams.height);
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

    private void drG() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.miT.getSupportedPreviewFpsRange()) {
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
        this.miT.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void vX(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.vT(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.vT(z)) {
                    drJ();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.vU(z);
            if (-1 != this.mCameraId) {
                drI();
                this.miX = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                drJ();
            }
        } catch (Exception e) {
            e.printStackTrace();
            drJ();
            if (this.lOt != null) {
                this.lOt.bp(8, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b drH() {
        return this.miX;
    }

    private void drI() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.miT = this.mCamera.getParameters();
            drF();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.s(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void drJ() {
        if (this.miN != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.miN.getPageContext().getPageActivity());
            aVar.ln(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.miN != null) {
                        h.this.miN.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.hJ(true);
            aVar.b(this.miN.getPageContext());
            aVar.aYL();
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
                if (this.lOt != null) {
                    this.lOt.bp(6, com.baidu.tieba.k.a.s(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void drK() {
        try {
            if (this.mCamera != null) {
                if (this.miT == null) {
                    this.miT = this.mCamera.getParameters();
                }
                if ("off".equals(this.miT.getFlashMode())) {
                    this.miT.setFlashMode("torch");
                } else {
                    this.miT.setFlashMode("off");
                }
                this.mCamera.setParameters(this.miT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lOt != null) {
                this.lOt.bp(7, com.baidu.tieba.k.a.s(e));
            }
        }
    }

    public boolean drL() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.miT == null) {
                this.miT = this.mCamera.getParameters();
            }
            return !"off".equals(this.miT.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lOt != null) {
                this.lOt.bp(7, com.baidu.tieba.k.a.s(e));
                return false;
            }
            return false;
        }
    }

    public void drM() {
        if (this.bGA != null && (this.bGA instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.bGA;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dru();
            this.miS = this.miS == 0 ? 1 : 0;
            vX(this.miS == 1);
            gLVideoPreviewView.drv();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.bGA != null && (this.bGA instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bGA).h(this.mCamera);
            releaseCamera();
            this.miS = this.miS == 0 ? 1 : 0;
            vX(this.miS == 1);
            startPreview();
        }
    }

    public boolean drN() {
        return this.miS == 1;
    }

    private void drO() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drP() {
        if (this.miQ != null && this.miP != null && this.miP.getParent() != null) {
            this.miQ.removeView(this.miP);
        }
    }

    private void dk(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.miR.contains("auto")) {
                this.miT = this.mCamera.getParameters();
                this.miT.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.miT);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.lOt != null) {
                this.lOt.bp(9, com.baidu.tieba.k.a.s(e));
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
        if (this.bGA instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bGA).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.bGA instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bGA).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.bGA instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.bGA).setSticker(stickerItem);
        }
    }

    public void onResume() {
        vX(this.miS == 1);
        if (this.bGA != null && (this.bGA instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bGA).onResume();
        }
        if (this.bGA != null && (this.bGA instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.bGA).onResume();
        }
        if (!com.baidu.tieba.video.record.c.drp()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.miU.h(this.mCamera);
        if (this.bGA != null && (this.bGA instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.bGA).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.miZ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.mit = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.miU instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.miU != null) {
                        h.this.miU.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.miU.a(aVar);
        }
    }

    public boolean drz() {
        return this.mCameraId == 0;
    }
}
