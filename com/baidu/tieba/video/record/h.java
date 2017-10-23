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
    private int dRP;
    protected String guQ;
    private int gyT;
    private int gyU;
    private RecordVideoActivity gzg;
    private Bitmap gzh;
    private a gzi;
    private FrameLayout gzj;
    private List<String> gzk;
    protected boolean gzl;
    private boolean gzo;
    private g gzp;
    private SurfaceView gzq;
    protected List<String> gzr;
    private b gzs;
    private Camera mCamera;
    protected int mCameraId = -1;
    protected int gzm = 0;
    private Camera.Parameters gzn = null;
    private Handler mMainHandler = new Handler() { // from class: com.baidu.tieba.video.record.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.this.startPreview();
                    return;
                case 2:
                    if (h.this.gzg != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gzg, d.l.disallow_camera_permission);
                        h.this.gzg.finish();
                        return;
                    }
                    return;
                case 3:
                    if (h.this.gzg != null) {
                        com.baidu.adp.lib.util.l.showToast(h.this.gzg, d.l.disallow_audio_record_permission);
                        h.this.gzg.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean fMw = true;

    /* loaded from: classes2.dex */
    public interface b {
        void cc(int i, int i2);
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public h(RecordVideoActivity recordVideoActivity) {
        this.gzg = recordVideoActivity;
        bxf();
        this.gzh = BitmapFactory.decodeResource(recordVideoActivity.getResources(), d.g.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.dRP = displayMetrics.widthPixels;
        this.gzj = this.gzg.bxm();
        if (Build.VERSION.SDK_INT >= 18) {
            f fVar = new f(recordVideoActivity, this);
            this.gzq = fVar;
            this.gzp = fVar;
        } else {
            l lVar = new l(recordVideoActivity, this);
            this.gzq = lVar;
            this.gzp = lVar;
        }
        if (recordVideoActivity != null && recordVideoActivity.bxm() != null) {
            recordVideoActivity.bxm().addView(this.gzq, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void startPreview() {
        this.gzp.d(this.mCamera);
    }

    public void startRecord() {
        this.gzp.e(this.mCamera);
    }

    public void stopRecord() {
        this.gzp.f(this.mCamera);
    }

    public void bwT() {
        this.gzr = null;
    }

    public String bwU() {
        if (this.gzr == null) {
            this.gzr = new ArrayList();
        }
        File file = new File(com.baidu.tieba.video.b.gtH);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = com.baidu.tieba.video.b.gtH + System.currentTimeMillis() + ".mp4";
        this.gzr.add(str);
        return str;
    }

    public void bwV() {
        if (this.gzr != null && this.gzr.size() != 0) {
            File file = new File(this.gzr.get(0));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String bwW() {
        File file = new File(com.baidu.tieba.video.b.gtH);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.guQ = com.baidu.tieba.video.b.gtH + "f_" + System.currentTimeMillis() + ".mp4";
        return this.guQ;
    }

    public boolean a(MotionEvent motionEvent, ViewParent viewParent) {
        switch (motionEvent.getAction()) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.dRP && x >= com.baidu.adp.lib.util.l.f(this.gzg, d.f.ds60)) {
                    int width = this.gzh.getWidth();
                    int height = this.gzh.getHeight();
                    int clamp = com.baidu.tieba.video.record.a.clamp(x, width / 2, this.dRP - (width / 2));
                    int clamp2 = com.baidu.tieba.video.record.a.clamp(y, height / 2, this.dRP - (height / 2));
                    if (viewParent != null && (viewParent instanceof FrameLayout)) {
                        if (this.gzj == null) {
                            this.gzj = (FrameLayout) viewParent;
                        }
                        int i = 0;
                        while (true) {
                            if (i < this.gzj.getChildCount()) {
                                if (this.gzi != this.gzj.getChildAt(i)) {
                                    i++;
                                } else {
                                    this.gzj.removeViewAt(i);
                                }
                            }
                        }
                        this.gzi = new a(this.gzg, clamp - (width / 2), clamp2 - (height / 2), this.gzh);
                        this.gzj.addView(this.gzi, new ViewGroup.LayoutParams(-2, -2));
                        cb(clamp, clamp2);
                        break;
                    }
                }
                break;
            case 1:
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.bxg();
                    }
                }, 800L);
                break;
        }
        return true;
    }

    public void bwX() {
        if (this.mCamera == null && this.gzg != null) {
            this.gzg.finish();
            return;
        }
        Camera.Size a2 = com.baidu.tieba.video.record.a.a(this.mCamera, 720, TbConfig.HEAD_IMG_SIZE);
        if (a2 != null) {
            this.gyT = a2.width;
            this.gyU = a2.height;
            this.gzn.setPreviewSize(this.gyT, this.gyU);
            if (this.gzp != null) {
                this.gzp.setPreviewSize(this.gyT, this.gyU);
            }
        }
        this.gzn.setPreviewFormat(17);
        bwY();
        this.mCamera.setDisplayOrientation(com.baidu.tieba.video.record.a.h(this.gzg, this.mCameraId));
        this.gzk = this.gzn.getSupportedFocusModes();
        if (this.gzk != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.gzk.contains("continuous-picture")) {
                this.gzn.setFocusMode("continuous-picture");
            } else if (this.gzk.contains("continuous-video")) {
                this.gzn.setFocusMode("continuous-video");
            }
        }
        this.mCamera.setParameters(this.gzn);
        if (this.gzg != null && this.gzg.bxm() != null) {
            int i = (int) (this.dRP * (this.gyT / (this.gyU * 1.0f)));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gzq.getLayoutParams();
            layoutParams.width = this.dRP;
            layoutParams.height = i;
            this.gzq.setLayoutParams(layoutParams);
            this.gzq.invalidate();
            if (this.gzs != null) {
                this.gzs.cc(layoutParams.width, layoutParams.height);
            }
        }
    }

    private void bwY() {
        int i;
        int i2;
        int[] iArr;
        int i3 = Integer.MAX_VALUE;
        int[] iArr2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr3 : this.gzn.getSupportedPreviewFpsRange()) {
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
        this.gzn.setPreviewFpsRange(iArr2[0], iArr2[1]);
    }

    public void ng(boolean z) {
        try {
            if (!com.baidu.tieba.video.record.a.ne(z)) {
                z = !z;
                if (!com.baidu.tieba.video.record.a.ne(z)) {
                    bxa();
                }
            }
            this.mCameraId = com.baidu.tieba.video.record.a.getCameraId(z);
            if (-1 != this.mCameraId) {
                bwZ();
                this.gzl = z;
            } else {
                bxa();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bxa();
        }
    }

    private void bwZ() {
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.gzn = this.mCamera.getParameters();
            bwX();
        } catch (RuntimeException e) {
            e.printStackTrace();
            this.mMainHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    private void bxa() {
        if (this.gzg != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gzg.getPageContext().getPageActivity());
            aVar.cc(d.l.video_quit_confirm);
            aVar.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.h.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (h.this.gzg != null) {
                        h.this.gzg.finish();
                    }
                }
            });
            aVar.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.h.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aq(true);
            aVar.b(this.gzg.getPageContext());
            aVar.tb();
        }
    }

    private void bxb() {
        if (this.mCamera != null) {
            try {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.setPreviewTexture(null);
                this.mCamera.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mCamera = null;
        }
    }

    public void bxc() {
        try {
            if (this.mCamera != null) {
                if (this.gzn == null) {
                    this.gzn = this.mCamera.getParameters();
                }
                if ("off".equals(this.gzn.getFlashMode())) {
                    this.gzn.setFlashMode("torch");
                    this.gzo = true;
                } else {
                    this.gzn.setFlashMode("off");
                    this.gzo = false;
                }
                this.mCamera.setParameters(this.gzn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bxd() {
        return this.gzo;
    }

    public void bxe() {
        if (this.gzq != null && (this.gzq instanceof f)) {
            f fVar = (f) this.gzq;
            fVar.setIsChangingCamera(true);
            bxb();
            fVar.bwO();
            this.gzm = this.gzm == 0 ? 1 : 0;
            ng(this.gzm == 1);
            fVar.bwP();
            fVar.setIsChangingCamera(false);
        } else if (this.gzq != null && (this.gzq instanceof l)) {
            ((l) this.gzq).g(this.mCamera);
            bxb();
            this.gzm = this.gzm == 0 ? 1 : 0;
            ng(this.gzm == 1);
            startPreview();
        }
        this.fMw = this.fMw ? false : true;
    }

    private void bxf() {
        this.gyT = 720;
        this.gyU = TbConfig.HEAD_IMG_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxg() {
        if (this.gzj != null && this.gzi != null) {
            this.gzj.removeView(this.gzi);
        }
    }

    private void cb(int i, int i2) {
        try {
            this.mCamera.cancelAutoFocus();
            if (this.gzk.contains("auto")) {
                this.gzn.setFocusMode("auto");
            }
            this.mCamera.setParameters(this.gzn);
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
        if (this.gzq instanceof f) {
            ((f) this.gzq).setBeautyLevel(aVar);
        }
    }

    public void setFilter(String str) {
        if (this.gzq instanceof f) {
            ((f) this.gzq).setFilter(str);
        }
    }

    public void setSticker(StickerItem stickerItem) {
        if (this.gzq instanceof f) {
            ((f) this.gzq).setSticker(stickerItem);
        }
    }

    public void onResume() {
        ng(this.gzm == 1);
        if (this.gzq != null && (this.gzq instanceof f)) {
            ((f) this.gzq).onResume();
        }
        if (this.gzq != null && (this.gzq instanceof l)) {
            ((l) this.gzq).onResume();
        }
        if (!com.baidu.tieba.video.record.b.bwL()) {
            this.mMainHandler.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public void onPause() {
        bxb();
        this.gzp.g(this.mCamera);
        if (this.gzq != null && (this.gzq instanceof f)) {
            ((f) this.gzq).onPause();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.gzs = bVar;
        }
    }
}
