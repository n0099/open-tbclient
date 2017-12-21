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
    private int cDl;
    private int cDm;
    private int egG;
    private com.baidu.tieba.i.h gCU;
    protected String gRm;
    private g.a gWJ;
    private RecordVideoActivity gXd;
    private Bitmap gXe;
    private a gXf;
    private int gXg;
    private FrameLayout gXh;
    private List<String> gXi;
    protected boolean gXj;
    private boolean gXm;
    private h gXn;
    private SurfaceView gXo;
    protected List<String> gXp;
    private b gXq;
    private com.baidu.tieba.video.record.b gXr;
    private g.a gXs;
    private c gXt;
    private Camera mCamera;
    private Handler mMainHandler;
    protected int mCameraId = -1;
    protected int gXk = 0;
    private Camera.Parameters gXl = null;

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
            this.gCU = kVar.aOk();
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
                        if (i.this.gXd != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.gXd, d.j.disallow_camera_permission);
                            if (i.this.gCU != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.gXd.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.gCU.Q(1, string);
                            }
                            i.this.gXd.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.gXd != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.gXd, d.j.disallow_audio_record_permission);
                            if (i.this.gCU != null) {
                                i.this.gCU.Q(2, i.this.gXd.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.gXd.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gXs = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nK(final boolean z) {
                if (i.this.gWJ != null) {
                    com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.gWJ.nK(z);
                        }
                    });
                }
            }
        };
        this.gXd = recordVideoActivity;
        bDM();
        this.gXe = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.egG = displayMetrics.widthPixels;
        this.gXg = displayMetrics.heightPixels;
        this.gXh = this.gXd.bEe();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.gXo = gVar;
            this.gXn = gVar;
            ((g) this.gXo).setFaceIdentifyStateListener(this.gXs);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.gXo = nVar;
            this.gXn = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bEe() != null) {
            recordVideoActivity.bEe().addView(this.gXo, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gXn.g(this.mCamera);
    }

    public void startRecord() {
        this.gXn.h(this.mCamera);
    }

    public void stopRecord() {
        this.gXn.i(this.mCamera);
    }

    public h bDx() {
        return this.gXn;
    }

    public void bDy() {
        this.gXp = null;
    }

    public String bDz() {
        if (this.gXp == null) {
            this.gXp = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gPG);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gPG + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.gXp.add(str);
        return str;
    }

    public void bDA() {
        if (this.gXp != null && this.gXp.size() != 0) {
            String remove = this.gXp.remove(this.gXp.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDB() {
        File file = new File(com.baidu.tieba.video.b.gPG);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gRm = com.baidu.tieba.video.b.gPG + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gRm;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.gXq != null && motionEvent.getAction() == 0) {
            this.gXq.bDO();
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
        this.gXq = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.gXg && x >= com.baidu.adp.lib.util.l.f(this.gXd, d.e.ds60)) {
                    int width = this.gXe.getWidth();
                    int height = this.gXe.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.egG - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.gXg - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gXh == null) {
                            this.gXh = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gXh.getChildCount()) {
                                if (this.gXf != this.gXh.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gXh.removeViewAt(i);
                                }
                            }
                        }
                        this.gXf = new a(this.gXd, clamp - (width / 2), clamp2 - (height / 2), this.gXe);
                        this.gXh.addView(this.gXf, new ViewGroup.LayoutParams(-2, -2));
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
        if (this.mCamera == null && this.gXd != null) {
            this.gXd.finish();
            return;
        }
        int ac = com.baidu.adp.lib.util.l.ac(this.gXd.getPageContext().getPageActivity());
        int bF = bF(this.gXd.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, ac, bF);
        if (a2 != null) {
            this.cDl = a2.width;
            this.cDm = a2.height;
            this.gXl.setPreviewSize(this.cDl, this.cDm);
            if (this.gXn != null) {
                this.gXn.setPreviewSize(this.cDl, this.cDm);
            }
        }
        this.gXl.setPreviewFormat(17);
        bDD();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.i(this.gXd, this.mCameraId));
        this.gXi = this.gXl.getSupportedFocusModes();
        if (this.gXi != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gXi.contains("continuous-picture")) {
                this.gXl.setFocusMode("continuous-picture");
            } else if (this.gXi.contains("continuous-video")) {
                this.gXl.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gXl);
        if (this.gXd != null && this.gXd.bEe() != null) {
            float f = (ac * 1.0f) / bF;
            float f2 = (this.cDm * 1.0f) / this.cDl;
            if (f > f2) {
                i = ac;
                i2 = (int) (ac / f2);
            } else {
                i = (int) (bF * f2);
                i2 = bF;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gXo.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gXo.setLayoutParams(layoutParams);
            this.gXo.invalidate();
            if (this.gXt != null) {
                this.gXt.cf(layoutParams.width, layoutParams.height);
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
        for (int[] iArr3 : this.gXl.getSupportedPreviewFpsRange()) {
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
        this.gXl.setPreviewFpsRange(iArr2[0], iArr2[1]);
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
                this.gXr = new com.baidu.tieba.video.record.b(this.mCamera);
                this.gXj = z;
            } else {
                bDG();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDG();
            if (this.gCU != null) {
                this.gCU.Q(8, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDE() {
        return this.gXr;
    }

    private void bDF() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gXl = this.mCamera.getParameters();
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
        if (this.gXd != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gXd.getPageContext().getPageActivity());
            aVar.cd(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.gXd != null) {
                        i.this.gXd.finish();
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
            aVar.b(this.gXd.getPageContext());
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
                if (this.gCU != null) {
                    this.gCU.Q(6, com.baidu.tieba.i.a.g(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDI() {
        try {
            if (this.mCamera != null) {
                if (this.gXl == null) {
                    this.gXl = this.mCamera.getParameters();
                }
                if ("off".equals(this.gXl.getFlashMode())) {
                    this.gXl.setFlashMode("torch");
                    this.gXm = true;
                } else {
                    this.gXl.setFlashMode("off");
                    this.gXm = false;
                }
                this.mCamera.setParameters(this.gXl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gCU != null) {
                this.gCU.Q(7, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public boolean bDJ() {
        return this.gXm;
    }

    public void bDK() {
        if (this.gXo != null && (this.gXo instanceof g)) {
            g gVar = (g) this.gXo;
            gVar.setIsChangingCamera(true);
            bDH();
            gVar.bDs();
            this.gXk = this.gXk == 0 ? 1 : 0;
            nL(this.gXk == 1);
            gVar.bDt();
            gVar.setIsChangingCamera(false);
        } else if (this.gXo != null && (this.gXo instanceof n)) {
            ((n) this.gXo).j(this.mCamera);
            bDH();
            this.gXk = this.gXk == 0 ? 1 : 0;
            nL(this.gXk == 1);
            startPreview();
        }
    }

    public boolean bDL() {
        return this.gXk == 1;
    }

    private void bDM() {
        this.cDl = 720;
        this.cDm = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
        if (this.gXh != null && this.gXf != null && this.gXf.getParent() != null) {
            this.gXh.removeView(this.gXf);
        }
    }

    private void ce(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gXi.contains("auto")) {
                this.gXl = this.mCamera.getParameters();
                this.gXl.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gXl);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gCU != null) {
                this.gCU.Q(9, com.baidu.tieba.i.a.g(e));
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
        if (this.gXo instanceof g) {
            ((g) this.gXo).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gXo instanceof g) {
            ((g) this.gXo).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gXo instanceof g) {
            ((g) this.gXo).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nL(this.gXk == 1);
        if (this.gXo != null && (this.gXo instanceof g)) {
            ((g) this.gXo).onResume();
        }
        if (this.gXo != null && (this.gXo instanceof n)) {
            ((n) this.gXo).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bDn()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bDH();
        this.gXn.j(this.mCamera);
        if (this.gXo != null && (this.gXo instanceof g)) {
            ((g) this.gXo).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gXt = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.gWJ = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.gXn instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.gXn != null) {
                        i.this.gXn.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.gXn.a(aVar);
        }
    }
}
