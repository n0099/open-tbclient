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
    private static volatile a kUt;
    private c aLm;
    private int kUu;
    private com.baidu.tieba.sdk.b.a kUv;
    private CustomMessageTask.CustomRunnable<Object> kUw = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.cvi();
            return null;
        }
    };
    private final HttpMessageListener kUx = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.kUu < 3) {
                        a.b(a.this);
                        a.this.a(a.this.kUv.cvh());
                        return;
                    }
                    return;
                }
                a.this.kUu = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.kUu;
        aVar.kUu = i + 1;
        return i;
    }

    public static a cWK() {
        if (kUt == null) {
            synchronized (a.class) {
                if (kUt == null) {
                    kUt = new a();
                }
            }
        }
        return kUt;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.kUw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.kUx);
        Fv();
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003402, TbConfig.SERVER_ADDRESS + "ala/sdk/login");
        tbHttpMessageTask.setNeedGzip(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(GetLoginTbsResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cvi() {
        if (this.kUv != null) {
            this.kUv.cvi();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.kUv = aVar;
    }

    public void cWL() {
        if (this.kUv != null) {
            cWO();
            if (this.aLm == null) {
                this.aLm = new c();
            }
            this.aLm.initListener();
            this.aLm.a(new d() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.d
                public void uO() {
                    if (a.this.aLm != null) {
                        a.this.aLm.onDestroy();
                    }
                }
            });
            this.aLm.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Gr() {
        if (this.kUv != null) {
            cWO();
        }
    }

    public boolean cWM() {
        if (this.kUv == null) {
            return false;
        }
        boolean cWO = cWO();
        if (!cWO) {
            this.kUv.cvi();
            return cWO;
        }
        return cWO;
    }

    public com.baidu.tieba.sdk.c.a cWN() {
        if (this.kUv != null) {
            return this.kUv.cvh();
        }
        return null;
    }

    private boolean cWO() {
        com.baidu.tieba.sdk.c.a cvh = this.kUv.cvh();
        if (cvh != null && cvh.isValid()) {
            cWP();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        cWR();
        cWQ();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void cWP() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a cvh = this.kUv.cvh();
        if (cvh != null) {
            String string = com.baidu.live.c.uN().getString("ala_account_user_id", "");
            String string2 = com.baidu.live.c.uN().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(cvh.userId) && cvh.userId.equals(string);
            if (StringUtils.isNull(cvh.bduss) || !cvh.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0717a c0717a = new C0717a(currentAccountInfo);
                String string3 = com.baidu.live.c.uN().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0717a.LN(string3);
                } else {
                    c0717a.LN(cvh.bduss);
                }
                String string4 = com.baidu.live.c.uN().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0717a.LO(string4);
                }
                c0717a.LK(cvh.userId);
                c0717a.LL(cvh.userName);
                c0717a.LM(cvh.nickName);
                c0717a.LP(cvh.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0717a.cWS(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0717a.cWS();
                    return;
                }
            }
            this.kUu = 0;
            cWQ();
            C0717a c0717a2 = new C0717a();
            c0717a2.LN(cvh.bduss);
            c0717a2.LL(cvh.userName);
            c0717a2.LM(cvh.nickName);
            c0717a2.LK(cvh.userId);
            c0717a2.LP(cvh.portrait);
            com.baidu.live.c.uN().putString("ala_account_user_id", cvh.userId);
            com.baidu.live.c.uN().putString("ala_account_user_bduss", cvh.bduss);
            TbadkCoreApplication.setCurrentAccount(c0717a2.cWS(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(cvh);
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

    private void cWQ() {
        com.baidu.live.c.uN().remove("ala_account_user_id");
        com.baidu.live.c.uN().remove("ala_account_user_bduss");
        com.baidu.live.c.uN().remove("ala_account_user_tbs");
    }

    private void cWR() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0717a {
        private String BDUSS;
        private AccountData kUA;
        private int kUz;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0717a() {
            this.kUA = new AccountData();
        }

        public C0717a(AccountData accountData) {
            if (accountData == null) {
                this.kUA = new AccountData();
            } else {
                this.kUA = accountData;
            }
        }

        public C0717a LK(String str) {
            this.userId = str;
            return this;
        }

        public C0717a LL(String str) {
            this.userName = str;
            return this;
        }

        public C0717a LM(String str) {
            this.nickName = str;
            return this;
        }

        public C0717a LN(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0717a LO(String str) {
            this.tbs = str;
            return this;
        }

        public C0717a LP(String str) {
            this.portrait = str;
            return this;
        }

        public C0717a CK(int i) {
            this.sex = i;
            return this;
        }

        public C0717a CL(int i) {
            this.kUz = i;
            return this;
        }

        public AccountData cWS() {
            this.kUA.setBDUSS(this.BDUSS);
            this.kUA.setAccount(this.userName);
            this.kUA.setDisplayName(this.nickName);
            this.kUA.setID(this.userId);
            this.kUA.setPortrait(this.portrait);
            this.kUA.setTbs(this.tbs);
            this.kUA.setSex(this.sex);
            this.kUA.setIsActive(this.kUz);
            return this.kUA;
        }
    }
}
