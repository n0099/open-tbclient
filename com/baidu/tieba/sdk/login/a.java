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
/* loaded from: classes4.dex */
public class a {
    private static volatile a lWm;
    private c aWS;
    private int lWn;
    private com.baidu.tieba.sdk.b.a lWo;
    private CustomMessageTask.CustomRunnable<Object> lWp = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cRv();
            return null;
        }
    };
    private final HttpMessageListener lWq = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.lWn < 3) {
                        a.b(a.this);
                        a.this.a(a.this.lWo.cRu());
                        return;
                    }
                    return;
                }
                a.this.lWn = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.lWn;
        aVar.lWn = i + 1;
        return i;
    }

    public static a dtp() {
        if (lWm == null) {
            synchronized (a.class) {
                if (lWm == null) {
                    lWm = new a();
                }
            }
        }
        return lWm;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.lWp);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.lWq);
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

    public void cRv() {
        if (this.lWo != null) {
            this.lWo.cRv();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.lWo = aVar;
    }

    public void dtq() {
        if (this.lWo != null) {
            dtt();
            if (this.aWS == null) {
                this.aWS = new c();
            }
            this.aWS.initListener();
            this.aWS.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void AS() {
                    if (a.this.aWS != null) {
                        a.this.aWS.onDestroy();
                    }
                }
            });
            this.aWS.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Og() {
        if (this.lWo != null) {
            dtt();
        }
    }

    public boolean dtr() {
        if (this.lWo == null) {
            return false;
        }
        boolean dtt = dtt();
        if (!dtt) {
            this.lWo.cRv();
            return dtt;
        }
        return dtt;
    }

    public com.baidu.tieba.sdk.c.a dts() {
        if (this.lWo != null) {
            return this.lWo.cRu();
        }
        return null;
    }

    private boolean dtt() {
        com.baidu.tieba.sdk.c.a cRu = this.lWo.cRu();
        if (cRu != null && cRu.isValid()) {
            dtu();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dtw();
        dtv();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dtu() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cRu = this.lWo.cRu();
        if (cRu != null) {
            String string = com.baidu.live.c.AR().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.AR().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cRu.userId) && cRu.userId.equals(string);
            if (StringUtils.isNull(cRu.bduss) || !cRu.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0793a c0793a = new C0793a(currentAccountInfo);
                String string3 = com.baidu.live.c.AR().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0793a.Qt(string3);
                } else {
                    c0793a.Qt(cRu.bduss);
                }
                String string4 = com.baidu.live.c.AR().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0793a.Qu(string4);
                }
                c0793a.Qq(cRu.userId);
                c0793a.Qr(cRu.userName);
                c0793a.Qs(cRu.nickName);
                c0793a.Qv(cRu.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0793a.dtx(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0793a.dtx();
                    return;
                }
            }
            this.lWn = 0;
            dtv();
            C0793a c0793a2 = new C0793a();
            c0793a2.Qt(cRu.bduss);
            c0793a2.Qr(cRu.userName);
            c0793a2.Qs(cRu.nickName);
            c0793a2.Qq(cRu.userId);
            c0793a2.Qv(cRu.portrait);
            com.baidu.live.c.AR().putString("ala_account_user_id", cRu.userId);
            com.baidu.live.c.AR().putString("ala_account_user_bduss", cRu.bduss);
            TbadkCoreApplication.setCurrentAccount(c0793a2.dtx(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cRu);
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

    private void dtv() {
        com.baidu.live.c.AR().remove("ala_account_user_id");
        com.baidu.live.c.AR().remove("ala_account_user_bduss");
        com.baidu.live.c.AR().remove("ala_account_user_tbs");
    }

    private void dtw() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0793a {
        private String BDUSS;
        private int lWs;
        private AccountData lWt;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0793a() {
            this.lWt = new AccountData();
        }

        public C0793a(AccountData accountData) {
            if (accountData == null) {
                this.lWt = new AccountData();
            } else {
                this.lWt = accountData;
            }
        }

        public C0793a Qq(String str) {
            this.userId = str;
            return this;
        }

        public C0793a Qr(String str) {
            this.userName = str;
            return this;
        }

        public C0793a Qs(String str) {
            this.nickName = str;
            return this;
        }

        public C0793a Qt(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0793a Qu(String str) {
            this.tbs = str;
            return this;
        }

        public C0793a Qv(String str) {
            this.portrait = str;
            return this;
        }

        public C0793a Hg(int i) {
            this.sex = i;
            return this;
        }

        public C0793a Hh(int i) {
            this.lWs = i;
            return this;
        }

        public AccountData dtx() {
            this.lWt.setBDUSS(this.BDUSS);
            this.lWt.setAccount(this.userName);
            this.lWt.setDisplayName(this.nickName);
            this.lWt.setID(this.userId);
            this.lWt.setPortrait(this.portrait);
            this.lWt.setTbs(this.tbs);
            this.lWt.setSex(this.sex);
            this.lWt.setIsActive(this.lWs);
            return this.lWt;
        }
    }
}
