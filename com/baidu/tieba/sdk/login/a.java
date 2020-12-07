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
    private static volatile a mSS;
    private c bff;
    private int mST;
    private com.baidu.tieba.sdk.b.a mSU;
    private CustomMessageTask.CustomRunnable<Object> mSV = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.dfx();
            return null;
        }
    };
    private final HttpMessageListener mSW = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mST < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mSU.dfw());
                        return;
                    }
                    return;
                }
                a.this.mST = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mST;
        aVar.mST = i + 1;
        return i;
    }

    public static a dHz() {
        if (mSS == null) {
            synchronized (a.class) {
                if (mSS == null) {
                    mSS = new a();
                }
            }
        }
        return mSS;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mSV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mSW);
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

    public void dfx() {
        if (this.mSU != null) {
            this.mSU.dfx();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mSU = aVar;
    }

    public void dHA() {
        if (this.mSU != null) {
            dHD();
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
        if (this.mSU != null) {
            dHD();
        }
    }

    public boolean dHB() {
        if (this.mSU == null) {
            return false;
        }
        boolean dHD = dHD();
        if (!dHD) {
            this.mSU.dfx();
            return dHD;
        }
        return dHD;
    }

    public com.baidu.tieba.sdk.c.a dHC() {
        if (this.mSU != null) {
            return this.mSU.dfw();
        }
        return null;
    }

    private boolean dHD() {
        com.baidu.tieba.sdk.c.a dfw = this.mSU.dfw();
        if (dfw != null && dfw.isValid()) {
            dHE();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dHG();
        dHF();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dHE() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a dfw = this.mSU.dfw();
        if (dfw != null) {
            String string = d.BM().getString("ala_account_user_id", "");
            String string2 = d.BM().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(dfw.userId) && dfw.userId.equals(string);
            if (StringUtils.isNull(dfw.bduss) || !dfw.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0858a c0858a = new C0858a(currentAccountInfo);
                String string3 = d.BM().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0858a.SJ(string3);
                } else {
                    c0858a.SJ(dfw.bduss);
                }
                String string4 = d.BM().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0858a.SK(string4);
                }
                c0858a.SG(dfw.userId);
                c0858a.SH(dfw.userName);
                c0858a.SI(dfw.nickName);
                c0858a.SL(dfw.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0858a.dHH(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0858a.dHH();
                    return;
                }
            }
            this.mST = 0;
            dHF();
            C0858a c0858a2 = new C0858a();
            c0858a2.SJ(dfw.bduss);
            c0858a2.SH(dfw.userName);
            c0858a2.SI(dfw.nickName);
            c0858a2.SG(dfw.userId);
            c0858a2.SL(dfw.portrait);
            d.BM().putString("ala_account_user_id", dfw.userId);
            d.BM().putString("ala_account_user_bduss", dfw.bduss);
            TbadkCoreApplication.setCurrentAccount(c0858a2.dHH(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(dfw);
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

    private void dHF() {
        d.BM().remove("ala_account_user_id");
        d.BM().remove("ala_account_user_bduss");
        d.BM().remove("ala_account_user_tbs");
    }

    private void dHG() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0858a {
        private String BDUSS;
        private int mSY;
        private AccountData mSZ;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0858a() {
            this.mSZ = new AccountData();
        }

        public C0858a(AccountData accountData) {
            if (accountData == null) {
                this.mSZ = new AccountData();
            } else {
                this.mSZ = accountData;
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
            this.mSY = i;
            return this;
        }

        public AccountData dHH() {
            this.mSZ.setBDUSS(this.BDUSS);
            this.mSZ.setAccount(this.userName);
            this.mSZ.setDisplayName(this.nickName);
            this.mSZ.setID(this.userId);
            this.mSZ.setPortrait(this.portrait);
            this.mSZ.setTbs(this.tbs);
            this.mSZ.setSex(this.sex);
            this.mSZ.setIsActive(this.mSY);
            return this.mSZ;
        }
    }
}
