package com.baidu.tieba.nearby;

import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.a.a {
    final /* synthetic */ NearbyForumActivity a;
    private volatile com.baidu.tieba.d.t b = null;
    private volatile String c;
    private volatile String d;

    public b(NearbyForumActivity nearbyForumActivity, String str, String str2) {
        this.a = nearbyForumActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.m;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        boolean z;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/forum/like");
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
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        ProgressBar progressBar;
        com.baidu.tieba.c.at atVar;
        d dVar;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.n = null;
        this.a.l = false;
        if (bool.booleanValue()) {
            atVar = this.a.d;
            atVar.a(this.d);
            dVar = this.a.f;
            dVar.notifyDataSetChanged();
            this.a.a(this.a.getString(R.string.like_success));
            TiebaApplication.d().i(true);
            return;
        }
        this.a.a(this.b.f());
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
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
