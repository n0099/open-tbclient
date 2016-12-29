package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ah;
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
        private final a dTL;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.dTL = aVar;
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
            if (this.dTL != null) {
                if (accountData != null) {
                    this.dTL.a(accountData);
                } else {
                    this.dTL.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bH(String str, String str2) {
        z zVar;
        String uk;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            zVar = new z(sb.toString());
            zVar.n("un", str);
            zVar.n("passwd", str2);
            zVar.n("isphone", "0");
            zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            zVar.uI().vB().vE().acS = true;
            zVar.uI().vB().mIsNeedAddCommenParam = false;
            zVar.uI().vB().mIsUseCurrentBDUSS = false;
            uk = zVar.uk();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (zVar.uI().vC().oH() && uk != null) {
            ah ahVar = new ah();
            ahVar.parserJson(uk);
            String userId = ahVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(ahVar.getUser().getUserName());
            if (ahVar.getUser().getPassword() != null) {
                accountData.setPassword(ahVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(ahVar.getUser().getUserId());
            accountData.setBDUSS(ahVar.getUser().getBDUSS());
            accountData.setPortrait(ahVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (ahVar.qt() != null) {
                accountData.setTbs(ahVar.qt().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (zVar.uL()) {
            switch (zVar.uM()) {
                case 1:
                case 2:
                case 5:
                    zVar.eg();
                    ReloginManager.tR().f(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
