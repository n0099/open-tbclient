package com.baidu.tieba.mention;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.c.ae;
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
    public com.baidu.tieba.b.i doInBackground(Object... objArr) {
        com.baidu.tieba.b.i iVar;
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
            iVar = new com.baidu.tieba.b.i();
            try {
                iVar.a(i2);
                if (iVar.a()) {
                    i = this.a.o;
                    if (i != 4) {
                        nVar = this.a.j;
                        nVar.a(i2);
                        return iVar;
                    }
                    return iVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return iVar;
            }
        } catch (Exception e3) {
            iVar = null;
            e = e3;
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.i iVar) {
        com.baidu.tieba.b.i iVar2;
        com.baidu.tieba.e eVar;
        com.baidu.tieba.e eVar2;
        com.baidu.tieba.e eVar3;
        a(false);
        if (iVar == null && this.b != null) {
            if (this.b.c()) {
                eVar3 = this.a.b;
                eVar3.b(this.b.f());
            } else {
                iVar2 = this.a.f;
                if (iVar2 == null) {
                    eVar2 = this.a.b;
                    eVar2.b(this.b.f());
                    iVar = new com.baidu.tieba.b.i();
                    this.e.a(false);
                    ArrayList b = iVar.b();
                    if (b != null) {
                        this.e.a(b);
                        this.e.notifyDataSetInvalidated();
                    }
                    this.a.f = iVar;
                } else {
                    eVar = this.a.b;
                    eVar.b(this.b.f());
                }
            }
        }
        this.a.a(iVar);
        this.a.k = null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        a(true);
    }
}
