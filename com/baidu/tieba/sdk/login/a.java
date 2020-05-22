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
import com.baidu.live.k.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes3.dex */
public class a {
    private static volatile a kTk;
    private c aLm;
    private int kTl;
    private com.baidu.tieba.sdk.b.a kTm;
    private CustomMessageTask.CustomRunnable<Object> kTn = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cuZ();
            return null;
        }
    };
    private final HttpMessageListener kTo = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.kTl < 3) {
                        a.b(a.this);
                        a.this.a(a.this.kTm.cuY());
                        return;
                    }
                    return;
                }
                a.this.kTl = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.kTl;
        aVar.kTl = i + 1;
        return i;
    }

    public static a cWu() {
        if (kTk == null) {
            synchronized (a.class) {
                if (kTk == null) {
                    kTk = new a();
                }
            }
        }
        return kTk;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.kTn);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.kTo);
        Fv();
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cuZ() {
        if (this.kTm != null) {
            this.kTm.cuZ();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.kTm = aVar;
    }

    public void cWv() {
        if (this.kTm != null) {
            cWy();
            if (this.aLm == null) {
                this.aLm = new c();
            }
            this.aLm.initListener();
            this.aLm.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void uO() {
                    if (a.this.aLm != null) {
                        a.this.aLm.onDestroy();
                    }
                }
            });
            this.aLm.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Gr() {
        if (this.kTm != null) {
            cWy();
        }
    }

    public boolean cWw() {
        if (this.kTm == null) {
            return false;
        }
        boolean cWy = cWy();
        if (!cWy) {
            this.kTm.cuZ();
            return cWy;
        }
        return cWy;
    }

    public com.baidu.tieba.sdk.c.a cWx() {
        if (this.kTm != null) {
            return this.kTm.cuY();
        }
        return null;
    }

    private boolean cWy() {
        com.baidu.tieba.sdk.c.a cuY = this.kTm.cuY();
        if (cuY != null && cuY.isValid()) {
            cWz();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cWB();
        cWA();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cWz() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cuY = this.kTm.cuY();
        if (cuY != null) {
            String string = com.baidu.live.c.uN().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.uN().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cuY.userId) && cuY.userId.equals(string);
            if (StringUtils.isNull(cuY.bduss) || !cuY.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0716a c0716a = new C0716a(currentAccountInfo);
                String string3 = com.baidu.live.c.uN().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0716a.LM(string3);
                } else {
                    c0716a.LM(cuY.bduss);
                }
                String string4 = com.baidu.live.c.uN().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0716a.LN(string4);
                }
                c0716a.LJ(cuY.userId);
                c0716a.LK(cuY.userName);
                c0716a.LL(cuY.nickName);
                c0716a.LO(cuY.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0716a.cWC(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0716a.cWC();
                    return;
                }
            }
            this.kTl = 0;
            cWA();
            C0716a c0716a2 = new C0716a();
            c0716a2.LM(cuY.bduss);
            c0716a2.LK(cuY.userName);
            c0716a2.LL(cuY.nickName);
            c0716a2.LJ(cuY.userId);
            c0716a2.LO(cuY.portrait);
            com.baidu.live.c.uN().putString("ala_account_user_id", cuY.userId);
            com.baidu.live.c.uN().putString("ala_account_user_bduss", cuY.bduss);
            TbadkCoreApplication.setCurrentAccount(c0716a2.cWC(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cuY);
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

    private void cWA() {
        com.baidu.live.c.uN().remove("ala_account_user_id");
        com.baidu.live.c.uN().remove("ala_account_user_bduss");
        com.baidu.live.c.uN().remove("ala_account_user_tbs");
    }

    private void cWB() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0716a {
        private String BDUSS;
        private int kTq;
        private AccountData kTr;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0716a() {
            this.kTr = new AccountData();
        }

        public C0716a(AccountData accountData) {
            if (accountData == null) {
                this.kTr = new AccountData();
            } else {
                this.kTr = accountData;
            }
        }

        public C0716a LJ(String str) {
            this.userId = str;
            return this;
        }

        public C0716a LK(String str) {
            this.userName = str;
            return this;
        }

        public C0716a LL(String str) {
            this.nickName = str;
            return this;
        }

        public C0716a LM(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0716a LN(String str) {
            this.tbs = str;
            return this;
        }

        public C0716a LO(String str) {
            this.portrait = str;
            return this;
        }

        public C0716a CI(int i) {
            this.sex = i;
            return this;
        }

        public C0716a CJ(int i) {
            this.kTq = i;
            return this;
        }

        public AccountData cWC() {
            this.kTr.setBDUSS(this.BDUSS);
            this.kTr.setAccount(this.userName);
            this.kTr.setDisplayName(this.nickName);
            this.kTr.setID(this.userId);
            this.kTr.setPortrait(this.portrait);
            this.kTr.setTbs(this.tbs);
            this.kTr.setSex(this.sex);
            this.kTr.setIsActive(this.kTq);
            return this.kTr;
        }
    }
}
