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
import com.baidu.live.j.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes2.dex */
public class a {
    private static a jPd;
    private c akJ;
    private int jPe;
    private com.baidu.tieba.sdk.a.a jPf;
    private CustomMessageTask.CustomRunnable<Object> jPg = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cbY();
            return null;
        }
    };
    private final HttpMessageListener jPh = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jPe < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jPf.cbX());
                        return;
                    }
                    return;
                }
                a.this.jPe = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jPe;
        aVar.jPe = i + 1;
        return i;
    }

    public static a cCT() {
        if (jPd == null) {
            synchronized (a.class) {
                if (jPd == null) {
                    jPd = new a();
                }
            }
        }
        return jPd;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jPg);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jPh);
        rT();
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cbY() {
        if (this.jPf != null) {
            this.jPf.cbY();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jPf = aVar;
    }

    public void cCU() {
        if (this.jPf != null) {
            cCX();
            if (this.akJ == null) {
                this.akJ = new c();
            }
            this.akJ.initListener();
            this.akJ.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void oK() {
                    if (a.this.akJ != null) {
                        a.this.akJ.onDestroy();
                    }
                }
            });
            this.akJ.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void xc() {
        if (this.jPf != null) {
            cCX();
        }
    }

    public boolean cCV() {
        if (this.jPf == null) {
            return false;
        }
        boolean cCX = cCX();
        if (!cCX) {
            this.jPf.cbY();
            return cCX;
        }
        return cCX;
    }

    public com.baidu.tieba.sdk.b.a cCW() {
        if (this.jPf != null) {
            return this.jPf.cbX();
        }
        return null;
    }

    private boolean cCX() {
        com.baidu.tieba.sdk.b.a cbX = this.jPf.cbX();
        if (cbX != null && cbX.isValid()) {
            cCY();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cDa();
        cCZ();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cCY() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cbX = this.jPf.cbX();
        if (cbX != null) {
            String string = com.baidu.live.c.oJ().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.oJ().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cbX.userId) && cbX.userId.equals(string);
            if (StringUtils.isNull(cbX.bduss) || !cbX.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0594a c0594a = new C0594a(currentAccountInfo);
                String string3 = com.baidu.live.c.oJ().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0594a.Ie(string3);
                } else {
                    c0594a.Ie(cbX.bduss);
                }
                String string4 = com.baidu.live.c.oJ().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0594a.If(string4);
                }
                c0594a.Ib(cbX.userId);
                c0594a.Ic(cbX.userName);
                c0594a.Id(cbX.nickName);
                c0594a.Ig(cbX.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0594a.cDb(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0594a.cDb();
                    return;
                }
            }
            this.jPe = 0;
            cCZ();
            C0594a c0594a2 = new C0594a();
            c0594a2.Ie(cbX.bduss);
            c0594a2.Ic(cbX.userName);
            c0594a2.Id(cbX.nickName);
            c0594a2.Ib(cbX.userId);
            c0594a2.Ig(cbX.portrait);
            com.baidu.live.c.oJ().putString("ala_account_user_id", cbX.userId);
            com.baidu.live.c.oJ().putString("ala_account_user_bduss", cbX.bduss);
            TbadkCoreApplication.setCurrentAccount(c0594a2.cDb(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cbX);
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

    private void cCZ() {
        com.baidu.live.c.oJ().remove("ala_account_user_id");
        com.baidu.live.c.oJ().remove("ala_account_user_bduss");
        com.baidu.live.c.oJ().remove("ala_account_user_tbs");
    }

    private void cDa() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0594a {
        private String BDUSS;
        private int jPj;
        private AccountData jPk;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0594a() {
            this.jPk = new AccountData();
        }

        public C0594a(AccountData accountData) {
            if (accountData == null) {
                this.jPk = new AccountData();
            } else {
                this.jPk = accountData;
            }
        }

        public C0594a Ib(String str) {
            this.userId = str;
            return this;
        }

        public C0594a Ic(String str) {
            this.userName = str;
            return this;
        }

        public C0594a Id(String str) {
            this.nickName = str;
            return this;
        }

        public C0594a Ie(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0594a If(String str) {
            this.tbs = str;
            return this;
        }

        public C0594a Ig(String str) {
            this.portrait = str;
            return this;
        }

        public C0594a Bh(int i) {
            this.sex = i;
            return this;
        }

        public C0594a Bi(int i) {
            this.jPj = i;
            return this;
        }

        public AccountData cDb() {
            this.jPk.setBDUSS(this.BDUSS);
            this.jPk.setAccount(this.userName);
            this.jPk.setDisplayName(this.nickName);
            this.jPk.setID(this.userId);
            this.jPk.setPortrait(this.portrait);
            this.jPk.setTbs(this.tbs);
            this.jPk.setSex(this.sex);
            this.jPk.setIsActive(this.jPj);
            return this.jPk;
        }
    }
}
