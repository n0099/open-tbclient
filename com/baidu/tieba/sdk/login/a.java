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
import com.baidu.live.m.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes4.dex */
public class a {
    private static volatile a mEu;
    private c bcR;
    private int mEv;
    private com.baidu.tieba.sdk.b.a mEw;
    private CustomMessageTask.CustomRunnable<Object> mEx = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.daO();
            return null;
        }
    };
    private final HttpMessageListener mEy = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mEv < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mEw.daN());
                        return;
                    }
                    return;
                }
                a.this.mEv = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mEv;
        aVar.mEv = i + 1;
        return i;
    }

    public static a dCK() {
        if (mEu == null) {
            synchronized (a.class) {
                if (mEu == null) {
                    mEu = new a();
                }
            }
        }
        return mEu;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mEx);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mEy);
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

    public void daO() {
        if (this.mEw != null) {
            this.mEw.daO();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mEw = aVar;
    }

    public void dCL() {
        if (this.mEw != null) {
            dCO();
            if (this.bcR == null) {
                this.bcR = new c();
            }
            this.bcR.initListener();
            this.bcR.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void Ba() {
                    if (a.this.bcR != null) {
                        a.this.bcR.onDestroy();
                    }
                }
            });
            this.bcR.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void SO() {
        if (this.mEw != null) {
            dCO();
        }
    }

    public boolean dCM() {
        if (this.mEw == null) {
            return false;
        }
        boolean dCO = dCO();
        if (!dCO) {
            this.mEw.daO();
            return dCO;
        }
        return dCO;
    }

    public com.baidu.tieba.sdk.c.a dCN() {
        if (this.mEw != null) {
            return this.mEw.daN();
        }
        return null;
    }

    private boolean dCO() {
        com.baidu.tieba.sdk.c.a daN = this.mEw.daN();
        if (daN != null && daN.isValid()) {
            dCP();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dCR();
        dCQ();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dCP() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a daN = this.mEw.daN();
        if (daN != null) {
            String string = d.AZ().getString("ala_account_user_id", "");
            String string2 = d.AZ().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(daN.userId) && daN.userId.equals(string);
            if (StringUtils.isNull(daN.bduss) || !daN.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0841a c0841a = new C0841a(currentAccountInfo);
                String string3 = d.AZ().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0841a.RX(string3);
                } else {
                    c0841a.RX(daN.bduss);
                }
                String string4 = d.AZ().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0841a.RY(string4);
                }
                c0841a.RU(daN.userId);
                c0841a.RV(daN.userName);
                c0841a.RW(daN.nickName);
                c0841a.RZ(daN.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0841a.dCS(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0841a.dCS();
                    return;
                }
            }
            this.mEv = 0;
            dCQ();
            C0841a c0841a2 = new C0841a();
            c0841a2.RX(daN.bduss);
            c0841a2.RV(daN.userName);
            c0841a2.RW(daN.nickName);
            c0841a2.RU(daN.userId);
            c0841a2.RZ(daN.portrait);
            d.AZ().putString("ala_account_user_id", daN.userId);
            d.AZ().putString("ala_account_user_bduss", daN.bduss);
            TbadkCoreApplication.setCurrentAccount(c0841a2.dCS(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(daN);
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

    private void dCQ() {
        d.AZ().remove("ala_account_user_id");
        d.AZ().remove("ala_account_user_bduss");
        d.AZ().remove("ala_account_user_tbs");
    }

    private void dCR() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0841a {
        private String BDUSS;
        private int mEA;
        private AccountData mEB;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0841a() {
            this.mEB = new AccountData();
        }

        public C0841a(AccountData accountData) {
            if (accountData == null) {
                this.mEB = new AccountData();
            } else {
                this.mEB = accountData;
            }
        }

        public C0841a RU(String str) {
            this.userId = str;
            return this;
        }

        public C0841a RV(String str) {
            this.userName = str;
            return this;
        }

        public C0841a RW(String str) {
            this.nickName = str;
            return this;
        }

        public C0841a RX(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0841a RY(String str) {
            this.tbs = str;
            return this;
        }

        public C0841a RZ(String str) {
            this.portrait = str;
            return this;
        }

        public C0841a Is(int i) {
            this.sex = i;
            return this;
        }

        public C0841a It(int i) {
            this.mEA = i;
            return this;
        }

        public AccountData dCS() {
            this.mEB.setBDUSS(this.BDUSS);
            this.mEB.setAccount(this.userName);
            this.mEB.setDisplayName(this.nickName);
            this.mEB.setID(this.userId);
            this.mEB.setPortrait(this.portrait);
            this.mEB.setTbs(this.tbs);
            this.mEB.setSex(this.sex);
            this.mEB.setIsActive(this.mEA);
            return this.mEB;
        }
    }
}
