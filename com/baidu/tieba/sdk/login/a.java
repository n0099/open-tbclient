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
    private static volatile a mER;
    private c bbg;
    private int mES;
    private com.baidu.tieba.sdk.b.a mET;
    private CustomMessageTask.CustomRunnable<Object> mEU = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.dal();
            return null;
        }
    };
    private final HttpMessageListener mEV = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mES < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mET.dak());
                        return;
                    }
                    return;
                }
                a.this.mES = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mES;
        aVar.mES = i + 1;
        return i;
    }

    public static a dCo() {
        if (mER == null) {
            synchronized (a.class) {
                if (mER == null) {
                    mER = new a();
                }
            }
        }
        return mER;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mEU);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mEV);
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

    public void dal() {
        if (this.mET != null) {
            this.mET.dal();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mET = aVar;
    }

    public void dCp() {
        if (this.mET != null) {
            dCs();
            if (this.bbg == null) {
                this.bbg = new c();
            }
            this.bbg.initListener();
            this.bbg.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void Ar() {
                    if (a.this.bbg != null) {
                        a.this.bbg.onDestroy();
                    }
                }
            });
            this.bbg.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Sf() {
        if (this.mET != null) {
            dCs();
        }
    }

    public boolean dCq() {
        if (this.mET == null) {
            return false;
        }
        boolean dCs = dCs();
        if (!dCs) {
            this.mET.dal();
            return dCs;
        }
        return dCs;
    }

    public com.baidu.tieba.sdk.c.a dCr() {
        if (this.mET != null) {
            return this.mET.dak();
        }
        return null;
    }

    private boolean dCs() {
        com.baidu.tieba.sdk.c.a dak = this.mET.dak();
        if (dak != null && dak.isValid()) {
            dCt();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dCv();
        dCu();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dCt() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a dak = this.mET.dak();
        if (dak != null) {
            String string = d.Aq().getString("ala_account_user_id", "");
            String string2 = d.Aq().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(dak.userId) && dak.userId.equals(string);
            if (StringUtils.isNull(dak.bduss) || !dak.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0843a c0843a = new C0843a(currentAccountInfo);
                String string3 = d.Aq().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0843a.Rv(string3);
                } else {
                    c0843a.Rv(dak.bduss);
                }
                String string4 = d.Aq().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0843a.Rw(string4);
                }
                c0843a.Rs(dak.userId);
                c0843a.Rt(dak.userName);
                c0843a.Ru(dak.nickName);
                c0843a.Rx(dak.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0843a.dCw(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0843a.dCw();
                    return;
                }
            }
            this.mES = 0;
            dCu();
            C0843a c0843a2 = new C0843a();
            c0843a2.Rv(dak.bduss);
            c0843a2.Rt(dak.userName);
            c0843a2.Ru(dak.nickName);
            c0843a2.Rs(dak.userId);
            c0843a2.Rx(dak.portrait);
            d.Aq().putString("ala_account_user_id", dak.userId);
            d.Aq().putString("ala_account_user_bduss", dak.bduss);
            TbadkCoreApplication.setCurrentAccount(c0843a2.dCw(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(dak);
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

    private void dCu() {
        d.Aq().remove("ala_account_user_id");
        d.Aq().remove("ala_account_user_bduss");
        d.Aq().remove("ala_account_user_tbs");
    }

    private void dCv() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0843a {
        private String BDUSS;
        private int mEX;
        private AccountData mEY;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0843a() {
            this.mEY = new AccountData();
        }

        public C0843a(AccountData accountData) {
            if (accountData == null) {
                this.mEY = new AccountData();
            } else {
                this.mEY = accountData;
            }
        }

        public C0843a Rs(String str) {
            this.userId = str;
            return this;
        }

        public C0843a Rt(String str) {
            this.userName = str;
            return this;
        }

        public C0843a Ru(String str) {
            this.nickName = str;
            return this;
        }

        public C0843a Rv(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0843a Rw(String str) {
            this.tbs = str;
            return this;
        }

        public C0843a Rx(String str) {
            this.portrait = str;
            return this;
        }

        public C0843a IT(int i) {
            this.sex = i;
            return this;
        }

        public C0843a IU(int i) {
            this.mEX = i;
            return this;
        }

        public AccountData dCw() {
            this.mEY.setBDUSS(this.BDUSS);
            this.mEY.setAccount(this.userName);
            this.mEY.setDisplayName(this.nickName);
            this.mEY.setID(this.userId);
            this.mEY.setPortrait(this.portrait);
            this.mEY.setTbs(this.tbs);
            this.mEY.setSex(this.sex);
            this.mEY.setIsActive(this.mEX);
            return this.mEY;
        }
    }
}
