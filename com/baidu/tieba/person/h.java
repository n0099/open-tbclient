package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.a {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.d.t b;

    private h(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(EditBarActivity editBarActivity, h hVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(com.baidu.tieba.a.s... sVarArr) {
        com.baidu.tieba.a.s sVar = sVarArr[0];
        if (sVar != null) {
            try {
                if (sVar.a() != null && sVar.b() != null) {
                    this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/forum/unfavolike");
                    this.b.a("fid", sVar.a());
                    this.b.a("kw", sVar.b());
                    this.b.a("favo_type", String.valueOf(sVar.j()));
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.c.b bVar;
        int i;
        int i2;
        int i3;
        i iVar;
        i iVar2;
        super.a((Object) str);
        this.a.k = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.b()) {
                bVar = this.a.c;
                ArrayList a = bVar.a();
                if (a != null) {
                    i = this.a.j;
                    if (i >= 0) {
                        i2 = this.a.j;
                        if (i2 < a.size()) {
                            i3 = this.a.j;
                            a.remove(i3);
                            iVar = this.a.g;
                            if (iVar != null) {
                                this.a.m();
                                iVar2 = this.a.g;
                                iVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                TiebaApplication.e().i(true);
                this.a.a(this.a.getString(R.string.success));
                return;
            }
            this.a.a(this.b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
