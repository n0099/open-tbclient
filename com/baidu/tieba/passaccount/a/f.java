package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public interface a {
        void a(AccountData accountData);

        void onFailure(String str);
    }

    public static void a(String str, String str2, a aVar) {
        b bVar = new b(str, str2, aVar);
        bVar.setPriority(3);
        bVar.execute(new Object[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Object, Object, AccountData> {
        private final a dIU;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.dIU = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public AccountData doInBackground(Object... objArr) {
            return f.bu(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.dIU != null) {
                if (accountData != null) {
                    this.dIU.a(accountData);
                } else {
                    this.dIU.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bu(String str, String str2) {
        ab abVar;
        String ta;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.n("un", str);
            abVar.n("passwd", str2);
            abVar.n("isphone", "0");
            abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            abVar.ty().uu().ux().Zs = true;
            abVar.ty().uu().mIsNeedAddCommenParam = false;
            abVar.ty().uu().mIsUseCurrentBDUSS = false;
            ta = abVar.ta();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.ty().uv().nU() && ta != null) {
            aa aaVar = new aa();
            aaVar.parserJson(ta);
            String userId = aaVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aaVar.getUser().getUserName());
            if (aaVar.getUser().getPassword() != null) {
                accountData.setPassword(aaVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aaVar.getUser().getUserId());
            accountData.setBDUSS(aaVar.getUser().getBDUSS());
            accountData.setPortrait(aaVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aaVar.pt() != null) {
                accountData.setTbs(aaVar.pt().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (abVar.tB()) {
            switch (abVar.tC()) {
                case 1:
                case 2:
                case 5:
                    abVar.dm();
                    ReloginManager.sJ().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
