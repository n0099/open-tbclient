package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        new C0067a(str, str2, str3, interfaceC0040a, false).execute(new String[0]);
    }

    public static AccountData j(String str, String str2, String str3) {
        w wVar = new w(TbConfig.LOGIN_FULL_ADDRESS);
        wVar.ue().uV().mIsUseCurrentBDUSS = false;
        wVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        wVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        wVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        wVar.ue().uV().abO = false;
        String tD = wVar.tD();
        if (wVar.ue().uW().qS() && tD != null) {
            l lVar = new l();
            lVar.parserJson(tD);
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rC() != null) {
                accountData.setTbs(lVar.rC().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0067a extends BdAsyncTask<String, Integer, AccountData> {
        private final String TD;
        private volatile w afh = null;
        private final String cbg;
        private final a.InterfaceC0040a cbh;
        private final boolean cbi;
        private final String mName;

        public C0067a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a, boolean z) {
            this.mName = str;
            this.cbg = str2;
            this.TD = str3;
            this.cbi = z;
            this.cbh = interfaceC0040a == null ? new b(this) : interfaceC0040a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cbh.cd(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afh = new w(TbConfig.LOGIN_FULL_ADDRESS);
            this.afh.ue().uV().mIsUseCurrentBDUSS = false;
            this.afh.o("bdusstoken", String.valueOf(this.cbg) + "|" + this.TD);
            this.afh.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.afh.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.afh.ue().uV().abO = false;
            String tD = this.afh.tD();
            if (this.afh.ue().uW().qS() && tD != null) {
                l lVar = new l();
                lVar.parserJson(tD);
                AccountData accountData = new AccountData();
                accountData.setAccount(lVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(lVar.getUser().getUserId());
                String bduss = lVar.getUser().getBDUSS();
                if (this.cbi && (a = f.a(com.baidu.tbadk.core.a.a.ra().cc(bduss))) != null) {
                    bduss = String.valueOf(a.ws) + "|" + a.TD;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(lVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (lVar.rC() != null) {
                    accountData.setTbs(lVar.rC().getTbs());
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
            ReloginManager.tm().aq(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afh.ui(), this.afh.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.cbh.a(accountData);
                return;
            }
            String str = null;
            if (this.afh != null) {
                str = this.afh.getErrorString();
                i = this.afh.ui();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.data_load_error);
            }
            this.cbh.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afh != null) {
                this.afh.gJ();
            }
        }
    }
}
