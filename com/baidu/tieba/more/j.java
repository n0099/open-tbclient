package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;
    private int c = 0;
    private boolean d;

    public j(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.a = accountActivity;
        this.d = false;
        this.b = accountData;
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.showLoadingDialog(this.a.getString(R.string.deleting), new k(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public AccountData a(Object... objArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            Thread.sleep(1000L);
            if (this.d) {
                com.baidu.tieba.im.db.s.a(this.b.getID());
            }
            DatabaseService.q(this.b.getID());
            if (this.b.getID().equals(TiebaApplication.B())) {
                arrayList = this.a.a;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.a.a;
                    AccountData accountData = (AccountData) arrayList2.get(1);
                    accountData.setIsActive(1);
                    DatabaseService.a(accountData);
                    return accountData;
                }
                this.c = 2;
            } else {
                this.c = 0;
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        ArrayList arrayList;
        p pVar;
        if (this.b != null) {
            new l(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        if (this.c != 0) {
            TiebaApplication.a((AccountData) null, this.a);
            com.baidu.tieba.account.l.a().b(this.b.getAccount());
            com.baidu.tieba.account.l.a().a(this.b.getBDUSS());
        }
        switch (this.c) {
            case 0:
                this.a.showToast(this.a.getString(R.string.success));
                arrayList = this.a.a;
                arrayList.remove(this.b);
                this.b = null;
                pVar = this.a.b;
                pVar.notifyDataSetChanged();
                break;
            case 1:
                if (accountData != null) {
                    new o(this.a, accountData.getBDUSS()).start();
                }
                TiebaApplication.a(accountData, this.a);
                com.baidu.tieba.account.l.a().b();
                MainTabActivity.b(this.a, 1);
                break;
            case 2:
                MainTabActivity.b(this.a, 4);
                break;
        }
        this.a.h = null;
    }
}
