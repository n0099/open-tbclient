package com.baidu.tieba.more;

import android.os.AsyncTask;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends AsyncTask {
    final /* synthetic */ AccountActivity a;
    private com.baidu.tieba.a.a b;

    public k(AccountActivity accountActivity, com.baidu.tieba.a.a aVar) {
        this.a = accountActivity;
        this.b = null;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        try {
            Thread.sleep(1000L);
            this.b.a(1);
            com.baidu.tieba.c.k.a(this.b);
            TiebaApplication.b(this.b);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        this.a.c();
        MainTabActivity.b(this.a, "goto_home");
        com.baidu.tieba.account.a.a().b();
        this.a.h = null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.a(this.a.getString(R.string.account_logining), new l(this));
    }
}
