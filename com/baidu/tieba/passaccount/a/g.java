package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.coreExtra.a.c {
    private static g cAg;

    private g() {
    }

    public static synchronized g ajU() {
        g gVar;
        synchronized (g.class) {
            if (cAg == null) {
                cAg = new g();
            }
            gVar = cAg;
        }
        return gVar;
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void f(AccountData accountData) {
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
    public void wA() {
        SapiAccountManager.getInstance().logout();
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void g(AccountData accountData) {
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

    @Override // com.baidu.tbadk.coreExtra.a.c
    public AccountData tH() {
        SapiAccount session;
        AccountData k;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || com.baidu.tbadk.core.a.a.qY() == null || (k = com.baidu.tbadk.core.a.a.qY().k(session.username, session.bduss, session.ptoken)) == null) {
            return null;
        }
        com.baidu.tbadk.core.a.b.b(k);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(k, k.getBDUSS(), k.getTbs());
        TbadkCoreApplication.setCurrentAccount(k, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
        return k;
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void a(a.InterfaceC0041a interfaceC0041a) {
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public List<AccountData> wB() {
        ArrayList arrayList = new ArrayList();
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts != null) {
            for (SapiAccount sapiAccount : loginAccounts) {
                AccountData accountData = new AccountData();
                accountData.setID(sapiAccount.uid);
                if (TextUtils.isEmpty(sapiAccount.username)) {
                    accountData.setAccount(sapiAccount.displayname);
                } else {
                    accountData.setAccount(sapiAccount.username);
                }
                accountData.setBDUSS(sapiAccount.bduss);
                if (session != null && !TextUtils.isEmpty(session.uid) && session.uid.equals(sapiAccount.uid)) {
                    accountData.setIsActive(1);
                }
                arrayList.add(accountData);
            }
        }
        return arrayList;
    }
}
