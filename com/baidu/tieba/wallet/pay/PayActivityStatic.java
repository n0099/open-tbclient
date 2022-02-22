package com.baidu.tieba.wallet.pay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.r0.a;
import c.a.t0.r0.c;
import c.a.t0.r0.g;
import c.a.t0.r0.h;
import c.a.t0.s.j0.b;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.R;
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
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes13.dex */
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
    public static c yyPayResultCallback;
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
            String q = b.k().q("version_name", "");
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
            build2.setVersion(q);
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
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            if (yyPayUIKit == null || yyPayUIKitYYLive == null) {
                yyPayUIKit = YYPayUIKit.getUIKit(41, 10002);
                yyPayUIKitYYLive = YYPayUIKit.getUIKit(41, 30);
            }
        }
    }

    public static void destoryYyPayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, cVar) == null) && cVar == yyPayResultCallback) {
            yyPayResultCallback = null;
        }
    }

    public static void doYYPayTask(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, gVar) == null) || gVar == null) {
            return;
        }
        initYYPaySDK();
        createUIKit();
        yyPayResultCallback = gVar.f13386e;
        Object obj = gVar.a;
        if (!(obj instanceof Activity)) {
            obj = getCurrentActivity();
        }
        IYYPayAmountView.ViewParams viewParams = new IYYPayAmountView.ViewParams();
        viewParams.closeOnSuccess = gVar.f13388g;
        if (!TextUtils.isEmpty(gVar.f13384c)) {
            viewParams.payAmountDialogTitle = gVar.f13384c;
        }
        Long l = gVar.f13385d;
        if (l != null) {
            int intValue = l.intValue();
            viewParams.targetAmount = intValue;
            if (intValue > 0) {
                int i2 = gVar.f13387f;
                if (i2 == 1) {
                    viewParams.payScene = PayScene.DIALOG_PAY_SCENE;
                } else if (i2 != 3) {
                    viewParams.payScene = PayScene.DIALOG_QUICK_PAY;
                } else {
                    viewParams.payScene = PayScene.DIALOG_TARGET_PAY;
                }
            }
        }
        c cVar = yyPayResultCallback;
        if (cVar instanceof a) {
            viewParams.viewEventListener = new AbsViewEventHandler((a) cVar) { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a val$absPayAllResult;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$absPayAllResult = r6;
                }

                @Override // tv.athena.revenue.payui.view.AbsViewEventHandler, tv.athena.revenue.payui.view.IViewEventListener
                public void onViewStateChange(PayDialogType payDialogType) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, payDialogType) == null) || payDialogType == null) {
                        return;
                    }
                    this.val$absPayAllResult.b((byte) payDialogType.ordinal());
                }
            };
        }
        if (obj != null) {
            IPayCallback<CurrencyChargeMessage> iPayCallback = new IPayCallback() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.4
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

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onFail(int i3, String str, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str, payCallBackBean) == null) || PayActivityStatic.yyPayResultCallback == null) {
                        return;
                    }
                    PayActivityStatic.yyPayResultCallback.onFail(i3, str);
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
                    h hVar = new h();
                    CurrencyChargeMessage currencyChargeMessage = (CurrencyChargeMessage) obj2;
                    hVar.f13394g = currencyChargeMessage.status;
                    hVar.f13389b = currencyChargeMessage.appid;
                    hVar.f13395h = Long.valueOf(currencyChargeMessage.uid);
                    hVar.f13396i = currencyChargeMessage.usedChannel;
                    hVar.f13391d = currencyChargeMessage.currencyType;
                    hVar.a = Long.valueOf(currencyChargeMessage.amount);
                    hVar.f13390c = Long.valueOf(currencyChargeMessage.currencyAmount);
                    hVar.f13393f = currencyChargeMessage.orderId;
                    hVar.f13392e = currencyChargeMessage.expand;
                    PayActivityStatic.yyPayResultCallback.a(hVar);
                }
            };
            if (gVar.f13383b == 0) {
                yyPayUIKit.startPayDialog((Activity) obj, viewParams, iPayCallback);
            } else {
                yyPayUIKitYYLive.startPayDialog((Activity) obj, viewParams, iPayCallback);
            }
        }
    }

    public static Activity getCurrentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("appid");
            payReq.partnerId = jSONObject.optString("partnerid");
            payReq.prepayId = jSONObject.optString("prepayid");
            payReq.packageValue = jSONObject.optString("package");
            payReq.nonceStr = jSONObject.optString("noncestr");
            payReq.timeStamp = jSONObject.optString("timestamp");
            payReq.sign = jSONObject.optString("sign");
            return payReq;
        }
        return (PayReq) invokeL.objValue;
    }

    public static void initBaiduWallet() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && BaiduWalletDelegate.getInstance().getAppContext() == null) {
            BaiduWallet.getInstance().initWallet(new Login(TbadkApplication.getInst().getContext()), TbadkApplication.getInst().getContext(), "tieba");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
            hashMap.put("tpl", "1200020868");
            hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
            BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
            int color = ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            int color2 = ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            String str = "ebpay_transparent id:" + color + "   ebpay_transparent:" + color2;
            String str2 = "ebpay_title_bg id:" + ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_title_bg") + "   ebpay_title_bgColor:" + ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
            int color3 = com.baidu.fsg.base.utils.ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            int color4 = com.baidu.fsg.base.utils.ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_transparent");
            String str3 = "base_ebpay_transparent id:" + color3 + "   base_ebpay_transparent:" + color4;
            String str4 = "base_ebpay_title_bg id:" + com.baidu.fsg.base.utils.ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_title_bg") + "   base_ebpay_title_bgColor:" + com.baidu.fsg.base.utils.ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
        }
    }

    public static void initYYPaySDK() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, null) == null) && needInitYYPaySDk()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? yyPayUIKit.getPayUIKitConfig().revenueConfig.getUid() != Long.parseLong(TbadkCoreApplication.getCurrentAccountInfo().getID()) : invokeV.booleanValue;
    }

    public static boolean needInitYYPaySDk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65550, null, map) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65551, null, str, iWechatProxyCallback) == null) {
            wxPayCallback = iWechatProxyCallback;
            wxRecharge(str);
        }
    }

    public static void wxRecharge(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
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
