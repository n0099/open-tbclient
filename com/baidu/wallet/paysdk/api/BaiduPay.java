package com.baidu.wallet.paysdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.android.pay.ScanCodeCallBack;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.beans.VerifyPayPasswordBean;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.UserInfoContentResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyPayPasswordResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.baidu.wallet.remotepay.RemotePaySplashActivity;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.google.protobuf.CodedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class BaiduPay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AMOUNT = "pay_amount";
    public static final String PAY_FROM = "pay_from";
    public static final String PAY_FROM_AUTHORIZE = "pay_from_authorize";
    public static final String PAY_FROM_BIND_CARD = "pay_from_bind_card";
    public static final String PAY_FROM_HUA_FEI = "pay_from_huafei";
    public static final String PAY_FROM_HUA_ZHUAN_ZHANG = "pay_from_zhuanzhang";
    public static final String PAY_FROM_NFC_BUSCARD_CHARGE = "pay_from_nfc_buscard_charge";
    public static final String PAY_FROM_TRAFFIC = "pay_from_traffic";
    public static final String PAY_TYPE_KEY = "type";
    public static final String PRECASHIER_PAY_RESPONSE = "precashier_pay_response";
    public static final int TYPE_FASE_PAY = 4;
    public static final int TYPE_PAY_ALL = 0;
    public static final int TYPE_SURPLUS = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayCallBack f61927a;

    /* renamed from: b  reason: collision with root package name */
    public IBindCardCallback f61928b;

    /* renamed from: c  reason: collision with root package name */
    public RNAuthCallBack f61929c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61930d;

    /* renamed from: e  reason: collision with root package name */
    public a f61931e;

    /* renamed from: f  reason: collision with root package name */
    public ScanCodeCallBack f61932f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61933g;

    /* renamed from: com.baidu.wallet.paysdk.api.BaiduPay$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f61939a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f61940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CheckCallBack f61941c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BaiduPay f61942d;

        public AnonymousClass3(BaiduPay baiduPay, Context context, CheckCallBack checkCallBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduPay, context, checkCallBack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61942d = baiduPay;
            this.f61940b = context;
            this.f61941c = checkCallBack;
            this.f61939a = new Handler(this.f61940b.getMainLooper());
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.f61939a.post(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.3.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f61946a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass3 f61947b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61947b = this;
                        this.f61946a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f61947b.f61941c.onCheckResult(3, this.f61946a);
                        }
                    }
                });
            }
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.f61939a.post(new Runnable(this, obj) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.3.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Object f61943a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass3 f61944b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61944b = this;
                        this.f61943a = obj;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        UserInfoContentResponse.UserBean userBean;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            UserInfoContentResponse userInfoContentResponse = (UserInfoContentResponse) this.f61943a;
                            if (userInfoContentResponse != null && (userBean = userInfoContentResponse.user_info) != null && userBean.hasMobilePwd()) {
                                PasswordController.getPassWordInstance().checkPwd(this.f61944b.f61940b, BeanConstants.FROM_COMMON_CHECK_PWD, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.3.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f61945a;

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
                                        this.f61945a = this;
                                    }

                                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                                    public void onFail(int i3, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, str2) == null) {
                                            PasswordController.getPassWordInstance().clearCheckPwdListener();
                                            this.f61945a.f61944b.f61941c.onCheckResult(2, QueryResponse.Options.CANCEL);
                                        }
                                    }

                                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                                    public void onSucceed(String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                            PasswordController.getPassWordInstance().clearCheckPwdListener();
                                            this.f61945a.f61944b.f61941c.onCheckResult(0, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS);
                                        }
                                    }
                                });
                            } else {
                                this.f61944b.f61941c.onCheckResult(1, "当前未设置手机支付密码");
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.wallet.paysdk.api.BaiduPay$4  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass4 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f61948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f61949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61950c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CheckCallBack f61951d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaiduPay f61952e;

        public AnonymousClass4(BaiduPay baiduPay, Context context, String str, CheckCallBack checkCallBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduPay, context, str, checkCallBack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61952e = baiduPay;
            this.f61949b = context;
            this.f61950c = str;
            this.f61951d = checkCallBack;
            this.f61948a = new Handler(this.f61949b.getMainLooper());
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.f61948a.post(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.4.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f61956a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass4 f61957b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61957b = this;
                        this.f61956a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f61957b.f61951d.onCheckResult(3, this.f61956a);
                        }
                    }
                });
            }
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                WalletGlobalUtils.DismissLoadingDialog();
                this.f61948a.post(new Runnable(this, obj) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.4.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Object f61953a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass4 f61954b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61954b = this;
                        this.f61953a = obj;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            VerifyPayPasswordResponse verifyPayPasswordResponse = (VerifyPayPasswordResponse) this.f61953a;
                            if (verifyPayPasswordResponse != null && verifyPayPasswordResponse.has_pwd == 1) {
                                PasswordController passWordInstance = PasswordController.getPassWordInstance();
                                AnonymousClass4 anonymousClass4 = this.f61954b;
                                passWordInstance.checkPwdFromH5(anonymousClass4.f61949b, anonymousClass4.f61950c, BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.4.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f61955a;

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
                                        this.f61955a = this;
                                    }

                                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                                    public void onFail(int i3, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, str2) == null) {
                                            PasswordController.getPassWordInstance().clearCheckPwdListener();
                                            this.f61955a.f61954b.f61951d.onCheckResult(2, QueryResponse.Options.CANCEL);
                                        }
                                    }

                                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                                    public void onSucceed(String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                            PasswordController.getPassWordInstance().clearCheckPwdListener();
                                            this.f61955a.f61954b.f61951d.onCheckResult(0, str2);
                                        }
                                    }
                                });
                                return;
                            }
                            this.f61954b.f61951d.onCheckResult(1, "当前未设置手机支付密码");
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface IBindCardCallback {
        void onChangeFailed(String str);

        void onChangeSucceed(String str);
    }

    /* loaded from: classes8.dex */
    public static class a implements BindBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final BindBack f61960a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61961b;

        @Override // com.baidu.android.pay.BindBack
        public boolean isHideLoadingDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.android.pay.BindBack
        public void onBindResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                BindBack bindBack = this.f61960a;
                if (bindBack != null) {
                    bindBack.onBindResult(i2, str);
                }
                this.f61961b = false;
            }
        }

        public a(BindBack bindBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bindBack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61961b = true;
            this.f61960a = bindBack;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BaiduPay f61962a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2106665990, "Lcom/baidu/wallet/paysdk/api/BaiduPay$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2106665990, "Lcom/baidu/wallet/paysdk/api/BaiduPay$b;");
                    return;
                }
            }
            f61962a = new BaiduPay();
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            boolean isRemotePay = PayDataCache.getInstance().isRemotePay();
            Context remotePayContext = getInstance().getRemotePayContext();
            boolean isFromPreCashier = PayDataCache.getInstance().isFromPreCashier();
            if (!isRemotePay) {
                clearPayBack();
                PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().3");
            } else {
                PayCallBackManager.callBackClientClear(context, "BaiduPay.innerPay().4");
                clearPayBack();
                PayDataCache.getInstance().setIsRemotePay(true);
                getInstance().setRemotePayContext(remotePayContext);
            }
            if (isFromPreCashier) {
                PayDataCache.getInstance().setFromPreCashier();
            }
        }
    }

    public static BaiduPay getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b.f61962a : (BaiduPay) invokeV.objValue;
    }

    public void bindCard(Context context, IBindCardCallback iBindCardCallback, PayRequestCache.BindCategory bindCategory, int i2, String str, String str2, Bundle bundle, String str3, boolean z, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, iBindCardCallback, bindCategory, Integer.valueOf(i2), str, str2, bundle, str3, Boolean.valueOf(z), str4}) == null) {
            if (bindCategory == null || PayRequestCache.BindCategory.Other == bindCategory) {
                throw new IllegalStateException("not support bind card for Paying");
            }
            if (context == null) {
                if (iBindCardCallback != null) {
                    iBindCardCallback.onChangeFailed("");
                    return;
                }
                return;
            }
            BindFastRequest createBindRequest = BindCardEntry.createBindRequest(bindCategory);
            createBindRequest.mBindFrom = i2;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str2)) {
                createBindRequest.setSp_no(str2);
                sb.append("sp_no:\"");
                sb.append(str2);
                sb.append("\",");
            }
            if (!TextUtils.isEmpty(str)) {
                createBindRequest.serviceType = str;
                sb.append("service_type:\"");
                sb.append(str);
                sb.append("\"}");
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("baidu.wallet.from", bindCategory.name());
            if (!TextUtils.isEmpty(str3)) {
                if (sb.length() > 0) {
                    sb.insert(0, str3);
                    sb.setCharAt(str3.length() - 1, ',');
                    sb.setCharAt(sb.length() - 1, ExtendedMessageFormat.END_FE);
                } else {
                    sb.append(str3);
                }
            } else if (sb.length() > 0) {
                sb.insert(0, StringUtil.ARRAY_START).setCharAt(sb.length() - 1, ExtendedMessageFormat.END_FE);
            }
            if (sb.length() > 0) {
                BindCardEntry.setExtrParam(sb.toString());
            }
            BindCardEntry.OnReturn createCb4CheckPwdAndBind = BindCardEntry.createCb4CheckPwdAndBind(context, iBindCardCallback, bundle, z, str4);
            BindCardEntry.init(context);
            BindCardEntry.setCallback(createCb4CheckPwdAndBind);
            BindCardEntry.run();
        }
    }

    public void bindCardAuth(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, z) == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = 6;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            Intent intent = new Intent(context, BindCardImplActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, z);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    public void bindCardOnCardaddReturn(Context context, BindCardEntry.OnReturn onReturn, PayRequestCache.BindCategory bindCategory, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, onReturn, bindCategory, Integer.valueOf(i2), str, str2}) == null) || onReturn == null) {
            return;
        }
        if (context == null) {
            onReturn.onFailed(-1, "context null");
            return;
        }
        BindCardEntry.init(context);
        BindCardEntry.setCallback(onReturn);
        BindCardEntry.setExtrParam(str2);
        BindFastRequest createBindRequest = BindCardEntry.createBindRequest(bindCategory);
        createBindRequest.mBindFrom = i2;
        if (!TextUtils.isEmpty(str)) {
            createBindRequest.serviceType = str;
        }
        BindCardEntry.run();
    }

    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, checkCallBack) == null) {
            UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean(context, 6, TableDefine.DB_TABLE_USERINFO);
            userInfoBean.setResponseCallback(new AnonymousClass3(this, context, checkCallBack));
            userInfoBean.execBean();
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            WalletGlobalUtils.showLoadingDialog(context);
        }
    }

    public void checkPwdFromH5(Context context, String str, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, str, checkCallBack) == null) {
            VerifyPayPasswordBean verifyPayPasswordBean = (VerifyPayPasswordBean) PayBeanFactory.getInstance().getBean(context, 600, "userHasPayPassword");
            verifyPayPasswordBean.setResponseCallback(new AnonymousClass4(this, context, str, checkCallBack));
            verifyPayPasswordBean.execBean();
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            WalletGlobalUtils.showLoadingDialog(context);
        }
    }

    public void clearBindCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f61928b = null;
        }
    }

    public void clearBindCallbackExt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f61931e = null;
        }
    }

    public void clearPayBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f61927a = null;
        }
    }

    public void clearRNAuthBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f61929c = null;
        }
    }

    public void completeCardAuth(Context context, CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, bondCard) == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = 7;
            bindFastRequest.mBondCard = bondCard;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            Intent intent = new Intent(context, BindCardImplActivity.class);
            int a2 = i.a().a(context, bondCard, false);
            if (a2 > 0) {
                intent.putExtra("halfScreen", a2);
            }
            intent.putExtra("reasonForChangeCardItem", 1);
            context.startActivity(intent);
        }
    }

    public void directAuth(Context context, CardData.BondCard bondCard) {
        CardData.BondCard bondCard2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, bondCard) == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBondCard = bondCard;
            bindFastRequest.mBindFrom = 8;
            bindFastRequest.setmBankInfo(null);
            bindFastRequest.setmPhone(bondCard.mobile);
            bindFastRequest.setSendSmsphone(bondCard.mobile);
            bindFastRequest.setmBankCard(bondCard.account_no);
            bindFastRequest.setSubBankCode(bondCard.account_bank_code);
            a(bindFastRequest, bondCard);
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            Intent intent = new Intent(context, WalletSmsActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null && (bondCard2 = payRequest.mBondCard) != null && bondCard2.hideSMSDialog && PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
                intent.putExtra("showSMSDialog", false);
            }
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).startActivityWithoutAnim(intent);
            } else {
                context.startActivity(intent);
            }
        }
    }

    public void doBindCardExt(Context context, BindBack bindBack, Map<String, String> map, String str) {
        String sb;
        String urlParam2JsonStr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, bindBack, map, str) == null) {
            if (map != null && context != null) {
                if (!WalletLoginHelper.getInstance().isLogin()) {
                    PayCallBackManager.callBackClientCancel(context, "BaiduPay.doBindCardExt().2");
                    return;
                }
                setBindCardbackExt(bindBack);
                if (map.isEmpty() && TextUtils.isEmpty(str)) {
                    urlParam2JsonStr = null;
                } else {
                    PayDataCache.getInstance().setIsRemotePay(false);
                    PayDataCache.getInstance().resetFromPrecashier();
                    PayRequest payRequest = new PayRequest();
                    payRequest.setPayFrom(PAY_FROM_BIND_CARD);
                    if (!TextUtils.isEmpty(str)) {
                        sb = str;
                        payRequest.initBindCardOrder(sb);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (sb2.length() > 1) {
                                sb2.append("&");
                            }
                            sb2.append(entry.getKey());
                            sb2.append("=");
                            sb2.append(entry.getValue());
                        }
                        sb = sb2.toString();
                    }
                    if (TextUtils.isEmpty(payRequest.mSpNO)) {
                        payRequest.mSpNO = map.get("sp_no");
                    }
                    if (TextUtils.isEmpty(payRequest.mOrderNo)) {
                        payRequest.mOrderNo = map.get("order_no");
                    }
                    payRequest.mParams = sb;
                    PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                    urlParam2JsonStr = com.dxmpay.wallet.utils.StringUtil.urlParam2JsonStr(sb);
                }
                getInstance().bindCard(context, new IBindCardCallback(this, bindBack) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindBack f61937a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPay f61938b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bindBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61938b = this;
                        this.f61937a = bindBack;
                    }

                    @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                    public void onChangeFailed(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                            BindBack bindBack2 = this.f61937a;
                            if (bindBack2 != null) {
                                bindBack2.onBindResult(-1, "");
                                StatHelper.clearSensor();
                                return;
                            }
                            this.f61938b.setBindCardbackExt(null);
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                    public void onChangeSucceed(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                            BindBack bindBack2 = this.f61937a;
                            if (bindBack2 != null) {
                                bindBack2.onBindResult(0, "");
                                StatHelper.clearSensor();
                                return;
                            }
                            this.f61938b.setBindCardbackExt(null);
                        }
                    }
                }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, urlParam2JsonStr, true, BeanConstants.FROM_BIND);
                return;
            }
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.doBindCardExt().1");
        }
    }

    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, map, checkCallBack) == null) {
            PasswordController.getPassWordInstance().checkPwdForSp(context, map, new PasswordController.IPwdListener(this, checkCallBack) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f61958a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPay f61959b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61959b = this;
                    this.f61958a = checkCallBack;
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        PasswordController.getPassWordInstance().clearCheckPwdListener();
                        this.f61958a.onCheckResult(i2, str);
                    }
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        PasswordController.getPassWordInstance().clearCheckPwdListener();
                        this.f61958a.onCheckResult(0, "");
                    }
                }
            });
        }
    }

    public void doPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, context, str, payCallBack, map) == null) {
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().resetFromPrecashier();
            String orderNo = StatHelper.getOrderNo(str);
            if (orderNo != null && !orderNo.equals(StatHelper.getOrderNo())) {
                StatHelper.clearSensor();
                StatHelper.cachePayFrom("0");
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            }
            BaiduPayDelegate.getInstance().cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
            a(context, str, payCallBack, map, null);
        }
    }

    public void doPayRNAuth(Context context, String str, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, context, str, rNAuthCallBack) == null) || !WalletLoginHelper.getInstance().isLogin() || context == null || TextUtils.isEmpty(str) || rNAuthCallBack == null) {
            return;
        }
        this.f61933g = context;
        this.f61929c = rNAuthCallBack;
        this.f61930d = false;
        H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this, context, rNAuthCallBack) { // from class: com.baidu.wallet.paysdk.api.BaiduPay.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f61934a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RNAuthCallBack f61935b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BaiduPay f61936c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, rNAuthCallBack};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61936c = this;
                this.f61934a = context;
                this.f61935b = rNAuthCallBack;
            }

            @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                int i2;
                String str2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                    pop();
                    EventBus.getInstance().unregister(this.f61934a, BeanConstants.EVENT_H5_RN_AUTH_RESULT);
                    if (this.f61936c.f61930d) {
                        str2 = "RnAuthSuccess";
                        i2 = 0;
                    } else {
                        i2 = -1;
                        str2 = "RnAuthFail";
                    }
                    String orderNo = StatHelper.getOrderNo();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RNAUTH_RESULT, StatHelper.collectData(orderNo, i2 + "", str2));
                    this.f61935b.onRNAuthResult(i2, str2);
                }
            }
        };
        h5LifeCycleCallback.push();
        EventBus.getInstance().register(context, BeanConstants.EVENT_H5_RN_AUTH_RESULT, 0, EventBus.ThreadMode.MainThread);
        Bundle bundle = new Bundle();
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", str);
        bundle.putParcelable("lifecycleLsnr", h5LifeCycleCallback);
        BaiduWalletDelegate.getInstance().openH5Module(context, bundle);
    }

    public void doPrecashierPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048591, this, context, str, payCallBack, map, precashierCreateOrderResponse) == null) {
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setFromPreCashier();
            a(context, str, payCallBack, map, precashierCreateOrderResponse);
        }
    }

    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048592, this, context, map, rNAuthCallBack) == null) && WalletLoginHelper.getInstance().isLogin() && map != null) {
            this.f61929c = rNAuthCallBack;
            StringBuilder sb = new StringBuilder();
            if (!map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                }
            }
            sb.append("is_from_sdk=1");
            StringBuilder sb2 = new StringBuilder(DomainConfig.getInstance().getAppPayHost() + "/static/wap/auth/");
            if (sb.length() > 0) {
                sb2.append("?");
                sb2.append(sb.toString());
            }
            String sb3 = sb2.toString();
            Bundle bundle = new Bundle();
            bundle.putInt("baidu.wallet.lightapp.biztype", 12);
            BaiduWalletDelegate.getInstance().openH5Module(context, sb3, false, bundle);
        }
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, context, str, payCallBack, map) == null) {
            this.f61933g = context;
            PayDataCache.getInstance().setIsRemotePay(true);
            PayDataCache.getInstance().resetFromPrecashier();
            a(context, str, payCallBack, map, null);
        }
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            clearPayBack();
        }
    }

    public IBindCardCallback getBindCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f61928b : (IBindCardCallback) invokeV.objValue;
    }

    public BindBack getBindCallbackExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f61931e : (BindBack) invokeV.objValue;
    }

    public PayCallBack getPayBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f61927a : (PayCallBack) invokeV.objValue;
    }

    public RNAuthCallBack getRNAuthBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f61929c : (RNAuthCallBack) invokeV.objValue;
    }

    public Context getRemotePayContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f61933g : (Context) invokeV.objValue;
    }

    public ScanCodeCallBack getScanCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f61932f : (ScanCodeCallBack) invokeV.objValue;
    }

    public boolean isBindCardProcessing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            a aVar = this.f61931e;
            return aVar != null && aVar.f61961b;
        }
        return invokeV.booleanValue;
    }

    public void jumpWapCashier(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, context, str, str2) == null) {
            Intent intent = new Intent();
            intent.setClassName(context, str2);
            intent.putExtra("jump_url", str);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void launchBindCardActivity(Context context, IBindCardCallback iBindCardCallback, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, iBindCardCallback, bundle) == null) {
            if (context == null) {
                if (iBindCardCallback != null) {
                    iBindCardCallback.onChangeFailed("");
                    return;
                }
                return;
            }
            this.f61928b = iBindCardCallback;
            Intent intent = new Intent(context, BindCardImplActivity.class);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void payRnAuthOnModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, event) == null) {
            if (event == null) {
                this.f61930d = false;
            } else if (BeanConstants.EVENT_H5_RN_AUTH_RESULT.equals(event.mEventKey)) {
                if (event.mEventObj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                        if (jSONObject.has(BeanConstants.EVENT_AUTH_RESULT) && 1 == jSONObject.getInt(BeanConstants.EVENT_AUTH_RESULT)) {
                            this.f61930d = true;
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        this.f61930d = false;
                        return;
                    }
                }
                this.f61930d = false;
            }
        }
    }

    public void preOrderPay(Context context, String str, String str2, PayCallBack payCallBack, Map<String, String> map) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048605, this, context, str, str2, payCallBack, map) == null) {
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setFromPreCashier();
            PayDataCache.getInstance().setOrderExtraInfo(str2);
            BaiduWalletDelegate.getInstance().checkSecurityEvn();
            if (!WalletLoginHelper.getInstance().isLogin()) {
                a(context);
                return;
            }
            if (PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY) != null || PayDataCache.getInstance().isRemotePay()) {
                b(context);
            }
            this.f61927a = payCallBack;
            if (map == null) {
                PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().2");
                return;
            }
            a(str, map);
            if (PayDataCache.getInstance().isRemotePay()) {
                intent = new Intent(context, RemotePaySplashActivity.class);
            } else {
                intent = new Intent(context, WelcomeActivity.class);
            }
            intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 3);
            intent.putExtra("orderExtraInfo", str2);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivityForResult(intent, BeanConstants.REQUEST_CODE_PAY_ACTIVITY);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(268435456);
            if (PayDataCache.getInstance().isRemotePay()) {
                intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            }
            context.getApplicationContext().startActivity(intent);
        }
    }

    public void resetRemotePayContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f61933g = null;
        }
    }

    public void setBindCardbackExt(BindBack bindBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bindBack) == null) {
            this.f61931e = bindBack != null ? new a(bindBack) : null;
        }
    }

    public void setRemotePayContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            this.f61933g = context;
        }
    }

    public void setScanCallback(ScanCodeCallBack scanCodeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, scanCodeCallBack) == null) {
            this.f61932f = scanCodeCallBack;
        }
    }

    public BaiduPay() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61930d = false;
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, this, context, str, payCallBack, map, precashierCreateOrderResponse) == null) {
            BaiduWalletDelegate.getInstance().checkSecurityEvn();
            if (!WalletLoginHelper.getInstance().isLogin()) {
                a(context);
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    return;
                }
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put("sp_no", StatHelper.getSpNo());
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_NOT_LOGIN, collectData, hashMap);
                return;
            }
            if (PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY) != null || PayDataCache.getInstance().isRemotePay()) {
                b(context);
            }
            this.f61927a = payCallBack;
            if (map == null) {
                PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().2");
                return;
            }
            a(str, map);
            a(context, precashierCreateOrderResponse);
        }
    }

    private void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, map) == null) {
            PayRequest a2 = a(str, map, map.get("pay_from"));
            PayRequestCache.getInstance().addBeanRequestToCache(a2.getRequestId(), a2);
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().1");
            AccountManager.getInstance(context).logout();
            WalletLoginHelper.getInstance().handlerWalletError(5003);
            GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_please_login"));
        }
    }

    private void a(Context context, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, precashierCreateOrderResponse) == null) {
            if (PayDataCache.getInstance().isRemotePay()) {
                intent = new Intent(context, RemotePaySplashActivity.class);
            } else {
                intent = new Intent(context, WelcomeActivity.class);
            }
            intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 1);
            if (precashierCreateOrderResponse != null) {
                intent.putExtra(PRECASHIER_PAY_RESPONSE, precashierCreateOrderResponse);
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivityForResult(intent, BeanConstants.REQUEST_CODE_PAY_ACTIVITY);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(268435456);
            if (PayDataCache.getInstance().isRemotePay()) {
                intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            }
            context.getApplicationContext().startActivity(intent);
        }
    }

    private PayRequest a(String str, Map<String, String> map, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, map, str2)) == null) {
            PayRequest payRequest = new PayRequest();
            payRequest.setPayFrom(str2);
            if (PayDataCache.getInstance().isRemotePay()) {
                payRequest.mRemotePayUserId = WalletLoginHelper.getInstance().getPassUid();
                payRequest.mRemotePayUserAccountName = WalletLoginHelper.getInstance().getPassUserName();
                payRequest.mRemotePayHostName = map.get("key_remote_app_name");
                payRequest.mRemotePkg = map.get("key_remote_pkg_name");
                payRequest.mRemoteWhereToBackAct = map.get("key_remote_where_to_back");
                PayDataCache.getInstance().setRemotePayHostName(map.get("key_remote_app_name"));
                PayDataCache.getInstance().setRemotePkg(map.get("key_remote_pkg_name"));
                PayDataCache.getInstance().setRemoteWhereToBackAct(map.get("key_remote_where_to_back"));
            }
            payRequest.initOrder(str);
            String str3 = "doPay. order info = " + str;
            return payRequest;
        }
        return (PayRequest) invokeLLL.objValue;
    }

    private void a(BindFastRequest bindFastRequest, CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, bindFastRequest, bondCard) == null) || bindFastRequest == null) {
            return;
        }
        bindFastRequest.setmBankCard(bondCard.account_no);
        bindFastRequest.mBankNo = bondCard.bank_code;
        bindFastRequest.setChannelNo(bondCard.account_bank_code);
        bindFastRequest.setBankType(bondCard.card_type);
        if (bondCard.card_type == 1) {
            bindFastRequest.setmCvv(bondCard.verify_code);
            bindFastRequest.setValidDateFromServer(bondCard.valid_date);
        }
        bindFastRequest.setmName(bondCard.true_name);
        bindFastRequest.setmPhone(bondCard.mobile);
        bindFastRequest.setSendSmsphone(bondCard.mobile);
        bindFastRequest.setmIdCard(bondCard.certificate_code);
        bindFastRequest.setCertificateType(bondCard.certificate_type);
    }
}
