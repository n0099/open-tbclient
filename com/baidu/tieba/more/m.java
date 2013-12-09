package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2097a;
    private AccountData b;

    public m(AccountActivity accountActivity, AccountData accountData) {
        this.f2097a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f2097a.showLoadingDialog(this.f2097a.getString(R.string.account_logining), new n(this));
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
            TiebaApplication.a(this.b, this.f2097a.getBaseContext());
        } catch (Exception e) {
            bd.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (this.b != null) {
            new o(this.f2097a, this.b.getBDUSS()).start();
        }
        this.f2097a.closeLoadingDialog();
        MainTabActivity.b(this.f2097a, 1);
        com.baidu.tieba.account.a.a().b();
        this.f2097a.g = null;
    }
}
