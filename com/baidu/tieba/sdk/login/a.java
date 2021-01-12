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
import com.baidu.live.p.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes10.dex */
public class a {
    private static volatile a mTL;
    private c bbX;
    private int mTM;
    private com.baidu.tieba.sdk.b.a mTN;
    private CustomMessageTask.CustomRunnable<Object> mTO = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.dbt();
            return null;
        }
    };
    private final HttpMessageListener mTP = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mTM < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mTN.dbs());
                        return;
                    }
                    return;
                }
                a.this.mTM = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mTM;
        aVar.mTM = i + 1;
        return i;
    }

    public static a dDz() {
        if (mTL == null) {
            synchronized (a.class) {
                if (mTL == null) {
                    mTL = new a();
                }
            }
        }
        return mTL;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mTO);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mTP);
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

    public void dbt() {
        if (this.mTN != null) {
            this.mTN.dbt();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mTN = aVar;
    }

    public void dDA() {
        if (this.mTN != null) {
            dDD();
            if (this.bbX == null) {
                this.bbX = new c();
            }
            this.bbX.initListener();
            this.bbX.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void xg() {
                    if (a.this.bbX != null) {
                        a.this.bbX.onDestroy();
                    }
                }
            });
            this.bbX.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void RP() {
        if (this.mTN != null) {
            dDD();
        }
    }

    public boolean dDB() {
        if (this.mTN == null) {
            return false;
        }
        boolean dDD = dDD();
        if (!dDD) {
            this.mTN.dbt();
            return dDD;
        }
        return dDD;
    }

    public com.baidu.tieba.sdk.c.a dDC() {
        if (this.mTN != null) {
            return this.mTN.dbs();
        }
        return null;
    }

    private boolean dDD() {
        com.baidu.tieba.sdk.c.a dbs = this.mTN.dbs();
        if (dbs != null && dbs.isValid()) {
            dDE();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dDG();
        dDF();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dDE() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a dbs = this.mTN.dbs();
        if (dbs != null) {
            String string = d.xf().getString("ala_account_user_id", "");
            String string2 = d.xf().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(dbs.userId) && dbs.userId.equals(string);
            if (StringUtils.isNull(dbs.bduss) || !dbs.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0858a c0858a = new C0858a(currentAccountInfo);
                String string3 = d.xf().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0858a.Rj(string3);
                } else {
                    c0858a.Rj(dbs.bduss);
                }
                String string4 = d.xf().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0858a.Rk(string4);
                }
                c0858a.Rg(dbs.userId);
                c0858a.Rh(dbs.userName);
                c0858a.Ri(dbs.nickName);
                c0858a.Rl(dbs.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0858a.dDH(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0858a.dDH();
                    return;
                }
            }
            this.mTM = 0;
            dDF();
            C0858a c0858a2 = new C0858a();
            c0858a2.Rj(dbs.bduss);
            c0858a2.Rh(dbs.userName);
            c0858a2.Ri(dbs.nickName);
            c0858a2.Rg(dbs.userId);
            c0858a2.Rl(dbs.portrait);
            d.xf().putString("ala_account_user_id", dbs.userId);
            d.xf().putString("ala_account_user_bduss", dbs.bduss);
            TbadkCoreApplication.setCurrentAccount(c0858a2.dDH(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(dbs);
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

    private void dDF() {
        d.xf().remove("ala_account_user_id");
        d.xf().remove("ala_account_user_bduss");
        d.xf().remove("ala_account_user_tbs");
    }

    private void dDG() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0858a {
        private String BDUSS;
        private int mTR;
        private AccountData mTS;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0858a() {
            this.mTS = new AccountData();
        }

        public C0858a(AccountData accountData) {
            if (accountData == null) {
                this.mTS = new AccountData();
            } else {
                this.mTS = accountData;
            }
        }

        public C0858a Rg(String str) {
            this.userId = str;
            return this;
        }

        public C0858a Rh(String str) {
            this.userName = str;
            return this;
        }

        public C0858a Ri(String str) {
            this.nickName = str;
            return this;
        }

        public C0858a Rj(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0858a Rk(String str) {
            this.tbs = str;
            return this;
        }

        public C0858a Rl(String str) {
            this.portrait = str;
            return this;
        }

        public C0858a HX(int i) {
            this.sex = i;
            return this;
        }

        public C0858a HY(int i) {
            this.mTR = i;
            return this;
        }

        public AccountData dDH() {
            this.mTS.setBDUSS(this.BDUSS);
            this.mTS.setAccount(this.userName);
            this.mTS.setDisplayName(this.nickName);
            this.mTS.setID(this.userId);
            this.mTS.setPortrait(this.portrait);
            this.mTS.setTbs(this.tbs);
            this.mTS.setSex(this.sex);
            this.mTS.setIsActive(this.mTR);
            return this.mTS;
        }
    }
}
