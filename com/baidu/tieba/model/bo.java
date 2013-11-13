package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ao> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1916a;
    private int c;
    private com.baidu.tieba.a.h b = null;
    private String d = null;
    private com.baidu.tieba.data.ao e = null;

    public bo(bm bmVar, int i) {
        this.f1916a = bmVar;
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
        this.f1916a.z = System.nanoTime();
        aoVar = this.f1916a.u;
        ArrayList<com.baidu.tieba.data.as> e = aoVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.h.c()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                aoVar3 = this.f1916a.u;
                aoVar3.f().f(1);
                bnVar = this.f1916a.y;
                if (bnVar != null) {
                    bnVar2 = this.f1916a.y;
                    aoVar4 = this.f1916a.u;
                    bnVar2.a(aoVar4);
                }
            }
        } else if (this.c == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.h.c()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                aoVar2 = this.f1916a.u;
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
        if (aoVar != null) {
            if (aoVar.d() == null || aoVar.d().j() == null) {
                str = null;
            } else {
                str = aoVar.d().j().getId();
            }
            com.baidu.tieba.data.ba d = aoVar.d();
            i = this.f1916a.g;
            d.b(i);
            i2 = this.f1916a.h;
            d.a(i2);
            j = this.f1916a.i;
            d.a(j);
            for (int i3 = 0; i3 < aoVar.e().size(); i3++) {
                com.baidu.tieba.data.as asVar = aoVar.e().get(i3);
                for (int i4 = 0; i4 < asVar.a().size(); i4++) {
                    boolean equals = str.equals(asVar.a().get(i4).g().getId());
                    context = this.f1916a.x;
                    asVar.a().get(i4).a(context, equals);
                }
            }
        }
    }

    private com.baidu.tieba.data.ao d() {
        String x;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        x = this.f1916a.x();
        sVar = this.f1916a.B;
        if (sVar == null || x == null) {
            tVar = null;
        } else {
            sVar2 = this.f1916a.B;
            tVar = sVar2.b(x);
        }
        if (tVar == null || tVar.f437a == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.f1916a.x;
        aoVar.a((String) tVar.f437a, context);
        if (aoVar.a()) {
            return aoVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ao e() {
        String x;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        x = this.f1916a.x();
        sVar = this.f1916a.A;
        if (sVar == null || x == null) {
            tVar = null;
        } else {
            sVar2 = this.f1916a.A;
            tVar = sVar2.b(x);
        }
        if (tVar == null || tVar.f437a == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.f1916a.x;
        aoVar.a((String) tVar.f437a, context);
        if (aoVar.a()) {
            if (aoVar.j() != null) {
                String j = aoVar.j();
                str = this.f1916a.d;
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
            aoVar = this.f1916a.u;
            ArrayList<com.baidu.tieba.data.as> e = aoVar.e();
            switch (this.c) {
                case 1:
                    this.f1916a.d = e.get(e.size() - 1).d();
                    d = null;
                    break;
                case 2:
                    this.f1916a.d = e.get(0).d();
                    d = null;
                    break;
                case 3:
                    z = this.f1916a.q;
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
            this.b = new com.baidu.tieba.a.h();
            com.baidu.tieba.a.h hVar = this.b;
            str = this.f1916a.c;
            str2 = this.f1916a.b;
            str3 = this.f1916a.d;
            i = this.f1916a.l;
            i2 = this.f1916a.k;
            z2 = this.f1916a.f;
            z3 = this.f1916a.e;
            int i5 = this.c;
            i3 = this.f1916a.j;
            i4 = this.f1916a.m;
            z4 = this.f1916a.s;
            j = this.f1916a.r;
            z5 = this.f1916a.q;
            apVar = bm.w;
            this.d = hVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, apVar);
            com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao();
            String str4 = this.d;
            context = this.f1916a.x;
            aoVar2.a(str4, context);
            if (!this.b.b()) {
                aoVar2 = null;
            }
            if (aoVar2 != null) {
                b(aoVar2);
                return aoVar2;
            } else if (this.b != null) {
                this.f1916a.setErrorString(this.b.e());
                this.f1916a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    apVar3 = bm.w;
                    apVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.f1916a.z;
                    apVar4 = bm.w;
                    apVar4.a((int) ((nanoTime - j2) / 1000000));
                    apVar5 = bm.w;
                    apVar5.b(this.b.d());
                    return aoVar2;
                }
                apVar2 = bm.w;
                apVar2.c(1);
                return aoVar2;
            } else {
                return aoVar2;
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.bg.b("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
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
        bnVar = this.f1916a.y;
        if (bnVar != null && this.e != null) {
            bnVar2 = this.f1916a.y;
            int i = this.c;
            com.baidu.tieba.data.ao aoVar = this.e;
            str = this.f1916a.mErrorString;
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
        String x;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String x2;
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
        this.f1916a.v = null;
        if (aoVar == null) {
            bnVar3 = this.f1916a.y;
            if (bnVar3 != null) {
                bnVar4 = this.f1916a.y;
                int errorCode = this.f1916a.getErrorCode();
                int i2 = this.c;
                str2 = this.f1916a.mErrorString;
                bnVar4.a(false, errorCode, i2, 0, null, str2);
            }
        } else {
            this.f1916a.s = false;
            this.f1916a.e(aoVar.f().d());
            this.f1916a.m = aoVar.f().a();
            bm bmVar = this.f1916a;
            i = this.f1916a.m;
            bmVar.m = i < 1 ? 1 : this.f1916a.m;
            aoVar2 = this.f1916a.u;
            ArrayList<com.baidu.tieba.data.as> e = aoVar2.e();
            switch (this.c) {
                case 1:
                    aoVar4 = this.f1916a.u;
                    aoVar4.a(aoVar.f(), 1);
                    e.addAll(aoVar.e());
                    size = 0;
                    break;
                case 2:
                    size = aoVar.e().size() + 1;
                    aoVar3 = this.f1916a.u;
                    aoVar3.a(aoVar.f(), 2);
                    e.addAll(0, aoVar.e());
                    break;
                case 3:
                    z = this.f1916a.f;
                    if (!z) {
                        aoVar.f().c(aoVar.f().a());
                    }
                    c(aoVar);
                    if (this.d != null) {
                        x2 = this.f1916a.x();
                        if (x2 != null) {
                            z2 = this.f1916a.q;
                            if (z2) {
                                sVar3 = this.f1916a.A;
                                sVar3.b(x2, this.d, 604800000L);
                            } else {
                                sVar2 = this.f1916a.B;
                                sVar2.b(x2, this.d, Util.MILLSECONDS_OF_DAY);
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
                        x = this.f1916a.x();
                        if (x != null) {
                            sVar = this.f1916a.A;
                            sVar.b(x, this.d, 2592000000L);
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
            bnVar = this.f1916a.y;
            if (bnVar != null) {
                bnVar2 = this.f1916a.y;
                int errorCode2 = this.f1916a.getErrorCode();
                int i3 = this.c;
                aoVar5 = this.f1916a.u;
                str = this.f1916a.mErrorString;
                bnVar2.a(true, errorCode2, i3, size, aoVar5, str);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.ao aoVar) {
        this.f1916a.u = aoVar;
        this.f1916a.d(aoVar.f().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bn bnVar;
        bn bnVar2;
        super.cancel(true);
        this.f1916a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bnVar = this.f1916a.y;
        if (bnVar != null) {
            bnVar2 = this.f1916a.y;
            bnVar2.a(false, this.f1916a.getErrorCode(), this.c, 0, null, null);
        }
        this.f1916a.v = null;
        this.d = null;
    }
}
