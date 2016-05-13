package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a) {
        C0065a c0065a = new C0065a(str, str2, str3, interfaceC0033a, false);
        c0065a.execute(new String[0]);
        return c0065a;
    }

    public static AccountData l(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.tB().uv().mIsUseCurrentBDUSS = false;
        abVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.n("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
        abVar.n("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
        abVar.tB().uv().YA = false;
        String td = abVar.td();
        if (abVar.tB().uw().nZ() && td != null) {
            y yVar = new y();
            yVar.parserJson(td);
            AccountData accountData = new AccountData();
            accountData.setAccount(yVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(yVar.getUser().getUserId());
            accountData.setBDUSS(yVar.getUser().getBDUSS());
            accountData.setPortrait(yVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (yVar.pz() != null) {
                accountData.setTbs(yVar.pz().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0065a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Mg;
        private volatile ab aeI = null;
        private final String cZq;
        private final a.InterfaceC0033a cZr;
        private final boolean cZs;
        private final String mName;

        public C0065a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.cZq = str2;
            this.Mg = str3;
            this.cZs = z;
            this.cZr = interfaceC0033a == null ? new b(this) : interfaceC0033a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cZr.ce(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.aeI = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.aeI.tB().uv().mIsUseCurrentBDUSS = false;
            this.aeI.n("bdusstoken", String.valueOf(this.cZq) + "|" + this.Mg);
            this.aeI.n("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
            this.aeI.n("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
            this.aeI.tB().uv().YA = false;
            String td = this.aeI.td();
            if (this.aeI.tB().uw().nZ() && td != null) {
                y yVar = new y();
                yVar.parserJson(td);
                AccountData accountData = new AccountData();
                accountData.setAccount(yVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(yVar.getUser().getUserId());
                String bduss = yVar.getUser().getBDUSS();
                if (this.cZs && (a = f.a(com.baidu.tbadk.core.a.a.oj().cd(bduss))) != null) {
                    bduss = String.valueOf(a.mZ) + "|" + a.Mg;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(yVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (yVar.pz() != null) {
                    accountData.setTbs(yVar.pz().getTbs());
                    return accountData;
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
            ReloginManager.sM().aw(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.aeI.tF(), this.aeI.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.cZr.a(accountData);
                return;
            }
            String str = null;
            if (this.aeI != null) {
                str = this.aeI.getErrorString();
                i = this.aeI.tF();
            }
            if (str == null) {
                str = TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.data_load_error);
            }
            this.cZr.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aeI != null) {
                this.aeI.dl();
            }
        }
    }
}
