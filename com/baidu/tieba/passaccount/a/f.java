package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.y;
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
        private final a dco;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.dco = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public AccountData doInBackground(Object... objArr) {
            return f.bt(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.dco != null) {
                if (accountData != null) {
                    this.dco.a(accountData);
                } else {
                    this.dco.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData bt(String str, String str2) {
        ab abVar;
        String tc;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            abVar = new ab(sb.toString());
            abVar.n("un", str);
            abVar.n("passwd", str2);
            abVar.n("isphone", "0");
            abVar.n("channel_id", TbadkCoreApplication.m11getInst().getPushChannelId());
            abVar.n("channel_uid", TbadkCoreApplication.m11getInst().getPushChannelUserId());
            abVar.tA().uu().ux().Zb = true;
            abVar.tA().uu().mIsNeedAddCommenParam = false;
            abVar.tA().uu().mIsUseCurrentBDUSS = false;
            tc = abVar.tc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (abVar.tA().uv().nZ() && tc != null) {
            y yVar = new y();
            yVar.parserJson(tc);
            String userId = yVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(yVar.getUser().getUserName());
            if (yVar.getUser().getPassword() != null) {
                accountData.setPassword(yVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(yVar.getUser().getUserId());
            accountData.setBDUSS(yVar.getUser().getBDUSS());
            accountData.setPortrait(yVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (yVar.pz() != null) {
                accountData.setTbs(yVar.pz().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (abVar.tD()) {
            switch (abVar.tE()) {
                case 1:
                case 2:
                case 5:
                    abVar.dl();
                    ReloginManager.sL().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
