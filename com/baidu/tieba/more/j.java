package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;
    private int c = 0;
    private boolean d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ AccountData a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(AccountData accountData) {
        ArrayList arrayList;
        p pVar;
        AccountData accountData2 = accountData;
        if (this.b != null) {
            new l(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        if (this.c != 0) {
            TiebaApplication.a((AccountData) null, this.a);
            com.baidu.tieba.account.m.a().b(this.b.getAccount());
            com.baidu.tieba.account.m.a().a(this.b.getBDUSS());
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
                if (accountData2 != null) {
                    new o(this.a, accountData2.getBDUSS()).start();
                }
                TiebaApplication.a(accountData2, this.a);
                TiebaApplication.g();
                TiebaApplication.u();
                com.baidu.tieba.mention.v.a().j();
                com.baidu.tieba.mention.v.a().h();
                com.baidu.tieba.mainentrance.d.a(this.a, 1, false);
                break;
            case 2:
                TiebaApplication.g();
                TiebaApplication.u();
                com.baidu.tieba.mention.v.a().j();
                com.baidu.tieba.mention.v.a().h();
                com.baidu.tieba.mainentrance.d.a(this.a, 11, false);
                break;
        }
        this.a.i = null;
    }

    public j(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.a = accountActivity;
        this.d = false;
        this.b = accountData;
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        this.a.showLoadingDialog(this.a.getString(R.string.deleting), new k(this));
    }

    private AccountData d() {
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            Thread.sleep(1000L);
            if (this.d) {
                com.baidu.tieba.im.db.g.a(this.b.getID());
            }
            DatabaseService.l(this.b.getID());
            if (this.b.getID().equals(TiebaApplication.v())) {
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
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }
}
