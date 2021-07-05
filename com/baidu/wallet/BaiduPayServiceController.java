package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.PwdManagerActivity;
import com.baidu.wallet.paysdk.ui.SecurityCenterActivity;
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BaiduPayServiceController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ILightappInvokerCallback f23621a;

    /* renamed from: b  reason: collision with root package name */
    public LoginBackListenerProxy f23622b;

    /* renamed from: com.baidu.wallet.BaiduPayServiceController$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f23626a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f23627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BaiduPayServiceController f23629d;

        public AnonymousClass2(BaiduPayServiceController baiduPayServiceController, Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduPayServiceController, context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23629d = baiduPayServiceController;
            this.f23627b = context;
            this.f23628c = z;
            this.f23626a = new Handler(this.f23627b.getMainLooper());
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                WalletGlobalUtils.DismissLoadingDialog();
                if (i3 == 100035 || i3 == 100036) {
                    PassUtil.passNormalized(this.f23627b, str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.BaiduPayServiceController.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f23632a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f23632a = this;
                        }

                        @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                        public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                            InterceptResult invokeLIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                                if (super.onNormalize(context, i4, map)) {
                                    this.f23632a.f23626a.post(new Runnable(this, context) { // from class: com.baidu.wallet.BaiduPayServiceController.2.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ Context f23633a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ C02542 f23634b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, context};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i5 = newInitContext.flag;
                                                if ((i5 & 1) != 0) {
                                                    int i6 = i5 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f23634b = this;
                                            this.f23633a = context;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f23634b.f23632a.f23629d.a(this.f23633a);
                                            }
                                        }
                                    });
                                    return false;
                                }
                                return false;
                            }
                            return invokeLIL.booleanValue;
                        }
                    });
                }
            }
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            UserData.UserModel userModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                WalletGlobalUtils.DismissLoadingDialog();
                DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
                if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null && userModel.hasMobilePwd()) {
                    Intent intent = new Intent(this.f23627b, PwdManagerActivity.class);
                    if (!(this.f23627b instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    intent.putExtra("with_anim", this.f23628c);
                    this.f23627b.startActivity(intent);
                    Context context = this.f23627b;
                    if (context instanceof Activity) {
                        if (this.f23628c) {
                            BaiduWalletUtils.startActivityAnim(context);
                            return;
                        } else {
                            BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                            return;
                        }
                    }
                    return;
                }
                PasswordController.getPassWordInstance().setPasswdByUser(this.f23627b, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.BaiduPayServiceController.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f23630a;

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
                        this.f23630a = this;
                    }

                    @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                    public void onChangeFailed(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                    public void onChangeSucceed(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                            this.f23630a.f23626a.post(new Runnable(this) { // from class: com.baidu.wallet.BaiduPayServiceController.2.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f23631a;

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
                                    this.f23631a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass2 anonymousClass2 = this.f23631a.f23630a;
                                        anonymousClass2.f23629d.a(anonymousClass2.f23627b);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BaiduPayServiceController f23639a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(4006434, "Lcom/baidu/wallet/BaiduPayServiceController$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(4006434, "Lcom/baidu/wallet/BaiduPayServiceController$a;");
                    return;
                }
            }
            f23639a = new BaiduPayServiceController();
        }
    }

    private void c(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65552, this, context, z) == null) || context == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        this.f23622b = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, z) { // from class: com.baidu.wallet.BaiduPayServiceController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f23623a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f23624b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BaiduPayServiceController f23625c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23625c = this;
                this.f23623a = context;
                this.f23624b = z;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(this.f23625c.f23622b);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    this.f23625c.d(this.f23623a, this.f23624b);
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.f23622b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65553, this, context, z) == null) {
            WalletGlobalUtils.showLoadingDialog(context);
            UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean(context, 6, "BaiduPayServiceController");
            userInfoBean.setResponseCallback(e(context, z));
            userInfoBean.execBean();
        }
    }

    private IBeanResponseCallback e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65554, this, context, z)) == null) ? new AnonymousClass2(this, context, z) : (IBeanResponseCallback) invokeLZ.objValue;
    }

    private void f(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65555, this, context, z) == null) {
            this.f23622b = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, z) { // from class: com.baidu.wallet.BaiduPayServiceController.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23635a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f23636b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayServiceController f23637c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23637c = this;
                    this.f23635a = context;
                    this.f23636b = z;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f23637c.f23622b);
                        } else {
                            this.f23637c.g(this.f23635a, this.f23636b);
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f23637c.g(this.f23635a, this.f23636b);
                    }
                }
            });
            WalletLoginHelper.getInstance().verifyPassLogin(this.f23622b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, this, context, z) == null) {
            Intent intent = new Intent(context, SecurityCenterActivity.class);
            boolean z2 = context instanceof Activity;
            if (z2) {
                LogUtil.d("BaiduPayServiceController", "context is activity!");
            } else {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("with_anim", z);
            context.startActivity(intent);
            if (z2) {
                if (z) {
                    BaiduWalletUtils.startActivityAnim(context);
                } else {
                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                }
            }
        }
    }

    public static BaiduPayServiceController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? a.f23639a : (BaiduPayServiceController) invokeV.objValue;
    }

    public void doScanCode(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            doScanCode(context, false, null, null);
        }
    }

    public void gotoWalletService(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) {
            gotoWalletService(context, str, str2, true);
        }
    }

    public BaiduPayServiceController() {
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
        this.f23621a = null;
    }

    public void doScanCode(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            doScanCode(context, z, null, str);
        }
    }

    public void gotoWalletService(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), str}) == null) {
            gotoWalletService(context, j, str, true);
        }
    }

    private void b(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65549, this, context, str, z) == null) {
            String transactionRecordsUrl = SdkInitResponse.getInstance().getTransactionRecordsUrl(context);
            if (TextUtils.isEmpty(transactionRecordsUrl)) {
                transactionRecordsUrl = BeanConstants.TRANSACTION_RECORDS_URL;
            }
            StringBuilder sb = new StringBuilder(transactionRecordsUrl);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int i2 = new JSONObject(str).getInt(com.baidu.wallet.api.Constants.ORDERTYPE_FLAG);
                    sb.append("?");
                    sb.append(com.baidu.wallet.api.Constants.ORDERTYPE_FLAG);
                    sb.append("=");
                    sb.append(i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, sb.toString(), false);
        }
    }

    public void doScanCode(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            String payCodeUrl = SdkInitResponse.getInstance().getPayCodeUrl(context);
            if (TextUtils.isEmpty(payCodeUrl)) {
                payCodeUrl = BeanConstants.API_WALLET_SCANCODE;
            }
            BaiduWalletDelegate.getInstance().openH5Module(context, payCodeUrl, false);
        }
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, context, str, str2, iLightappInvokerCallback) == null) || iLightappInvokerCallback == null) {
            return;
        }
        this.f23621a = iLightappInvokerCallback;
        gotoWalletService(context, str, str2, true);
    }

    private void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, this, context, str, z) == null) {
            String balanceHomeUrl = SdkInitResponse.getInstance().getBalanceHomeUrl(context);
            if (TextUtils.isEmpty(balanceHomeUrl)) {
                balanceHomeUrl = BeanConstants.API_WALLET_BALANCE_HOME_PATH;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    StringBuilder sb = new StringBuilder(balanceHomeUrl);
                    sb.append("?");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        sb.append(next);
                        sb.append("=");
                        sb.append(optString);
                        sb.append("&");
                    }
                    if (sb.length() > 0) {
                        balanceHomeUrl = sb.substring(0, sb.length() - 1);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
            baiduWalletDelegate.openH5Module(context, balanceHomeUrl + "#", "", z, false);
        }
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            gotoWalletService(context, Long.parseLong(str), str2, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), str, Boolean.valueOf(z)}) == null) || context == null || j < 0) {
            return;
        }
        if (j == 4) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_MYBANKINFO);
            a(context, z, str);
        } else if (j == 16) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_TRANSRECORD);
            b(context, str, z);
        } else if (j == 8) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_SECURITYCENTER);
            f(context, z);
        } else if (j == 128) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_O2OPARSER);
            a(context, str);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_PAYSET);
            a(context, z);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_PWDSET);
            b(context, z);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK) {
            b(context, str);
        } else if (j == 512) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_SCANQRCODE);
            doScanCode(context, false, str);
        } else if (j == 32) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_BALANCEINFO);
            a(context, str, z);
        } else if (j == 8192) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_CASHBACK);
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_service_offline_tips"));
        } else {
            GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_not_include_tips"));
        }
    }

    private void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, this, context, z) == null) {
            c(context, z);
        }
    }

    private void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, context, str) == null) {
            BaiduPayDelegate.getInstance().checkPwdFromH5(context, str, new CheckCallBack(this) { // from class: com.baidu.wallet.BaiduPayServiceController.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduPayServiceController f23638a;

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
                    this.f23638a = this;
                }

                @Override // com.baidu.wallet.api.CheckCallBack
                public void onCheckResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) || this.f23638a.f23621a == null) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("{\"result\":");
                    sb.append(i2 == 0 ? 0 : 1);
                    sb.append(",\"cnt\":{");
                    if (i2 == 0) {
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("\"content\":\"");
                            sb.append(str2);
                            sb.append("\"");
                        }
                        sb.append("}}");
                    } else {
                        sb.append("\"errCode\":");
                        sb.append(i2);
                        sb.append(",\"des\":\"");
                        sb.append(str2);
                        sb.append("\"}}");
                    }
                    this.f23638a.f23621a.onResult(i2 != 0 ? 1 : 0, sb.toString());
                    this.f23638a.f23621a = null;
                }
            });
        }
    }

    private void a(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            Intent intent = new Intent();
            intent.setClass(context, BankCardListActivity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(com.baidu.wallet.api.Constants.BDL_KEY_BANKINFO_EXTRA, str);
            }
            BaiduWalletServiceController.loginFirst(context, intent, z);
        }
    }

    private void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, context, z) == null) {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
                return;
            }
            Intent intent = new Intent(context, PaySettingActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            BaiduWalletServiceController.loginFirst(context, intent, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, context) == null) {
            c(context, true);
        }
    }

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, context, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    str = URLEncoder.encode(str, "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                BaiduWalletUtils.invokeHostLightapp(context, str);
                return;
            }
            GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_o2o_error"));
        }
    }
}
