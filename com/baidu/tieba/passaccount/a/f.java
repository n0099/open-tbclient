package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ad;
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
        private final a dVd;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.dVd = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            return f.bz(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.dVd != null) {
                if (accountData != null) {
                    this.dVd.a(accountData);
                } else {
                    this.dVd.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bz(String str, String str2) {
        ab abVar;
        String sZ;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.n("un", str);
            abVar.n("passwd", str2);
            abVar.n("isphone", "0");
            abVar.n("channel_id", TbadkCoreApplication.m10getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m10getInst().getPushChannelUserId());
            abVar.tx().uu().ux().aab = true;
            abVar.tx().uu().mIsNeedAddCommenParam = false;
            abVar.tx().uu().mIsUseCurrentBDUSS = false;
            sZ = abVar.sZ();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.tx().uv().nJ() && sZ != null) {
            ad adVar = new ad();
            adVar.parserJson(sZ);
            String userId = adVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(adVar.getUser().getUserName());
            if (adVar.getUser().getPassword() != null) {
                accountData.setPassword(adVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(adVar.getUser().getUserId());
            accountData.setBDUSS(adVar.getUser().getBDUSS());
            accountData.setPortrait(adVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (adVar.pc() != null) {
                accountData.setTbs(adVar.pc().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (abVar.tA()) {
            switch (abVar.tB()) {
                case 1:
                case 2:
                case 5:
                    abVar.dl();
                    ReloginManager.sI().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
