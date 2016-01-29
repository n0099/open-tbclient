package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2, String str3, a.InterfaceC0042a interfaceC0042a) {
        new C0071a(str, str2, str3, interfaceC0042a, false).execute(new String[0]);
    }

    public static AccountData k(String str, String str2, String str3) {
        aa aaVar = new aa(TbConfig.LOGIN_FULL_ADDRESS);
        aaVar.vB().wv().mIsUseCurrentBDUSS = false;
        aaVar.p("bdusstoken", String.valueOf(str2) + "|" + str3);
        aaVar.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        aaVar.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        aaVar.vB().wv().adM = false;
        String uZ = aaVar.uZ();
        if (aaVar.vB().ww().rl() && uZ != null) {
            r rVar = new r();
            rVar.parserJson(uZ);
            AccountData accountData = new AccountData();
            accountData.setAccount(rVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(rVar.getUser().getUserId());
            accountData.setBDUSS(rVar.getUser().getBDUSS());
            accountData.setPortrait(rVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (rVar.so() != null) {
                accountData.setTbs(rVar.so().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a extends BdAsyncTask<String, Integer, AccountData> {
        private final String TU;
        private volatile aa aiG = null;
        private final String cEm;
        private final a.InterfaceC0042a cEn;
        private final boolean cEo;
        private final String mName;

        public C0071a(String str, String str2, String str3, a.InterfaceC0042a interfaceC0042a, boolean z) {
            this.mName = str;
            this.cEm = str2;
            this.TU = str3;
            this.cEo = z;
            this.cEn = interfaceC0042a == null ? new b(this) : interfaceC0042a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cEn.cj(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.aiG = new aa(TbConfig.LOGIN_FULL_ADDRESS);
            this.aiG.vB().wv().mIsUseCurrentBDUSS = false;
            this.aiG.p("bdusstoken", String.valueOf(this.cEm) + "|" + this.TU);
            this.aiG.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.aiG.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.aiG.vB().wv().adM = false;
            String uZ = this.aiG.uZ();
            if (this.aiG.vB().ww().rl() && uZ != null) {
                r rVar = new r();
                rVar.parserJson(uZ);
                AccountData accountData = new AccountData();
                accountData.setAccount(rVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(rVar.getUser().getUserId());
                String bduss = rVar.getUser().getBDUSS();
                if (this.cEo && (a = f.a(com.baidu.tbadk.core.a.a.rv().ci(bduss))) != null) {
                    bduss = String.valueOf(a.wJ) + "|" + a.TU;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(rVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (rVar.so() != null) {
                    accountData.setTbs(rVar.so().getTbs());
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
            ReloginManager.uJ().ar(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.aiG.vF(), this.aiG.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.cEn.a(accountData);
                return;
            }
            String str = null;
            if (this.aiG != null) {
                str = this.aiG.getErrorString();
                i = this.aiG.vF();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.data_load_error);
            }
            this.cEn.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiG != null) {
                this.aiG.gT();
            }
        }
    }
}
