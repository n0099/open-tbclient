package com.baidu.tieba.wallet.pay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.R;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.wallet.Login;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback;
import d.a.o0.l0.b;
import d.a.o0.l0.f;
import d.a.o0.l0.g;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
/* loaded from: classes4.dex */
public class PayActivityStatic {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_WX_RECHARGE_RESULT_ERROR_CODE = "_wxapi_baseresp_errcode";
    public static final String KEY_WX_RECHARGE_RESULT_ERROR_STR = "_wxapi_baseresp_errstr";
    public static final String YY_GSLB_APP_ID = "b1e5c785-70de-4bd4-8b9e-f3b6ace8f5dc";
    public static final int YY_PAY_APPID = 41;
    public static final int YY_PAY_USE_CHANNEL = 10002;
    public static final int YY_PAY_USE_CHANNEL_YY_LIVE = 30;
    public static BroadcastReceiver broadcastReceiver;
    public static IWechatProxyCallback wxPayCallback;
    public static b yyPayResultCallback;
    public static YYPayUIKit yyPayUIKit;
    public static YYPayUIKit yyPayUIKitYYLive;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-955702171, "Lcom/baidu/tieba/wallet/pay/PayActivityStatic;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-955702171, "Lcom/baidu/tieba/wallet/pay/PayActivityStatic;");
        }
    }

    public PayActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static MiddleRevenueConfig buildMiddleRevenueConfig(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            Context applicationContext = BdBaseApplication.getInst().getApp().getApplicationContext();
            String packageName = applicationContext.getPackageName();
            String p = d.a.o0.r.d0.b.j().p("version_name", "");
            Context context = TbadkCoreApplication.getInst().getContext();
            MiddleReportConfig build = new MiddleReportConfig.MiddleReportConfigBuilder().build();
            build.setAppName(context.getString(R.string.app_name));
            build.setDeviceId(DeviceId.getDeviceID(context));
            build.setReportRatio(1.0f);
            build.setReporter(null);
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            long parseLong = Long.parseLong(currentAccountInfo.getID());
            MiddleRevenueConfig build2 = new MiddleRevenueConfig.MiddleRevenueConfigBuilder().build();
            build2.setAppContext(applicationContext);
            build2.setAppId(41);
            build2.setUseChannel(i2);
            build2.setCurrencyType(4);
            build2.setPackageName(packageName);
            build2.setVersion(p);
            build2.setTestEnv(BdBaseApplication.getInst().isDebugMode());
            build2.setAuthType(6);
            build2.setProtoType(ProtocolType.HTTP);
            build2.setReportConfig(build);
            build2.setGslbAppId(YY_GSLB_APP_ID);
            build2.setUid(parseLong);
            build2.setToken(currentAccountInfo.getBDUSS());
            build2.setTokenCallback(new IToken() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IToken
                public String onUpdateToken() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getCurrentAccountInfo().getBDUSS() : (String) invokeV.objValue;
                }
            });
            build2.setHostId("5");
            return build2;
        }
        return (MiddleRevenueConfig) invokeI.objValue;
    }

    public static void createUIKit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            if (yyPayUIKit == null || yyPayUIKitYYLive == null) {
                yyPayUIKit = YYPayUIKit.getUIKit(41, 10002);
                yyPayUIKitYYLive = YYPayUIKit.getUIKit(41, 30);
            }
        }
    }

    public static void doYYPayTask(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar) == null) || fVar == null) {
            return;
        }
        initYYPaySDK();
        createUIKit();
        yyPayResultCallback = fVar.f52133e;
        Object obj = fVar.f52129a;
        if (!(obj instanceof Activity)) {
            obj = getCurrentActivity();
        }
        IYYPayAmountView.ViewParams viewParams = new IYYPayAmountView.ViewParams();
        if (!TextUtils.isEmpty(fVar.f52131c)) {
            viewParams.payAmountDialogTitle = fVar.f52131c;
        }
        Long l = fVar.f52132d;
        if (l != null) {
            viewParams.targetAmount = l.intValue();
        }
        if (obj != null) {
            if (fVar.f52130b == 0) {
                yyPayUIKit.startPayDialog((Activity) obj, null, null);
            } else {
                yyPayUIKitYYLive.startPayDialog((Activity) obj, viewParams, new IPayCallback() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                    public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, payCallBackBean) == null) || PayActivityStatic.yyPayResultCallback == null) {
                            return;
                        }
                        PayActivityStatic.yyPayResultCallback.onFail(i2, str);
                    }

                    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
                    public void onPayStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }

                    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
                    public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
                        }
                    }

                    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                    public void onSuccess(Object obj2, PayCallBackBean payCallBackBean) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048579, this, obj2, payCallBackBean) == null) || PayActivityStatic.yyPayResultCallback == null) {
                            return;
                        }
                        if (!(obj2 instanceof CurrencyChargeMessage)) {
                            PayActivityStatic.yyPayResultCallback.a(null);
                            return;
                        }
                        g gVar = new g();
                        CurrencyChargeMessage currencyChargeMessage = (CurrencyChargeMessage) obj2;
                        gVar.f52140g = currencyChargeMessage.status;
                        gVar.f52135b = currencyChargeMessage.appid;
                        gVar.f52141h = Long.valueOf(currencyChargeMessage.uid);
                        gVar.f52142i = currencyChargeMessage.usedChannel;
                        gVar.f52137d = currencyChargeMessage.currencyType;
                        gVar.f52134a = Long.valueOf(currencyChargeMessage.amount);
                        gVar.f52136c = Long.valueOf(currencyChargeMessage.currencyAmount);
                        gVar.f52139f = currencyChargeMessage.orderId;
                        gVar.f52138e = currencyChargeMessage.expand;
                        PayActivityStatic.yyPayResultCallback.a(gVar);
                    }
                });
            }
        }
    }

    public static Activity getCurrentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return (Activity) declaredField3.get(obj);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static PayReq getPayReq(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("appid");
            payReq.partnerId = jSONObject.optString("partnerid");
            payReq.prepayId = jSONObject.optString("prepayid");
            payReq.packageValue = jSONObject.optString(AsInstallService.SCHEME_PACKAGE_ADDED);
            payReq.nonceStr = jSONObject.optString("noncestr");
            payReq.timeStamp = jSONObject.optString("timestamp");
            payReq.sign = jSONObject.optString("sign");
            return payReq;
        }
        return (PayReq) invokeL.objValue;
    }

    public static void initBaiduWallet() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && BaiduWalletDelegate.getInstance().getAppContext() == null) {
            BaiduWallet.getInstance().initWallet(new Login(TbadkApplication.getInst().getContext()), TbadkApplication.getInst().getContext(), "tieba");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
            hashMap.put("tpl", "1200020868");
            hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
            BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
            int color = ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            int color2 = ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            int color3 = ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
            int color4 = ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
            Log.e("PayActivityStatic", "ebpay_transparent id:" + color + "   ebpay_transparent:" + color2);
            Log.e("PayActivityStatic", "ebpay_title_bg id:" + color3 + "   ebpay_title_bgColor:" + color4);
            int color5 = com.baidu.fsg.base.utils.ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            int color6 = com.baidu.fsg.base.utils.ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            int color7 = com.baidu.fsg.base.utils.ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
            int color8 = com.baidu.fsg.base.utils.ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
            Log.e("PayActivityStatic", "base_ebpay_transparent id:" + color5 + "   base_ebpay_transparent:" + color6);
            Log.e("PayActivityStatic", "base_ebpay_title_bg id:" + color7 + "   base_ebpay_title_bgColor:" + color8);
        }
    }

    public static void initYYPaySDK() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && needInitYYPaySDk()) {
            MiddleRevenueConfig buildMiddleRevenueConfig = buildMiddleRevenueConfig(10002);
            PayUIKitConfig builder = new PayUIKitConfig.PayUIKitConfigBuilder().setRevenueConfig(buildMiddleRevenueConfig).builder();
            builder.revenueConfig = buildMiddleRevenueConfig;
            YYPayUIKit.createNewKitWithConfigure(41, 10002, builder);
            MiddleRevenueConfig buildMiddleRevenueConfig2 = buildMiddleRevenueConfig(30);
            PayUIKitConfig builder2 = new PayUIKitConfig.PayUIKitConfigBuilder().setRevenueConfig(buildMiddleRevenueConfig2).builder();
            builder2.revenueConfig = buildMiddleRevenueConfig2;
            YYPayUIKit.createNewKitWithConfigure(41, 30, builder2);
        }
    }

    public static boolean isAccountChange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? yyPayUIKit.getPayUIKitConfig().revenueConfig.getUid() != Long.parseLong(TbadkCoreApplication.getCurrentAccountInfo().getID()) : invokeV.booleanValue;
    }

    public static boolean needInitYYPaySDk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (yyPayUIKit != null) {
                if (!isAccountChange()) {
                    return false;
                }
                yyPayUIKit.destroy();
                yyPayUIKit = null;
                yyPayUIKitYYLive.destroy();
                yyPayUIKitYYLive = null;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void onWxPayResult(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, map) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
            IWechatProxyCallback iWechatProxyCallback = wxPayCallback;
            if (iWechatProxyCallback != null) {
                iWechatProxyCallback.onSuccess(hashMap);
            }
        }
    }

    public static void registerYYPayUIKitProxy(String str, IWechatProxyCallback iWechatProxyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, iWechatProxyCallback) == null) {
            wxPayCallback = iWechatProxyCallback;
            wxRecharge(str);
        }
    }

    public static void wxRecharge(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            try {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
                PayReq payReq = getPayReq(new JSONObject(str));
                createWXAPI.registerApp(payReq.appId);
                if (!createWXAPI.sendReq(payReq)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(KEY_WX_RECHARGE_RESULT_ERROR_CODE, 6);
                    hashMap.put(KEY_WX_RECHARGE_RESULT_ERROR_STR, "wx_start_failed");
                    onWxPayResult(hashMap);
                }
                if (broadcastReceiver != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(broadcastReceiver);
                }
                broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(intent.getExtras().getInt("errorCode", -1)));
                            hashMap2.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, intent.getExtras().getString("errorMsg", ""));
                            PayActivityStatic.onWxPayResult(hashMap2);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception unused) {
            }
        }
    }
}
