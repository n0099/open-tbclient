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
import com.baidu.live.l.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes7.dex */
public class a {
    private static volatile a lNk;
    private c aUD;
    private int lNl;
    private com.baidu.tieba.sdk.b.a lNm;
    private CustomMessageTask.CustomRunnable<Object> lNn = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cNQ();
            return null;
        }
    };
    private final HttpMessageListener lNo = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.lNl < 3) {
                        a.b(a.this);
                        a.this.a(a.this.lNm.cNP());
                        return;
                    }
                    return;
                }
                a.this.lNl = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.lNl;
        aVar.lNl = i + 1;
        return i;
    }

    public static a dpC() {
        if (lNk == null) {
            synchronized (a.class) {
                if (lNk == null) {
                    lNk = new a();
                }
            }
        }
        return lNk;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.lNn);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.lNo);
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

    public void cNQ() {
        if (this.lNm != null) {
            this.lNm.cNQ();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.lNm = aVar;
    }

    public void dpD() {
        if (this.lNm != null) {
            dpG();
            if (this.aUD == null) {
                this.aUD = new c();
            }
            this.aUD.initListener();
            this.aUD.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void AE() {
                    if (a.this.aUD != null) {
                        a.this.aUD.onDestroy();
                    }
                }
            });
            this.aUD.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void ND() {
        if (this.lNm != null) {
            dpG();
        }
    }

    public boolean dpE() {
        if (this.lNm == null) {
            return false;
        }
        boolean dpG = dpG();
        if (!dpG) {
            this.lNm.cNQ();
            return dpG;
        }
        return dpG;
    }

    public com.baidu.tieba.sdk.c.a dpF() {
        if (this.lNm != null) {
            return this.lNm.cNP();
        }
        return null;
    }

    private boolean dpG() {
        com.baidu.tieba.sdk.c.a cNP = this.lNm.cNP();
        if (cNP != null && cNP.isValid()) {
            dpH();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dpJ();
        dpI();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dpH() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cNP = this.lNm.cNP();
        if (cNP != null) {
            String string = com.baidu.live.c.AD().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.AD().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cNP.userId) && cNP.userId.equals(string);
            if (StringUtils.isNull(cNP.bduss) || !cNP.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0796a c0796a = new C0796a(currentAccountInfo);
                String string3 = com.baidu.live.c.AD().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0796a.PT(string3);
                } else {
                    c0796a.PT(cNP.bduss);
                }
                String string4 = com.baidu.live.c.AD().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0796a.PU(string4);
                }
                c0796a.PQ(cNP.userId);
                c0796a.PR(cNP.userName);
                c0796a.PS(cNP.nickName);
                c0796a.PV(cNP.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0796a.dpK(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0796a.dpK();
                    return;
                }
            }
            this.lNl = 0;
            dpI();
            C0796a c0796a2 = new C0796a();
            c0796a2.PT(cNP.bduss);
            c0796a2.PR(cNP.userName);
            c0796a2.PS(cNP.nickName);
            c0796a2.PQ(cNP.userId);
            c0796a2.PV(cNP.portrait);
            com.baidu.live.c.AD().putString("ala_account_user_id", cNP.userId);
            com.baidu.live.c.AD().putString("ala_account_user_bduss", cNP.bduss);
            TbadkCoreApplication.setCurrentAccount(c0796a2.dpK(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cNP);
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

    private void dpI() {
        com.baidu.live.c.AD().remove("ala_account_user_id");
        com.baidu.live.c.AD().remove("ala_account_user_bduss");
        com.baidu.live.c.AD().remove("ala_account_user_tbs");
    }

    private void dpJ() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0796a {
        private String BDUSS;
        private int lNq;
        private AccountData lNr;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0796a() {
            this.lNr = new AccountData();
        }

        public C0796a(AccountData accountData) {
            if (accountData == null) {
                this.lNr = new AccountData();
            } else {
                this.lNr = accountData;
            }
        }

        public C0796a PQ(String str) {
            this.userId = str;
            return this;
        }

        public C0796a PR(String str) {
            this.userName = str;
            return this;
        }

        public C0796a PS(String str) {
            this.nickName = str;
            return this;
        }

        public C0796a PT(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0796a PU(String str) {
            this.tbs = str;
            return this;
        }

        public C0796a PV(String str) {
            this.portrait = str;
            return this;
        }

        public C0796a GF(int i) {
            this.sex = i;
            return this;
        }

        public C0796a GG(int i) {
            this.lNq = i;
            return this;
        }

        public AccountData dpK() {
            this.lNr.setBDUSS(this.BDUSS);
            this.lNr.setAccount(this.userName);
            this.lNr.setDisplayName(this.nickName);
            this.lNr.setID(this.userId);
            this.lNr.setPortrait(this.portrait);
            this.lNr.setTbs(this.tbs);
            this.lNr.setSex(this.sex);
            this.lNr.setIsActive(this.lNq);
            return this.lNr;
        }
    }
}
