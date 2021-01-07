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
import com.baidu.live.p.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.account.AccountHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sdk.login.message.GetLoginTbsResponsedMessage;
/* loaded from: classes11.dex */
public class a {
    private static volatile a mYt;
    private c bgO;
    private int mYu;
    private com.baidu.tieba.sdk.b.a mYv;
    private CustomMessageTask.CustomRunnable<Object> mYw = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.dfl();
            return null;
        }
    };
    private final HttpMessageListener mYx = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mYu < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mYv.dfk());
                        return;
                    }
                    return;
                }
                a.this.mYu = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mYu;
        aVar.mYu = i + 1;
        return i;
    }

    public static a dHr() {
        if (mYt == null) {
            synchronized (a.class) {
                if (mYt == null) {
                    mYt = new a();
                }
            }
        }
        return mYt;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mYw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mYx);
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

    public void dfl() {
        if (this.mYv != null) {
            this.mYv.dfl();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mYv = aVar;
    }

    public void dHs() {
        if (this.mYv != null) {
            dHv();
            if (this.bgO == null) {
                this.bgO = new c();
            }
            this.bgO.initListener();
            this.bgO.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void Bb() {
                    if (a.this.bgO != null) {
                        a.this.bgO.onDestroy();
                    }
                }
            });
            this.bgO.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void VI() {
        if (this.mYv != null) {
            dHv();
        }
    }

    public boolean dHt() {
        if (this.mYv == null) {
            return false;
        }
        boolean dHv = dHv();
        if (!dHv) {
            this.mYv.dfl();
            return dHv;
        }
        return dHv;
    }

    public com.baidu.tieba.sdk.c.a dHu() {
        if (this.mYv != null) {
            return this.mYv.dfk();
        }
        return null;
    }

    private boolean dHv() {
        com.baidu.tieba.sdk.c.a dfk = this.mYv.dfk();
        if (dfk != null && dfk.isValid()) {
            dHw();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dHy();
        dHx();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dHw() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a dfk = this.mYv.dfk();
        if (dfk != null) {
            String string = d.Ba().getString("ala_account_user_id", "");
            String string2 = d.Ba().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(dfk.userId) && dfk.userId.equals(string);
            if (StringUtils.isNull(dfk.bduss) || !dfk.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0875a c0875a = new C0875a(currentAccountInfo);
                String string3 = d.Ba().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0875a.Sr(string3);
                } else {
                    c0875a.Sr(dfk.bduss);
                }
                String string4 = d.Ba().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0875a.Ss(string4);
                }
                c0875a.So(dfk.userId);
                c0875a.Sp(dfk.userName);
                c0875a.Sq(dfk.nickName);
                c0875a.St(dfk.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0875a.dHz(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0875a.dHz();
                    return;
                }
            }
            this.mYu = 0;
            dHx();
            C0875a c0875a2 = new C0875a();
            c0875a2.Sr(dfk.bduss);
            c0875a2.Sp(dfk.userName);
            c0875a2.Sq(dfk.nickName);
            c0875a2.So(dfk.userId);
            c0875a2.St(dfk.portrait);
            d.Ba().putString("ala_account_user_id", dfk.userId);
            d.Ba().putString("ala_account_user_bduss", dfk.bduss);
            TbadkCoreApplication.setCurrentAccount(c0875a2.dHz(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(dfk);
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

    private void dHx() {
        d.Ba().remove("ala_account_user_id");
        d.Ba().remove("ala_account_user_bduss");
        d.Ba().remove("ala_account_user_tbs");
    }

    private void dHy() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0875a {
        private String BDUSS;
        private AccountData mYA;
        private int mYz;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0875a() {
            this.mYA = new AccountData();
        }

        public C0875a(AccountData accountData) {
            if (accountData == null) {
                this.mYA = new AccountData();
            } else {
                this.mYA = accountData;
            }
        }

        public C0875a So(String str) {
            this.userId = str;
            return this;
        }

        public C0875a Sp(String str) {
            this.userName = str;
            return this;
        }

        public C0875a Sq(String str) {
            this.nickName = str;
            return this;
        }

        public C0875a Sr(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0875a Ss(String str) {
            this.tbs = str;
            return this;
        }

        public C0875a St(String str) {
            this.portrait = str;
            return this;
        }

        public C0875a JE(int i) {
            this.sex = i;
            return this;
        }

        public C0875a JF(int i) {
            this.mYz = i;
            return this;
        }

        public AccountData dHz() {
            this.mYA.setBDUSS(this.BDUSS);
            this.mYA.setAccount(this.userName);
            this.mYA.setDisplayName(this.nickName);
            this.mYA.setID(this.userId);
            this.mYA.setPortrait(this.portrait);
            this.mYA.setTbs(this.tbs);
            this.mYA.setSex(this.sex);
            this.mYA.setIsActive(this.mYz);
            return this.mYA;
        }
    }
}
