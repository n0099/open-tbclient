package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0033a interfaceC0033a) {
        com.baidu.tbadk.core.a.h hVar = new com.baidu.tbadk.core.a.h();
        a aVar = new a(str, str2, str3, interfaceC0033a, false);
        if (com.baidu.tbadk.core.a.h.oW() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0033a, str));
        } else {
            if (com.baidu.tbadk.core.a.h.oW()) {
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
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.uS().vN().mIsUseCurrentBDUSS = false;
        abVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        abVar.uS().vN().acA = false;
        String uu = abVar.uu();
        if (abVar.uS().vO().oF() && uu != null) {
            ag agVar = new ag();
            agVar.parserJson(uu);
            AccountData accountData = new AccountData();
            accountData.setAccount(agVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(agVar.getUser().getUserId());
            accountData.setBDUSS(agVar.getUser().getBDUSS());
            accountData.setPortrait(agVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (agVar.qq() != null) {
                accountData.setTbs(agVar.qq().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Ot;
        private volatile ab aiu = null;
        private final String dXX;
        private final a.InterfaceC0033a dXY;
        private final boolean dXZ;
        private final String mName;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.dXX = str2;
            this.Ot = str3;
            this.dXZ = z;
            this.dXY = interfaceC0033a == null ? new d(this) : interfaceC0033a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dXY.cf(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.aiu = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.aiu.uS().vN().mIsUseCurrentBDUSS = false;
            this.aiu.n("bdusstoken", String.valueOf(this.dXX) + "|" + this.Ot);
            if (!StringUtils.isNull(this.mStoken)) {
                this.aiu.n("stoken", this.mStoken);
            }
            this.aiu.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.aiu.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.aiu.uS().vN().acA = false;
            String uu = this.aiu.uu();
            if (this.aiu.uS().vO().oF() && uu != null) {
                ag agVar = new ag();
                agVar.parserJson(uu);
                AccountData accountData = new AccountData();
                accountData.setAccount(agVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(agVar.getUser().getUserId());
                String bduss = agVar.getUser().getBDUSS();
                if (this.dXZ && (a = h.a(com.baidu.tbadk.core.a.a.oP().ce(bduss))) != null) {
                    bduss = String.valueOf(a.pX) + "|" + a.Ot;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(agVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (agVar.qq() != null) {
                    accountData.setTbs(agVar.qq().getTbs());
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
            ReloginManager.uc().ay(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.aiu.uW(), this.aiu.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dXY.a(accountData);
                return;
            }
            String str = null;
            if (this.aiu != null) {
                str = this.aiu.getErrorString();
                i = this.aiu.uW();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.data_load_error);
            }
            this.dXY.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiu != null) {
                this.aiu.eg();
            }
        }
    }
}
