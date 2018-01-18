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
    private int dxa;
    private int dxb;
    private com.baidu.tieba.i.h gZj;
    protected String hnR;
    private RecordVideoActivity htL;
    private Bitmap htM;
    private a htN;
    private int htO;
    private FrameLayout htP;
    private List<String> htQ;
    protected boolean htR;
    private h htU;
    private SurfaceView htV;
    protected List<String> htW;
    private b htX;
    private com.baidu.tieba.video.record.b htY;
    private g.a htZ;
    private g.a htr;
    private c hua;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int htS = 0;
    private Camera.Parameters htT = null;

    /* loaded from: classes2.dex */
    public interface b {
        void bCK();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void cV(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public i(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
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
                        if (i.this.htL != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.htL, d.j.disallow_camera_permission);
                            if (i.this.gZj != null) {
                                if (!(message.obj instanceof String)) {
                                    string = i.this.htL.getResources().getString(d.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                i.this.gZj.R(1, string);
                            }
                            i.this.htL.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (i.this.htL != null) {
                            com.baidu.adp.lib.util.l.showToast(i.this.htL, d.j.disallow_audio_record_permission);
                            if (i.this.gZj != null) {
                                i.this.gZj.R(2, i.this.htL.getResources().getString(d.j.disallow_audio_record_permission));
                            }
                            i.this.htL.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.htZ = new g.a() { // from class: com.baidu.tieba.video.record.i.2
            @Override // com.baidu.tieba.video.record.g.a
            public void nh(final boolean z) {
                if (i.this.htr != null) {
                    com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.video.record.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.htr.nh(z);
                        }
                    });
                }
            }
        };
        this.htL = recordVideoActivity;
        bCI();
        this.htM = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.htO = displayMetrics.heightPixels;
        this.htP = this.htL.bDb();
        if (Build.VERSION.SDK_INT >= 18) {
            g gVar = new g(recordVideoActivity, this);
            this.htV = gVar;
            this.htU = gVar;
            ((g) this.htV).setFaceIdentifyStateListener(this.htZ);
        } else {
            n nVar = new n(recordVideoActivity, this);
            this.htV = nVar;
            this.htU = nVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bDb() != null) {
            recordVideoActivity.bDb().addView(this.htV, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.htU.g(this.mCamera);
    }

    public void startRecord() {
        this.htU.h(this.mCamera);
    }

    public void stopRecord() {
        this.htU.i(this.mCamera);
    }

    public h bCt() {
        return this.htU;
    }

    public void bCu() {
        this.htW = null;
    }

    public String bCv() {
        if (this.htW == null) {
            this.htW = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.hmh);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.hmh + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.htW.add(str);
        return str;
    }

    public void bCw() {
        if (this.htW != null && this.htW.size() != 0) {
            String remove = this.htW.remove(this.htW.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bCx() {
        File file = new File(com.baidu.tieba.video.b.hmh);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hnR = com.baidu.tieba.video.b.hmh + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hnR;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.htX != null && motionEvent.getAction() == 0) {
            this.htX.bCK();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.bCJ();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.htX = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.htO && x >= com.baidu.adp.lib.util.l.s(this.htL, d.e.ds60)) {
                    int width = this.htM.getWidth();
                    int height = this.htM.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.htO - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.htP == null) {
                            this.htP = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.htP.getChildCount()) {
                                if (this.htN != this.htP.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.htP.removeViewAt(i);
                                }
                            }
                        }
                        this.htN = new a(this.htL, clamp - (width / 2), clamp2 - (height / 2), this.htM);
                        this.htP.addView(this.htN, new ViewGroup.LayoutParams(-2, -2));
                        cU(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.4
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.bCJ();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bCy() {
        int i;
        int i2;
        if (this.mCamera == null && this.htL != null) {
            this.htL.finish();
            return;
        }
        int ao = com.baidu.adp.lib.util.l.ao(this.htL.getPageContext().getPageActivity());
        int bQ = bQ(this.htL.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((bQ * 1.0f) / ao)));
        if (a2 != null) {
            this.dxa = a2.width;
            this.dxb = a2.height;
            this.htT.setPreviewSize(this.dxa, this.dxb);
            if (this.htU != null) {
                this.htU.setPreviewSize(this.dxa, this.dxb);
            }
        }
        this.htT.setPreviewFormat(17);
        bCz();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.i(this.htL, this.mCameraId));
        this.htQ = this.htT.getSupportedFocusModes();
        if (this.htQ != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.htQ.contains("continuous-picture")) {
                this.htT.setFocusMode("continuous-picture");
            } else if (this.htQ.contains("continuous-video")) {
                this.htT.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.htT);
        if (this.htL != null && this.htL.bDb() != null) {
            float f = (ao * 1.0f) / bQ;
            float f2 = (this.dxb * 1.0f) / this.dxa;
            if (f > f2) {
                i = ao;
                i2 = (int) (ao / f2);
            } else {
                i = (int) (bQ * f2);
                i2 = bQ;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.htV.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.htV.setLayoutParams(layoutParams);
            this.htV.invalidate();
            if (this.hua != null) {
                this.hua.cV(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int bQ(Context context) {
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

    private void bCz() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.htT.getSupportedPreviewFpsRange()) {
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
        this.htT.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ni(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nf(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nf(z)) {
                    bCC();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bCB();
                this.htY = new com.baidu.tieba.video.record.b(this.mCamera);
                this.htR = z;
            } else {
                bCC();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bCC();
            if (this.gZj != null) {
                this.gZj.R(8, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bCA() {
        return this.htY;
    }

    private void bCB() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.htT = this.mCamera.getParameters();
            bCy();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.i.a.i(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bCC() {
        if (this.htL != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.htL.getPageContext().getPageActivity());
            aVar.fb(d.j.video_quit_confirm);
            aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (i.this.htL != null) {
                        i.this.htL.finish();
                    }
                }
            });
            aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aV(true);
            aVar.b(this.htL.getPageContext());
            aVar.AA();
        }
    }

    private void bCD() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gZj != null) {
                    this.gZj.R(6, com.baidu.tieba.i.a.i(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bCE() {
        try {
            if (this.mCamera != null) {
                if (this.htT == null) {
                    this.htT = this.mCamera.getParameters();
                }
                if ("off".equals(this.htT.getFlashMode())) {
                    this.htT.setFlashMode("torch");
                } else {
                    this.htT.setFlashMode("off");
                }
                this.mCamera.setParameters(this.htT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZj != null) {
                this.gZj.R(7, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public boolean bCF() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.htT == null) {
                this.htT = this.mCamera.getParameters();
            }
            return !"off".equals(this.htT.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZj != null) {
                this.gZj.R(7, com.baidu.tieba.i.a.i(e));
                return false;
            }
            return false;
        }
    }

    public void bCG() {
        if (this.htV != null && (this.htV instanceof g)) {
            g gVar = (g) this.htV;
            gVar.setIsChangingCamera(true);
            bCD();
            gVar.bCo();
            this.htS = this.htS == 0 ? 1 : 0;
            ni(this.htS == 1);
            gVar.bCp();
            gVar.setIsChangingCamera(false);
        } else if (this.htV != null && (this.htV instanceof n)) {
            ((n) this.htV).j(this.mCamera);
            bCD();
            this.htS = this.htS == 0 ? 1 : 0;
            ni(this.htS == 1);
            startPreview();
        }
    }

    public boolean bCH() {
        return this.htS == 1;
    }

    private void bCI() {
        this.dxa = 720;
        this.dxb = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        if (this.htP != null && this.htN != null && this.htN.getParent() != null) {
            this.htP.removeView(this.htN);
        }
    }

    private void cU(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.htQ.contains("auto")) {
                this.htT = this.mCamera.getParameters();
                this.htT.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.htT);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gZj != null) {
                this.gZj.R(9, com.baidu.tieba.i.a.i(e));
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
        if (this.htV instanceof g) {
            ((g) this.htV).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.htV instanceof g) {
            ((g) this.htV).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.htV instanceof g) {
            ((g) this.htV).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ni(this.htS == 1);
        if (this.htV != null && (this.htV instanceof g)) {
            ((g) this.htV).onResume();
        }
        if (this.htV != null && (this.htV instanceof n)) {
            ((n) this.htV).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bCh()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bCD();
        this.htU.j(this.mCamera);
        if (this.htV != null && (this.htV instanceof g)) {
            ((g) this.htV).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hua = cVar;
        }
    }

    public void setFaceIdentifyStateListener(g.a aVar) {
        if (aVar != null) {
            this.htr = aVar;
        }
    }

    public void a(final h.a aVar) {
        if (this.htU instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.i.7
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.htU != null) {
                        i.this.htU.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.htU.a(aVar);
        }
    }
}
