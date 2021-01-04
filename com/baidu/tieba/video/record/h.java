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
/* loaded from: classes8.dex */
public class h {
    private SurfaceView cva;
    private int dXO;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    protected String nJo;
    private GLVideoPreviewView.a nKR;
    private RecordVideoActivity nLl;
    private Bitmap nLm;
    private a nLn;
    private FrameLayout nLo;
    private List<String> nLp;
    private g nLs;
    protected List<String> nLt;
    private b nLu;
    private com.baidu.tieba.video.record.b nLv;
    private GLVideoPreviewView.a nLw;
    private c nLx;
    private com.baidu.tieba.l.g nsP;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nLq = 0;
    private Camera.Parameters nLr = null;

    /* loaded from: classes8.dex */
    public interface b {
        void dVH();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void dC(int i, int i2);
    }

    public void aq(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jI(false);
        aVar.oZ(R.string.request_permission_default_title);
        aVar.pa(R.string.request_permission_camera);
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
        }).b(com.baidu.adp.base.j.K(activity));
        aVar.btX();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nsP = kVar.diP();
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
                        if (h.this.nLl != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aq(h.this.nLl);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nLl, R.string.disallow_camera_permission);
                            if (h.this.nsP != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nLl.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.nsP.bD(1, string);
                            }
                            h.this.nLl.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nLl != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nLl, R.string.disallow_audio_record_permission);
                            if (h.this.nsP != null) {
                                h.this.nsP.bD(2, h.this.nLl.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nLl.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nLw = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yP(final boolean z) {
                if (h.this.nKR != null) {
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nKR.yP(z);
                        }
                    });
                }
            }
        };
        this.nLl = recordVideoActivity;
        dVF();
        this.nLm = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dXO = displayMetrics.heightPixels;
        this.nLo = this.nLl.dVY();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.cva = gLVideoPreviewView;
            this.nLs = gLVideoPreviewView;
            ((GLVideoPreviewView) this.cva).setFaceIdentifyStateListener(this.nLw);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.cva = videoPreviewView;
            this.nLs = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dVY() != null) {
            recordVideoActivity.dVY().addView(this.cva, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nLs.e(this.mCamera);
    }

    public void startRecord() {
        this.nLs.f(this.mCamera);
    }

    public void stopRecord() {
        this.nLs.g(this.mCamera);
    }

    public g dVs() {
        return this.nLs;
    }

    public String dVt() {
        if (this.nLt == null) {
            this.nLt = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nFh);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nFh + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nLt.add(str);
        return str;
    }

    public void dVu() {
        if (this.nLt != null && this.nLt.size() != 0) {
            String remove = this.nLt.remove(this.nLt.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dVv() {
        File file = new File(com.baidu.tieba.video.c.nFh);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nJo = com.baidu.tieba.video.c.nFh + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nJo;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nLu != null && motionEvent.getAction() == 0) {
            this.nLu.dVH();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dVG();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nLu = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dXO && x >= com.baidu.adp.lib.util.l.getDimens(this.nLl, R.dimen.ds60)) {
                    int width = this.nLm.getWidth();
                    int height = this.nLm.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dXO - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nLo == null) {
                            this.nLo = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nLo.getChildCount()) {
                                if (this.nLn != this.nLo.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nLo.removeViewAt(i);
                                }
                            }
                        }
                        this.nLn = new a(this.nLl, clamp - (width / 2), clamp2 - (height / 2), this.nLm);
                        this.nLo.addView(this.nLn, new ViewGroup.LayoutParams(-2, -2));
                        dB(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dVG();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dVw() {
        int i;
        if (this.mCamera == null && this.nLl != null) {
            this.nLl.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nLl.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nLl.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.nLr.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nLs != null) {
                this.nLs.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nLr.setPreviewFormat(17);
        dVx();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nLl, this.mCameraId));
        this.nLp = this.nLr.getSupportedFocusModes();
        if (this.nLp != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nLp.contains("continuous-picture")) {
                this.nLr.setFocusMode("continuous-picture");
            } else if (this.nLp.contains("continuous-video")) {
                this.nLr.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nLr);
        if (this.nLl != null && this.nLl.dVY() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = (int) (equipmentWidth / f2);
            } else {
                equipmentWidth = (int) (screenHeight * f2);
                i = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cva.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = i;
            this.cva.setLayoutParams(layoutParams);
            this.cva.invalidate();
            if (this.nLx != null) {
                this.nLx.dC(layoutParams.width, layoutParams.height);
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

    private void dVx() {
        int[] iArr = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : this.nLr.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr2[1]) > i2 || Math.abs(15000 - iArr2[0]) > i) {
                iArr2 = iArr;
            } else {
                i2 = Math.abs(20000 - iArr2[1]);
                i = Math.abs(15000 - iArr2[0]);
            }
            iArr = iArr2;
        }
        this.nLr.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public void yQ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.yM(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.yM(z)) {
                    dVA();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yN(z);
            if (-1 != this.mCameraId) {
                dVz();
                this.nLv = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dVA();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dVA();
            if (this.nsP != null) {
                this.nsP.bD(8, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dVy() {
        return this.nLv;
    }

    private void dVz() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nLr = this.mCamera.getParameters();
            dVw();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dVA() {
        if (this.nLl != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nLl.getPageContext().getPageActivity());
            aVar.pa(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nLl != null) {
                        h.this.nLl.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.jH(true);
            aVar.b(this.nLl.getPageContext());
            aVar.btX();
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
                if (this.nsP != null) {
                    this.nsP.bD(6, com.baidu.tieba.l.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dVB() {
        try {
            if (this.mCamera != null) {
                if (this.nLr == null) {
                    this.nLr = this.mCamera.getParameters();
                }
                if ("off".equals(this.nLr.getFlashMode())) {
                    this.nLr.setFlashMode("torch");
                } else {
                    this.nLr.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nLr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsP != null) {
                this.nsP.bD(7, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public boolean dVC() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nLr == null) {
                this.nLr = this.mCamera.getParameters();
            }
            return !"off".equals(this.nLr.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsP != null) {
                this.nsP.bD(7, com.baidu.tieba.l.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void dVD() {
        if (this.cva != null && (this.cva instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.cva;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dVl();
            this.nLq = this.nLq == 0 ? 1 : 0;
            yQ(this.nLq == 1);
            gLVideoPreviewView.dVm();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.cva != null && (this.cva instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cva).h(this.mCamera);
            releaseCamera();
            this.nLq = this.nLq == 0 ? 1 : 0;
            yQ(this.nLq == 1);
            startPreview();
        }
    }

    public boolean dVE() {
        return this.nLq == 1;
    }

    private void dVF() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVG() {
        if (this.nLo != null && this.nLn != null && this.nLn.getParent() != null) {
            this.nLo.removeView(this.nLn);
        }
    }

    private void dB(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nLp.contains("auto")) {
                this.nLr = this.mCamera.getParameters();
                this.nLr.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nLr);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsP != null) {
                this.nsP.bD(9, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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
        if (this.cva instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cva).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.cva instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cva).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.cva instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.cva).setSticker(stickerItem);
        }
    }

    public void onResume() {
        yQ(this.nLq == 1);
        if (this.cva != null && (this.cva instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cva).onResume();
        }
        if (this.cva != null && (this.cva instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cva).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dVg()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nLs.h(this.mCamera);
        if (this.cva != null && (this.cva instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cva).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nLx = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nKR = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nLs instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nLs != null) {
                        h.this.nLs.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nLs.a(aVar);
        }
    }

    public boolean dVq() {
        return this.mCameraId == 0;
    }
}
