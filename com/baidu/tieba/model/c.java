package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0035a interfaceC0035a) {
        com.baidu.tbadk.core.a.h hVar = new com.baidu.tbadk.core.a.h();
        a aVar = new a(str, str2, str3, interfaceC0035a, false);
        if (com.baidu.tbadk.core.a.h.pc() && StringUtils.isNull(str4)) {
            hVar.a(str2, new d(aVar, interfaceC0035a, str));
        } else {
            if (com.baidu.tbadk.core.a.h.pc()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0035a interfaceC0035a) {
        a aVar = new a(str, str2, str3, interfaceC0035a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData B(String str, String str2, String str3) {
        z zVar = new z(TbConfig.LOGIN_FULL_ADDRESS);
        zVar.uF().vA().mIsUseCurrentBDUSS = false;
        zVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        zVar.uF().vA().agr = false;
        String ug = zVar.ug();
        if (zVar.uF().vB().isRequestSuccess() && ug != null) {
            ak akVar = new ak();
            akVar.parserJson(ug);
            AccountData accountData = new AccountData();
            accountData.setAccount(akVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(akVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(akVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (akVar.qh() != null) {
                accountData.setTbs(akVar.qh().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Sh;
        private final String dUe;
        private final a.InterfaceC0035a dUf;
        private final boolean dUg;
        private final String mName;
        private volatile z mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0035a interfaceC0035a, boolean z) {
            this.mName = str;
            this.dUe = str2;
            this.Sh = str3;
            this.dUg = z;
            this.dUf = interfaceC0035a == null ? new e(this) : interfaceC0035a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dUf.cf(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.uF().vA().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", String.valueOf(this.dUe) + "|" + this.Sh);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.mNetwork.uF().vA().agr = false;
            String ug = this.mNetwork.ug();
            if (this.mNetwork.uF().vB().isRequestSuccess() && ug != null) {
                ak akVar = new ak();
                akVar.parserJson(ug);
                AccountData accountData = new AccountData();
                accountData.setAccount(akVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(akVar.getUser().getUserId());
                String str = this.dUe;
                if (this.dUg && (a = h.a(com.baidu.tbadk.core.a.a.oV().ce(str))) != null) {
                    str = String.valueOf(a.mBduss) + "|" + a.Sh;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(akVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (akVar.qh() != null) {
                    accountData.setTbs(akVar.qh().getTbs());
                    return accountData;
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
            ReloginManager.tR().az(false);
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.uJ(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dUf.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.uJ();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.data_load_error);
            }
            this.dUf.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fs();
            }
        }
    }
}
