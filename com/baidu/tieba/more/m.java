package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;

    public m(AccountActivity accountActivity, AccountData accountData) {
        this.a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.showLoadingDialog(this.a.getString(R.string.account_logining), new n(this));
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
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        TiebaApplication.a(this.b, this.a.getBaseContext());
        if (this.b != null) {
            new o(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        com.baidu.tieba.c.d.a().b();
        MainTabActivity.c(this.a, 1);
        this.a.g = null;
    }
}
