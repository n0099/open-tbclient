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
        new C0069a(str, str2, str3, interfaceC0041a, false).execute(new String[0]);
    }

    public static AccountData k(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.uw().vp().mIsUseCurrentBDUSS = false;
        abVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        abVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        abVar.uw().vp().adq = false;
        String tV = abVar.tV();
        if (abVar.uw().vq().qO() && tV != null) {
            n nVar = new n();
            nVar.parserJson(tV);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.rI() != null) {
                accountData.setTbs(nVar.rI().getTbs());
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
        private final String Uv;
        private volatile ab ahV = null;
        private final String cxF;
        private final a.InterfaceC0041a cxG;
        private final boolean cxH;
        private final String mName;

        public C0069a(String str, String str2, String str3, a.InterfaceC0041a interfaceC0041a, boolean z) {
            this.mName = str;
            this.cxF = str2;
            this.Uv = str3;
            this.cxH = z;
            this.cxG = interfaceC0041a == null ? new b(this) : interfaceC0041a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cxG.ck(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.ahV = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.ahV.uw().vp().mIsUseCurrentBDUSS = false;
            this.ahV.o("bdusstoken", String.valueOf(this.cxF) + "|" + this.Uv);
            this.ahV.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.ahV.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.ahV.uw().vp().adq = false;
            String tV = this.ahV.tV();
            if (this.ahV.uw().vq().qO() && tV != null) {
                n nVar = new n();
                nVar.parserJson(tV);
                AccountData accountData = new AccountData();
                accountData.setAccount(nVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(nVar.getUser().getUserId());
                String bduss = nVar.getUser().getBDUSS();
                if (this.cxH && (a = f.a(com.baidu.tbadk.core.a.a.qY().cj(bduss))) != null) {
                    bduss = String.valueOf(a.wA) + "|" + a.Uv;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(nVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (nVar.rI() != null) {
                    accountData.setTbs(nVar.rI().getTbs());
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
            ReloginManager.tE().aq(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.ahV.uA(), this.ahV.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.cxG.a(accountData);
                return;
            }
            String str = null;
            if (this.ahV != null) {
                str = this.ahV.getErrorString();
                i = this.ahV.uA();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.j.data_load_error);
            }
            this.cxG.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.ahV != null) {
                this.ahV.gL();
            }
        }
    }
}
