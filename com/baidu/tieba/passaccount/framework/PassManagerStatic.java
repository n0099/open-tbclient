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
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.a.a;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.k.n;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.passaccount.a.b;
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
    private static boolean fpk = false;
    private static SapiConfiguration fpl;

    static {
        QI();
        registerTask();
        registerListener();
        aZW();
        aZX();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        bab();
        bac();
        bad();
        bae();
    }

    private static void QI() {
        a.checkPassV6Switch();
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
    }

    private static void registerTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001268, b.bag());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001293, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.core.a.a> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001293, com.baidu.tieba.passaccount.a.a.baf());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
                    TbadkCoreApplication.getInst().incPassportV6CrashCount();
                }
            }
        });
        az.zV().a(new az.a() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.8
            @Override // com.baidu.tbadk.core.util.az.a
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

    private static void aZW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921328, new CustomMessageTask.CustomRunnable<Application>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
                if (customMessage != null) {
                    PassManagerStatic.bS(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aZX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(com.baidu.tbadk.core.frameworkData.a.amE, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    PassManagerStatic.bT(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bS(Context context) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.11
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        Resources resources = context.getResources();
        if (resources == null) {
            str = "";
        } else {
            try {
                str = resources.getString(d.k.register_tip);
            } catch (Exception e) {
                str = "";
            }
        }
        SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_domain_qa", false)) {
            com.baidu.tbadk.coreExtra.a.b.aBi = Domain.DOMAIN_QA;
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
        } else {
            builder.setRuntimeEnvironment(com.baidu.tbadk.coreExtra.a.b.aBi);
        }
        builder.setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin("file:///android_asset/sapi_theme/style.css").fastRegConfirm(baa()).fastRegConfirmMsg(str).fastLoginSupport(aZY()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).biometricTypeSupport(BiometricType.LIVENESS_RECOG).qqAppID("101462192").sinaAppID("1511099634", "https://passport.baidu.com");
        if (com.baidu.tbadk.coreExtra.a.b.aBi == Domain.DOMAIN_QA) {
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA.forceHttps(true));
            builder.debug(true);
        }
        fpl = builder.build();
        try {
            SapiAccountManager.getInstance().init(fpl);
            WbSdk.install(context, new AuthInfo(context, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        n.KP().ae(System.currentTimeMillis() - currentTimeMillis);
    }

    private static FastLoginFeature[] aZY() {
        List<FastLoginFeature> aZZ = aZZ();
        FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[aZZ.size()];
        aZZ.toArray(fastLoginFeatureArr);
        return fastLoginFeatureArr;
    }

    public static List<FastLoginFeature> aZZ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FastLoginFeature.TX_QQ_SSO);
        arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
        arrayList.add(FastLoginFeature.SINA_WEIBO_SSO);
        return arrayList;
    }

    private static boolean baa() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        boolean z = systemProperty != null && "V5".equals(systemProperty);
        String from = TbadkCoreApplication.getFrom();
        return z || (from != null && from.equalsIgnoreCase(TbConfig.DIALOG_FROM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bT(final Context context) {
        MessageManager.getInstance().runTask(2921332, (Class) null);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null && !TextUtils.isEmpty(session.bduss)) {
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.bduss = session.bduss;
            accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
            accountCenterDTO.paramsList.add(new BasicNameValuePair("thirdparty", "0"));
            PassportSDK passportSDK = PassportSDK.getInstance();
            switchNightMode();
            passportSDK.loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.12
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

    private static void bab() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921332, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (!PassManagerStatic.fpk) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
                    hashMap.put("tpl", "1200020868");
                    hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
                    BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
                    boolean unused = PassManagerStatic.fpk = true;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bac() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921351, new CustomMessageTask.CustomRunnable<com.baidu.tieba.passaccount.a>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.passaccount.a> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.tieba.passaccount.a)) {
                    com.baidu.tieba.passaccount.a data = customMessage.getData();
                    if (data.fpb != null && data.fpc != null && (data.fpc instanceof SendAuth.Resp)) {
                        PassportSDK.getInstance().handleWXLoginResp(data.fpb, ((SendAuth.Resp) data.fpc).state, ((SendAuth.Resp) data.fpc).code, data.fpc.errCode);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void switchNightMode() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            fpl.isNightMode = true;
        } else {
            fpl.isNightMode = false;
        }
    }

    private static void bad() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921339) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(2921339, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                String data = customMessage.getData();
                if (SapiUtils.isQrLoginSchema(data) && SapiUtils.QR_LOGIN_LP_PC.equals(SapiUtils.parseQrLoginSchema(data).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                    PassManagerStatic.switchNightMode();
                    PassportSDK.getInstance().loadQrLogin(new QrLoginCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.4.1
                        @Override // com.baidu.sapi2.callback.QrLoginCallback
                        public void loginStatusChange(boolean z) {
                        }
                    }, data);
                }
                return new CustomResponsedMessage<>(2921339, true);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bae() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921352, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.5
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
