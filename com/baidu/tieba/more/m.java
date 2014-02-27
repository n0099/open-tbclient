package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        TiebaApplication.a(this.b, this.a.getBaseContext());
        if (this.b != null) {
            new o(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        com.baidu.tieba.d.d.a();
        com.baidu.tieba.d.d.b();
        TiebaApplication.g();
        TiebaApplication.u();
        com.baidu.tieba.mention.v.a().j();
        com.baidu.tieba.mention.v.a().h();
        com.baidu.tieba.mainentrance.d.a(this.a, 1, false);
        this.a.h = null;
    }

    public m(AccountActivity accountActivity, AccountData accountData) {
        this.a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        this.a.showLoadingDialog(this.a.getString(R.string.account_logining), new n(this));
    }

    private Boolean d() {
        try {
            Thread.sleep(1000L);
            this.b.setIsActive(1);
            DatabaseService.a(this.b);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }
}
