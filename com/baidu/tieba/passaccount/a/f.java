package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.z;
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
        private final a eeZ;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.eeZ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AccountData doInBackground(Object... objArr) {
            return f.bH(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.eeZ != null) {
                if (accountData != null) {
                    this.eeZ.a(accountData);
                } else {
                    this.eeZ.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bH(String str, String str2) {
        z zVar;
        String uB;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            zVar = new z(sb.toString());
            zVar.n("un", str);
            zVar.n("passwd", str2);
            zVar.n("isphone", "0");
            zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            zVar.uZ().vS().vV().ahu = true;
            zVar.uZ().vS().mIsNeedAddCommenParam = false;
            zVar.uZ().vS().mIsUseCurrentBDUSS = false;
            uB = zVar.uB();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (zVar.uZ().vT().isRequestSuccess() && uB != null) {
            aj ajVar = new aj();
            ajVar.parserJson(uB);
            String userId = ajVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(ajVar.getUser().getUserName());
            if (ajVar.getUser().getPassword() != null) {
                accountData.setPassword(ajVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (zVar.vc()) {
            switch (zVar.vd()) {
                case 1:
                case 2:
                case 5:
                    zVar.fm();
                    ReloginManager.uj().f(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
