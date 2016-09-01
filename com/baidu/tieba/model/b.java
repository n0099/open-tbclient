package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0033a interfaceC0033a) {
        com.baidu.tbadk.core.a.h hVar = new com.baidu.tbadk.core.a.h();
        a aVar = new a(str, str2, str3, interfaceC0033a, false);
        if (com.baidu.tbadk.core.a.h.oV() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0033a, str));
        } else {
            if (com.baidu.tbadk.core.a.h.oV()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static AccountData F(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.uD().vz().mIsUseCurrentBDUSS = false;
        abVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        abVar.uD().vz().acp = false;
        String ue = abVar.ue();
        if (abVar.uD().vA().oE() && ue != null) {
            ae aeVar = new ae();
            aeVar.parserJson(ue);
            AccountData accountData = new AccountData();
            accountData.setAccount(aeVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(aeVar.getUser().getUserId());
            accountData.setBDUSS(aeVar.getUser().getBDUSS());
            accountData.setPortrait(aeVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aeVar.qf() != null) {
                accountData.setTbs(aeVar.qf().getTbs());
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
        private volatile ab aiS = null;
        private final String dWd;
        private final a.InterfaceC0033a dWe;
        private final boolean dWf;
        private final String mName;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.dWd = str2;
            this.Os = str3;
            this.dWf = z;
            this.dWe = interfaceC0033a == null ? new d(this) : interfaceC0033a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dWe.cf(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.aiS = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.aiS.uD().vz().mIsUseCurrentBDUSS = false;
            this.aiS.n("bdusstoken", String.valueOf(this.dWd) + "|" + this.Os);
            if (!StringUtils.isNull(this.mStoken)) {
                this.aiS.n("stoken", this.mStoken);
            }
            this.aiS.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aiS.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aiS.uD().vz().acp = false;
            String ue = this.aiS.ue();
            if (this.aiS.uD().vA().oE() && ue != null) {
                ae aeVar = new ae();
                aeVar.parserJson(ue);
                AccountData accountData = new AccountData();
                accountData.setAccount(aeVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aeVar.getUser().getUserId());
                String bduss = aeVar.getUser().getBDUSS();
                if (this.dWf && (a = h.a(com.baidu.tbadk.core.a.a.oO().ce(bduss))) != null) {
                    bduss = String.valueOf(a.pX) + "|" + a.Os;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(aeVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aeVar.qf() != null) {
                    accountData.setTbs(aeVar.qf().getTbs());
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
            ReloginManager.tN().ay(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.aiS.uH(), this.aiS.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dWe.a(accountData);
                return;
            }
            String str = null;
            if (this.aiS != null) {
                str = this.aiS.getErrorString();
                i = this.aiS.uH();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.data_load_error);
            }
            this.dWe.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiS != null) {
                this.aiS.eg();
            }
        }
    }
}
