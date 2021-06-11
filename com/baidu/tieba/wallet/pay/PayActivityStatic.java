package com.baidu.tieba.wallet.pay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.LBSPayInner;
import com.baidu.android.lbspay.network.INetwork;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.router.LocalRouter;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.wallet.ICertification;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.tieba.wallet.ITiebaPayCallback;
import com.baidu.tieba.wallet.LightAppListenerImpl;
import com.baidu.tieba.wallet.Login;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipayProxyCallback;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmProxyCallback;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import d.a.c.e.p.k;
import d.a.m0.d.a;
import d.a.m0.l0.b;
import d.a.m0.l0.d;
import d.a.m0.l0.e;
import d.a.m0.l0.f;
import d.a.m0.l0.g;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.UserBfbInfo;
import tv.athena.revenue.api.MiddleReportConfig;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
/* loaded from: classes5.dex */
public class PayActivityStatic {
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

    static {
        ResUtils.setApplicationContext(TbadkCoreApplication.getInst());
        ResUtils.setResourcePackageName("com.baidu.tieba.pluginWallet");
        com.baidu.apollon.utils.ResUtils.setApplicationContext(TbadkCoreApplication.getInst());
        com.baidu.apollon.utils.ResUtils.setResourcePackageName("com.baidu.tieba");
        registerHttpAndSocketTask();
        registerMyWalletTask();
        registerPersonWalletMessage();
        registerOpenWalletICashPageTask();
        registerOpenWallteHomePageTask();
        registerFinancialFrsSDKTabSchemaListener();
        registerOpenWalletICashPageJump();
        registerBaiduNovelPayTask();
        registerAiAppPayTask();
        registerAliPayTask();
        registerTiebaPay();
        registerTiebaCertification();
        registerYYPayTask();
        registerYYPayUIKitProxy();
        LightAppWrapper.getInstance().initLightApp(new LightAppListenerImpl());
        TbadkApplication.getInst().RegisterIntent(PayWalletActivityConfig.class, WalletPayActivity.class);
        TbadkApplication.getInst().RegisterIntent(WalletPayResultActivityConfig.class, WalletPayResultActivity.class);
        registerOpenWallteBalanceTask();
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016457) { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || (customResponsedMessage.getData() instanceof ExceptionData)) {
                    return;
                }
                UserBfbInfo userBfbInfo = (UserBfbInfo) customResponsedMessage.getData();
                HashMap hashMap = new HashMap();
                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, userBfbInfo.android_bfb_sdk.sp_no.toString());
                hashMap.put("version", userBfbInfo.android_bfb_sdk.version);
                hashMap.put("activity_no", userBfbInfo.android_bfb_sdk.activity_no);
                hashMap.put("order_no", userBfbInfo.android_bfb_sdk.order_no);
                hashMap.put("return_url", userBfbInfo.android_bfb_sdk.return_url);
                hashMap.put("sign", userBfbInfo.android_bfb_sdk.sign);
                hashMap.put("sign_method", userBfbInfo.android_bfb_sdk.sign_method.toString());
                LBSPayInner.getInstance().doBindCard(TbadkApplication.getInst().getContext(), new BindBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.19.1
                    @Override // com.baidu.android.pay.BindBack
                    public boolean isHideLoadingDialog() {
                        return false;
                    }

                    @Override // com.baidu.android.pay.BindBack
                    public void onBindResult(int i2, String str) {
                        if (i2 != 0) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016458));
                    }
                }, hashMap);
            }
        });
        try {
            LocalRouter.init(TbadkCoreApplication.getInst());
        } catch (Throwable unused) {
        }
    }

    public static MiddleRevenueConfig buildMiddleRevenueConfig(int i2) {
        Context applicationContext = BdBaseApplication.getInst().getApp().getApplicationContext();
        String packageName = applicationContext.getPackageName();
        String p = d.a.m0.r.d0.b.j().p("version_name", "");
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
        build2.setTokenCallback(new IToken() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.17
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IToken
            public String onUpdateToken() {
                return TbadkCoreApplication.getCurrentAccountInfo().getBDUSS();
            }
        });
        build2.setHostId("5");
        return build2;
    }

    public static void createUIKit() {
        if (yyPayUIKit == null || yyPayUIKitYYLive == null) {
            yyPayUIKit = YYPayUIKit.getUIKit(41, 10002);
            yyPayUIKitYYLive = YYPayUIKit.getUIKit(41, 30);
        }
    }

    public static void doPayWithChannel(String str, HashMap<String, String> hashMap, LBSPayBack lBSPayBack) {
        try {
            JSONObject jSONObject = new JSONObject(BaiduLBSPay.getInstance().getReqData(d.a.c.a.b.f().b()));
            jSONObject.put("token", INetwork.LBS_HOST);
            jSONObject.put("payChannel", str);
            BaiduLBSPay.getInstance().doCallFrontCashierPay(d.a.c.a.b.f().b(), null, lBSPayBack, hashMap, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static Activity getCurrentActivity() {
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

    public static PayReq getPayReq(Map<String, String> map) {
        PayReq payReq = new PayReq();
        payReq.appId = map.get("appid");
        payReq.partnerId = map.get("partnerid");
        payReq.prepayId = map.get("prepayid");
        payReq.packageValue = map.get("packagealias");
        payReq.nonceStr = map.get("noncestr");
        payReq.timeStamp = map.get("timestamp");
        payReq.sign = map.get("sign");
        return payReq;
    }

    public static void initBaiduWallet() {
        if (BaiduWalletDelegate.getInstance().getAppContext() != null) {
            return;
        }
        BaiduWallet.getInstance().initWallet(new Login(TbadkApplication.getInst().getContext()), TbadkApplication.getInst().getContext(), "tieba");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
        hashMap.put("tpl", "1200020868");
        hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
        BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
        int color = com.baidu.apollon.utils.ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_transparent");
        int color2 = com.baidu.apollon.utils.ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_transparent");
        int color3 = com.baidu.apollon.utils.ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
        int color4 = com.baidu.apollon.utils.ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
        Log.e("PayActivityStatic", "ebpay_transparent id:" + color + "   ebpay_transparent:" + color2);
        Log.e("PayActivityStatic", "ebpay_title_bg id:" + color3 + "   ebpay_title_bgColor:" + color4);
        int color5 = ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_transparent");
        int color6 = ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_transparent");
        int color7 = ResUtils.color(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
        int color8 = ResUtils.getColor(TbadkApplication.getInst().getContext(), "ebpay_title_bg");
        Log.e("PayActivityStatic", "base_ebpay_transparent id:" + color5 + "   base_ebpay_transparent:" + color6);
        Log.e("PayActivityStatic", "base_ebpay_title_bg id:" + color7 + "   base_ebpay_title_bgColor:" + color8);
    }

    public static void initYYPaySDK() {
        if (needInitYYPaySDk()) {
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
        return yyPayUIKit.getPayUIKitConfig().revenueConfig.getUid() != Long.parseLong(TbadkCoreApplication.getCurrentAccountInfo().getID());
    }

    public static boolean needInitYYPaySDk() {
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

    public static void onWxPayResult(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        IWechatProxyCallback iWechatProxyCallback = wxPayCallback;
        if (iWechatProxyCallback != null) {
            iWechatProxyCallback.onSuccess(hashMap);
        }
    }

    public static void registerAiAppPayTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921393, new CustomMessageTask.CustomRunnable<e>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<e> customMessage) {
                final e data;
                Activity activity;
                if (customMessage == null || (data = customMessage.getData()) == null) {
                    return null;
                }
                final BdUniqueId bdUniqueId = data.f53174a;
                String str = data.f53176c;
                int i2 = data.f53175b;
                if (i2 == 1) {
                    if (data.f53177d != null) {
                        PayActivityStatic.initBaiduWallet();
                        BaiduWallet.getInstance().doPay(data.f53177d, str, new PayCallBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.5.1
                            @Override // com.baidu.android.pay.PayCallBack
                            public boolean isHideLoadingDialog() {
                                return false;
                            }

                            @Override // com.baidu.android.pay.PayCallBack
                            public void onPayResult(int i3, String str2) {
                                e eVar = new e();
                                eVar.f53174a = bdUniqueId;
                                eVar.f53175b = i3;
                                eVar.f53176c = str2;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, eVar));
                            }
                        });
                    }
                } else if (i2 == 2) {
                    if (data.f53177d != null) {
                        new BdAsyncTask<String, Integer, Map<String, String>>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.5.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Map<String, String> doInBackground(String... strArr) {
                                return new PayTask(data.f53177d).payV2(strArr[0], true);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public void onPostExecute(Map<String, String> map) {
                                int i3 = -1;
                                String str2 = null;
                                for (String str3 : map.keySet()) {
                                    if (TextUtils.equals(str3, l.f1987a)) {
                                        i3 = Integer.parseInt(map.get(str3));
                                    } else if (TextUtils.equals(str3, "result")) {
                                        str2 = map.get(str3);
                                    }
                                }
                                int i4 = i3 == 9000 ? 0 : i3 == 8000 ? 1 : i3 == 6001 ? 2 : 6;
                                e eVar = new e();
                                eVar.f53174a = bdUniqueId;
                                eVar.f53175b = i4;
                                eVar.f53176c = str2;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, eVar));
                            }
                        }.execute(str);
                    }
                } else if (i2 == 3) {
                    if (data.f53177d != null) {
                        PayActivityStatic.initBaiduWallet();
                        if (data.f53178e != null && !StringUtils.isNull(data.f53176c)) {
                            BaiduLBSPay.getInstance().doCallFrontCashierPay(data.f53177d, null, new LBSPayBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.5.3
                                @Override // com.baidu.android.lbspay.LBSPayBack
                                public void onPayResult(int i3, String str2) {
                                    String str3;
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("statusCode", i3);
                                        jSONObject.put("responseData", str2);
                                        str3 = jSONObject.toString();
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        str3 = null;
                                    }
                                    e eVar = new e();
                                    eVar.f53174a = bdUniqueId;
                                    eVar.f53175b = i3;
                                    eVar.f53176c = str3;
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, eVar));
                                }
                            }, data.f53178e, data.f53176c);
                        }
                    }
                } else if (i2 == 4 && (activity = data.f53177d) != null && data.f53179f != null) {
                    IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, TbConfig.WEIXIN_SHARE_APP_ID);
                    PayReq payReq = PayActivityStatic.getPayReq(data.f53179f);
                    createWXAPI.registerApp(payReq.appId);
                    createWXAPI.sendReq(payReq);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerAliPayTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921539, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<a> customMessage) {
                if (customMessage.getData() == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921539, new PayTask(customMessage.getData().f52933a).pay(customMessage.getData().f52934b, customMessage.getData().f52935c));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerBaiduNovelPayTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921335, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof String)) {
                    PayActivityStatic.initBaiduWallet();
                    BaiduWallet.getInstance().doPay(TbadkCoreApplication.getInst(), customMessage.getData(), new PayCallBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.2.1
                        @Override // com.baidu.android.pay.PayCallBack
                        public boolean isHideLoadingDialog() {
                            return false;
                        }

                        @Override // com.baidu.android.pay.PayCallBack
                        public void onPayResult(int i2, String str) {
                            e eVar = new e();
                            eVar.f53175b = i2;
                            eVar.f53176c = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921335, eVar));
                        }
                    });
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerFinancialFrsSDKTabSchemaListener() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.8
            @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                int indexOf;
                int i2;
                String substring;
                int indexOf2;
                int i3;
                if (strArr != null && strArr.length > 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FINANCIAL_FRS_SDK_TAB) && (indexOf = str.indexOf("://")) >= 0 && (i2 = indexOf + 3) <= str.length() && (indexOf2 = (substring = str.substring(i2)).indexOf("url=")) >= 0 && (i3 = indexOf2 + 4) <= substring.length() && d.c().e()) {
                        String substring2 = substring.substring(i3);
                        PayActivityStatic.initBaiduWallet();
                        BaiduWallet.getInstance().openH5Module(TbadkApplication.getInst().getContext(), substring2, true);
                        return 0;
                    }
                }
                return 3;
            }
        });
    }

    public static void registerHttpAndSocketTask() {
        d.a.n0.e3.d0.a.f(303043, ResponsedGetOrderSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_ORDER, d.a.n0.e3.d0.a.a(TbConfig.GET_ORDER, 303043));
        tbHttpMessageTask.setResponsedClass(ResponsedGetOrderHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void registerMyWalletTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001351, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().getContext() != null && d.c().d()) {
                    PayActivityStatic.initBaiduWallet();
                    BaiduWallet.getInstance().startWallet(customMessage.getData().getContext());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerOpenWalletICashPageJump() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.11
            @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                final String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_ICACH) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_DUXIAOMAN)) {
                    if (d.a.c.e.p.l.C() && d.c().e()) {
                        PayActivityStatic.initBaiduWallet();
                        BaiduWallet.getInstance().openH5Module(TbadkApplication.getInst().getContext(), str, true);
                    } else {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.newDebug("wallet_debug", 0L, null, "type", "scheme_start_wallet_sub_thread", "link", "" + str);
                        d.a.c.e.m.e.a().post(new Runnable() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.c().e()) {
                                    PayActivityStatic.initBaiduWallet();
                                    BaiduWallet.getInstance().openH5Module(TbadkApplication.getInst().getContext(), str, true);
                                }
                            }
                        });
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    public static void registerOpenWalletICashPageTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001447, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null && !k.isEmpty(customMessage.getData())) {
                    String data = customMessage.getData();
                    if (d.c().e()) {
                        PayActivityStatic.initBaiduWallet();
                        BaiduWallet.getInstance().openH5Module(TbadkApplication.getInst().getContext(), data, true);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerOpenWallteBalanceTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001452, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                PayActivityStatic.initBaiduWallet();
                BaiduWallet.getInstance().gotoWalletService(TbadkApplication.getInst().getContext(), EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, "");
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerOpenWallteHomePageTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (d.c().f()) {
                    PayActivityStatic.initBaiduWallet();
                    BaiduWallet.getInstance().gotoWalletService(TbadkApplication.getInst().getContext(), "16384", "");
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerPersonWalletMessage() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001387) { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                    return;
                }
                PayActivityStatic.initBaiduWallet();
                BaiduWallet.getInstance().accessWalletEntry(TbadkApplication.getInst().getContext(), (String) customResponsedMessage.getData());
            }
        });
    }

    public static void registerTiebaCertification() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921433, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(2921433, new ICertification() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.13.1
                    @Override // com.baidu.tieba.wallet.ICertification
                    public void certification(Context context, Map<String, Object> map, final ICertification.CertificationCallback certificationCallback) {
                        String str = SapiAccountManager.getInstance().getSession().bduss;
                        RealNameDTO realNameDTO = new RealNameDTO();
                        realNameDTO.bduss = str;
                        realNameDTO.scene = FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
                        realNameDTO.needCbKey = false;
                        if (map != null) {
                            realNameDTO.customRealNameUrl = map.containsKey("certify_url") ? map.get("certify_url").toString() : "";
                        }
                        PassportSDK.getInstance().loadAccountRealName(context, new AccountRealNameCallback() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.13.1.1
                            @Override // com.baidu.sapi2.callback.AccountRealNameCallback
                            public void onFinish(AccountRealNameResult accountRealNameResult) {
                                super.onFinish(accountRealNameResult);
                                Log.d("realAuth", "@@ 实名认证 实名操作结果，是否完成初级实名（验证姓名+身份证）：" + accountRealNameResult.juniorRealNameSuc + "，是否完成高级实名：" + accountRealNameResult.seniorRealNameSuc);
                                if (certificationCallback != null) {
                                    HashMap hashMap = new HashMap();
                                    int resultCode = accountRealNameResult.getResultCode();
                                    String resultMsg = accountRealNameResult.getResultMsg();
                                    boolean z = accountRealNameResult.juniorRealNameSuc;
                                    boolean z2 = accountRealNameResult.seniorRealNameSuc;
                                    String str2 = accountRealNameResult.callbackkey;
                                    if (TextUtils.isEmpty(resultMsg)) {
                                        resultMsg = "";
                                    }
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = "";
                                    }
                                    hashMap.put("resultMsg", resultMsg);
                                    hashMap.put("callbackkey", str2);
                                    hashMap.put("juniorRealNameSuc", z ? "1" : "0");
                                    hashMap.put("seniorRealNameSuc", z2 ? "1" : "0");
                                    certificationCallback.onResult(resultCode, hashMap);
                                }
                            }
                        }, realNameDTO);
                    }
                });
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerTiebaPay() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921432, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2921432, new ITiebaPay() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.12.1
                    @Override // com.baidu.tieba.wallet.ITiebaPay
                    public String getWalletUa() {
                        PayActivityStatic.initBaiduWallet();
                        String reqData = BaiduLBSPay.getInstance().getReqData(d.a.c.a.b.f().b());
                        if (!StringUtils.isNull(reqData)) {
                            try {
                                return new JSONObject(reqData).optString("ua");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return "";
                    }

                    @Override // com.baidu.tieba.wallet.ITiebaPay
                    public void onPayResult(String str, String str2, Context context, boolean z) {
                    }

                    @Override // com.baidu.tieba.wallet.ITiebaPay
                    public void pay(String str, HashMap<String, String> hashMap, final ITiebaPayCallback iTiebaPayCallback) {
                        LBSPayBack lBSPayBack = new LBSPayBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.12.1.1
                            @Override // com.baidu.android.lbspay.LBSPayBack
                            public void onPayResult(int i2, String str2) {
                                ITiebaPayCallback iTiebaPayCallback2 = iTiebaPayCallback;
                                if (iTiebaPayCallback2 != null) {
                                    iTiebaPayCallback2.onPayResult(i2, str2);
                                }
                            }
                        };
                        PayActivityStatic.initBaiduWallet();
                        if (!StringUtils.isNull(str)) {
                            PayActivityStatic.doPayWithChannel(str, hashMap, lBSPayBack);
                        } else {
                            BaiduLBSPay.getInstance().doPolymerPay(d.a.c.a.b.f().b(), lBSPayBack, hashMap);
                        }
                    }

                    @Override // com.baidu.tieba.wallet.ITiebaPay
                    public void release() {
                    }
                });
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerYYPayTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921546, new CustomMessageTask.CustomRunnable<f>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.18
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<f> customMessage) {
                if (customMessage.getData() == null) {
                    return null;
                }
                f data = customMessage.getData();
                PayActivityStatic.initYYPaySDK();
                PayActivityStatic.createUIKit();
                b unused = PayActivityStatic.yyPayResultCallback = data.f53184d;
                Object obj = data.f53181a;
                if (!(obj instanceof Activity)) {
                    obj = PayActivityStatic.getCurrentActivity();
                }
                IYYPayAmountView.ViewParams viewParams = new IYYPayAmountView.ViewParams();
                if (!TextUtils.isEmpty(data.f53183c)) {
                    viewParams.payAmountDialogTitle = data.f53183c;
                }
                if (obj != null) {
                    if (data.f53182b == 0) {
                        PayActivityStatic.yyPayUIKit.startPayDialog((Activity) obj, null, null);
                    } else {
                        PayActivityStatic.yyPayUIKitYYLive.startPayDialog((Activity) obj, viewParams, new IPayCallback() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.18.1
                            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                            public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
                                if (PayActivityStatic.yyPayResultCallback != null) {
                                    PayActivityStatic.yyPayResultCallback.onFail(i2, str);
                                }
                            }

                            @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
                            public void onPayStart() {
                            }

                            @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
                            public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
                            }

                            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                            public void onSuccess(Object obj2, PayCallBackBean payCallBackBean) {
                                if (PayActivityStatic.yyPayResultCallback != null) {
                                    if (!(obj2 instanceof CurrencyChargeMessage)) {
                                        PayActivityStatic.yyPayResultCallback.a(null);
                                        return;
                                    }
                                    g gVar = new g();
                                    CurrencyChargeMessage currencyChargeMessage = (CurrencyChargeMessage) obj2;
                                    gVar.f53191g = currencyChargeMessage.status;
                                    gVar.f53186b = currencyChargeMessage.appid;
                                    gVar.f53192h = Long.valueOf(currencyChargeMessage.uid);
                                    gVar.f53193i = currencyChargeMessage.usedChannel;
                                    gVar.f53188d = currencyChargeMessage.currencyType;
                                    gVar.f53185a = Long.valueOf(currencyChargeMessage.amount);
                                    gVar.f53187c = Long.valueOf(currencyChargeMessage.currencyAmount);
                                    gVar.f53190f = currencyChargeMessage.orderId;
                                    gVar.f53189e = currencyChargeMessage.expand;
                                    PayActivityStatic.yyPayResultCallback.a(gVar);
                                }
                            }
                        });
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerYYPayUIKitProxy() {
        YYPayUIKit.setAlipaySdkProxy(new IAlipaySdkServiceProxy() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.14
            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy
            public void sendPay(long j, Activity activity, String str, IAlipayProxyCallback iAlipayProxyCallback) {
                try {
                    a aVar = new a();
                    aVar.f52933a = activity;
                    aVar.f52934b = str;
                    aVar.f52935c = false;
                    iAlipayProxyCallback.onSuccess((String) MessageManager.getInstance().runTask(2921539, String.class, aVar).getData());
                } catch (Exception e2) {
                    iAlipayProxyCallback.onFail(e2.getMessage());
                }
            }
        });
        YYPayUIKit.setWechatSdkProxy(new IWechatSdkServiceProxy() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.15
            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy
            public void onWxPayResult(int i2, String str) {
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy
            public void sendPay(long j, Activity activity, String str, IWechatProxyCallback iWechatProxyCallback) {
                IWechatProxyCallback unused = PayActivityStatic.wxPayCallback = iWechatProxyCallback;
                PayActivityStatic.wxRecharge(str);
            }
        });
        YYPayUIKit.setDxmPaySdkProxy(new IDxmSdkServiceProxy() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.16
            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy
            public void sendPay(long j, Activity activity, String str, final IDxmProxyCallback iDxmProxyCallback) {
                PayActivityStatic.initBaiduWallet();
                BaiduWallet.getInstance().doPay(TbadkCoreApplication.getInst(), str, new PayCallBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.16.1
                    @Override // com.baidu.android.pay.PayCallBack
                    public boolean isHideLoadingDialog() {
                        return false;
                    }

                    @Override // com.baidu.android.pay.PayCallBack
                    public void onPayResult(int i2, String str2) {
                        iDxmProxyCallback.onSuccess(i2, str2);
                    }
                });
            }
        });
    }

    public static void wxRecharge(String str) {
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
            broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.4
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(intent.getExtras().getInt("errorCode", -1)));
                    hashMap2.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, intent.getExtras().getString("errorMsg", ""));
                    PayActivityStatic.onWxPayResult(hashMap2);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("WXPayResult");
            TbadkCoreApplication.getInst().registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception unused) {
        }
    }

    public static PayReq getPayReq(JSONObject jSONObject) {
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
}
