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
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0070a interfaceC0070a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0070a, false);
        if (e.wO() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0070a != null) {
                        interfaceC0070a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.wO()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0070a interfaceC0070a) {
        a aVar = new a(str, str2, str3, interfaceC0070a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String aIq;
        private final String frC;
        private final a.InterfaceC0070a frD;
        private final boolean frE;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0070a interfaceC0070a, boolean z) {
            this.mName = str;
            this.frC = str2;
            this.aIq = str3;
            this.frE = z;
            this.frD = interfaceC0070a == null ? new a.InterfaceC0070a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0070a
                public void cB(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0070a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0070a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0070a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.frD.cB(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.Cf().Db().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.frC + "|" + this.aIq);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.Cf().Db().aWy = false;
            String BH = this.mNetwork.BH();
            if (this.mNetwork.Cf().Dc().isRequestSuccess() && BH != null) {
                ae aeVar = new ae();
                aeVar.parserJson(BH);
                AccountData accountData = new AccountData();
                accountData.setAccount(aeVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aeVar.getUser().getUserId());
                String str = this.frC;
                if (this.frE && (a = d.a(com.baidu.tbadk.core.a.a.wH().cA(str))) != null) {
                    str = a.akC + "|" + a.aIq;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(aeVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aeVar.xG() != null) {
                    accountData.setTbs(aeVar.xG().getTbs());
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
            ReloginManager.Bp().be(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.Cj(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.frD.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.Cj();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.data_load_error);
            }
            this.frD.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.mR();
            }
        }
    }
}
