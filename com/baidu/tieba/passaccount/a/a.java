package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a hgK = null;
    private final a.InterfaceC0222a hgL = new a.InterfaceC0222a() { // from class: com.baidu.tieba.passaccount.a.a.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0222a
        public void kV(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0222a
        public void a(AccountData accountData) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0222a
        public void e(final String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.abQ().e(null);
            }
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tieba.passaccount.a.a.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: h */
                public AccountData doInBackground(Void... voidArr) {
                    return com.baidu.tbadk.core.a.b.kX(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: m */
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute(accountData);
                    if (accountData != null && !TextUtils.isEmpty(accountData.getID())) {
                        com.baidu.tbadk.core.a.b.kW(accountData.getID());
                    }
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };

    private a() {
    }

    public static a bHd() {
        if (hgK == null) {
            hgK = new a();
        }
        return hgK;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b kU(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.Ek = split[0];
                        if (split.length >= 2) {
                            bVar.bvD = split[1];
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
    public void WE() {
        AccountData currentAccountObj;
        a.b kU;
        if (j.kY() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (kU = kU(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), kU.Ek, kU.bvD, currentAccountObj.getStoken(), this.hgL);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0222a interfaceC0222a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0222a);
    }
}
