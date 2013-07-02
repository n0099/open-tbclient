package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {
    final /* synthetic */ AccountActivity a;
    private AccountData b;
    private int c = 0;

    public i(AccountActivity accountActivity, AccountData accountData) {
        this.a = accountActivity;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.a(this.a.getString(R.string.deleting), new j(this));
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
            DatabaseService.r(this.b.getID());
            if (this.b.getID().equals(TiebaApplication.E())) {
                TiebaApplication.b((AccountData) null);
                arrayList = this.a.a;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.a.a;
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
            com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        ArrayList arrayList;
        n nVar;
        if (this.b != null) {
            new k(this.a, this.b.getBDUSS()).start();
        }
        this.a.h();
        switch (this.c) {
            case 0:
                this.a.a(this.a.getString(R.string.success));
                arrayList = this.a.a;
                arrayList.remove(this.b);
                this.b = null;
                nVar = this.a.b;
                nVar.notifyDataSetChanged();
                break;
            case 1:
                TiebaApplication.b(accountData);
                com.baidu.tieba.account.a.a().b();
                MainTabActivity.b(this.a, "goto_home");
                break;
            case 2:
                MainTabActivity.b(this.a, "goto_person");
                break;
        }
        this.a.l = null;
    }
}
