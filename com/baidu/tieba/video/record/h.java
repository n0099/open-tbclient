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
/* loaded from: classes5.dex */
public class h {
    protected boolean axa;
    private int dLT;
    private RecordVideoActivity jDQ;
    private Bitmap jDR;
    private a jDS;
    private FrameLayout jDT;
    private List<String> jDU;
    private g jDX;
    private SurfaceView jDY;
    protected List<String> jDZ;
    private GLVideoPreviewView.a jDw;
    private b jEa;
    private com.baidu.tieba.video.record.b jEb;
    private GLVideoPreviewView.a jEc;
    private c jEd;
    private com.baidu.tieba.j.h jjG;
    protected String jyG;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jDV = 0;
    private Camera.Parameters jDW = null;

    /* loaded from: classes5.dex */
    public interface b {
        void cvd();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cA(int i, int i2);
    }

    public void ac(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.eh(false);
        aVar.hT(R.string.request_permission_default_title);
        aVar.hU(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.i.ab(activity));
        aVar.akO();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjG = lVar.bMY();
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
                        if (h.this.jDQ != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ac(h.this.jDQ);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jDQ, (int) R.string.disallow_camera_permission);
                            if (h.this.jjG != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jDQ.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.jjG.av(1, string);
                            }
                            h.this.jDQ.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jDQ != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jDQ, (int) R.string.disallow_audio_record_permission);
                            if (h.this.jjG != null) {
                                h.this.jjG.av(2, h.this.jDQ.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.jDQ.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jEc = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void ry(final boolean z) {
                if (h.this.jDw != null) {
                    com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jDw.ry(z);
                        }
                    });
                }
            }
        };
        this.jDQ = recordVideoActivity;
        cvb();
        this.jDR = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dLT = displayMetrics.heightPixels;
        this.jDT = this.jDQ.cvv();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jDY = gLVideoPreviewView;
            this.jDX = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jDY).setFaceIdentifyStateListener(this.jEc);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jDY = videoPreviewView;
            this.jDX = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cvv() != null) {
            recordVideoActivity.cvv().addView(this.jDY, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jDX.e(this.mCamera);
    }

    public void startRecord() {
        this.jDX.f(this.mCamera);
    }

    public void stopRecord() {
        this.jDX.g(this.mCamera);
    }

    public g cuO() {
        return this.jDX;
    }

    public String cuP() {
        if (this.jDZ == null) {
            this.jDZ = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.jwU);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.jwU + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jDZ.add(str);
        return str;
    }

    public void cuQ() {
        if (this.jDZ != null && this.jDZ.size() != 0) {
            String remove = this.jDZ.remove(this.jDZ.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cuR() {
        File file = new File(com.baidu.tieba.video.c.jwU);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.jyG = com.baidu.tieba.video.c.jwU + "f_" + System.currentTimeMillis() + ".mp4";
        return this.jyG;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jEa != null && motionEvent.getAction() == 0) {
            this.jEa.cvd();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cvc();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jEa = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dLT && x >= com.baidu.adp.lib.util.l.getDimens(this.jDQ, R.dimen.ds60)) {
                    int width = this.jDR.getWidth();
                    int height = this.jDR.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dLT - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jDT == null) {
                            this.jDT = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jDT.getChildCount()) {
                                if (this.jDS != this.jDT.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jDT.removeViewAt(i);
                                }
                            }
                        }
                        this.jDS = new a(this.jDQ, clamp - (width / 2), clamp2 - (height / 2), this.jDR);
                        this.jDT.addView(this.jDS, new ViewGroup.LayoutParams(-2, -2));
                        cz(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cvc();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cuS() {
        int i;
        int i2;
        if (this.mCamera == null && this.jDQ != null) {
            this.jDQ.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jDQ.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jDQ.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jDW.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jDX != null) {
                this.jDX.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jDW.setPreviewFormat(17);
        cuT();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.f(this.jDQ, this.mCameraId));
        this.jDU = this.jDW.getSupportedFocusModes();
        if (this.jDU != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jDU.contains("continuous-picture")) {
                this.jDW.setFocusMode("continuous-picture");
            } else if (this.jDU.contains("continuous-video")) {
                this.jDW.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jDW);
        if (this.jDQ != null && this.jDQ.cvv() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jDY.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jDY.setLayoutParams(layoutParams);
            this.jDY.invalidate();
            if (this.jEd != null) {
                this.jEd.cA(layoutParams.width, layoutParams.height);
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

    private void cuT() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jDW.getSupportedPreviewFpsRange()) {
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
        this.jDW.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void rz(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.rv(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.rv(z)) {
                    cuW();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.rw(z);
            if (-1 != this.mCameraId) {
                cuV();
                this.jEb = new com.baidu.tieba.video.record.b(this.mCamera);
                this.axa = z;
            } else {
                cuW();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cuW();
            if (this.jjG != null) {
                this.jjG.av(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cuU() {
        return this.jEb;
    }

    private void cuV() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jDW = this.mCamera.getParameters();
            cuS();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cuW() {
        if (this.jDQ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jDQ.getPageContext().getPageActivity());
            aVar.hU(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jDQ != null) {
                        h.this.jDQ.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.eg(true);
            aVar.b(this.jDQ.getPageContext());
            aVar.akO();
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
                if (this.jjG != null) {
                    this.jjG.av(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cuX() {
        try {
            if (this.mCamera != null) {
                if (this.jDW == null) {
                    this.jDW = this.mCamera.getParameters();
                }
                if ("off".equals(this.jDW.getFlashMode())) {
                    this.jDW.setFlashMode("torch");
                } else {
                    this.jDW.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jDW);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jjG != null) {
                this.jjG.av(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean cuY() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jDW == null) {
                this.jDW = this.mCamera.getParameters();
            }
            return !"off".equals(this.jDW.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jjG != null) {
                this.jjG.av(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void cuZ() {
        if (this.jDY != null && (this.jDY instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jDY;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cuH();
            this.jDV = this.jDV == 0 ? 1 : 0;
            rz(this.jDV == 1);
            gLVideoPreviewView.cuI();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jDY != null && (this.jDY instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jDY).h(this.mCamera);
            releaseCamera();
            this.jDV = this.jDV == 0 ? 1 : 0;
            rz(this.jDV == 1);
            startPreview();
        }
    }

    public boolean cva() {
        return this.jDV == 1;
    }

    private void cvb() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvc() {
        if (this.jDT != null && this.jDS != null && this.jDS.getParent() != null) {
            this.jDT.removeView(this.jDS);
        }
    }

    private void cz(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jDU.contains("auto")) {
                this.jDW = this.mCamera.getParameters();
                this.jDW.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jDW);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jjG != null) {
                this.jjG.av(9, com.baidu.tieba.j.a.o(e));
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
        if (this.jDY instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jDY).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jDY instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jDY).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jDY instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jDY).setSticker(stickerItem);
        }
    }

    public void onResume() {
        rz(this.jDV == 1);
        if (this.jDY != null && (this.jDY instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jDY).onResume();
        }
        if (this.jDY != null && (this.jDY instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jDY).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cuC()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jDX.h(this.mCamera);
        if (this.jDY != null && (this.jDY instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jDY).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jEd = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jDw = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jDX instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jDX != null) {
                        h.this.jDX.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jDX.a(aVar);
        }
    }

    public boolean cuM() {
        return this.mCameraId == 0;
    }
}
