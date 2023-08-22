package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.pay.IyyPayResultCallback;
import com.baidu.tbadk.pay.YYPayData;
import com.baidu.tbadk.pay.YYPayResult;
import com.baidu.tieba.yr5;
import com.baidu.tieba.zr5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
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
/* loaded from: classes8.dex */
public class YYPayManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_WX_RECHARGE_RESULT_ERROR_CODE = "_wxapi_baseresp_errcode";
    public static final String KEY_WX_RECHARGE_RESULT_ERROR_STR = "_wxapi_baseresp_errstr";
    public static final String YY_GSLB_APP_ID = "b1e5c785-70de-4bd4-8b9e-f3b6ace8f5dc";
    public static final int YY_PAY_APPID = 41;
    public static final int YY_PAY_USE_CHANNEL = 10002;
    public static final int YY_PAY_USE_CHANNEL_YY_LIVE = 30;
    public static BroadcastReceiver broadcastReceiver;
    public static IWechatProxyCallback wxPayCallback;
    public static IyyPayResultCallback yyPayResultCallback;
    public static YYPayUIKit yyPayUIKit;
    public static YYPayUIKit yyPayUIKitYYLive;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1207692014, "Lcom/baidu/tieba/wallet/YYPayManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1207692014, "Lcom/baidu/tieba/wallet/YYPayManager;");
        }
    }

    public YYPayManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void createUIKit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            if (yyPayUIKit != null && yyPayUIKitYYLive != null) {
                return;
            }
            yyPayUIKit = YYPayUIKit.getUIKit(41, 10002);
            yyPayUIKitYYLive = YYPayUIKit.getUIKit(41, 30);
        }
    }

    public static boolean needInitYYPaySDk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (yyPayUIKit != null) {
                if (isAccountChange()) {
                    yyPayUIKit.destroy();
                    yyPayUIKit = null;
                    yyPayUIKitYYLive.destroy();
                    yyPayUIKitYYLive = null;
                } else {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void destoryYyPayCallback(IyyPayResultCallback iyyPayResultCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, iyyPayResultCallback) == null) && iyyPayResultCallback == yyPayResultCallback) {
            yyPayResultCallback = null;
        }
    }

    public static MiddleRevenueConfig buildMiddleRevenueConfig(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            Context applicationContext = BdBaseApplication.getInst().getApp().getApplicationContext();
            String packageName = applicationContext.getPackageName();
            String string = SharedPrefHelper.getInstance().getString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "");
            Context context = TbadkCoreApplication.getInst().getContext();
            MiddleReportConfig build = new MiddleReportConfig.MiddleReportConfigBuilder().build();
            build.setAppName("百度贴吧");
            build.setDeviceId(DeviceId.getDeviceID(context));
            build.setReportRatio(1.0f);
            build.setReporter(null);
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            long parseLong = Long.parseLong(currentAccountInfo.getID());
            MiddleRevenueConfig build2 = new MiddleRevenueConfig.MiddleRevenueConfigBuilder().build();
            build2.setAppContext(applicationContext);
            build2.setAppId(41);
            build2.setUseChannel(i);
            build2.setCurrencyType(4);
            build2.setPackageName(packageName);
            build2.setVersion(string);
            build2.setTestEnv(BdBaseApplication.getInst().isDebugMode());
            build2.setAuthType(6);
            build2.setProtoType(ProtocolType.HTTP);
            build2.setGslbAppId(YY_GSLB_APP_ID);
            build2.setUid(parseLong);
            build2.setToken(currentAccountInfo.getBDUSS());
            build2.setTokenCallback(new IToken() { // from class: com.baidu.tieba.wallet.YYPayManager.3
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

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IToken
                public String onUpdateToken() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return TbadkCoreApplication.getCurrentAccountInfo().getBDUSS();
                    }
                    return (String) invokeV.objValue;
                }
            });
            build2.setHostId("5");
            return build2;
        }
        return (MiddleRevenueConfig) invokeI.objValue;
    }

    public static void doYYPayTask(YYPayData yYPayData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, yYPayData) != null) || yYPayData == null) {
            return;
        }
        initYYPaySDK();
        createUIKit();
        yyPayResultCallback = yYPayData.yyPayResultCallback;
        Object obj = yYPayData.context;
        if (!(obj instanceof Activity)) {
            obj = getCurrentActivity();
        }
        IYYPayAmountView.ViewParams viewParams = new IYYPayAmountView.ViewParams();
        viewParams.closeOnSuccess = yYPayData.closeOnSuccess;
        if (!TextUtils.isEmpty(yYPayData.mTitle)) {
            viewParams.payAmountDialogTitle = yYPayData.mTitle;
        }
        Long l = yYPayData.mAmount;
        if (l != null) {
            int intValue = l.intValue();
            viewParams.targetAmount = intValue;
            if (intValue > 0) {
                int i = yYPayData.payScene;
                if (i != 1) {
                    if (i != 3) {
                        viewParams.payScene = PayScene.DIALOG_QUICK_PAY;
                    } else {
                        viewParams.payScene = PayScene.DIALOG_TARGET_PAY;
                    }
                } else {
                    viewParams.payScene = PayScene.DIALOG_PAY_SCENE;
                }
            }
        }
        IyyPayResultCallback iyyPayResultCallback = yyPayResultCallback;
        if (iyyPayResultCallback instanceof yr5) {
            viewParams.viewEventListener = new AbsViewEventHandler((yr5) iyyPayResultCallback) { // from class: com.baidu.tieba.wallet.YYPayManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ yr5 val$absPayAllResult;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, payDialogType) == null) && payDialogType != null) {
                        this.val$absPayAllResult.a((byte) payDialogType.ordinal());
                    }
                }
            };
        }
        if (obj != null) {
            IPayCallback<CurrencyChargeMessage> iPayCallback = new IPayCallback() { // from class: com.baidu.tieba.wallet.YYPayManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

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
                    if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, payCallBackBean) == null) && YYPayManager.yyPayResultCallback != null) {
                        YYPayManager.yyPayResultCallback.onFail(i2, str);
                    }
                }

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onSuccess(Object obj2, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048579, this, obj2, payCallBackBean) == null) && YYPayManager.yyPayResultCallback != null) {
                        if (obj2 instanceof CurrencyChargeMessage) {
                            YYPayResult yYPayResult = new YYPayResult();
                            CurrencyChargeMessage currencyChargeMessage = (CurrencyChargeMessage) obj2;
                            yYPayResult.status = currencyChargeMessage.status;
                            yYPayResult.appid = currencyChargeMessage.appid;
                            yYPayResult.uid = Long.valueOf(currencyChargeMessage.uid);
                            yYPayResult.usedChannel = currencyChargeMessage.usedChannel;
                            yYPayResult.currencyType = currencyChargeMessage.currencyType;
                            yYPayResult.amount = Long.valueOf(currencyChargeMessage.amount);
                            yYPayResult.currencyAmount = Long.valueOf(currencyChargeMessage.currencyAmount);
                            yYPayResult.orderId = currencyChargeMessage.orderId;
                            yYPayResult.expand = currencyChargeMessage.expand;
                            YYPayManager.yyPayResultCallback.onSuccess(yYPayResult);
                            return;
                        }
                        YYPayManager.yyPayResultCallback.onSuccess(null);
                    }
                }
            };
            if (yYPayData.channel == 0) {
                yyPayUIKit.startPayDialog((Activity) obj, viewParams, iPayCallback);
            } else {
                yyPayUIKitYYLive.startPayDialog((Activity) obj, viewParams, iPayCallback);
            }
            if (TbSingleton.getInstance().isUserBan()) {
                zr5.a(null);
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
            } catch (Exception e) {
                e.printStackTrace();
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

    public static void initYYPaySDK() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65546, null) != null) || !needInitYYPaySDk()) {
            return;
        }
        MiddleRevenueConfig buildMiddleRevenueConfig = buildMiddleRevenueConfig(10002);
        PayUIKitConfig builder = new PayUIKitConfig.PayUIKitConfigBuilder().setRevenueConfig(buildMiddleRevenueConfig).builder();
        builder.revenueConfig = buildMiddleRevenueConfig;
        YYPayUIKit.createNewKitWithConfigure(41, 10002, builder);
        MiddleRevenueConfig buildMiddleRevenueConfig2 = buildMiddleRevenueConfig(30);
        PayUIKitConfig builder2 = new PayUIKitConfig.PayUIKitConfigBuilder().setRevenueConfig(buildMiddleRevenueConfig2).builder();
        builder2.revenueConfig = buildMiddleRevenueConfig2;
        YYPayUIKit.createNewKitWithConfigure(41, 30, builder2);
    }

    public static boolean isAccountChange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (yyPayUIKit.getPayUIKitConfig().revenueConfig.getUid() != Long.parseLong(TbadkCoreApplication.getCurrentAccountInfo().getID())) {
                return true;
            }
            return false;
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
                broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.wallet.YYPayManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                            hashMap2.put(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(intent.getExtras().getInt("errorCode", -1)));
                            hashMap2.put(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR, intent.getExtras().getString("errorMsg", ""));
                            YYPayManager.onWxPayResult(hashMap2);
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
