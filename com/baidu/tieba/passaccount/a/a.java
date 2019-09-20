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
    private static a hGV = null;
    private final a.InterfaceC0248a hGW = new a.InterfaceC0248a() { // from class: com.baidu.tieba.passaccount.a.a.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0248a
        public void mm(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0248a
        public void a(AccountData accountData) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0248a
        public void h(final String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.ahN().e(null);
            }
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tieba.passaccount.a.a.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: h */
                public AccountData doInBackground(Void... voidArr) {
                    return com.baidu.tbadk.core.a.b.mo(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: m */
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute(accountData);
                    if (accountData != null && !TextUtils.isEmpty(accountData.getID())) {
                        com.baidu.tbadk.core.a.b.mn(accountData.getID());
                    }
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };

    private a() {
    }

    public static a bSz() {
        if (hGV == null) {
            hGV = new a();
        }
        return hGV;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b ml(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.BY = split[0];
                        if (split.length >= 2) {
                            bVar.bEg = split[1];
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
    public void ack() {
        AccountData currentAccountObj;
        a.b ml;
        if (j.kc() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (ml = ml(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), ml.BY, ml.bEg, currentAccountObj.getStoken(), this.hGW);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0248a interfaceC0248a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0248a);
    }
}
