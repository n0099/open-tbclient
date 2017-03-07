package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0031a interfaceC0031a) {
        h hVar = new h();
        a aVar = new a(str, str2, str3, interfaceC0031a, false);
        if (h.pf() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0031a, str));
        } else {
            if (h.pf()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0031a interfaceC0031a) {
        a aVar = new a(str, str2, str3, interfaceC0031a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData E(String str, String str2, String str3) {
        z zVar = new z(TbConfig.LOGIN_FULL_ADDRESS);
        zVar.uZ().vS().mIsUseCurrentBDUSS = false;
        zVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        zVar.uZ().vS().agT = false;
        String uB = zVar.uB();
        if (zVar.uZ().vT().isRequestSuccess() && uB != null) {
            aj ajVar = new aj();
            ajVar.parserJson(uB);
            AccountData accountData = new AccountData();
            accountData.setAccount(ajVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(ajVar.getUser().getUserId());
            accountData.setBDUSS(ajVar.getUser().getBDUSS());
            accountData.setPortrait(ajVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ajVar.qE() != null) {
                accountData.setTbs(ajVar.qE().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String SH;
        private final String dUA;
        private final a.InterfaceC0031a dUB;
        private final boolean dUC;
        private final String mName;
        private volatile z mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0031a interfaceC0031a, boolean z) {
            this.mName = str;
            this.dUA = str2;
            this.SH = str3;
            this.dUC = z;
            this.dUB = interfaceC0031a == null ? new d(this) : interfaceC0031a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dUB.bY(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.uZ().vS().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", String.valueOf(this.dUA) + "|" + this.SH);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.mNetwork.uZ().vS().agT = false;
            String uB = this.mNetwork.uB();
            if (this.mNetwork.uZ().vT().isRequestSuccess() && uB != null) {
                aj ajVar = new aj();
                ajVar.parserJson(uB);
                AccountData accountData = new AccountData();
                accountData.setAccount(ajVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(ajVar.getUser().getUserId());
                String bduss = ajVar.getUser().getBDUSS();
                if (this.dUC && (a = g.a(com.baidu.tbadk.core.a.a.oY().bX(bduss))) != null) {
                    bduss = String.valueOf(a.xo) + "|" + a.SH;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(ajVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (ajVar.qE() != null) {
                    accountData.setTbs(ajVar.qE().getTbs());
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
            ReloginManager.uj().aB(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.vd(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dUB.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.vd();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.data_load_error);
            }
            this.dUB.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
        }
    }
}
