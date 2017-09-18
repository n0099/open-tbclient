package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(final String str, String str2, String str3, String str4, final a.InterfaceC0043a interfaceC0043a) {
        e eVar = new e();
        final a aVar = new a(str, str2, str3, interfaceC0043a, false);
        if (e.ph() && StringUtils.isNull(str4)) {
            eVar.a(str2, new e.a() { // from class: com.baidu.tieba.model.b.1
                @Override // com.baidu.tbadk.core.a.e.a
                public void onSuccess(String str5) {
                    a.this.setStoken(str5);
                    a.this.execute(new String[0]);
                }

                @Override // com.baidu.tbadk.core.a.e.a
                public void onFailed() {
                    if (interfaceC0043a != null) {
                        interfaceC0043a.c(str, 1, null);
                    }
                }
            });
        } else {
            if (e.ph()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0043a interfaceC0043a) {
        a aVar = new a(str, str2, str3, interfaceC0043a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData G(String str, String str2, String str3) {
        x xVar = new x(TbConfig.LOGIN_FULL_ADDRESS);
        xVar.vj().wf().mIsUseCurrentBDUSS = false;
        xVar.n("bdusstoken", str2 + "|" + str3);
        xVar.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
        xVar.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
        xVar.vj().wf().aij = false;
        String uM = xVar.uM();
        if (xVar.vj().wg().isRequestSuccess() && uM != null) {
            ak akVar = new ak();
            akVar.parserJson(uM);
            AccountData accountData = new AccountData();
            accountData.setAccount(akVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(akVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(akVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (akVar.qn() != null) {
                accountData.setTbs(akVar.qn().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String SS;
        private final String ewA;
        private final a.InterfaceC0043a ewB;
        private final boolean ewC;
        private final String mName;
        private volatile x mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0043a interfaceC0043a, boolean z) {
            this.mName = str;
            this.ewA = str2;
            this.SS = str3;
            this.ewC = z;
            this.ewB = interfaceC0043a == null ? new a.InterfaceC0043a() { // from class: com.baidu.tieba.model.b.a.1
                @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
                public void cp(String str4) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
                public void a(AccountData accountData) {
                }

                @Override // com.baidu.tbadk.core.a.a.InterfaceC0043a
                public void c(String str4, int i, String str5) {
                }
            } : interfaceC0043a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ewB.cp(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new x(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.vj().wf().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", this.ewA + "|" + this.SS);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.getInst().getPushChannelUserId());
            this.mNetwork.vj().wf().aij = false;
            String uM = this.mNetwork.uM();
            if (this.mNetwork.vj().wg().isRequestSuccess() && uM != null) {
                ak akVar = new ak();
                akVar.parserJson(uM);
                AccountData accountData = new AccountData();
                accountData.setAccount(akVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(akVar.getUser().getUserId());
                String str = this.ewA;
                if (this.ewC && (a = d.a(com.baidu.tbadk.core.a.a.pa().co(str))) != null) {
                    str = a.wq + "|" + a.SS;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(akVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (akVar.qn() != null) {
                    accountData.setTbs(akVar.qn().getTbs());
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.uu().az(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.vn(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.ewB.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.vn();
            }
            if (str == null) {
                str = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.data_load_error);
            }
            this.ewB.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fp();
            }
        }
    }
}
