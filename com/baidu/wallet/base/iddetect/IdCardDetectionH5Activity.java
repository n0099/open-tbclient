package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.camera.util.ImageUtils;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class IdCardDetectionH5Activity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static int s = 1;
    public View k;
    public TextView n;
    public Bitmap t;
    public Bitmap u;
    public Bitmap v;

    /* renamed from: e  reason: collision with root package name */
    public final String f24036e = IdCardDetectionH5Activity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public View f24037f = null;

    /* renamed from: g  reason: collision with root package name */
    public View f24038g = null;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f24039h = null;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f24040i = null;
    public TextView j = null;
    public TextView l = null;
    public ImageView m = null;
    public TextView o = null;
    public ImageView p = null;
    public AtomicBoolean q = new AtomicBoolean(false);
    public String r = "";
    public Bundle w = new Bundle();

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getAutoFocusDelay() {
        return 3000L;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        return View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_h5_detection_activity"), null);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getFirstFocusDelay() {
        return 2000L;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        return 0.631f;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        return this;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        return 0;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        return true;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (ResUtils.id(getActivity(), "idcards_flash_light_switch") == id) {
            triggerFlash();
        } else if (ResUtils.id(getActivity(), "idcards_take_pic_start") == id) {
            if (this.q.compareAndSet(false, true)) {
                view.setClickable(false);
                takePicture();
            }
        } else if (ResUtils.id(getActivity(), "idcard_take_pic_finish") == id) {
            int i2 = s;
            String str = "pic2";
            switch (i2) {
                case 1:
                    this.w.putInt("step", i2);
                    s++;
                    a(Boolean.TRUE);
                    this.w.putString("pic1", this.r);
                    return;
                case 2:
                    String saveBitmapToCache = ImageUtils.saveBitmapToCache(getActivity(), this.v, System.currentTimeMillis() + ".jpg");
                    this.r = saveBitmapToCache;
                    this.w.putString("pic2", saveBitmapToCache);
                    s = 1;
                    IdCardDetectionController.getInstance().IdCardDeteSuccess(this.w);
                    finishWithoutAnim();
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.w.putInt("step", i2);
                    this.r = ImageUtils.saveBitmapToCache(getActivity(), this.v, System.currentTimeMillis() + "");
                    Bundle bundle = this.w;
                    int i3 = s;
                    bundle.putString((i3 == 5 || i3 == 6) ? "pic1" : "pic1", this.r);
                    s = 1;
                    IdCardDetectionController.getInstance().IdCardDeteSuccess(this.w);
                    finishWithoutAnim();
                    return;
                default:
                    finishWithoutAnim();
                    return;
            }
        } else if (ResUtils.id(getActivity(), "idcard_restart_take_pic") == id) {
            a(Boolean.FALSE);
        } else if (ResUtils.id(getActivity(), "idcards_title_back") == id) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            finishWithoutAnim();
        } else if (view == this.f24037f) {
            stopCamera();
            switchCamera();
            if (!CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.f24038g.setVisibility(4);
            } else if (this.cameraId == 1) {
                this.f24038g.setVisibility(4);
                this.f24038g.setBackgroundResource(ResUtils.drawable(getActivity(), "wallet_base_camera_flashlight_off_btn"));
            } else {
                this.f24038g.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s = extras.getInt("step");
        }
        this.f24038g = findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
        this.f24037f = findViewById(ResUtils.id(getActivity(), "idcards_camera_switch"));
        this.j = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
        this.k = findViewById(ResUtils.id(getActivity(), "wallet_camera_control_area"));
        this.n = (TextView) findViewById(ResUtils.id(getActivity(), "TextView1"));
        this.f24039h = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
        this.f24040i = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
        this.o = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
        this.l = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
        this.m = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.f24038g.setOnClickListener(this);
            this.f24038g.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.f24038g, "打开闪光灯");
        } else {
            this.f24038g.setVisibility(4);
        }
        this.f24037f.setVisibility(CameraCtrl.getInstance().isSupportMultiCamera() ? 0 : 8);
        this.f24037f.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.l.setOnClickListener(this);
        findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
        this.p = imageView;
        imageView.setOnClickListener(this);
        this.mPreviewView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    IdCardDetectionH5Activity.this.autoFoucus();
                    return true;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.t;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.t.recycle();
        this.t = null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(final Object[] objArr) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity.2
            @Override // java.lang.Runnable
            public void run() {
                IdCardDetectionH5Activity.this.j.setVisibility(8);
                IdCardDetectionH5Activity.this.k.setVisibility(8);
                TextView textView = IdCardDetectionH5Activity.this.n;
                IdCardDetectionH5Activity idCardDetectionH5Activity = IdCardDetectionH5Activity.this;
                textView.setText(idCardDetectionH5Activity.getString(ResUtils.string(idCardDetectionH5Activity.getActivity(), "wallet_base_h5_idcard_title2")));
                IdCardDetectionH5Activity.this.f24039h.setVisibility(8);
                IdCardDetectionH5Activity.this.f24040i.setVisibility(0);
                IdCardDetectionH5Activity.this.m.setVisibility(0);
                IdCardDetectionH5Activity.this.v = (Bitmap) objArr[0];
                IdCardDetectionH5Activity.this.m.setImageBitmap(IdCardDetectionH5Activity.this.v);
                IdCardDetectionH5Activity.this.restartScan();
                IdCardDetectionH5Activity.this.q.compareAndSet(true, false);
                IdCardDetectionH5Activity.this.p.setClickable(true);
            }
        });
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        switch (s) {
            case 1:
            case 3:
            case 5:
                this.j.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_hand"));
                return;
            case 2:
            case 4:
                this.j.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_hand"));
                return;
            case 6:
                this.j.setText("");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        if (this.mInCaptureTimeOut.compareAndSet(true, false)) {
            LogUtil.d(this.f24036e, "preview process");
            PayStatisticsUtil.onEvent(StatServiceEvent.SDK_SELF_DEFINE_TAKE_PICTURE_FAILED);
            if (this.q.get()) {
                rect.set(0, 0, i2, i3);
                if (this.t == null) {
                    this.t = Bitmap.createBitmap(rect.height(), rect.width(), Bitmap.Config.ARGB_8888);
                }
                Yuv.rotateCropBmp(bArr, i2, i3, rect.left, rect.top, 270, this.t);
                return new Bitmap[]{this.t};
            }
        }
        return null;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        if (this.q.get()) {
            LogUtil.d(this.f24036e, "takepic process");
            Bitmap a2 = com.baidu.wallet.base.iddetect.utils.a.a(bArr, i2, i3);
            this.u = a2;
            if (a2 != null) {
                if (this.cameraId == 1) {
                    this.u = ImageUtils.rotateAReversalBitmap(270, a2);
                } else {
                    this.u = ImageUtils.rotateBitmap(90, a2);
                }
            }
            return new Bitmap[]{this.u};
        }
        return null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        if (this.f24038g == null) {
            return;
        }
        this.f24038g.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f24038g, z ? "关闭闪光灯" : "打开闪光灯");
    }

    private void a(Boolean bool) {
        if (bool.booleanValue()) {
            Activity activity = getActivity();
            Bitmap bitmap = this.v;
            this.r = ImageUtils.saveBitmapToCache(activity, bitmap, System.currentTimeMillis() + ".jpg");
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.n.setText(getString(ResUtils.string(getActivity(), "wallet_base_h5_idcard_title_take_pic")));
        this.f24039h.setVisibility(0);
        this.f24040i.setVisibility(8);
        this.m.setVisibility(8);
        onResume();
    }
}
