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
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0030a interfaceC0030a) {
        h hVar = new h();
        a aVar = new a(str, str2, str3, interfaceC0030a, false);
        if (h.pD() && StringUtils.isNull(str4)) {
            hVar.a(str2, new c(aVar, interfaceC0030a, str));
        } else {
            if (h.pD()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0030a interfaceC0030a) {
        a aVar = new a(str, str2, str3, interfaceC0030a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData A(String str, String str2, String str3) {
        z zVar = new z(TbConfig.LOGIN_FULL_ADDRESS);
        zVar.vw().wp().mIsUseCurrentBDUSS = false;
        zVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        zVar.vw().wp().ahi = false;
        String uY = zVar.uY();
        if (zVar.vw().wq().isRequestSuccess() && uY != null) {
            ai aiVar = new ai();
            aiVar.parserJson(uY);
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.rb() != null) {
                accountData.setTbs(aiVar.rb().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Tb;
        private final String dUj;
        private final a.InterfaceC0030a dUk;
        private final boolean dUl;
        private final String mName;
        private volatile z mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0030a interfaceC0030a, boolean z) {
            this.mName = str;
            this.dUj = str2;
            this.Tb = str3;
            this.dUl = z;
            this.dUk = interfaceC0030a == null ? new d(this) : interfaceC0030a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dUk.cf(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new z(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.vw().wp().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", String.valueOf(this.dUj) + "|" + this.Tb);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.mNetwork.vw().wp().ahi = false;
            String uY = this.mNetwork.uY();
            if (this.mNetwork.vw().wq().isRequestSuccess() && uY != null) {
                ai aiVar = new ai();
                aiVar.parserJson(uY);
                AccountData accountData = new AccountData();
                accountData.setAccount(aiVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(aiVar.getUser().getUserId());
                String str = this.dUj;
                if (this.dUl && (a = g.a(com.baidu.tbadk.core.a.a.pw().ce(str))) != null) {
                    str = String.valueOf(a.mBduss) + "|" + a.Tb;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(aiVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (aiVar.rb() != null) {
                    accountData.setTbs(aiVar.rb().getTbs());
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
            ReloginManager.uG().aD(false);
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.vA(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.dUk.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.vA();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.data_load_error);
            }
            this.dUk.b(this.mName, i, str);
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
