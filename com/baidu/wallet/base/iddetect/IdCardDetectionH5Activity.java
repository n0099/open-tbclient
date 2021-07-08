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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
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
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class IdCardDetectionH5Activity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic = null;
    public static int s = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f24048e;

    /* renamed from: f  reason: collision with root package name */
    public View f24049f;

    /* renamed from: g  reason: collision with root package name */
    public View f24050g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f24051h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f24052i;
    public TextView j;
    public View k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public ImageView p;
    public AtomicBoolean q;
    public String r;
    public Bitmap t;
    public Bitmap u;
    public Bitmap v;
    public Bundle w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1189882368, "Lcom/baidu/wallet/base/iddetect/IdCardDetectionH5Activity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1189882368, "Lcom/baidu/wallet/base/iddetect/IdCardDetectionH5Activity;");
        }
    }

    public IdCardDetectionH5Activity() {
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
        this.f24048e = IdCardDetectionH5Activity.class.getSimpleName();
        this.f24049f = null;
        this.f24050g = null;
        this.f24051h = null;
        this.f24052i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = new AtomicBoolean(false);
        this.r = "";
        this.w = new Bundle();
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getAutoFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_identity_h5_detection_activity"), null) : (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public long getFirstFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2000L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0.631f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            return 0;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-2, "canceled by user");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
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
                        this.w.putInt(ShaderParams.VALUE_TYPE_STEP, i2);
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
                        this.w.putInt(ShaderParams.VALUE_TYPE_STEP, i2);
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
            } else if (view == this.f24049f) {
                stopCamera();
                switchCamera();
                if (!CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                    this.f24050g.setVisibility(4);
                } else if (this.cameraId == 1) {
                    this.f24050g.setVisibility(4);
                    this.f24050g.setBackgroundResource(ResUtils.drawable(getActivity(), "wallet_base_camera_flashlight_off_btn"));
                } else {
                    this.f24050g.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                s = extras.getInt(ShaderParams.VALUE_TYPE_STEP);
            }
            this.f24050g = findViewById(ResUtils.id(getActivity(), "idcards_flash_light_switch"));
            this.f24049f = findViewById(ResUtils.id(getActivity(), "idcards_camera_switch"));
            this.j = (TextView) findViewById(ResUtils.id(getActivity(), "bd_wallet_promo"));
            this.k = findViewById(ResUtils.id(getActivity(), "wallet_camera_control_area"));
            this.n = (TextView) findViewById(ResUtils.id(getActivity(), "TextView1"));
            this.f24051h = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_bottom_layout"));
            this.f24052i = (LinearLayout) findViewById(ResUtils.id(getActivity(), "idcard_pic_preview_bottom_layout"));
            this.o = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_restart_take_pic"));
            this.l = (TextView) findViewById(ResUtils.id(getActivity(), "idcard_take_pic_finish"));
            this.m = (ImageView) findViewById(ResUtils.id(getActivity(), "img_snapshot"));
            if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.f24050g.setOnClickListener(this);
                this.f24050g.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.f24050g, "打开闪光灯");
            } else {
                this.f24050g.setVisibility(4);
            }
            this.f24049f.setVisibility(CameraCtrl.getInstance().isSupportMultiCamera() ? 0 : 8);
            this.f24049f.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.l.setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "idcards_title_back")).setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getActivity(), "idcards_take_pic_start"));
            this.p = imageView;
            imageView.setOnClickListener(this);
            this.mPreviewView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IdCardDetectionH5Activity f24053a;

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
                    this.f24053a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.f24053a.autoFoucus();
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            Bitmap bitmap = this.t;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.t.recycle();
            this.t = null;
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            IdCardDetectionController.getInstance().IdCardDeteFailed(-1, "permission denied");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, objArr) == null) {
            runOnUiThread(new Runnable(this, objArr) { // from class: com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object[] f24054a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IdCardDetectionH5Activity f24055b;

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
                    this.f24055b = this;
                    this.f24054a = objArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f24055b.j.setVisibility(8);
                        this.f24055b.k.setVisibility(8);
                        TextView textView = this.f24055b.n;
                        IdCardDetectionH5Activity idCardDetectionH5Activity = this.f24055b;
                        textView.setText(idCardDetectionH5Activity.getString(ResUtils.string(idCardDetectionH5Activity.getActivity(), "wallet_base_h5_idcard_title2")));
                        this.f24055b.f24051h.setVisibility(8);
                        this.f24055b.f24052i.setVisibility(0);
                        this.f24055b.m.setVisibility(0);
                        this.f24055b.v = (Bitmap) this.f24054a[0];
                        this.f24055b.m.setImageBitmap(this.f24055b.v);
                        this.f24055b.restartScan();
                        this.f24055b.q.compareAndSet(true, false);
                        this.f24055b.p.setClickable(true);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            if (this.mInCaptureTimeOut.compareAndSet(true, false)) {
                LogUtil.d(this.f24048e, "preview process");
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
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, bArr, i2, i3)) == null) {
            if (this.q.get()) {
                LogUtil.d(this.f24048e, "takepic process");
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
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, rect) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.f24050g == null) {
            return;
        }
        this.f24050g.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f24050g, z ? "关闭闪光灯" : "打开闪光灯");
    }

    private void a(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bool) == null) {
            if (bool.booleanValue()) {
                Activity activity = getActivity();
                Bitmap bitmap = this.v;
                this.r = ImageUtils.saveBitmapToCache(activity, bitmap, System.currentTimeMillis() + ".jpg");
            }
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.n.setText(getString(ResUtils.string(getActivity(), "wallet_base_h5_idcard_title_take_pic")));
            this.f24051h.setVisibility(0);
            this.f24052i.setVisibility(8);
            this.m.setVisibility(8);
            onResume();
        }
    }
}
