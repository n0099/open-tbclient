package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends AsyncTask {
    final /* synthetic */ h a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private ArrayList d;
    private e e;

    public p(h hVar, String str, ArrayList arrayList, e eVar) {
        this.a = hVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = eVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.j doInBackground(Object... objArr) {
        com.baidu.tieba.b.j jVar;
        Exception e;
        com.baidu.tieba.e eVar;
        int i;
        n nVar;
        try {
            this.b = new com.baidu.tieba.c.t(this.c);
            this.b.a(this.d);
            com.baidu.tieba.c.t tVar = this.b;
            eVar = this.a.b;
            tVar.a(eVar);
            String i2 = this.b.i();
            if (!this.b.b() || i2 == null) {
                return null;
            }
            jVar = new com.baidu.tieba.b.j();
            try {
                jVar.a(i2);
                if (jVar.a()) {
                    i = this.a.o;
                    if (i != 4) {
                        nVar = this.a.j;
                        nVar.a(i2);
                        return jVar;
                    }
                    return jVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return jVar;
            }
        } catch (Exception e3) {
            jVar = null;
            e = e3;
        }
    }

    private void a(boolean z) {
        int i;
        ProgressBar progressBar;
        int i2;
        ProgressBar progressBar2;
        if (z) {
            i2 = this.a.o;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    progressBar2 = this.a.l;
                    progressBar2.setVisibility(0);
                    return;
                case 4:
                    this.e.c(true);
                    this.e.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
        i = this.a.o;
        switch (i) {
            case 1:
            case 2:
            case 3:
                progressBar = this.a.l;
                progressBar.setVisibility(8);
                return;
            case 4:
                this.e.c(false);
                this.e.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.j jVar) {
        com.baidu.tieba.e eVar;
        a(false);
        if (this.b != null) {
            if (!this.b.c() || jVar == null) {
                eVar = this.a.b;
                Activity parent = eVar.getParent();
                if (parent != null && (parent instanceof MentionActivity)) {
                    ai.a((Context) ((MentionActivity) parent), this.b.f());
                }
            } else {
                this.a.a(jVar);
            }
        }
        this.a.k = null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
