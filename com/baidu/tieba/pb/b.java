package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ab> {
    final /* synthetic */ a a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;
    private int e;
    private int f;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.a = aVar;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.d = str2;
        this.c = str;
        this.e = i;
        this.f = i2;
    }

    public String e() {
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ab a(Object... objArr) {
        String str;
        boolean z;
        this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/pb/picpage");
        com.baidu.tieba.util.ba baVar = this.b;
        str = this.a.e;
        baVar.a("kw", str);
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
        this.b.c(false);
        String m = this.b.m();
        if (!this.b.d()) {
            return null;
        }
        com.baidu.tieba.data.ab abVar = new com.baidu.tieba.data.ab();
        abVar.a(m, true);
        return abVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.k();
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.data.ab abVar) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        c cVar;
        c cVar2;
        ArrayList<String> arrayList;
        int i2;
        String str;
        String str2;
        String str3;
        int i3;
        ArrayList arrayList2;
        String a;
        ArrayList arrayList3;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        super.a((b) abVar);
        this.a.h = null;
        if (abVar != null) {
            this.a.i = abVar.k();
            this.a.c = abVar.g();
            this.a.b = abVar.f();
            if (this.d == null) {
                arrayList3 = this.a.a;
                arrayList3.clear();
            }
            LinkedList<com.baidu.tieba.data.aa> h = abVar.h();
            int size = h.size();
            if (size <= 0) {
                this.a.g = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2 = this.a.a;
                    a = this.a.a(h.get(i5));
                    arrayList2.add(a);
                }
                com.baidu.tieba.data.aa aaVar = h.get(size - 1);
                this.a.f = aaVar.c();
                i3 = this.a.i;
                if (i3 == aaVar.h()) {
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
                        cVar = this.a.l;
                        if (cVar == null) {
                            cVar2 = this.a.l;
                            arrayList = this.a.a;
                            i2 = this.a.i;
                            str = this.a.c;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.d != null) {
            }
            cVar = this.a.l;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.a.l;
            if (cVar3 != null) {
                if (this.b != null) {
                    i4 = this.b.f();
                    str4 = this.d == null ? this.b.j() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.a.l;
                cVar4.a(i4, str4);
            }
        }
    }
}
