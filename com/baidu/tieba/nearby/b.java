package com.baidu.tieba.nearby;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyForumActivity f1149a;
    private volatile com.baidu.tieba.util.r b = null;
    private volatile String c;
    private volatile String d;

    public b(NearbyForumActivity nearbyForumActivity, String str, String str2) {
        this.f1149a = nearbyForumActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f1149a.m;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        boolean z;
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/forum/like");
            this.b.a("kw", this.c);
            this.b.a("fid", this.d);
            this.b.d(true);
            this.b.j();
            if (this.b.c()) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ProgressBar progressBar;
        com.baidu.tieba.model.at atVar;
        d dVar;
        progressBar = this.f1149a.m;
        progressBar.setVisibility(8);
        this.f1149a.n = null;
        this.f1149a.l = false;
        if (bool.booleanValue()) {
            atVar = this.f1149a.b;
            atVar.a(this.d);
            dVar = this.f1149a.d;
            dVar.notifyDataSetChanged();
            this.f1149a.a(this.f1149a.getString(R.string.like_success));
            TiebaApplication.f().i(true);
            return;
        }
        this.f1149a.a(this.b.g());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        progressBar = this.f1149a.m;
        progressBar.setVisibility(8);
        this.f1149a.n = null;
        this.f1149a.l = false;
        super.cancel(true);
    }
}
