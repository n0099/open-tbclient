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
import com.baidu.live.e;
import com.baidu.live.m.c;
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
    private static volatile a myt;
    private c bby;
    private int myu;
    private com.baidu.tieba.sdk.b.a myv;
    private CustomMessageTask.CustomRunnable<Object> myw = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cYn();
            return null;
        }
    };
    private final HttpMessageListener myx = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.myu < 3) {
                        a.b(a.this);
                        a.this.a(a.this.myv.cYm());
                        return;
                    }
                    return;
                }
                a.this.myu = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.myu;
        aVar.myu = i + 1;
        return i;
    }

    public static a dAi() {
        if (myt == null) {
            synchronized (a.class) {
                if (myt == null) {
                    myt = new a();
                }
            }
        }
        return myt;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.myw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.myx);
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

    public void cYn() {
        if (this.myv != null) {
            this.myv.cYn();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.myv = aVar;
    }

    public void dAj() {
        if (this.myv != null) {
            dAm();
            if (this.bby == null) {
                this.bby = new c();
            }
            this.bby.initListener();
            this.bby.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void Ba() {
                    if (a.this.bby != null) {
                        a.this.bby.onDestroy();
                    }
                }
            });
            this.bby.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Qe() {
        if (this.myv != null) {
            dAm();
        }
    }

    public boolean dAk() {
        if (this.myv == null) {
            return false;
        }
        boolean dAm = dAm();
        if (!dAm) {
            this.myv.cYn();
            return dAm;
        }
        return dAm;
    }

    public com.baidu.tieba.sdk.c.a dAl() {
        if (this.myv != null) {
            return this.myv.cYm();
        }
        return null;
    }

    private boolean dAm() {
        com.baidu.tieba.sdk.c.a cYm = this.myv.cYm();
        if (cYm != null && cYm.isValid()) {
            dAn();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dAp();
        dAo();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dAn() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cYm = this.myv.cYm();
        if (cYm != null) {
            String string = d.AZ().getString("ala_account_user_id", "");
            String string2 = d.AZ().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cYm.userId) && cYm.userId.equals(string);
            if (StringUtils.isNull(cYm.bduss) || !cYm.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0826a c0826a = new C0826a(currentAccountInfo);
                String string3 = d.AZ().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0826a.RG(string3);
                } else {
                    c0826a.RG(cYm.bduss);
                }
                String string4 = d.AZ().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0826a.RH(string4);
                }
                c0826a.RD(cYm.userId);
                c0826a.RE(cYm.userName);
                c0826a.RF(cYm.nickName);
                c0826a.RI(cYm.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0826a.dAq(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0826a.dAq();
                    return;
                }
            }
            this.myu = 0;
            dAo();
            C0826a c0826a2 = new C0826a();
            c0826a2.RG(cYm.bduss);
            c0826a2.RE(cYm.userName);
            c0826a2.RF(cYm.nickName);
            c0826a2.RD(cYm.userId);
            c0826a2.RI(cYm.portrait);
            d.AZ().putString("ala_account_user_id", cYm.userId);
            d.AZ().putString("ala_account_user_bduss", cYm.bduss);
            TbadkCoreApplication.setCurrentAccount(c0826a2.dAq(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cYm);
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

    private void dAo() {
        d.AZ().remove("ala_account_user_id");
        d.AZ().remove("ala_account_user_bduss");
        d.AZ().remove("ala_account_user_tbs");
    }

    private void dAp() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0826a {
        private String BDUSS;
        private AccountData myA;
        private int myz;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0826a() {
            this.myA = new AccountData();
        }

        public C0826a(AccountData accountData) {
            if (accountData == null) {
                this.myA = new AccountData();
            } else {
                this.myA = accountData;
            }
        }

        public C0826a RD(String str) {
            this.userId = str;
            return this;
        }

        public C0826a RE(String str) {
            this.userName = str;
            return this;
        }

        public C0826a RF(String str) {
            this.nickName = str;
            return this;
        }

        public C0826a RG(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0826a RH(String str) {
            this.tbs = str;
            return this;
        }

        public C0826a RI(String str) {
            this.portrait = str;
            return this;
        }

        public C0826a If(int i) {
            this.sex = i;
            return this;
        }

        public C0826a Ig(int i) {
            this.myz = i;
            return this;
        }

        public AccountData dAq() {
            this.myA.setBDUSS(this.BDUSS);
            this.myA.setAccount(this.userName);
            this.myA.setDisplayName(this.nickName);
            this.myA.setID(this.userId);
            this.myA.setPortrait(this.portrait);
            this.myA.setTbs(this.tbs);
            this.myA.setSex(this.sex);
            this.myA.setIsActive(this.myz);
            return this.myA;
        }
    }
}
