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
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0071a interfaceC0071a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0071a, false);
        if (e.wP() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0071a != null) {
                        interfaceC0071a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.wP()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0071a interfaceC0071a) {
        a aVar = new a(str, str2, str3, interfaceC0071a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String aIs;
        private final String fqb;
        private final a.InterfaceC0071a fqc;
        private final boolean fqd;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0071a interfaceC0071a, boolean z) {
            this.mName = str;
            this.fqb = str2;
            this.aIs = str3;
            this.fqd = z;
            this.fqc = interfaceC0071a == null ? new a.InterfaceC0071a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0071a
                public void cB(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0071a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0071a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0071a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fqc.cB(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.Cn().Dk().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.fqb + "|" + this.aIs);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.Cn().Dk().aWz = false;
            String BP = this.mNetwork.BP();
            if (this.mNetwork.Cn().Dl().isRequestSuccess() && BP != null) {
                af afVar = new af();
                afVar.parserJson(BP);
                AccountData accountData = new AccountData();
                accountData.setAccount(afVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(afVar.getUser().getUserId());
                String str = this.fqb;
                if (this.fqd && (a = d.a(com.baidu.tbadk.core.a.a.wI().cA(str))) != null) {
                    str = a.akC + "|" + a.aIs;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(afVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (afVar.xJ() != null) {
                    accountData.setTbs(afVar.xJ().getTbs());
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
            ReloginManager.Bx().be(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.Cr(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.fqc.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.Cr();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.data_load_error);
            }
            this.fqc.c(this.mName, i, str);
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
