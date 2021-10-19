package com.baidu.wallet.fastpay.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
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
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.fastpay.FastPayCallBackManager;
import com.baidu.wallet.fastpay.beans.FastPayBeanFactory;
import com.baidu.wallet.fastpay.beans.e;
import com.baidu.wallet.fastpay.datamodel.GetOrderResponse;
import com.baidu.wallet.fastpay.datamodel.SimpleOrderInfo;
import com.baidu.wallet.fastpay.ui.WalletMobileResultActivity;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak", "UseSparseArrays", "StaticFieldLeak"})
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f61228a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, b> f61229b;

    /* renamed from: c  reason: collision with root package name */
    public String f61230c;

    /* renamed from: d  reason: collision with root package name */
    public final String f61231d;

    /* loaded from: classes8.dex */
    public interface b {
        void onFastPayFail(int i2, int i3, C1829a c1829a);

        void onFastPaySuccess(int i2, int i3, Object obj);
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f61255a;
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
            f61255a = new a();
        }
    }

    public void b(int i2) {
        Map<Integer, b> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (map = this.f61229b) == null || map.size() <= 0) {
            return;
        }
        this.f61229b.remove(Integer.valueOf(i2));
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
        this.f61231d = "0";
        this.f61229b = new HashMap();
    }

    /* renamed from: com.baidu.wallet.fastpay.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1829a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f61252a;

        /* renamed from: b  reason: collision with root package name */
        public String f61253b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleOrderInfo f61254c;

        public C1829a() {
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
            this.f61253b = "";
            this.f61254c = null;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1829a(int i2, String str) {
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
            this.f61252a = i2;
            this.f61253b = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1829a(int i2, String str, SimpleOrderInfo simpleOrderInfo) {
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
            this.f61254c = simpleOrderInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            try {
                return new BigDecimal(str).divide(new BigDecimal(100), 6).toPlainString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Map<Integer, b> map = this.f61229b;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return this.f61229b.get(Integer.valueOf(i2));
        }
        return (b) invokeI.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f61255a : (a) invokeV.objValue;
    }

    public void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            this.f61228a = DxmApplicationContextImpl.getApplicationContext(context);
            this.f61230c = "BaiduWallet_APP_common_charge";
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

    public void a(e eVar, int i2, String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, eVar, i2, str, bVar) == null) {
            LogUtil.d("BaiduFastPay", "getChargeCards. mobile = " + str);
            this.f61229b.put(Integer.valueOf(i2), bVar);
            if (!a(str)) {
                LogUtil.d("BaiduFastPay", "getChargeCards. wrong mobile number.");
                FastPayCallBackManager.a(i2, 0, -57353, ResUtils.getString(this.f61228a, "wallet_fp_wrong_number"), null);
                return;
            }
            eVar.a(str, this.f61230c);
            eVar.setResponseCallback(new IBeanResponseCallback(this, i2) { // from class: com.baidu.wallet.fastpay.sdk.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f61232a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61233b;

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
                    this.f61233b = this;
                    this.f61232a = i2;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i3, int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i3, i4, str2) == null) {
                        if (45313 == i3 && i4 == -4) {
                            str2 = ResUtils.getString(this.f61233b.f61228a, "wallet_fp_no_faces");
                        }
                        FastPayCallBackManager.a(this.f61232a, 0, i4, str2, null);
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i3, Object obj, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, obj, str2) == null) {
                        FastPayCallBackManager.a(this.f61232a, obj);
                    }
                }
            });
            eVar.execBean();
        }
    }

    public void a(int i2, Map<String, String> map, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, map, bVar) == null) {
            this.f61229b.put(Integer.valueOf(i2), bVar);
            String str = map.get("key_mobile");
            if (!a(str)) {
                LogUtil.d("BaiduFastPay", "toCharge. wrong mobile number.");
                FastPayCallBackManager.a(i2, 0, -57353, ResUtils.getString(this.f61228a, "wallet_fp_wrong_number"), null);
                return;
            }
            WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(this.f61228a, new ILoginBackListener(this, i2, map, str, bVar) { // from class: com.baidu.wallet.fastpay.sdk.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f61234a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Map f61235b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f61236c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f61237d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f61238e;

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
                    this.f61238e = this;
                    this.f61234a = i2;
                    this.f61235b = map;
                    this.f61236c = str;
                    this.f61237d = bVar;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str2) == null) {
                        FastPayCallBackManager.a(this.f61234a, 0, -5, ResUtils.getString(this.f61238e.f61228a, "fp_not_login"), null);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str2) == null) {
                        this.f61238e.a(this.f61234a, (String) this.f61235b.get("param_key_face_value"), this.f61236c, (String) this.f61235b.get("userType"), "", this.f61237d);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, String str3, String str4, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, bVar}) == null) {
            com.baidu.wallet.fastpay.beans.c cVar = (com.baidu.wallet.fastpay.beans.c) FastPayBeanFactory.getInstance().getBean(this.f61228a, FastPayBeanFactory.BEAN_ID_GET_ORDER, "BaiduFastPay");
            cVar.a(str2, str, "0", this.f61230c);
            cVar.setResponseCallback(new IBeanResponseCallback(this, str, str2, i2, str3, str4) { // from class: com.baidu.wallet.fastpay.sdk.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61239a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61240b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f61241c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f61242d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f61243e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f61244f;

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
                    this.f61244f = this;
                    this.f61239a = str;
                    this.f61240b = str2;
                    this.f61241c = i2;
                    this.f61242d = str3;
                    this.f61243e = str4;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i3, int i4, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i3, i4, str5) == null) {
                        FastPayCallBackManager.a(this.f61241c, 0, i4, str5, null);
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i3, Object obj, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, obj, str5) == null) {
                        GetOrderResponse getOrderResponse = (GetOrderResponse) obj;
                        SimpleOrderInfo simpleOrderInfo = new SimpleOrderInfo();
                        simpleOrderInfo.mFaceValue = this.f61239a;
                        simpleOrderInfo.mMobile = this.f61240b;
                        simpleOrderInfo.mOrderNo = getOrderResponse.order_no;
                        simpleOrderInfo.mOrderInfo = getOrderResponse.url;
                        simpleOrderInfo.mPayDesc = getOrderResponse.pay_desc;
                        simpleOrderInfo.mSpSuccpageRemainTime = getOrderResponse.redirect_sp_succpage_remain_time;
                        simpleOrderInfo.init();
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, simpleOrderInfo) { // from class: com.baidu.wallet.fastpay.sdk.a.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ SimpleOrderInfo f61245a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f61246b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, simpleOrderInfo};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61246b = this;
                                this.f61245a = simpleOrderInfo;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass3 anonymousClass3 = this.f61246b;
                                    anonymousClass3.f61244f.a(anonymousClass3.f61241c, this.f61245a, anonymousClass3.f61242d, anonymousClass3.f61243e);
                                }
                            }
                        });
                        FastPayCallBackManager.a(this.f61241c, obj);
                    }
                }
            });
            cVar.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, SimpleOrderInfo simpleOrderInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), simpleOrderInfo, str, str2}) == null) {
            if (simpleOrderInfo != null && !TextUtils.isEmpty(simpleOrderInfo.mOrderInfo)) {
                LogUtil.d("BaiduFastPay", "handleGetOrderInfoSuccess.");
                HashMap hashMap = new HashMap();
                hashMap.put("pay_from", BaiduPay.PAY_FROM_HUA_FEI);
                ArrayList arrayList = new ArrayList(Arrays.asList(b(simpleOrderInfo.mFaceValue)));
                arrayList.addAll(com.baidu.wallet.fastpay.a.a.a().b());
                DXMSdkSAUtils.onEventWithValues("mobileRechargeCreateOrder", arrayList);
                LocalRouter.getInstance(this.f61228a).route(this.f61228a, new RouterRequest().provider("dxmPay").action("enterDoPayWithParams").data("orderInfo", simpleOrderInfo.mOrderInfo).data("showDialog", Boolean.TRUE).data("params", hashMap), new RouterCallback(this, simpleOrderInfo, i2) { // from class: com.baidu.wallet.fastpay.sdk.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SimpleOrderInfo f61247a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f61248b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f61249c;

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
                        this.f61249c = this;
                        this.f61247a = simpleOrderInfo;
                        this.f61248b = i2;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap2) == null) {
                            if (i3 == 0) {
                                if (hashMap2 == null || hashMap2.size() <= 0) {
                                    return;
                                }
                                int intValue = ((Integer) hashMap2.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                                String str3 = (String) hashMap2.get("payDesc");
                                if (intValue != 0 && intValue != 1) {
                                    FastPayCallBackManager.a(this.f61248b, 1, intValue, "", this.f61247a);
                                    return;
                                }
                                ArrayList arrayList2 = new ArrayList(Arrays.asList(this.f61249c.b(this.f61247a.mFaceValue)));
                                arrayList2.addAll(com.baidu.wallet.fastpay.a.a.a().b());
                                DXMSdkSAUtils.onEventWithValues("mobileRechargePaySuccess", arrayList2);
                                SimpleOrderInfo simpleOrderInfo2 = this.f61247a;
                                if (simpleOrderInfo2 != null && !TextUtils.isEmpty(simpleOrderInfo2.mOrderNo) && this.f61247a.isGotoResultActivity()) {
                                    Context context = this.f61249c.f61228a;
                                    SimpleOrderInfo simpleOrderInfo3 = this.f61247a;
                                    WalletMobileResultActivity.gotoBusniessResultPage(context, true, simpleOrderInfo3.mOrderNo, simpleOrderInfo3.mPayDesc, intValue == 1, new ResultPageStateListener(this, intValue) { // from class: com.baidu.wallet.fastpay.sdk.a.4.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ int f61250a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass4 f61251b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, Integer.valueOf(intValue)};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f61251b = this;
                                            this.f61250a = intValue;
                                        }

                                        @Override // com.baidu.wallet.api.ResultPageStateListener
                                        public void onConfirm() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                FastPayCallBackManager.PayStateContent payStateContent = new FastPayCallBackManager.PayStateContent();
                                                AnonymousClass4 anonymousClass4 = this.f61251b;
                                                SimpleOrderInfo simpleOrderInfo4 = anonymousClass4.f61247a;
                                                payStateContent.order_no = simpleOrderInfo4.mOrderNo;
                                                FastPayCallBackManager.a(anonymousClass4.f61248b, this.f61250a, simpleOrderInfo4, payStateContent);
                                            }
                                        }
                                    });
                                    return;
                                }
                                FastPayCallBackManager.PayStateContent payStateContent = new FastPayCallBackManager.PayStateContent();
                                SimpleOrderInfo simpleOrderInfo4 = this.f61247a;
                                payStateContent.order_no = simpleOrderInfo4.mOrderNo;
                                FastPayCallBackManager.a(this.f61248b, intValue, simpleOrderInfo4, payStateContent);
                                return;
                            }
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("provider", "dxmPay");
                            hashMap3.put("action", "enterDoPayWithParams");
                            hashMap3.put("errMsg", (String) hashMap2.get("errorMsg"));
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i3, hashMap3.values());
                        }
                    }
                });
                return;
            }
            FastPayCallBackManager.a(i2, 1, -10, ResUtils.getString(this.f61228a, "fp_pay_cancel"), simpleOrderInfo);
        }
    }
}
