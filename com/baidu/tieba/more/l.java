package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1453a;
    private AccountData b;

    public l(AccountActivity accountActivity, AccountData accountData) {
        this.f1453a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1453a.a(this.f1453a.getString(R.string.account_logining), new m(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        try {
            Thread.sleep(1000L);
            this.b.setIsActive(1);
            DatabaseService.a(this.b);
            TiebaApplication.a(this.b, this.f1453a.getBaseContext());
        } catch (Exception e) {
            aq.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (this.b != null) {
            new n(this.f1453a, this.b.getBDUSS()).start();
        }
        this.f1453a.h();
        MainTabActivity.b(this.f1453a, 1);
        com.baidu.tieba.account.a.a().b();
        this.f1453a.k = null;
    }
}
