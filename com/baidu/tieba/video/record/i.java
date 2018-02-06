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
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private int dAn;
    private int dAo;
    private int dSn;
    private com.baidu.tieba.i.h hbR;
    protected String hpA;
    private h hvC;
    private SurfaceView hvD;
    protected List<String> hvE;
    private b hvF;
    private com.baidu.tieba.video.record.b hvG;
    private g.a hvH;
    private c hvI;
    private g.a hva;
    private RecordVideoActivity hvu;
    private Bitmap hvv;
    private a hvw;
    private FrameLayout hvx;
    private List<String> hvy;
    protected boolean hvz;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hvA = 0;
    private Camera.Parameters hvB = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDu();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void cQ(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        this.mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String string;
                switch (message.what) {
                    case 1:
                        i.this.startPreview();
                        return;
                    case 2:
                        if (i.this.hvu != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hvu, d.j.disallow_camera_permission);
                            if (i.this.hbR != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.hvu.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.hbR.U(1, string);
                            }
                            i.this.hvu.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.hvu != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hvu, d.j.disallow_audio_record_permission);
                            if (i.this.hbR != null) {
                                i.this.hbR.U(2, i.this.hvu.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.hvu.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hvH = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nr(final boolean z) {
                if (i.this.hva != null) {
                    com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.hva.nr(z);
                        }
                    });
                }
            }
        };
        this.hvu = recordVideoActivity;
        bDs();
        this.hvv = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dSn = displayMetrics.heightPixels;
        this.hvx = this.hvu.bDL();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.hvD = gVar;
            this.hvC = gVar;
            ((g) this.hvD).setFaceIdentifyStateListener(this.hvH);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.hvD = nVar;
            this.hvC = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDL() != null) {
            recordVideoActivity.bDL().addView(this.hvD, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hvC.g(this.mCamera);
    }

    public void startRecord() {
        this.hvC.h(this.mCamera);
    }

    public void stopRecord() {
        this.hvC.i(this.mCamera);
    }

    public h bDe() {
        return this.hvC;
    }

    public void bDf() {
        this.hvE = null;
    }

    public String bDg() {
        if (this.hvE == null) {
            this.hvE = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.hnQ);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.hnQ + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hvE.add(str);
        return str;
    }

    public void bDh() {
        if (this.hvE != null && this.hvE.size() != 0) {
            String remove = this.hvE.remove(this.hvE.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDi() {
        File file = new File(com.baidu.tieba.video.b.hnQ);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hpA = com.baidu.tieba.video.b.hnQ + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hpA;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hvF != null && motionEvent.getAction() == 0) {
            this.hvF.bDu();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bDt();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hvF = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dSn && x >= com.baidu.adp.lib.util.l.t(this.hvu, d.e.ds60)) {
                    int width = this.hvv.getWidth();
                    int height = this.hvv.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dSn - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hvx == null) {
                            this.hvx = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hvx.getChildCount()) {
                                if (this.hvw != this.hvx.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hvx.removeViewAt(i);
                                }
                            }
                        }
                        this.hvw = new a(this.hvu, clamp - (width / 2), clamp2 - (height / 2), this.hvv);
                        this.hvx.addView(this.hvw, new ViewGroup.LayoutParams(-2, -2));
                        cP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bDt();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bDj() {
        int i;
        int i2;
        if (this.mCamera == null && this.hvu != null) {
            this.hvu.finish();
            return;
        }
        int ao = com.baidu.adp.lib.util.l.ao(this.hvu.getPageContext().getPageActivity());
        int bN = bN(this.hvu.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bN * 1.0f) / ao)));
        if (a2 != null) {
            this.dAn = a2.width;
            this.dAo = a2.height;
            this.hvB.setPreviewSize(this.dAn, this.dAo);
            if (this.hvC != null) {
                this.hvC.setPreviewSize(this.dAn, this.dAo);
            }
        }
        this.hvB.setPreviewFormat(17);
        bDk();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hvu, this.mCameraId));
        this.hvy = this.hvB.getSupportedFocusModes();
        if (this.hvy != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hvy.contains("continuous-picture")) {
                this.hvB.setFocusMode("continuous-picture");
            } else if (this.hvy.contains("continuous-video")) {
                this.hvB.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hvB);
        if (this.hvu != null && this.hvu.bDL() != null) {
            float f = (ao * 1.0f) / bN;
            float f2 = (this.dAo * 1.0f) / this.dAn;
            if (f > f2) {
                i = ao;
                i2 = (int) (ao / f2);
            } else {
                i = (int) (bN * f2);
                i2 = bN;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvD.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hvD.setLayoutParams(layoutParams);
            this.hvD.invalidate();
            if (this.hvI != null) {
                this.hvI.cQ(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bN(Context context) {
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
            return com.baidu.adp.lib.util.l.aq(context);
        }
        return i;
    }

    private void bDk() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hvB.getSupportedPreviewFpsRange()) {
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
        this.hvB.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ns(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.np(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.np(z)) {
                    bDn();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bDm();
                this.hvG = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hvz = z;
            } else {
                bDn();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDn();
            if (this.hbR != null) {
                this.hbR.U(8, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDl() {
        return this.hvG;
    }

    private void bDm() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hvB = this.mCamera.getParameters();
            bDj();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.i(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bDn() {
        if (this.hvu != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hvu.getPageContext().getPageActivity());
            aVar.fb(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.hvu != null) {
                        i.this.hvu.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.hvu.getPageContext());
            aVar.AU();
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
                if (this.hbR != null) {
                    this.hbR.U(6, com.baidu.tieba.i.a.i(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDo() {
        try {
            if (this.mCamera != null) {
                if (this.hvB == null) {
                    this.hvB = this.mCamera.getParameters();
                }
                if ("off".equals(this.hvB.getFlashMode())) {
                    this.hvB.setFlashMode("torch");
                } else {
                    this.hvB.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hvB);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbR != null) {
                this.hbR.U(7, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public boolean bDp() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hvB == null) {
                this.hvB = this.mCamera.getParameters();
            }
            return !"off".equals(this.hvB.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbR != null) {
                this.hbR.U(7, com.baidu.tieba.i.a.i(e));
                return false;
            }
            return false;
        }
    }

    public void bDq() {
        if (this.hvD != null && (this.hvD instanceof g)) {
            g gVar = (g) this.hvD;
            gVar.setIsChangingCamera(true);
            releaseCamera();
            gVar.bCZ();
            this.hvA = this.hvA == 0 ? 1 : 0;
            ns(this.hvA == 1);
            gVar.bDa();
            gVar.setIsChangingCamera(false);
        } else if (this.hvD != null && (this.hvD instanceof n)) {
            ((n) this.hvD).j(this.mCamera);
            releaseCamera();
            this.hvA = this.hvA == 0 ? 1 : 0;
            ns(this.hvA == 1);
            startPreview();
        }
    }

    public boolean bDr() {
        return this.hvA == 1;
    }

    private void bDs() {
        this.dAn = 720;
        this.dAo = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDt() {
        if (this.hvx != null && this.hvw != null && this.hvw.getParent() != null) {
            this.hvx.removeView(this.hvw);
        }
    }

    private void cP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hvy.contains("auto")) {
                this.hvB = this.mCamera.getParameters();
                this.hvB.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hvB);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hbR != null) {
                this.hbR.U(9, com.baidu.tieba.i.a.i(e));
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
        if (this.hvD instanceof g) {
            ((g) this.hvD).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hvD instanceof g) {
            ((g) this.hvD).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hvD instanceof g) {
            ((g) this.hvD).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ns(this.hvA == 1);
        if (this.hvD != null && (this.hvD instanceof g)) {
            ((g) this.hvD).onResume();
        }
        if (this.hvD != null && (this.hvD instanceof n)) {
            ((n) this.hvD).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCS()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hvC.j(this.mCamera);
        if (this.hvD != null && (this.hvD instanceof g)) {
            ((g) this.hvD).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hvI = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.hva = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.hvC instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.hvC != null) {
                        i.this.hvC.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hvC.a(aVar);
        }
    }
}
