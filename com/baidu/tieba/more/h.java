package com.baidu.tieba.more;

import android.os.AsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends AsyncTask {
    final /* synthetic */ AccountActivity a;
    private com.baidu.tieba.a.a b;
    private int c = 0;

    public h(AccountActivity accountActivity, com.baidu.tieba.a.a aVar) {
        this.a = accountActivity;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.a doInBackground(Object... objArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            Thread.sleep(1000L);
            com.baidu.tieba.c.k.o(this.b.a());
            if (this.b.a().equals(TiebaApplication.u())) {
                TiebaApplication.b((com.baidu.tieba.a.a) null);
                arrayList = this.a.b;
                if (arrayList.size() >= 2) {
                    this.c = 1;
                    arrayList2 = this.a.b;
                    com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) arrayList2.get(1);
                    aVar.a(1);
                    com.baidu.tieba.c.k.a(aVar);
                    return aVar;
                }
                com.baidu.tieba.account.a.a().a(this.b.d());
                this.c = 2;
            } else {
                this.c = 0;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.a aVar) {
        ArrayList arrayList;
        m mVar;
        if (this.b != null) {
            new j(this.a, this.b.d()).start();
        }
        this.a.c();
        switch (this.c) {
            case 0:
                this.a.b(this.a.getString(R.string.success));
                arrayList = this.a.b;
                arrayList.remove(this.b);
                this.b = null;
                mVar = this.a.c;
                mVar.notifyDataSetChanged();
                break;
            case 1:
                TiebaApplication.b(aVar);
                com.baidu.tieba.account.a.a().b();
                MainTabActivity.b(this.a, "goto_home");
                break;
            case 2:
                MainTabActivity.b(this.a, "goto_more");
                break;
        }
        this.a.i = null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.a(this.a.getString(R.string.deleting), new i(this));
    }
}
