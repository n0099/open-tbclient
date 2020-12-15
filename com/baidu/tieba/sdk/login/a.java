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
import com.baidu.live.o.c;
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
    private static volatile a mSU;
    private c bff;
    private int mSV;
    private com.baidu.tieba.sdk.b.a mSW;
    private CustomMessageTask.CustomRunnable<Object> mSX = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.dfy();
            return null;
        }
    };
    private final HttpMessageListener mSY = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mSV < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mSW.dfx());
                        return;
                    }
                    return;
                }
                a.this.mSV = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mSV;
        aVar.mSV = i + 1;
        return i;
    }

    public static a dHA() {
        if (mSU == null) {
            synchronized (a.class) {
                if (mSU == null) {
                    mSU = new a();
                }
            }
        }
        return mSU;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mSX);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mSY);
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

    public void dfy() {
        if (this.mSW != null) {
            this.mSW.dfy();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mSW = aVar;
    }

    public void dHB() {
        if (this.mSW != null) {
            dHE();
            if (this.bff == null) {
                this.bff = new c();
            }
            this.bff.initListener();
            this.bff.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void BN() {
                    if (a.this.bff != null) {
                        a.this.bff.onDestroy();
                    }
                }
            });
            this.bff.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void UD() {
        if (this.mSW != null) {
            dHE();
        }
    }

    public boolean dHC() {
        if (this.mSW == null) {
            return false;
        }
        boolean dHE = dHE();
        if (!dHE) {
            this.mSW.dfy();
            return dHE;
        }
        return dHE;
    }

    public com.baidu.tieba.sdk.c.a dHD() {
        if (this.mSW != null) {
            return this.mSW.dfx();
        }
        return null;
    }

    private boolean dHE() {
        com.baidu.tieba.sdk.c.a dfx = this.mSW.dfx();
        if (dfx != null && dfx.isValid()) {
            dHF();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dHH();
        dHG();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dHF() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a dfx = this.mSW.dfx();
        if (dfx != null) {
            String string = d.BM().getString("ala_account_user_id", "");
            String string2 = d.BM().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(dfx.userId) && dfx.userId.equals(string);
            if (StringUtils.isNull(dfx.bduss) || !dfx.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0858a c0858a = new C0858a(currentAccountInfo);
                String string3 = d.BM().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0858a.SJ(string3);
                } else {
                    c0858a.SJ(dfx.bduss);
                }
                String string4 = d.BM().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0858a.SK(string4);
                }
                c0858a.SG(dfx.userId);
                c0858a.SH(dfx.userName);
                c0858a.SI(dfx.nickName);
                c0858a.SL(dfx.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0858a.dHI(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0858a.dHI();
                    return;
                }
            }
            this.mSV = 0;
            dHG();
            C0858a c0858a2 = new C0858a();
            c0858a2.SJ(dfx.bduss);
            c0858a2.SH(dfx.userName);
            c0858a2.SI(dfx.nickName);
            c0858a2.SG(dfx.userId);
            c0858a2.SL(dfx.portrait);
            d.BM().putString("ala_account_user_id", dfx.userId);
            d.BM().putString("ala_account_user_bduss", dfx.bduss);
            TbadkCoreApplication.setCurrentAccount(c0858a2.dHI(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(dfx);
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

    private void dHG() {
        d.BM().remove("ala_account_user_id");
        d.BM().remove("ala_account_user_bduss");
        d.BM().remove("ala_account_user_tbs");
    }

    private void dHH() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0858a {
        private String BDUSS;
        private int mTa;
        private AccountData mTb;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0858a() {
            this.mTb = new AccountData();
        }

        public C0858a(AccountData accountData) {
            if (accountData == null) {
                this.mTb = new AccountData();
            } else {
                this.mTb = accountData;
            }
        }

        public C0858a SG(String str) {
            this.userId = str;
            return this;
        }

        public C0858a SH(String str) {
            this.userName = str;
            return this;
        }

        public C0858a SI(String str) {
            this.nickName = str;
            return this;
        }

        public C0858a SJ(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0858a SK(String str) {
            this.tbs = str;
            return this;
        }

        public C0858a SL(String str) {
            this.portrait = str;
            return this;
        }

        public C0858a JK(int i) {
            this.sex = i;
            return this;
        }

        public C0858a JL(int i) {
            this.mTa = i;
            return this;
        }

        public AccountData dHI() {
            this.mTb.setBDUSS(this.BDUSS);
            this.mTb.setAccount(this.userName);
            this.mTb.setDisplayName(this.nickName);
            this.mTb.setID(this.userId);
            this.mTb.setPortrait(this.portrait);
            this.mTb.setTbs(this.tbs);
            this.mTb.setSex(this.sex);
            this.mTb.setIsActive(this.mTa);
            return this.mTb;
        }
    }
}
