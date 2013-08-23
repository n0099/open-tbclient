package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1503a;
    private com.baidu.tieba.util.v b = null;
    private String c;
    private String d;
    private int e;
    private int f;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.f1503a = aVar;
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
    public com.baidu.tieba.data.ac a(Object... objArr) {
        String str;
        boolean z;
        this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/pb/picpage");
        com.baidu.tieba.util.v vVar = this.b;
        str = this.f1503a.e;
        vVar.a("kw", str);
        this.b.a("tid", this.c);
        if (this.d != null) {
            this.b.a("pic_id", this.d);
        }
        this.b.a("next", String.valueOf(this.e));
        this.b.a("prev", String.valueOf(this.f));
        z = this.f1503a.j;
        if (!z) {
            this.b.a("not_see_lz", String.valueOf(1));
        }
        this.b.c(false);
        String j = this.b.j();
        if (!this.b.c()) {
            return null;
        }
        com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac();
        acVar.a(j, true);
        return acVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1503a.h = null;
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
    public void a(com.baidu.tieba.data.ac acVar) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        c cVar;
        c cVar2;
        ArrayList arrayList;
        int i2;
        String str;
        String str2;
        String str3;
        int i3;
        ArrayList arrayList2;
        String a2;
        ArrayList arrayList3;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        super.a((Object) acVar);
        this.f1503a.h = null;
        if (acVar != null) {
            this.f1503a.i = acVar.k();
            this.f1503a.c = acVar.g();
            this.f1503a.b = acVar.f();
            if (this.d == null) {
                arrayList3 = this.f1503a.f1477a;
                arrayList3.clear();
            }
            LinkedList h = acVar.h();
            int size = h.size();
            if (size <= 0) {
                this.f1503a.g = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2 = this.f1503a.f1477a;
                    a2 = this.f1503a.a((com.baidu.tieba.data.ab) h.get(i5));
                    arrayList2.add(a2);
                }
                com.baidu.tieba.data.ab abVar = (com.baidu.tieba.data.ab) h.get(size - 1);
                this.f1503a.f = abVar.c();
                i3 = this.f1503a.i;
                if (i3 == abVar.h()) {
                    this.f1503a.g = true;
                } else {
                    this.f1503a.g = false;
                }
            }
            z = this.f1503a.g;
            if (z) {
                str2 = this.f1503a.b;
                if (str2 != null) {
                    str3 = this.f1503a.b;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.d != null) {
                            this.f1503a.d = this.c;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.f1503a.l;
                        if (cVar == null) {
                            cVar2 = this.f1503a.l;
                            arrayList = this.f1503a.f1477a;
                            i2 = this.f1503a.i;
                            str = this.f1503a.c;
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
            cVar = this.f1503a.l;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.f1503a.l;
            if (cVar3 != null) {
                if (this.b != null) {
                    i4 = this.b.e();
                    str4 = this.d == null ? this.b.g() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.f1503a.l;
                cVar4.a(i4, str4);
            }
        }
    }
}
