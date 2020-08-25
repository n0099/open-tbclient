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
import com.baidu.live.l.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes7.dex */
public class a {
    private static volatile a lMX;
    private c aUB;
    private int lMY;
    private com.baidu.tieba.sdk.b.a lMZ;
    private CustomMessageTask.CustomRunnable<Object> lNa = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cNP();
            return null;
        }
    };
    private final HttpMessageListener lNb = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.lMY < 3) {
                        a.b(a.this);
                        a.this.a(a.this.lMZ.cNO());
                        return;
                    }
                    return;
                }
                a.this.lMY = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.lMY;
        aVar.lMY = i + 1;
        return i;
    }

    public static a dpz() {
        if (lMX == null) {
            synchronized (a.class) {
                if (lMX == null) {
                    lMX = new a();
                }
            }
        }
        return lMX;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.lNa);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.lNb);
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

    public void cNP() {
        if (this.lMZ != null) {
            this.lMZ.cNP();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.lMZ = aVar;
    }

    public void dpA() {
        if (this.lMZ != null) {
            dpD();
            if (this.aUB == null) {
                this.aUB = new c();
            }
            this.aUB.initListener();
            this.aUB.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void AE() {
                    if (a.this.aUB != null) {
                        a.this.aUB.onDestroy();
                    }
                }
            });
            this.aUB.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void ND() {
        if (this.lMZ != null) {
            dpD();
        }
    }

    public boolean dpB() {
        if (this.lMZ == null) {
            return false;
        }
        boolean dpD = dpD();
        if (!dpD) {
            this.lMZ.cNP();
            return dpD;
        }
        return dpD;
    }

    public com.baidu.tieba.sdk.c.a dpC() {
        if (this.lMZ != null) {
            return this.lMZ.cNO();
        }
        return null;
    }

    private boolean dpD() {
        com.baidu.tieba.sdk.c.a cNO = this.lMZ.cNO();
        if (cNO != null && cNO.isValid()) {
            dpE();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dpG();
        dpF();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dpE() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cNO = this.lMZ.cNO();
        if (cNO != null) {
            String string = com.baidu.live.c.AD().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.AD().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cNO.userId) && cNO.userId.equals(string);
            if (StringUtils.isNull(cNO.bduss) || !cNO.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0796a c0796a = new C0796a(currentAccountInfo);
                String string3 = com.baidu.live.c.AD().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0796a.PT(string3);
                } else {
                    c0796a.PT(cNO.bduss);
                }
                String string4 = com.baidu.live.c.AD().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0796a.PU(string4);
                }
                c0796a.PQ(cNO.userId);
                c0796a.PR(cNO.userName);
                c0796a.PS(cNO.nickName);
                c0796a.PV(cNO.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0796a.dpH(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0796a.dpH();
                    return;
                }
            }
            this.lMY = 0;
            dpF();
            C0796a c0796a2 = new C0796a();
            c0796a2.PT(cNO.bduss);
            c0796a2.PR(cNO.userName);
            c0796a2.PS(cNO.nickName);
            c0796a2.PQ(cNO.userId);
            c0796a2.PV(cNO.portrait);
            com.baidu.live.c.AD().putString("ala_account_user_id", cNO.userId);
            com.baidu.live.c.AD().putString("ala_account_user_bduss", cNO.bduss);
            TbadkCoreApplication.setCurrentAccount(c0796a2.dpH(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cNO);
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

    private void dpF() {
        com.baidu.live.c.AD().remove("ala_account_user_id");
        com.baidu.live.c.AD().remove("ala_account_user_bduss");
        com.baidu.live.c.AD().remove("ala_account_user_tbs");
    }

    private void dpG() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0796a {
        private String BDUSS;
        private int lNd;
        private AccountData lNe;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0796a() {
            this.lNe = new AccountData();
        }

        public C0796a(AccountData accountData) {
            if (accountData == null) {
                this.lNe = new AccountData();
            } else {
                this.lNe = accountData;
            }
        }

        public C0796a PQ(String str) {
            this.userId = str;
            return this;
        }

        public C0796a PR(String str) {
            this.userName = str;
            return this;
        }

        public C0796a PS(String str) {
            this.nickName = str;
            return this;
        }

        public C0796a PT(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0796a PU(String str) {
            this.tbs = str;
            return this;
        }

        public C0796a PV(String str) {
            this.portrait = str;
            return this;
        }

        public C0796a GF(int i) {
            this.sex = i;
            return this;
        }

        public C0796a GG(int i) {
            this.lNd = i;
            return this;
        }

        public AccountData dpH() {
            this.lNe.setBDUSS(this.BDUSS);
            this.lNe.setAccount(this.userName);
            this.lNe.setDisplayName(this.nickName);
            this.lNe.setID(this.userId);
            this.lNe.setPortrait(this.portrait);
            this.lNe.setTbs(this.tbs);
            this.lNe.setSex(this.sex);
            this.lNe.setIsActive(this.lNd);
            return this.lNe;
        }
    }
}
