package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a eCL = null;
    private final a.InterfaceC0040a eCM = new a.InterfaceC0040a() { // from class: com.baidu.tieba.passaccount.a.a.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void cz(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void a(AccountData accountData) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void c(final String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.uz().f(null);
            }
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tieba.passaccount.a.a.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: f */
                public AccountData doInBackground(Void... voidArr) {
                    return com.baidu.tbadk.core.a.b.cB(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: o */
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute(accountData);
                    if (accountData != null && !TextUtils.isEmpty(accountData.getAccount())) {
                        com.baidu.tbadk.core.a.b.cA(accountData.getAccount());
                    }
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };

    private a() {
    }

    public static a aOQ() {
        if (eCL == null) {
            eCL = new a();
        }
        return eCL;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cy(String str) {
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
                            bVar.TQ = split[1];
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
    public void ph() {
        AccountData currentAccountObj;
        a.b cy;
        if (i.hr() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cy = cy(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), cy.mBduss, cy.TQ, currentAccountObj.getStoken(), this.eCM);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0040a interfaceC0040a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0040a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData f(String str, String str2, String str3, String str4) {
        return com.baidu.tieba.model.b.G(str, str2, str3);
    }
}
