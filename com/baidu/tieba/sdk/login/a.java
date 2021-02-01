package com.baidu.tieba.sdk.login;

import android.content.Intent;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.e;
import com.baidu.live.o.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes11.dex */
public class a {
    private static volatile a nde;
    private c bff;
    private int ndf;
    private com.baidu.tieba.sdk.b.a ndg;
    private CustomMessageTask.CustomRunnable<Object> ndh = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.ddr();
            return null;
        }
    };
    private final HttpMessageListener ndi = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.ndf < 3) {
                        a.b(a.this);
                        a.this.a(a.this.ndg.ddq());
                        return;
                    }
                    return;
                }
                a.this.ndf = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.ndf;
        aVar.ndf = i + 1;
        return i;
    }

    public static a dFI() {
        if (nde == null) {
            synchronized (a.class) {
                if (nde == null) {
                    nde = new a();
                }
            }
        }
        return nde;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.ndh);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.ndi);
        registerTask();
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void ddr() {
        if (this.ndg != null) {
            this.ndg.ddr();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.ndg = aVar;
    }

    public void dFJ() {
        if (this.ndg != null) {
            dFM();
            if (this.bff == null) {
                this.bff = new c();
            }
            this.bff.initListener();
            this.bff.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void xd() {
                    if (a.this.bff != null) {
                        a.this.bff.onDestroy();
                    }
                }
            });
            this.bff.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Tw() {
        if (this.ndg != null) {
            dFM();
        }
    }

    public boolean dFK() {
        if (this.ndg == null) {
            return false;
        }
        boolean dFM = dFM();
        if (!dFM) {
            this.ndg.ddr();
            return dFM;
        }
        return dFM;
    }

    public com.baidu.tieba.sdk.c.a dFL() {
        if (this.ndg != null) {
            return this.ndg.ddq();
        }
        return null;
    }

    private boolean dFM() {
        com.baidu.tieba.sdk.c.a ddq = this.ndg.ddq();
        if (ddq != null && ddq.isValid()) {
            dFN();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dFP();
        dFO();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dFN() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a ddq = this.ndg.ddq();
        if (ddq != null) {
            String string = d.xc().getString("ala_account_user_id", "");
            String string2 = d.xc().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(ddq.userId) && ddq.userId.equals(string);
            if (StringUtils.isNull(ddq.bduss) || !ddq.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0861a c0861a = new C0861a(currentAccountInfo);
                String string3 = d.xc().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0861a.Sf(string3);
                } else {
                    c0861a.Sf(ddq.bduss);
                }
                String string4 = d.xc().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0861a.Sg(string4);
                }
                c0861a.Sc(ddq.userId);
                c0861a.Sd(ddq.userName);
                c0861a.Se(ddq.nickName);
                c0861a.Sh(ddq.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0861a.dFQ(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0861a.dFQ();
                    return;
                }
            }
            this.ndf = 0;
            dFO();
            C0861a c0861a2 = new C0861a();
            c0861a2.Sf(ddq.bduss);
            c0861a2.Sd(ddq.userName);
            c0861a2.Se(ddq.nickName);
            c0861a2.Sc(ddq.userId);
            c0861a2.Sh(ddq.portrait);
            d.xc().putString("ala_account_user_id", ddq.userId);
            d.xc().putString("ala_account_user_bduss", ddq.bduss);
            TbadkCoreApplication.setCurrentAccount(c0861a2.dFQ(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(ddq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.sdk.c.a aVar) {
        if (aVar != null) {
            HttpMessage httpMessage = new HttpMessage(1003402);
            httpMessage.addParam("BDUSS", aVar.bduss);
            httpMessage.addParam("user_name", aVar.userName);
            httpMessage.addParam("nick_name", aVar.nickName);
            httpMessage.addParam("sex", aVar.sex);
            httpMessage.addParam("portrait", aVar.portrait);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void dFO() {
        d.xc().remove("ala_account_user_id");
        d.xc().remove("ala_account_user_bduss");
        d.xc().remove("ala_account_user_tbs");
    }

    private void dFP() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0861a {
        private String BDUSS;
        private int ndk;
        private AccountData ndl;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0861a() {
            this.ndl = new AccountData();
        }

        public C0861a(AccountData accountData) {
            if (accountData == null) {
                this.ndl = new AccountData();
            } else {
                this.ndl = accountData;
            }
        }

        public C0861a Sc(String str) {
            this.userId = str;
            return this;
        }

        public C0861a Sd(String str) {
            this.userName = str;
            return this;
        }

        public C0861a Se(String str) {
            this.nickName = str;
            return this;
        }

        public C0861a Sf(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0861a Sg(String str) {
            this.tbs = str;
            return this;
        }

        public C0861a Sh(String str) {
            this.portrait = str;
            return this;
        }

        public C0861a Ir(int i) {
            this.sex = i;
            return this;
        }

        public C0861a Is(int i) {
            this.ndk = i;
            return this;
        }

        public AccountData dFQ() {
            this.ndl.setBDUSS(this.BDUSS);
            this.ndl.setAccount(this.userName);
            this.ndl.setDisplayName(this.nickName);
            this.ndl.setID(this.userId);
            this.ndl.setPortrait(this.portrait);
            this.ndl.setTbs(this.tbs);
            this.ndl.setSex(this.sex);
            this.ndl.setIsActive(this.ndk);
            return this.ndl;
        }
    }
}
