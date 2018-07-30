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
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private int dCJ;
    private int ddW;
    private int ddX;
    private com.baidu.tieba.j.h gOY;
    protected String hdp;
    private RecordVideoActivity hiK;
    private Bitmap hiL;
    private a hiM;
    private FrameLayout hiN;
    private List<String> hiO;
    protected boolean hiP;
    private g hiS;
    private SurfaceView hiT;
    protected List<String> hiU;
    private b hiV;
    private com.baidu.tieba.video.record.b hiW;
    private GLVideoPreviewView.a hiX;
    private c hiY;
    private GLVideoPreviewView.a hiq;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hiQ = 0;
    private Camera.Parameters hiR = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bCH();
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
            this.gOY = lVar.aWa();
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
                        if (h.this.hiK != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hiK, d.j.disallow_camera_permission);
                            if (h.this.gOY != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hiK.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.gOY.ab(1, string);
                            }
                            h.this.hiK.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hiK != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hiK, d.j.disallow_audio_record_permission);
                            if (h.this.gOY != null) {
                                h.this.gOY.ab(2, h.this.hiK.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            h.this.hiK.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiX = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void na(final boolean z) {
                if (h.this.hiq != null) {
                    com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hiq.na(z);
                        }
                    });
                }
            }
        };
        this.hiK = recordVideoActivity;
        bCF();
        this.hiL = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dCJ = displayMetrics.heightPixels;
        this.hiN = this.hiK.bCX();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hiT = gLVideoPreviewView;
            this.hiS = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hiT).setFaceIdentifyStateListener(this.hiX);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hiT = videoPreviewView;
            this.hiS = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bCX() != null) {
            recordVideoActivity.bCX().addView(this.hiT, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hiS.g(this.mCamera);
    }

    public void startRecord() {
        this.hiS.h(this.mCamera);
    }

    public void stopRecord() {
        this.hiS.i(this.mCamera);
    }

    public g bCs() {
        return this.hiS;
    }

    public String bCt() {
        if (this.hiU == null) {
            this.hiU = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hbD);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hbD + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hiU.add(str);
        return str;
    }

    public void bCu() {
        if (this.hiU != null && this.hiU.size() != 0) {
            String remove = this.hiU.remove(this.hiU.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bCv() {
        File file = new File(com.baidu.tieba.video.c.hbD);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hdp = com.baidu.tieba.video.c.hbD + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hdp;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hiV != null && motionEvent.getAction() == 0) {
            this.hiV.bCH();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bCG();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hiV = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dCJ && x >= com.baidu.adp.lib.util.l.f(this.hiK, d.e.ds60)) {
                    int width = this.hiL.getWidth();
                    int height = this.hiL.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dCJ - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hiN == null) {
                            this.hiN = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hiN.getChildCount()) {
                                if (this.hiM != this.hiN.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hiN.removeViewAt(i);
                                }
                            }
                        }
                        this.hiM = new a(this.hiK, clamp - (width / 2), clamp2 - (height / 2), this.hiL);
                        this.hiN.addView(this.hiM, new ViewGroup.LayoutParams(-2, -2));
                        bQ(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bCG();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bCw() {
        int i;
        int i2;
        if (this.mCamera == null && this.hiK != null) {
            this.hiK.finish();
            return;
        }
        int ah = com.baidu.adp.lib.util.l.ah(this.hiK.getPageContext().getPageActivity());
        int bM = bM(this.hiK.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bM * 1.0f) / ah)));
        if (a2 != null) {
            this.ddW = a2.width;
            this.ddX = a2.height;
            this.hiR.setPreviewSize(this.ddW, this.ddX);
            if (this.hiS != null) {
                this.hiS.setPreviewSize(this.ddW, this.ddX);
            }
        }
        this.hiR.setPreviewFormat(17);
        bCx();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hiK, this.mCameraId));
        this.hiO = this.hiR.getSupportedFocusModes();
        if (this.hiO != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hiO.contains("continuous-picture")) {
                this.hiR.setFocusMode("continuous-picture");
            } else if (this.hiO.contains("continuous-video")) {
                this.hiR.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hiR);
        if (this.hiK != null && this.hiK.bCX() != null) {
            float f = (ah * 1.0f) / bM;
            float f2 = (this.ddX * 1.0f) / this.ddW;
            if (f > f2) {
                i = ah;
                i2 = (int) (ah / f2);
            } else {
                i = (int) (bM * f2);
                i2 = bM;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiT.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hiT.setLayoutParams(layoutParams);
            this.hiT.invalidate();
            if (this.hiY != null) {
                this.hiY.bR(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bM(Context context) {
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

    private void bCx() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hiR.getSupportedPreviewFpsRange()) {
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
        this.hiR.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nb(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.mX(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.mX(z)) {
                    bCA();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.mY(z);
            if (-1 != this.mCameraId) {
                bCz();
                this.hiW = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hiP = z;
            } else {
                bCA();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bCA();
            if (this.gOY != null) {
                this.gOY.ab(8, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bCy() {
        return this.hiW;
    }

    private void bCz() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hiR = this.mCamera.getParameters();
            bCw();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.m(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bCA() {
        if (this.hiK != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hiK.getPageContext().getPageActivity());
            aVar.cf(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hiK != null) {
                        h.this.hiK.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.au(true);
            aVar.b(this.hiK.getPageContext());
            aVar.xf();
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
                if (this.gOY != null) {
                    this.gOY.ab(6, com.baidu.tieba.j.a.m(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bCB() {
        try {
            if (this.mCamera != null) {
                if (this.hiR == null) {
                    this.hiR = this.mCamera.getParameters();
                }
                if ("off".equals(this.hiR.getFlashMode())) {
                    this.hiR.setFlashMode("torch");
                } else {
                    this.hiR.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hiR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOY != null) {
                this.gOY.ab(7, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public boolean bCC() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hiR == null) {
                this.hiR = this.mCamera.getParameters();
            }
            return !"off".equals(this.hiR.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOY != null) {
                this.gOY.ab(7, com.baidu.tieba.j.a.m(e));
                return false;
            }
            return false;
        }
    }

    public void bCD() {
        if (this.hiT != null && (this.hiT instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hiT;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bCl();
            this.hiQ = this.hiQ == 0 ? 1 : 0;
            nb(this.hiQ == 1);
            gLVideoPreviewView.bCm();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hiT != null && (this.hiT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hiT).j(this.mCamera);
            releaseCamera();
            this.hiQ = this.hiQ == 0 ? 1 : 0;
            nb(this.hiQ == 1);
            startPreview();
        }
    }

    public boolean bCE() {
        return this.hiQ == 1;
    }

    private void bCF() {
        this.ddW = 720;
        this.ddX = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCG() {
        if (this.hiN != null && this.hiM != null && this.hiM.getParent() != null) {
            this.hiN.removeView(this.hiM);
        }
    }

    private void bQ(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hiO.contains("auto")) {
                this.hiR = this.mCamera.getParameters();
                this.hiR.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hiR);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gOY != null) {
                this.gOY.ab(9, com.baidu.tieba.j.a.m(e));
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
        if (this.hiT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hiT).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hiT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hiT).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hiT instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hiT).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nb(this.hiQ == 1);
        if (this.hiT != null && (this.hiT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hiT).onResume();
        }
        if (this.hiT != null && (this.hiT instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hiT).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCg()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hiS.j(this.mCamera);
        if (this.hiT != null && (this.hiT instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hiT).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hiY = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hiq = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hiS instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.7
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hiS != null) {
                        h.this.hiS.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hiS.a(aVar);
        }
    }

    public boolean bCq() {
        return this.mCameraId == 0;
    }
}
