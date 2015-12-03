package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public interface a {
        void a(AccountData accountData);

        void ko(String str);
    }

    public static void a(String str, String str2, a aVar) {
        b bVar = new b(str, str2, aVar);
        bVar.setPriority(3);
        bVar.execute(new Object[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Object, Object, AccountData> {
        private final a cwB;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.cwB = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            return f.aW(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.cwB != null) {
                if (accountData != null) {
                    this.cwB.a(accountData);
                } else {
                    this.cwB.ko(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aW(String str, String str2) {
        ab abVar;
        String ul;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.o("un", str);
            abVar.o("passwd", str2);
            abVar.o("isphone", "0");
            abVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            abVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            abVar.uM().vF().vI().adj = true;
            abVar.uM().vF().mIsNeedAddCommenParam = false;
            abVar.uM().vF().mIsUseCurrentBDUSS = false;
            ul = abVar.ul();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.uM().vG().rf() && ul != null) {
            n nVar = new n();
            nVar.parserJson(ul);
            String userId = nVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            if (nVar.getUser().getPassword() != null) {
                accountData.setPassword(nVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(nVar.getUser().getUserId());
            accountData.setBDUSS(nVar.getUser().getBDUSS());
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.rZ() != null) {
                accountData.setTbs(nVar.rZ().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (abVar.uP()) {
            switch (abVar.uQ()) {
                case 1:
                case 2:
                case 5:
                    abVar.gL();
                    ReloginManager.tU().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
