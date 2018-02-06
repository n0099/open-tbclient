package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a fEk = null;
    private final a.InterfaceC0093a fEl = new a.InterfaceC0093a() { // from class: com.baidu.tieba.passaccount.a.a.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0093a
        public void cM(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0093a
        public void a(AccountData accountData) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0093a
        public void c(final String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.BJ().e(null);
            }
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tieba.passaccount.a.a.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: g */
                public AccountData doInBackground(Void... voidArr) {
                    return com.baidu.tbadk.core.a.b.cO(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: n */
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute(accountData);
                    if (accountData != null && !TextUtils.isEmpty(accountData.getAccount())) {
                        com.baidu.tbadk.core.a.b.cN(accountData.getAccount());
                    }
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };

    private a() {
    }

    public static a aZD() {
        if (fEk == null) {
            fEk = new a();
        }
        return fEk;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cL(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.akE = split[0];
                        if (split.length >= 2) {
                            bVar.aJN = split[1];
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
    public void xw() {
        AccountData currentAccountObj;
        a.b cL;
        if (j.oJ() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cL = cL(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), cL.akE, cL.aJN, currentAccountObj.getStoken(), this.fEl);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0093a interfaceC0093a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0093a);
    }
}
