package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.a.c;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements c {
    private static b flA;

    private b() {
    }

    public static synchronized b aZz() {
        b bVar;
        synchronized (b.class) {
            if (flA == null) {
                flA = new b();
            }
            bVar = flA;
        }
        return bVar;
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void g(AccountData accountData) {
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (!TextUtils.isEmpty(accountData.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
            for (SapiAccount sapiAccount : loginAccounts) {
                if (accountData.getID().equals(sapiAccount.uid)) {
                    SapiAccountManager.getInstance().validate(sapiAccount);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void Bp() {
        try {
            SapiAccountManager.getInstance().logout();
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void h(AccountData accountData) {
        if (accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
            SapiAccountManager.getInstance().logout();
            return;
        }
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts != null && loginAccounts.size() > 0) {
            for (SapiAccount sapiAccount : loginAccounts) {
                if (accountData.getID().equals(sapiAccount.uid)) {
                    SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                    return;
                }
            }
        }
    }
}
