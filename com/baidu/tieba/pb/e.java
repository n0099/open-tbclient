package com.baidu.tieba.pb;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends AsyncTask {
    final /* synthetic */ d a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;
    private int e;
    private int f;

    public e(d dVar, String str, String str2, int i, int i2) {
        this.a = dVar;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.d = str2;
        this.c = str;
        this.e = i;
        this.f = i2;
    }

    public String a() {
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.v doInBackground(Object... objArr) {
        String str;
        boolean z;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/pb/picpage");
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.e;
        tVar.a("kw", str);
        this.b.a("tid", this.c);
        if (this.d != null) {
            this.b.a("pic_id", this.d);
        }
        this.b.a("next", String.valueOf(this.e));
        this.b.a("prev", String.valueOf(this.f));
        z = this.a.j;
        if (!z) {
            this.b.a("not_see_lz", String.valueOf(1));
        }
        this.b.b(false);
        String i = this.b.i();
        if (!this.b.b()) {
            return null;
        }
        com.baidu.tieba.a.v vVar = new com.baidu.tieba.a.v();
        vVar.a(i, true);
        return vVar;
    }

    public void b() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.h = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(com.baidu.tieba.a.v vVar) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        f fVar;
        f fVar2;
        ArrayList arrayList;
        int i2;
        String str;
        String str2;
        String str3;
        int i3;
        ArrayList arrayList2;
        String a;
        ArrayList arrayList3;
        f fVar3;
        int i4;
        String str4;
        f fVar4;
        super.onPostExecute(vVar);
        this.a.h = null;
        if (vVar != null) {
            this.a.i = vVar.k();
            this.a.c = vVar.g();
            this.a.b = vVar.f();
            if (this.d == null) {
                arrayList3 = this.a.a;
                arrayList3.clear();
            }
            LinkedList h = vVar.h();
            int size = h.size();
            if (size <= 0) {
                this.a.g = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2 = this.a.a;
                    a = this.a.a((com.baidu.tieba.a.u) h.get(i5));
                    arrayList2.add(a);
                }
                com.baidu.tieba.a.u uVar = (com.baidu.tieba.a.u) h.get(size - 1);
                this.a.f = uVar.c();
                i3 = this.a.i;
                if (i3 == uVar.h()) {
                    this.a.g = true;
                } else {
                    this.a.g = false;
                }
            }
            z = this.a.g;
            if (z) {
                str2 = this.a.b;
                if (str2 != null) {
                    str3 = this.a.b;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.d != null) {
                            this.a.d = this.c;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        fVar = this.a.l;
                        if (fVar == null) {
                            fVar2 = this.a.l;
                            arrayList = this.a.a;
                            i2 = this.a.i;
                            str = this.a.c;
                            fVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.d != null) {
            }
            fVar = this.a.l;
            if (fVar == null) {
            }
        } else {
            fVar3 = this.a.l;
            if (fVar3 != null) {
                if (this.b != null) {
                    i4 = this.b.d();
                    str4 = this.d == null ? this.b.f() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                fVar4 = this.a.l;
                fVar4.a(i4, str4);
            }
        }
    }
}
