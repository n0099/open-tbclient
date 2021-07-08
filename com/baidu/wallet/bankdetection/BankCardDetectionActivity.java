package com.baidu.wallet.bankdetection;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
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
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.MistView;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class BankCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f23909e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public MistView f23910f;

    /* renamed from: g  reason: collision with root package name */
    public View f23911g;

    /* renamed from: h  reason: collision with root package name */
    public View f23912h;

    /* renamed from: i  reason: collision with root package name */
    public BankCardProcessing f23913i;
    public AtomicInteger j;

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
        f23909e = BankCardDetectionActivity.class.getSimpleName();
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
        this.f23911g = null;
        this.f23912h = null;
        this.j = new AtomicInteger(0);
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23913i == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (2 <= i2 || 1 == this.j.intValue()) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            i2 = i3;
        }
        if (1 == this.j.intValue()) {
            this.j.set(3);
            this.f23913i.release();
            this.f23913i = null;
            return;
        }
        String str = f23909e;
        LogUtil.w(str, "destroyProcessor() Classifyer state=" + this.j.intValue());
    }

    public int dip2pixel(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics()) : invokeF.intValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_bankcard_detection_activity"), null);
            this.f23910f = mistView;
            return mistView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0.631f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? i2 * i3 * 3 : invokeII.intValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                BankCardProcessing.init(CameraBaseActivity.getToken());
                BankCardProcessing bankCardProcessing = BankCardProcessing.getInstance();
                this.f23913i = bankCardProcessing;
                if (bankCardProcessing.init(getAssets(), PathUtils.model_path, PathUtils.mean_path, PathUtils.dtc_model_path_fst, PathUtils.dtc_mean_path_fst, PathUtils.dtc_model_path_scd, PathUtils.dtc_mean_path_scd, PathUtils.captcha_path) < 0) {
                    LogUtil.e(f23909e, "Model initialization failure.", null);
                    this.f23913i = null;
                    return false;
                }
                this.j.set(1);
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.STAT_EXITDETECT);
            BankcardDetectionController.getInstance().updateFail(-2, "");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            if (ResUtils.id(getActivity(), "flash_light_switch") == id) {
                triggerFlash();
            } else if (ResUtils.id(getActivity(), "manal_input_prompt") == id) {
                PayStatisticsUtil.onEvent(StatServiceEvent.STAT_MANUAINPUT);
                BankcardDetectionController.getInstance().update(null, "");
                finish();
                overridePendingTransition(0, 0);
            } else if (ResUtils.id(getActivity(), "title_back") == id) {
                PayStatisticsUtil.onEvent(StatServiceEvent.STAT_EXITDETECT);
                BankcardDetectionController.getInstance().updateFail(-2, "");
                finish();
                overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            String str = f23909e;
            LogUtil.i(str, "onCreate(" + bundle + SmallTailInfo.EMOTION_SUFFIX);
            this.f23911g = findViewById(ResUtils.id(getActivity(), "focus_view"));
            this.f23912h = findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
            if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.f23912h.setOnClickListener(this);
                this.f23912h.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.f23912h, "打开闪光灯");
            } else {
                this.f23912h.setVisibility(4);
            }
            findViewById(ResUtils.id(getActivity(), "title_back")).setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "manal_input_prompt")).setOnClickListener(this);
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BankcardDetectionController.getInstance().updateFail(-1, "no camera permission");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, objArr) == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, (BCResult) objArr[0]) { // from class: com.baidu.wallet.bankdetection.BankCardDetectionActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BCResult f23914a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDetectionActivity f23915b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23915b = this;
                    this.f23914a = r7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        EventBus eventBus = EventBus.getInstance();
                        eventBus.getClass();
                        eventBus.postStickyEvent(new EventBus.Event(eventBus, "BankCardResult", this.f23914a));
                        this.f23915b.startActivityForResult(new Intent(this.f23915b.getActivity(), BankCardResultActivity.class), 132);
                        this.f23915b.overridePendingTransition(0, 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            if (1 != this.j.intValue()) {
                return null;
            }
            this.j.set(2);
            Yuv.rotateCrop(bArr, i2, i3, rect, 270, bArr2);
            BCResult runBankCardProcess = this.f23913i.runBankCardProcess(bArr2, rect.width(), rect.height(), 1, 1, rect.height() - 1, rect.width() - 1, 1, false);
            this.j.set(1);
            if (runBankCardProcess == null || !runBankCardProcess.bFlag) {
                return null;
            }
            return new BCResult[]{runBankCardProcess};
        }
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048589, this, bArr, i2, i3)) == null) {
            return null;
        }
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f23911g.getLayoutParams();
            int width = this.f23911g.getWidth();
            layoutParams.width = width;
            layoutParams.height = Math.round(width * getFocusDataYXRatioal() * this.mScaleCoefficient);
            this.f23911g.setLayoutParams(layoutParams);
            this.f23911g.requestLayout();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mPreviewView.getLocationOnScreen(iArr2);
            this.f23911g.getLocationOnScreen(iArr);
            Rect rect = this.mFocusViewRect;
            int i2 = iArr[0] - iArr2[0];
            rect.left = i2;
            rect.right = i2 + layoutParams.width;
            int i3 = iArr[1] - iArr2[1];
            rect.top = i3;
            rect.bottom = i3 + layoutParams.height;
            this.f23910f.getFocusFrame().set(this.mFocusViewRect);
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rect) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f23912h == null) {
            return;
        }
        this.f23912h.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f23912h, z ? "关闭闪光灯" : "打开闪光灯");
    }
}
