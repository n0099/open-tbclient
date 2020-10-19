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
    private static volatile a mlS;
    private c bae;
    private int mlT;
    private com.baidu.tieba.sdk.b.a mlU;
    private CustomMessageTask.CustomRunnable<Object> mlV = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cVf();
            return null;
        }
    };
    private final HttpMessageListener mlW = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mlT < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mlU.cVe());
                        return;
                    }
                    return;
                }
                a.this.mlT = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mlT;
        aVar.mlT = i + 1;
        return i;
    }

    public static a dxa() {
        if (mlS == null) {
            synchronized (a.class) {
                if (mlS == null) {
                    mlS = new a();
                }
            }
        }
        return mlS;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mlV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mlW);
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

    public void cVf() {
        if (this.mlU != null) {
            this.mlU.cVf();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mlU = aVar;
    }

    public void dxb() {
        if (this.mlU != null) {
            dxe();
            if (this.bae == null) {
                this.bae = new c();
            }
            this.bae.initListener();
            this.bae.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void Ba() {
                    if (a.this.bae != null) {
                        a.this.bae.onDestroy();
                    }
                }
            });
            this.bae.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Pl() {
        if (this.mlU != null) {
            dxe();
        }
    }

    public boolean dxc() {
        if (this.mlU == null) {
            return false;
        }
        boolean dxe = dxe();
        if (!dxe) {
            this.mlU.cVf();
            return dxe;
        }
        return dxe;
    }

    public com.baidu.tieba.sdk.c.a dxd() {
        if (this.mlU != null) {
            return this.mlU.cVe();
        }
        return null;
    }

    private boolean dxe() {
        com.baidu.tieba.sdk.c.a cVe = this.mlU.cVe();
        if (cVe != null && cVe.isValid()) {
            dxf();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dxh();
        dxg();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dxf() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cVe = this.mlU.cVe();
        if (cVe != null) {
            String string = com.baidu.live.c.AZ().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.AZ().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cVe.userId) && cVe.userId.equals(string);
            if (StringUtils.isNull(cVe.bduss) || !cVe.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0811a c0811a = new C0811a(currentAccountInfo);
                String string3 = com.baidu.live.c.AZ().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0811a.Rh(string3);
                } else {
                    c0811a.Rh(cVe.bduss);
                }
                String string4 = com.baidu.live.c.AZ().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0811a.Ri(string4);
                }
                c0811a.Re(cVe.userId);
                c0811a.Rf(cVe.userName);
                c0811a.Rg(cVe.nickName);
                c0811a.Rj(cVe.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0811a.dxi(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0811a.dxi();
                    return;
                }
            }
            this.mlT = 0;
            dxg();
            C0811a c0811a2 = new C0811a();
            c0811a2.Rh(cVe.bduss);
            c0811a2.Rf(cVe.userName);
            c0811a2.Rg(cVe.nickName);
            c0811a2.Re(cVe.userId);
            c0811a2.Rj(cVe.portrait);
            com.baidu.live.c.AZ().putString("ala_account_user_id", cVe.userId);
            com.baidu.live.c.AZ().putString("ala_account_user_bduss", cVe.bduss);
            TbadkCoreApplication.setCurrentAccount(c0811a2.dxi(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cVe);
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

    private void dxg() {
        com.baidu.live.c.AZ().remove("ala_account_user_id");
        com.baidu.live.c.AZ().remove("ala_account_user_bduss");
        com.baidu.live.c.AZ().remove("ala_account_user_tbs");
    }

    private void dxh() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0811a {
        private String BDUSS;
        private int mlY;
        private AccountData mlZ;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0811a() {
            this.mlZ = new AccountData();
        }

        public C0811a(AccountData accountData) {
            if (accountData == null) {
                this.mlZ = new AccountData();
            } else {
                this.mlZ = accountData;
            }
        }

        public C0811a Re(String str) {
            this.userId = str;
            return this;
        }

        public C0811a Rf(String str) {
            this.userName = str;
            return this;
        }

        public C0811a Rg(String str) {
            this.nickName = str;
            return this;
        }

        public C0811a Rh(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0811a Ri(String str) {
            this.tbs = str;
            return this;
        }

        public C0811a Rj(String str) {
            this.portrait = str;
            return this;
        }

        public C0811a HM(int i) {
            this.sex = i;
            return this;
        }

        public C0811a HN(int i) {
            this.mlY = i;
            return this;
        }

        public AccountData dxi() {
            this.mlZ.setBDUSS(this.BDUSS);
            this.mlZ.setAccount(this.userName);
            this.mlZ.setDisplayName(this.nickName);
            this.mlZ.setID(this.userId);
            this.mlZ.setPortrait(this.portrait);
            this.mlZ.setTbs(this.tbs);
            this.mlZ.setSex(this.sex);
            this.mlZ.setIsActive(this.mlY);
            return this.mlZ;
        }
    }
}
