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
    private static volatile a lvJ;
    private c aPn;
    private int lvK;
    private com.baidu.tieba.sdk.b.a lvL;
    private CustomMessageTask.CustomRunnable<Object> lvM = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cCX();
            return null;
        }
    };
    private final HttpMessageListener lvN = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.lvK < 3) {
                        a.b(a.this);
                        a.this.a(a.this.lvL.cCW());
                        return;
                    }
                    return;
                }
                a.this.lvK = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.lvK;
        aVar.lvK = i + 1;
        return i;
    }

    public static a deh() {
        if (lvJ == null) {
            synchronized (a.class) {
                if (lvJ == null) {
                    lvJ = new a();
                }
            }
        }
        return lvJ;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.lvM);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.lvN);
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

    public void cCX() {
        if (this.lvL != null) {
            this.lvL.cCX();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.lvL = aVar;
    }

    public void dei() {
        if (this.lvL != null) {
            del();
            if (this.aPn == null) {
                this.aPn = new c();
            }
            this.aPn.initListener();
            this.aPn.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void vg() {
                    if (a.this.aPn != null) {
                        a.this.aPn.onDestroy();
                    }
                }
            });
            this.aPn.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void HK() {
        if (this.lvL != null) {
            del();
        }
    }

    public boolean dej() {
        if (this.lvL == null) {
            return false;
        }
        boolean del = del();
        if (!del) {
            this.lvL.cCX();
            return del;
        }
        return del;
    }

    public com.baidu.tieba.sdk.c.a dek() {
        if (this.lvL != null) {
            return this.lvL.cCW();
        }
        return null;
    }

    private boolean del() {
        com.baidu.tieba.sdk.c.a cCW = this.lvL.cCW();
        if (cCW != null && cCW.isValid()) {
            dem();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        deo();
        den();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dem() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cCW = this.lvL.cCW();
        if (cCW != null) {
            String string = com.baidu.live.c.vf().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.vf().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cCW.userId) && cCW.userId.equals(string);
            if (StringUtils.isNull(cCW.bduss) || !cCW.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0743a c0743a = new C0743a(currentAccountInfo);
                String string3 = com.baidu.live.c.vf().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0743a.MW(string3);
                } else {
                    c0743a.MW(cCW.bduss);
                }
                String string4 = com.baidu.live.c.vf().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0743a.MX(string4);
                }
                c0743a.MT(cCW.userId);
                c0743a.MU(cCW.userName);
                c0743a.MV(cCW.nickName);
                c0743a.MY(cCW.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0743a.dep(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0743a.dep();
                    return;
                }
            }
            this.lvK = 0;
            den();
            C0743a c0743a2 = new C0743a();
            c0743a2.MW(cCW.bduss);
            c0743a2.MU(cCW.userName);
            c0743a2.MV(cCW.nickName);
            c0743a2.MT(cCW.userId);
            c0743a2.MY(cCW.portrait);
            com.baidu.live.c.vf().putString("ala_account_user_id", cCW.userId);
            com.baidu.live.c.vf().putString("ala_account_user_bduss", cCW.bduss);
            TbadkCoreApplication.setCurrentAccount(c0743a2.dep(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cCW);
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

    private void den() {
        com.baidu.live.c.vf().remove("ala_account_user_id");
        com.baidu.live.c.vf().remove("ala_account_user_bduss");
        com.baidu.live.c.vf().remove("ala_account_user_tbs");
    }

    private void deo() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0743a {
        private String BDUSS;
        private int lvP;
        private AccountData lvQ;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0743a() {
            this.lvQ = new AccountData();
        }

        public C0743a(AccountData accountData) {
            if (accountData == null) {
                this.lvQ = new AccountData();
            } else {
                this.lvQ = accountData;
            }
        }

        public C0743a MT(String str) {
            this.userId = str;
            return this;
        }

        public C0743a MU(String str) {
            this.userName = str;
            return this;
        }

        public C0743a MV(String str) {
            this.nickName = str;
            return this;
        }

        public C0743a MW(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0743a MX(String str) {
            this.tbs = str;
            return this;
        }

        public C0743a MY(String str) {
            this.portrait = str;
            return this;
        }

        public C0743a Ei(int i) {
            this.sex = i;
            return this;
        }

        public C0743a Ej(int i) {
            this.lvP = i;
            return this;
        }

        public AccountData dep() {
            this.lvQ.setBDUSS(this.BDUSS);
            this.lvQ.setAccount(this.userName);
            this.lvQ.setDisplayName(this.nickName);
            this.lvQ.setID(this.userId);
            this.lvQ.setPortrait(this.portrait);
            this.lvQ.setTbs(this.tbs);
            this.lvQ.setSex(this.sex);
            this.lvQ.setIsActive(this.lvP);
            return this.lvQ;
        }
    }
}
