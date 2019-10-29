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
    private static a iRS;
    private b acu;
    private int iRT;
    private com.baidu.tieba.sdk.a.a iRU;
    private CustomMessageTask.CustomRunnable<Object> iRV = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.bJE();
            return null;
        }
    };
    private final HttpMessageListener iRW = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.iRT < 3) {
                        a.b(a.this);
                        a.this.a(a.this.iRU.bJD());
                        return;
                    }
                    return;
                }
                a.this.iRT = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.iRT;
        aVar.iRT = i + 1;
        return i;
    }

    public static a chN() {
        if (iRS == null) {
            synchronized (a.class) {
                if (iRS == null) {
                    iRS = new a();
                }
            }
        }
        return iRS;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.iRV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.iRW);
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

    public void bJE() {
        if (this.iRU != null) {
            this.iRU.bJE();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.iRU = aVar;
    }

    public void chO() {
        if (this.iRU != null) {
            chR();
            if (this.acu == null) {
                this.acu = new b();
            }
            this.acu.initListener();
            this.acu.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void nq() {
                    if (a.this.acu != null) {
                        a.this.acu.onDestroy();
                    }
                }
            });
            this.acu.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void uM() {
        if (this.iRU != null) {
            chR();
        }
    }

    public boolean chP() {
        if (this.iRU == null) {
            return false;
        }
        boolean chR = chR();
        if (!chR) {
            this.iRU.bJE();
            return chR;
        }
        return chR;
    }

    public com.baidu.tieba.sdk.b.a chQ() {
        if (this.iRU != null) {
            return this.iRU.bJD();
        }
        return null;
    }

    private boolean chR() {
        com.baidu.tieba.sdk.b.a bJD = this.iRU.bJD();
        if (bJD != null && bJD.isValid()) {
            chS();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        chU();
        chT();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void chS() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a bJD = this.iRU.bJD();
        if (bJD != null) {
            String string = c.np().getString("ala_account_user_id", "");
            String string2 = c.np().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(bJD.userId) && bJD.userId.equals(string);
            if (StringUtils.isNull(bJD.bduss) || !bJD.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0510a c0510a = new C0510a(currentAccountInfo);
                String string3 = c.np().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0510a.Dh(string3);
                } else {
                    c0510a.Dh(bJD.bduss);
                }
                String string4 = c.np().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0510a.Di(string4);
                }
                c0510a.De(bJD.userId);
                c0510a.Df(bJD.userName);
                c0510a.Dg(bJD.nickName);
                c0510a.Dj(bJD.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0510a.chV(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0510a.chV();
                    return;
                }
            }
            this.iRT = 0;
            chT();
            C0510a c0510a2 = new C0510a();
            c0510a2.Dh(bJD.bduss);
            c0510a2.Df(bJD.userName);
            c0510a2.Dg(bJD.nickName);
            c0510a2.De(bJD.userId);
            c0510a2.Dj(bJD.portrait);
            c.np().putString("ala_account_user_id", bJD.userId);
            c.np().putString("ala_account_user_bduss", bJD.bduss);
            TbadkCoreApplication.setCurrentAccount(c0510a2.chV(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(bJD);
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

    private void chT() {
        c.np().remove("ala_account_user_id");
        c.np().remove("ala_account_user_bduss");
        c.np().remove("ala_account_user_tbs");
    }

    private void chU() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0510a {
        private String BDUSS;
        private int iRY;
        private AccountData iRZ;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0510a() {
            this.iRZ = new AccountData();
        }

        public C0510a(AccountData accountData) {
            if (accountData == null) {
                this.iRZ = new AccountData();
            } else {
                this.iRZ = accountData;
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

        public C0510a yI(int i) {
            this.sex = i;
            return this;
        }

        public C0510a yJ(int i) {
            this.iRY = i;
            return this;
        }

        public AccountData chV() {
            this.iRZ.setBDUSS(this.BDUSS);
            this.iRZ.setAccount(this.userName);
            this.iRZ.setDisplayName(this.nickName);
            this.iRZ.setID(this.userId);
            this.iRZ.setPortrait(this.portrait);
            this.iRZ.setTbs(this.tbs);
            this.iRZ.setSex(this.sex);
            this.iRZ.setIsActive(this.iRY);
            return this.iRZ;
        }
    }
}
