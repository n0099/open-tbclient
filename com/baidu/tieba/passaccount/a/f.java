package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ai;
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
        private final a epe;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.epe = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AccountData doInBackground(Object... objArr) {
            return f.bE(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.epe != null) {
                if (accountData != null) {
                    this.epe.a(accountData);
                } else {
                    this.epe.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bE(String str, String str2) {
        z zVar;
        String uy;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            zVar = new z(sb.toString());
            zVar.n("un", str);
            zVar.n("passwd", str2);
            zVar.n("isphone", "0");
            zVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            zVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            zVar.uW().vR().vU().adA = true;
            zVar.uW().vR().mIsNeedAddCommenParam = false;
            zVar.uW().vR().mIsUseCurrentBDUSS = false;
            uy = zVar.uy();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (zVar.uW().vS().oH() && uy != null) {
            ai aiVar = new ai();
            aiVar.parserJson(uy);
            String userId = aiVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(aiVar.getUser().getUserName());
            if (aiVar.getUser().getPassword() != null) {
                accountData.setPassword(aiVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(aiVar.getUser().getUserId());
            accountData.setBDUSS(aiVar.getUser().getBDUSS());
            accountData.setPortrait(aiVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (aiVar.qs() != null) {
                accountData.setTbs(aiVar.qs().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (zVar.uZ()) {
            switch (zVar.va()) {
                case 1:
                case 2:
                case 5:
                    zVar.eg();
                    ReloginManager.ug().f(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
