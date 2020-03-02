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
/* loaded from: classes10.dex */
public class h {
    private int cdv;
    private GLVideoPreviewView.a kAY;
    private b kBA;
    private com.baidu.tieba.video.record.b kBB;
    private GLVideoPreviewView.a kBC;
    private c kBD;
    private RecordVideoActivity kBq;
    private Bitmap kBr;
    private a kBs;
    private FrameLayout kBt;
    private List<String> kBu;
    private g kBx;
    private SurfaceView kBy;
    protected List<String> kBz;
    private com.baidu.tieba.k.h khN;
    protected String kwr;
    private Camera mCamera;
    protected boolean mFrontCamera;
    private Handler mMainHandler;
    private int previewHeight;
    private int previewWidth;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int kBv = 0;
    private Camera.Parameters kBw = null;

    /* loaded from: classes10.dex */
    public interface b {
        void cRv();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void cS(int i, int i2);
    }

    public void aj(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fH(false);
        aVar.jV(R.string.request_permission_default_title);
        aVar.jW(R.string.request_permission_camera);
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
        aVar.aEC();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.khN = lVar.cgY();
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
                        if (h.this.kBq != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.aj(h.this.kBq);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.kBq, (int) R.string.disallow_camera_permission);
                            if (h.this.khN != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.kBq.getResources().getString(R.string.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.khN.aP(1, string);
                            }
                            h.this.kBq.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.kBq != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.kBq, (int) R.string.disallow_audio_record_permission);
                            if (h.this.khN != null) {
                                h.this.khN.aP(2, h.this.kBq.getResources().getString(R.string.disallow_audio_record_permission));
                            }
                            h.this.kBq.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kBC = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void tu(final boolean z) {
                if (h.this.kAY != null) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.kAY.tu(z);
                        }
                    });
                }
            }
        };
        this.kBq = recordVideoActivity;
        cRt();
        this.kBr = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.cdv = displayMetrics.heightPixels;
        this.kBt = this.kBq.cRK();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.kBy = gLVideoPreviewView;
            this.kBx = gLVideoPreviewView;
            ((GLVideoPreviewView) this.kBy).setFaceIdentifyStateListener(this.kBC);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.kBy = videoPreviewView;
            this.kBx = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.cRK() != null) {
            recordVideoActivity.cRK().addView(this.kBy, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.kBx.e(this.mCamera);
    }

    public void startRecord() {
        this.kBx.f(this.mCamera);
    }

    public void stopRecord() {
        this.kBx.g(this.mCamera);
    }

    public g cRh() {
        return this.kBx;
    }

    public String cRi() {
        if (this.kBz == null) {
            this.kBz = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.kuN);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.kuN + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.kBz.add(str);
        return str;
    }

    public void cRj() {
        if (this.kBz != null && this.kBz.size() != 0) {
            String remove = this.kBz.remove(this.kBz.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String cRk() {
        File file = new File(com.baidu.tieba.video.c.kuN);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.kwr = com.baidu.tieba.video.c.kuN + "f_" + System.currentTimeMillis() + ".mp4";
        return this.kwr;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.kBA != null && motionEvent.getAction() == 0) {
            this.kBA.cRv();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.cRu();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.kBA = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.cdv && x >= com.baidu.adp.lib.util.l.getDimens(this.kBq, R.dimen.ds60)) {
                    int width = this.kBr.getWidth();
                    int height = this.kBr.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.cdv - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.kBt == null) {
                            this.kBt = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.kBt.getChildCount()) {
                                if (this.kBs != this.kBt.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.kBt.removeViewAt(i);
                                }
                            }
                        }
                        this.kBs = new a(this.kBq, clamp - (width / 2), clamp2 - (height / 2), this.kBr);
                        this.kBt.addView(this.kBs, new ViewGroup.LayoutParams(-2, -2));
                        cR(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.cRu();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void cRl() {
        int i;
        int i2;
        if (this.mCamera == null && this.kBq != null) {
            this.kBq.finish();
            return;
        }
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kBq.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.kBq.getPageContext().getPageActivity());
        Camera.Size c2 = com.baidu.tieba.video.record.a.c(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / equipmentWidth)));
        if (c2 != null) {
            this.previewWidth = c2.width;
            this.previewHeight = c2.height;
            this.kBw.setPreviewSize(this.previewWidth, this.previewHeight);
            if (this.kBx != null) {
                this.kBx.setPreviewSize(this.previewWidth, this.previewHeight);
            }
        }
        this.kBw.setPreviewFormat(17);
        cRm();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.kBq, this.mCameraId));
        this.kBu = this.kBw.getSupportedFocusModes();
        if (this.kBu != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.kBu.contains("continuous-picture")) {
                this.kBw.setFocusMode("continuous-picture");
            } else if (this.kBu.contains("continuous-video")) {
                this.kBw.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.kBw);
        if (this.kBq != null && this.kBq.cRK() != null) {
            float f = (equipmentWidth * 1.0f) / screenHeight;
            float f2 = (this.previewHeight * 1.0f) / this.previewWidth;
            if (f > f2) {
                i = equipmentWidth;
                i2 = (int) (equipmentWidth / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kBy.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.kBy.setLayoutParams(layoutParams);
            this.kBy.invalidate();
            if (this.kBD != null) {
                this.kBD.cS(layoutParams.width, layoutParams.height);
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

    private void cRm() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.kBw.getSupportedPreviewFpsRange()) {
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
        this.kBw.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void tv(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.tr(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.tr(z)) {
                    cRp();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.ts(z);
            if (-1 != this.mCameraId) {
                cRo();
                this.kBB = new com.baidu.tieba.video.record.b(this.mCamera);
                this.mFrontCamera = z;
            } else {
                cRp();
            }
        } catch (Exception e) {
            e.printStackTrace();
            cRp();
            if (this.khN != null) {
                this.khN.aP(8, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b cRn() {
        return this.kBB;
    }

    private void cRo() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.kBw = this.mCamera.getParameters();
            cRl();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.k.a.q(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void cRp() {
        if (this.kBq != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kBq.getPageContext().getPageActivity());
            aVar.jW(R.string.video_quit_confirm);
            aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.kBq != null) {
                        h.this.kBq.finish();
                    }
                }
            });
            aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.fG(true);
            aVar.b(this.kBq.getPageContext());
            aVar.aEC();
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
                if (this.khN != null) {
                    this.khN.aP(6, com.baidu.tieba.k.a.q(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void cRq() {
        try {
            if (this.mCamera != null) {
                if (this.kBw == null) {
                    this.kBw = this.mCamera.getParameters();
                }
                if ("off".equals(this.kBw.getFlashMode())) {
                    this.kBw.setFlashMode("torch");
                } else {
                    this.kBw.setFlashMode("off");
                }
                this.mCamera.setParameters(this.kBw);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khN != null) {
                this.khN.aP(7, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    public boolean cRr() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.kBw == null) {
                this.kBw = this.mCamera.getParameters();
            }
            return !"off".equals(this.kBw.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khN != null) {
                this.khN.aP(7, com.baidu.tieba.k.a.q(e));
                return false;
            }
            return false;
        }
    }

    public void cRs() {
        if (this.kBy != null && (this.kBy instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.kBy;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.cRb();
            this.kBv = this.kBv == 0 ? 1 : 0;
            tv(this.kBv == 1);
            gLVideoPreviewView.cRc();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.kBy != null && (this.kBy instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kBy).h(this.mCamera);
            releaseCamera();
            this.kBv = this.kBv == 0 ? 1 : 0;
            tv(this.kBv == 1);
            startPreview();
        }
    }

    public boolean getIsFrontCamera() {
        return this.kBv == 1;
    }

    private void cRt() {
        this.previewWidth = 720;
        this.previewHeight = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRu() {
        if (this.kBt != null && this.kBs != null && this.kBs.getParent() != null) {
            this.kBt.removeView(this.kBs);
        }
    }

    private void cR(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.kBu.contains("auto")) {
                this.kBw = this.mCamera.getParameters();
                this.kBw.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.kBw);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.khN != null) {
                this.khN.aP(9, com.baidu.tieba.k.a.q(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends View {
        Bitmap bitmap;
        int left;

        /* renamed from: top  reason: collision with root package name */
        int f1028top;

        public a(Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.left = i;
            this.f1028top = i2;
            this.bitmap = bitmap;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.bitmap, this.left, this.f1028top, (Paint) null);
            super.onDraw(canvas);
        }
    }

    public void setBeautyLevel(com.baidu.tieba.video.a aVar) {
        if (this.kBy instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kBy).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.kBy instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kBy).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.kBy instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.kBy).setSticker(stickerItem);
        }
    }

    public void onResume() {
        tv(this.kBv == 1);
        if (this.kBy != null && (this.kBy instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kBy).onResume();
        }
        if (this.kBy != null && (this.kBy instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.kBy).onResume();
        }
        if (!com.baidu.tieba.video.record.c.cQW()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.kBx.h(this.mCamera);
        if (this.kBy != null && (this.kBy instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.kBy).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.kBD = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.kAY = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.kBx instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.kBx != null) {
                        h.this.kBx.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.kBx.a(aVar);
        }
    }

    public boolean getCameraIsBack() {
        return this.mCameraId == 0;
    }
}
