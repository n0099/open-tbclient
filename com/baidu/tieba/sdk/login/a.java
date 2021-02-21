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
import com.baidu.live.o.c;
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
    private static volatile a ndE;
    private c bff;
    private int ndF;
    private com.baidu.tieba.sdk.b.a ndG;
    private CustomMessageTask.CustomRunnable<Object> ndH = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.ddy();
            return null;
        }
    };
    private final HttpMessageListener ndI = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.ndF < 3) {
                        a.b(a.this);
                        a.this.a(a.this.ndG.ddx());
                        return;
                    }
                    return;
                }
                a.this.ndF = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.ndF;
        aVar.ndF = i + 1;
        return i;
    }

    public static a dFQ() {
        if (ndE == null) {
            synchronized (a.class) {
                if (ndE == null) {
                    ndE = new a();
                }
            }
        }
        return ndE;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.ndH);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.ndI);
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

    public void ddy() {
        if (this.ndG != null) {
            this.ndG.ddy();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.ndG = aVar;
    }

    public void dFR() {
        if (this.ndG != null) {
            dFU();
            if (this.bff == null) {
                this.bff = new c();
            }
            this.bff.initListener();
            this.bff.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void xd() {
                    if (a.this.bff != null) {
                        a.this.bff.onDestroy();
                    }
                }
            });
            this.bff.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Tw() {
        if (this.ndG != null) {
            dFU();
        }
    }

    public boolean dFS() {
        if (this.ndG == null) {
            return false;
        }
        boolean dFU = dFU();
        if (!dFU) {
            this.ndG.ddy();
            return dFU;
        }
        return dFU;
    }

    public com.baidu.tieba.sdk.c.a dFT() {
        if (this.ndG != null) {
            return this.ndG.ddx();
        }
        return null;
    }

    private boolean dFU() {
        com.baidu.tieba.sdk.c.a ddx = this.ndG.ddx();
        if (ddx != null && ddx.isValid()) {
            dFV();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dFX();
        dFW();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dFV() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a ddx = this.ndG.ddx();
        if (ddx != null) {
            String string = d.xc().getString("ala_account_user_id", "");
            String string2 = d.xc().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(ddx.userId) && ddx.userId.equals(string);
            if (StringUtils.isNull(ddx.bduss) || !ddx.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0863a c0863a = new C0863a(currentAccountInfo);
                String string3 = d.xc().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0863a.Sr(string3);
                } else {
                    c0863a.Sr(ddx.bduss);
                }
                String string4 = d.xc().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0863a.Ss(string4);
                }
                c0863a.So(ddx.userId);
                c0863a.Sp(ddx.userName);
                c0863a.Sq(ddx.nickName);
                c0863a.St(ddx.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0863a.dFY(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0863a.dFY();
                    return;
                }
            }
            this.ndF = 0;
            dFW();
            C0863a c0863a2 = new C0863a();
            c0863a2.Sr(ddx.bduss);
            c0863a2.Sp(ddx.userName);
            c0863a2.Sq(ddx.nickName);
            c0863a2.So(ddx.userId);
            c0863a2.St(ddx.portrait);
            d.xc().putString("ala_account_user_id", ddx.userId);
            d.xc().putString("ala_account_user_bduss", ddx.bduss);
            TbadkCoreApplication.setCurrentAccount(c0863a2.dFY(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(ddx);
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

    private void dFW() {
        d.xc().remove("ala_account_user_id");
        d.xc().remove("ala_account_user_bduss");
        d.xc().remove("ala_account_user_tbs");
    }

    private void dFX() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0863a {
        private String BDUSS;
        private int ndK;
        private AccountData ndL;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0863a() {
            this.ndL = new AccountData();
        }

        public C0863a(AccountData accountData) {
            if (accountData == null) {
                this.ndL = new AccountData();
            } else {
                this.ndL = accountData;
            }
        }

        public C0863a So(String str) {
            this.userId = str;
            return this;
        }

        public C0863a Sp(String str) {
            this.userName = str;
            return this;
        }

        public C0863a Sq(String str) {
            this.nickName = str;
            return this;
        }

        public C0863a Sr(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0863a Ss(String str) {
            this.tbs = str;
            return this;
        }

        public C0863a St(String str) {
            this.portrait = str;
            return this;
        }

        public C0863a Ir(int i) {
            this.sex = i;
            return this;
        }

        public C0863a Is(int i) {
            this.ndK = i;
            return this;
        }

        public AccountData dFY() {
            this.ndL.setBDUSS(this.BDUSS);
            this.ndL.setAccount(this.userName);
            this.ndL.setDisplayName(this.nickName);
            this.ndL.setID(this.userId);
            this.ndL.setPortrait(this.portrait);
            this.ndL.setTbs(this.tbs);
            this.ndL.setSex(this.sex);
            this.ndL.setIsActive(this.ndK);
            return this.ndL;
        }
    }
}
