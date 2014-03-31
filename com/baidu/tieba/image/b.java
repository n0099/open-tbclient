package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.data.t;
import com.baidu.tieba.data.u;
import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<Object, Integer, u> {
    final /* synthetic */ a a;
    private ak b = null;
    private String c;
    private String d;
    private int e;
    private int f;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ u a(Object... objArr) {
        return e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void a(u uVar) {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
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
        ArrayList arrayList4;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        u uVar2 = uVar;
        super.a((b) uVar2);
        this.a.h = null;
        if (uVar2 != null) {
            this.a.i = uVar2.k();
            this.a.c = uVar2.g();
            this.a.b = uVar2.f();
            if (this.d == null) {
                arrayList4 = this.a.a;
                arrayList4.clear();
            }
            LinkedList<t> h = uVar2.h();
            int size = h.size();
            if (size > 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    String a = a.a(this.a, h.get(i5));
                    arrayList2 = this.a.a;
                    if (!arrayList2.contains(a)) {
                        arrayList3 = this.a.a;
                        arrayList3.add(a);
                    }
                }
                t tVar = h.get(size - 1);
                this.a.f = tVar.c();
                i3 = this.a.i;
                if (i3 != tVar.h()) {
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
                                    i = 0;
                                    z3 = true;
                                } else {
                                    i = -1;
                                    z3 = false;
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
                    i4 = this.b.d();
                    str4 = this.d == null ? this.b.f() : null;
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

    public final String a() {
        return this.d;
    }

    private u e() {
        String str;
        boolean z;
        this.b = new ak(String.valueOf(n.a) + "c/f/pb/picpage");
        ak akVar = this.b;
        str = this.a.e;
        akVar.a("kw", str);
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
        this.b.a().a().b = false;
        String i = this.b.i();
        if (!this.b.a().b().b()) {
            return null;
        }
        u uVar = new u();
        uVar.a(i, true);
        return uVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.h = null;
        super.cancel(true);
    }
}
