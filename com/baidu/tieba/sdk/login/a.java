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
    private static volatile a jRP;
    private c ang;
    private int jRQ;
    private com.baidu.tieba.sdk.a.a jRR;
    private CustomMessageTask.CustomRunnable<Object> jRS = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cdY();
            return null;
        }
    };
    private final HttpMessageListener jRT = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jRQ < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jRR.cdX());
                        return;
                    }
                    return;
                }
                a.this.jRQ = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jRQ;
        aVar.jRQ = i + 1;
        return i;
    }

    public static a cER() {
        if (jRP == null) {
            synchronized (a.class) {
                if (jRP == null) {
                    jRP = new a();
                }
            }
        }
        return jRP;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jRS);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jRT);
        tj();
    }

    private void tj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cdY() {
        if (this.jRR != null) {
            this.jRR.cdY();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jRR = aVar;
    }

    public void cES() {
        if (this.jRR != null) {
            cEV();
            if (this.ang == null) {
                this.ang = new c();
            }
            this.ang.initListener();
            this.ang.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void px() {
                    if (a.this.ang != null) {
                        a.this.ang.onDestroy();
                    }
                }
            });
            this.ang.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void zD() {
        if (this.jRR != null) {
            cEV();
        }
    }

    public boolean cET() {
        if (this.jRR == null) {
            return false;
        }
        boolean cEV = cEV();
        if (!cEV) {
            this.jRR.cdY();
            return cEV;
        }
        return cEV;
    }

    public com.baidu.tieba.sdk.b.a cEU() {
        if (this.jRR != null) {
            return this.jRR.cdX();
        }
        return null;
    }

    private boolean cEV() {
        com.baidu.tieba.sdk.b.a cdX = this.jRR.cdX();
        if (cdX != null && cdX.isValid()) {
            cEW();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cEY();
        cEX();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cEW() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cdX = this.jRR.cdX();
        if (cdX != null) {
            String string = com.baidu.live.c.pw().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.pw().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cdX.userId) && cdX.userId.equals(string);
            if (StringUtils.isNull(cdX.bduss) || !cdX.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0602a c0602a = new C0602a(currentAccountInfo);
                String string3 = com.baidu.live.c.pw().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0602a.Is(string3);
                } else {
                    c0602a.Is(cdX.bduss);
                }
                String string4 = com.baidu.live.c.pw().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0602a.It(string4);
                }
                c0602a.Ip(cdX.userId);
                c0602a.Iq(cdX.userName);
                c0602a.Ir(cdX.nickName);
                c0602a.Iu(cdX.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0602a.cEZ(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0602a.cEZ();
                    return;
                }
            }
            this.jRQ = 0;
            cEX();
            C0602a c0602a2 = new C0602a();
            c0602a2.Is(cdX.bduss);
            c0602a2.Iq(cdX.userName);
            c0602a2.Ir(cdX.nickName);
            c0602a2.Ip(cdX.userId);
            c0602a2.Iu(cdX.portrait);
            com.baidu.live.c.pw().putString("ala_account_user_id", cdX.userId);
            com.baidu.live.c.pw().putString("ala_account_user_bduss", cdX.bduss);
            TbadkCoreApplication.setCurrentAccount(c0602a2.cEZ(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cdX);
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

    private void cEX() {
        com.baidu.live.c.pw().remove("ala_account_user_id");
        com.baidu.live.c.pw().remove("ala_account_user_bduss");
        com.baidu.live.c.pw().remove("ala_account_user_tbs");
    }

    private void cEY() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0602a {
        private String BDUSS;
        private int jRV;
        private AccountData jRW;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0602a() {
            this.jRW = new AccountData();
        }

        public C0602a(AccountData accountData) {
            if (accountData == null) {
                this.jRW = new AccountData();
            } else {
                this.jRW = accountData;
            }
        }

        public C0602a Ip(String str) {
            this.userId = str;
            return this;
        }

        public C0602a Iq(String str) {
            this.userName = str;
            return this;
        }

        public C0602a Ir(String str) {
            this.nickName = str;
            return this;
        }

        public C0602a Is(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0602a It(String str) {
            this.tbs = str;
            return this;
        }

        public C0602a Iu(String str) {
            this.portrait = str;
            return this;
        }

        public C0602a By(int i) {
            this.sex = i;
            return this;
        }

        public C0602a Bz(int i) {
            this.jRV = i;
            return this;
        }

        public AccountData cEZ() {
            this.jRW.setBDUSS(this.BDUSS);
            this.jRW.setAccount(this.userName);
            this.jRW.setDisplayName(this.nickName);
            this.jRW.setID(this.userId);
            this.jRW.setPortrait(this.portrait);
            this.jRW.setTbs(this.tbs);
            this.jRW.setSex(this.sex);
            this.jRW.setIsActive(this.jRV);
            return this.jRW;
        }
    }
}
