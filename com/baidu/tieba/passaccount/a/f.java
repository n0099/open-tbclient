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

        void kk(String str);
    }

    public static void a(String str, String str2, a aVar) {
        b bVar = new b(str, str2, aVar);
        bVar.setPriority(3);
        bVar.execute(new Object[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Object, Object, AccountData> {
        private final a cAf;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.cAf = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            return f.aR(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.cAf != null) {
                if (accountData != null) {
                    this.cAf.a(accountData);
                } else {
                    this.cAf.kk(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aR(String str, String str2) {
        ab abVar;
        String tV;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.o("un", str);
            abVar.o("passwd", str2);
            abVar.o("isphone", "0");
            abVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            abVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            abVar.uw().vp().vs().adN = true;
            abVar.uw().vp().mIsNeedAddCommenParam = false;
            abVar.uw().vp().mIsUseCurrentBDUSS = false;
            tV = abVar.tV();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.uw().vq().qO() && tV != null) {
            n nVar = new n();
            nVar.parserJson(tV);
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
            if (nVar.rI() != null) {
                accountData.setTbs(nVar.rI().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (abVar.uz()) {
            switch (abVar.uA()) {
                case 1:
                case 2:
                case 5:
                    abVar.gL();
                    ReloginManager.tE().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
