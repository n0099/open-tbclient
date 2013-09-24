package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ao> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f1417a;
    private int c;
    private com.baidu.tieba.a.i b = null;
    private String d = null;
    private com.baidu.tieba.data.ao e = null;

    public bf(bd bdVar, int i) {
        this.f1417a = bdVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bdVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.data.ao aoVar;
        com.baidu.tieba.data.ao aoVar2;
        com.baidu.tieba.data.ao aoVar3;
        be beVar;
        be beVar2;
        com.baidu.tieba.data.ao aoVar4;
        boolean z = false;
        super.b();
        this.f1417a.y = System.nanoTime();
        aoVar = this.f1417a.t;
        ArrayList<com.baidu.tieba.data.as> d = aoVar.d();
        if (this.c == 1) {
            boolean z2 = false;
            while (d.size() + 30 > com.baidu.tieba.data.g.c()) {
                d.remove(0);
                z2 = true;
            }
            if (z2) {
                aoVar3 = this.f1417a.t;
                aoVar3.e().f(1);
                beVar = this.f1417a.x;
                if (beVar != null) {
                    beVar2 = this.f1417a.x;
                    aoVar4 = this.f1417a.t;
                    beVar2.a(aoVar4);
                }
            }
        } else if (this.c == 2) {
            while (d.size() + 30 > com.baidu.tieba.data.g.c()) {
                d.remove(d.size() - 1);
                z = true;
            }
            if (z) {
                aoVar2 = this.f1417a.t;
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
            com.baidu.tieba.data.bh c = aoVar.c();
            i = this.f1417a.g;
            c.b(i);
            i2 = this.f1417a.h;
            c.a(i2);
            j = this.f1417a.i;
            c.a(j);
            for (int i3 = 0; i3 < aoVar.d().size(); i3++) {
                com.baidu.tieba.data.as asVar = aoVar.d().get(i3);
                for (int i4 = 0; i4 < asVar.a().size(); i4++) {
                    context = this.f1417a.w;
                    asVar.a().get(i4).a(context);
                }
            }
        }
    }

    private com.baidu.tieba.data.ao e() {
        String w;
        com.baidu.adp.lib.cache.q qVar;
        com.baidu.adp.lib.cache.r rVar;
        Context context;
        com.baidu.adp.lib.cache.q qVar2;
        w = this.f1417a.w();
        qVar = this.f1417a.A;
        if (qVar == null || w == null) {
            rVar = null;
        } else {
            qVar2 = this.f1417a.A;
            rVar = qVar2.b(w);
        }
        if (rVar == null || rVar.f388a == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.f1417a.w;
        aoVar.a((String) rVar.f388a, context);
        if (aoVar.a()) {
            return aoVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ao f() {
        String w;
        com.baidu.adp.lib.cache.q qVar;
        com.baidu.adp.lib.cache.r rVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.q qVar2;
        w = this.f1417a.w();
        qVar = this.f1417a.z;
        if (qVar == null || w == null) {
            rVar = null;
        } else {
            qVar2 = this.f1417a.z;
            rVar = qVar2.b(w);
        }
        if (rVar == null || rVar.f388a == 0) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        context = this.f1417a.w;
        aoVar.a((String) rVar.f388a, context);
        if (aoVar.a()) {
            if (aoVar.h() != null) {
                String h = aoVar.h();
                str = this.f1417a.d;
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
        com.baidu.tieba.data.ao e;
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
            aoVar = this.f1417a.t;
            ArrayList<com.baidu.tieba.data.as> d = aoVar.d();
            switch (this.c) {
                case 1:
                    this.f1417a.d = d.get(d.size() - 1).d();
                    e = null;
                    break;
                case 2:
                    this.f1417a.d = d.get(0).d();
                    e = null;
                    break;
                case 3:
                    z = this.f1417a.q;
                    if (z) {
                        e = f();
                        break;
                    } else {
                        e = e();
                        break;
                    }
                case 4:
                    e = f();
                    break;
                default:
                    e = null;
                    break;
            }
            if (e != null) {
                this.e = e;
                b(this.e);
                c((Object[]) new Integer[]{0});
            }
            this.b = new com.baidu.tieba.a.i();
            com.baidu.tieba.a.i iVar = this.b;
            str = this.f1417a.c;
            str2 = this.f1417a.b;
            str3 = this.f1417a.d;
            i = this.f1417a.l;
            i2 = this.f1417a.k;
            z2 = this.f1417a.f;
            z3 = this.f1417a.e;
            int i5 = this.c;
            i3 = this.f1417a.j;
            i4 = this.f1417a.m;
            z4 = this.f1417a.s;
            j = this.f1417a.r;
            z5 = this.f1417a.q;
            apVar = bd.v;
            this.d = iVar.a(str, str2, str3, i, i2, z2, z3, i5, i3, i4, z4, j, z5, apVar);
            com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao();
            String str4 = this.d;
            context = this.f1417a.w;
            aoVar2.a(str4, context);
            if (!this.b.b()) {
                aoVar2 = null;
            }
            if (aoVar2 != null) {
                b(aoVar2);
                return aoVar2;
            } else if (this.b != null) {
                this.f1417a.setErrorString(this.b.e());
                this.f1417a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    apVar3 = bd.v;
                    apVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.f1417a.y;
                    apVar4 = bd.v;
                    apVar4.a((int) ((nanoTime - j2) / 1000000));
                    apVar5 = bd.v;
                    apVar5.b(this.b.d());
                    return aoVar2;
                }
                apVar2 = bd.v;
                apVar2.c(1);
                return aoVar2;
            } else {
                return aoVar2;
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.av.b("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        be beVar;
        be beVar2;
        String str;
        beVar = this.f1417a.x;
        if (beVar != null && this.e != null) {
            beVar2 = this.f1417a.x;
            int i = this.c;
            com.baidu.tieba.data.ao aoVar = this.e;
            str = this.f1417a.mErrorString;
            beVar2.a(true, 0, i, 0, aoVar, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b5, code lost:
        r0 = r13.f1417a.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f1, code lost:
        r0 = r13.f1417a.w();
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.data.ao aoVar) {
        int i;
        com.baidu.tieba.data.ao aoVar2;
        int size;
        com.baidu.tieba.data.ao aoVar3;
        com.baidu.tieba.data.ao aoVar4;
        String w;
        com.baidu.adp.lib.cache.q qVar;
        boolean z;
        String w2;
        boolean z2;
        com.baidu.adp.lib.cache.q qVar2;
        com.baidu.adp.lib.cache.q qVar3;
        be beVar;
        be beVar2;
        com.baidu.tieba.data.ao aoVar5;
        String str;
        be beVar3;
        be beVar4;
        String str2;
        this.f1417a.u = null;
        if (aoVar != null) {
            this.f1417a.s = false;
            this.f1417a.e(aoVar.e().d());
            this.f1417a.m = aoVar.e().a();
            bd bdVar = this.f1417a;
            i = this.f1417a.m;
            bdVar.m = i < 1 ? 1 : this.f1417a.m;
            aoVar2 = this.f1417a.t;
            ArrayList<com.baidu.tieba.data.as> d = aoVar2.d();
            switch (this.c) {
                case 1:
                    aoVar4 = this.f1417a.t;
                    aoVar4.a(aoVar.e(), 1);
                    d.addAll(aoVar.d());
                    size = 0;
                    break;
                case 2:
                    size = aoVar.d().size() + 1;
                    aoVar3 = this.f1417a.t;
                    aoVar3.a(aoVar.e(), 2);
                    d.addAll(0, aoVar.d());
                    break;
                case 3:
                    z = this.f1417a.f;
                    if (!z) {
                        aoVar.e().c(aoVar.e().a());
                    }
                    c(aoVar);
                    if (this.d != null && w2 != null) {
                        z2 = this.f1417a.q;
                        if (z2) {
                            qVar3 = this.f1417a.z;
                            qVar3.b(w2, this.d, 604800000L);
                            size = 0;
                            break;
                        } else {
                            qVar2 = this.f1417a.A;
                            qVar2.b(w2, this.d, Util.MILLSECONDS_OF_DAY);
                            size = 0;
                            break;
                        }
                    }
                    size = 0;
                    break;
                case 4:
                    c(aoVar);
                    if (this.d != null && w != null) {
                        qVar = this.f1417a.z;
                        qVar.b(w, this.d, 2592000000L);
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
            beVar = this.f1417a.x;
            if (beVar != null) {
                beVar2 = this.f1417a.x;
                int errorCode = this.f1417a.getErrorCode();
                int i2 = this.c;
                aoVar5 = this.f1417a.t;
                str = this.f1417a.mErrorString;
                beVar2.a(true, errorCode, i2, size, aoVar5, str);
            }
        } else {
            beVar3 = this.f1417a.x;
            if (beVar3 != null) {
                beVar4 = this.f1417a.x;
                int errorCode2 = this.f1417a.getErrorCode();
                int i3 = this.c;
                str2 = this.f1417a.mErrorString;
                beVar4.a(false, errorCode2, i3, 0, null, str2);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.ao aoVar) {
        this.f1417a.t = aoVar;
        this.f1417a.d(aoVar.e().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        be beVar;
        be beVar2;
        super.cancel(true);
        this.f1417a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        beVar = this.f1417a.x;
        if (beVar != null) {
            beVar2 = this.f1417a.x;
            beVar2.a(false, this.f1417a.getErrorCode(), this.c, 0, null, null);
        }
        this.f1417a.u = null;
        this.d = null;
    }
}
