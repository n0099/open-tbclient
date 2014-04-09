package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.PraiseData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bh extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ae> {
    final /* synthetic */ bf a;
    private int c;
    private b b = null;
    private String d = null;
    private com.baidu.tieba.data.ae e = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.ae a(Object... objArr) {
        return f();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fd, code lost:
        r0 = r14.a.B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0141, code lost:
        r0 = r14.a.B();
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void a(com.baidu.tieba.data.ae aeVar) {
        int i;
        com.baidu.tieba.data.ae aeVar2;
        int size;
        com.baidu.tieba.data.ae aeVar3;
        com.baidu.tieba.data.ae aeVar4;
        String B;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String B2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        com.baidu.tieba.data.ae aeVar5;
        bg bgVar;
        bg bgVar2;
        com.baidu.tieba.data.ae aeVar6;
        String str;
        com.baidu.tieba.data.ae aeVar7;
        com.baidu.tieba.data.ae aeVar8;
        PraiseData praiseData;
        com.baidu.tieba.data.ae aeVar9;
        PraiseData praiseData2;
        com.baidu.tieba.data.ae aeVar10;
        com.baidu.tieba.data.ae aeVar11;
        PraiseData praiseData3;
        bg bgVar3;
        bg bgVar4;
        String str2;
        com.baidu.tieba.data.ae aeVar12 = aeVar;
        this.a.w = null;
        if (aeVar12 != null) {
            this.a.t = false;
            this.a.e(aeVar12.f().d());
            this.a.n = aeVar12.f().a();
            bf bfVar = this.a;
            i = this.a.n;
            bfVar.n = i <= 0 ? 1 : this.a.n;
            aeVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.ai> e = aeVar2.e();
            switch (this.c) {
                case 1:
                    aeVar4 = this.a.v;
                    aeVar4.a(aeVar12.f(), 1);
                    e.addAll(aeVar12.e());
                    size = 0;
                    break;
                case 2:
                    size = aeVar12.e().size() + 1;
                    aeVar3 = this.a.v;
                    aeVar3.a(aeVar12.f(), 2);
                    e.addAll(0, aeVar12.e());
                    break;
                case 3:
                    z = this.a.g;
                    if (!z) {
                        aeVar12.f().c(aeVar12.f().a());
                    }
                    b(aeVar12);
                    if (this.d != null && B2 != null) {
                        this.a.A();
                        z2 = this.a.r;
                        if (z2) {
                            sVar3 = this.a.B;
                            sVar3.b(B2, this.d, 604800000L);
                            size = 0;
                            break;
                        } else {
                            sVar2 = this.a.C;
                            sVar2.b(B2, this.d, 86400000L);
                            size = 0;
                            break;
                        }
                    }
                    size = 0;
                    break;
                case 4:
                    b(aeVar12);
                    if (this.d != null && B != null) {
                        this.a.A();
                        sVar = this.a.B;
                        sVar.b(B, this.d, 2592000000L);
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 5:
                    b(aeVar12);
                    size = 0;
                    break;
                case 6:
                    b(aeVar12);
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            aeVar5 = this.a.v;
            if (aeVar5 != null) {
                aeVar7 = this.a.v;
                if (aeVar7.d() != null) {
                    aeVar8 = this.a.v;
                    PraiseData k = aeVar8.d().k();
                    praiseData = this.a.H;
                    if (praiseData == null || k.isPriaseDataValid()) {
                        bf bfVar2 = this.a;
                        aeVar9 = this.a.v;
                        bfVar2.H = aeVar9.d().k();
                        praiseData2 = this.a.H;
                        aeVar10 = this.a.v;
                        praiseData2.setPostId(aeVar10.d().C());
                    } else {
                        aeVar11 = this.a.v;
                        com.baidu.tbadk.core.data.o d = aeVar11.d();
                        praiseData3 = this.a.H;
                        d.a(praiseData3);
                    }
                }
            }
            bgVar = this.a.z;
            if (bgVar != null) {
                bgVar2 = this.a.z;
                int errorCode = this.a.getErrorCode();
                int i2 = this.c;
                aeVar6 = this.a.v;
                str = this.a.mErrorString;
                bgVar2.a(true, errorCode, i2, size, aeVar6, str, 1);
            }
        } else {
            bgVar3 = this.a.z;
            if (bgVar3 != null) {
                bgVar4 = this.a.z;
                int errorCode2 = this.a.getErrorCode();
                int i3 = this.c;
                str2 = this.a.mErrorString;
                bgVar4.a(false, errorCode2, i3, 0, null, str2, 1);
            }
        }
        this.d = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        bg bgVar;
        bg bgVar2;
        String str;
        bgVar = this.a.z;
        if (bgVar == null || this.e == null) {
            return;
        }
        bgVar2 = this.a.z;
        int i = this.c;
        com.baidu.tieba.data.ae aeVar = this.e;
        str = this.a.mErrorString;
        bgVar2.a(true, 0, i, 0, aeVar, str, 0);
    }

    public bh(bf bfVar, int i) {
        this.a = bfVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bfVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        com.baidu.tieba.data.ae aeVar;
        com.baidu.tieba.data.ae aeVar2;
        com.baidu.tieba.data.ae aeVar3;
        bg bgVar;
        bg bgVar2;
        com.baidu.tieba.data.ae aeVar4;
        boolean z = false;
        super.c();
        this.a.A = System.nanoTime();
        aeVar = this.a.v;
        ArrayList<com.baidu.tieba.data.ai> e = aeVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.d.f()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                aeVar3 = this.a.v;
                aeVar3.f().f(1);
                bgVar = this.a.z;
                if (bgVar != null) {
                    bgVar2 = this.a.z;
                    aeVar4 = this.a.v;
                    bgVar2.a(aeVar4);
                }
            }
        } else if (this.c == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.d.f()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                aeVar2 = this.a.v;
                aeVar2.f().e(1);
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(com.baidu.tieba.data.ae aeVar) {
        String str;
        int i;
        int i2;
        long j;
        Context context;
        Context context2;
        if (aeVar != null) {
            if (aeVar.d() == null || aeVar.d().t() == null) {
                str = null;
            } else {
                str = aeVar.d().t().getUserId();
            }
            com.baidu.tbadk.core.data.o d = aeVar.d();
            i = this.a.h;
            d.d(i);
            i2 = this.a.i;
            d.c(i2);
            j = this.a.j;
            d.a(j);
            for (int i3 = 0; i3 < aeVar.e().size(); i3++) {
                com.baidu.tieba.data.ai aiVar = aeVar.e().get(i3);
                for (int i4 = 0; i4 < aiVar.a().size(); i4++) {
                    boolean equals = str.equals(aiVar.a().get(i4).g().getUserId());
                    if (this.a.a == null) {
                        bf bfVar = this.a;
                        context2 = this.a.y;
                        bfVar.a = new com.baidu.tbadk.editortool.ab(context2);
                        this.a.a.a(true);
                    }
                    context = this.a.y;
                    aiVar.a().get(i4).a(context, equals, this.a.a);
                }
            }
        }
    }

    private com.baidu.tieba.data.ae a() {
        String B;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        B = this.a.B();
        this.a.A();
        sVar = this.a.C;
        if (sVar == null || B == null) {
            tVar = null;
        } else {
            sVar2 = this.a.C;
            tVar = sVar2.b(B);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
        context = this.a.y;
        aeVar.a((String) tVar.b, context);
        if (aeVar.a()) {
            return aeVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ae e() {
        String B;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        B = this.a.B();
        this.a.A();
        sVar = this.a.B;
        if (sVar == null || B == null) {
            tVar = null;
        } else {
            sVar2 = this.a.B;
            tVar = sVar2.b(B);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
        context = this.a.y;
        aeVar.a((String) tVar.b, context);
        if (aeVar.a()) {
            if (aeVar.j() != null) {
                String j = aeVar.j();
                str = this.a.e;
                if (!j.equals(str)) {
                    return null;
                }
            }
            return aeVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ae f() {
        bj bjVar;
        com.baidu.tieba.data.ae aeVar;
        boolean z;
        com.baidu.tieba.data.ae a;
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
        com.baidu.tieba.data.af afVar;
        Context context;
        com.baidu.tieba.data.af afVar2;
        com.baidu.tieba.data.af afVar3;
        long j2;
        com.baidu.tieba.data.af afVar4;
        com.baidu.tieba.data.af afVar5;
        bj bjVar2;
        bj bjVar3;
        bjVar = bk.a;
        com.baidu.tieba.data.ae b = bjVar.b();
        if (b == null) {
            try {
                aeVar = this.a.v;
                ArrayList<com.baidu.tieba.data.ai> e = aeVar.e();
                switch (this.c) {
                    case 1:
                        this.a.e = e.get(e.size() - 1).d();
                        a = null;
                        break;
                    case 2:
                        this.a.e = e.get(0).d();
                        a = null;
                        break;
                    case 3:
                        z = this.a.r;
                        if (z) {
                            a = e();
                            break;
                        } else {
                            a = a();
                            break;
                        }
                    case 4:
                        a = e();
                        break;
                    default:
                        a = null;
                        break;
                }
                if (a != null) {
                    this.e = a;
                    a2(this.e);
                    c((Object[]) new Integer[]{0});
                }
                this.a.D = System.currentTimeMillis();
                this.b = new b();
                b bVar = this.b;
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
                afVar = bf.x;
                this.d = bVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, afVar);
                this.a.E = this.b.g();
                this.a.F = this.b.h();
                this.a.G = System.currentTimeMillis();
                com.baidu.tieba.data.ae aeVar2 = new com.baidu.tieba.data.ae();
                String str4 = this.d;
                context = this.a.y;
                aeVar2.a(str4, context);
                if (!this.b.b()) {
                    aeVar2 = null;
                }
                if (aeVar2 != null) {
                    a2(aeVar2);
                    return aeVar2;
                } else if (this.b != null) {
                    this.a.setErrorString(this.b.e());
                    this.a.setErrorCode(this.b.f());
                    if (this.b.c()) {
                        afVar3 = bf.x;
                        afVar3.a();
                        long nanoTime = System.nanoTime();
                        j2 = this.a.A;
                        afVar4 = bf.x;
                        afVar4.a((int) ((nanoTime - j2) / 1000000));
                        afVar5 = bf.x;
                        afVar5.b(this.b.d());
                        return aeVar2;
                    }
                    afVar2 = bf.x;
                    afVar2.c(1);
                    return aeVar2;
                } else {
                    return aeVar2;
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
                return null;
            }
        }
        bf bfVar = this.a;
        bjVar2 = bk.a;
        bfVar.g = bjVar2.d();
        bf bfVar2 = this.a;
        bjVar3 = bk.a;
        bfVar2.f = bjVar3.e();
        return b;
    }

    private void b(com.baidu.tieba.data.ae aeVar) {
        this.a.v = aeVar;
        this.a.d(aeVar.f().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        bg bgVar;
        bg bgVar2;
        super.cancel(true);
        this.a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bgVar = this.a.z;
        if (bgVar != null) {
            bgVar2 = this.a.z;
            bgVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null, 2);
        }
        this.a.w = null;
        this.d = null;
    }
}
