package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private int dSd;
    protected String gvf;
    private List<String> gzA;
    protected boolean gzB;
    private boolean gzE;
    private g gzF;
    private SurfaceView gzG;
    protected List<String> gzH;
    private b gzI;
    private int gzi;
    private int gzj;
    private RecordVideoActivity gzw;
    private Bitmap gzx;
    private a gzy;
    private FrameLayout gzz;
    private Camera mCamera;
    protected int mCameraId = -1;
    protected int gzC = 0;
    private Camera.Parameters gzD = null;
    private Handler mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.this.startPreview();
                    return;
                case 2:
                    if (h.this.gzw != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gzw, d.l.disallow_camera_permission);
                        h.this.gzw.finish();
                        return;
                    }
                    return;
                case 3:
                    if (h.this.gzw != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gzw, d.l.disallow_audio_record_permission);
                        h.this.gzw.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean fML = true;

    /* loaded from: classes2.dex */
    public interface b {
        void cc(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        this.gzw = recordVideoActivity;
        bxo();
        this.gzx = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.g.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.dSd = displayMetrics.widthPixels;
        this.gzz = this.gzw.bxv();
        if (Build.VERSION.SDK_INT >= 18) {
            f fVar = new f(recordVideoActivity, this);
            this.gzG = fVar;
            this.gzF = fVar;
        } else {
            l lVar = new l(recordVideoActivity, this);
            this.gzG = lVar;
            this.gzF = lVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bxv() != null) {
            recordVideoActivity.bxv().addView(this.gzG, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gzF.d(this.mCamera);
    }

    public void startRecord() {
        this.gzF.e(this.mCamera);
    }

    public void stopRecord() {
        this.gzF.f(this.mCamera);
    }

    public void bxc() {
        this.gzH = null;
    }

    public String bxd() {
        if (this.gzH == null) {
            this.gzH = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gtW);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gtW + System.currentTimeMillis() + ".mp4";
        this.gzH.add(str);
        return str;
    }

    public void bxe() {
        if (this.gzH != null && this.gzH.size() != 0) {
            File file = new File(this.gzH.get(0));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String bxf() {
        File file = new File(com.baidu.tieba.video.b.gtW);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.gvf = com.baidu.tieba.video.b.gtW + "f_" + System.currentTimeMillis() + ".mp4";
        return this.gvf;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dSd && x >= com.baidu.adp.lib.util.l.f(this.gzw, d.f.ds60)) {
                    int width = this.gzx.getWidth();
                    int height = this.gzx.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.dSd - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dSd - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gzz == null) {
                            this.gzz = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gzz.getChildCount()) {
                                if (this.gzy != this.gzz.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gzz.removeViewAt(i);
                                }
                            }
                        }
                        this.gzy = new a(this.gzw, clamp - (width / 2), clamp2 - (height / 2), this.gzx);
                        this.gzz.addView(this.gzy, new ViewGroup.LayoutParams(-2, -2));
                        cb(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bxp();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bxg() {
        if (this.mCamera == null && this.gzw != null) {
            this.gzw.finish();
            return;
        }
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, TbConfig.HEAD_IMG_SIZE);
        if (a2 != null) {
            this.gzi = a2.width;
            this.gzj = a2.height;
            this.gzD.setPreviewSize(this.gzi, this.gzj);
            if (this.gzF != null) {
                this.gzF.setPreviewSize(this.gzi, this.gzj);
            }
        }
        this.gzD.setPreviewFormat(17);
        bxh();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.g(this.gzw, this.mCameraId));
        this.gzA = this.gzD.getSupportedFocusModes();
        if (this.gzA != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gzA.contains("continuous-picture")) {
                this.gzD.setFocusMode("continuous-picture");
            } else if (this.gzA.contains("continuous-video")) {
                this.gzD.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gzD);
        if (this.gzw != null && this.gzw.bxv() != null) {
            int i = (int) (this.dSd * (this.gzi / (this.gzj * 1.0f)));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gzG.getLayoutParams();
            layoutParams.width = this.dSd;
            layoutParams.height = i;
            this.gzG.setLayoutParams(layoutParams);
            this.gzG.invalidate();
            if (this.gzI != null) {
                this.gzI.cc(layoutParams.width, layoutParams.height);
            }
        }
    }

    private void bxh() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gzD.getSupportedPreviewFpsRange()) {
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
        this.gzD.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void nh(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.nf(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.nf(z)) {
                    bxj();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bxi();
                this.gzB = z;
            } else {
                bxj();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bxj();
        }
    }

    private void bxi() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gzD = this.mCamera.getParameters();
            bxg();
        } catch (RuntimeException e) {
            e.printStackTrace();
            this.mMainHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    private void bxj() {
        if (this.gzw != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gzw.getPageContext().getPageActivity());
            aVar.cd(d.l.video_quit_confirm);
            aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gzw != null) {
                        h.this.gzw.finish();
                    }
                }
            });
            aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(this.gzw.getPageContext());
            aVar.ti();
        }
    }

    private void bxk() {
        if (this.mCamera != null) {
            this.mCamera.stopPreview();
            this.mCamera.setPreviewCallback(null);
            try {
                this.mCamera.setPreviewTexture(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void bxl() {
        try {
            if (this.mCamera != null) {
                if (this.gzD == null) {
                    this.gzD = this.mCamera.getParameters();
                }
                if ("off".equals(this.gzD.getFlashMode())) {
                    this.gzD.setFlashMode("torch");
                    this.gzE = true;
                } else {
                    this.gzD.setFlashMode("off");
                    this.gzE = false;
                }
                this.mCamera.setParameters(this.gzD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bxm() {
        return this.gzE;
    }

    public void bxn() {
        if (this.gzG != null && (this.gzG instanceof f)) {
            f fVar = (f) this.gzG;
            fVar.setIsChangingCamera(true);
            bxk();
            fVar.bwX();
            this.gzC = this.gzC == 0 ? 1 : 0;
            nh(this.gzC == 1);
            fVar.bwY();
            fVar.setIsChangingCamera(false);
        } else if (this.gzG != null && (this.gzG instanceof l)) {
            ((l) this.gzG).g(this.mCamera);
            bxk();
            this.gzC = this.gzC == 0 ? 1 : 0;
            nh(this.gzC == 1);
            startPreview();
        }
        this.fML = this.fML ? false : true;
    }

    private void bxo() {
        this.gzi = 720;
        this.gzj = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxp() {
        if (this.gzz != null && this.gzy != null) {
            this.gzz.removeView(this.gzy);
        }
    }

    private void cb(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gzA.contains("auto")) {
                this.gzD.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gzD);
            this.mCamera.autoFocus(null);
        } catch (Exception e) {
            e.printStackTrace();
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
        if (this.gzG instanceof f) {
            ((f) this.gzG).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gzG instanceof f) {
            ((f) this.gzG).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gzG instanceof f) {
            ((f) this.gzG).setSticker(stickerItem);
        }
    }

    public void onResume() {
        nh(this.gzC == 1);
        if (this.gzG != null && (this.gzG instanceof f)) {
            ((f) this.gzG).onResume();
        }
        if (this.gzG != null && (this.gzG instanceof l)) {
            ((l) this.gzG).onResume();
        }
        if (!com.baidu.tieba.video.record.b.bwU()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bxk();
        this.gzF.g(this.mCamera);
        if (this.gzG != null && (this.gzG instanceof f)) {
            ((f) this.gzG).onPause();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.gzI = bVar;
        }
    }
}
