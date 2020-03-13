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
    private static volatile a jQn;
    private c amW;
    private int jQo;
    private com.baidu.tieba.sdk.a.a jQp;
    private CustomMessageTask.CustomRunnable<Object> jQq = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cdF();
            return null;
        }
    };
    private final HttpMessageListener jQr = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jQo < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jQp.cdE());
                        return;
                    }
                    return;
                }
                a.this.jQo = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jQo;
        aVar.jQo = i + 1;
        return i;
    }

    public static a cEx() {
        if (jQn == null) {
            synchronized (a.class) {
                if (jQn == null) {
                    jQn = new a();
                }
            }
        }
        return jQn;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jQq);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jQr);
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

    public void cdF() {
        if (this.jQp != null) {
            this.jQp.cdF();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jQp = aVar;
    }

    public void cEy() {
        if (this.jQp != null) {
            cEB();
            if (this.amW == null) {
                this.amW = new c();
            }
            this.amW.initListener();
            this.amW.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void ps() {
                    if (a.this.amW != null) {
                        a.this.amW.onDestroy();
                    }
                }
            });
            this.amW.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void zw() {
        if (this.jQp != null) {
            cEB();
        }
    }

    public boolean cEz() {
        if (this.jQp == null) {
            return false;
        }
        boolean cEB = cEB();
        if (!cEB) {
            this.jQp.cdF();
            return cEB;
        }
        return cEB;
    }

    public com.baidu.tieba.sdk.b.a cEA() {
        if (this.jQp != null) {
            return this.jQp.cdE();
        }
        return null;
    }

    private boolean cEB() {
        com.baidu.tieba.sdk.b.a cdE = this.jQp.cdE();
        if (cdE != null && cdE.isValid()) {
            cEC();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cEE();
        cED();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cEC() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cdE = this.jQp.cdE();
        if (cdE != null) {
            String string = com.baidu.live.c.pr().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.pr().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cdE.userId) && cdE.userId.equals(string);
            if (StringUtils.isNull(cdE.bduss) || !cdE.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0601a c0601a = new C0601a(currentAccountInfo);
                String string3 = com.baidu.live.c.pr().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0601a.It(string3);
                } else {
                    c0601a.It(cdE.bduss);
                }
                String string4 = com.baidu.live.c.pr().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0601a.Iu(string4);
                }
                c0601a.Iq(cdE.userId);
                c0601a.Ir(cdE.userName);
                c0601a.Is(cdE.nickName);
                c0601a.Iv(cdE.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0601a.cEF(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0601a.cEF();
                    return;
                }
            }
            this.jQo = 0;
            cED();
            C0601a c0601a2 = new C0601a();
            c0601a2.It(cdE.bduss);
            c0601a2.Ir(cdE.userName);
            c0601a2.Is(cdE.nickName);
            c0601a2.Iq(cdE.userId);
            c0601a2.Iv(cdE.portrait);
            com.baidu.live.c.pr().putString("ala_account_user_id", cdE.userId);
            com.baidu.live.c.pr().putString("ala_account_user_bduss", cdE.bduss);
            TbadkCoreApplication.setCurrentAccount(c0601a2.cEF(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cdE);
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

    private void cED() {
        com.baidu.live.c.pr().remove("ala_account_user_id");
        com.baidu.live.c.pr().remove("ala_account_user_bduss");
        com.baidu.live.c.pr().remove("ala_account_user_tbs");
    }

    private void cEE() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0601a {
        private String BDUSS;
        private int jQt;
        private AccountData jQu;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0601a() {
            this.jQu = new AccountData();
        }

        public C0601a(AccountData accountData) {
            if (accountData == null) {
                this.jQu = new AccountData();
            } else {
                this.jQu = accountData;
            }
        }

        public C0601a Iq(String str) {
            this.userId = str;
            return this;
        }

        public C0601a Ir(String str) {
            this.userName = str;
            return this;
        }

        public C0601a Is(String str) {
            this.nickName = str;
            return this;
        }

        public C0601a It(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0601a Iu(String str) {
            this.tbs = str;
            return this;
        }

        public C0601a Iv(String str) {
            this.portrait = str;
            return this;
        }

        public C0601a Bq(int i) {
            this.sex = i;
            return this;
        }

        public C0601a Br(int i) {
            this.jQt = i;
            return this;
        }

        public AccountData cEF() {
            this.jQu.setBDUSS(this.BDUSS);
            this.jQu.setAccount(this.userName);
            this.jQu.setDisplayName(this.nickName);
            this.jQu.setID(this.userId);
            this.jQu.setPortrait(this.portrait);
            this.jQu.setTbs(this.tbs);
            this.jQu.setSex(this.sex);
            this.jQu.setIsActive(this.jQt);
            return this.jQu;
        }
    }
}
