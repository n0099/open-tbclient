package com.baidu.wallet.fastpay.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.ResultPageStateListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.fastpay.FastPayCallBackManager;
import com.baidu.wallet.fastpay.beans.FastPayBeanFactory;
import com.baidu.wallet.fastpay.beans.d;
import com.baidu.wallet.fastpay.datamodel.GetOrderResponse;
import com.baidu.wallet.fastpay.datamodel.SimpleOrderInfo;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.ui.WalletMobileResultActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak", "UseSparseArrays", "StaticFieldLeak"})
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f24723a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, b> f24724b;

    /* renamed from: c  reason: collision with root package name */
    public String f24725c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24726d;

    /* loaded from: classes6.dex */
    public interface b {
        void onFastPayFail(int i2, int i3, C0263a c0263a);

        void onFastPaySuccess(int i2, int i3, Object obj);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f24748a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1548098683, "Lcom/baidu/wallet/fastpay/sdk/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1548098683, "Lcom/baidu/wallet/fastpay/sdk/a$c;");
                    return;
                }
            }
            f24748a = new a();
        }
    }

    public void b(int i2) {
        Map<Integer, b> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (map = this.f24724b) == null || map.size() <= 0) {
            return;
        }
        this.f24724b.remove(Integer.valueOf(i2));
    }

    public a() {
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
        this.f24726d = "0";
        this.f24724b = new HashMap();
    }

    /* renamed from: com.baidu.wallet.fastpay.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0263a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f24745a;

        /* renamed from: b  reason: collision with root package name */
        public String f24746b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleOrderInfo f24747c;

        public C0263a() {
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
            this.f24746b = "";
            this.f24747c = null;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C0263a(int i2, String str) {
            this();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    this();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f24745a = i2;
            this.f24746b = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C0263a(int i2, String str, SimpleOrderInfo simpleOrderInfo) {
            this(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, simpleOrderInfo};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f24747c = simpleOrderInfo;
        }
    }

    public b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Map<Integer, b> map = this.f24724b;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return this.f24724b.get(Integer.valueOf(i2));
        }
        return (b) invokeI.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f24748a : (a) invokeV.objValue;
    }

    public void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            this.f24723a = context.getApplicationContext();
            this.f24725c = "BaiduWallet_APP_common_charge";
        }
    }

    public void a(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            a(context, i2);
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? Pattern.compile("^1[0-9]{10}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public void a(d dVar, int i2, String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, dVar, i2, str, bVar) == null) {
            LogUtil.d("BaiduFastPay", "getChargeCards. mobile = " + str);
            this.f24724b.put(Integer.valueOf(i2), bVar);
            if (!a(str)) {
                LogUtil.d("BaiduFastPay", "getChargeCards. wrong mobile number.");
                FastPayCallBackManager.a(i2, 0, StatusCode.ERROR_CODE_LOCAL, ResUtils.getString(this.f24723a, "wallet_fp_wrong_number"), null);
                return;
            }
            dVar.a(str, this.f24725c);
            dVar.setResponseCallback(new IBeanResponseCallback(this, i2) { // from class: com.baidu.wallet.fastpay.sdk.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f24727a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f24728b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24728b = this;
                    this.f24727a = i2;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i3, int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i3, i4, str2) == null) {
                        if (45313 == i3 && i4 == -4) {
                            str2 = ResUtils.getString(this.f24728b.f24723a, "wallet_fp_no_faces");
                        }
                        FastPayCallBackManager.a(this.f24727a, 0, i4, str2, null);
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i3, Object obj, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, obj, str2) == null) {
                        FastPayCallBackManager.a(this.f24727a, obj);
                    }
                }
            });
            dVar.execBean();
        }
    }

    public void a(int i2, Map<String, String> map, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, map, bVar) == null) {
            this.f24724b.put(Integer.valueOf(i2), bVar);
            String str = map.get("key_mobile");
            if (!a(str)) {
                LogUtil.d("BaiduFastPay", "toCharge. wrong mobile number.");
                FastPayCallBackManager.a(i2, 0, StatusCode.ERROR_CODE_LOCAL, ResUtils.getString(this.f24723a, "wallet_fp_wrong_number"), null);
                return;
            }
            WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(this.f24723a, new ILoginBackListener(this, i2, map, str, bVar) { // from class: com.baidu.wallet.fastpay.sdk.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f24729a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Map f24730b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f24731c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f24732d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f24733e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), map, str, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24733e = this;
                    this.f24729a = i2;
                    this.f24730b = map;
                    this.f24731c = str;
                    this.f24732d = bVar;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str2) == null) {
                        FastPayCallBackManager.a(this.f24729a, 0, -5, ResUtils.getString(this.f24733e.f24723a, "fp_not_login"), null);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str2) == null) {
                        this.f24733e.a(this.f24729a, (String) this.f24730b.get("param_key_face_value"), this.f24731c, (String) this.f24730b.get(com.baidu.wallet.api.Constants.USER_TYPE_KEY), (String) this.f24730b.get(com.baidu.wallet.api.Constants.TOKEN_VALUE_KEY), this.f24732d);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, String str3, String str4, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, bVar}) == null) {
            com.baidu.wallet.fastpay.beans.b bVar2 = (com.baidu.wallet.fastpay.beans.b) FastPayBeanFactory.getInstance().getBean(this.f24723a, FastPayBeanFactory.BEAN_ID_GET_ORDER, "BaiduFastPay");
            bVar2.a(str2, str, "0", this.f24725c);
            bVar2.setResponseCallback(new IBeanResponseCallback(this, str, str2, i2, str3, str4) { // from class: com.baidu.wallet.fastpay.sdk.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f24734a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f24735b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f24736c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f24737d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f24738e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f24739f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Integer.valueOf(i2), str3, str4};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24739f = this;
                    this.f24734a = str;
                    this.f24735b = str2;
                    this.f24736c = i2;
                    this.f24737d = str3;
                    this.f24738e = str4;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i3, int i4, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i3, i4, str5) == null) {
                        FastPayCallBackManager.a(this.f24736c, 0, i4, str5, null);
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i3, Object obj, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, obj, str5) == null) {
                        GetOrderResponse getOrderResponse = (GetOrderResponse) obj;
                        SimpleOrderInfo simpleOrderInfo = new SimpleOrderInfo();
                        simpleOrderInfo.mFaceValue = this.f24734a;
                        simpleOrderInfo.mMobile = this.f24735b;
                        simpleOrderInfo.mOrderNo = getOrderResponse.order_no;
                        simpleOrderInfo.mOrderInfo = getOrderResponse.url;
                        simpleOrderInfo.mPayDesc = getOrderResponse.pay_desc;
                        simpleOrderInfo.mSpSuccpageRemainTime = getOrderResponse.redirect_sp_succpage_remain_time;
                        simpleOrderInfo.init();
                        this.f24739f.a(this.f24736c, simpleOrderInfo, this.f24737d, this.f24738e);
                        FastPayCallBackManager.a(this.f24736c, obj);
                    }
                }
            });
            bVar2.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, SimpleOrderInfo simpleOrderInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{Integer.valueOf(i2), simpleOrderInfo, str, str2}) == null) {
            if (simpleOrderInfo != null && !TextUtils.isEmpty(simpleOrderInfo.mOrderInfo)) {
                LogUtil.d("BaiduFastPay", "handleGetOrderInfoSuccess.");
                HashMap hashMap = new HashMap();
                hashMap.put("pay_from", BaiduPay.PAY_FROM_HUA_FEI);
                LogUtil.d("handleGetOrderInfoSuccess. token type = " + str + ", token = " + str2);
                BaiduPay.getInstance().doPay(this.f24723a, simpleOrderInfo.mOrderInfo, new PayCallBack(this, simpleOrderInfo, i2) { // from class: com.baidu.wallet.fastpay.sdk.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SimpleOrderInfo f24740a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f24741b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f24742c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, simpleOrderInfo, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f24742c = this;
                        this.f24740a = simpleOrderInfo;
                        this.f24741b = i2;
                    }

                    @Override // com.baidu.android.pay.PayCallBack
                    public boolean isHideLoadingDialog() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return false;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // com.baidu.android.pay.PayCallBack
                    public void onPayResult(int i3, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str3) == null) {
                            if (i3 != 0 && i3 != 1) {
                                FastPayCallBackManager.a(this.f24741b, 1, i3, "", this.f24740a);
                                return;
                            }
                            SimpleOrderInfo simpleOrderInfo2 = this.f24740a;
                            if (simpleOrderInfo2 != null && !TextUtils.isEmpty(simpleOrderInfo2.mOrderNo) && this.f24740a.isGotoResultActivity()) {
                                Context context = this.f24742c.f24723a;
                                SimpleOrderInfo simpleOrderInfo3 = this.f24740a;
                                WalletMobileResultActivity.gotoBusniessResultPage(context, true, simpleOrderInfo3.mOrderNo, simpleOrderInfo3.mPayDesc, i3 == 1, new ResultPageStateListener(this, i3) { // from class: com.baidu.wallet.fastpay.sdk.a.4.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ int f24743a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass4 f24744b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i3)};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f24744b = this;
                                        this.f24743a = i3;
                                    }

                                    @Override // com.baidu.wallet.api.ResultPageStateListener
                                    public void onConfirm() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            FastPayCallBackManager.PayStateContent payStateContent = new FastPayCallBackManager.PayStateContent();
                                            AnonymousClass4 anonymousClass4 = this.f24744b;
                                            SimpleOrderInfo simpleOrderInfo4 = anonymousClass4.f24740a;
                                            payStateContent.order_no = simpleOrderInfo4.mOrderNo;
                                            FastPayCallBackManager.a(anonymousClass4.f24741b, this.f24743a, simpleOrderInfo4, payStateContent);
                                        }
                                    }
                                });
                                return;
                            }
                            FastPayCallBackManager.PayStateContent payStateContent = new FastPayCallBackManager.PayStateContent();
                            SimpleOrderInfo simpleOrderInfo4 = this.f24740a;
                            payStateContent.order_no = simpleOrderInfo4.mOrderNo;
                            FastPayCallBackManager.a(this.f24741b, i3, simpleOrderInfo4, payStateContent);
                        }
                    }
                }, hashMap);
                return;
            }
            FastPayCallBackManager.a(i2, 1, -10, ResUtils.getString(this.f24723a, "fp_pay_cancel"), simpleOrderInfo);
        }
    }
}
