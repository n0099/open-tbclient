package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2, String str3, a.InterfaceC0041a interfaceC0041a) {
        new C0075a(str, str2, str3, interfaceC0041a, false).execute(new String[0]);
    }

    public static AccountData k(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.uM().vF().mIsUseCurrentBDUSS = false;
        abVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        abVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        abVar.uM().vF().acL = false;
        String ul = abVar.ul();
        if (abVar.uM().vG().rf() && ul != null) {
            n nVar = new n();
            nVar.parserJson(ul);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.rZ() != null) {
                accountData.setTbs(nVar.rZ().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0075a extends BdAsyncTask<String, Integer, AccountData> {
        private final String TV;
        private volatile ab agS = null;
        private final String ctD;
        private final a.InterfaceC0041a ctE;
        private final boolean ctF;
        private final String mName;

        public C0075a(String str, String str2, String str3, a.InterfaceC0041a interfaceC0041a, boolean z) {
            this.mName = str;
            this.ctD = str2;
            this.TV = str3;
            this.ctF = z;
            this.ctE = interfaceC0041a == null ? new b(this) : interfaceC0041a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ctE.ci(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.agS = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.agS.uM().vF().mIsUseCurrentBDUSS = false;
            this.agS.o("bdusstoken", String.valueOf(this.ctD) + "|" + this.TV);
            this.agS.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.agS.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.agS.uM().vF().acL = false;
            String ul = this.agS.ul();
            if (this.agS.uM().vG().rf() && ul != null) {
                n nVar = new n();
                nVar.parserJson(ul);
                AccountData accountData = new AccountData();
                accountData.setAccount(nVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(nVar.getUser().getUserId());
                String bduss = nVar.getUser().getBDUSS();
                if (this.ctF && (a = f.a(com.baidu.tbadk.core.a.a.rp().ch(bduss))) != null) {
                    bduss = String.valueOf(a.wy) + "|" + a.TV;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(nVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (nVar.rZ() != null) {
                    accountData.setTbs(nVar.rZ().getTbs());
                    return accountData;
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.tU().at(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.agS.uQ(), this.agS.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.ctE.a(accountData);
                return;
            }
            String str = null;
            if (this.agS != null) {
                str = this.agS.getErrorString();
                i = this.agS.uQ();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.data_load_error);
            }
            this.ctE.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.agS != null) {
                this.agS.gL();
            }
        }
    }
}
