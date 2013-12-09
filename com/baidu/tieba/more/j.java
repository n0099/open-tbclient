package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, AccountData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2094a;
    private AccountData b;
    private int c = 0;
    private boolean d;

    public j(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.f2094a = accountActivity;
        this.d = false;
        this.b = accountData;
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f2094a.showLoadingDialog(this.f2094a.getString(R.string.deleting), new k(this));
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
            DatabaseService.o(this.b.getID());
            if (this.b.getID().equals(TiebaApplication.B())) {
                TiebaApplication.a((AccountData) null, this.f2094a.getBaseContext());
                arrayList = this.f2094a.f2053a;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.f2094a.f2053a;
                    AccountData accountData = (AccountData) arrayList2.get(1);
                    accountData.setIsActive(1);
                    DatabaseService.a(accountData);
                    return accountData;
                }
                com.baidu.tieba.account.a.a().a(this.b.getBDUSS());
                this.c = 2;
            } else {
                this.c = 0;
            }
        } catch (Exception e) {
            bd.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
            new l(this.f2094a, this.b.getBDUSS()).start();
        }
        this.f2094a.closeLoadingDialog();
        switch (this.c) {
            case 0:
                this.f2094a.showToast(this.f2094a.getString(R.string.success));
                arrayList = this.f2094a.f2053a;
                arrayList.remove(this.b);
                this.b = null;
                pVar = this.f2094a.b;
                pVar.notifyDataSetChanged();
                break;
            case 1:
                if (accountData != null) {
                    new o(this.f2094a, accountData.getBDUSS()).start();
                }
                TiebaApplication.a(accountData, this.f2094a.getBaseContext());
                com.baidu.tieba.account.a.a().b();
                MainTabActivity.b(this.f2094a, 1);
                break;
            case 2:
                MainTabActivity.b(this.f2094a, 4);
                break;
        }
        this.f2094a.h = null;
    }
}
