package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.data.t;
import com.baidu.tieba.data.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, u> {
    final /* synthetic */ a a;
    private an b = null;
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

    public String a() {
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public u doInBackground(Object... objArr) {
        String str;
        boolean z;
        this.b = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/picpage");
        an anVar = this.b;
        str = this.a.e;
        anVar.a("kw", str);
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
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.h = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(u uVar) {
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
        String a;
        String a2;
        HashMap hashMap;
        ArrayList arrayList2;
        HashMap hashMap2;
        ArrayList arrayList3;
        HashMap hashMap3;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        super.onPostExecute(uVar);
        this.a.h = null;
        if (uVar != null) {
            this.a.i = uVar.j();
            this.a.c = uVar.f();
            this.a.b = uVar.e();
            if (this.d == null) {
                arrayList3 = this.a.a;
                arrayList3.clear();
                hashMap3 = this.a.m;
                hashMap3.clear();
            }
            LinkedList<t> g = uVar.g();
            int size = g.size();
            if (size <= 0) {
                this.a.g = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.a.a(g.get(i5));
                    a2 = this.a.a(a);
                    hashMap = this.a.m;
                    if (!hashMap.containsKey(a2)) {
                        arrayList2 = this.a.a;
                        arrayList2.add(a);
                        hashMap2 = this.a.m;
                        hashMap2.put(a2, a);
                    }
                }
                t tVar = g.get(size - 1);
                this.a.f = tVar.c();
                i3 = this.a.i;
                if (i3 == tVar.h()) {
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
}
