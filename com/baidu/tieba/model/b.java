package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ai;
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
        zVar.uW().vR().mIsUseCurrentBDUSS = false;
        zVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        zVar.uW().vR().acY = false;
        String uy = zVar.uy();
        if (zVar.uW().vS().oH() && uy != null) {
            ai aiVar = new ai();
            aiVar.parserJson(uy);
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(aiVar.getUser().getBDUSS());
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.qs() != null) {
                accountData.setTbs(aiVar.qs().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Ow;
        private volatile z ajm = null;
        private final String edX;
        private final a.InterfaceC0033a edY;
        private final boolean edZ;
        private final String mName;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a, boolean z) {
            this.mName = str;
            this.edX = str2;
            this.Ow = str3;
            this.edZ = z;
            this.edY = interfaceC0033a == null ? new d(this) : interfaceC0033a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.edY.cg(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.ajm = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.ajm.uW().vR().mIsUseCurrentBDUSS = false;
            this.ajm.n("bdusstoken", String.valueOf(this.edX) + "|" + this.Ow);
            if (!StringUtils.isNull(this.mStoken)) {
                this.ajm.n("stoken", this.mStoken);
            }
            this.ajm.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.ajm.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.ajm.uW().vR().acY = false;
            String uy = this.ajm.uy();
            if (this.ajm.uW().vS().oH() && uy != null) {
                ai aiVar = new ai();
                aiVar.parserJson(uy);
                AccountData accountData = new AccountData();
                accountData.setAccount(aiVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aiVar.getUser().getUserId());
                String bduss = aiVar.getUser().getBDUSS();
                if (this.edZ && (a = h.a(com.baidu.tbadk.core.a.a.oR().cf(bduss))) != null) {
                    bduss = String.valueOf(a.pY) + "|" + a.Ow;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(aiVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aiVar.qs() != null) {
                    accountData.setTbs(aiVar.qs().getTbs());
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
            ReloginManager.ug().aB(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.ajm.va(), this.ajm.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.edY.a(accountData);
                return;
            }
            String str = null;
            if (this.ajm != null) {
                str = this.ajm.getErrorString();
                i = this.ajm.va();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.data_load_error);
            }
            this.edY.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.ajm != null) {
                this.ajm.eg();
            }
        }
    }
}
