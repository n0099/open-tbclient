package com.baidu.tieba.recommend;

import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends AsyncTask {
    ArrayList a;
    final /* synthetic */ GuessActivity b;
    private String d;
    private int e;
    private t c = null;
    private volatile long f = 0;

    public k(GuessActivity guessActivity, String str, ArrayList arrayList, int i) {
        this.b = guessActivity;
        this.d = null;
        this.e = 3;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.e = i;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        this.f = System.nanoTime();
        switch (this.e) {
            case 1:
                lVar3 = this.b.j;
                lVar3.a(true);
                lVar4 = this.b.j;
                lVar4.notifyDataSetChanged();
                return;
            case 2:
                lVar = this.b.j;
                lVar.b(true);
                lVar2 = this.b.j;
                lVar2.notifyDataSetChanged();
                return;
            case 3:
                this.b.a(true);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.e doInBackground(Object... objArr) {
        com.baidu.tieba.b.e eVar;
        Exception e;
        long j;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        try {
            this.c = new t(this.d);
            this.c.a(this.a);
            j = GuessActivity.n;
            if (j != 0) {
                t tVar = this.c;
                j4 = GuessActivity.n;
                tVar.a("ctime", String.valueOf(j4));
            }
            j2 = GuessActivity.o;
            if (j2 != 0) {
                t tVar2 = this.c;
                j3 = GuessActivity.o;
                tVar2.a("data_size", String.valueOf(j3));
            }
            i = GuessActivity.p;
            if (i != 0) {
                t tVar3 = this.c;
                i2 = GuessActivity.p;
                tVar3.a("net_error", String.valueOf(i2));
            }
            this.c.a(this.b);
            String i3 = this.c.i();
            if (!this.c.b()) {
                eVar = null;
            } else {
                com.baidu.tieba.b.e eVar2 = new com.baidu.tieba.b.e();
                try {
                    eVar2.a(i3);
                    ag.a(getClass().getName(), "doInBackground", i3);
                    eVar = eVar2;
                } catch (Exception e2) {
                    e = e2;
                    eVar = eVar2;
                    ag.b(getClass().getName(), "", "GuessAsyncTask.doInBackground error = " + e.getMessage());
                    return eVar;
                }
            }
        } catch (Exception e3) {
            eVar = null;
            e = e3;
        }
        try {
            if (this.c.c()) {
                GuessActivity.n = 0L;
                GuessActivity.o = 0L;
                GuessActivity.p = 0;
            } else {
                GuessActivity.p = 1;
            }
        } catch (Exception e4) {
            e = e4;
            ag.b(getClass().getName(), "", "GuessAsyncTask.doInBackground error = " + e.getMessage());
            return eVar;
        }
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.e eVar) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        switch (this.e) {
            case 1:
                lVar3 = this.b.j;
                lVar3.a(false);
                lVar4 = this.b.j;
                lVar4.notifyDataSetChanged();
                break;
            case 2:
                lVar = this.b.j;
                lVar.b(false);
                lVar2 = this.b.j;
                lVar2.notifyDataSetChanged();
                break;
            case 3:
                this.b.a(false);
                break;
        }
        if (eVar != null) {
            this.b.l = eVar;
            this.b.s();
            GuessActivity.n = (System.nanoTime() - this.f) / 1000000;
            if (this.c != null) {
                GuessActivity.o = this.c.a();
            }
            TiebaApplication.b().c(System.currentTimeMillis());
        } else {
            b();
        }
        this.b.k = null;
        this.b.h = null;
        System.gc();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    public void a() {
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    private void b() {
        this.b.b(this.c.f());
    }
}
