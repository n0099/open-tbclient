package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ae;
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
        private final a ehi;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.ehi = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            return f.bA(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.ehi != null) {
                if (accountData != null) {
                    this.ehi.a(accountData);
                } else {
                    this.ehi.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bA(String str, String str2) {
        ab abVar;
        String ue;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.n("un", str);
            abVar.n("passwd", str2);
            abVar.n("isphone", "0");
            abVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            abVar.uD().vz().vC().acQ = true;
            abVar.uD().vz().mIsNeedAddCommenParam = false;
            abVar.uD().vz().mIsUseCurrentBDUSS = false;
            ue = abVar.ue();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.uD().vA().oE() && ue != null) {
            ae aeVar = new ae();
            aeVar.parserJson(ue);
            String userId = aeVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aeVar.getUser().getUserName());
            if (aeVar.getUser().getPassword() != null) {
                accountData.setPassword(aeVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (abVar.uG()) {
            switch (abVar.uH()) {
                case 1:
                case 2:
                case 5:
                    abVar.eg();
                    ReloginManager.tN().f(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
