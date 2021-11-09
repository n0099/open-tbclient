package com.baidu.wallet.base.camera;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.d;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class CameraBaseActivity extends BaseActivity implements SurfaceHolder.Callback, com.baidu.wallet.base.camera.internal.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_PROBE_OPEN_STATE = 1;
    public static int REQUEST_PERMISSION_CAMERA = 0;
    public static final int RequestCode = 132;
    public static final int ResultCodeExit = 1243;
    public static final int ResultCodeStay = 1244;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_RAW = 0;
    public static final String Tag;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera.AutoFocusCallback autoFocusCallback;
    public int cameraId;
    public com.baidu.wallet.base.camera.internal.a mAutoFocusCb;
    public final Handler mAutoFocusHandler;
    public Rect mBmpDataRect;
    public boolean mCanRequestCameraPermission;
    public ViewGroup mContentView;
    public final AtomicInteger mDetectorState;
    public a[] mDetectors;
    public final AtomicBoolean mDone;
    public b mFlashController;
    public float mFocusDataYXRatial;
    public Rect mFocusViewRect;
    public IImageProcess mImageProcessor;
    public int[] mImageSize;
    public boolean mInCaptureProgresses;
    public AtomicBoolean mInCaptureTimeOut;
    public AtomicBoolean mIsCameraMalfunctioned;
    public Handler mMiscEvtHandler;
    public OnCameraChangeListener mOnCameraChange;
    public d mPreviewCb;
    public SurfaceView mPreviewView;
    public int mRotation;
    public float mScaleCoefficient;
    public int[] mScreeSize;
    public SurfaceHolder mSurfaceHolder;
    public com.baidu.wallet.base.camera.util.c mThreadPool;
    public CountDownTimer mTimer;
    public View mTitleBarMargin;
    public RelativeLayout mTitle_bar;

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f57334a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57335b;

        public b(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57334a = cameraBaseActivity;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57335b = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f57334a.updateFlashLightUi(this.f57335b);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<CameraBaseActivity> f57336a;

        public c(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57336a = new WeakReference<>(cameraBaseActivity);
        }

        private boolean a() {
            InterceptResult invokeV;
            a[] aVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                CameraBaseActivity cameraBaseActivity = this.f57336a.get();
                if (cameraBaseActivity == null) {
                    return false;
                }
                if (cameraBaseActivity.mDetectors != null && cameraBaseActivity.mDetectors.length != 0) {
                    for (a aVar : cameraBaseActivity.mDetectors) {
                        if (aVar != null && aVar.a()) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            CameraBaseActivity cameraBaseActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cameraBaseActivity = this.f57336a.get()) == null) {
                return;
            }
            while (!a()) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            cameraBaseActivity.mImageProcessor.destroyProcessor();
            cameraBaseActivity.mDetectors = null;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1251310210, "Lcom/baidu/wallet/base/camera/CameraBaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1251310210, "Lcom/baidu/wallet/base/camera/CameraBaseActivity;");
                return;
            }
        }
        Tag = CameraBaseActivity.class.getSimpleName();
        REQUEST_PERMISSION_CAMERA = 1;
    }

    public CameraBaseActivity() {
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
        this.mSurfaceHolder = null;
        this.mDone = new AtomicBoolean(false);
        this.mScaleCoefficient = 1.0f;
        this.mFocusDataYXRatial = 1.0f;
        this.mBmpDataRect = new Rect();
        this.mFocusViewRect = new Rect();
        this.mScreeSize = new int[2];
        this.mImageSize = new int[2];
        this.mDetectors = null;
        this.mDetectorState = new AtomicInteger(0);
        this.mMiscEvtHandler = null;
        this.mIsCameraMalfunctioned = new AtomicBoolean(false);
        this.mCanRequestCameraPermission = true;
        this.mInCaptureProgresses = false;
        this.mInCaptureTimeOut = new AtomicBoolean(false);
        this.mAutoFocusHandler = new Handler(this, Looper.myLooper()) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CameraBaseActivity f57319a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f57319a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int id = ResUtils.id(this.f57319a.getActivity(), "wallet_auto_focus");
                    if (id == message.what) {
                        if (this.f57319a.mPreviewCb != null) {
                            this.f57319a.mAutoFocusCb.a(this, id);
                            com.baidu.wallet.base.camera.internal.b d2 = this.f57319a.mPreviewCb.d();
                            if (d2 != null) {
                                try {
                                    d2.a(this.f57319a.mAutoFocusCb);
                                    return;
                                } catch (Exception unused) {
                                    LogUtil.w(CameraBaseActivity.Tag, "mAutoFocusHandler.handleMessage()");
                                    return;
                                }
                            }
                            return;
                        }
                        this.f57319a.mAutoFocusCb.a(null, id);
                        return;
                    }
                    super.handleMessage(message);
                }
            }
        };
        this.mFlashController = new b(this);
        this.cameraId = 0;
        this.autoFocusCallback = new Camera.AutoFocusCallback(this) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CameraBaseActivity f57323a;

            /* renamed from: b  reason: collision with root package name */
            public int f57324b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f57323a = this;
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZL(1048576, this, z, camera) == null) || this.f57323a.mPreviewCb == null || this.f57323a.mPreviewCb.d() == null) {
                    return;
                }
                CameraBaseActivity cameraBaseActivity = this.f57323a;
                if (cameraBaseActivity.mInCaptureProgresses) {
                    return;
                }
                com.baidu.wallet.base.camera.internal.b d2 = cameraBaseActivity.mPreviewCb.d();
                if (z) {
                    this.f57324b = 0;
                    this.f57323a.takePictureWithoutAutoFocus(d2);
                    return;
                }
                int i4 = this.f57324b + 1;
                this.f57324b = i4;
                if (i4 <= 1) {
                    d2.a(this.f57323a.autoFocusCallback, "continuous-picture");
                } else {
                    this.f57323a.takePictureWithoutAutoFocus(d2);
                }
            }
        };
    }

    private synchronized a getAvailableDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            synchronized (this) {
                if (this.mDetectors == null) {
                    a[] aVarArr = new a[com.baidu.wallet.base.camera.util.a.a()];
                    this.mDetectors = aVarArr;
                    aVarArr[0] = new a(this);
                    return this.mDetectors[0];
                }
                for (int i2 = 0; i2 < this.mDetectors.length; i2++) {
                    if (this.mDetectors[i2] == null) {
                        this.mDetectors[i2] = new a(this);
                        return this.mDetectors[i2];
                    } else if (!this.mDetectors[i2].a()) {
                        return this.mDetectors[i2];
                    }
                }
                return null;
            }
        }
        return (a) invokeV.objValue;
    }

    public static String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? SafePay.getInstance().getToken() : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNoCamaraPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            onPermissionDenied();
            showBaseDialog(3, ResUtils.getString(getActivity(), "wallet_camera_error"));
        }
    }

    private boolean isFlashOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (this.mPreviewCb != null) {
                return CameraCtrl.getInstance().isFlashOn();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void setFlashLightOn(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65555, this, z) == null) || this.mPreviewCb == null) {
            return;
        }
        CameraCtrl cameraCtrl = CameraCtrl.getInstance();
        if (cameraCtrl.isFlashOn() != z) {
            cameraCtrl.setFlashOn(z);
        }
        switchFlashOnMainThread(cameraCtrl.isFlashOn());
    }

    private void startCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            stopCountDown();
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, SdkInitResponse.getInstance().getTakePicWaitTime(), SdkInitResponse.getInstance().getTakePicWaitTime()) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CameraBaseActivity f57325a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r11), Long.valueOf(r13)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57325a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f57325a.mTimer == null) {
                        return;
                    }
                    this.f57325a.mTimer.cancel();
                    this.f57325a.mInCaptureTimeOut.set(true);
                    this.f57325a.mInCaptureProgresses = false;
                    LogUtil.d(CameraBaseActivity.Tag, "timeout");
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                    }
                }
            };
            this.mTimer = countDownTimer2;
            countDownTimer2.start();
        }
    }

    private boolean startScan() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (this.mPreviewCb == null) {
                int a2 = d.a(getActivity(), this.cameraId);
                this.mRotation = a2;
                int i2 = this.cameraId;
                int[] iArr = this.mScreeSize;
                d a3 = d.a(i2, iArr[0], iArr[1], a2, 17, 10, this);
                this.mPreviewCb = a3;
                if (a3 == null) {
                    handleNoCamaraPermission();
                    return false;
                }
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null && (dVar = this.mPreviewCb) != null) {
                dVar.a(surfaceHolder);
                com.baidu.wallet.base.camera.internal.a aVar = new com.baidu.wallet.base.camera.internal.a();
                this.mAutoFocusCb = aVar;
                aVar.a(getAutoFocusDelay());
                this.mAutoFocusCb.b(getFirstFocusDelay());
                this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "wallet_auto_focus")).sendToTarget();
                try {
                    Camera.Size previewSize = this.mPreviewCb.d().d().getPreviewSize();
                    this.mImageSize[0] = previewSize.width;
                    this.mImageSize[1] = previewSize.height;
                    int[] iArr2 = this.mScreeSize;
                    int[] iArr3 = this.mImageSize;
                    this.mScaleCoefficient = ((iArr2[1] * iArr3[1]) / iArr2[0]) / iArr3[0];
                    String str = Tag;
                    LogUtil.i(str, "ratio:" + this.mScaleCoefficient);
                    relayoutUi();
                    setFocusRectValue(this.mFocusViewRect);
                    mapViewDataBoundary(this.mBmpDataRect);
                } catch (Throwable th) {
                    showBaseDialog(3, ResUtils.getString(getActivity(), "wallet_camera_error"));
                    DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_GET_PREVIEW_SIZE_FAILED, Arrays.asList(th.getMessage()));
                    return false;
                }
            }
            this.mDone.set(false);
            this.mIsCameraMalfunctioned.set(true);
            Handler handler = this.mMiscEvtHandler;
            if (handler == null) {
                this.mMiscEvtHandler = new Handler(this) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CameraBaseActivity f57321a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57321a = this;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && 1 == message.what && this.f57321a.mIsCameraMalfunctioned.get()) {
                            this.f57321a.showBaseDialog(3, ResUtils.getString(this.f57321a.getActivity(), "wallet_camera_error"));
                        }
                    }
                };
            } else {
                handler.removeMessages(1);
            }
            this.mMiscEvtHandler.sendEmptyMessageDelayed(1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void switchFlashOnMainThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, this, z) == null) {
            this.mFlashController.a(z);
            getActivity().runOnUiThread(this.mFlashController);
        }
    }

    public void autoFoucus() {
        d dVar;
        com.baidu.wallet.base.camera.internal.b d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.mPreviewCb) == null || (d2 = dVar.d()) == null) {
            return;
        }
        try {
            d2.a(this.mAutoFocusCb);
        } catch (Throwable unused) {
            LogUtil.w(Tag, "autoFocus exception");
        }
    }

    @Override // com.baidu.wallet.base.camera.internal.c
    public void destroyCamera() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        LogUtil.i(Tag, "destroyCamera()");
        OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
        if (onCameraChangeListener != null) {
            onCameraChangeListener.onCameraClose();
        }
        if (this.mDetectors == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.mDetectors;
            if (i2 < aVarArr.length) {
                aVarArr[i2] = null;
                i2++;
            } else {
                this.mDetectors = null;
                return;
            }
        }
    }

    public String getApplicationName() {
        InterceptResult invokeV;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                packageManager = DxmApplicationContextImpl.getApplicationContext(this).getPackageManager();
                try {
                    applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                packageManager = null;
            }
            return (String) packageManager.getApplicationLabel(applicationInfo);
        }
        return (String) invokeV.objValue;
    }

    public long getAutoFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 500L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    public abstract View getCustomizedView();

    public long getFirstFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 500L;
        }
        return invokeV.longValue;
    }

    public abstract float getFocusDataYXRatioal();

    public abstract IImageProcess getImageProcessor();

    @Override // com.baidu.wallet.base.camera.internal.c
    public boolean initCamera(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048585, this, i2, i3, i4, i5)) == null) {
            String str = Tag;
            LogUtil.i(str, "initCamera(" + i2 + "|" + i3 + "|" + i4 + "|" + i5 + SmallTailInfo.EMOTION_SUFFIX);
            OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
            if (onCameraChangeListener != null) {
                onCameraChangeListener.onCameraOpen();
                return true;
            }
            return true;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isStatusbarTextColorBlack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void mapViewDataBoundary(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            float focusDataYXRatioal = getFocusDataYXRatioal();
            this.mFocusDataYXRatial = focusDataYXRatioal;
            if (0.0f >= focusDataYXRatioal) {
                this.mFocusDataYXRatial = 1.0f;
            }
            int round = Math.round(this.mImageSize[1] * (this.mFocusViewRect.left / this.mScreeSize[0]));
            rect.top = round;
            int[] iArr = this.mImageSize;
            rect.bottom = iArr[1] - round;
            rect.left = Math.round(iArr[0] * (this.mFocusViewRect.top / this.mScreeSize[1]));
            rect.right = Math.round((rect.height() * this.mFocusDataYXRatial) + rect.left);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            if (132 != i2 || i3 == 1244) {
                restartScan();
            } else if (i3 == 1243) {
                finish();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_camera_detection"), null);
            this.mContentView = viewGroup;
            setContentView(viewGroup);
            IImageProcess imageProcessor = getImageProcessor();
            this.mImageProcessor = imageProcessor;
            if (imageProcessor == null) {
                LogUtil.e(Tag, "onCreate() failed to get ImageProcessor", null);
                finish();
            }
            this.mContentView.addView(getCustomizedView(), 1);
            View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
            this.mTitleBarMargin = findViewById;
            setTop(findViewById);
            setIsShowMultiWindowTips(true);
            setIsMultiWindowAvailable(false);
            setMultiWindowTipsId("wallet_base_multi_window_close");
            SurfaceView surfaceView = (SurfaceView) findViewById(ResUtils.id(getActivity(), "surfaceview"));
            this.mPreviewView = surfaceView;
            SurfaceHolder holder = surfaceView.getHolder();
            holder.setKeepScreenOn(true);
            holder.setType(3);
            holder.addCallback(this);
            com.baidu.wallet.base.camera.util.c a2 = com.baidu.wallet.base.camera.util.c.a(com.baidu.wallet.base.camera.util.a.a(), ImageProcessor.f36026a);
            this.mThreadPool = a2;
            a2.a(new Runnable(this) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CameraBaseActivity f57317a;

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
                    this.f57317a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57317a.mDetectorState.set(this.f57317a.mImageProcessor.initProcessor() ? 1 : 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LogUtil.i(Tag, "onDestroy()");
            this.mDone.set(true);
            Handler handler = this.mMiscEvtHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mMiscEvtHandler = null;
            }
            stopCamera();
            if (this.mImageProcessor != null) {
                new c(this).start();
            }
            com.baidu.wallet.base.camera.util.c cVar = this.mThreadPool;
            if (cVar != null) {
                cVar.a();
                this.mThreadPool = null;
            }
            updateFlashLightUi(false);
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LogUtil.i(Tag, "onPause()");
            super.onPause();
        }
    }

    public abstract void onPermissionDenied();

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, dialog) == null) {
            super.onPrepareDialog(i2, dialog);
            if (i2 == 3) {
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CameraBaseActivity f57318a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57318a = this;
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            WalletGlobalUtils.showStr = "";
                            CameraCtrl cameraCtrl = CameraCtrl.getInstance();
                            if (cameraCtrl != null) {
                                cameraCtrl.reset();
                            }
                            this.f57318a.finish();
                        }
                    }
                });
            }
        }
    }

    public abstract void onProcessImageOk(Object[] objArr);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == REQUEST_PERMISSION_CAMERA) {
                this.mCanRequestCameraPermission = true;
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                            if (iArr[i3] == 0) {
                                relayoutUi();
                                setFocusRectValue(this.mFocusViewRect);
                                startScan();
                            } else if (-1 == iArr[i3]) {
                                handleNoCamaraPermission();
                            }
                        }
                    }
                    return;
                }
                handleNoCamaraPermission();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LogUtil.i(Tag, "onResume()");
            super.onResume();
        }
    }

    public void pauseCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.mAutoFocusCb != null) {
                this.mAutoFocusCb.a(null, ResUtils.id(getActivity(), "wallet_auto_focus"));
            }
            d dVar = this.mPreviewCb;
            if (dVar != null) {
                dVar.c();
                setFlashLightOn(false);
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.internal.c
    public void processImage(byte[] bArr) {
        a availableDetector;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bArr) == null) || this.mDone.get() || 1 != this.mDetectorState.get() || (availableDetector = getAvailableDetector()) == null || this.mPreviewCb == null || this.mDone.get()) {
            return;
        }
        int[] iArr = this.mImageSize;
        availableDetector.a(bArr, iArr[0], iArr[1], this.mBmpDataRect);
        this.mThreadPool.a(availableDetector);
        if (this.mIsCameraMalfunctioned.get()) {
            for (byte b2 : bArr) {
                if (b2 != 0) {
                    this.mIsCameraMalfunctioned.compareAndSet(true, false);
                    Handler handler = this.mMiscEvtHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public abstract void relayoutUi();

    public void restartScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mDone.set(false);
            d dVar = this.mPreviewCb;
            if (dVar != null) {
                dVar.a(this.mPreviewView.getHolder());
                this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "wallet_auto_focus")).sendToTarget();
                return;
            }
            startScan();
        }
    }

    public abstract void setFocusRectValue(Rect rect);

    public void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onCameraChangeListener) == null) {
            this.mOnCameraChange = onCameraChangeListener;
        }
    }

    public void setTop(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, view) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
        ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
    }

    public void stopCamera() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (dVar = this.mPreviewCb) == null) {
            return;
        }
        dVar.a(false);
        this.mPreviewCb = null;
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (countDownTimer = this.mTimer) == null) {
            return;
        }
        countDownTimer.cancel();
        this.mTimer = null;
        this.mInCaptureTimeOut.set(false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048606, this, surfaceHolder, i2, i3, i4) == null) {
            LogUtil.i(Tag, "surfaceChanged");
            int[] iArr = this.mScreeSize;
            iArr[0] = i3;
            iArr[1] = i4;
            this.mSurfaceHolder = surfaceHolder;
            if (PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                startScan();
            } else if (this.mCanRequestCameraPermission) {
                BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CameraBaseActivity f57320a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57320a = this;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                this.f57320a.mCanRequestCameraPermission = false;
                                if (PermissionManager.checkCallingOrSelfPermission(this.f57320a.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, CameraBaseActivity.REQUEST_PERMISSION_CAMERA)) {
                                    return;
                                }
                                this.f57320a.handleNoCamaraPermission();
                            } else if (Build.VERSION.SDK_INT >= 23) {
                                this.f57320a.onRequestPermissionsResult(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                            }
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bool) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool) == null) {
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, surfaceHolder) == null) {
            String str = Tag;
            LogUtil.i(str, "surfaceCreated()" + surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, surfaceHolder) == null) {
            LogUtil.i(Tag, "surfaceDestroyed");
            switchFlashOnMainThread(false);
            this.mSurfaceHolder = null;
            stopCamera();
        }
    }

    public void switchCamera() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && CameraCtrl.getInstance().isSupportMultiCamera()) {
            int i2 = this.cameraId;
            if (i2 == 0) {
                this.cameraId = 1;
            } else if (i2 == 1) {
                this.cameraId = 0;
            }
            restartScan();
        }
    }

    public void takePicture() {
        com.baidu.wallet.base.camera.internal.b d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            LogUtil.d(Tag, "takePic");
            startCountDown();
            d dVar = this.mPreviewCb;
            if (dVar == null || (d2 = dVar.d()) == null) {
                return;
            }
            d2.a(this.autoFocusCallback);
        }
    }

    public void takePictureWithoutAutoFocus(com.baidu.wallet.base.camera.internal.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) || bVar == null) {
            return;
        }
        this.mInCaptureProgresses = true;
        System.currentTimeMillis();
        try {
            bVar.a(null, null, null, new Camera.PictureCallback(this) { // from class: com.baidu.wallet.base.camera.CameraBaseActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CameraBaseActivity f57322a;

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
                    this.f57322a = this;
                }

                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    CameraBaseActivity cameraBaseActivity;
                    IImageProcess iImageProcess;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr, camera) == null) {
                        String str = CameraBaseActivity.Tag;
                        LogUtil.d(str, "takepic callback Timeout = " + this.f57322a.mInCaptureTimeOut);
                        if (!this.f57322a.mInCaptureTimeOut.get() && (iImageProcess = (cameraBaseActivity = this.f57322a).mImageProcessor) != null) {
                            int[] iArr = cameraBaseActivity.mImageSize;
                            Object[] processImageJpegData = iImageProcess.processImageJpegData(bArr, iArr[0], iArr[1]);
                            if (processImageJpegData != null && this.f57322a.mDone.compareAndSet(false, true)) {
                                this.f57322a.pauseCamera();
                                this.f57322a.onProcessImageOk(processImageJpegData);
                            }
                        } else {
                            this.f57322a.pauseCamera();
                            this.f57322a.restartScan();
                        }
                        this.f57322a.mInCaptureProgresses = false;
                    }
                }
            });
        } catch (Throwable th) {
            this.mInCaptureTimeOut.set(true);
            this.mInCaptureProgresses = false;
            DXMSdkSAUtils.onEventWithValues("sdk_self_define_take_picture_failed", Arrays.asList(th.getMessage()));
        }
    }

    public void triggerFlash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            setFlashLightOn(!isFlashOn());
        }
    }

    public abstract void updateFlashLightUi(boolean z);

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f57326a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57327b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f57328c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f57329d;

        /* renamed from: e  reason: collision with root package name */
        public int f57330e;

        /* renamed from: f  reason: collision with root package name */
        public int f57331f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f57332g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f57333h;

        public a(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57326a = cameraBaseActivity;
            this.f57327b = a.class.getSimpleName();
            this.f57329d = null;
            this.f57333h = new AtomicBoolean(false);
        }

        public void a(byte[] bArr, int i2, int i3, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect}) == null) {
                this.f57328c = bArr;
                this.f57330e = i2;
                this.f57331f = i3;
                this.f57332g = rect;
                int recycledBufSize = this.f57326a.mImageProcessor.getRecycledBufSize(rect.width(), rect.height());
                byte[] bArr2 = this.f57329d;
                if (bArr2 == null || bArr2.length != recycledBufSize) {
                    this.f57329d = new byte[recycledBufSize];
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f57326a.mDone.get()) {
                    this.f57333h.set(false);
                } else if (!this.f57333h.compareAndSet(false, true)) {
                    LogUtil.e(this.f57327b, "internal error", null);
                } else {
                    Object[] processImage = this.f57326a.mImageProcessor.processImage(this.f57328c, this.f57330e, this.f57331f, this.f57332g, this.f57329d);
                    if (processImage != null && this.f57326a.mDone.compareAndSet(false, true)) {
                        this.f57326a.pauseCamera();
                        this.f57326a.onProcessImageOk(processImage);
                    }
                    this.f57333h.set(false);
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57333h.get() : invokeV.booleanValue;
        }
    }
}
