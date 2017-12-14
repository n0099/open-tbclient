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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private int cDh;
    private int cDi;
    private int egC;
    private com.baidu.tieba.i.h gCP;
    protected String gRh;
    private g.a gWE;
    private RecordVideoActivity gWY;
    private Bitmap gWZ;
    private a gXa;
    private int gXb;
    private FrameLayout gXc;
    private List<String> gXd;
    protected boolean gXe;
    private boolean gXh;
    private h gXi;
    private SurfaceView gXj;
    protected List<String> gXk;
    private b gXl;
    private com.baidu.tieba.video.record.b gXm;
    private g.a gXn;
    private c gXo;
    private Camera mCamera;
    private Handler mMainHandler;
    protected int mCameraId = -1;
    protected int gXf = 0;
    private Camera.Parameters gXg = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDO();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void cf(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOk();
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
                        if (i.this.gWY != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.gWY, d.j.disallow_camera_permission);
                            if (i.this.gCP != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.gWY.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.gCP.Q(1, string);
                            }
                            i.this.gWY.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.gWY != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.gWY, d.j.disallow_audio_record_permission);
                            if (i.this.gCP != null) {
                                i.this.gCP.Q(2, i.this.gWY.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.gWY.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gXn = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nK(final boolean z) {
                if (i.this.gWE != null) {
                    com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.gWE.nK(z);
                        }
                    });
                }
            }
        };
        this.gWY = recordVideoActivity;
        bDM();
        this.gWZ = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.egC = displayMetrics.widthPixels;
        this.gXb = displayMetrics.heightPixels;
        this.gXc = this.gWY.bEe();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.gXj = gVar;
            this.gXi = gVar;
            ((g) this.gXj).setFaceIdentifyStateListener(this.gXn);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.gXj = nVar;
            this.gXi = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bEe() != null) {
            recordVideoActivity.bEe().addView(this.gXj, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gXi.g(this.mCamera);
    }

    public void startRecord() {
        this.gXi.h(this.mCamera);
    }

    public void stopRecord() {
        this.gXi.i(this.mCamera);
    }

    public h bDx() {
        return this.gXi;
    }

    public void bDy() {
        this.gXk = null;
    }

    public String bDz() {
        if (this.gXk == null) {
            this.gXk = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gPB);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gPB + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gXk.add(str);
        return str;
    }

    public void bDA() {
        if (this.gXk != null && this.gXk.size() != 0) {
            String remove = this.gXk.remove(this.gXk.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDB() {
        File file = new File(com.baidu.tieba.video.b.gPB);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gRh = com.baidu.tieba.video.b.gPB + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gRh;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.gXl != null && motionEvent.getAction() == 0) {
            this.gXl.bDO();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bDN();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.gXl = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.gXb && x >= com.baidu.adp.lib.util.l.f(this.gWY, d.e.ds60)) {
                    int width = this.gWZ.getWidth();
                    int height = this.gWZ.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.egC - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.gXb - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gXc == null) {
                            this.gXc = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gXc.getChildCount()) {
                                if (this.gXa != this.gXc.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gXc.removeViewAt(i);
                                }
                            }
                        }
                        this.gXa = new a(this.gWY, clamp - (width / 2), clamp2 - (height / 2), this.gWZ);
                        this.gXc.addView(this.gXa, new ViewGroup.LayoutParams(-2, -2));
                        ce(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bDN();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bDC() {
        int i;
        int i2;
        if (this.mCamera == null && this.gWY != null) {
            this.gWY.finish();
            return;
        }
        int ac = com.baidu.adp.lib.util.l.ac(this.gWY.getPageContext().getPageActivity());
        int bF = bF(this.gWY.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, ac, bF);
        if (a2 != null) {
            this.cDh = a2.width;
            this.cDi = a2.height;
            this.gXg.setPreviewSize(this.cDh, this.cDi);
            if (this.gXi != null) {
                this.gXi.setPreviewSize(this.cDh, this.cDi);
            }
        }
        this.gXg.setPreviewFormat(17);
        bDD();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.i(this.gWY, this.mCameraId));
        this.gXd = this.gXg.getSupportedFocusModes();
        if (this.gXd != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gXd.contains("continuous-picture")) {
                this.gXg.setFocusMode("continuous-picture");
            } else if (this.gXd.contains("continuous-video")) {
                this.gXg.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gXg);
        if (this.gWY != null && this.gWY.bEe() != null) {
            float f = (ac * 1.0f) / bF;
            float f2 = (this.cDi * 1.0f) / this.cDh;
            if (f > f2) {
                i = ac;
                i2 = (int) (ac / f2);
            } else {
                i = (int) (bF * f2);
                i2 = bF;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gXj.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gXj.setLayoutParams(layoutParams);
            this.gXj.invalidate();
            if (this.gXo != null) {
                this.gXo.cf(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bF(Context context) {
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
            return com.baidu.adp.lib.util.l.ae(context);
        }
        return i;
    }

    private void bDD() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gXg.getSupportedPreviewFpsRange()) {
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
        this.gXg.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nL(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nI(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nI(z)) {
                    bDG();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bDF();
                this.gXm = new com.baidu.tieba.video.record.b(this.mCamera);
                this.gXe = z;
            } else {
                bDG();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDG();
            if (this.gCP != null) {
                this.gCP.Q(8, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDE() {
        return this.gXm;
    }

    private void bDF() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gXg = this.mCamera.getParameters();
            bDC();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.g(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bDG() {
        if (this.gWY != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gWY.getPageContext().getPageActivity());
            aVar.cd(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.gWY != null) {
                        i.this.gWY.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ao(true);
            aVar.b(this.gWY.getPageContext());
            aVar.th();
        }
    }

    private void bDH() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gCP != null) {
                    this.gCP.Q(6, com.baidu.tieba.i.a.g(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDI() {
        try {
            if (this.mCamera != null) {
                if (this.gXg == null) {
                    this.gXg = this.mCamera.getParameters();
                }
                if ("off".equals(this.gXg.getFlashMode())) {
                    this.gXg.setFlashMode("torch");
                    this.gXh = true;
                } else {
                    this.gXg.setFlashMode("off");
                    this.gXh = false;
                }
                this.mCamera.setParameters(this.gXg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gCP != null) {
                this.gCP.Q(7, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public boolean bDJ() {
        return this.gXh;
    }

    public void bDK() {
        if (this.gXj != null && (this.gXj instanceof g)) {
            g gVar = (g) this.gXj;
            gVar.setIsChangingCamera(true);
            bDH();
            gVar.bDs();
            this.gXf = this.gXf == 0 ? 1 : 0;
            nL(this.gXf == 1);
            gVar.bDt();
            gVar.setIsChangingCamera(false);
        } else if (this.gXj != null && (this.gXj instanceof n)) {
            ((n) this.gXj).j(this.mCamera);
            bDH();
            this.gXf = this.gXf == 0 ? 1 : 0;
            nL(this.gXf == 1);
            startPreview();
        }
    }

    public boolean bDL() {
        return this.gXf == 1;
    }

    private void bDM() {
        this.cDh = 720;
        this.cDi = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
        if (this.gXc != null && this.gXa != null && this.gXa.getParent() != null) {
            this.gXc.removeView(this.gXa);
        }
    }

    private void ce(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gXd.contains("auto")) {
                this.gXg = this.mCamera.getParameters();
                this.gXg.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gXg);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gCP != null) {
                this.gCP.Q(9, com.baidu.tieba.i.a.g(e));
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
        if (this.gXj instanceof g) {
            ((g) this.gXj).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gXj instanceof g) {
            ((g) this.gXj).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gXj instanceof g) {
            ((g) this.gXj).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nL(this.gXf == 1);
        if (this.gXj != null && (this.gXj instanceof g)) {
            ((g) this.gXj).onResume();
        }
        if (this.gXj != null && (this.gXj instanceof n)) {
            ((n) this.gXj).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bDn()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bDH();
        this.gXi.j(this.mCamera);
        if (this.gXj != null && (this.gXj instanceof g)) {
            ((g) this.gXj).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gXo = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.gWE = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.gXi instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.gXi != null) {
                        i.this.gXi.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.gXi.a(aVar);
        }
    }
}
