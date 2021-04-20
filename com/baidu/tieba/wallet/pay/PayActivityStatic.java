package com.baidu.tieba.wallet.pay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
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
import d.b.c.a.b;
import d.b.c.e.m.e;
import d.b.c.e.p.k;
import d.b.h0.l0.c;
import d.b.h0.l0.d;
import d.b.i0.d3.d0.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.UserBfbInfo;
/* loaded from: classes5.dex */
public class PayActivityStatic {
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
        registerTiebaPay();
        registerTiebaCertification();
        LightAppWrapper.getInstance().initLightApp(new LightAppListenerImpl());
        TbadkApplication.getInst().RegisterIntent(PayWalletActivityConfig.class, WalletPayActivity.class);
        TbadkApplication.getInst().RegisterIntent(WalletPayResultActivityConfig.class, WalletPayResultActivity.class);
        registerOpenWallteBalanceTask();
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016457) { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.12
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
                LBSPayInner.getInstance().doBindCard(TbadkApplication.getInst().getContext(), new BindBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.12.1
                    @Override // com.baidu.android.pay.BindBack
                    public boolean isHideLoadingDialog() {
                        return false;
                    }

                    @Override // com.baidu.android.pay.BindBack
                    public void onBindResult(int i, String str) {
                        if (i != 0) {
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

    public static void doPayWithChannel(String str, HashMap<String, String> hashMap, LBSPayBack lBSPayBack) {
        try {
            JSONObject jSONObject = new JSONObject(BaiduLBSPay.getInstance().getReqData(b.f().b()));
            jSONObject.put("token", INetwork.LBS_HOST);
            jSONObject.put("payChannel", str);
            BaiduLBSPay.getInstance().doCallFrontCashierPay(b.f().b(), null, lBSPayBack, hashMap, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
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

    public static void registerAiAppPayTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921393, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
                final d data;
                Activity activity;
                if (customMessage == null || (data = customMessage.getData()) == null) {
                    return null;
                }
                final BdUniqueId bdUniqueId = data.f50704a;
                String str = data.f50706c;
                int i = data.f50705b;
                if (i == 1) {
                    if (data.f50707d != null) {
                        PayActivityStatic.initBaiduWallet();
                        BaiduWallet.getInstance().doPay(data.f50707d, str, new PayCallBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3.1
                            @Override // com.baidu.android.pay.PayCallBack
                            public boolean isHideLoadingDialog() {
                                return false;
                            }

                            @Override // com.baidu.android.pay.PayCallBack
                            public void onPayResult(int i2, String str2) {
                                d dVar = new d();
                                dVar.f50704a = bdUniqueId;
                                dVar.f50705b = i2;
                                dVar.f50706c = str2;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, dVar));
                            }
                        });
                    }
                } else if (i == 2) {
                    if (data.f50707d != null) {
                        new BdAsyncTask<String, Integer, Map<String, String>>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Map<String, String> doInBackground(String... strArr) {
                                return new PayTask(data.f50707d).payV2(strArr[0], true);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public void onPostExecute(Map<String, String> map) {
                                int i2 = -1;
                                String str2 = null;
                                for (String str3 : map.keySet()) {
                                    if (TextUtils.equals(str3, l.f2017a)) {
                                        i2 = Integer.parseInt(map.get(str3));
                                    } else if (TextUtils.equals(str3, "result")) {
                                        str2 = map.get(str3);
                                    }
                                }
                                int i3 = i2 == 9000 ? 0 : i2 == 8000 ? 1 : i2 == 6001 ? 2 : 6;
                                d dVar = new d();
                                dVar.f50704a = bdUniqueId;
                                dVar.f50705b = i3;
                                dVar.f50706c = str2;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, dVar));
                            }
                        }.execute(str);
                    }
                } else if (i == 3) {
                    if (data.f50707d != null) {
                        PayActivityStatic.initBaiduWallet();
                        if (data.f50708e != null && !StringUtils.isNull(data.f50706c)) {
                            BaiduLBSPay.getInstance().doCallFrontCashierPay(data.f50707d, null, new LBSPayBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.3.3
                                @Override // com.baidu.android.lbspay.LBSPayBack
                                public void onPayResult(int i2, String str2) {
                                    String str3;
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("statusCode", i2);
                                        jSONObject.put("responseData", str2);
                                        str3 = jSONObject.toString();
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        str3 = null;
                                    }
                                    d dVar = new d();
                                    dVar.f50704a = bdUniqueId;
                                    dVar.f50705b = i2;
                                    dVar.f50706c = str3;
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, dVar));
                                }
                            }, data.f50708e, data.f50706c);
                        }
                    }
                } else if (i == 4 && (activity = data.f50707d) != null && data.f50709f != null) {
                    IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, TbConfig.WEIXIN_SHARE_APP_ID);
                    PayReq payReq = PayActivityStatic.getPayReq(data.f50709f);
                    createWXAPI.registerApp(payReq.appId);
                    createWXAPI.sendReq(payReq);
                }
                return null;
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
                        public void onPayResult(int i, String str) {
                            d dVar = new d();
                            dVar.f50705b = i;
                            dVar.f50706c = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921335, dVar));
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
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.6
            @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                int indexOf;
                int i;
                String substring;
                int indexOf2;
                int i2;
                if (strArr != null && strArr.length > 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FINANCIAL_FRS_SDK_TAB) && (indexOf = str.indexOf("://")) >= 0 && (i = indexOf + 3) <= str.length() && (indexOf2 = (substring = str.substring(i)).indexOf("url=")) >= 0 && (i2 = indexOf2 + 4) <= substring.length() && c.c().e()) {
                        String substring2 = substring.substring(i2);
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
        a.f(303043, ResponsedGetOrderSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_ORDER, a.a(TbConfig.GET_ORDER, 303043));
        tbHttpMessageTask.setResponsedClass(ResponsedGetOrderHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void registerMyWalletTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001351, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().getContext() != null && c.c().d()) {
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
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.9
            @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                final String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_ICACH) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_DUXIAOMAN)) {
                    if (d.b.c.e.p.l.B() && c.c().e()) {
                        PayActivityStatic.initBaiduWallet();
                        BaiduWallet.getInstance().openH5Module(TbadkApplication.getInst().getContext(), str, true);
                    } else {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.newDebug("wallet_debug", 0L, null, "type", "scheme_start_wallet_sub_thread", "link", "" + str);
                        e.a().post(new Runnable() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.c().e()) {
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2001447, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null && !k.isEmpty(customMessage.getData())) {
                    String data = customMessage.getData();
                    if (c.c().e()) {
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2001452, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                PayActivityStatic.initBaiduWallet();
                BaiduWallet.getInstance().gotoWalletService(TbadkApplication.getInst().getContext(), "32", "");
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void registerOpenWallteHomePageTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (c.c().f()) {
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001387) { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.4
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2921433, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.11
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(2921433, new ICertification() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.11.1
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
                        PassportSDK.getInstance().loadAccountRealName(context, new AccountRealNameCallback() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.11.1.1
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2921432, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2921432, new ITiebaPay() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.10.1
                    @Override // com.baidu.tieba.wallet.ITiebaPay
                    public String getWalletUa() {
                        PayActivityStatic.initBaiduWallet();
                        String reqData = BaiduLBSPay.getInstance().getReqData(b.f().b());
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
                        LBSPayBack lBSPayBack = new LBSPayBack() { // from class: com.baidu.tieba.wallet.pay.PayActivityStatic.10.1.1
                            @Override // com.baidu.android.lbspay.LBSPayBack
                            public void onPayResult(int i, String str2) {
                                ITiebaPayCallback iTiebaPayCallback2 = iTiebaPayCallback;
                                if (iTiebaPayCallback2 != null) {
                                    iTiebaPayCallback2.onPayResult(i, str2);
                                }
                            }
                        };
                        PayActivityStatic.initBaiduWallet();
                        if (!StringUtils.isNull(str)) {
                            PayActivityStatic.doPayWithChannel(str, hashMap, lBSPayBack);
                        } else {
                            BaiduLBSPay.getInstance().doPolymerPay(b.f().b(), lBSPayBack, hashMap);
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
}
