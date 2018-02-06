package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.utils.enums.BiometricType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.QALoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.a.a;
import com.baidu.tbadk.coreExtra.a.c;
import com.baidu.tbadk.k.q;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.d;
import com.baidu.tieba.passaccount.a.b;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.baidu.tieba.passaccount.app.QALoginActivity;
import com.baidu.tieba.passaccount.app.SapiFastRegActivity;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class PassManagerStatic {
    private static boolean fEi = false;

    static {
        Un();
        HQ();
        registerListener();
        aZy();
        aZz();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        aZC();
    }

    private static void Un() {
        a.checkPassV6Switch();
        if (!a.Fb()) {
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(RegisterActivityConfig.class, SapiFastRegActivity.class);
        }
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QALoginActivityConfig.class, QALoginActivity.class);
    }

    private static void HQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001268, b.aZE());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001293, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.core.a.a> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2001293, com.baidu.tieba.passaccount.a.a.aZD());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
                    TbadkCoreApplication.getInst().incPassportV6CrashCount();
                }
            }
        });
        aw.Du().a(new aw.a() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.4
            @Override // com.baidu.tbadk.core.util.aw.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jumptologin=1")) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), "", true, 0)));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void aZy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921328, new CustomMessageTask.CustomRunnable<Application>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
                if (customMessage != null) {
                    PassManagerStatic.bU(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aZz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(com.baidu.tbadk.core.frameworkData.a.aSP, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    PassManagerStatic.bV(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bU(Context context) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.7
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
                str = resources.getString(d.j.register_tip);
            } catch (Exception e) {
                str = "";
            }
        }
        SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_domain_qa", false)) {
            com.baidu.tbadk.coreExtra.a.b.bgN = Domain.DOMAIN_QA;
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
        } else {
            builder.setRuntimeEnvironment(com.baidu.tbadk.coreExtra.a.b.bgN);
        }
        builder.setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).registMode(RegistMode.FAST).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin("file:///android_asset/sapi_theme/style.css").fastRegConfirm(aZB()).fastRegConfirmMsg(str).fastLoginSupport(aZA()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).biometricTypeSupport(BiometricType.LIVENESS_RECOG);
        if (com.baidu.tbadk.coreExtra.a.b.bgN == Domain.DOMAIN_QA) {
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA.forceHttps(true));
            builder.debug(true);
        }
        try {
            SapiAccountManager.getInstance().init(builder.build());
        } catch (Exception e2) {
        }
        q.OB().ah(System.currentTimeMillis() - currentTimeMillis);
    }

    private static FastLoginFeature[] aZA() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 10) {
            arrayList.add(FastLoginFeature.TX_QQ_WEBVIEW);
            arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
            arrayList.add(FastLoginFeature.SINA_WEIBO_WEBVIEW);
        }
        FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[arrayList.size()];
        arrayList.toArray(fastLoginFeatureArr);
        return fastLoginFeatureArr;
    }

    private static boolean aZB() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        boolean z = systemProperty != null && "V5".equals(systemProperty);
        String from = TbadkCoreApplication.getFrom();
        return z || (from != null && from.equalsIgnoreCase(TbConfig.DIALOG_FROM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bV(final Context context) {
        MessageManager.getInstance().runTask(2921332, (Class) null);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null && !TextUtils.isEmpty(session.bduss)) {
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.bduss = session.bduss;
            accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
            PassportSDK.getInstance().loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.8
                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onSocialBind(String str) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WXEntryActivityConfig(context, 230016)));
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onLogin(Context context2, int i, String str) {
                    super.onLogin(context2, i, str);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, 3, true)));
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

    private static void aZC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921332, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.passaccount.framework.PassManagerStatic.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (!PassManagerStatic.fEi) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(BaiduRimConstants.RIM_ID_KEY, "2100020001");
                    hashMap.put("tpl", "1200020868");
                    hashMap.put("appkey", "ef4b7e008deab5c6fd206d180c5967039bfa8120");
                    BaiduRIM.getInstance().initRIM(TbadkApplication.getInst().getContext(), hashMap);
                    boolean unused = PassManagerStatic.fEi = true;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
