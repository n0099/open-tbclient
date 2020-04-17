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
    private static volatile a kBe;
    private c aFy;
    private int kBf;
    private com.baidu.tieba.sdk.a.a kBg;
    private CustomMessageTask.CustomRunnable<Object> kBh = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.coz();
            return null;
        }
    };
    private final HttpMessageListener kBi = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.kBf < 3) {
                        a.b(a.this);
                        a.this.a(a.this.kBg.coy());
                        return;
                    }
                    return;
                }
                a.this.kBf = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.kBf;
        aVar.kBf = i + 1;
        return i;
    }

    public static a cPt() {
        if (kBe == null) {
            synchronized (a.class) {
                if (kBe == null) {
                    kBe = new a();
                }
            }
        }
        return kBe;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.kBh);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.kBi);
        xC();
    }

    private void xC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void coz() {
        if (this.kBg != null) {
            this.kBg.coz();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.kBg = aVar;
    }

    public void cPu() {
        if (this.kBg != null) {
            cPx();
            if (this.aFy == null) {
                this.aFy = new c();
            }
            this.aFy.initListener();
            this.aFy.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void tI() {
                    if (a.this.aFy != null) {
                        a.this.aFy.onDestroy();
                    }
                }
            });
            this.aFy.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void EB() {
        if (this.kBg != null) {
            cPx();
        }
    }

    public boolean cPv() {
        if (this.kBg == null) {
            return false;
        }
        boolean cPx = cPx();
        if (!cPx) {
            this.kBg.coz();
            return cPx;
        }
        return cPx;
    }

    public com.baidu.tieba.sdk.b.a cPw() {
        if (this.kBg != null) {
            return this.kBg.coy();
        }
        return null;
    }

    private boolean cPx() {
        com.baidu.tieba.sdk.b.a coy = this.kBg.coy();
        if (coy != null && coy.isValid()) {
            cPy();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cPA();
        cPz();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cPy() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a coy = this.kBg.coy();
        if (coy != null) {
            String string = com.baidu.live.c.tH().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.tH().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(coy.userId) && coy.userId.equals(string);
            if (StringUtils.isNull(coy.bduss) || !coy.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0642a c0642a = new C0642a(currentAccountInfo);
                String string3 = com.baidu.live.c.tH().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0642a.JX(string3);
                } else {
                    c0642a.JX(coy.bduss);
                }
                String string4 = com.baidu.live.c.tH().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0642a.JY(string4);
                }
                c0642a.JU(coy.userId);
                c0642a.JV(coy.userName);
                c0642a.JW(coy.nickName);
                c0642a.JZ(coy.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0642a.cPB(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0642a.cPB();
                    return;
                }
            }
            this.kBf = 0;
            cPz();
            C0642a c0642a2 = new C0642a();
            c0642a2.JX(coy.bduss);
            c0642a2.JV(coy.userName);
            c0642a2.JW(coy.nickName);
            c0642a2.JU(coy.userId);
            c0642a2.JZ(coy.portrait);
            com.baidu.live.c.tH().putString("ala_account_user_id", coy.userId);
            com.baidu.live.c.tH().putString("ala_account_user_bduss", coy.bduss);
            TbadkCoreApplication.setCurrentAccount(c0642a2.cPB(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(coy);
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

    private void cPz() {
        com.baidu.live.c.tH().remove("ala_account_user_id");
        com.baidu.live.c.tH().remove("ala_account_user_bduss");
        com.baidu.live.c.tH().remove("ala_account_user_tbs");
    }

    private void cPA() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0642a {
        private String BDUSS;
        private int kBk;
        private AccountData kBl;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0642a() {
            this.kBl = new AccountData();
        }

        public C0642a(AccountData accountData) {
            if (accountData == null) {
                this.kBl = new AccountData();
            } else {
                this.kBl = accountData;
            }
        }

        public C0642a JU(String str) {
            this.userId = str;
            return this;
        }

        public C0642a JV(String str) {
            this.userName = str;
            return this;
        }

        public C0642a JW(String str) {
            this.nickName = str;
            return this;
        }

        public C0642a JX(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0642a JY(String str) {
            this.tbs = str;
            return this;
        }

        public C0642a JZ(String str) {
            this.portrait = str;
            return this;
        }

        public C0642a BY(int i) {
            this.sex = i;
            return this;
        }

        public C0642a BZ(int i) {
            this.kBk = i;
            return this;
        }

        public AccountData cPB() {
            this.kBl.setBDUSS(this.BDUSS);
            this.kBl.setAccount(this.userName);
            this.kBl.setDisplayName(this.nickName);
            this.kBl.setID(this.userId);
            this.kBl.setPortrait(this.portrait);
            this.kBl.setTbs(this.tbs);
            this.kBl.setSex(this.sex);
            this.kBl.setIsActive(this.kBk);
            return this.kBl;
        }
    }
}
