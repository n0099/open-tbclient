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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.datamodel.OpenFingerprintResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
import java.security.KeyStoreException;
@TargetApi(23)
/* loaded from: classes5.dex */
public class SysFingerprintPay implements IFingerprintPay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_DISMISS_LOADING_DIALOG = 4097;
    public static final int MSG_SHOW_LOADING_DIALOG = 4096;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public FingerprintHandler mSysFpHander;

    /* loaded from: classes5.dex */
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
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

    private boolean isNonePayingProcess(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, activity)) == null) ? activity instanceof NonePayingProcess : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOTPTokenByFingerprint(Activity activity, String str, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, str, fingerprintCallback) == null) {
            try {
                com.baidu.wallet.paysdk.fingerprint.ui.a a2 = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 1, str, fingerprintCallback);
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(a2, "FingerprintPayDialog");
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
            String sn = WalletFingerprint.getInstance(activity.getApplicationContext()).getSN();
            com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) activity, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, TAG);
            WalletGlobalUtils.showLoadingDialog(activity);
            aVar.a(sn);
            aVar.setResponseCallback(new IBeanResponseCallback(this, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f26242a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FingerprintCallback f26243b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ SysFingerprintPay f26244c;

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
                    this.f26244c = this;
                    this.f26242a = activity;
                    this.f26243b = fingerprintCallback;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        this.f26244c.mSysFpHander.post(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f26246a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f26247b;

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
                                this.f26247b = this;
                                this.f26246a = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f26247b.f26243b.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, this.f26246a);
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        WalletFingerprint.getInstance(this.f26242a).clearOTPToken();
                        this.f26244c.mSysFpHander.post(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f26245a;

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
                                this.f26245a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f26245a.f26243b.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 0, "");
                                }
                            }
                        });
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fingerprintHandler = this.mSysFpHander) == null) {
            return;
        }
        fingerprintHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void open(Activity activity, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, fingerprintCallback) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (!isNonePayingProcess(activity)) {
                if (payRequest.FP_Guide_Strategy > 0) {
                    register(activity, fingerprintCallback);
                    return;
                }
                return;
            }
            PasswordController.getPassWordInstance().checkPwd(activity, BeanConstants.FROM_FINGERPRINT_PAY, new PasswordController.IPwdListener(this, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f26239a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FingerprintCallback f26240b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ SysFingerprintPay f26241c;

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
                    this.f26241c = this;
                    this.f26239a = activity;
                    this.f26240b = fingerprintCallback;
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f26240b.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, str);
                    }
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD)).mPayPass = str;
                        this.f26241c.register(this.f26239a, this.f26240b);
                    }
                }
            });
        }
    }

    public void register(Activity activity, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, fingerprintCallback) == null) {
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
                        bVar.setResponseCallback(new IBeanResponseCallback(this, bVar, activity, fingerprintCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.baidu.wallet.paysdk.fingerprint.bean.b f26248a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Activity f26249b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ FingerprintCallback f26250c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ SysFingerprintPay f26251d;

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
                                this.f26251d = this;
                                this.f26248a = bVar;
                                this.f26249b = activity;
                                this.f26250c = fingerprintCallback;
                            }

                            @Override // com.baidu.apollon.beans.IBeanResponseCallback
                            public void onBeanExecFailure(int i2, int i3, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                                    this.f26248a.destroyBean();
                                    this.f26251d.mSysFpHander.sendEmptyMessage(4097);
                                    this.f26251d.mSysFpHander.post(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f26253a;

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
                                            this.f26253a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                AnonymousClass3 anonymousClass3 = this.f26253a;
                                                anonymousClass3.f26250c.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(anonymousClass3.f26249b, "wallet_fp_open_failed"));
                                            }
                                        }
                                    });
                                }
                            }

                            @Override // com.baidu.apollon.beans.IBeanResponseCallback
                            public void onBeanExecSuccess(int i2, Object obj, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                                    this.f26248a.destroyBean();
                                    this.f26251d.mSysFpHander.sendEmptyMessage(4097);
                                    OpenFingerprintResponse openFingerprintResponse = (obj == null || !(obj instanceof OpenFingerprintResponse)) ? null : (OpenFingerprintResponse) obj;
                                    if (openFingerprintResponse == null || TextUtils.isEmpty(openFingerprintResponse.token_info)) {
                                        this.f26251d.mSysFpHander.post(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f26252a;

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
                                                this.f26252a = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    AnonymousClass3 anonymousClass3 = this.f26252a;
                                                    anonymousClass3.f26250c.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(anonymousClass3.f26249b, "wallet_fp_open_failed"));
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    String safeSavedDataByUnionId = OtpTokenUtils.toSafeSavedDataByUnionId(SafePay.getInstance().decryptProxy(openFingerprintResponse.token_info), this.f26249b.getApplicationContext());
                                    String localEncrypt1 = SafePay.getInstance().localEncrypt1(OtpTokenUtils.getSN(openFingerprintResponse.token_info));
                                    this.f26251d.saveOTPTokenByFingerprint(this.f26249b, localEncrypt1 + "|" + safeSavedDataByUnionId, this.f26250c);
                                }
                            }
                        });
                        bVar.execBean();
                    } catch (Exception unused) {
                        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GENERATEKEY_FAILED);
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
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, fingerprintCallback) == null) {
            try {
                com.baidu.wallet.paysdk.fingerprint.ui.a a2 = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 2, null, fingerprintCallback);
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(a2, "FingerprintPayDialog");
                beginTransaction.commitAllowingStateLoss();
            } catch (KeyStoreException unused) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
            }
        }
    }
}
