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
import com.baidu.live.j.c;
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
    private static a jOY;
    private c akJ;
    private int jOZ;
    private com.baidu.tieba.sdk.a.a jPa;
    private CustomMessageTask.CustomRunnable<Object> jPb = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cbY();
            return null;
        }
    };
    private final HttpMessageListener jPc = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.jOZ < 3) {
                        a.b(a.this);
                        a.this.a(a.this.jPa.cbX());
                        return;
                    }
                    return;
                }
                a.this.jOZ = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.jOZ;
        aVar.jOZ = i + 1;
        return i;
    }

    public static a cCR() {
        if (jOY == null) {
            synchronized (a.class) {
                if (jOY == null) {
                    jOY = new a();
                }
            }
        }
        return jOY;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.jPb);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.jPc);
        rT();
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cbY() {
        if (this.jPa != null) {
            this.jPa.cbY();
        }
    }

    public void b(com.baidu.tieba.sdk.a.a aVar) {
        this.jPa = aVar;
    }

    public void cCS() {
        if (this.jPa != null) {
            cCV();
            if (this.akJ == null) {
                this.akJ = new c();
            }
            this.akJ.initListener();
            this.akJ.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void oK() {
                    if (a.this.akJ != null) {
                        a.this.akJ.onDestroy();
                    }
                }
            });
            this.akJ.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void xc() {
        if (this.jPa != null) {
            cCV();
        }
    }

    public boolean cCT() {
        if (this.jPa == null) {
            return false;
        }
        boolean cCV = cCV();
        if (!cCV) {
            this.jPa.cbY();
            return cCV;
        }
        return cCV;
    }

    public com.baidu.tieba.sdk.b.a cCU() {
        if (this.jPa != null) {
            return this.jPa.cbX();
        }
        return null;
    }

    private boolean cCV() {
        com.baidu.tieba.sdk.b.a cbX = this.jPa.cbX();
        if (cbX != null && cbX.isValid()) {
            cCW();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cCY();
        cCX();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cCW() {
        boolean z = true;
        com.baidu.tieba.sdk.b.a cbX = this.jPa.cbX();
        if (cbX != null) {
            String string = com.baidu.live.c.oJ().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.oJ().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cbX.userId) && cbX.userId.equals(string);
            if (StringUtils.isNull(cbX.bduss) || !cbX.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0594a c0594a = new C0594a(currentAccountInfo);
                String string3 = com.baidu.live.c.oJ().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0594a.Ie(string3);
                } else {
                    c0594a.Ie(cbX.bduss);
                }
                String string4 = com.baidu.live.c.oJ().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0594a.If(string4);
                }
                c0594a.Ib(cbX.userId);
                c0594a.Ic(cbX.userName);
                c0594a.Id(cbX.nickName);
                c0594a.Ig(cbX.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0594a.cCZ(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0594a.cCZ();
                    return;
                }
            }
            this.jOZ = 0;
            cCX();
            C0594a c0594a2 = new C0594a();
            c0594a2.Ie(cbX.bduss);
            c0594a2.Ic(cbX.userName);
            c0594a2.Id(cbX.nickName);
            c0594a2.Ib(cbX.userId);
            c0594a2.Ig(cbX.portrait);
            com.baidu.live.c.oJ().putString("ala_account_user_id", cbX.userId);
            com.baidu.live.c.oJ().putString("ala_account_user_bduss", cbX.bduss);
            TbadkCoreApplication.setCurrentAccount(c0594a2.cCZ(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cbX);
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

    private void cCX() {
        com.baidu.live.c.oJ().remove("ala_account_user_id");
        com.baidu.live.c.oJ().remove("ala_account_user_bduss");
        com.baidu.live.c.oJ().remove("ala_account_user_tbs");
    }

    private void cCY() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0594a {
        private String BDUSS;
        private int jPe;
        private AccountData jPf;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0594a() {
            this.jPf = new AccountData();
        }

        public C0594a(AccountData accountData) {
            if (accountData == null) {
                this.jPf = new AccountData();
            } else {
                this.jPf = accountData;
            }
        }

        public C0594a Ib(String str) {
            this.userId = str;
            return this;
        }

        public C0594a Ic(String str) {
            this.userName = str;
            return this;
        }

        public C0594a Id(String str) {
            this.nickName = str;
            return this;
        }

        public C0594a Ie(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0594a If(String str) {
            this.tbs = str;
            return this;
        }

        public C0594a Ig(String str) {
            this.portrait = str;
            return this;
        }

        public C0594a Bh(int i) {
            this.sex = i;
            return this;
        }

        public C0594a Bi(int i) {
            this.jPe = i;
            return this;
        }

        public AccountData cCZ() {
            this.jPf.setBDUSS(this.BDUSS);
            this.jPf.setAccount(this.userName);
            this.jPf.setDisplayName(this.nickName);
            this.jPf.setID(this.userId);
            this.jPf.setPortrait(this.portrait);
            this.jPf.setTbs(this.tbs);
            this.jPf.setSex(this.sex);
            this.jPf.setIsActive(this.jPe);
            return this.jPf;
        }
    }
}
