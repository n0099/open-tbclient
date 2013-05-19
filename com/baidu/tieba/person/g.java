package com.baidu.tieba.person;

import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.a {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.d.t b;

    private g(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(EditBarActivity editBarActivity, g gVar) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.c.b a(Object... objArr) {
        com.baidu.tieba.c.b bVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/forum/like");
            str = this.a.o;
            if (str != null) {
                com.baidu.tieba.d.t tVar = this.b;
                str2 = this.a.o;
                tVar.a("uid", str2);
            }
            String i = this.b.i();
            if (!this.b.b()) {
                return null;
            }
            bVar = new com.baidu.tieba.c.b();
            try {
                bVar.a(i);
                return bVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return bVar;
            }
        } catch (Exception e3) {
            bVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.b bVar) {
        ProgressBar progressBar;
        com.baidu.tieba.c.b bVar2;
        i iVar;
        i iVar2;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.i = null;
        if (this.b != null) {
            if (this.b.b() && bVar != null) {
                bVar2 = this.a.c;
                bVar2.a(bVar.a());
                iVar = this.a.g;
                if (iVar == null) {
                    return;
                }
                this.a.m();
                iVar2 = this.a.g;
                iVar2.notifyDataSetChanged();
                return;
            }
            this.a.a(this.b.f());
        }
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
        this.a.i = null;
        super.cancel(true);
    }
}
