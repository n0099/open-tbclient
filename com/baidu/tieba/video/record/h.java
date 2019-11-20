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
    protected boolean awI;
    private int dLc;
    private GLVideoPreviewView.a jCF;
    private RecordVideoActivity jCZ;
    private Bitmap jDa;
    private a jDb;
    private FrameLayout jDc;
    private List<String> jDd;
    private g jDg;
    private SurfaceView jDh;
    protected List<String> jDi;
    private b jDj;
    private com.baidu.tieba.video.record.b jDk;
    private GLVideoPreviewView.a jDl;
    private c jDm;
    private com.baidu.tieba.j.h jiP;
    protected String jxP;
    private Camera mCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int jDe = 0;
    private Camera.Parameters jDf = null;

    /* loaded from: classes5.dex */
    public interface b {
        void cvb();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cy(int i, int i2);
    }

    public void ac(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.eh(false);
        aVar.hS(R.string.request_permission_default_title);
        aVar.hT(R.string.request_permission_camera);
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
        aVar.akM();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
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
                        if (h.this.jCZ != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.ac(h.this.jCZ);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.jCZ, (int) R.string.disallow_camera_permission);
                            if (h.this.jiP != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.jCZ.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.jiP.au(1, string);
                            }
                            h.this.jCZ.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.jCZ != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.jCZ, (int) R.string.disallow_audio_record_permission);
                            if (h.this.jiP != null) {
                                h.this.jiP.au(2, h.this.jCZ.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.jCZ.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jDl = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void ry(final boolean z) {
                if (h.this.jCF != null) {
                    com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.jCF.ry(z);
                        }
                    });
                }
            }
        };
        this.jCZ = recordVideoActivity;
        cuZ();
        this.jDa = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dLc = displayMetrics.heightPixels;
        this.jDc = this.jCZ.cvt();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.jDh = gLVideoPreviewView;
            this.jDg = gLVideoPreviewView;
            ((GLVideoPreviewView) this.jDh).setFaceIdentifyStateListener(this.jDl);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.jDh = videoPreviewView;
            this.jDg = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cvt() != null) {
            recordVideoActivity.cvt().addView(this.jDh, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.jDg.e(this.mCamera);
    }

    public void startRecord() {
        this.jDg.f(this.mCamera);
    }

    public void stopRecord() {
        this.jDg.g(this.mCamera);
    }

    public g cuM() {
        return this.jDg;
    }

    public String cuN() {
        if (this.jDi == null) {
            this.jDi = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.jwd);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.jwd + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.jDi.add(str);
        return str;
    }

    public void cuO() {
        if (this.jDi != null && this.jDi.size() != 0) {
            String remove = this.jDi.remove(this.jDi.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cuP() {
        File file = new File(com.baidu.tieba.video.c.jwd);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.jxP = com.baidu.tieba.video.c.jwd + "f_" + System.currentTimeMillis() + ".mp4";
        return this.jxP;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.jDj != null && motionEvent.getAction() == 0) {
            this.jDj.cvb();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cva();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.jDj = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dLc && x >= com.baidu.adp.lib.util.l.getDimens(this.jCZ, R.dimen.ds60)) {
                    int width = this.jDa.getWidth();
                    int height = this.jDa.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dLc - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.jDc == null) {
                            this.jDc = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.jDc.getChildCount()) {
                                if (this.jDb != this.jDc.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.jDc.removeViewAt(i);
                                }
                            }
                        }
                        this.jDb = new a(this.jCZ, clamp - (width / 2), clamp2 - (height / 2), this.jDa);
                        this.jDc.addView(this.jDb, new ViewGroup.LayoutParams(-2, -2));
                        cx(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cva();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cuQ() {
        int i;
        int i2;
        if (this.mCamera == null && this.jCZ != null) {
            this.jCZ.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jCZ.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.jCZ.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.jDf.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.jDg != null) {
                this.jDg.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.jDf.setPreviewFormat(17);
        cuR();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.f(this.jCZ, this.mCameraId));
        this.jDd = this.jDf.getSupportedFocusModes();
        if (this.jDd != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.jDd.contains("continuous-picture")) {
                this.jDf.setFocusMode("continuous-picture");
            } else if (this.jDd.contains("continuous-video")) {
                this.jDf.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.jDf);
        if (this.jCZ != null && this.jCZ.cvt() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jDh.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.jDh.setLayoutParams(layoutParams);
            this.jDh.invalidate();
            if (this.jDm != null) {
                this.jDm.cy(layoutParams.width, layoutParams.height);
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

    private void cuR() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.jDf.getSupportedPreviewFpsRange()) {
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
        this.jDf.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void rz(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.rv(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.rv(z)) {
                    cuU();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.rw(z);
            if (-1 != this.mCameraId) {
                cuT();
                this.jDk = new com.baidu.tieba.video.record.b(this.mCamera);
                this.awI = z;
            } else {
                cuU();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cuU();
            if (this.jiP != null) {
                this.jiP.au(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cuS() {
        return this.jDk;
    }

    private void cuT() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.jDf = this.mCamera.getParameters();
            cuQ();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cuU() {
        if (this.jCZ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jCZ.getPageContext().getPageActivity());
            aVar.hT(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.jCZ != null) {
                        h.this.jCZ.finish();
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
            aVar.b(this.jCZ.getPageContext());
            aVar.akM();
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
                if (this.jiP != null) {
                    this.jiP.au(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cuV() {
        try {
            if (this.mCamera != null) {
                if (this.jDf == null) {
                    this.jDf = this.mCamera.getParameters();
                }
                if ("off".equals(this.jDf.getFlashMode())) {
                    this.jDf.setFlashMode("torch");
                } else {
                    this.jDf.setFlashMode("off");
                }
                this.mCamera.setParameters(this.jDf);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jiP != null) {
                this.jiP.au(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean cuW() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.jDf == null) {
                this.jDf = this.mCamera.getParameters();
            }
            return !"off".equals(this.jDf.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jiP != null) {
                this.jiP.au(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void cuX() {
        if (this.jDh != null && (this.jDh instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.jDh;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cuF();
            this.jDe = this.jDe == 0 ? 1 : 0;
            rz(this.jDe == 1);
            gLVideoPreviewView.cuG();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.jDh != null && (this.jDh instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jDh).h(this.mCamera);
            releaseCamera();
            this.jDe = this.jDe == 0 ? 1 : 0;
            rz(this.jDe == 1);
            startPreview();
        }
    }

    public boolean cuY() {
        return this.jDe == 1;
    }

    private void cuZ() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cva() {
        if (this.jDc != null && this.jDb != null && this.jDb.getParent() != null) {
            this.jDc.removeView(this.jDb);
        }
    }

    private void cx(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.jDd.contains("auto")) {
                this.jDf = this.mCamera.getParameters();
                this.jDf.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.jDf);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.jiP != null) {
                this.jiP.au(9, com.baidu.tieba.j.a.o(e));
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
        if (this.jDh instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jDh).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.jDh instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jDh).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.jDh instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.jDh).setSticker(stickerItem);
        }
    }

    public void onResume() {
        rz(this.jDe == 1);
        if (this.jDh != null && (this.jDh instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jDh).onResume();
        }
        if (this.jDh != null && (this.jDh instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.jDh).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cuA()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.jDg.h(this.mCamera);
        if (this.jDh != null && (this.jDh instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.jDh).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.jDm = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.jCF = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.jDg instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.jDg != null) {
                        h.this.jDg.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.jDg.a(aVar);
        }
    }

    public boolean cuK() {
        return this.mCameraId == 0;
    }
}
