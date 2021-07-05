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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class IdentityCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle A;
    public boolean B;

    /* renamed from: e  reason: collision with root package name */
    public final String f23946e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23947f;

    /* renamed from: g  reason: collision with root package name */
    public MistView f23948g;

    /* renamed from: h  reason: collision with root package name */
    public View f23949h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f23950i;
    public RelativeLayout j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public FrameLayout o;
    public ImageView p;
    public ImageView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public AtomicBoolean u;
    public String v;
    public String w;
    public Bitmap y;
    public Bitmap z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-501821520, "Lcom/baidu/wallet/base/iddetect/IdentityCardDetectionActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-501821520, "Lcom/baidu/wallet/base/iddetect/IdentityCardDetectionActivity;");
        }
    }

    public IdentityCardDetectionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23946e = IdentityCardDetectionActivity.class.getSimpleName();
        this.f23947f = 17;
        this.f23949h = null;
        this.f23950i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = new AtomicBoolean(false);
        this.v = "";
        this.w = "";
        this.A = new Bundle();
        this.B = true;
    }

    public void deleteReady2USeFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            File file = new File(this.w);
            if (file.exists()) {
                file.delete();
            }
            this.w = "";
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getAutoFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_card_detection_activity"), null);
            this.f23948g = mistView;
            return mistView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getFirstFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0.631f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    public void getPicFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = x;
            if (i2 == 1) {
                this.A.putInt(ShaderParams.VALUE_TYPE_STEP, i2);
                x++;
                a(Boolean.TRUE);
                this.A.putString("pic1", this.v);
                this.f23948g.setMistColor(MistView.MASK_COLOR_DEFAULT_TRANSPARENT);
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
                this.A.putInt(ShaderParams.VALUE_TYPE_STEP, x);
                this.v = this.w;
                this.A.putString(x != 3 ? "pic2" : "pic1", this.v);
                x = 1;
                IdCardDetectionController.getInstance().IdCardDeteSuccess(this.A);
                finishWithoutAnim();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            return 0;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, intent) == null) && i3 == -1 && i2 == 17) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
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
                this.f23948g.setMistColor(MistView.MASK_COLOR_DEFAULT_TRANSPARENT);
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
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                x = extras.getInt(ShaderParams.VALUE_TYPE_STEP);
                this.B = extras.getBoolean("show_album");
            }
            this.f23949h = findViewById(ResUtils.id(getActivity(), "focus_view"));
            this.f23950i = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
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
                this.f23950i.setOnClickListener(this);
                this.f23950i.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.f23950i, "打开闪光灯");
            } else {
                this.f23950i.setVisibility(4);
            }
            this.r.setOnClickListener(this);
            this.m.setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
            this.t = imageView;
            imageView.setOnClickListener(this);
            this.mPreviewView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IdentityCardDetectionActivity f23951a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23951a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.f23951a.autoFoucus();
                            return true;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            Bitmap bitmap = this.y;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.y.recycle();
            this.y = null;
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, objArr) == null) {
            runOnUiThread(new Runnable(this, objArr) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object[] f23954a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IdentityCardDetectionActivity f23955b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, objArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23955b = this;
                    this.f23954a = objArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f23955b.f23949h.setVisibility(8);
                        this.f23955b.l.setVisibility(8);
                        this.f23955b.j.setVisibility(8);
                        this.f23955b.k.setVisibility(0);
                        long currentTimeMillis = System.currentTimeMillis();
                        IdentityCardDetectionActivity identityCardDetectionActivity = this.f23955b;
                        identityCardDetectionActivity.w = ImageUtils.saveBitmapToCache(identityCardDetectionActivity.getActivity(), (Bitmap) this.f23954a[0], System.currentTimeMillis() + ".jpg", 90);
                        Bitmap bPfromsdcard = ImageUtils.getBPfromsdcard(this.f23955b.w);
                        LogUtil.i("IdentityCardDetectionActivity", "re save and show time:" + (System.currentTimeMillis() - currentTimeMillis));
                        this.f23955b.n.setImageBitmap(bPfromsdcard);
                        this.f23955b.pauseCamera();
                        this.f23955b.u.compareAndSet(true, false);
                        this.f23955b.t.setClickable(true);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            if (this.mInCaptureTimeOut.compareAndSet(true, false)) {
                LogUtil.d(this.f23946e, "preview process");
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
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, bArr, i2, i3)) == null) {
            if (this.u.get()) {
                LogUtil.d(this.f23946e, "takepic process");
                Bitmap a2 = com.baidu.wallet.base.iddetect.utils.a.a(bArr, i2, i3);
                this.z = a2;
                if (a2 != null) {
                    this.z = ImageUtils.rotateBitmap(90, a2);
                }
                return new Bitmap[]{this.z};
            }
            return null;
        }
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f23949h.getLayoutParams();
            int width = this.f23949h.getWidth();
            layoutParams.width = width;
            layoutParams.height = (int) (width * getFocusDataYXRatioal() * this.mScaleCoefficient);
            this.f23949h.post(new Runnable(this, layoutParams) { // from class: com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ViewGroup.LayoutParams f23952a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IdentityCardDetectionActivity f23953b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, layoutParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23953b = this;
                    this.f23952a = layoutParams;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f23953b.f23949h.setLayoutParams(this.f23952a);
                    }
                }
            });
            int[] iArr = new int[2];
            getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            int[] iArr2 = new int[2];
            this.mPreviewView.getLocationOnScreen(iArr2);
            this.f23949h.getLocationOnScreen(iArr);
            Rect rect = this.mFocusViewRect;
            int i2 = iArr[0] - iArr2[0];
            rect.left = i2;
            rect.right = (i2 + layoutParams.width) - 1;
            int i3 = iArr[1] - iArr2[1];
            rect.top = i3;
            rect.bottom = (i3 + layoutParams.height) - 1;
            this.f23948g.getFocusFrame().set(this.mFocusViewRect);
            ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            this.n.setLayoutParams(layoutParams2);
            this.n.requestLayout();
            ((FrameLayout.LayoutParams) this.l.getLayoutParams()).topMargin = this.mFocusViewRect.bottom + DisplayUtils.dip2px(getActivity(), 15.0f);
            this.l.requestLayout();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || this.f23950i == null) {
            return;
        }
        this.f23950i.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f23950i, z ? "关闭闪光灯" : "打开闪光灯");
    }

    private void a(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bool) == null) {
            if (bool.booleanValue()) {
                this.v = this.w;
            }
            this.f23949h.setVisibility(0);
            this.l.setVisibility(0);
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setImageDrawable(null);
            onResume();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
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
