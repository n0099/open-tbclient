package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0094a interfaceC0094a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0094a, false);
        if (e.xC() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0094a != null) {
                        interfaceC0094a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.xC()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0094a interfaceC0094a) {
        a aVar = new a(str, str2, str3, interfaceC0094a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String aJD;
        private final String fvC;
        private final a.InterfaceC0094a fvD;
        private final boolean fvE;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0094a interfaceC0094a, boolean z) {
            this.mName = str;
            this.fvC = str2;
            this.aJD = str3;
            this.fvE = z;
            this.fvD = interfaceC0094a == null ? new a.InterfaceC0094a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
                public void cM(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0094a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fvD.cM(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.Cz().Dw().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.fvC + "|" + this.aJD);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.Cz().Dw().aYa = false;
            String Cb = this.mNetwork.Cb();
            if (this.mNetwork.Cz().Dx().isRequestSuccess() && Cb != null) {
                ae aeVar = new ae();
                aeVar.parserJson(Cb);
                AccountData accountData = new AccountData();
                accountData.setAccount(aeVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aeVar.getUser().getUserId());
                String str = this.fvC;
                if (this.fvE && (a = d.a(com.baidu.tbadk.core.a.a.xv().cL(str))) != null) {
                    str = a.aky + "|" + a.aJD;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(aeVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aeVar.yn() != null) {
                    accountData.setTbs(aeVar.yn().getTbs());
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.BK().bi(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.CD(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.fvD.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.CD();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.data_load_error);
            }
            this.fvD.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
        }
    }
}
