package com.baidu.tieba;

import android.os.AsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends AsyncTask {
    ArrayList a;
    final /* synthetic */ LabelActivity b;
    private String d;
    private boolean f;
    private com.baidu.tieba.c.t c = null;
    private int e = 1;

    public v(LabelActivity labelActivity, String str, boolean z, ArrayList arrayList) {
        this.b = labelActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.f = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.b.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        com.baidu.tieba.b.f fVar;
        com.baidu.tieba.b.f fVar2;
        com.baidu.tieba.b.f fVar3;
        com.baidu.tieba.b.f fVar4;
        com.baidu.tieba.b.f fVar5;
        com.baidu.tieba.b.f fVar6;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            fVar = this.b.q;
            if (fVar != null) {
                fVar5 = this.b.q;
                if (fVar5.h().size() != 0) {
                    fVar6 = this.b.q;
                    this.c.a("tag_info", fVar6.g());
                }
            }
            com.baidu.tieba.c.ag.b("begin to get label data...url is " + this.d);
            String i = this.c.i();
            com.baidu.tieba.c.ag.b("end to get label data...");
            if (this.c.b()) {
                fVar2 = this.b.q;
                if (fVar2 == null) {
                    this.b.q = new com.baidu.tieba.b.f();
                }
                fVar3 = this.b.q;
                fVar3.a(i);
                if (this.f) {
                    fVar4 = this.b.q;
                    fVar4.b(com.baidu.tieba.c.k.b(12));
                }
                com.baidu.tieba.c.ag.a(getClass().getName(), "doInBackground", i);
                System.gc();
            }
            if (this.c.c()) {
                this.e = 0;
            } else {
                this.e = 1;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "LabelAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        this.b.b(false);
        if (bool.booleanValue() && this.e != 1) {
            this.b.n();
            this.b.c(false);
        } else {
            b();
        }
        this.b.M = null;
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
