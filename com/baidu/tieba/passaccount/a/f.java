package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.y;
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
        private final a ecE;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.ecE = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public AccountData doInBackground(Object... objArr) {
            return f.bP(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.ecE != null) {
                if (accountData != null) {
                    this.ecE.a(accountData);
                } else {
                    this.ecE.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bP(String str, String str2) {
        y yVar;
        String ud;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            yVar = new y(sb.toString());
            yVar.n("un", str);
            yVar.n("passwd", str2);
            yVar.n("isphone", "0");
            yVar.n("channel_id", TbadkCoreApplication.m9getInst().getPushChannelId());
            yVar.n("channel_uid", TbadkCoreApplication.m9getInst().getPushChannelUserId());
            yVar.uC().vv().vy().ace = true;
            yVar.uC().vv().mIsNeedAddCommenParam = false;
            yVar.uC().vv().mIsUseCurrentBDUSS = false;
            ud = yVar.ud();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (yVar.uC().vw().isRequestSuccess() && ud != null) {
            ai aiVar = new ai();
            aiVar.parserJson(ud);
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
            if (aiVar.qm() != null) {
                accountData.setTbs(aiVar.qm().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (yVar.uF()) {
            switch (yVar.uG()) {
                case 1:
                case 2:
                case 5:
                    yVar.ee();
                    ReloginManager.tL().f(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
