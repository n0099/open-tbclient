package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
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
        private final a cGL;
        private final String mAccount;
        private final String mPassword;

        public b(String str, String str2, a aVar) {
            this.mAccount = str;
            this.mPassword = str2;
            this.cGL = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public AccountData doInBackground(Object... objArr) {
            return f.aY(this.mAccount, this.mPassword);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(AccountData accountData) {
            super.onPostExecute(accountData);
            if (this.cGL != null) {
                if (accountData != null) {
                    this.cGL.a(accountData);
                } else {
                    this.cGL.onFailure(this.mAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData aY(String str, String str2) {
        aa aaVar;
        String uZ;
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            aaVar = new aa(sb.toString());
            aaVar.p("un", str);
            aaVar.p("passwd", str2);
            aaVar.p("isphone", "0");
            aaVar.p("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            aaVar.p("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            aaVar.vB().wv().wy().aen = true;
            aaVar.vB().wv().mIsNeedAddCommenParam = false;
            aaVar.vB().wv().mIsUseCurrentBDUSS = false;
            uZ = aaVar.uZ();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (aaVar.vB().ww().rl() && uZ != null) {
            r rVar = new r();
            rVar.parserJson(uZ);
            String userId = rVar.getUser().getUserId();
            if (userId == null || userId.length() <= 0) {
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(rVar.getUser().getUserName());
            if (rVar.getUser().getPassword() != null) {
                accountData.setPassword(rVar.getUser().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(rVar.getUser().getUserId());
            accountData.setBDUSS(rVar.getUser().getBDUSS());
            accountData.setPortrait(rVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (rVar.so() != null) {
                accountData.setTbs(rVar.so().getTbs());
                return accountData;
            }
            return accountData;
        }
        if (aaVar.vE()) {
            switch (aaVar.vF()) {
                case 1:
                case 2:
                case 5:
                    aaVar.gT();
                    ReloginManager.uJ().e(null);
                    break;
            }
            return null;
        }
        return null;
    }
}
