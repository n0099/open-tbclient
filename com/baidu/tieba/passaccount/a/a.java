package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes8.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a jkn = null;
    private final a.InterfaceC0426a jko = new a.InterfaceC0426a() { // from class: com.baidu.tieba.passaccount.a.a.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0426a
        public void onBeforeLogin(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0426a
        public void a(AccountData accountData) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0426a
        public void onFailure(final String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.aNM().e(null);
            }
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tieba.passaccount.a.a.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: i */
                public AccountData doInBackground(Void... voidArr) {
                    return com.baidu.tbadk.core.a.b.tJ(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: m */
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute(accountData);
                    if (accountData != null && !TextUtils.isEmpty(accountData.getID())) {
                        com.baidu.tbadk.core.a.b.tI(accountData.getID());
                    }
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };

    private a() {
    }

    public static a cut() {
        if (jkn == null) {
            jkn = new a();
        }
        return jkn;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b tH(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.mBduss = split[0];
                        if (split.length >= 2) {
                            bVar.mPtoken = split[1];
                            return bVar;
                        }
                        return bVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return bVar;
                    }
                }
            } catch (Exception e3) {
                bVar = null;
                e = e3;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.a.a
    public void reLoginByCacheAccount() {
        AccountData currentAccountObj;
        a.b tH;
        if (j.isNetWorkAvailable() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (tH = tH(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), tH.mBduss, tH.mPtoken, currentAccountObj.getStoken(), this.jko);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0426a interfaceC0426a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0426a);
    }
}
