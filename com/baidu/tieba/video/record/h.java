package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.f;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private int dCG;
    private int ddU;
    private int ddV;
    private com.baidu.tieba.j.h gPa;
    protected String hdq;
    private RecordVideoActivity hiL;
    private Bitmap hiM;
    private a hiN;
    private FrameLayout hiO;
    private List<String> hiP;
    protected boolean hiQ;
    private g hiT;
    private SurfaceView hiU;
    protected List<String> hiV;
    private b hiW;
    private com.baidu.tieba.video.record.b hiX;
    private GLVideoPreviewView.a hiY;
    private c hiZ;
    private GLVideoPreviewView.a hir;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hiR = 0;
    private Camera.Parameters hiS = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bCJ();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bR(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
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
                        if (h.this.hiL != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hiL, f.j.disallow_camera_permission);
                            if (h.this.gPa != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hiL.getResources().getString(f.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gPa.ab(1, string);
                            }
                            h.this.hiL.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hiL != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hiL, f.j.disallow_audio_record_permission);
                            if (h.this.gPa != null) {
                                h.this.gPa.ab(2, h.this.hiL.getResources().getString(f.j.disallow_audio_record_permission));
                            }
                            h.this.hiL.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiY = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void na(final boolean z) {
                if (h.this.hir != null) {
                    com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hir.na(z);
                        }
                    });
                }
            }
        };
        this.hiL = recordVideoActivity;
        bCH();
        this.hiM = BitmapFactory.decodeResource(recordVideoActivity.getResources(), f.C0146f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dCG = displayMetrics.heightPixels;
        this.hiO = this.hiL.bCZ();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hiU = gLVideoPreviewView;
            this.hiT = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hiU).setFaceIdentifyStateListener(this.hiY);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hiU = videoPreviewView;
            this.hiT = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bCZ() != null) {
            recordVideoActivity.bCZ().addView(this.hiU, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hiT.e(this.mCamera);
    }

    public void startRecord() {
        this.hiT.f(this.mCamera);
    }

    public void stopRecord() {
        this.hiT.g(this.mCamera);
    }

    public g bCu() {
        return this.hiT;
    }

    public String bCv() {
        if (this.hiV == null) {
            this.hiV = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hbE);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hbE + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hiV.add(str);
        return str;
    }

    public void bCw() {
        if (this.hiV != null && this.hiV.size() != 0) {
            String remove = this.hiV.remove(this.hiV.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bCx() {
        File file = new File(com.baidu.tieba.video.c.hbE);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hdq = com.baidu.tieba.video.c.hbE + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hdq;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hiW != null && motionEvent.getAction() == 0) {
            this.hiW.bCJ();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bCI();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hiW = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dCG && x >= com.baidu.adp.lib.util.l.f(this.hiL, f.e.ds60)) {
                    int width = this.hiM.getWidth();
                    int height = this.hiM.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dCG - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hiO == null) {
                            this.hiO = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hiO.getChildCount()) {
                                if (this.hiN != this.hiO.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hiO.removeViewAt(i);
                                }
                            }
                        }
                        this.hiN = new a(this.hiL, clamp - (width / 2), clamp2 - (height / 2), this.hiM);
                        this.hiO.addView(this.hiN, new ViewGroup.LayoutParams(-2, -2));
                        bQ(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bCI();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bCy() {
        int i;
        int i2;
        if (this.mCamera == null && this.hiL != null) {
            this.hiL.finish();
            return;
        }
        int ah = com.baidu.adp.lib.util.l.ah(this.hiL.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hiL.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / ah)));
        if (a2 != null) {
            this.ddU = a2.width;
            this.ddV = a2.height;
            this.hiS.setPreviewSize(this.ddU, this.ddV);
            if (this.hiT != null) {
                this.hiT.setPreviewSize(this.ddU, this.ddV);
            }
        }
        this.hiS.setPreviewFormat(17);
        bCz();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hiL, this.mCameraId));
        this.hiP = this.hiS.getSupportedFocusModes();
        if (this.hiP != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hiP.contains("continuous-picture")) {
                this.hiS.setFocusMode("continuous-picture");
            } else if (this.hiP.contains("continuous-video")) {
                this.hiS.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hiS);
        if (this.hiL != null && this.hiL.bCZ() != null) {
            float f = (ah * 1.0f) / screenHeight;
            float f2 = (this.ddV * 1.0f) / this.ddU;
            if (f > f2) {
                i = ah;
                i2 = (int) (ah / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiU.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hiU.setLayoutParams(layoutParams);
            this.hiU.invalidate();
            if (this.hiZ != null) {
                this.hiZ.bR(layoutParams.width, layoutParams.height);
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
            return com.baidu.adp.lib.util.l.aj(context);
        }
        return i;
    }

    private void bCz() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hiS.getSupportedPreviewFpsRange()) {
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
        this.hiS.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nb(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.mX(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.mX(z)) {
                    bCC();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.mY(z);
            if (-1 != this.mCameraId) {
                bCB();
                this.hiX = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hiQ = z;
            } else {
                bCC();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bCC();
            if (this.gPa != null) {
                this.gPa.ab(8, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bCA() {
        return this.hiX;
    }

    private void bCB() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hiS = this.mCamera.getParameters();
            bCy();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.m(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bCC() {
        if (this.hiL != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hiL.getPageContext().getPageActivity());
            aVar.cf(f.j.video_quit_confirm);
            aVar.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hiL != null) {
                        h.this.hiL.finish();
                    }
                }
            });
            aVar.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.av(true);
            aVar.b(this.hiL.getPageContext());
            aVar.xe();
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
                if (this.gPa != null) {
                    this.gPa.ab(6, com.baidu.tieba.j.a.m(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bCD() {
        try {
            if (this.mCamera != null) {
                if (this.hiS == null) {
                    this.hiS = this.mCamera.getParameters();
                }
                if ("off".equals(this.hiS.getFlashMode())) {
                    this.hiS.setFlashMode("torch");
                } else {
                    this.hiS.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hiS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gPa != null) {
                this.gPa.ab(7, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public boolean bCE() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hiS == null) {
                this.hiS = this.mCamera.getParameters();
            }
            return !"off".equals(this.hiS.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gPa != null) {
                this.gPa.ab(7, com.baidu.tieba.j.a.m(e));
                return false;
            }
            return false;
        }
    }

    public void bCF() {
        if (this.hiU != null && (this.hiU instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hiU;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bCn();
            this.hiR = this.hiR == 0 ? 1 : 0;
            nb(this.hiR == 1);
            gLVideoPreviewView.bCo();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hiU != null && (this.hiU instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hiU).h(this.mCamera);
            releaseCamera();
            this.hiR = this.hiR == 0 ? 1 : 0;
            nb(this.hiR == 1);
            startPreview();
        }
    }

    public boolean bCG() {
        return this.hiR == 1;
    }

    private void bCH() {
        this.ddU = 720;
        this.ddV = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCI() {
        if (this.hiO != null && this.hiN != null && this.hiN.getParent() != null) {
            this.hiO.removeView(this.hiN);
        }
    }

    private void bQ(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hiP.contains("auto")) {
                this.hiS = this.mCamera.getParameters();
                this.hiS.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hiS);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gPa != null) {
                this.gPa.ab(9, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
        if (this.hiU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hiU).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hiU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hiU).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hiU instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hiU).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nb(this.hiR == 1);
        if (this.hiU != null && (this.hiU instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hiU).onResume();
        }
        if (this.hiU != null && (this.hiU instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hiU).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCi()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hiT.h(this.mCamera);
        if (this.hiU != null && (this.hiU instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hiU).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hiZ = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hir = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hiT instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hiT != null) {
                        h.this.hiT.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hiT.a(aVar);
        }
    }

    public boolean bCs() {
        return this.mCameraId == 0;
    }
}
