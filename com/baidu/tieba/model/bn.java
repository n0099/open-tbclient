package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ao> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bl f1920a;
    private int c;
    private com.baidu.tieba.a.i b = null;
    private String d = null;
    private com.baidu.tieba.data.ao e = null;

    public bn(bl blVar, int i) {
        this.f1920a = blVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        blVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.data.ao aoVar;
        com.baidu.tieba.data.ao aoVar2;
        com.baidu.tieba.data.ao aoVar3;
        bm bmVar;
        bm bmVar2;
        com.baidu.tieba.data.ao aoVar4;
        boolean z = false;
        super.b();
        this.f1920a.y = System.nanoTime();
        aoVar = this.f1920a.t;
        ArrayList<com.baidu.tieba.data.as> d = aoVar.d();
        if (this.c == 1) {
            boolean z2 = false;
            while (d.size() + 30 > com.baidu.tieba.data.h.c()) {
                d.remove(0);
                z2 = true;
            }
            if (z2) {
                aoVar3 = this.f1920a.t;
                aoVar3.e().f(1);
                bmVar = this.f1920a.x;
                if (bmVar != null) {
                    bmVar2 = this.f1920a.x;
                    aoVar4 = this.f1920a.t;
                    bmVar2.a(aoVar4);
                }
            }
        } else if (this.c == 2) {
            while (d.size() + 30 > com.baidu.tieba.data.h.c()) {
                d.remove(d.size() - 1);
                z = true;
            }
            if (z) {
                aoVar2 = this.f1920a.t;
                aoVar2.e().e(1);
            }
        }
    }

    private void b(com.baidu.tieba.data.ao aoVar) {
        int i;
        int i2;
        long j;
        Context context;
        if (aoVar != null) {
            com.baidu.tieba.data.bf c = aoVar.c();
            i = this.f1920a.g;
            c.b(i);
            i2 = this.f1920a.h;
            c.a(i2);
            j = this.f1920a.i;
            c.a(j);
            for (int i3 = 0; i3 < aoVar.d().size(); i3++) {
                com.baidu.tieba.data.as asVar = aoVar.d().get(i3);
                for (int i4 = 0; i4 < asVar.a().size(); i4++) {
                    context = this.f1920a.w;
                    asVar.a().get(i4).a(context);
                }
            }
        }
    }

    private com.baidu.tieba.data.ao d() {
        String w;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        w = this.f1920a.w();
        sVar = this.f1920a.A;
        if (sVar == null || w == null) {
            tVar = null;
        } else {
            sVar2 = this.f1920a.A;
            tVar = sVar2.b(w);
        }
        if (tVar == null || tVar.f437a == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.f1920a.w;
        aoVar.a((String) tVar.f437a, context);
        if (aoVar.a()) {
            return aoVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ao e() {
        String w;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        w = this.f1920a.w();
        sVar = this.f1920a.z;
        if (sVar == null || w == null) {
            tVar = null;
        } else {
            sVar2 = this.f1920a.z;
            tVar = sVar2.b(w);
        }
        if (tVar == null || tVar.f437a == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.f1920a.w;
        aoVar.a((String) tVar.f437a, context);
        if (aoVar.a()) {
            if (aoVar.h() != null) {
                String h = aoVar.h();
                str = this.f1920a.d;
                if (!h.equals(str)) {
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
            aoVar = this.f1920a.t;
            ArrayList<com.baidu.tieba.data.as> d2 = aoVar.d();
            switch (this.c) {
                case 1:
                    this.f1920a.d = d2.get(d2.size() - 1).d();
                    d = null;
                    break;
                case 2:
                    this.f1920a.d = d2.get(0).d();
                    d = null;
                    break;
                case 3:
                    z = this.f1920a.q;
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
            this.b = new com.baidu.tieba.a.i();
            com.baidu.tieba.a.i iVar = this.b;
            str = this.f1920a.c;
            str2 = this.f1920a.b;
            str3 = this.f1920a.d;
            i = this.f1920a.l;
            i2 = this.f1920a.k;
            z2 = this.f1920a.f;
            z3 = this.f1920a.e;
            int i5 = this.c;
            i3 = this.f1920a.j;
            i4 = this.f1920a.m;
            z4 = this.f1920a.s;
            j = this.f1920a.r;
            z5 = this.f1920a.q;
            apVar = bl.v;
            this.d = iVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, apVar);
            com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao();
            String str4 = this.d;
            context = this.f1920a.w;
            aoVar2.a(str4, context);
            if (!this.b.b()) {
                aoVar2 = null;
            }
            if (aoVar2 != null) {
                b(aoVar2);
                return aoVar2;
            } else if (this.b != null) {
                this.f1920a.setErrorString(this.b.e());
                this.f1920a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    apVar3 = bl.v;
                    apVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.f1920a.y;
                    apVar4 = bl.v;
                    apVar4.a((int) ((nanoTime - j2) / 1000000));
                    apVar5 = bl.v;
                    apVar5.b(this.b.d());
                    return aoVar2;
                }
                apVar2 = bl.v;
                apVar2.c(1);
                return aoVar2;
            } else {
                return aoVar2;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        bm bmVar;
        bm bmVar2;
        String str;
        bmVar = this.f1920a.x;
        if (bmVar != null && this.e != null) {
            bmVar2 = this.f1920a.x;
            int i = this.c;
            com.baidu.tieba.data.ao aoVar = this.e;
            str = this.f1920a.mErrorString;
            bmVar2.a(true, 0, i, 0, aoVar, str);
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
        String w;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String w2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        bm bmVar;
        bm bmVar2;
        com.baidu.tieba.data.ao aoVar5;
        String str;
        bm bmVar3;
        bm bmVar4;
        String str2;
        this.f1920a.u = null;
        if (aoVar == null) {
            bmVar3 = this.f1920a.x;
            if (bmVar3 != null) {
                bmVar4 = this.f1920a.x;
                int errorCode = this.f1920a.getErrorCode();
                int i2 = this.c;
                str2 = this.f1920a.mErrorString;
                bmVar4.a(false, errorCode, i2, 0, null, str2);
            }
        } else {
            this.f1920a.s = false;
            this.f1920a.e(aoVar.e().d());
            this.f1920a.m = aoVar.e().a();
            bl blVar = this.f1920a;
            i = this.f1920a.m;
            blVar.m = i < 1 ? 1 : this.f1920a.m;
            aoVar2 = this.f1920a.t;
            ArrayList<com.baidu.tieba.data.as> d = aoVar2.d();
            switch (this.c) {
                case 1:
                    aoVar4 = this.f1920a.t;
                    aoVar4.a(aoVar.e(), 1);
                    d.addAll(aoVar.d());
                    size = 0;
                    break;
                case 2:
                    size = aoVar.d().size() + 1;
                    aoVar3 = this.f1920a.t;
                    aoVar3.a(aoVar.e(), 2);
                    d.addAll(0, aoVar.d());
                    break;
                case 3:
                    z = this.f1920a.f;
                    if (!z) {
                        aoVar.e().c(aoVar.e().a());
                    }
                    c(aoVar);
                    if (this.d != null) {
                        w2 = this.f1920a.w();
                        if (w2 != null) {
                            z2 = this.f1920a.q;
                            if (z2) {
                                sVar3 = this.f1920a.z;
                                sVar3.b(w2, this.d, 604800000L);
                            } else {
                                sVar2 = this.f1920a.A;
                                sVar2.b(w2, this.d, Util.MILLSECONDS_OF_DAY);
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
                        w = this.f1920a.w();
                        if (w != null) {
                            sVar = this.f1920a.z;
                            sVar.b(w, this.d, 2592000000L);
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
            bmVar = this.f1920a.x;
            if (bmVar != null) {
                bmVar2 = this.f1920a.x;
                int errorCode2 = this.f1920a.getErrorCode();
                int i3 = this.c;
                aoVar5 = this.f1920a.t;
                str = this.f1920a.mErrorString;
                bmVar2.a(true, errorCode2, i3, size, aoVar5, str);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.ao aoVar) {
        this.f1920a.t = aoVar;
        this.f1920a.d(aoVar.e().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bm bmVar;
        bm bmVar2;
        super.cancel(true);
        this.f1920a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bmVar = this.f1920a.x;
        if (bmVar != null) {
            bmVar2 = this.f1920a.x;
            bmVar2.a(false, this.f1920a.getErrorCode(), this.c, 0, null, null);
        }
        this.f1920a.u = null;
        this.d = null;
    }
}
