package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0032a interfaceC0032a) {
        h hVar = new h();
        a aVar = new a(str, str2, str3, interfaceC0032a, false);
        if (h.oR() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0032a, str));
        } else {
            if (h.oR()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0032a interfaceC0032a) {
        a aVar = new a(str, str2, str3, interfaceC0032a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData H(String str, String str2, String str3) {
        y yVar = new y(TbConfig.LOGIN_FULL_ADDRESS);
        yVar.uC().vv().mIsUseCurrentBDUSS = false;
        yVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        yVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        yVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        yVar.uC().vv().abD = false;
        String ud = yVar.ud();
        if (yVar.uC().vw().isRequestSuccess() && ud != null) {
            ai aiVar = new ai();
            aiVar.parserJson(ud);
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(aiVar.getUser().getBDUSS());
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.qm() != null) {
                accountData.setTbs(aiVar.qm().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String ND;
        private final String dRI;
        private final a.InterfaceC0032a dRJ;
        private final boolean dRK;
        private final String mName;
        private volatile y mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0032a interfaceC0032a, boolean z) {
            this.mName = str;
            this.dRI = str2;
            this.ND = str3;
            this.dRK = z;
            this.dRJ = interfaceC0032a == null ? new d(this) : interfaceC0032a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dRJ.cf(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new y(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.uC().vv().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", String.valueOf(this.dRI) + "|" + this.ND);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.mNetwork.uC().vv().abD = false;
            String ud = this.mNetwork.ud();
            if (this.mNetwork.uC().vw().isRequestSuccess() && ud != null) {
                ai aiVar = new ai();
                aiVar.parserJson(ud);
                AccountData accountData = new AccountData();
                accountData.setAccount(aiVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aiVar.getUser().getUserId());
                String bduss = aiVar.getUser().getBDUSS();
                if (this.dRK && (a = g.a(com.baidu.tbadk.core.a.a.oK().ce(bduss))) != null) {
                    bduss = String.valueOf(a.pS) + "|" + a.ND;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(aiVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aiVar.qm() != null) {
                    accountData.setTbs(aiVar.qm().getTbs());
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
            ReloginManager.tL().aC(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.uG(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dRJ.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.uG();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.data_load_error);
            }
            this.dRJ.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ee();
            }
        }
    }
}
