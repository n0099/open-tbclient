package com.baidu.tieba.nearby;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends AsyncTask {
    final /* synthetic */ NearbyForumActivity a;
    private volatile com.baidu.tieba.c.t b = null;
    private volatile String c;
    private volatile String d;

    public b(NearbyForumActivity nearbyForumActivity, String str, String str2) {
        this.a = nearbyForumActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.m;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        boolean z;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/like");
            this.b.a("kw", this.c);
            this.b.a("fid", this.d);
            this.b.d(true);
            this.b.i();
            if (this.b.b()) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        com.baidu.tieba.b.m mVar;
        d dVar;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.n = null;
        this.a.l = false;
        if (bool.booleanValue()) {
            mVar = this.a.d;
            mVar.a(this.d);
            dVar = this.a.f;
            dVar.notifyDataSetChanged();
            this.a.b(this.a.getString(R.string.like_success));
            return;
        }
        this.a.b(this.b.f());
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.n = null;
        this.a.l = false;
        super.cancel(true);
    }
}
