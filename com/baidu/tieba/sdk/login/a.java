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
import com.baidu.live.c;
import com.baidu.live.d;
import com.baidu.live.e.b;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes6.dex */
public class a {
    private static a iRb;
    private b acb;
    private int iRc;
    private com.baidu.tieba.sdk.a.a iRd;
    private CustomMessageTask.CustomRunnable<Object> iRe = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.bJC();
            return null;
        }
    };
    private final HttpMessageListener iRf = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.iRc < 3) {
                        a.b(a.this);
                        a.this.a(a.this.iRd.bJB());
                        return;
                    }
                    return;
                }
                a.this.iRc = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.iRc;
        aVar.iRc = i + 1;
        return i;
    }

    public static a chL() {
        if (iRb == null) {
            synchronized (a.class) {
                if (iRb == null) {
                    iRb = new a();
                }
            }
        }
        return iRb;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.iRe);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.iRf);
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

    public void bJC() {
        if (this.iRd != null) {
            this.iRd.bJC();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.iRd = aVar;
    }

    public void chM() {
        if (this.iRd != null) {
            chP();
            if (this.acb == null) {
                this.acb = new b();
            }
            this.acb.initListener();
            this.acb.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void nq() {
                    if (a.this.acb != null) {
                        a.this.acb.onDestroy();
                    }
                }
            });
            this.acb.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void uN() {
        if (this.iRd != null) {
            chP();
        }
    }

    public boolean chN() {
        if (this.iRd == null) {
            return false;
        }
        boolean chP = chP();
        if (!chP) {
            this.iRd.bJC();
            return chP;
        }
        return chP;
    }

    public com.baidu.tieba.sdk.b.a chO() {
        if (this.iRd != null) {
            return this.iRd.bJB();
        }
        return null;
    }

    private boolean chP() {
        com.baidu.tieba.sdk.b.a bJB = this.iRd.bJB();
        if (bJB != null && bJB.isValid()) {
            chQ();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        chS();
        chR();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void chQ() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a bJB = this.iRd.bJB();
        if (bJB != null) {
            String string = c.np().getString("ala_account_user_id", "");
            String string2 = c.np().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(bJB.userId) && bJB.userId.equals(string);
            if (StringUtils.isNull(bJB.bduss) || !bJB.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0510a c0510a = new C0510a(currentAccountInfo);
                String string3 = c.np().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0510a.Dh(string3);
                } else {
                    c0510a.Dh(bJB.bduss);
                }
                String string4 = c.np().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0510a.Di(string4);
                }
                c0510a.De(bJB.userId);
                c0510a.Df(bJB.userName);
                c0510a.Dg(bJB.nickName);
                c0510a.Dj(bJB.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0510a.chT(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0510a.chT();
                    return;
                }
            }
            this.iRc = 0;
            chR();
            C0510a c0510a2 = new C0510a();
            c0510a2.Dh(bJB.bduss);
            c0510a2.Df(bJB.userName);
            c0510a2.Dg(bJB.nickName);
            c0510a2.De(bJB.userId);
            c0510a2.Dj(bJB.portrait);
            c.np().putString("ala_account_user_id", bJB.userId);
            c.np().putString("ala_account_user_bduss", bJB.bduss);
            TbadkCoreApplication.setCurrentAccount(c0510a2.chT(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(bJB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.sdk.b.a aVar) {
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

    private void chR() {
        c.np().remove("ala_account_user_id");
        c.np().remove("ala_account_user_bduss");
        c.np().remove("ala_account_user_tbs");
    }

    private void chS() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0510a {
        private String BDUSS;
        private int iRh;
        private AccountData iRi;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0510a() {
            this.iRi = new AccountData();
        }

        public C0510a(AccountData accountData) {
            if (accountData == null) {
                this.iRi = new AccountData();
            } else {
                this.iRi = accountData;
            }
        }

        public C0510a De(String str) {
            this.userId = str;
            return this;
        }

        public C0510a Df(String str) {
            this.userName = str;
            return this;
        }

        public C0510a Dg(String str) {
            this.nickName = str;
            return this;
        }

        public C0510a Dh(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0510a Di(String str) {
            this.tbs = str;
            return this;
        }

        public C0510a Dj(String str) {
            this.portrait = str;
            return this;
        }

        public C0510a yH(int i) {
            this.sex = i;
            return this;
        }

        public C0510a yI(int i) {
            this.iRh = i;
            return this;
        }

        public AccountData chT() {
            this.iRi.setBDUSS(this.BDUSS);
            this.iRi.setAccount(this.userName);
            this.iRi.setDisplayName(this.nickName);
            this.iRi.setID(this.userId);
            this.iRi.setPortrait(this.portrait);
            this.iRi.setTbs(this.tbs);
            this.iRi.setSex(this.sex);
            this.iRi.setIsActive(this.iRh);
            return this.iRi;
        }
    }
}
