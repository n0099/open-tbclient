package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, a.InterfaceC0042a interfaceC0042a) {
        C0072a c0072a = new C0072a(str, str2, str3, interfaceC0042a, false);
        c0072a.execute(new String[0]);
        return c0072a;
    }

    public static AccountData k(String str, String str2, String str3) {
        ab abVar = new ab(TbConfig.LOGIN_FULL_ADDRESS);
        abVar.vU().wO().mIsUseCurrentBDUSS = false;
        abVar.p("bdusstoken", String.valueOf(str2) + "|" + str3);
        abVar.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        abVar.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        abVar.vU().wO().adb = false;
        String vw = abVar.vw();
        if (abVar.vU().wP().qC() && vw != null) {
            x xVar = new x();
            xVar.parserJson(vw);
            AccountData accountData = new AccountData();
            accountData.setAccount(xVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(xVar.getUser().getUserId());
            accountData.setBDUSS(xVar.getUser().getBDUSS());
            accountData.setPortrait(xVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (xVar.sf() != null) {
                accountData.setTbs(xVar.sf().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072a extends BdAsyncTask<String, Integer, AccountData> {
        private final String Rq;
        private volatile ab aiW = null;
        private final String cXE;
        private final a.InterfaceC0042a cXF;
        private final boolean cXG;
        private final String mName;

        public C0072a(String str, String str2, String str3, a.InterfaceC0042a interfaceC0042a, boolean z) {
            this.mName = str;
            this.cXE = str2;
            this.Rq = str3;
            this.cXG = z;
            this.cXF = interfaceC0042a == null ? new b(this) : interfaceC0042a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cXF.cg(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.aiW = new ab(TbConfig.LOGIN_FULL_ADDRESS);
            this.aiW.vU().wO().mIsUseCurrentBDUSS = false;
            this.aiW.p("bdusstoken", String.valueOf(this.cXE) + "|" + this.Rq);
            this.aiW.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.aiW.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.aiW.vU().wO().adb = false;
            String vw = this.aiW.vw();
            if (this.aiW.vU().wP().qC() && vw != null) {
                x xVar = new x();
                xVar.parserJson(vw);
                AccountData accountData = new AccountData();
                accountData.setAccount(xVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(xVar.getUser().getUserId());
                String bduss = xVar.getUser().getBDUSS();
                if (this.cXG && (a = f.a(com.baidu.tbadk.core.a.a.qM().cf(bduss))) != null) {
                    bduss = String.valueOf(a.xa) + "|" + a.Rq;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(xVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (xVar.sf() != null) {
                    accountData.setTbs(xVar.sf().getTbs());
                    return accountData;
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.vf().at(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.aiW.vY(), this.aiW.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.cXF.a(accountData);
                return;
            }
            String str = null;
            if (this.aiW != null) {
                str = this.aiW.getErrorString();
                i = this.aiW.vY();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.data_load_error);
            }
            this.cXF.b(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.aiW != null) {
                this.aiW.gX();
            }
        }
    }
}
