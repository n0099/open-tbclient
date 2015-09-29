package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        new C0067a(str, str2, str3, interfaceC0040a, false).execute(new String[0]);
    }

    public static AccountData k(String str, String str2, String str3) {
        w wVar = new w(TbConfig.LOGIN_FULL_ADDRESS);
        wVar.uh().uX().mIsUseCurrentBDUSS = false;
        wVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        wVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        wVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        wVar.uh().uX().abL = false;
        String tG = wVar.tG();
        if (wVar.uh().uY().qV() && tG != null) {
            k kVar = new k();
            kVar.parserJson(tG);
            AccountData accountData = new AccountData();
            accountData.setAccount(kVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(kVar.getUser().getUserId());
            accountData.setBDUSS(kVar.getUser().getBDUSS());
            accountData.setPortrait(kVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (kVar.rF() != null) {
                accountData.setTbs(kVar.rF().getTbs());
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
        private final String TC;
        private volatile w afg = null;
        private final String caV;
        private final a.InterfaceC0040a caW;
        private final boolean caX;
        private final String mName;

        public C0067a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a, boolean z) {
            this.mName = str;
            this.caV = str2;
            this.TC = str3;
            this.caX = z;
            this.caW = interfaceC0040a == null ? new b(this) : interfaceC0040a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.caW.cc(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afg = new w(TbConfig.LOGIN_FULL_ADDRESS);
            this.afg.uh().uX().mIsUseCurrentBDUSS = false;
            this.afg.o("bdusstoken", String.valueOf(this.caV) + "|" + this.TC);
            this.afg.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.afg.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.afg.uh().uX().abL = false;
            String tG = this.afg.tG();
            if (this.afg.uh().uY().qV() && tG != null) {
                k kVar = new k();
                kVar.parserJson(tG);
                AccountData accountData = new AccountData();
                accountData.setAccount(kVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(kVar.getUser().getUserId());
                String bduss = kVar.getUser().getBDUSS();
                if (this.caX && (a = f.a(com.baidu.tbadk.core.a.a.rd().cb(bduss))) != null) {
                    bduss = String.valueOf(a.ws) + "|" + a.TC;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(kVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (kVar.rF() != null) {
                    accountData.setTbs(kVar.rF().getTbs());
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
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afg.ul(), this.afg.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.caW.a(accountData);
                return;
            }
            String str = null;
            if (this.afg != null) {
                str = this.afg.getErrorString();
                i = this.afg.ul();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.data_load_error);
            }
            this.caW.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afg != null) {
                this.afg.gJ();
            }
        }
    }
}
