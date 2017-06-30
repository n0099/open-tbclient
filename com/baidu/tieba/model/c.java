package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0037a interfaceC0037a) {
        com.baidu.tbadk.core.a.h hVar = new com.baidu.tbadk.core.a.h();
        a aVar = new a(str, str2, str3, interfaceC0037a, false);
        if (com.baidu.tbadk.core.a.h.oZ() && StringUtils.isNull(str4)) {
            hVar.a(str2, new d(aVar, interfaceC0037a, str));
        } else {
            if (com.baidu.tbadk.core.a.h.oZ()) {
                aVar.setStoken(str4);
            }
            aVar.execute(new String[0]);
        }
        return aVar;
    }

    public static BdAsyncTask<?, ?, ?> b(String str, String str2, String str3, String str4, a.InterfaceC0037a interfaceC0037a) {
        a aVar = new a(str, str2, str3, interfaceC0037a, false);
        aVar.execute(new String[0]);
        return aVar;
    }

    public static AccountData F(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.uV().vR().mIsUseCurrentBDUSS = false;
        abVar.n("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
        abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
        abVar.uV().vR().agZ = false;
        String uy = abVar.uy();
        if (abVar.uV().vS().isRequestSuccess() && uy != null) {
            al alVar = new al();
            alVar.parserJson(uy);
            AccountData accountData = new AccountData();
            accountData.setAccount(alVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(alVar.getUser().getUserId());
            accountData.setBDUSS(str2);
            accountData.setPortrait(alVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (alVar.qe() != null) {
                accountData.setTbs(alVar.qe().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Sc;
        private final String ecB;
        private final a.InterfaceC0037a ecC;
        private final boolean ecD;
        private final String mName;
        private volatile ab mNetwork = null;
        private String mStoken;

        public a(String str, String str2, String str3, a.InterfaceC0037a interfaceC0037a, boolean z) {
            this.mName = str;
            this.ecB = str2;
            this.Sc = str3;
            this.ecD = z;
            this.ecC = interfaceC0037a == null ? new e(this) : interfaceC0037a;
            setPriority(3);
        }

        public void setStoken(String str) {
            this.mStoken = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ecC.cl(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.mNetwork = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.mNetwork.uV().vR().mIsUseCurrentBDUSS = false;
            this.mNetwork.n("bdusstoken", String.valueOf(this.ecB) + "|" + this.Sc);
            if (!StringUtils.isNull(this.mStoken)) {
                this.mNetwork.n("stoken", this.mStoken);
            }
            this.mNetwork.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            this.mNetwork.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            this.mNetwork.uV().vR().agZ = false;
            String uy = this.mNetwork.uy();
            if (this.mNetwork.uV().vS().isRequestSuccess() && uy != null) {
                al alVar = new al();
                alVar.parserJson(uy);
                AccountData accountData = new AccountData();
                accountData.setAccount(alVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(alVar.getUser().getUserId());
                String str = this.ecB;
                if (this.ecD && (a = h.a(com.baidu.tbadk.core.a.a.oS().ck(str))) != null) {
                    str = String.valueOf(a.mBduss) + "|" + a.Sc;
                }
                accountData.setBDUSS(str);
                accountData.setPortrait(alVar.getUser().getPortrait());
                accountData.setStoken(this.mStoken);
                accountData.setIsActive(1);
                if (alVar.qe() != null) {
                    accountData.setTbs(alVar.qe().getTbs());
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
            ReloginManager.uh().aA(false);
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.mNetwork.uZ(), this.mNetwork.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.ecC.a(accountData);
                return;
            }
            String str = null;
            if (this.mNetwork != null) {
                str = this.mNetwork.getErrorString();
                i = this.mNetwork.uZ();
            }
            if (str == null) {
                str = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.data_load_error);
            }
            this.ecC.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.fr();
            }
        }
    }
}
