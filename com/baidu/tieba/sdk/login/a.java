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
/* loaded from: classes10.dex */
public class a {
    private static volatile a nfJ;
    private c bgH;
    private int nfK;
    private com.baidu.tieba.sdk.b.a nfL;
    private CustomMessageTask.CustomRunnable<Object> nfM = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.sdk.login.a.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            a.this.ddH();
            return null;
        }
    };
    private final HttpMessageListener nfN = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.sdk.login.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetLoginTbsResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (a.this.nfK < 3) {
                        a.b(a.this);
                        a.this.a(a.this.nfL.ddG());
                        return;
                    }
                    return;
                }
                a.this.nfK = 0;
            }
        }
    };

    static /* synthetic */ int b(a aVar) {
        int i = aVar.nfK;
        aVar.nfK = i + 1;
        return i;
    }

    public static a dFY() {
        if (nfJ == null) {
            synchronized (a.class) {
                if (nfJ == null) {
                    nfJ = new a();
                }
            }
        }
        return nfJ;
    }

    private a() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.login.a.a(0));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN, this.nfM);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(this.nfN);
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

    public void ddH() {
        if (this.nfL != null) {
            this.nfL.ddH();
        }
    }

    public void b(com.baidu.tieba.sdk.b.a aVar) {
        this.nfL = aVar;
    }

    public void dFZ() {
        if (this.nfL != null) {
            dGc();
            if (this.bgH == null) {
                this.bgH = new c();
            }
            this.bgH.initListener();
            this.bgH.a(new e() { // from class: com.baidu.tieba.sdk.login.a.3
                @Override // com.baidu.live.e
                public void xg() {
                    if (a.this.bgH != null) {
                        a.this.bgH.onDestroy();
                    }
                }
            });
            this.bgH.refreshCurUserScores();
            Intent intent = new Intent("action_callback_live_login_result");
            intent.putExtra("status", TbadkCoreApplication.isLogin());
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleLoginResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void Tz() {
        if (this.nfL != null) {
            dGc();
        }
    }

    public boolean dGa() {
        if (this.nfL == null) {
            return false;
        }
        boolean dGc = dGc();
        if (!dGc) {
            this.nfL.ddH();
            return dGc;
        }
        return dGc;
    }

    public com.baidu.tieba.sdk.c.a dGb() {
        if (this.nfL != null) {
            return this.nfL.ddG();
        }
        return null;
    }

    private boolean dGc() {
        com.baidu.tieba.sdk.c.a ddG = this.nfL.ddG();
        if (ddG != null && ddG.isValid()) {
            dGd();
            if (AccountHelper.getOnSyncAccountCallback() != null) {
                AccountHelper.getOnSyncAccountCallback().onSyncAccount(true);
                return true;
            }
            return true;
        }
        dGf();
        dGe();
        if (AccountHelper.getOnSyncAccountCallback() != null) {
            AccountHelper.getOnSyncAccountCallback().onSyncAccount(false);
        }
        return false;
    }

    private void dGd() {
        boolean z = true;
        com.baidu.tieba.sdk.c.a ddG = this.nfL.ddG();
        if (ddG != null) {
            String string = d.xf().getString("ala_account_user_id", "");
            String string2 = d.xf().getString("ala_account_user_bduss", "");
            boolean z2 = !StringUtils.isNull(ddG.userId) && ddG.userId.equals(string);
            if (StringUtils.isNull(ddG.bduss) || !ddG.bduss.equals(string2)) {
                z = false;
            }
            if (z2 && z) {
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                C0869a c0869a = new C0869a(currentAccountInfo);
                String string3 = d.xf().getString("ala_account_user_bduss", "");
                if (!StringUtils.isNull(string3)) {
                    c0869a.Sx(string3);
                } else {
                    c0869a.Sx(ddG.bduss);
                }
                String string4 = d.xf().getString("ala_account_user_tbs", "");
                if (!StringUtils.isNull(string4)) {
                    c0869a.Sy(string4);
                }
                c0869a.Su(ddG.userId);
                c0869a.Sv(ddG.userName);
                c0869a.Sw(ddG.nickName);
                c0869a.Sz(ddG.portrait);
                if (currentAccountInfo == null) {
                    TbadkCoreApplication.setCurrentAccount(c0869a.dGg(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
                    return;
                } else {
                    c0869a.dGg();
                    return;
                }
            }
            this.nfK = 0;
            dGe();
            C0869a c0869a2 = new C0869a();
            c0869a2.Sx(ddG.bduss);
            c0869a2.Sv(ddG.userName);
            c0869a2.Sw(ddG.nickName);
            c0869a2.Su(ddG.userId);
            c0869a2.Sz(ddG.portrait);
            d.xf().putString("ala_account_user_id", ddG.userId);
            d.xf().putString("ala_account_user_bduss", ddG.bduss);
            TbadkCoreApplication.setCurrentAccount(c0869a2.dGg(), TbadkCoreApplication.getInst().getApp().getApplicationContext());
            a(ddG);
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

    private void dGe() {
        d.xf().remove("ala_account_user_id");
        d.xf().remove("ala_account_user_bduss");
        d.xf().remove("ala_account_user_tbs");
    }

    private void dGf() {
        TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
    }

    /* renamed from: com.baidu.tieba.sdk.login.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0869a {
        private String BDUSS;
        private int nfP;
        private AccountData nfQ;
        private String nickName;
        private String portrait;
        private int sex;
        private String tbs;
        private String userId;
        private String userName;

        public C0869a() {
            this.nfQ = new AccountData();
        }

        public C0869a(AccountData accountData) {
            if (accountData == null) {
                this.nfQ = new AccountData();
            } else {
                this.nfQ = accountData;
            }
        }

        public C0869a Su(String str) {
            this.userId = str;
            return this;
        }

        public C0869a Sv(String str) {
            this.userName = str;
            return this;
        }

        public C0869a Sw(String str) {
            this.nickName = str;
            return this;
        }

        public C0869a Sx(String str) {
            this.BDUSS = str;
            return this;
        }

        public C0869a Sy(String str) {
            this.tbs = str;
            return this;
        }

        public C0869a Sz(String str) {
            this.portrait = str;
            return this;
        }

        public C0869a Iv(int i) {
            this.sex = i;
            return this;
        }

        public C0869a Iw(int i) {
            this.nfP = i;
            return this;
        }

        public AccountData dGg() {
            this.nfQ.setBDUSS(this.BDUSS);
            this.nfQ.setAccount(this.userName);
            this.nfQ.setDisplayName(this.nickName);
            this.nfQ.setID(this.userId);
            this.nfQ.setPortrait(this.portrait);
            this.nfQ.setTbs(this.tbs);
            this.nfQ.setSex(this.sex);
            this.nfQ.setIsActive(this.nfP);
            return this.nfQ;
        }
    }
}
