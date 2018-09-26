package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.router.LocalRouter;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BiometricType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.a.a;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.l.n;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.e;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.a.d;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class PassManagerStatic {
    private static boolean fwM = false;
    private static SapiConfiguration fwN;

    static {
        SI();
        registerTask();
        registerListener();
        bay();
        baz();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        baD();
        baE();
        baG();
        baH();
        b.registerTask();
    }

    private static void SI() {
        a.checkPassV6Switch();
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
    }

    private static void registerTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001268, d.baU());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001293, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.core.a.a> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001293, com.baidu.tieba.passaccount.a.a.baK());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
                    TbadkCoreApplication.getInst().incPassportV6CrashCount();
                }
            }
        });
        ay.AN().a(new ay.a() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.9
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jumptologin=1")) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, 0)));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void bay() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921328, new CustomMessageTask.CustomRunnable<Application>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
                if (customMessage != null) {
                    PassManagerStatic.cz(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void baz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(com.baidu.tbadk.core.frameworkData.a.aoK, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.11
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    PassManagerStatic.cA(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cz(Context context) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.12
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.13
            @Override // com.baidu.sapi2.SapiAccountManager.ReceiveShareListener
            public void onReceiveShare() {
                if (PassManagerStatic.fwN != null) {
                    try {
                        SapiAccountManager.getInstance().init(PassManagerStatic.fwN);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
            }
        });
        Resources resources = context.getResources();
        if (resources == null) {
            str = "";
        } else {
            try {
                str = resources.getString(e.j.register_tip);
            } catch (Exception e) {
                str = "";
            }
        }
        SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_domain_qa", false)) {
            com.baidu.tbadk.coreExtra.a.b.aEd = Domain.DOMAIN_QA;
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
        } else {
            builder.setRuntimeEnvironment(com.baidu.tbadk.coreExtra.a.b.aEd);
        }
        builder.setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin("file:///android_asset/sapi_theme/style.css").fastRegConfirm(baC()).fastRegConfirmMsg(str).fastLoginSupport(baA()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).biometricTypeSupport(BiometricType.LIVENESS_RECOG).qqAppID("101462192").sinaAppID("1511099634", "https://passport.baidu.com").setSupportFaceLogin(true);
        if (com.baidu.tbadk.coreExtra.a.b.aEd == Domain.DOMAIN_QA) {
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA.forceHttps(true));
            builder.debug(true);
        }
        fwN = builder.build();
        try {
            SapiAccountManager.getInstance().init(fwN);
            WbSdk.install(context, new AuthInfo(context, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        try {
            LocalRouter.init(context);
        } catch (Throwable th) {
        }
        n.Me().ak(System.currentTimeMillis() - currentTimeMillis);
    }

    private static FastLoginFeature[] baA() {
        List<FastLoginFeature> baB = baB();
        FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[baB.size()];
        baB.toArray(fastLoginFeatureArr);
        return fastLoginFeatureArr;
    }

    public static List<FastLoginFeature> baB() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FastLoginFeature.TX_QQ_SSO);
        arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
        arrayList.add(FastLoginFeature.SINA_WEIBO_SSO);
        return arrayList;
    }

    private static boolean baC() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        boolean z = systemProperty != null && "V5".equals(systemProperty);
        String from = TbadkCoreApplication.getFrom();
        return z || (from != null && from.equalsIgnoreCase(TbConfig.DIALOG_FROM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cA(final Context context) {
        MessageManager.getInstance().runTask(2921332, (Class) null);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null && !TextUtils.isEmpty(session.bduss)) {
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.bduss = session.bduss;
            accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
            accountCenterDTO.paramsList.add(new BasicNameValuePair("thirdparty", "0"));
            PassportSDK passportSDK = PassportSDK.getInstance();
            baF();
            passportSDK.loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.14
                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onSocialBind(String str) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WXEntryActivityConfig(context, 230016)));
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onBdussChange() {
                    super.onBdussChange();
                    MessageManager.getInstance().runTask(2921330, null, context);
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onFinish(AccountCenterResult accountCenterResult) {
                    if (accountCenterResult != null && accountCenterResult.isAccountDestory) {
                        MessageManager.getInstance().runTask(2921330, null, context);
                    }
                }
            }, accountCenterDTO);
        }
    }

    private static void baD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921332, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (!PassManagerStatic.fwM) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
                    hashMap.put(BaiduRimConstants.TPL_INIT_KEY, "1200020868");
                    hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
                    BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
                    boolean unused = PassManagerStatic.fwM = true;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void baE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921351, new CustomMessageTask.CustomRunnable<com.baidu.tieba.passaccount.a>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.passaccount.a> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.tieba.passaccount.a)) {
                    com.baidu.tieba.passaccount.a data = customMessage.getData();
                    if (data.fwB != null && data.fwC != null && (data.fwC instanceof SendAuth.Resp)) {
                        PassportSDK.getInstance().handleWXLoginResp(data.fwB, ((SendAuth.Resp) data.fwC).state, ((SendAuth.Resp) data.fwC).code, data.fwC.errCode);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void baF() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            fwN.isNightMode = true;
        } else {
            fwN.isNightMode = false;
        }
    }

    private static void baG() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921339) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(2921339, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                String data = customMessage.getData();
                if (SapiUtils.isQrLoginSchema(data)) {
                    if ("pc".equals(SapiUtils.parseQrLoginSchema(data).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                        PassManagerStatic.baF();
                        PassportSDK.getInstance().loadQrLogin(new QrLoginCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.5.1
                            @Override // com.baidu.sapi2.callback.QrLoginCallback
                            public void onFinish(QrLoginResult qrLoginResult) {
                            }

                            @Override // com.baidu.sapi2.callback.QrLoginCallback
                            public void onLocalLogin(WebAuthResult webAuthResult) {
                            }
                        }, data);
                    }
                    return new CustomResponsedMessage<>(2921339, true);
                }
                return new CustomResponsedMessage<>(2921339, false);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void baH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921352, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<Object> customMessage) {
                List<ActivityManager.RunningTaskInfo> runningTasks;
                boolean z = true;
                ActivityManager activityManager = (ActivityManager) TbadkApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    boolean z2 = true;
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null && runningTaskInfo.topActivity != null && runningTaskInfo.topActivity.getClassName() != null) {
                            String className = runningTaskInfo.topActivity.getClassName();
                            z2 = (className.equals(LoginActivity.class.getName()) || className.equals(com.baidu.sapi2.activity.LoginActivity.class.getName())) ? false : true;
                        }
                    }
                    z = z2;
                }
                return new CustomResponsedMessage<>(2921352, Boolean.valueOf(z));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
