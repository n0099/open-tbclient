package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public interface a {
        void a(AccountData accountData);

        void jz(String str);
    }

    public static void a(String str, String str2, a aVar) {
        b bVar = new b(str, str2, aVar);
        bVar.setPriority(3);
        bVar.execute(new Object[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Object, Object, AccountData> {
        private final a ced;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.ced = aVar;
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
            if (this.ced != null) {
                if (accountData != null) {
                    this.ced.a(accountData);
                } else {
                    this.ced.jz(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aR(String str, String str2) {
        w wVar;
        String tG;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            wVar = new w(sb.toString());
            wVar.o("un", str);
            wVar.o("passwd", str2);
            wVar.o("isphone", "0");
            wVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            wVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            wVar.uh().uZ().vc().acq = true;
            wVar.uh().uZ().mIsNeedAddCommenParam = false;
            wVar.uh().uZ().mIsUseCurrentBDUSS = false;
            tG = wVar.tG();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (wVar.uh().va().qT() && tG != null) {
            l lVar = new l();
            lVar.parserJson(tG);
            String userId = lVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            if (lVar.getUser().getPassword() != null) {
                accountData.setPassword(lVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rE() != null) {
                accountData.setTbs(lVar.rE().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (wVar.uk()) {
            switch (wVar.ul()) {
                case 1:
                case 2:
                case 5:
                    wVar.gJ();
                    ReloginManager.tp().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
