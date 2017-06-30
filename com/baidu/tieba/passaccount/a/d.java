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
public class d implements com.baidu.tbadk.coreExtra.a.c {
    private static d eov;

    private d() {
    }

    public static synchronized d aLB() {
        d dVar;
        synchronized (d.class) {
            if (eov == null) {
                eov = new d();
            }
            dVar = eov;
        }
        return dVar;
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
    public void xv() {
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

    @Override // com.baidu.tbadk.coreExtra.a.c
    public AccountData ul() {
        SapiAccount session;
        AccountData h;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || com.baidu.tbadk.core.a.a.oS() == null || (h = com.baidu.tbadk.core.a.a.oS().h(session.username, session.bduss, "", null)) == null) {
            return null;
        }
        com.baidu.tbadk.core.a.b.b(h);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(h, h.getBDUSS(), h.getTbs());
        TbadkCoreApplication.setCurrentAccount(h, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
        return h;
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public void a(a.InterfaceC0037a interfaceC0037a) {
    }

    @Override // com.baidu.tbadk.coreExtra.a.c
    public List<AccountData> xw() {
        ArrayList arrayList = new ArrayList();
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts != null) {
            for (SapiAccount sapiAccount : loginAccounts) {
                AccountData accountData = new AccountData();
                accountData.setID(sapiAccount.uid);
                if (TextUtils.isEmpty(sapiAccount.username)) {
                    accountData.setDisplayName(sapiAccount.displayname);
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
