package com.baidu.wallet.bankdetection.ocr.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.bankdetection.BankcardDetectionController;
import com.baidu.wallet.bankdetection.ocr.DxmOcrBankCardDetect;
import com.baidu.wallet.bankdetection.ocr.a.a;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.camera.CameraBaseActivity;
import com.dxmpay.wallet.base.camera.IImageProcess;
import com.dxmpay.wallet.base.camera.internal.CameraCtrl;
import com.dxmpay.wallet.base.camera.util.ThreadPool;
import com.dxmpay.wallet.base.widget.MistView;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes13.dex */
public class DxmOcrBankCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public MistView f50483b;

    /* renamed from: c  reason: collision with root package name */
    public View f50484c;

    /* renamed from: d  reason: collision with root package name */
    public View f50485d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f50486e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f50487f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f50488g;

    /* renamed from: h  reason: collision with root package name */
    public DxmOcrBankCardDetect f50489h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f50490i;

    /* renamed from: j  reason: collision with root package name */
    public int f50491j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(710166132, "Lcom/baidu/wallet/bankdetection/ocr/ui/DxmOcrBankCardDetectionActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(710166132, "Lcom/baidu/wallet/bankdetection/ocr/ui/DxmOcrBankCardDetectionActivity;");
                return;
            }
        }
        a = DxmOcrBankCardDetectionActivity.class.getSimpleName();
    }

    public DxmOcrBankCardDetectionActivity() {
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
        this.f50484c = null;
        this.f50485d = null;
        this.f50490i = new AtomicBoolean(true);
        this.p = true;
    }

    private void a(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, iArr) == null) {
            this.l = iArr[0];
            this.m = iArr[1];
            this.n = iArr[0] + this.f50484c.getWidth();
            this.o = iArr[1] + this.f50484c.getHeight();
            this.f50491j = getResources().getDisplayMetrics().widthPixels;
            this.k = getResources().getDisplayMetrics().heightPixels;
        }
    }

    private void b() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (bitmap = this.f50488g) == null || bitmap.isRecycled()) {
            return;
        }
        this.f50488g.recycle();
        this.f50488g = null;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50489h == null) {
            return;
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f50489h.close();
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_bankcard_detection_activity"), null);
            this.f50483b = mistView;
            return mistView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0.631f;
        }
        return invokeV.floatValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public int getFromBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? i2 * i3 * 3 : invokeII.intValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f50489h == null) {
                this.f50489h = new DxmOcrBankCardDetect();
            }
            this.f50489h.setContext(this);
            DxmOcrBankCardDetect.Options options = new DxmOcrBankCardDetect.Options();
            options.minLength = 14;
            options.maxLength = 19;
            options.borderDistance = 5;
            options.scoreThreshold = 0.8f;
            options.expandRatio = 1.0f;
            options.bankCardRatio = 0.55f;
            options.blurThreshold = 1.5f;
            options.useMinScore = false;
            int staticInitModel = DxmOcrBankCardDetect.staticInitModel(getAssets(), "bankcard_det.param.bin", "bankcard_det.bin", "bankcard_rec.param.bin", "bankcard_rec.bin", CameraBaseActivity.getToken(), false);
            String str = "initStatus:" + staticInitModel;
            StatisticManager.onEvent(PayStatServiceEvent.BANKCARD_INITOCRMODEL_STATUS, staticInitModel + "");
            this.f50489h.setOptions(options);
            boolean z = staticInitModel == 0;
            this.p = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void isAllowCameraPermisssion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 132 && i3 == 1244) {
                a();
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f50490i.compareAndSet(true, false);
            pauseCamera();
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
                this.f50490i.compareAndSet(true, false);
                pauseCamera();
                StatisticManager.onEvent("manualInputBankCard");
                BankcardDetectionController.getInstance().updateFail(-2, "");
                finish();
                overridePendingTransition(0, 0);
            } else if (ResUtils.id(getActivity(), "title_back") == id) {
                onBackPressed();
            }
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            this.mThreadPool = ThreadPool.create(1, ImageProcessor.a);
            super.onCreate(bundle);
            String str = "onCreate(" + bundle + SmallTailInfo.EMOTION_SUFFIX;
            this.f50484c = findViewById(ResUtils.id(getActivity(), "focus_view"));
            this.f50485d = findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
            if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
                this.f50485d.setOnClickListener(this);
                this.f50485d.setVisibility(0);
                AccessibilityUtils.setContentDescription(this.f50485d, "打开闪光灯");
            } else {
                this.f50485d.setVisibility(4);
            }
            findViewById(ResUtils.id(getActivity(), "title_back")).setOnClickListener(this);
            findViewById(ResUtils.id(getActivity(), "manal_input_prompt")).setOnClickListener(this);
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            b();
            this.f50486e = null;
            this.f50487f = null;
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BankcardDetectionController.getInstance().updateFail(-1, "no camera permission");
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, objArr) == null) {
            if (objArr != null && objArr.length > 1) {
                this.f50488g = (Bitmap) objArr[0];
                String valueOf = String.valueOf(objArr[1]);
                a.a().a(this.f50488g);
                a.a().a(valueOf);
                String str = "cardNum: " + valueOf;
                startActivityForResult(new Intent(getActivity(), DxmOcrBankCardResultActivity.class), 132);
                overridePendingTransition(0, 0);
                this.f50487f = a(this.f50488g);
                new com.baidu.wallet.bankdetection.a.a(getActivity(), valueOf, this.f50487f, this.f50486e).execBean();
                return;
            }
            a();
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            if (this.p) {
                return;
            }
            BankcardDetectionController.getInstance().updateFail(-3, "初始化失败");
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            String str = "processImage11: " + this.f50490i.get();
            if (this.f50490i.get()) {
                this.f50490i.compareAndSet(true, false);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                float f2 = i3 * 1.0f;
                int round = Math.round((f2 / (this.f50491j * 1.0f)) * this.l);
                float f3 = i2 * 1.0f;
                int round2 = Math.round((f3 / (this.k * 1.0f)) * this.m);
                int round3 = Math.round((f2 / (this.f50491j * 1.0f)) * this.n);
                int round4 = Math.round((f3 / (this.k * 1.0f)) * this.o);
                int[] iArr = {round, round2, round3, round4};
                String str2 = "width: " + i2;
                String str3 = "height: " + i3;
                String str4 = "leftX: " + round;
                String str5 = "leftY: " + round2;
                String str6 = "rightX: " + round3;
                String str7 = "rightY: " + round4;
                long currentTimeMillis = System.currentTimeMillis();
                Object[] objArr = {createBitmap, "", ""};
                int detect = this.f50489h.detect(bArr, iArr, objArr);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str8 = "detectStatus: " + detect;
                if (detect == 0) {
                    String str9 = "duration: " + currentTimeMillis2;
                    Object obj = objArr[0];
                    String valueOf = String.valueOf(objArr[1]);
                    String valueOf2 = String.valueOf(objArr[2]);
                    if (!TextUtils.isEmpty(valueOf) && obj != null && !TextUtils.isEmpty(valueOf2)) {
                        String str10 = "bankCardNum: " + valueOf;
                        String str11 = "score: " + valueOf2;
                        Bitmap createBitmap2 = Bitmap.createBitmap(rect.height(), rect.width(), Bitmap.Config.ARGB_8888);
                        Yuv.rotateCropBmp(bArr, i2, i3, rect.left, rect.top, 270, createBitmap2);
                        this.f50486e = a(createBitmap2);
                        if (createBitmap2 != null && !createBitmap2.isRecycled()) {
                            createBitmap2.recycle();
                        }
                        return objArr;
                    }
                    b();
                    this.f50490i.compareAndSet(false, true);
                    return null;
                }
                b();
                this.f50490i.compareAndSet(false, true);
                return null;
            }
            return null;
        }
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, bArr, i2, i3)) == null) {
            return null;
        }
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f50484c.getLayoutParams();
            int width = this.f50484c.getWidth();
            layoutParams.width = width;
            layoutParams.height = Math.round(width * getFocusDataYXRatioal() * this.mScaleCoefficient);
            this.f50484c.setLayoutParams(layoutParams);
            this.f50484c.requestLayout();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mPreviewView.getLocationOnScreen(iArr2);
            this.f50484c.getLocationOnScreen(iArr);
            Rect rect = this.mFocusViewRect;
            int i2 = iArr[0] - iArr2[0];
            rect.left = i2;
            rect.right = i2 + layoutParams.width;
            int i3 = iArr[1] - iArr2[1];
            rect.top = i3;
            rect.bottom = i3 + layoutParams.height;
            this.f50483b.getFocusFrame().set(this.mFocusViewRect);
            a(iArr);
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rect) == null) {
        }
    }

    @Override // com.dxmpay.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || this.f50485d == null) {
            return;
        }
        this.f50485d.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "dxm_wallet_base_camera_flashlight_on_btn" : "dxm_wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f50485d, z ? "关闭闪光灯" : "打开闪光灯");
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            restartScan();
            b();
            this.f50490i.compareAndSet(false, true);
        }
    }

    private byte[] a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bitmap)) == null) {
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
}
