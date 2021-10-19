package com.baidu.wallet.bankdetection;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bankdetection.BCResult;
import com.baidu.bankdetection.BankCardProcessing;
import com.baidu.bankdetection.PathUtils;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.bankdetection.a.a;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.camera.CameraBaseActivity;
import com.dxmpay.wallet.base.camera.IImageProcess;
import com.dxmpay.wallet.base.camera.internal.CameraCtrl;
import com.dxmpay.wallet.base.widget.MistView;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class BankCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60347a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public MistView f60348b;

    /* renamed from: c  reason: collision with root package name */
    public View f60349c;

    /* renamed from: d  reason: collision with root package name */
    public View f60350d;

    /* renamed from: e  reason: collision with root package name */
    public BankCardProcessing f60351e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f60352f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f60353g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f60354h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(174760257, "Lcom/baidu/wallet/bankdetection/BankCardDetectionActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(174760257, "Lcom/baidu/wallet/bankdetection/BankCardDetectionActivity;");
                return;
            }
        }
        f60347a = BankCardDetectionActivity.class.getSimpleName();
    }

    public BankCardDetectionActivity() {
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
        this.f60349c = null;
        this.f60350d = null;
        this.f60354h = new AtomicInteger(0);
    }

    private byte[] a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bitmap)) == null) {
            byte[] bArr = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr;
            } catch (Exception e2) {
                e2.printStackTrace();
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60351e == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (2 <= i2 || 1 == this.f60354h.intValue()) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            i2 = i3;
        }
        if (1 == this.f60354h.intValue()) {
            this.f60354h.set(3);
            this.f60351e.release();
            this.f60351e = null;
            return;
        }
        String str = "destroyProcessor() Classifyer state=" + this.f60354h.intValue();
    }

    public int dip2pixel(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics()) : invokeF.intValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_bankcard_detection_activity"), null);
            this.f60348b = mistView;
            return mistView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0.631f;
        }
        return invokeV.floatValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public int getFromBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) ? i2 * i3 * 3 : invokeII.intValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                BankCardProcessing.init(CameraBaseActivity.getToken());
                BankCardProcessing bankCardProcessing = BankCardProcessing.getInstance();
                this.f60351e = bankCardProcessing;
                if (bankCardProcessing.init(getAssets(), PathUtils.model_path, PathUtils.mean_path, PathUtils.dtc_model_path_fst, PathUtils.dtc_mean_path_fst, PathUtils.dtc_model_path_scd, PathUtils.dtc_mean_path_scd, PathUtils.captcha_path) < 0) {
                    LogUtil.e(f60347a, "Model initialization failure.", null);
                    this.f60351e = null;
                    return false;
                }
                this.f60354h.set(1);
                return true;
            } catch (AlgorithmOnMainThreadException e2) {
                e2.printStackTrace();
                return false;
            } catch (IDLAuthorityException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void isAllowCameraPermisssion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_CANCEL, "");
            BankcardDetectionController.getInstance().updateFail(-2, "");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int id = view.getId();
            if (ResUtils.id(getActivity(), "flash_light_switch") == id) {
                triggerFlash();
            } else if (ResUtils.id(getActivity(), "manal_input_prompt") == id) {
                StatisticManager.onEvent("manualInputBankCard");
                BankcardDetectionController.getInstance().update(null, "");
                finish();
                overridePendingTransition(0, 0);
            } else if (ResUtils.id(getActivity(), "title_back") == id) {
                StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_CANCEL, "");
                BankcardDetectionController.getInstance().updateFail(-2, "");
                finish();
                overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            String str = "onCreate(" + bundle + SmallTailInfo.EMOTION_SUFFIX;
            this.f60349c = findViewById(ResUtils.id(getActivity(), "focus_view"));
            this.f60350d = findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
            if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.f60350d.setOnClickListener(this);
                this.f60350d.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.f60350d, "打开闪光灯");
            } else {
                this.f60350d.setVisibility(4);
            }
            findViewById(ResUtils.id(getActivity(), "title_back")).setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "manal_input_prompt")).setOnClickListener(this);
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BankcardDetectionController.getInstance().updateFail(-1, "no camera permission");
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, objArr) == null) {
            BCResult bCResult = (BCResult) objArr[0];
            new Handler(Looper.getMainLooper()).post(new Runnable(this, bCResult) { // from class: com.baidu.wallet.bankdetection.BankCardDetectionActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BCResult f60355a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDetectionActivity f60356b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, bCResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60356b = this;
                    this.f60355a = bCResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        EventBus eventBus = EventBus.getInstance();
                        eventBus.getClass();
                        eventBus.postStickyEvent(new EventBus.Event(eventBus, "BankCardResult", this.f60355a));
                        this.f60356b.startActivityForResult(new Intent(this.f60356b.getActivity(), BankCardResultActivity.class), 132);
                        this.f60356b.overridePendingTransition(0, 0);
                    }
                }
            });
            this.f60353g = a(bCResult.getDstRGBImage(false));
            new a(getActivity(), bCResult.cardNumberToString(), this.f60353g, this.f60352f).execBean();
        }
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            if (1 != this.f60354h.intValue()) {
                return null;
            }
            this.f60354h.set(2);
            Yuv.rotateCrop(bArr, i2, i3, rect, 270, bArr2);
            BCResult runBankCardProcess = this.f60351e.runBankCardProcess(bArr2, rect.width(), rect.height(), 1, 1, rect.height() - 1, rect.width() - 1, 1, false);
            this.f60354h.set(1);
            if (runBankCardProcess == null || !runBankCardProcess.bFlag) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(rect.height(), rect.width(), Bitmap.Config.ARGB_8888);
            Yuv.rotateCropBmp(bArr, i2, i3, rect.left, rect.top, 270, createBitmap);
            this.f60352f = a(createBitmap);
            createBitmap.recycle();
            return new BCResult[]{runBankCardProcess};
        }
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, bArr, i2, i3)) == null) {
            return null;
        }
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f60349c.getLayoutParams();
            int width = this.f60349c.getWidth();
            layoutParams.width = width;
            layoutParams.height = Math.round(width * getFocusDataYXRatioal() * this.mScaleCoefficient);
            this.f60349c.setLayoutParams(layoutParams);
            this.f60349c.requestLayout();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mPreviewView.getLocationOnScreen(iArr2);
            this.f60349c.getLocationOnScreen(iArr);
            Rect rect = this.mFocusViewRect;
            int i2 = iArr[0] - iArr2[0];
            rect.left = i2;
            rect.right = i2 + layoutParams.width;
            int i3 = iArr[1] - iArr2[1];
            rect.top = i3;
            rect.bottom = i3 + layoutParams.height;
            this.f60348b.getFocusFrame().set(this.mFocusViewRect);
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, rect) == null) {
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.f60350d == null) {
            return;
        }
        this.f60350d.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "dxm_wallet_base_camera_flashlight_on_btn" : "dxm_wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f60350d, z ? "关闭闪光灯" : "打开闪光灯");
    }
}
