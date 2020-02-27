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
    private static volatile a jPZ;
    private c amV;
    private int jQa;
    private com.baidu.tieba.sdk.a.a jQb;
    private CustomMessageTask.CustomRunnable<Object> jQc = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cdC();
            return null;
        }
    };
    private final HttpMessageListener jQd = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jQa < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jQb.cdB());
                        return;
                    }
                    return;
                }
                a.this.jQa = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jQa;
        aVar.jQa = i + 1;
        return i;
    }

    public static a cEu() {
        if (jPZ == null) {
            synchronized (a.class) {
                if (jPZ == null) {
                    jPZ = new a();
                }
            }
        }
        return jPZ;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jQc);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jQd);
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

    public void cdC() {
        if (this.jQb != null) {
            this.jQb.cdC();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jQb = aVar;
    }

    public void cEv() {
        if (this.jQb != null) {
            cEy();
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

    public void zu() {
        if (this.jQb != null) {
            cEy();
        }
    }

    public boolean cEw() {
        if (this.jQb == null) {
            return false;
        }
        boolean cEy = cEy();
        if (!cEy) {
            this.jQb.cdC();
            return cEy;
        }
        return cEy;
    }

    public com.baidu.tieba.sdk.b.a cEx() {
        if (this.jQb != null) {
            return this.jQb.cdB();
        }
        return null;
    }

    private boolean cEy() {
        com.baidu.tieba.sdk.b.a cdB = this.jQb.cdB();
        if (cdB != null && cdB.isValid()) {
            cEz();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cEB();
        cEA();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cEz() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cdB = this.jQb.cdB();
        if (cdB != null) {
            String string = com.baidu.live.c.pr().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.pr().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cdB.userId) && cdB.userId.equals(string);
            if (StringUtils.isNull(cdB.bduss) || !cdB.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0601a c0601a = new C0601a(currentAccountInfo);
                String string3 = com.baidu.live.c.pr().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0601a.Is(string3);
                } else {
                    c0601a.Is(cdB.bduss);
                }
                String string4 = com.baidu.live.c.pr().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0601a.It(string4);
                }
                c0601a.Ip(cdB.userId);
                c0601a.Iq(cdB.userName);
                c0601a.Ir(cdB.nickName);
                c0601a.Iu(cdB.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0601a.cEC(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0601a.cEC();
                    return;
                }
            }
            this.jQa = 0;
            cEA();
            C0601a c0601a2 = new C0601a();
            c0601a2.Is(cdB.bduss);
            c0601a2.Iq(cdB.userName);
            c0601a2.Ir(cdB.nickName);
            c0601a2.Ip(cdB.userId);
            c0601a2.Iu(cdB.portrait);
            com.baidu.live.c.pr().putString("ala_account_user_id", cdB.userId);
            com.baidu.live.c.pr().putString("ala_account_user_bduss", cdB.bduss);
            TbadkCoreApplication.setCurrentAccount(c0601a2.cEC(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cdB);
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

    private void cEA() {
        com.baidu.live.c.pr().remove("ala_account_user_id");
        com.baidu.live.c.pr().remove("ala_account_user_bduss");
        com.baidu.live.c.pr().remove("ala_account_user_tbs");
    }

    private void cEB() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0601a {
        private String BDUSS;
        private int jQf;
        private AccountData jQg;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0601a() {
            this.jQg = new AccountData();
        }

        public C0601a(AccountData accountData) {
            if (accountData == null) {
                this.jQg = new AccountData();
            } else {
                this.jQg = accountData;
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
            this.jQf = i;
            return this;
        }

        public AccountData cEC() {
            this.jQg.setBDUSS(this.BDUSS);
            this.jQg.setAccount(this.userName);
            this.jQg.setDisplayName(this.nickName);
            this.jQg.setID(this.userId);
            this.jQg.setPortrait(this.portrait);
            this.jQg.setTbs(this.tbs);
            this.jQg.setSex(this.sex);
            this.jQg.setIsActive(this.jQf);
            return this.jQg;
        }
    }
}
