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
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0035a interfaceC0035a) {
        h hVar = new h();
        a aVar = new a(str, str2, str3, interfaceC0035a, false);
        if (h.pk() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0035a, str));
        } else {
            if (h.pk()) {
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

    public static AccountData A(String str, String str2, String str3) {
        z zVar = new z(TbConfig.LOGIN_FULL_ADDRESS);
        zVar.uJ().vD().mIsUseCurrentBDUSS = false;
        zVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        zVar.uJ().vD().agA = false;
        String ul = zVar.ul();
        if (zVar.uJ().vE().isRequestSuccess() && ul != null) {
            aj ajVar = new aj();
            ajVar.parserJson(ul);
            AccountData accountData = new AccountData();
            accountData.setAccount(ajVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(ajVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(ajVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ajVar.ql() != null) {
                accountData.setTbs(ajVar.ql().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Su;
        private final String dOH;
        private final a.InterfaceC0035a dOI;
        private final boolean dOJ;
        private final String mName;
        private volatile z mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0035a interfaceC0035a, boolean z) {
            this.mName = str;
            this.dOH = str2;
            this.Su = str3;
            this.dOJ = z;
            this.dOI = interfaceC0035a == null ? new d(this) : interfaceC0035a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dOI.cf(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.uJ().vD().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", String.valueOf(this.dOH) + "|" + this.Su);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.mNetwork.uJ().vD().agA = false;
            String ul = this.mNetwork.ul();
            if (this.mNetwork.uJ().vE().isRequestSuccess() && ul != null) {
                aj ajVar = new aj();
                ajVar.parserJson(ul);
                AccountData accountData = new AccountData();
                accountData.setAccount(ajVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(ajVar.getUser().getUserId());
                String str = this.dOH;
                if (this.dOJ && (a = g.a(com.baidu.tbadk.core.a.a.pd().ce(str))) != null) {
                    str = String.valueOf(a.mBduss) + "|" + a.Su;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(ajVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (ajVar.ql() != null) {
                    accountData.setTbs(ajVar.ql().getTbs());
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
            ReloginManager.tS().aA(false);
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.uN(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dOI.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.uN();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.data_load_error);
            }
            this.dOI.b(this.mName, i, str);
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
