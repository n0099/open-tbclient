package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.an> {
    final /* synthetic */ bm a;
    private int c;
    private com.baidu.tieba.a.f b = null;
    private String d = null;
    private com.baidu.tieba.data.an e = null;

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
        com.baidu.tieba.data.an anVar;
        com.baidu.tieba.data.an anVar2;
        com.baidu.tieba.data.an anVar3;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.an anVar4;
        boolean z = false;
        super.b();
        this.a.z = System.nanoTime();
        anVar = this.a.u;
        ArrayList<com.baidu.tieba.data.ar> e = anVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.h.c()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                anVar3 = this.a.u;
                anVar3.f().f(1);
                bnVar = this.a.y;
                if (bnVar != null) {
                    bnVar2 = this.a.y;
                    anVar4 = this.a.u;
                    bnVar2.a(anVar4);
                }
            }
        } else if (this.c == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.h.c()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                anVar2 = this.a.u;
                anVar2.f().e(1);
            }
        }
    }

    private void b(com.baidu.tieba.data.an anVar) {
        String str;
        int i;
        int i2;
        long j;
        Context context;
        if (anVar != null) {
            if (anVar.d() == null || anVar.d().j() == null) {
                str = null;
            } else {
                str = anVar.d().j().getId();
            }
            com.baidu.tieba.data.az d = anVar.d();
            i = this.a.g;
            d.b(i);
            i2 = this.a.h;
            d.a(i2);
            j = this.a.i;
            d.a(j);
            for (int i3 = 0; i3 < anVar.e().size(); i3++) {
                com.baidu.tieba.data.ar arVar = anVar.e().get(i3);
                for (int i4 = 0; i4 < arVar.a().size(); i4++) {
                    boolean equals = str.equals(arVar.a().get(i4).g().getId());
                    context = this.a.x;
                    arVar.a().get(i4).a(context, equals);
                }
            }
        }
    }

    private com.baidu.tieba.data.an d() {
        String x;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        x = this.a.x();
        sVar = this.a.B;
        if (sVar == null || x == null) {
            tVar = null;
        } else {
            sVar2 = this.a.B;
            tVar = sVar2.b(x);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.an anVar = new com.baidu.tieba.data.an();
        context = this.a.x;
        anVar.a((String) tVar.b, context);
        if (anVar.a()) {
            return anVar;
        }
        return null;
    }

    private com.baidu.tieba.data.an e() {
        String x;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        x = this.a.x();
        sVar = this.a.A;
        if (sVar == null || x == null) {
            tVar = null;
        } else {
            sVar2 = this.a.A;
            tVar = sVar2.b(x);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.an anVar = new com.baidu.tieba.data.an();
        context = this.a.x;
        anVar.a((String) tVar.b, context);
        if (anVar.a()) {
            if (anVar.j() != null) {
                String j = anVar.j();
                str = this.a.d;
                if (!j.equals(str)) {
                    return null;
                }
            }
            return anVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.an a(Object... objArr) {
        com.baidu.tieba.data.an anVar;
        boolean z;
        com.baidu.tieba.data.an d;
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
        com.baidu.tieba.data.ao aoVar;
        Context context;
        com.baidu.tieba.data.ao aoVar2;
        com.baidu.tieba.data.ao aoVar3;
        long j2;
        com.baidu.tieba.data.ao aoVar4;
        com.baidu.tieba.data.ao aoVar5;
        try {
            anVar = this.a.u;
            ArrayList<com.baidu.tieba.data.ar> e = anVar.e();
            switch (this.c) {
                case 1:
                    this.a.d = e.get(e.size() - 1).d();
                    d = null;
                    break;
                case 2:
                    this.a.d = e.get(0).d();
                    d = null;
                    break;
                case 3:
                    z = this.a.q;
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
            str = this.a.c;
            str2 = this.a.b;
            str3 = this.a.d;
            i = this.a.l;
            i2 = this.a.k;
            z2 = this.a.f;
            z3 = this.a.e;
            int i5 = this.c;
            i3 = this.a.j;
            i4 = this.a.m;
            z4 = this.a.s;
            j = this.a.r;
            z5 = this.a.q;
            aoVar = bm.w;
            this.d = fVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, aoVar);
            com.baidu.tieba.data.an anVar2 = new com.baidu.tieba.data.an();
            String str4 = this.d;
            context = this.a.x;
            anVar2.a(str4, context);
            if (!this.b.b()) {
                anVar2 = null;
            }
            if (anVar2 != null) {
                b(anVar2);
                return anVar2;
            } else if (this.b != null) {
                this.a.setErrorString(this.b.e());
                this.a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    aoVar3 = bm.w;
                    aoVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.a.z;
                    aoVar4 = bm.w;
                    aoVar4.a((int) ((nanoTime - j2) / 1000000));
                    aoVar5 = bm.w;
                    aoVar5.b(this.b.d());
                    return anVar2;
                }
                aoVar2 = bm.w;
                aoVar2.c(1);
                return anVar2;
            } else {
                return anVar2;
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.be.b("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
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
        bnVar = this.a.y;
        if (bnVar != null && this.e != null) {
            bnVar2 = this.a.y;
            int i = this.c;
            com.baidu.tieba.data.an anVar = this.e;
            str = this.a.mErrorString;
            bnVar2.a(true, 0, i, 0, anVar, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.an anVar) {
        int i;
        com.baidu.tieba.data.an anVar2;
        int size;
        com.baidu.tieba.data.an anVar3;
        com.baidu.tieba.data.an anVar4;
        String x;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String x2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.an anVar5;
        String str;
        bn bnVar3;
        bn bnVar4;
        String str2;
        this.a.v = null;
        if (anVar == null) {
            bnVar3 = this.a.y;
            if (bnVar3 != null) {
                bnVar4 = this.a.y;
                int errorCode = this.a.getErrorCode();
                int i2 = this.c;
                str2 = this.a.mErrorString;
                bnVar4.a(false, errorCode, i2, 0, null, str2);
            }
        } else {
            this.a.s = false;
            this.a.e(anVar.f().d());
            this.a.m = anVar.f().a();
            bm bmVar = this.a;
            i = this.a.m;
            bmVar.m = i < 1 ? 1 : this.a.m;
            anVar2 = this.a.u;
            ArrayList<com.baidu.tieba.data.ar> e = anVar2.e();
            switch (this.c) {
                case 1:
                    anVar4 = this.a.u;
                    anVar4.a(anVar.f(), 1);
                    e.addAll(anVar.e());
                    size = 0;
                    break;
                case 2:
                    size = anVar.e().size() + 1;
                    anVar3 = this.a.u;
                    anVar3.a(anVar.f(), 2);
                    e.addAll(0, anVar.e());
                    break;
                case 3:
                    z = this.a.f;
                    if (!z) {
                        anVar.f().c(anVar.f().a());
                    }
                    c(anVar);
                    if (this.d != null) {
                        x2 = this.a.x();
                        if (x2 != null) {
                            z2 = this.a.q;
                            if (z2) {
                                sVar3 = this.a.A;
                                sVar3.b(x2, this.d, 604800000L);
                            } else {
                                sVar2 = this.a.B;
                                sVar2.b(x2, this.d, 86400000L);
                            }
                        }
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 4:
                    c(anVar);
                    if (this.d != null) {
                        x = this.a.x();
                        if (x != null) {
                            sVar = this.a.A;
                            sVar.b(x, this.d, 2592000000L);
                        }
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 5:
                    c(anVar);
                    size = 0;
                    break;
                case 6:
                    c(anVar);
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            bnVar = this.a.y;
            if (bnVar != null) {
                bnVar2 = this.a.y;
                int errorCode2 = this.a.getErrorCode();
                int i3 = this.c;
                anVar5 = this.a.u;
                str = this.a.mErrorString;
                bnVar2.a(true, errorCode2, i3, size, anVar5, str);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.an anVar) {
        this.a.u = anVar;
        this.a.d(anVar.f().d());
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
        bnVar = this.a.y;
        if (bnVar != null) {
            bnVar2 = this.a.y;
            bnVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null);
        }
        this.a.v = null;
        this.d = null;
    }
}
