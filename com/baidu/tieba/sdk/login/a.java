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
import com.baidu.live.i.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes2.dex */
public class a {
    private static a jLv;
    private c ajY;
    private int jLw;
    private com.baidu.tieba.sdk.a.a jLx;
    private CustomMessageTask.CustomRunnable<Object> jLy = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.caP();
            return null;
        }
    };
    private final HttpMessageListener jLz = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jLw < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jLx.caO());
                        return;
                    }
                    return;
                }
                a.this.jLw = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jLw;
        aVar.jLw = i + 1;
        return i;
    }

    public static a cBN() {
        if (jLv == null) {
            synchronized (a.class) {
                if (jLv == null) {
                    jLv = new a();
                }
            }
        }
        return jLv;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jLy);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jLz);
        rG();
    }

    private void rG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void caP() {
        if (this.jLx != null) {
            this.jLx.caP();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jLx = aVar;
    }

    public void cBO() {
        if (this.jLx != null) {
            cBR();
            if (this.ajY == null) {
                this.ajY = new c();
            }
            this.ajY.initListener();
            this.ajY.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void oJ() {
                    if (a.this.ajY != null) {
                        a.this.ajY.onDestroy();
                    }
                }
            });
            this.ajY.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void wL() {
        if (this.jLx != null) {
            cBR();
        }
    }

    public boolean cBP() {
        if (this.jLx == null) {
            return false;
        }
        boolean cBR = cBR();
        if (!cBR) {
            this.jLx.caP();
            return cBR;
        }
        return cBR;
    }

    public com.baidu.tieba.sdk.b.a cBQ() {
        if (this.jLx != null) {
            return this.jLx.caO();
        }
        return null;
    }

    private boolean cBR() {
        com.baidu.tieba.sdk.b.a caO = this.jLx.caO();
        if (caO != null && caO.isValid()) {
            cBS();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cBU();
        cBT();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cBS() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a caO = this.jLx.caO();
        if (caO != null) {
            String string = com.baidu.live.c.oI().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.oI().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(caO.userId) && caO.userId.equals(string);
            if (StringUtils.isNull(caO.bduss) || !caO.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0589a c0589a = new C0589a(currentAccountInfo);
                String string3 = com.baidu.live.c.oI().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0589a.HU(string3);
                } else {
                    c0589a.HU(caO.bduss);
                }
                String string4 = com.baidu.live.c.oI().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0589a.HV(string4);
                }
                c0589a.HR(caO.userId);
                c0589a.HS(caO.userName);
                c0589a.HT(caO.nickName);
                c0589a.HW(caO.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0589a.cBV(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0589a.cBV();
                    return;
                }
            }
            this.jLw = 0;
            cBT();
            C0589a c0589a2 = new C0589a();
            c0589a2.HU(caO.bduss);
            c0589a2.HS(caO.userName);
            c0589a2.HT(caO.nickName);
            c0589a2.HR(caO.userId);
            c0589a2.HW(caO.portrait);
            com.baidu.live.c.oI().putString("ala_account_user_id", caO.userId);
            com.baidu.live.c.oI().putString("ala_account_user_bduss", caO.bduss);
            TbadkCoreApplication.setCurrentAccount(c0589a2.cBV(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(caO);
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

    private void cBT() {
        com.baidu.live.c.oI().remove("ala_account_user_id");
        com.baidu.live.c.oI().remove("ala_account_user_bduss");
        com.baidu.live.c.oI().remove("ala_account_user_tbs");
    }

    private void cBU() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0589a {
        private String BDUSS;
        private int jLB;
        private AccountData jLC;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0589a() {
            this.jLC = new AccountData();
        }

        public C0589a(AccountData accountData) {
            if (accountData == null) {
                this.jLC = new AccountData();
            } else {
                this.jLC = accountData;
            }
        }

        public C0589a HR(String str) {
            this.userId = str;
            return this;
        }

        public C0589a HS(String str) {
            this.userName = str;
            return this;
        }

        public C0589a HT(String str) {
            this.nickName = str;
            return this;
        }

        public C0589a HU(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0589a HV(String str) {
            this.tbs = str;
            return this;
        }

        public C0589a HW(String str) {
            this.portrait = str;
            return this;
        }

        public C0589a Bc(int i) {
            this.sex = i;
            return this;
        }

        public C0589a Bd(int i) {
            this.jLB = i;
            return this;
        }

        public AccountData cBV() {
            this.jLC.setBDUSS(this.BDUSS);
            this.jLC.setAccount(this.userName);
            this.jLC.setDisplayName(this.nickName);
            this.jLC.setID(this.userId);
            this.jLC.setPortrait(this.portrait);
            this.jLC.setTbs(this.tbs);
            this.jLC.setSex(this.sex);
            this.jLC.setIsActive(this.jLB);
            return this.jLC;
        }
    }
}
