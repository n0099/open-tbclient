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
    private static volatile a jQb;
    private c amV;
    private int jQc;
    private com.baidu.tieba.sdk.a.a jQd;
    private CustomMessageTask.CustomRunnable<Object> jQe = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cdE();
            return null;
        }
    };
    private final HttpMessageListener jQf = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jQc < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jQd.cdD());
                        return;
                    }
                    return;
                }
                a.this.jQc = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jQc;
        aVar.jQc = i + 1;
        return i;
    }

    public static a cEw() {
        if (jQb == null) {
            synchronized (a.class) {
                if (jQb == null) {
                    jQb = new a();
                }
            }
        }
        return jQb;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jQe);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jQf);
        te();
    }

    private void te() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cdE() {
        if (this.jQd != null) {
            this.jQd.cdE();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jQd = aVar;
    }

    public void cEx() {
        if (this.jQd != null) {
            cEA();
            if (this.amV == null) {
                this.amV = new c();
            }
            this.amV.initListener();
            this.amV.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void ps() {
                    if (a.this.amV != null) {
                        a.this.amV.onDestroy();
                    }
                }
            });
            this.amV.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void zw() {
        if (this.jQd != null) {
            cEA();
        }
    }

    public boolean cEy() {
        if (this.jQd == null) {
            return false;
        }
        boolean cEA = cEA();
        if (!cEA) {
            this.jQd.cdE();
            return cEA;
        }
        return cEA;
    }

    public com.baidu.tieba.sdk.b.a cEz() {
        if (this.jQd != null) {
            return this.jQd.cdD();
        }
        return null;
    }

    private boolean cEA() {
        com.baidu.tieba.sdk.b.a cdD = this.jQd.cdD();
        if (cdD != null && cdD.isValid()) {
            cEB();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cED();
        cEC();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cEB() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cdD = this.jQd.cdD();
        if (cdD != null) {
            String string = com.baidu.live.c.pr().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.pr().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cdD.userId) && cdD.userId.equals(string);
            if (StringUtils.isNull(cdD.bduss) || !cdD.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0601a c0601a = new C0601a(currentAccountInfo);
                String string3 = com.baidu.live.c.pr().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0601a.Is(string3);
                } else {
                    c0601a.Is(cdD.bduss);
                }
                String string4 = com.baidu.live.c.pr().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0601a.It(string4);
                }
                c0601a.Ip(cdD.userId);
                c0601a.Iq(cdD.userName);
                c0601a.Ir(cdD.nickName);
                c0601a.Iu(cdD.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0601a.cEE(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0601a.cEE();
                    return;
                }
            }
            this.jQc = 0;
            cEC();
            C0601a c0601a2 = new C0601a();
            c0601a2.Is(cdD.bduss);
            c0601a2.Iq(cdD.userName);
            c0601a2.Ir(cdD.nickName);
            c0601a2.Ip(cdD.userId);
            c0601a2.Iu(cdD.portrait);
            com.baidu.live.c.pr().putString("ala_account_user_id", cdD.userId);
            com.baidu.live.c.pr().putString("ala_account_user_bduss", cdD.bduss);
            TbadkCoreApplication.setCurrentAccount(c0601a2.cEE(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cdD);
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

    private void cEC() {
        com.baidu.live.c.pr().remove("ala_account_user_id");
        com.baidu.live.c.pr().remove("ala_account_user_bduss");
        com.baidu.live.c.pr().remove("ala_account_user_tbs");
    }

    private void cED() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0601a {
        private String BDUSS;
        private int jQh;
        private AccountData jQi;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0601a() {
            this.jQi = new AccountData();
        }

        public C0601a(AccountData accountData) {
            if (accountData == null) {
                this.jQi = new AccountData();
            } else {
                this.jQi = accountData;
            }
        }

        public C0601a Ip(String str) {
            this.userId = str;
            return this;
        }

        public C0601a Iq(String str) {
            this.userName = str;
            return this;
        }

        public C0601a Ir(String str) {
            this.nickName = str;
            return this;
        }

        public C0601a Is(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0601a It(String str) {
            this.tbs = str;
            return this;
        }

        public C0601a Iu(String str) {
            this.portrait = str;
            return this;
        }

        public C0601a Bq(int i) {
            this.sex = i;
            return this;
        }

        public C0601a Br(int i) {
            this.jQh = i;
            return this;
        }

        public AccountData cEE() {
            this.jQi.setBDUSS(this.BDUSS);
            this.jQi.setAccount(this.userName);
            this.jQi.setDisplayName(this.nickName);
            this.jQi.setID(this.userId);
            this.jQi.setPortrait(this.portrait);
            this.jQi.setTbs(this.tbs);
            this.jQi.setSex(this.sex);
            this.jQi.setIsActive(this.jQh);
            return this.jQi;
        }
    }
}
