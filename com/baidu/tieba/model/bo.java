package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ao> {
    final /* synthetic */ bm a;
    private int c;
    private com.baidu.tieba.a.f b = null;
    private String d = null;
    private com.baidu.tieba.data.ao e = null;

    public bo(bm bmVar, int i) {
        this.a = bmVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bmVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.data.ao aoVar;
        com.baidu.tieba.data.ao aoVar2;
        com.baidu.tieba.data.ao aoVar3;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.ao aoVar4;
        boolean z = false;
        super.b();
        this.a.A = System.nanoTime();
        aoVar = this.a.v;
        ArrayList<com.baidu.tieba.data.as> e = aoVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.h.c()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                aoVar3 = this.a.v;
                aoVar3.f().f(1);
                bnVar = this.a.z;
                if (bnVar != null) {
                    bnVar2 = this.a.z;
                    aoVar4 = this.a.v;
                    bnVar2.a(aoVar4);
                }
            }
        } else if (this.c == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.h.c()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                aoVar2 = this.a.v;
                aoVar2.f().e(1);
            }
        }
    }

    private void b(com.baidu.tieba.data.ao aoVar) {
        String str;
        int i;
        int i2;
        long j;
        Context context;
        Context context2;
        if (aoVar != null) {
            if (aoVar.d() == null || aoVar.d().j() == null) {
                str = null;
            } else {
                str = aoVar.d().j().getId();
            }
            com.baidu.tieba.data.bb d = aoVar.d();
            i = this.a.h;
            d.b(i);
            i2 = this.a.i;
            d.a(i2);
            j = this.a.j;
            d.a(j);
            for (int i3 = 0; i3 < aoVar.e().size(); i3++) {
                com.baidu.tieba.data.as asVar = aoVar.e().get(i3);
                for (int i4 = 0; i4 < asVar.a().size(); i4++) {
                    boolean equals = str.equals(asVar.a().get(i4).g().getId());
                    if (this.a.a == null) {
                        bm bmVar = this.a;
                        context2 = this.a.y;
                        bmVar.a = new com.baidu.tieba.util.i(context2);
                        this.a.a.d(true);
                    }
                    context = this.a.y;
                    asVar.a().get(i4).a(context, equals, this.a.a);
                }
            }
        }
    }

    private com.baidu.tieba.data.ao d() {
        String y;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        y = this.a.y();
        this.a.x();
        sVar = this.a.C;
        if (sVar == null || y == null) {
            tVar = null;
        } else {
            sVar2 = this.a.C;
            tVar = sVar2.b(y);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.a.y;
        aoVar.a((String) tVar.b, context);
        if (aoVar.a()) {
            return aoVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ao e() {
        String y;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        y = this.a.y();
        this.a.x();
        sVar = this.a.B;
        if (sVar == null || y == null) {
            tVar = null;
        } else {
            sVar2 = this.a.B;
            tVar = sVar2.b(y);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.a.y;
        aoVar.a((String) tVar.b, context);
        if (aoVar.a()) {
            if (aoVar.j() != null) {
                String j = aoVar.j();
                str = this.a.e;
                if (!j.equals(str)) {
                    return null;
                }
            }
            return aoVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ao a(Object... objArr) {
        com.baidu.tieba.data.ao aoVar;
        boolean z;
        com.baidu.tieba.data.ao d;
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
        com.baidu.tieba.data.ap apVar;
        Context context;
        com.baidu.tieba.data.ap apVar2;
        com.baidu.tieba.data.ap apVar3;
        long j2;
        com.baidu.tieba.data.ap apVar4;
        com.baidu.tieba.data.ap apVar5;
        try {
            aoVar = this.a.v;
            ArrayList<com.baidu.tieba.data.as> e = aoVar.e();
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
                b(this.e);
                c((Object[]) new Integer[]{0});
            }
            this.b = new com.baidu.tieba.a.f();
            com.baidu.tieba.a.f fVar = this.b;
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
            apVar = bm.x;
            this.d = fVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, apVar);
            com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao();
            String str4 = this.d;
            context = this.a.y;
            aoVar2.a(str4, context);
            if (!this.b.b()) {
                aoVar2 = null;
            }
            if (aoVar2 != null) {
                b(aoVar2);
                return aoVar2;
            } else if (this.b != null) {
                this.a.setErrorString(this.b.e());
                this.a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    apVar3 = bm.x;
                    apVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.a.A;
                    apVar4 = bm.x;
                    apVar4.a((int) ((nanoTime - j2) / 1000000));
                    apVar5 = bm.x;
                    apVar5.b(this.b.d());
                    return aoVar2;
                }
                apVar2 = bm.x;
                apVar2.c(1);
                return aoVar2;
            } else {
                return aoVar2;
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.g.e.b("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        bn bnVar;
        bn bnVar2;
        String str;
        bnVar = this.a.z;
        if (bnVar != null && this.e != null) {
            bnVar2 = this.a.z;
            int i = this.c;
            com.baidu.tieba.data.ao aoVar = this.e;
            str = this.a.mErrorString;
            bnVar2.a(true, 0, i, 0, aoVar, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ao aoVar) {
        int i;
        com.baidu.tieba.data.ao aoVar2;
        int size;
        com.baidu.tieba.data.ao aoVar3;
        com.baidu.tieba.data.ao aoVar4;
        String y;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String y2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.ao aoVar5;
        String str;
        bn bnVar3;
        bn bnVar4;
        String str2;
        this.a.w = null;
        if (aoVar == null) {
            bnVar3 = this.a.z;
            if (bnVar3 != null) {
                bnVar4 = this.a.z;
                int errorCode = this.a.getErrorCode();
                int i2 = this.c;
                str2 = this.a.mErrorString;
                bnVar4.a(false, errorCode, i2, 0, null, str2);
            }
        } else {
            this.a.t = false;
            this.a.e(aoVar.f().d());
            this.a.n = aoVar.f().a();
            bm bmVar = this.a;
            i = this.a.n;
            bmVar.n = i < 1 ? 1 : this.a.n;
            aoVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.as> e = aoVar2.e();
            switch (this.c) {
                case 1:
                    aoVar4 = this.a.v;
                    aoVar4.a(aoVar.f(), 1);
                    e.addAll(aoVar.e());
                    size = 0;
                    break;
                case 2:
                    size = aoVar.e().size() + 1;
                    aoVar3 = this.a.v;
                    aoVar3.a(aoVar.f(), 2);
                    e.addAll(0, aoVar.e());
                    break;
                case 3:
                    z = this.a.g;
                    if (!z) {
                        aoVar.f().c(aoVar.f().a());
                    }
                    c(aoVar);
                    if (this.d != null) {
                        y2 = this.a.y();
                        if (y2 != null) {
                            this.a.x();
                            z2 = this.a.r;
                            if (z2) {
                                sVar3 = this.a.B;
                                sVar3.b(y2, this.d, 604800000L);
                            } else {
                                sVar2 = this.a.C;
                                sVar2.b(y2, this.d, 86400000L);
                            }
                        }
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 4:
                    c(aoVar);
                    if (this.d != null) {
                        y = this.a.y();
                        if (y != null) {
                            this.a.x();
                            sVar = this.a.B;
                            sVar.b(y, this.d, 2592000000L);
                        }
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 5:
                    c(aoVar);
                    size = 0;
                    break;
                case 6:
                    c(aoVar);
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            bnVar = this.a.z;
            if (bnVar != null) {
                bnVar2 = this.a.z;
                int errorCode2 = this.a.getErrorCode();
                int i3 = this.c;
                aoVar5 = this.a.v;
                str = this.a.mErrorString;
                bnVar2.a(true, errorCode2, i3, size, aoVar5, str);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.ao aoVar) {
        this.a.v = aoVar;
        this.a.d(aoVar.f().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bn bnVar;
        bn bnVar2;
        super.cancel(true);
        this.a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bnVar = this.a.z;
        if (bnVar != null) {
            bnVar2 = this.a.z;
            bnVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null);
        }
        this.a.w = null;
        this.d = null;
    }
}
