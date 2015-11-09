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
        wVar.uh().uZ().mIsUseCurrentBDUSS = false;
        wVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        wVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        wVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        wVar.uh().uZ().abT = false;
        String tG = wVar.tG();
        if (wVar.uh().va().qT() && tG != null) {
            l lVar = new l();
            lVar.parserJson(tG);
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rE() != null) {
                accountData.setTbs(lVar.rE().getTbs());
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
        private final String TE;
        private volatile w afm = null;
        private final String cbH;
        private final a.InterfaceC0040a cbI;
        private final boolean cbJ;
        private final String mName;

        public C0067a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a, boolean z) {
            this.mName = str;
            this.cbH = str2;
            this.TE = str3;
            this.cbJ = z;
            this.cbI = interfaceC0040a == null ? new b(this) : interfaceC0040a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cbI.cb(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afm = new w(TbConfig.LOGIN_FULL_ADDRESS);
            this.afm.uh().uZ().mIsUseCurrentBDUSS = false;
            this.afm.o("bdusstoken", String.valueOf(this.cbH) + "|" + this.TE);
            this.afm.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.afm.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.afm.uh().uZ().abT = false;
            String tG = this.afm.tG();
            if (this.afm.uh().va().qT() && tG != null) {
                l lVar = new l();
                lVar.parserJson(tG);
                AccountData accountData = new AccountData();
                accountData.setAccount(lVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(lVar.getUser().getUserId());
                String bduss = lVar.getUser().getBDUSS();
                if (this.cbJ && (a = f.a(com.baidu.tbadk.core.a.a.rb().ca(bduss))) != null) {
                    bduss = String.valueOf(a.ws) + "|" + a.TE;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(lVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (lVar.rE() != null) {
                    accountData.setTbs(lVar.rE().getTbs());
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
            ReloginManager.tp().aq(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afm.ul(), this.afm.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.cbI.a(accountData);
                return;
            }
            String str = null;
            if (this.afm != null) {
                str = this.afm.getErrorString();
                i = this.afm.ul();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.data_load_error);
            }
            this.cbI.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afm != null) {
                this.afm.gJ();
            }
        }
    }
}
