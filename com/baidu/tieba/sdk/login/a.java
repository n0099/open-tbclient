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
    private static volatile a mYu;
    private c bgO;
    private int mYv;
    private com.baidu.tieba.sdk.b.a mYw;
    private CustomMessageTask.CustomRunnable<Object> mYx = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.dfk();
            return null;
        }
    };
    private final HttpMessageListener mYy = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.mYv < 3) {
                        a.b(a.this);
                        a.this.a(a.this.mYw.dfj());
                        return;
                    }
                    return;
                }
                a.this.mYv = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.mYv;
        aVar.mYv = i + 1;
        return i;
    }

    public static a dHq() {
        if (mYu == null) {
            synchronized (a.class) {
                if (mYu == null) {
                    mYu = new a();
                }
            }
        }
        return mYu;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.mYx);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.mYy);
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

    public void dfk() {
        if (this.mYw != null) {
            this.mYw.dfk();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.mYw = aVar;
    }

    public void dHr() {
        if (this.mYw != null) {
            dHu();
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
        if (this.mYw != null) {
            dHu();
        }
    }

    public boolean dHs() {
        if (this.mYw == null) {
            return false;
        }
        boolean dHu = dHu();
        if (!dHu) {
            this.mYw.dfk();
            return dHu;
        }
        return dHu;
    }

    public com.baidu.tieba.sdk.c.a dHt() {
        if (this.mYw != null) {
            return this.mYw.dfj();
        }
        return null;
    }

    private boolean dHu() {
        com.baidu.tieba.sdk.c.a dfj = this.mYw.dfj();
        if (dfj != null && dfj.isValid()) {
            dHv();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dHx();
        dHw();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dHv() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a dfj = this.mYw.dfj();
        if (dfj != null) {
            String string = d.Ba().getString("ala_account_user_id", "");
            String string2 = d.Ba().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(dfj.userId) && dfj.userId.equals(string);
            if (StringUtils.isNull(dfj.bduss) || !dfj.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0842a c0842a = new C0842a(currentAccountInfo);
                String string3 = d.Ba().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0842a.Ss(string3);
                } else {
                    c0842a.Ss(dfj.bduss);
                }
                String string4 = d.Ba().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0842a.St(string4);
                }
                c0842a.Sp(dfj.userId);
                c0842a.Sq(dfj.userName);
                c0842a.Sr(dfj.nickName);
                c0842a.Su(dfj.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0842a.dHy(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0842a.dHy();
                    return;
                }
            }
            this.mYv = 0;
            dHw();
            C0842a c0842a2 = new C0842a();
            c0842a2.Ss(dfj.bduss);
            c0842a2.Sq(dfj.userName);
            c0842a2.Sr(dfj.nickName);
            c0842a2.Sp(dfj.userId);
            c0842a2.Su(dfj.portrait);
            d.Ba().putString("ala_account_user_id", dfj.userId);
            d.Ba().putString("ala_account_user_bduss", dfj.bduss);
            TbadkCoreApplication.setCurrentAccount(c0842a2.dHy(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(dfj);
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

    private void dHw() {
        d.Ba().remove("ala_account_user_id");
        d.Ba().remove("ala_account_user_bduss");
        d.Ba().remove("ala_account_user_tbs");
    }

    private void dHx() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0842a {
        private String BDUSS;
        private int mYA;
        private AccountData mYB;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0842a() {
            this.mYB = new AccountData();
        }

        public C0842a(AccountData accountData) {
            if (accountData == null) {
                this.mYB = new AccountData();
            } else {
                this.mYB = accountData;
            }
        }

        public C0842a Sp(String str) {
            this.userId = str;
            return this;
        }

        public C0842a Sq(String str) {
            this.userName = str;
            return this;
        }

        public C0842a Sr(String str) {
            this.nickName = str;
            return this;
        }

        public C0842a Ss(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0842a St(String str) {
            this.tbs = str;
            return this;
        }

        public C0842a Su(String str) {
            this.portrait = str;
            return this;
        }

        public C0842a JE(int i) {
            this.sex = i;
            return this;
        }

        public C0842a JF(int i) {
            this.mYA = i;
            return this;
        }

        public AccountData dHy() {
            this.mYB.setBDUSS(this.BDUSS);
            this.mYB.setAccount(this.userName);
            this.mYB.setDisplayName(this.nickName);
            this.mYB.setID(this.userId);
            this.mYB.setPortrait(this.portrait);
            this.mYB.setTbs(this.tbs);
            this.mYB.setSex(this.sex);
            this.mYB.setIsActive(this.mYA);
            return this.mYB;
        }
    }
}
