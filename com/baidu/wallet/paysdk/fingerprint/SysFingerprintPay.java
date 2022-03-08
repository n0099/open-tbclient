package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.datamodel.OpenFingerprintResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.nopassauth.OtpTokenUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
import java.security.KeyStoreException;
@TargetApi(23)
/* loaded from: classes6.dex */
public class SysFingerprintPay implements IFingerprintPay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_DISMISS_LOADING_DIALOG = 4097;
    public static final int MSG_SHOW_LOADING_DIALOG = 4096;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public FingerprintHandler mSysFpHander;

    /* loaded from: classes6.dex */
    public class FingerprintHandler extends Handler implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SysFingerprintPay this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FingerprintHandler(SysFingerprintPay sysFingerprintPay, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sysFingerprintPay, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sysFingerprintPay;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 4096) {
                    WalletGlobalUtils.showLoadingDialog((Activity) message.obj);
                } else if (i2 == 4097) {
                    WalletGlobalUtils.DismissLoadingDialog();
                } else {
                    super.handleMessage(message);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2106112054, "Lcom/baidu/wallet/paysdk/fingerprint/SysFingerprintPay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2106112054, "Lcom/baidu/wallet/paysdk/fingerprint/SysFingerprintPay;");
                return;
            }
        }
        TAG = SysFingerprintPay.class.getSimpleName();
    }

    public SysFingerprintPay() {
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
        this.mSysFpHander = new FingerprintHandler(this, Looper.getMainLooper());
    }

    private boolean checkFingerprintAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            if (PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT")) {
                a aVar = null;
                FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class);
                try {
                    aVar = a.a(context);
                } catch (KeyStoreException e2) {
                    e2.printStackTrace();
                }
                return aVar != null && aVar.a() && fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchCloseSysFingerprint(Activity activity, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, activity, fingerprintCallback) == null) {
            String sn = WalletFingerprint.getInstance(activity.getApplicationContext()).getSN();
            com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) activity, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, TAG);
            WalletGlobalUtils.showLoadingDialog(activity);
            aVar.a(sn);
            aVar.setResponseCallback(new IBeanResponseCallback(this, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Activity a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FingerprintCallback f50628b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ SysFingerprintPay f50629c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, fingerprintCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50629c = this;
                    this.a = activity;
                    this.f50628b = fingerprintCallback;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        this.f50629c.mSysFpHander.post(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ String a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f50630b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f50630b = this;
                                this.a = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f50630b.f50628b.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, this.a);
                                }
                            }
                        });
                    }
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        WalletFingerprint.getInstance(this.a).clearOTPToken();
                        this.f50629c.mSysFpHander.post(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.f50628b.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 0, "");
                                }
                            }
                        });
                    }
                }
            });
            aVar.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOTPTokenByFingerprint(Activity activity, String str, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, activity, str, fingerprintCallback) == null) {
            try {
                com.baidu.wallet.paysdk.fingerprint.ui.a a = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 1, str, fingerprintCallback);
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(a, "FingerprintPayDialog");
                beginTransaction.commitAllowingStateLoss();
            } catch (KeyStoreException unused) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void close(Activity activity, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, fingerprintCallback) == null) {
            WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(activity, new ILoginBackListener(this, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Activity a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FingerprintCallback f50624b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ SysFingerprintPay f50625c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, fingerprintCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50625c = this;
                    this.a = activity;
                    this.f50624b = fingerprintCallback;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f50625c.fetchCloseSysFingerprint(this.a, this.f50624b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f50625c.fetchCloseSysFingerprint(this.a, this.f50624b);
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void closeFingerprint(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_CLOSE_FINGERPRINT);
            String sn = WalletFingerprint.getInstance(context).getSN();
            com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean(context, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, TAG);
            aVar.a(sn);
            aVar.setResponseCallback(new IBeanResponseCallback(this, aVar, context) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.wallet.paysdk.fingerprint.bean.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f50626b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ SysFingerprintPay f50627c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50627c = this;
                    this.a = aVar;
                    this.f50626b = context;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        this.a.destroyBean();
                    }
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        this.a.destroyBean();
                        WalletFingerprint.getInstance(this.f50626b).clearOTPToken();
                    }
                }
            });
            aVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void destory() {
        FingerprintHandler fingerprintHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fingerprintHandler = this.mSysFpHander) == null) {
            return;
        }
        fingerprintHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void open(Activity activity, FingerprintCallback fingerprintCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, activity, fingerprintCallback, z) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (!z && payRequest != null && payRequest.FP_Guide_Strategy > 0) {
                register(activity, fingerprintCallback);
            } else {
                PasswordController.getPassWordInstance().checkPwd(activity, BeanConstants.FROM_FINGERPRINT_PAY, new PasswordController.IPwdListener(this, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Activity a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ FingerprintCallback f50622b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ SysFingerprintPay f50623c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, fingerprintCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f50623c = this;
                        this.a = activity;
                        this.f50622b = fingerprintCallback;
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            this.f50622b.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, str);
                        }
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onSucceed(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD)).mPayPass = str;
                            this.f50623c.register(this.a, this.f50622b);
                        }
                    }
                });
            }
        }
    }

    public void register(Activity activity, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, fingerprintCallback) == null) {
            Context applicationContext = activity.getApplicationContext();
            if (Build.VERSION.SDK_INT < 23) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_sys_too_low"));
            } else if (!checkFingerprintAvailable(activity)) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_unsupport_cancle_open"));
            } else {
                try {
                    try {
                        a.a(activity).a(WalletFingerprint.getKeyStoreNewAlise(activity));
                        Message.obtain(this.mSysFpHander, 4096, activity).sendToTarget();
                        com.baidu.wallet.paysdk.fingerprint.bean.b bVar = (com.baidu.wallet.paysdk.fingerprint.bean.b) FingerprintBeanFactory.getInstance().getBean(applicationContext, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, TAG);
                        bVar.setResponseCallback(new IBeanResponseCallback(this, bVar, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ com.baidu.wallet.paysdk.fingerprint.bean.b a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Activity f50631b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ FingerprintCallback f50632c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ SysFingerprintPay f50633d;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bVar, activity, fingerprintCallback};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f50633d = this;
                                this.a = bVar;
                                this.f50631b = activity;
                                this.f50632c = fingerprintCallback;
                            }

                            @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                            public void onBeanExecFailure(int i2, int i3, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                                    this.a.destroyBean();
                                    this.f50633d.mSysFpHander.sendEmptyMessage(4097);
                                    this.f50633d.mSysFpHander.post(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.5.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass5 a;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                AnonymousClass5 anonymousClass5 = this.a;
                                                anonymousClass5.f50632c.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(anonymousClass5.f50631b, "wallet_fp_open_failed"));
                                            }
                                        }
                                    });
                                }
                            }

                            @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                            public void onBeanExecSuccess(int i2, Object obj, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                                    this.a.destroyBean();
                                    this.f50633d.mSysFpHander.sendEmptyMessage(4097);
                                    OpenFingerprintResponse openFingerprintResponse = (obj == null || !(obj instanceof OpenFingerprintResponse)) ? null : (OpenFingerprintResponse) obj;
                                    if (openFingerprintResponse == null || TextUtils.isEmpty(openFingerprintResponse.token_info)) {
                                        this.f50633d.mSysFpHander.post(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.5.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass5 a;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i3 = newInitContext.flag;
                                                    if ((i3 & 1) != 0) {
                                                        int i4 = i3 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.a = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    AnonymousClass5 anonymousClass5 = this.a;
                                                    anonymousClass5.f50632c.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(anonymousClass5.f50631b, "wallet_fp_open_failed"));
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    String safeSavedDataByUnionId = OtpTokenUtils.toSafeSavedDataByUnionId(SecurePay.getInstance().decryptProxy(openFingerprintResponse.token_info), this.f50631b.getApplicationContext());
                                    String localEncrypt1 = SecurePay.getInstance().localEncrypt1(OtpTokenUtils.getSN(openFingerprintResponse.token_info));
                                    this.f50633d.saveOTPTokenByFingerprint(this.f50631b, localEncrypt1 + "|" + safeSavedDataByUnionId, this.f50632c);
                                }
                            }
                        });
                        bVar.execBean();
                    } catch (Exception unused) {
                        StatisticManager.onEvent("fprd_generateKey_failed");
                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
                    }
                } catch (KeyStoreException e2) {
                    e2.printStackTrace();
                    fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void verify(Activity activity, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, fingerprintCallback) == null) {
            try {
                com.baidu.wallet.paysdk.fingerprint.ui.a a = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 2, null, fingerprintCallback);
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(a, "FingerprintPayDialog");
                beginTransaction.commitAllowingStateLoss();
            } catch (KeyStoreException unused) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
            }
        }
    }
}
