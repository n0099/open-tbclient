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
    private static volatile a kBi;
    private c aFE;
    private int kBj;
    private com.baidu.tieba.sdk.a.a kBk;
    private CustomMessageTask.CustomRunnable<Object> kBl = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cox();
            return null;
        }
    };
    private final HttpMessageListener kBm = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.kBj < 3) {
                        a.b(a.this);
                        a.this.a(a.this.kBk.cow());
                        return;
                    }
                    return;
                }
                a.this.kBj = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.kBj;
        aVar.kBj = i + 1;
        return i;
    }

    public static a cPr() {
        if (kBi == null) {
            synchronized (a.class) {
                if (kBi == null) {
                    kBi = new a();
                }
            }
        }
        return kBi;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.kBl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.kBm);
        xB();
    }

    private void xB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cox() {
        if (this.kBk != null) {
            this.kBk.cox();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.kBk = aVar;
    }

    public void cPs() {
        if (this.kBk != null) {
            cPv();
            if (this.aFE == null) {
                this.aFE = new c();
            }
            this.aFE.initListener();
            this.aFE.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void tH() {
                    if (a.this.aFE != null) {
                        a.this.aFE.onDestroy();
                    }
                }
            });
            this.aFE.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void EA() {
        if (this.kBk != null) {
            cPv();
        }
    }

    public boolean cPt() {
        if (this.kBk == null) {
            return false;
        }
        boolean cPv = cPv();
        if (!cPv) {
            this.kBk.cox();
            return cPv;
        }
        return cPv;
    }

    public com.baidu.tieba.sdk.b.a cPu() {
        if (this.kBk != null) {
            return this.kBk.cow();
        }
        return null;
    }

    private boolean cPv() {
        com.baidu.tieba.sdk.b.a cow = this.kBk.cow();
        if (cow != null && cow.isValid()) {
            cPw();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cPy();
        cPx();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cPw() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cow = this.kBk.cow();
        if (cow != null) {
            String string = com.baidu.live.c.tG().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.tG().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cow.userId) && cow.userId.equals(string);
            if (StringUtils.isNull(cow.bduss) || !cow.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0663a c0663a = new C0663a(currentAccountInfo);
                String string3 = com.baidu.live.c.tG().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0663a.Ka(string3);
                } else {
                    c0663a.Ka(cow.bduss);
                }
                String string4 = com.baidu.live.c.tG().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0663a.Kb(string4);
                }
                c0663a.JX(cow.userId);
                c0663a.JY(cow.userName);
                c0663a.JZ(cow.nickName);
                c0663a.Kc(cow.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0663a.cPz(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0663a.cPz();
                    return;
                }
            }
            this.kBj = 0;
            cPx();
            C0663a c0663a2 = new C0663a();
            c0663a2.Ka(cow.bduss);
            c0663a2.JY(cow.userName);
            c0663a2.JZ(cow.nickName);
            c0663a2.JX(cow.userId);
            c0663a2.Kc(cow.portrait);
            com.baidu.live.c.tG().putString("ala_account_user_id", cow.userId);
            com.baidu.live.c.tG().putString("ala_account_user_bduss", cow.bduss);
            TbadkCoreApplication.setCurrentAccount(c0663a2.cPz(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cow);
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

    private void cPx() {
        com.baidu.live.c.tG().remove("ala_account_user_id");
        com.baidu.live.c.tG().remove("ala_account_user_bduss");
        com.baidu.live.c.tG().remove("ala_account_user_tbs");
    }

    private void cPy() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0663a {
        private String BDUSS;
        private int kBo;
        private AccountData kBp;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0663a() {
            this.kBp = new AccountData();
        }

        public C0663a(AccountData accountData) {
            if (accountData == null) {
                this.kBp = new AccountData();
            } else {
                this.kBp = accountData;
            }
        }

        public C0663a JX(String str) {
            this.userId = str;
            return this;
        }

        public C0663a JY(String str) {
            this.userName = str;
            return this;
        }

        public C0663a JZ(String str) {
            this.nickName = str;
            return this;
        }

        public C0663a Ka(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0663a Kb(String str) {
            this.tbs = str;
            return this;
        }

        public C0663a Kc(String str) {
            this.portrait = str;
            return this;
        }

        public C0663a BY(int i) {
            this.sex = i;
            return this;
        }

        public C0663a BZ(int i) {
            this.kBo = i;
            return this;
        }

        public AccountData cPz() {
            this.kBp.setBDUSS(this.BDUSS);
            this.kBp.setAccount(this.userName);
            this.kBp.setDisplayName(this.nickName);
            this.kBp.setID(this.userId);
            this.kBp.setPortrait(this.portrait);
            this.kBp.setTbs(this.tbs);
            this.kBp.setSex(this.sex);
            this.kBp.setIsActive(this.kBo);
            return this.kBp;
        }
    }
}
