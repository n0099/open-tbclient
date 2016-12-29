package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0033a interfaceC0033a) {
        com.baidu.tbadk.core.a.h hVar = new com.baidu.tbadk.core.a.h();
        a aVar = new a(str, str2, str3, interfaceC0033a, false);
        if (com.baidu.tbadk.core.a.h.oY() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0033a, str));
        } else {
            if (com.baidu.tbadk.core.a.h.oY()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0033a interfaceC0033a) {
        a aVar = new a(str, str2, str3, interfaceC0033a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData F(String str, String str2, String str3) {
        z zVar = new z(TbConfig.LOGIN_FULL_ADDRESS);
        zVar.uI().vB().mIsUseCurrentBDUSS = false;
        zVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        zVar.uI().vB().acr = false;
        String uk = zVar.uk();
        if (zVar.uI().vC().oH() && uk != null) {
            ah ahVar = new ah();
            ahVar.parserJson(uk);
            AccountData accountData = new AccountData();
            accountData.setAccount(ahVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(ahVar.getUser().getUserId());
            accountData.setBDUSS(ahVar.getUser().getBDUSS());
            accountData.setPortrait(ahVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ahVar.qt() != null) {
                accountData.setTbs(ahVar.qt().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Os;
        private volatile z aiN = null;
        private final String dID;
        private final a.InterfaceC0033a dIE;
        private final boolean dIF;
        private final String mName;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.dID = str2;
            this.Os = str3;
            this.dIF = z;
            this.dIE = interfaceC0033a == null ? new d(this) : interfaceC0033a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dIE.ch(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.aiN = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.aiN.uI().vB().mIsUseCurrentBDUSS = false;
            this.aiN.n("bdusstoken", String.valueOf(this.dID) + "|" + this.Os);
            if (!StringUtils.isNull(this.mStoken)) {
                this.aiN.n("stoken", this.mStoken);
            }
            this.aiN.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aiN.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aiN.uI().vB().acr = false;
            String uk = this.aiN.uk();
            if (this.aiN.uI().vC().oH() && uk != null) {
                ah ahVar = new ah();
                ahVar.parserJson(uk);
                AccountData accountData = new AccountData();
                accountData.setAccount(ahVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(ahVar.getUser().getUserId());
                String bduss = ahVar.getUser().getBDUSS();
                if (this.dIF && (a = h.a(com.baidu.tbadk.core.a.a.oR().cg(bduss))) != null) {
                    bduss = String.valueOf(a.pY) + "|" + a.Os;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(ahVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (ahVar.qt() != null) {
                    accountData.setTbs(ahVar.qt().getTbs());
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
            ReloginManager.tR().aC(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.aiN.uM(), this.aiN.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dIE.a(accountData);
                return;
            }
            String str = null;
            if (this.aiN != null) {
                str = this.aiN.getErrorString();
                i = this.aiN.uM();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.data_load_error);
            }
            this.dIE.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiN != null) {
                this.aiN.eg();
            }
        }
    }
}
