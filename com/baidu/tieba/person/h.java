package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<com.baidu.tieba.data.v, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1694a;
    private com.baidu.tieba.util.z b;

    private h(EditBarActivity editBarActivity) {
        this.f1694a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(EditBarActivity editBarActivity, h hVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.v... vVarArr) {
        String str;
        com.baidu.tieba.data.v vVar = vVarArr[0];
        if (vVar != null) {
            try {
                if (vVar.a() != null && vVar.b() != null) {
                    this.f1694a.l = vVar.b();
                    this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/unfavolike");
                    this.b.a("fid", vVar.a());
                    com.baidu.tieba.util.z zVar = this.b;
                    str = this.f1694a.l;
                    zVar.a("kw", str);
                    this.b.a("favo_type", String.valueOf(vVar.j()));
                    this.b.e(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.model.d dVar;
        int i;
        int i2;
        int i3;
        String str2;
        i iVar;
        i iVar2;
        super.a((h) str);
        this.f1694a.m = null;
        progressBar = this.f1694a.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.c()) {
                dVar = this.f1694a.f1638a;
                ArrayList<com.baidu.tieba.data.v> a2 = dVar.a();
                if (a2 != null) {
                    i = this.f1694a.k;
                    if (i >= 0) {
                        i2 = this.f1694a.k;
                        if (i2 < a2.size()) {
                            i3 = this.f1694a.k;
                            a2.remove(i3);
                            TiebaApplication g = TiebaApplication.g();
                            str2 = this.f1694a.l;
                            g.f(str2);
                            iVar = this.f1694a.f;
                            if (iVar != null) {
                                this.f1694a.e();
                                iVar2 = this.f1694a.f;
                                iVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.f1694a.a(this.f1694a.getString(R.string.success));
                return;
            }
            this.f1694a.a(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f1694a.g;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.f1694a.g;
        progressBar.setVisibility(8);
        this.f1694a.m = null;
        super.cancel(true);
    }
}
