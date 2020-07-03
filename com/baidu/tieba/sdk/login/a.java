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
/* loaded from: classes3.dex */
public class a {
    private static volatile a lop;
    private c aNS;
    private int loq;
    private com.baidu.tieba.sdk.b.a lor;
    private CustomMessageTask.CustomRunnable<Object> los = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cyZ();
            return null;
        }
    };
    private final HttpMessageListener lot = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.loq < 3) {
                        a.b(a.this);
                        a.this.a(a.this.lor.cyY());
                        return;
                    }
                    return;
                }
                a.this.loq = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.loq;
        aVar.loq = i + 1;
        return i;
    }

    public static a daZ() {
        if (lop == null) {
            synchronized (a.class) {
                if (lop == null) {
                    lop = new a();
                }
            }
        }
        return lop;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.los);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.lot);
        xp();
    }

    private void xp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cyZ() {
        if (this.lor != null) {
            this.lor.cyZ();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.lor = aVar;
    }

    public void dba() {
        if (this.lor != null) {
            dbd();
            if (this.aNS == null) {
                this.aNS = new c();
            }
            this.aNS.initListener();
            this.aNS.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void vg() {
                    if (a.this.aNS != null) {
                        a.this.aNS.onDestroy();
                    }
                }
            });
            this.aNS.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void HE() {
        if (this.lor != null) {
            dbd();
        }
    }

    public boolean dbb() {
        if (this.lor == null) {
            return false;
        }
        boolean dbd = dbd();
        if (!dbd) {
            this.lor.cyZ();
            return dbd;
        }
        return dbd;
    }

    public com.baidu.tieba.sdk.c.a dbc() {
        if (this.lor != null) {
            return this.lor.cyY();
        }
        return null;
    }

    private boolean dbd() {
        com.baidu.tieba.sdk.c.a cyY = this.lor.cyY();
        if (cyY != null && cyY.isValid()) {
            dbe();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dbg();
        dbf();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dbe() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cyY = this.lor.cyY();
        if (cyY != null) {
            String string = com.baidu.live.c.vf().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.vf().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cyY.userId) && cyY.userId.equals(string);
            if (StringUtils.isNull(cyY.bduss) || !cyY.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0733a c0733a = new C0733a(currentAccountInfo);
                String string3 = com.baidu.live.c.vf().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0733a.Mo(string3);
                } else {
                    c0733a.Mo(cyY.bduss);
                }
                String string4 = com.baidu.live.c.vf().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0733a.Mp(string4);
                }
                c0733a.Ml(cyY.userId);
                c0733a.Mm(cyY.userName);
                c0733a.Mn(cyY.nickName);
                c0733a.Mq(cyY.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0733a.dbh(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0733a.dbh();
                    return;
                }
            }
            this.loq = 0;
            dbf();
            C0733a c0733a2 = new C0733a();
            c0733a2.Mo(cyY.bduss);
            c0733a2.Mm(cyY.userName);
            c0733a2.Mn(cyY.nickName);
            c0733a2.Ml(cyY.userId);
            c0733a2.Mq(cyY.portrait);
            com.baidu.live.c.vf().putString("ala_account_user_id", cyY.userId);
            com.baidu.live.c.vf().putString("ala_account_user_bduss", cyY.bduss);
            TbadkCoreApplication.setCurrentAccount(c0733a2.dbh(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cyY);
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

    private void dbf() {
        com.baidu.live.c.vf().remove("ala_account_user_id");
        com.baidu.live.c.vf().remove("ala_account_user_bduss");
        com.baidu.live.c.vf().remove("ala_account_user_tbs");
    }

    private void dbg() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0733a {
        private String BDUSS;
        private int lov;
        private AccountData lox;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0733a() {
            this.lox = new AccountData();
        }

        public C0733a(AccountData accountData) {
            if (accountData == null) {
                this.lox = new AccountData();
            } else {
                this.lox = accountData;
            }
        }

        public C0733a Ml(String str) {
            this.userId = str;
            return this;
        }

        public C0733a Mm(String str) {
            this.userName = str;
            return this;
        }

        public C0733a Mn(String str) {
            this.nickName = str;
            return this;
        }

        public C0733a Mo(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0733a Mp(String str) {
            this.tbs = str;
            return this;
        }

        public C0733a Mq(String str) {
            this.portrait = str;
            return this;
        }

        public C0733a DM(int i) {
            this.sex = i;
            return this;
        }

        public C0733a DN(int i) {
            this.lov = i;
            return this;
        }

        public AccountData dbh() {
            this.lox.setBDUSS(this.BDUSS);
            this.lox.setAccount(this.userName);
            this.lox.setDisplayName(this.nickName);
            this.lox.setID(this.userId);
            this.lox.setPortrait(this.portrait);
            this.lox.setTbs(this.tbs);
            this.lox.setSex(this.sex);
            this.lox.setIsActive(this.lov);
            return this.lox;
        }
    }
}
