package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.a.a;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.a.d;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PassManagerStatic {
    private static boolean jAE = false;
    private static boolean jAF = false;
    private static boolean jAG = false;
    private static SapiConfiguration jAH;

    static {
        bmg();
        Fv();
        registerListener();
        cBa();
        cAZ();
        cBb();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        cBe();
        cBg();
        cBh();
        b.Fv();
    }

    private static void bmg() {
        a.checkPassV6Switch();
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
    }

    private static void Fv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_PASS_MANAGER, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PASS_MANAGER, d.cBs());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.core.a.a> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, com.baidu.tieba.passaccount.a.a.cBj());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.UEXCEPTION_MESSAGE) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
                    TbadkCoreApplication.getInst().incPassportV6CrashCount();
                }
            }
        });
        ba.aUZ().a(new ba.a() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.9
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_LOGIN)) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, 0)));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void cAZ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921438, new CustomMessageTask.CustomRunnable<Application>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
                if (customMessage != null) {
                    Application data = customMessage.getData();
                    if (!PassManagerStatic.jAF) {
                        try {
                            WbSdk.install(data, new AuthInfo(data, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                            boolean unused = PassManagerStatic.jAF = true;
                        } catch (Exception e) {
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cBa() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SAPI_INIT, new CustomMessageTask.CustomRunnable<Application>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.11
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
                if (customMessage != null) {
                    PassManagerStatic.fb(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cBb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921329, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    PassManagerStatic.fc(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fb(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.13
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.14
            @Override // com.baidu.sapi2.SapiAccountManager.ReceiveShareListener
            public void onReceiveShare() {
                if (PassManagerStatic.jAH != null) {
                    try {
                        SapiAccountManager.getInstance().init(PassManagerStatic.jAH);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
            }
        });
        BdLog.e("sapi begin middle :" + System.currentTimeMillis());
        SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("is_domain_qa", false)) {
            com.baidu.tbadk.coreExtra.a.b.PASS_LOGIN_ADDRESS = Domain.DOMAIN_QA;
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
        } else {
            builder.setRuntimeEnvironment(com.baidu.tbadk.coreExtra.a.b.PASS_LOGIN_ADDRESS);
        }
        builder.setProductLineInfo("tb", "1", "6e93e7659ae637845c7f83abee68a740").sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin("file:///android_asset/sapi_theme/style.css").fastLoginSupport(cBc()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).qqAppID("101462192").sinaAppID("1511099634", PassBioEnv.PASSPORT_DOMAIN).setSupportFaceLogin(true).setSupportTouchLogin(false).forbidPresetPhoneNumber(true);
        builder.setAgreeDangerousProtocol(com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_secret_is_show", false));
        if (com.baidu.tbadk.coreExtra.a.b.PASS_LOGIN_ADDRESS == Domain.DOMAIN_QA) {
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA.forceHttps(true));
            builder.debug(true);
        }
        jAH = builder.build();
        try {
            SapiAccountManager.getInstance().init(jAH);
        } catch (Exception e) {
            BdLog.e(e);
        }
        n.bfN().cx(System.currentTimeMillis() - currentTimeMillis);
    }

    private static FastLoginFeature[] cBc() {
        List<FastLoginFeature> cBd = cBd();
        FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[cBd.size()];
        cBd.toArray(fastLoginFeatureArr);
        return fastLoginFeatureArr;
    }

    public static List<FastLoginFeature> cBd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FastLoginFeature.TX_QQ_SSO);
        arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
        arrayList.add(FastLoginFeature.SINA_WEIBO_SSO);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fc(final Context context) {
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null && !TextUtils.isEmpty(session.bduss)) {
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.bduss = session.bduss;
            accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
            accountCenterDTO.paramsList.add(new PassNameValuePair("thirdparty", "0"));
            PassportSDK passportSDK = PassportSDK.getInstance();
            cBf();
            passportSDK.loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.2
                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onSocialBind(String str) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WXEntryActivityConfig(context, RequestResponseCode.REQUEST_WXENTER_ACTIVITY)));
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onBdussChange() {
                    super.onBdussChange();
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LOG_OUT, null, context);
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onFinish(AccountCenterResult accountCenterResult) {
                    if (accountCenterResult != null && accountCenterResult.isAccountDestory) {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LOG_OUT, null, context);
                    }
                }
            }, accountCenterDTO);
        }
    }

    private static void cBe() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921351, new CustomMessageTask.CustomRunnable<com.baidu.tieba.passaccount.a>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.passaccount.a> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.tieba.passaccount.a)) {
                    com.baidu.tieba.passaccount.a data = customMessage.getData();
                    if (data.jAm != null && data.jAn != null && (data.jAn instanceof SendAuth.Resp)) {
                        PassportSDK.getInstance().handleWXLoginResp(data.jAm, ((SendAuth.Resp) data.jAn).state, ((SendAuth.Resp) data.jAn).code, data.jAn.errCode);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void cBf() {
        if (jAH != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                jAH.isNightMode = true;
            } else {
                jAH.isNightMode = false;
            }
        }
    }

    private static void cBg() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_QR_CODE_LOGIN) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_QR_CODE_LOGIN, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                String data = customMessage.getData();
                if (SapiUtils.isQrLoginSchema(data)) {
                    if ("pc".equals(SapiUtils.parseQrLoginSchema(data).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                        PassManagerStatic.cBf();
                        PassportSDK.getInstance().loadQrLogin(new QrLoginCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.5.1
                            @Override // com.baidu.sapi2.callback.QrLoginCallback
                            public void onFinish(QrLoginResult qrLoginResult) {
                            }

                            @Override // com.baidu.sapi2.callback.QrLoginCallback
                            public void onLocalLogin(WebAuthResult webAuthResult) {
                            }
                        }, data);
                    }
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_QR_CODE_LOGIN, true);
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_QR_CODE_LOGIN, false);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cBh() {
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
