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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0083a interfaceC0083a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0083a, false);
        if (e.qm() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0083a != null) {
                        interfaceC0083a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.qm()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String UZ;
        private final String eQl;
        private final a.InterfaceC0083a eQm;
        private final boolean eQn;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0083a interfaceC0083a, boolean z) {
            this.mName = str;
            this.eQl = str2;
            this.UZ = str3;
            this.eQn = z;
            this.eQm = interfaceC0083a == null ? new a.InterfaceC0083a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
                public void cE(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0083a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eQm.cE(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.vj().wi().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.eQl + "|" + this.UZ);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.vj().wi().ajD = false;
            String uL = this.mNetwork.uL();
            if (this.mNetwork.vj().wj().isRequestSuccess() && uL != null) {
                af afVar = new af();
                afVar.parserJson(uL);
                AccountData accountData = new AccountData();
                accountData.setAccount(afVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(afVar.getUser().getUserId());
                String str = this.eQl;
                if (this.eQn && (a = d.a(com.baidu.tbadk.core.a.a.qf().cD(str))) != null) {
                    str = a.vc + "|" + a.UZ;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(afVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (afVar.qT() != null) {
                    accountData.setTbs(afVar.qT().getTbs());
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
            ReloginManager.us().aA(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.vn(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.eQm.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.vn();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.data_load_error);
            }
            this.eQm.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
        }
    }
}
