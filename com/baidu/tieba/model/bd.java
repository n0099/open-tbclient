package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.cs;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bd extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.am> {
    final /* synthetic */ bb a;
    private int c;
    private com.baidu.tieba.b.f b = null;
    private String d = null;
    private com.baidu.tieba.data.am e = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.am a(Object... objArr) {
        return f();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b8, code lost:
        r0 = r14.a.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fa, code lost:
        r0 = r14.a.C();
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void a(com.baidu.tieba.data.am amVar) {
        int i;
        com.baidu.tieba.data.am amVar2;
        int size;
        com.baidu.tieba.data.am amVar3;
        com.baidu.tieba.data.am amVar4;
        String C;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String C2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        bc bcVar;
        bc bcVar2;
        com.baidu.tieba.data.am amVar5;
        String str;
        bc bcVar3;
        bc bcVar4;
        String str2;
        com.baidu.tieba.data.am amVar6 = amVar;
        this.a.w = null;
        if (amVar6 != null) {
            this.a.t = false;
            this.a.e(amVar6.f().d());
            this.a.n = amVar6.f().a();
            bb bbVar = this.a;
            i = this.a.n;
            bbVar.n = i <= 0 ? 1 : this.a.n;
            amVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.aq> e = amVar2.e();
            switch (this.c) {
                case 1:
                    amVar4 = this.a.v;
                    amVar4.a(amVar6.f(), 1);
                    e.addAll(amVar6.e());
                    size = 0;
                    break;
                case 2:
                    size = amVar6.e().size() + 1;
                    amVar3 = this.a.v;
                    amVar3.a(amVar6.f(), 2);
                    e.addAll(0, amVar6.e());
                    break;
                case 3:
                    z = this.a.g;
                    if (!z) {
                        amVar6.f().c(amVar6.f().a());
                    }
                    b(amVar6);
                    if (this.d != null && C2 != null) {
                        this.a.B();
                        z2 = this.a.r;
                        if (z2) {
                            sVar3 = this.a.B;
                            sVar3.b(C2, this.d, 604800000L);
                            size = 0;
                            break;
                        } else {
                            sVar2 = this.a.C;
                            sVar2.b(C2, this.d, 86400000L);
                            size = 0;
                            break;
                        }
                    }
                    size = 0;
                    break;
                case 4:
                    b(amVar6);
                    if (this.d != null && C != null) {
                        this.a.B();
                        sVar = this.a.B;
                        sVar.b(C, this.d, 2592000000L);
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 5:
                    b(amVar6);
                    size = 0;
                    break;
                case 6:
                    b(amVar6);
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            bcVar = this.a.z;
            if (bcVar != null) {
                bcVar2 = this.a.z;
                int errorCode = this.a.getErrorCode();
                int i2 = this.c;
                amVar5 = this.a.v;
                str = this.a.mErrorString;
                bcVar2.a(true, errorCode, i2, size, amVar5, str, 1);
            }
        } else {
            bcVar3 = this.a.z;
            if (bcVar3 != null) {
                bcVar4 = this.a.z;
                int errorCode2 = this.a.getErrorCode();
                int i3 = this.c;
                str2 = this.a.mErrorString;
                bcVar4.a(false, errorCode2, i3, 0, null, str2, 1);
            }
        }
        this.d = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        bc bcVar;
        bc bcVar2;
        String str;
        bcVar = this.a.z;
        if (bcVar == null || this.e == null) {
            return;
        }
        bcVar2 = this.a.z;
        int i = this.c;
        com.baidu.tieba.data.am amVar = this.e;
        str = this.a.mErrorString;
        bcVar2.a(true, 0, i, 0, amVar, str, 0);
    }

    public bd(bb bbVar, int i) {
        this.a = bbVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bbVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        com.baidu.tieba.data.am amVar;
        com.baidu.tieba.data.am amVar2;
        com.baidu.tieba.data.am amVar3;
        bc bcVar;
        bc bcVar2;
        com.baidu.tieba.data.am amVar4;
        boolean z = false;
        super.b();
        this.a.A = System.nanoTime();
        amVar = this.a.v;
        ArrayList<com.baidu.tieba.data.aq> e = amVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.i.n()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                amVar3 = this.a.v;
                amVar3.f().f(1);
                bcVar = this.a.z;
                if (bcVar != null) {
                    bcVar2 = this.a.z;
                    amVar4 = this.a.v;
                    bcVar2.a(amVar4);
                }
            }
        } else if (this.c == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.i.n()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                amVar2 = this.a.v;
                amVar2.f().e(1);
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(com.baidu.tieba.data.am amVar) {
        String str;
        int i;
        int i2;
        long j;
        Context context;
        Context context2;
        if (amVar != null) {
            if (amVar.d() == null || amVar.d().i() == null) {
                str = null;
            } else {
                str = amVar.d().i().getUserId();
            }
            com.baidu.tieba.data.az d = amVar.d();
            i = this.a.h;
            d.b(i);
            i2 = this.a.i;
            d.a(i2);
            j = this.a.j;
            d.a(j);
            for (int i3 = 0; i3 < amVar.e().size(); i3++) {
                com.baidu.tieba.data.aq aqVar = amVar.e().get(i3);
                for (int i4 = 0; i4 < aqVar.a().size(); i4++) {
                    boolean equals = str.equals(aqVar.a().get(i4).g().getUserId());
                    if (this.a.a == null) {
                        bb bbVar = this.a;
                        context2 = this.a.y;
                        bbVar.a = new com.baidu.tieba.util.i(context2);
                        this.a.a.a(true);
                    }
                    context = this.a.y;
                    aqVar.a().get(i4).a(context, equals, this.a.a);
                }
            }
        }
    }

    private com.baidu.tieba.data.am d() {
        String C;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        C = this.a.C();
        this.a.B();
        sVar = this.a.C;
        if (sVar == null || C == null) {
            tVar = null;
        } else {
            sVar2 = this.a.C;
            tVar = sVar2.b(C);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am();
        context = this.a.y;
        amVar.a((String) tVar.b, context);
        if (amVar.a()) {
            return amVar;
        }
        return null;
    }

    private com.baidu.tieba.data.am e() {
        String C;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        C = this.a.C();
        this.a.B();
        sVar = this.a.B;
        if (sVar == null || C == null) {
            tVar = null;
        } else {
            sVar2 = this.a.B;
            tVar = sVar2.b(C);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am();
        context = this.a.y;
        amVar.a((String) tVar.b, context);
        if (amVar.a()) {
            if (amVar.j() != null) {
                String j = amVar.j();
                str = this.a.e;
                if (!j.equals(str)) {
                    return null;
                }
            }
            return amVar;
        }
        return null;
    }

    private com.baidu.tieba.data.am f() {
        com.baidu.tieba.data.am amVar;
        boolean z;
        com.baidu.tieba.data.am d;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        long j;
        boolean z5;
        com.baidu.tieba.data.an anVar;
        Context context;
        com.baidu.tieba.data.an anVar2;
        com.baidu.tieba.data.an anVar3;
        long j2;
        com.baidu.tieba.data.an anVar4;
        com.baidu.tieba.data.an anVar5;
        com.baidu.tieba.data.am b = cs.a().b();
        if (b != null) {
            this.a.g = cs.a().d();
            this.a.f = cs.a().e();
            return b;
        }
        try {
            amVar = this.a.v;
            ArrayList<com.baidu.tieba.data.aq> e = amVar.e();
            switch (this.c) {
                case 1:
                    this.a.e = e.get(e.size() - 1).d();
                    d = null;
                    break;
                case 2:
                    this.a.e = e.get(0).d();
                    d = null;
                    break;
                case 3:
                    z = this.a.r;
                    if (z) {
                        d = e();
                        break;
                    } else {
                        d = d();
                        break;
                    }
                case 4:
                    d = e();
                    break;
                default:
                    d = null;
                    break;
            }
            if (d != null) {
                this.e = d;
                a2(this.e);
                c((Object[]) new Integer[]{0});
            }
            this.a.D = System.currentTimeMillis();
            this.b = new com.baidu.tieba.b.f();
            com.baidu.tieba.b.f fVar = this.b;
            str = this.a.d;
            str2 = this.a.c;
            str3 = this.a.e;
            i = this.a.m;
            i2 = this.a.l;
            z2 = this.a.g;
            z3 = this.a.f;
            int i5 = this.c;
            i3 = this.a.k;
            i4 = this.a.n;
            z4 = this.a.t;
            j = this.a.s;
            z5 = this.a.r;
            anVar = bb.x;
            this.d = fVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, anVar);
            this.a.E = this.b.g();
            this.a.F = this.b.h();
            this.a.G = System.currentTimeMillis();
            com.baidu.tieba.data.am amVar2 = new com.baidu.tieba.data.am();
            String str4 = this.d;
            context = this.a.y;
            amVar2.a(str4, context);
            if (!this.b.b()) {
                amVar2 = null;
            }
            if (amVar2 != null) {
                a2(amVar2);
                return amVar2;
            } else if (this.b != null) {
                this.a.setErrorString(this.b.e());
                this.a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    anVar3 = bb.x;
                    anVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.a.A;
                    anVar4 = bb.x;
                    anVar4.a((int) ((nanoTime - j2) / 1000000));
                    anVar5 = bb.x;
                    anVar5.b(this.b.d());
                    return amVar2;
                }
                anVar2 = bb.x;
                anVar2.c(1);
                return amVar2;
            } else {
                return amVar2;
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
            return null;
        }
    }

    private void b(com.baidu.tieba.data.am amVar) {
        this.a.v = amVar;
        this.a.d(amVar.f().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        bc bcVar;
        bc bcVar2;
        super.cancel(true);
        this.a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bcVar = this.a.z;
        if (bcVar != null) {
            bcVar2 = this.a.z;
            bcVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null, 2);
        }
        this.a.w = null;
        this.d = null;
    }
}
