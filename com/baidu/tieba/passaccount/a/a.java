package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a lyb = null;
    private final a.InterfaceC0558a lyc = new a.InterfaceC0558a() { // from class: com.baidu.tieba.passaccount.a.a.1
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
        public void onBeforeLogin(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
        public void a(AccountData accountData) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0558a
        public void onFailure(String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.brp().e(null);
            }
        }
    };

    private a() {
    }

    public static a dhR() {
        if (lyb == null) {
            lyb = new a();
        }
        return lyb;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b zq(String str) {
        a.b bVar;
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
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        return bVar;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bVar = null;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.a.a
    public void reLoginByCacheAccount() {
        if (j.isNetWorkAvailable()) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                a.b zq = zq(currentAccountObj.getBDUSS());
                if (zq != null) {
                    com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), zq.mBduss, zq.mPtoken, currentAccountObj.getStoken(), this.lyc);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "main_tab_has_no_cache_account", 0, "", new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0558a interfaceC0558a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0558a);
    }
}
