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
    protected String nJn;
    private GLVideoPreviewView.a nKQ;
    private RecordVideoActivity nLk;
    private Bitmap nLl;
    private a nLm;
    private FrameLayout nLn;
    private List<String> nLo;
    private g nLr;
    protected List<String> nLs;
    private b nLt;
    private com.baidu.tieba.video.record.b nLu;
    private GLVideoPreviewView.a nLv;
    private c nLw;
    private com.baidu.tieba.l.g nsO;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int nLp = 0;
    private Camera.Parameters nLq = null;

    /* loaded from: classes8.dex */
    public interface b {
        void dVI();
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
        aVar.btY();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nsO = kVar.diQ();
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
                        if (h.this.nLk != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aq(h.this.nLk);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.nLk, R.string.disallow_camera_permission);
                            if (h.this.nsO != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.nLk.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.nsO.bD(1, string);
                            }
                            h.this.nLk.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.nLk != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.nLk, R.string.disallow_audio_record_permission);
                            if (h.this.nsO != null) {
                                h.this.nsO.bD(2, h.this.nLk.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.nLk.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.nLv = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void yP(final boolean z) {
                if (h.this.nKQ != null) {
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.nKQ.yP(z);
                        }
                    });
                }
            }
        };
        this.nLk = recordVideoActivity;
        dVG();
        this.nLl = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dXO = displayMetrics.heightPixels;
        this.nLn = this.nLk.dVZ();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.cva = gLVideoPreviewView;
            this.nLr = gLVideoPreviewView;
            ((GLVideoPreviewView) this.cva).setFaceIdentifyStateListener(this.nLv);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.cva = videoPreviewView;
            this.nLr = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.dVZ() != null) {
            recordVideoActivity.dVZ().addView(this.cva, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.nLr.e(this.mCamera);
    }

    public void startRecord() {
        this.nLr.f(this.mCamera);
    }

    public void stopRecord() {
        this.nLr.g(this.mCamera);
    }

    public g dVt() {
        return this.nLr;
    }

    public String dVu() {
        if (this.nLs == null) {
            this.nLs = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.nFg);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.nFg + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.nLs.add(str);
        return str;
    }

    public void dVv() {
        if (this.nLs != null && this.nLs.size() != 0) {
            String remove = this.nLs.remove(this.nLs.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String dVw() {
        File file = new File(com.baidu.tieba.video.c.nFg);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.nJn = com.baidu.tieba.video.c.nFg + "f_" + System.currentTimeMillis() + ".mp4";
        return this.nJn;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.nLt != null && motionEvent.getAction() == 0) {
            this.nLt.dVI();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.dVH();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.nLt = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dXO && x >= com.baidu.adp.lib.util.l.getDimens(this.nLk, R.dimen.ds60)) {
                    int width = this.nLl.getWidth();
                    int height = this.nLl.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dXO - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.nLn == null) {
                            this.nLn = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.nLn.getChildCount()) {
                                if (this.nLm != this.nLn.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.nLn.removeViewAt(i);
                                }
                            }
                        }
                        this.nLm = new a(this.nLk, clamp - (width / 2), clamp2 - (height / 2), this.nLl);
                        this.nLn.addView(this.nLm, new ViewGroup.LayoutParams(-2, -2));
                        dB(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.dVH();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void dVx() {
        int i;
        if (this.mCamera == null && this.nLk != null) {
            this.nLk.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.nLk.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.nLk.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (a2 != null) {
            this.previewWidth = a2.width;
            this.previewHeight = a2.height;
            this.nLq.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.nLr != null) {
                this.nLr.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.nLq.setPreviewFormat(17);
        dVy();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.determineDisplayOrientation(this.nLk, this.mCameraId));
        this.nLo = this.nLq.getSupportedFocusModes();
        if (this.nLo != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.nLo.contains("continuous-picture")) {
                this.nLq.setFocusMode("continuous-picture");
            } else if (this.nLo.contains("continuous-video")) {
                this.nLq.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.nLq);
        if (this.nLk != null && this.nLk.dVZ() != null) {
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
            if (this.nLw != null) {
                this.nLw.dC(layoutParams.width, layoutParams.height);
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

    private void dVy() {
        int[] iArr = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : this.nLq.getSupportedPreviewFpsRange()) {
            if (Math.abs(20000 - iArr2[1]) > i2 || Math.abs(15000 - iArr2[0]) > i) {
                iArr2 = iArr;
            } else {
                i2 = Math.abs(20000 - iArr2[1]);
                i = Math.abs(15000 - iArr2[0]);
            }
            iArr = iArr2;
        }
        this.nLq.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public void yQ(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.yM(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.yM(z)) {
                    dVB();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.yN(z);
            if (-1 != this.mCameraId) {
                dVA();
                this.nLu = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                dVB();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dVB();
            if (this.nsO != null) {
                this.nsO.bD(8, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b dVz() {
        return this.nLu;
    }

    private void dVA() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.nLq = this.mCamera.getParameters();
            dVx();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.l.a.p(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void dVB() {
        if (this.nLk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nLk.getPageContext().getPageActivity());
            aVar.pa(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.nLk != null) {
                        h.this.nLk.finish();
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
            aVar.b(this.nLk.getPageContext());
            aVar.btY();
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
                if (this.nsO != null) {
                    this.nsO.bD(6, com.baidu.tieba.l.a.p(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void dVC() {
        try {
            if (this.mCamera != null) {
                if (this.nLq == null) {
                    this.nLq = this.mCamera.getParameters();
                }
                if ("off".equals(this.nLq.getFlashMode())) {
                    this.nLq.setFlashMode("torch");
                } else {
                    this.nLq.setFlashMode("off");
                }
                this.mCamera.setParameters(this.nLq);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsO != null) {
                this.nsO.bD(7, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public boolean dVD() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.nLq == null) {
                this.nLq = this.mCamera.getParameters();
            }
            return !"off".equals(this.nLq.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsO != null) {
                this.nsO.bD(7, com.baidu.tieba.l.a.p(e));
                return false;
            }
            return false;
        }
    }

    public void dVE() {
        if (this.cva != null && (this.cva instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.cva;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.dVm();
            this.nLp = this.nLp == 0 ? 1 : 0;
            yQ(this.nLp == 1);
            gLVideoPreviewView.dVn();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.cva != null && (this.cva instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cva).h(this.mCamera);
            releaseCamera();
            this.nLp = this.nLp == 0 ? 1 : 0;
            yQ(this.nLp == 1);
            startPreview();
        }
    }

    public boolean dVF() {
        return this.nLp == 1;
    }

    private void dVG() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVH() {
        if (this.nLn != null && this.nLm != null && this.nLm.getParent() != null) {
            this.nLn.removeView(this.nLm);
        }
    }

    private void dB(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.nLo.contains("auto")) {
                this.nLq = this.mCamera.getParameters();
                this.nLq.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.nLq);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsO != null) {
                this.nsO.bD(9, com.baidu.tieba.l.a.p(e));
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
        yQ(this.nLp == 1);
        if (this.cva != null && (this.cva instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cva).onResume();
        }
        if (this.cva != null && (this.cva instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.cva).onResume();
        }
        if (!com.baidu.tieba.video.record.c.dVh()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.nLr.h(this.mCamera);
        if (this.cva != null && (this.cva instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.cva).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.nLw = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.nKQ = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.nLr instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.nLr != null) {
                        h.this.nLr.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.nLr.a(aVar);
        }
    }

    public boolean dVr() {
        return this.mCameraId == 0;
    }
}
