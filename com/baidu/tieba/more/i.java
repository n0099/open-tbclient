package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1450a;
    private AccountData b;
    private int c = 0;

    public i(AccountActivity accountActivity, AccountData accountData) {
        this.f1450a = accountActivity;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1450a.a(this.f1450a.getString(R.string.deleting), new j(this));
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
            DatabaseService.p(this.b.getID());
            if (this.b.getID().equals(TiebaApplication.E())) {
                TiebaApplication.a((AccountData) null, this.f1450a.getBaseContext());
                arrayList = this.f1450a.f1425a;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.f1450a.f1425a;
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
            aq.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        ArrayList arrayList;
        o oVar;
        if (this.b != null) {
            new k(this.f1450a, this.b.getBDUSS()).start();
        }
        this.f1450a.h();
        switch (this.c) {
            case 0:
                this.f1450a.a(this.f1450a.getString(R.string.success));
                arrayList = this.f1450a.f1425a;
                arrayList.remove(this.b);
                this.b = null;
                oVar = this.f1450a.b;
                oVar.notifyDataSetChanged();
                break;
            case 1:
                if (accountData != null) {
                    new n(this.f1450a, accountData.getBDUSS()).start();
                }
                TiebaApplication.a(accountData, this.f1450a.getBaseContext());
                com.baidu.tieba.account.a.a().b();
                MainTabActivity.b(this.f1450a, 1);
                break;
            case 2:
                MainTabActivity.b(this.f1450a, 4);
                break;
        }
        this.f1450a.l = null;
    }
}
