package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ad;
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
        abVar.tx().uu().mIsUseCurrentBDUSS = false;
        abVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.n("channel_id", TbadkCoreApplication.m10getInst().getPushChannelId());
        abVar.n("channel_uid", TbadkCoreApplication.m10getInst().getPushChannelUserId());
        abVar.tx().uu().ZA = false;
        String sZ = abVar.sZ();
        if (abVar.tx().uv().nJ() && sZ != null) {
            ad adVar = new ad();
            adVar.parserJson(sZ);
            AccountData accountData = new AccountData();
            accountData.setAccount(adVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(adVar.getUser().getUserId());
            accountData.setBDUSS(adVar.getUser().getBDUSS());
            accountData.setPortrait(adVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (adVar.pc() != null) {
                accountData.setTbs(adVar.pc().getTbs());
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
        private final String Me;
        private volatile ab afX = null;
        private final String dKk;
        private final a.InterfaceC0033a dKl;
        private final boolean dKm;
        private final String mName;

        public C0069a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.dKk = str2;
            this.Me = str3;
            this.dKm = z;
            this.dKl = interfaceC0033a == null ? new b(this) : interfaceC0033a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dKl.ce(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afX = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.afX.tx().uu().mIsUseCurrentBDUSS = false;
            this.afX.n("bdusstoken", String.valueOf(this.dKk) + "|" + this.Me);
            this.afX.n("channel_id", TbadkCoreApplication.m10getInst().getPushChannelId());
            this.afX.n("channel_uid", TbadkCoreApplication.m10getInst().getPushChannelUserId());
            this.afX.tx().uu().ZA = false;
            String sZ = this.afX.sZ();
            if (this.afX.tx().uv().nJ() && sZ != null) {
                ad adVar = new ad();
                adVar.parserJson(sZ);
                AccountData accountData = new AccountData();
                accountData.setAccount(adVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(adVar.getUser().getUserId());
                String bduss = adVar.getUser().getBDUSS();
                if (this.dKm && (a = f.a(com.baidu.tbadk.core.a.a.nT().cd(bduss))) != null) {
                    bduss = String.valueOf(a.nC) + "|" + a.Me;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(adVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (adVar.pc() != null) {
                    accountData.setTbs(adVar.pc().getTbs());
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
            ReloginManager.sI().ax(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afX.tB(), this.afX.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dKl.a(accountData);
                return;
            }
            String str = null;
            if (this.afX != null) {
                str = this.afX.getErrorString();
                i = this.afX.tB();
            }
            if (str == null) {
                str = TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.data_load_error);
            }
            this.dKl.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afX != null) {
                this.afX.dl();
            }
        }
    }
}
