package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1416a;
    private AccountData b;

    public l(AccountActivity accountActivity, AccountData accountData) {
        this.f1416a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1416a.a(this.f1416a.getString(R.string.account_logining), new m(this));
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
            TiebaApplication.a(this.b, this.f1416a.getBaseContext());
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (this.b != null) {
            new n(this.f1416a, this.b.getBDUSS()).start();
        }
        this.f1416a.h();
        MainTabActivity.b(this.f1416a, "goto_home");
        com.baidu.tieba.account.a.a().b();
        this.f1416a.k = null;
    }
}
