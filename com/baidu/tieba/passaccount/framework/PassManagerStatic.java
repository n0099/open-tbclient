package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.OneKeyLoginActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.tieba.passaccount.app.OneKeyLoginActivity;
import com.google.gson.Gson;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import d.b.h0.r.q.r0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PassManagerStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f19091a = false;

    /* renamed from: b  reason: collision with root package name */
    public static SapiConfiguration f19092b;

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<r0> {

        /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0212a extends OneKeyLoginCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f19093a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ r0 f19094b;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0213a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ OneKeyLoginResult f19095e;

                public RunnableC0213a(OneKeyLoginResult oneKeyLoginResult) {
                    this.f19095e = oneKeyLoginResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OneKeyLoginResult oneKeyLoginResult = this.f19095e;
                    if (oneKeyLoginResult.enable && !TextUtils.isEmpty(oneKeyLoginResult.sign) && !TextUtils.isEmpty(this.f19095e.encryptPhoneNum) && !TextUtils.isEmpty(this.f19095e.operator)) {
                        if (PassManagerStatic.h(C0212a.this.f19093a)) {
                            DialogLoginHelper.addLoginDialogInvokeLog(C0212a.this.f19094b.b(), DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
                            r0 r0Var = C0212a.this.f19094b;
                            OneKeyLoginResult oneKeyLoginResult2 = this.f19095e;
                            new LoginDialogActivityConfig(r0Var, oneKeyLoginResult2.encryptPhoneNum, oneKeyLoginResult2.operator, oneKeyLoginResult2.sign).start();
                        }
                    } else if ("first_login_abtest".equals(C0212a.this.f19094b.b())) {
                    } else {
                        C0212a c0212a = C0212a.this;
                        if (!PassManagerStatic.i(c0212a.f19093a, c0212a.f19094b) && PassManagerStatic.h(C0212a.this.f19093a)) {
                            new LoginActivityConfig(C0212a.this.f19093a, true).start();
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$b */
            /* loaded from: classes3.dex */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if ("first_login_abtest".equals(C0212a.this.f19094b.b())) {
                        return;
                    }
                    C0212a c0212a = C0212a.this;
                    if (!PassManagerStatic.i(c0212a.f19093a, c0212a.f19094b) && PassManagerStatic.h(C0212a.this.f19093a)) {
                        new LoginActivityConfig(C0212a.this.f19093a, true).start();
                    }
                }
            }

            public C0212a(a aVar, Context context, r0 r0Var) {
                this.f19093a = context;
                this.f19094b = r0Var;
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void available(OneKeyLoginResult oneKeyLoginResult) {
                d.b.c.e.m.e.a().post(new RunnableC0213a(oneKeyLoginResult));
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                d.b.c.e.m.e.a().post(new b());
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<r0> customMessage) {
            r0 data;
            Context a2;
            ShareStorage.StorageModel storageModel;
            if (customMessage == null || (data = customMessage.getData()) == null || (a2 = data.a()) == null) {
                return null;
            }
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                confignation.setAgreeDangerousProtocol(true);
            }
            List<ShareStorage.StorageModel> v2ShareModelList = SapiAccountManager.getInstance().getV2ShareModelList();
            if (!ListUtils.isEmpty(v2ShareModelList) && (storageModel = v2ShareModelList.get(0)) != null) {
                if (PassManagerStatic.h(a2)) {
                    String json = new Gson().toJson(storageModel);
                    DialogLoginHelper.addLoginDialogInvokeLog(data.b(), DialogLoginHelper.DIALOG_TYPE_SHARE);
                    new LoginDialogActivityConfig(data, json).start();
                }
                return null;
            }
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new C0212a(this, a2, data));
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends GlobalCallback {
        @Override // com.baidu.sapi2.callback.GlobalCallback
        public void onLoginStatusChange() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921537, 2));
        }

        @Override // com.baidu.sapi2.callback.GlobalCallback
        public void onNeedInitPassSdk() {
            if (PassManagerStatic.f19092b != null) {
                try {
                    SapiAccountManager.getInstance().init(PassManagerStatic.f19092b);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921537, 1));
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends AccountCenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f19098a;

        public c(Context context) {
            this.f19098a = context;
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onBdussChange() {
            super.onBdussChange();
            MessageManager.getInstance().runTask(2921330, null, this.f19098a);
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onFinish(AccountCenterResult accountCenterResult) {
            if (accountCenterResult == null || !accountCenterResult.isAccountDestory) {
                return;
            }
            MessageManager.getInstance().runTask(2921330, null, this.f19098a);
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onSocialBind(String str) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WXEntryActivityConfig(this.f19098a, 230016)));
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements CustomMessageTask.CustomRunnable<d.b.i0.b2.a> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.b.i0.b2.a> customMessage) {
            BaseResp baseResp;
            if (customMessage != null && (customMessage.getData() instanceof d.b.i0.b2.a)) {
                d.b.i0.b2.a data = customMessage.getData();
                if (data.f53319a != null && (baseResp = data.f53320b) != null && (baseResp instanceof SendAuth.Resp)) {
                    PassportSDK.getInstance().handleWXLoginResp(data.f53319a, ((SendAuth.Resp) baseResp).state, ((SendAuth.Resp) baseResp).code, data.f53320b.errCode);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements CustomMessageTask.CustomRunnable<String> {

        /* loaded from: classes3.dex */
        public class a extends QrLoginCallback {
            public a(f fVar) {
            }

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onFinish(QrLoginResult qrLoginResult) {
            }

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onLocalLogin(WebAuthResult webAuthResult) {
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
            if (customMessage == null || !(customMessage.getData() instanceof String)) {
                return null;
            }
            String data = customMessage.getData();
            if (SapiUtils.isQrLoginSchema(data)) {
                if ("pc".equals(SapiUtils.parseQrLoginSchema(data).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                    PassManagerStatic.z();
                    PassportSDK.getInstance().loadQrLogin(new a(this), data);
                }
                return new CustomResponsedMessage<>(2921339, Boolean.TRUE);
            }
            return new CustomResponsedMessage<>(2921339, Boolean.FALSE);
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Object> customMessage) {
            List<ActivityManager.RunningTaskInfo> runningTasks;
            boolean z;
            ComponentName componentName;
            ActivityManager activityManager = (ActivityManager) TbadkApplication.getInst().getSystemService("activity");
            boolean z2 = true;
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                loop0: while (true) {
                    z = true;
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null && (componentName = runningTaskInfo.topActivity) != null && componentName.getClassName() != null) {
                            String className = runningTaskInfo.topActivity.getClassName();
                            if (className.equals(LoginActivity.class.getName()) || className.equals(com.baidu.sapi2.activity.LoginActivity.class.getName())) {
                                z = false;
                            }
                        }
                    }
                }
                z2 = z;
            }
            return new CustomResponsedMessage<>(2921352, Boolean.valueOf(z2));
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements CustomMessageTask.CustomRunnable<Context> {

        /* loaded from: classes3.dex */
        public class a extends OneKeyLoginCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f19099a;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0214a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ OneKeyLoginResult f19100e;

                public RunnableC0214a(OneKeyLoginResult oneKeyLoginResult) {
                    this.f19100e = oneKeyLoginResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OneKeyLoginResult oneKeyLoginResult = this.f19100e;
                    if (!oneKeyLoginResult.enable || TextUtils.isEmpty(oneKeyLoginResult.sign) || TextUtils.isEmpty(this.f19100e.encryptPhoneNum) || TextUtils.isEmpty(this.f19100e.operator) || !PassManagerStatic.h(a.this.f19099a)) {
                        return;
                    }
                    DialogLoginHelper.addLoginDialogInvokeLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                    Context context = a.this.f19099a;
                    OneKeyLoginResult oneKeyLoginResult2 = this.f19100e;
                    new OneKeyLoginActivityConfig(context, oneKeyLoginResult2.encryptPhoneNum, oneKeyLoginResult2.operator, oneKeyLoginResult2.sign).start();
                }
            }

            public a(h hVar, Context context) {
                this.f19099a = context;
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void available(OneKeyLoginResult oneKeyLoginResult) {
                d.b.c.e.m.e.a().post(new RunnableC0214a(oneKeyLoginResult));
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                d.b.i0.l.e();
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            Context data;
            ShareStorage.StorageModel storageModel;
            if (customMessage == null || (data = customMessage.getData()) == null) {
                return null;
            }
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                confignation.setAgreeDangerousProtocol(true);
            }
            List<ShareStorage.StorageModel> v2ShareModelList = SapiAccountManager.getInstance().getV2ShareModelList();
            if (!ListUtils.isEmpty(v2ShareModelList) && (storageModel = v2ShareModelList.get(0)) != null) {
                if (PassManagerStatic.h(data)) {
                    String json = new Gson().toJson(storageModel);
                    DialogLoginHelper.addLoginDialogInvokeLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_SHARE);
                    new OneKeyLoginActivityConfig(data, json).start();
                }
                return null;
            }
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(this, data));
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements CustomMessageTask.CustomRunnable<Activity> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.b.h0.s.a.b> run(CustomMessage<Activity> customMessage) {
            return new CustomResponsedMessage<>(2001268, d.b.i0.b2.d.d.d());
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Activity> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.b.h0.r.l.a> run(CustomMessage<Activity> customMessage) {
            return new CustomResponsedMessage<>(2001293, d.b.i0.b2.d.a.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData) || !((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
                return;
            }
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_LOGIN)) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, 0)));
                    return 1;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements CustomMessageTask.CustomRunnable<Application> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
            if (customMessage == null) {
                return null;
            }
            Application data = customMessage.getData();
            if (!PassManagerStatic.f19091a) {
                try {
                    WbSdk.install(data, new AuthInfo(data, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    boolean unused = PassManagerStatic.f19091a = true;
                } catch (Exception unused2) {
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements CustomMessageTask.CustomRunnable<Application> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
            if (customMessage == null) {
                return null;
            }
            PassManagerStatic.m(customMessage.getData());
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class o implements CustomMessageTask.CustomRunnable<Context> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            if (customMessage != null && (customMessage.getData() instanceof Context)) {
                PassManagerStatic.y(customMessage.getData());
            }
            return null;
        }
    }

    static {
        q();
        w();
        r();
        o();
        p();
        v();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        x();
        u();
        n();
        d.b.i0.b2.d.b.o();
        s();
        t();
    }

    public static boolean h(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) && !activity.isFinishing();
        }
        return false;
    }

    public static boolean i(Context context, r0 r0Var) {
        if ("new_shouye".equals(r0Var.b())) {
            return true;
        }
        if ("sousuo_dianji".equals(r0Var.b())) {
            if (context instanceof BaseActivity) {
                j(((BaseActivity) context).getPageContext(), r0Var.c());
                return true;
            }
            return true;
        }
        return false;
    }

    public static void j(TbPageContext<?> tbPageContext, String str) {
        if (tbPageContext == null || StringUtils.isNull(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLinkWithOutJumpWebView(tbPageContext, new String[]{str});
    }

    public static FastLoginFeature[] k() {
        List<FastLoginFeature> l2 = l();
        FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[l2.size()];
        l2.toArray(fastLoginFeatureArr);
        return fastLoginFeatureArr;
    }

    public static List<FastLoginFeature> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FastLoginFeature.TX_QQ_SSO);
        arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
        arrayList.add(FastLoginFeature.SINA_WEIBO_SSO);
        return arrayList;
    }

    public static void m(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.setGlobalCallback(new b());
        SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
        if (d.b.h0.r.d0.b.j().g("is_domain_qa", false)) {
            d.b.h0.s.a.a.f51531a = Domain.DOMAIN_QA;
            builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
        } else {
            builder.setRuntimeEnvironment(d.b.h0.s.a.a.f51531a);
        }
        builder.setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).customActionBar(true).skin("file:///android_asset/sapi_theme/style.css").fastLoginSupport(k()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).qqAppID("101462192").sinaAppID("1511099634", PassBioEnv.PASSPORT_DOMAIN).setSupportFaceLogin(true).setSupportTouchLogin(false).forbidPresetPhoneNumber(true);
        builder.setAgreeDangerousProtocol(PermissionUtil.isAgreePrivacyPolicy());
        Domain domain = d.b.h0.s.a.a.f51531a;
        Domain domain2 = Domain.DOMAIN_QA;
        if (domain == domain2) {
            builder.setRuntimeEnvironment(domain2.forceHttps(true));
            builder.debug(true);
        }
        f19092b = builder.build();
        try {
            SapiAccountManager.getInstance().init(f19092b);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        d.b.h0.m0.l.b().E(System.currentTimeMillis() - currentTimeMillis);
    }

    public static void n() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921352, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void o() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921328, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void p() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921438, new m());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void q() {
        d.b.h0.s.a.a.a();
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginDialogActivityConfig.class, LoginDialogActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(OneKeyLoginActivityConfig.class, OneKeyLoginActivity.class);
    }

    public static void r() {
        MessageManager.getInstance().registerListener(new k(2016301));
        UrlManager.getInstance().addListener(new l());
    }

    public static void s() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921530, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void t() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921535, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void u() {
        MessageManager.getInstance().registerListener(new e(2921339));
        CustomMessageTask customMessageTask = new CustomMessageTask(2921339, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void v() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921329, new o());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void w() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new i());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001293, new j());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    public static void x() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921351, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void y(Context context) {
        MessageManager.getInstance().runTask(2921332, (Class) null);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null || TextUtils.isEmpty(session.bduss)) {
            return;
        }
        AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
        accountCenterDTO.bduss = session.bduss;
        accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
        accountCenterDTO.paramsList.add(new PassNameValuePair("thirdparty", "0"));
        PassportSDK passportSDK = PassportSDK.getInstance();
        z();
        passportSDK.loadAccountCenter(new c(context), accountCenterDTO);
    }

    public static void z() {
        if (f19092b == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            f19092b.isNightMode = true;
        } else {
            f19092b.isNightMode = false;
        }
    }
}
