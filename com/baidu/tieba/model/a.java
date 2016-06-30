package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a) {
        C0069a c0069a = new C0069a(str, str2, str3, interfaceC0033a, false);
        c0069a.execute(new String[0]);
        return c0069a;
    }

    public static AccountData p(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.ty().uu().mIsUseCurrentBDUSS = false;
        abVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        abVar.ty().uu().YR = false;
        String ta = abVar.ta();
        if (abVar.ty().uv().nU() && ta != null) {
            aa aaVar = new aa();
            aaVar.parserJson(ta);
            AccountData accountData = new AccountData();
            accountData.setAccount(aaVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(aaVar.getUser().getUserId());
            accountData.setBDUSS(aaVar.getUser().getBDUSS());
            accountData.setPortrait(aaVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aaVar.pt() != null) {
                accountData.setTbs(aaVar.pt().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Mg;
        private volatile ab afj = null;
        private final String dFY;
        private final a.InterfaceC0033a dFZ;
        private final boolean dGa;
        private final String mName;

        public C0069a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.dFY = str2;
            this.Mg = str3;
            this.dGa = z;
            this.dFZ = interfaceC0033a == null ? new b(this) : interfaceC0033a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dFZ.cd(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afj = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.afj.ty().uu().mIsUseCurrentBDUSS = false;
            this.afj.n("bdusstoken", String.valueOf(this.dFY) + "|" + this.Mg);
            this.afj.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.afj.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.afj.ty().uu().YR = false;
            String ta = this.afj.ta();
            if (this.afj.ty().uv().nU() && ta != null) {
                aa aaVar = new aa();
                aaVar.parserJson(ta);
                AccountData accountData = new AccountData();
                accountData.setAccount(aaVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aaVar.getUser().getUserId());
                String bduss = aaVar.getUser().getBDUSS();
                if (this.dGa && (a = f.a(com.baidu.tbadk.core.a.a.oe().cc(bduss))) != null) {
                    bduss = String.valueOf(a.mZ) + "|" + a.Mg;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(aaVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (aaVar.pt() != null) {
                    accountData.setTbs(aaVar.pt().getTbs());
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
            ReloginManager.sJ().au(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afj.tC(), this.afj.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dFZ.a(accountData);
                return;
            }
            String str = null;
            if (this.afj != null) {
                str = this.afj.getErrorString();
                i = this.afj.tC();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.data_load_error);
            }
            this.dFZ.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afj != null) {
                this.afj.dm();
            }
        }
    }
}
