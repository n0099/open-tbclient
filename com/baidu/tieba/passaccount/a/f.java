package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public interface a {
        void a(AccountData accountData);

        void jx(String str);
    }

    public static void a(String str, String str2, a aVar) {
        b bVar = new b(str, str2, aVar);
        bVar.setPriority(3);
        bVar.execute(new Object[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Object, Object, AccountData> {
        private final a cdr;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.cdr = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public AccountData doInBackground(Object... objArr) {
            return f.aS(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.cdr != null) {
                if (accountData != null) {
                    this.cdr.a(accountData);
                } else {
                    this.cdr.jx(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aS(String str, String str2) {
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
            wVar.uh().uX().va().ack = true;
            wVar.uh().uX().mIsNeedAddCommenParam = false;
            wVar.uh().uX().mIsUseCurrentBDUSS = false;
            tG = wVar.tG();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (wVar.uh().uY().qV() && tG != null) {
            k kVar = new k();
            kVar.parserJson(tG);
            String userId = kVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(kVar.getUser().getUserName());
            if (kVar.getUser().getPassword() != null) {
                accountData.setPassword(kVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(kVar.getUser().getUserId());
            accountData.setBDUSS(kVar.getUser().getBDUSS());
            accountData.setPortrait(kVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (kVar.rF() != null) {
                accountData.setTbs(kVar.rF().getTbs());
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
