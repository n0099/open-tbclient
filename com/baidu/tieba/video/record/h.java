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
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private int drR;
    private int drS;
    private com.baidu.tieba.j.h heb;
    protected String hsy;
    private RecordVideoActivity hxO;
    private Bitmap hxP;
    private a hxQ;
    private FrameLayout hxR;
    private List<String> hxS;
    protected boolean hxT;
    private g hxW;
    private SurfaceView hxX;
    protected List<String> hxY;
    private b hxZ;
    private GLVideoPreviewView.a hxu;
    private com.baidu.tieba.video.record.b hya;
    private GLVideoPreviewView.a hyb;
    private c hyc;
    private Camera mCamera;
    private Handler mMainHandler;
    private int screenHeight;
    private int screenWidth;
    protected int mCameraId = -1;
    protected int hxU = 0;
    private Camera.Parameters hxV = null;

    /* loaded from: classes5.dex */
    public interface b {
        void bIL();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void bW(int i, int i2);
    }

    public void O(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.aP(false);
        aVar.cy(e.j.request_permission_default_title);
        aVar.cz(e.j.request_permission_camera);
        aVar.a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.video.record.h.3
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
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(com.baidu.adp.base.i.aK(activity));
        aVar.Au();
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
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
                        if (h.this.hxO != null) {
                            if ("OD103".equals(Build.MODEL)) {
                                h.this.O(h.this.hxO);
                                return;
                            }
                            com.baidu.adp.lib.util.l.showToast(h.this.hxO, e.j.disallow_camera_permission);
                            if (h.this.heb != null) {
                                if (!(message.obj instanceof String)) {
                                    string = h.this.hxO.getResources().getString(e.j.disallow_camera_permission);
                                } else {
                                    string = (String) message.obj;
                                }
                                h.this.heb.ab(1, string);
                            }
                            h.this.hxO.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (h.this.hxO != null) {
                            com.baidu.adp.lib.util.l.showToast(h.this.hxO, e.j.disallow_audio_record_permission);
                            if (h.this.heb != null) {
                                h.this.heb.ab(2, h.this.hxO.getResources().getString(e.j.disallow_audio_record_permission));
                            }
                            h.this.hxO.finish();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hyb = new GLVideoPreviewView.a() { // from class: com.baidu.tieba.video.record.h.4
            @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
            public void nO(final boolean z) {
                if (h.this.hxu != null) {
                    com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.video.record.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.hxu.nO(z);
                        }
                    });
                }
            }
        };
        this.hxO = recordVideoActivity;
        bIJ();
        this.hxP = BitmapFactory.decodeResource(recordVideoActivity.getResources(), e.f.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.hxR = this.hxO.bJb();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.hxX = gLVideoPreviewView;
            this.hxW = gLVideoPreviewView;
            ((GLVideoPreviewView) this.hxX).setFaceIdentifyStateListener(this.hyb);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.hxX = videoPreviewView;
            this.hxW = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.bJb() != null) {
            recordVideoActivity.bJb().addView(this.hxX, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.hxW.e(this.mCamera);
    }

    public void startRecord() {
        this.hxW.f(this.mCamera);
    }

    public void stopRecord() {
        this.hxW.g(this.mCamera);
    }

    public g bIw() {
        return this.hxW;
    }

    public String bIx() {
        if (this.hxY == null) {
            this.hxY = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.c.hqN);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.c.hqN + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.hxY.add(str);
        return str;
    }

    public void bIy() {
        if (this.hxY != null && this.hxY.size() != 0) {
            String remove = this.hxY.remove(this.hxY.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public String bIz() {
        File file = new File(com.baidu.tieba.video.c.hqN);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.hsy = com.baidu.tieba.video.c.hqN + "f_" + System.currentTimeMillis() + ".mp4";
        return this.hsy;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.hxZ != null && motionEvent.getAction() == 0) {
            this.hxZ.bIL();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return b(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.this.bIK();
                }
            }, 100L);
            return true;
        }
        return true;
    }

    public void a(b bVar) {
        this.hxZ = bVar;
    }

    public boolean b(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.screenHeight && x >= com.baidu.adp.lib.util.l.h(this.hxO, e.C0175e.ds60)) {
                    int width = this.hxP.getWidth();
                    int height = this.hxP.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.screenWidth - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.screenHeight - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.hxR == null) {
                            this.hxR = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.hxR.getChildCount()) {
                                if (this.hxQ != this.hxR.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.hxR.removeViewAt(i);
                                }
                            }
                        }
                        this.hxQ = new a(this.hxO, clamp - (width / 2), clamp2 - (height / 2), this.hxP);
                        this.hxR.addView(this.hxQ, new ViewGroup.LayoutParams(-2, -2));
                        bV(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bIK();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bIA() {
        int i;
        int i2;
        if (this.mCamera == null && this.hxO != null) {
            this.hxO.finish();
            return;
        }
        int aO = com.baidu.adp.lib.util.l.aO(this.hxO.getPageContext().getPageActivity());
        int screenHeight = getScreenHeight(this.hxO.getPageContext().getPageActivity());
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, (int) (720 * ((screenHeight * 1.0f) / aO)));
        if (a2 != null) {
            this.drR = a2.width;
            this.drS = a2.height;
            this.hxV.setPreviewSize(this.drR, this.drS);
            if (this.hxW != null) {
                this.hxW.setPreviewSize(this.drR, this.drS);
            }
        }
        this.hxV.setPreviewFormat(17);
        bIB();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.hxO, this.mCameraId));
        this.hxS = this.hxV.getSupportedFocusModes();
        if (this.hxS != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.hxS.contains("continuous-picture")) {
                this.hxV.setFocusMode("continuous-picture");
            } else if (this.hxS.contains("continuous-video")) {
                this.hxV.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.hxV);
        if (this.hxO != null && this.hxO.bJb() != null) {
            float f = (aO * 1.0f) / screenHeight;
            float f2 = (this.drS * 1.0f) / this.drR;
            if (f > f2) {
                i = aO;
                i2 = (int) (aO / f2);
            } else {
                i = (int) (screenHeight * f2);
                i2 = screenHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hxX.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hxX.setLayoutParams(layoutParams);
            this.hxX.invalidate();
            if (this.hyc != null) {
                this.hyc.bW(layoutParams.width, layoutParams.height);
            }
        }
    }

    public int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.l.aQ(context);
        }
        return i;
    }

    private void bIB() {
        int i;
        int i2;
        int[] iArr;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.hxV.getSupportedPreviewFpsRange()) {
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
        this.hxV.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nP(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nL(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nL(z)) {
                    bIE();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.nM(z);
            if (-1 != this.mCameraId) {
                bID();
                this.hya = new com.baidu.tieba.video.record.b(this.mCamera);
                this.hxT = z;
            } else {
                bIE();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bIE();
            if (this.heb != null) {
                this.heb.ab(8, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public com.baidu.tieba.video.record.b bIC() {
        return this.hya;
    }

    private void bID() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.hxV = this.mCamera.getParameters();
            bIA();
        } catch (RuntimeException e) {
            e.printStackTrace();
            Message obtainMessage = this.mMainHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = com.baidu.tieba.j.a.o(e);
            this.mMainHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void bIE() {
        if (this.hxO != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hxO.getPageContext().getPageActivity());
            aVar.cz(e.j.video_quit_confirm);
            aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.hxO != null) {
                        h.this.hxO.finish();
                    }
                }
            });
            aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aO(true);
            aVar.b(this.hxO.getPageContext());
            aVar.Au();
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
                if (this.heb != null) {
                    this.heb.ab(6, com.baidu.tieba.j.a.o(e));
                }
            }
            this.mCamera = null;
        }
    }

    public void bIF() {
        try {
            if (this.mCamera != null) {
                if (this.hxV == null) {
                    this.hxV = this.mCamera.getParameters();
                }
                if (ARCameraAttr.FlashType.FLASH_OFF.equals(this.hxV.getFlashMode())) {
                    this.hxV.setFlashMode("torch");
                } else {
                    this.hxV.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                }
                this.mCamera.setParameters(this.hxV);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.heb != null) {
                this.heb.ab(7, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    public boolean bIG() {
        try {
            if (this.mCamera == null) {
                return false;
            }
            if (this.hxV == null) {
                this.hxV = this.mCamera.getParameters();
            }
            return !ARCameraAttr.FlashType.FLASH_OFF.equals(this.hxV.getFlashMode());
        } catch (Exception e) {
            e.printStackTrace();
            if (this.heb != null) {
                this.heb.ab(7, com.baidu.tieba.j.a.o(e));
                return false;
            }
            return false;
        }
    }

    public void bIH() {
        if (this.hxX != null && (this.hxX instanceof GLVideoPreviewView)) {
            GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) this.hxX;
            gLVideoPreviewView.setIsChangingCamera(true);
            releaseCamera();
            gLVideoPreviewView.bIp();
            this.hxU = this.hxU == 0 ? 1 : 0;
            nP(this.hxU == 1);
            gLVideoPreviewView.bIq();
            gLVideoPreviewView.setIsChangingCamera(false);
        } else if (this.hxX != null && (this.hxX instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hxX).h(this.mCamera);
            releaseCamera();
            this.hxU = this.hxU == 0 ? 1 : 0;
            nP(this.hxU == 1);
            startPreview();
        }
    }

    public boolean bII() {
        return this.hxU == 1;
    }

    private void bIJ() {
        this.drR = 720;
        this.drS = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIK() {
        if (this.hxR != null && this.hxQ != null && this.hxQ.getParent() != null) {
            this.hxR.removeView(this.hxQ);
        }
    }

    private void bV(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.hxS.contains("auto")) {
                this.hxV = this.mCamera.getParameters();
                this.hxV.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.hxV);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.heb != null) {
                this.heb.ab(9, com.baidu.tieba.j.a.o(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
        if (this.hxX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hxX).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.hxX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hxX).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.hxX instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) this.hxX).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nP(this.hxU == 1);
        if (this.hxX != null && (this.hxX instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hxX).onResume();
        }
        if (this.hxX != null && (this.hxX instanceof VideoPreviewView)) {
            ((VideoPreviewView) this.hxX).onResume();
        }
        if (!com.baidu.tieba.video.record.c.bIk()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        releaseCamera();
        this.hxW.h(this.mCamera);
        if (this.hxX != null && (this.hxX instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) this.hxX).onPause();
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hyc = cVar;
        }
    }

    public void setFaceIdentifyStateListener(GLVideoPreviewView.a aVar) {
        if (aVar != null) {
            this.hxu = aVar;
        }
    }

    public void a(final g.a aVar) {
        if (this.hxW instanceof GLSurfaceView) {
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.9
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.hxW != null) {
                        h.this.hxW.a(aVar);
                    }
                }
            }, 500L);
        } else {
            this.hxW.a(aVar);
        }
    }

    public boolean bIu() {
        return this.mCameraId == 0;
    }
}
