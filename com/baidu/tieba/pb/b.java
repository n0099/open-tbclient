package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ab> {
    final /* synthetic */ a a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;
    private int e;
    private int f;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.ab a(Object... objArr) {
        return e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void a(com.baidu.tieba.data.ab abVar) {
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
        ArrayList arrayList3;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        com.baidu.tieba.data.ab abVar2 = abVar;
        super.a((b) abVar2);
        this.a.h = null;
        if (abVar2 != null) {
            this.a.i = abVar2.k();
            this.a.c = abVar2.g();
            this.a.b = abVar2.f();
            if (this.d == null) {
                arrayList3 = this.a.a;
                arrayList3.clear();
            }
            LinkedList<com.baidu.tieba.data.aa> h = abVar2.h();
            int size = h.size();
            if (size > 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2 = this.a.a;
                    arrayList2.add(a.a(this.a, h.get(i5)));
                }
                com.baidu.tieba.data.aa aaVar = h.get(size - 1);
                this.a.f = aaVar.c();
                i3 = this.a.i;
                if (i3 != aaVar.h()) {
                    this.a.g = false;
                    z = this.a.g;
                    if (z) {
                        str2 = this.a.b;
                        if (str2 != null) {
                            str3 = this.a.b;
                            if (str3.length() > 0) {
                                z2 = true;
                                if (this.d == null) {
                                    this.a.d = this.c;
                                    z3 = true;
                                    i = 0;
                                } else {
                                    z3 = false;
                                    i = -1;
                                }
                                cVar = this.a.l;
                                if (cVar != null) {
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
                    if (this.d == null) {
                    }
                    cVar = this.a.l;
                    if (cVar != null) {
                    }
                }
            }
            this.a.g = true;
            z = this.a.g;
            if (z) {
            }
            z2 = false;
            if (this.d == null) {
            }
            cVar = this.a.l;
            if (cVar != null) {
            }
        } else {
            cVar3 = this.a.l;
            if (cVar3 != null) {
                if (this.b != null) {
                    i4 = this.b.e();
                    str4 = this.d == null ? this.b.i() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.a.l;
                cVar4.a(i4, str4);
            }
        }
    }

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

    public final String d() {
        return this.d;
    }

    private com.baidu.tieba.data.ab e() {
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
        String l = this.b.l();
        if (!this.b.c()) {
            return null;
        }
        com.baidu.tieba.data.ab abVar = new com.baidu.tieba.data.ab();
        abVar.a(l, true);
        return abVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        this.a.h = null;
        super.cancel(true);
    }
}
