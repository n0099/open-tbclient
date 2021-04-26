package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.camera.util.ImageUtils;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.MistView;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class IdentityCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static int x = 1;

    /* renamed from: g  reason: collision with root package name */
    public MistView f24046g;
    public Bitmap y;
    public Bitmap z;

    /* renamed from: e  reason: collision with root package name */
    public final String f24044e = IdentityCardDetectionActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public final int f24045f = 17;

    /* renamed from: h  reason: collision with root package name */
    public View f24047h = null;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f24048i = null;
    public RelativeLayout j = null;
    public LinearLayout k = null;
    public TextView l = null;
    public TextView m = null;
    public ImageView n = null;
    public FrameLayout o = null;
    public ImageView p = null;
    public ImageView q = null;
    public TextView r = null;
    public TextView s = null;
    public ImageView t = null;
    public AtomicBoolean u = new AtomicBoolean(false);
    public String v = "";
    public String w = "";
    public Bundle A = new Bundle();
    public boolean B = true;

    public void deleteReady2USeFile() {
        File file = new File(this.w);
        if (file.exists()) {
            file.delete();
        }
        this.w = "";
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getAutoFocusDelay() {
        return 3000L;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_card_detection_activity"), null);
        this.f24046g = mistView;
        return mistView;
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

    public void getPicFinished() {
        int i2 = x;
        if (i2 == 1) {
            this.A.putInt("step", i2);
            x++;
            a(Boolean.TRUE);
            this.A.putString("pic1", this.v);
            this.f24046g.setMistColor(MistView.MASK_COLOR_DEFAULT_TRANSPARENT);
            restartScan();
        } else if (i2 == 2) {
            String str = this.w;
            this.v = str;
            this.A.putString("pic2", str);
            x = 1;
            IdCardDetectionController.getInstance().IdCardDeteSuccess(this.A);
            finishWithoutAnim();
        } else if (i2 != 3 && i2 != 4) {
            finishWithoutAnim();
        } else {
            this.A.putInt("step", x);
            this.v = this.w;
            this.A.putString(x != 3 ? "pic2" : "pic1", this.v);
            x = 1;
            IdCardDetectionController.getInstance().IdCardDeteSuccess(this.A);
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        return 0;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        return true;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 17) {
            pauseCamera();
            Uri uri = null;
            if (intent != null && intent.getData() != null) {
                uri = intent.getData();
            }
            if (uri == null) {
                return;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = ImageUtils.calSampleSize(getActivity(), uri);
                Bitmap bitmapFromUri = ImageUtils.getBitmapFromUri(getActivity(), uri, options);
                Activity activity = getActivity();
                this.w = ImageUtils.saveBitmapToCache(activity, bitmapFromUri, System.currentTimeMillis() + ".jpg", 90);
                if (bitmapFromUri != null) {
                    bitmapFromUri.recycle();
                }
                if (x == 1) {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_idcard_promo_f_album_tips"));
                }
                getPicFinished();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
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
            return;
        }
        if (ResUtils.id(getActivity(), "idcards_take_pic_start") == id) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_FRONTPAGE_IDAUTH_TYPE_CAMERA_SHOOT, x != 1 ? "1" : "0");
            if (this.u.compareAndSet(false, true)) {
                view.setClickable(false);
                takePicture();
            }
        } else if (ResUtils.id(getActivity(), "idcard_take_pic_finish") == id) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_FRONT_PAGE_IDAUTH_TYPE_CARMERA_FINISH, x != 2 ? "1" : "0");
            getPicFinished();
        } else if (ResUtils.id(getActivity(), "idcard_restart_take_pic") == id) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_FRONTPAGE_IDAUTH_TYPE_CAMERA_AGAGIN, x != 2 ? "1" : "0");
            deleteReady2USeFile();
            a(Boolean.FALSE);
            this.f24046g.setMistColor(MistView.MASK_COLOR_DEFAULT_TRANSPARENT);
            restartScan();
        } else if (ResUtils.id(getActivity(), "idcards_title_back") == id) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            finishWithoutAnim();
        } else if (ResUtils.id(getActivity(), "idcards_open_album") != id || CheckUtils.isFastDoubleClick()) {
        } else {
            int i2 = x;
            PayStatisticsUtil.onEvent((i2 == 1 || i2 == 3) ? StatServiceEvent.RNAUTH_MANUEL_CLICK_OPEN_ALBUM_TO_FRONT : StatServiceEvent.RNAUTH_MANUEL_CLICK_OPEN_ALBUM_TO_BACK);
            a();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            x = extras.getInt("step");
            this.B = extras.getBoolean("show_album");
        }
        this.f24047h = findViewById(ResUtils.id(getActivity(), "focus_view"));
        this.f24048i = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
        this.l = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
        this.j = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
        this.k = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
        this.r = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
        this.m = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
        this.n = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
        this.o = (FrameLayout) findViewById(ResUtils.id(getActivity(), "img_display_layout"));
        this.q = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_prompt_image_view_b"));
        this.p = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_prompt_image_view_f"));
        TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "idcards_open_album"));
        this.s = textView;
        textView.setOnClickListener(this);
        if (!this.B) {
            this.s.setVisibility(8);
        }
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.f24048i.setOnClickListener(this);
            this.f24048i.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.f24048i, "打开闪光灯");
        } else {
            this.f24048i.setVisibility(4);
        }
        this.r.setOnClickListener(this);
        this.m.setOnClickListener(this);
        findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
        this.t = imageView;
        imageView.setOnClickListener(this);
        this.mPreviewView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    IdentityCardDetectionActivity.this.autoFoucus();
                    return true;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.y;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.y.recycle();
        this.y = null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(final Object[] objArr) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.3
            @Override // java.lang.Runnable
            public void run() {
                IdentityCardDetectionActivity.this.f24047h.setVisibility(8);
                IdentityCardDetectionActivity.this.l.setVisibility(8);
                IdentityCardDetectionActivity.this.j.setVisibility(8);
                IdentityCardDetectionActivity.this.k.setVisibility(0);
                long currentTimeMillis = System.currentTimeMillis();
                IdentityCardDetectionActivity identityCardDetectionActivity = IdentityCardDetectionActivity.this;
                identityCardDetectionActivity.w = ImageUtils.saveBitmapToCache(identityCardDetectionActivity.getActivity(), (Bitmap) objArr[0], System.currentTimeMillis() + ".jpg", 90);
                Bitmap bPfromsdcard = ImageUtils.getBPfromsdcard(IdentityCardDetectionActivity.this.w);
                LogUtil.i("IdentityCardDetectionActivity", "re save and show time:" + (System.currentTimeMillis() - currentTimeMillis));
                IdentityCardDetectionActivity.this.n.setImageBitmap(bPfromsdcard);
                IdentityCardDetectionActivity.this.pauseCamera();
                IdentityCardDetectionActivity.this.u.compareAndSet(true, false);
                IdentityCardDetectionActivity.this.t.setClickable(true);
            }
        });
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i2 = x;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                }
            }
            this.l.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_b"));
            this.q.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.l.setText(ResUtils.string(getActivity(), "wallet_base_idcard_promo_f"));
        this.q.setVisibility(8);
        this.p.setVisibility(0);
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        if (this.mInCaptureTimeOut.compareAndSet(true, false)) {
            LogUtil.d(this.f24044e, "preview process");
            PayStatisticsUtil.onEvent(StatServiceEvent.SDK_FRONTPAGE_IDAUTH_TYPE_TAKE_PICTURE_FAILED);
            if (this.u.get()) {
                rect.set(0, 0, i2, i3);
                if (this.y == null) {
                    this.y = Bitmap.createBitmap(rect.height(), rect.width(), Bitmap.Config.ARGB_8888);
                }
                Yuv.rotateCropBmp(bArr, i2, i3, rect.left, rect.top, 270, this.y);
                return new Bitmap[]{this.y};
            }
        }
        return null;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        if (this.u.get()) {
            LogUtil.d(this.f24044e, "takepic process");
            Bitmap a2 = com.baidu.wallet.base.iddetect.utils.a.a(bArr, i2, i3);
            this.z = a2;
            if (a2 != null) {
                this.z = ImageUtils.rotateBitmap(90, a2);
            }
            return new Bitmap[]{this.z};
        }
        return null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        final ViewGroup.LayoutParams layoutParams = this.f24047h.getLayoutParams();
        int width = this.f24047h.getWidth();
        layoutParams.width = width;
        layoutParams.height = (int) (width * getFocusDataYXRatioal() * this.mScaleCoefficient);
        this.f24047h.post(new Runnable() { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.2
            @Override // java.lang.Runnable
            public void run() {
                IdentityCardDetectionActivity.this.f24047h.setLayoutParams(layoutParams);
            }
        });
        int[] iArr = new int[2];
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        int[] iArr2 = new int[2];
        this.mPreviewView.getLocationOnScreen(iArr2);
        this.f24047h.getLocationOnScreen(iArr);
        Rect rect = this.mFocusViewRect;
        int i2 = iArr[0] - iArr2[0];
        rect.left = i2;
        rect.right = (i2 + layoutParams.width) - 1;
        int i3 = iArr[1] - iArr2[1];
        rect.top = i3;
        rect.bottom = (i3 + layoutParams.height) - 1;
        this.f24046g.getFocusFrame().set(this.mFocusViewRect);
        ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.n.setLayoutParams(layoutParams2);
        this.n.requestLayout();
        ((FrameLayout.LayoutParams) this.l.getLayoutParams()).topMargin = this.mFocusViewRect.bottom + DisplayUtils.dip2px(getActivity(), 15.0f);
        this.l.requestLayout();
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        if (this.f24048i == null) {
            return;
        }
        this.f24048i.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f24048i, z ? "关闭闪光灯" : "打开闪光灯");
    }

    private void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.v = this.w;
        }
        this.f24047h.setVisibility(0);
        this.l.setVisibility(0);
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.o.setVisibility(8);
        this.n.setImageDrawable(null);
        onResume();
    }

    private void a() {
        if (PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.OPENABLE");
            if (Build.VERSION.SDK_INT < 19) {
                intent.setAction("android.intent.action.GET_CONTENT");
            } else {
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
            }
            intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
            startActivityForResult(Intent.createChooser(intent, "选择图片"), 17);
        }
    }
}
