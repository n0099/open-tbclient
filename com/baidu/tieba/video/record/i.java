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
    private int dAe;
    private int dAf;
    private int dSg;
    private com.baidu.tieba.i.h hca;
    protected String hpL;
    private RecordVideoActivity hvF;
    private Bitmap hvG;
    private a hvH;
    private FrameLayout hvI;
    private List<String> hvJ;
    protected boolean hvK;
    private h hvN;
    private SurfaceView hvO;
    protected List<String> hvP;
    private b hvQ;
    private com.baidu.tieba.video.record.b hvR;
    private g.a hvS;
    private c hvT;
    private g.a hvl;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hvL = 0;
    private Camera.Parameters hvM = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bDy();
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
            this.hca = kVar.aXg();
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
                        if (i.this.hvF != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hvF, d.j.disallow_camera_permission);
                            if (i.this.hca != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.hvF.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.hca.U(1, string);
                            }
                            i.this.hvF.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.hvF != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.hvF, d.j.disallow_audio_record_permission);
                            if (i.this.hca != null) {
                                i.this.hca.U(2, i.this.hvF.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.hvF.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hvS = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nw(final boolean z) {
                if (i.this.hvl != null) {
                    com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.hvl.nw(z);
                        }
                    });
                }
            }
        };
        this.hvF = recordVideoActivity;
        bDw();
        this.hvG = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.dSg = displayMetrics.heightPixels;
        this.hvI = this.hvF.bDP();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.hvO = gVar;
            this.hvN = gVar;
            ((g) this.hvO).setFaceIdentifyStateListener(this.hvS);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.hvO = nVar;
            this.hvN = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDP() != null) {
            recordVideoActivity.bDP().addView(this.hvO, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hvN.g(this.mCamera);
    }

    public void startRecord() {
        this.hvN.h(this.mCamera);
    }

    public void stopRecord() {
        this.hvN.i(this.mCamera);
    }

    public h bDi() {
        return this.hvN;
    }

    public void bDj() {
        this.hvP = null;
    }

    public String bDk() {
        if (this.hvP == null) {
            this.hvP = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.hob);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.hob + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hvP.add(str);
        return str;
    }

    public void bDl() {
        if (this.hvP != null && this.hvP.size() != 0) {
            String remove = this.hvP.remove(this.hvP.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bDm() {
        File file = new File(com.baidu.tieba.video.b.hob);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hpL = com.baidu.tieba.video.b.hob + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hpL;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hvQ != null && motionEvent.getAction() == 0) {
            this.hvQ.bDy();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bDx();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hvQ = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dSg && x >= com.baidu.adp.lib.util.l.t(this.hvF, d.e.ds60)) {
                    int width = this.hvG.getWidth();
                    int height = this.hvG.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dSg - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hvI == null) {
                            this.hvI = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hvI.getChildCount()) {
                                if (this.hvH != this.hvI.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hvI.removeViewAt(i);
                                }
                            }
                        }
                        this.hvH = new a(this.hvF, clamp - (width / 2), clamp2 - (height / 2), this.hvG);
                        this.hvI.addView(this.hvH, new ViewGroup.LayoutParams(-2, -2));
                        cP(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bDx();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bDn() {
        int i;
        int i2;
        if (this.mCamera == null && this.hvF != null) {
            this.hvF.finish();
            return;
        }
        int ao = com.baidu.adp.lib.util.l.ao(this.hvF.getPageContext().getPageActivity());
        int bN = bN(this.hvF.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bN * 1.0f) / ao)));
        if (a2 != null) {
            this.dAe = a2.width;
            this.dAf = a2.height;
            this.hvM.setPreviewSize(this.dAe, this.dAf);
            if (this.hvN != null) {
                this.hvN.setPreviewSize(this.dAe, this.dAf);
            }
        }
        this.hvM.setPreviewFormat(17);
        bDo();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.hvF, this.mCameraId));
        this.hvJ = this.hvM.getSupportedFocusModes();
        if (this.hvJ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hvJ.contains("continuous-picture")) {
                this.hvM.setFocusMode("continuous-picture");
            } else if (this.hvJ.contains("continuous-video")) {
                this.hvM.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hvM);
        if (this.hvF != null && this.hvF.bDP() != null) {
            float f = (ao * 1.0f) / bN;
            float f2 = (this.dAf * 1.0f) / this.dAe;
            if (f > f2) {
                i = ao;
                i2 = (int) (ao / f2);
            } else {
                i = (int) (bN * f2);
                i2 = bN;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvO.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hvO.setLayoutParams(layoutParams);
            this.hvO.invalidate();
            if (this.hvT != null) {
                this.hvT.cQ(layoutParams.width, layoutParams.height);
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

    private void bDo() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hvM.getSupportedPreviewFpsRange()) {
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
        this.hvM.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nx(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nu(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nu(z)) {
                    bDr();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bDq();
                this.hvR = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hvK = z;
            } else {
                bDr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bDr();
            if (this.hca != null) {
                this.hca.U(8, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bDp() {
        return this.hvR;
    }

    private void bDq() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hvM = this.mCamera.getParameters();
            bDn();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.i(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bDr() {
        if (this.hvF != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hvF.getPageContext().getPageActivity());
            aVar.fb(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.hvF != null) {
                        i.this.hvF.finish();
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
            aVar.b(this.hvF.getPageContext());
            aVar.AV();
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
                if (this.hca != null) {
                    this.hca.U(6, com.baidu.tieba.i.a.i(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bDs() {
        try {
            if (this.mCamera != null) {
                if (this.hvM == null) {
                    this.hvM = this.mCamera.getParameters();
                }
                if ("off".equals(this.hvM.getFlashMode())) {
                    this.hvM.setFlashMode("torch");
                } else {
                    this.hvM.setFlashMode("off");
                }
                this.mCamera.setParameters(this.hvM);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hca != null) {
                this.hca.U(7, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public boolean bDt() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hvM == null) {
                this.hvM = this.mCamera.getParameters();
            }
            return !"off".equals(this.hvM.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hca != null) {
                this.hca.U(7, com.baidu.tieba.i.a.i(e));
                return false;
            }
            return false;
        }
    }

    public void bDu() {
        if (this.hvO != null && (this.hvO instanceof g)) {
            g gVar = (g) this.hvO;
            gVar.setIsChangingCamera(true);
            releaseCamera();
            gVar.bDd();
            this.hvL = this.hvL == 0 ? 1 : 0;
            nx(this.hvL == 1);
            gVar.bDe();
            gVar.setIsChangingCamera(false);
        } else if (this.hvO != null && (this.hvO instanceof n)) {
            ((n) this.hvO).j(this.mCamera);
            releaseCamera();
            this.hvL = this.hvL == 0 ? 1 : 0;
            nx(this.hvL == 1);
            startPreview();
        }
    }

    public boolean bDv() {
        return this.hvL == 1;
    }

    private void bDw() {
        this.dAe = 720;
        this.dAf = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDx() {
        if (this.hvI != null && this.hvH != null && this.hvH.getParent() != null) {
            this.hvI.removeView(this.hvH);
        }
    }

    private void cP(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hvJ.contains("auto")) {
                this.hvM = this.mCamera.getParameters();
                this.hvM.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hvM);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hca != null) {
                this.hca.U(9, com.baidu.tieba.i.a.i(e));
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
        if (this.hvO instanceof g) {
            ((g) this.hvO).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hvO instanceof g) {
            ((g) this.hvO).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hvO instanceof g) {
            ((g) this.hvO).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nx(this.hvL == 1);
        if (this.hvO != null && (this.hvO instanceof g)) {
            ((g) this.hvO).onResume();
        }
        if (this.hvO != null && (this.hvO instanceof n)) {
            ((n) this.hvO).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCW()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hvN.j(this.mCamera);
        if (this.hvO != null && (this.hvO instanceof g)) {
            ((g) this.hvO).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hvT = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.hvl = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.hvN instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.hvN != null) {
                        i.this.hvN.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hvN.a(aVar);
        }
    }
}
