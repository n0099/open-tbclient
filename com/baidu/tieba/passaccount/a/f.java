package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.x;
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
        private final a cZT;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.cZT = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public AccountData doInBackground(Object... objArr) {
            return f.bo(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.cZT != null) {
                if (accountData != null) {
                    this.cZT.a(accountData);
                } else {
                    this.cZT.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bo(String str, String str2) {
        ab abVar;
        String vw;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.p("un", str);
            abVar.p("passwd", str2);
            abVar.p("isphone", "0");
            abVar.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            abVar.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            abVar.vU().wO().wR().adD = true;
            abVar.vU().wO().mIsNeedAddCommenParam = false;
            abVar.vU().wO().mIsUseCurrentBDUSS = false;
            vw = abVar.vw();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.vU().wP().qC() && vw != null) {
            x xVar = new x();
            xVar.parserJson(vw);
            String userId = xVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(xVar.getUser().getUserName());
            if (xVar.getUser().getPassword() != null) {
                accountData.setPassword(xVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
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
        if (abVar.vX()) {
            switch (abVar.vY()) {
                case 1:
                case 2:
                case 5:
                    abVar.gX();
                    ReloginManager.vf().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
