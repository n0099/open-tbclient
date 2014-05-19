package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PraiseData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ae> {
    final /* synthetic */ bc a;
    private int c;
    private b b = null;
    private String d = null;
    private com.baidu.tieba.data.ae e = null;

    public be(bc bcVar, int i) {
        this.a = bcVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bcVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tieba.data.ae aeVar;
        com.baidu.tieba.data.ae aeVar2;
        com.baidu.tieba.data.ae aeVar3;
        bd bdVar;
        bd bdVar2;
        com.baidu.tieba.data.ae aeVar4;
        boolean z = false;
        super.onPreExecute();
        this.a.A = System.nanoTime();
        aeVar = this.a.v;
        ArrayList<com.baidu.tieba.data.ah> e = aeVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.d.f()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                aeVar3 = this.a.v;
                aeVar3.f().f(1);
                bdVar = this.a.z;
                if (bdVar != null) {
                    bdVar2 = this.a.z;
                    aeVar4 = this.a.v;
                    bdVar2.a(aeVar4);
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

    private void b(com.baidu.tieba.data.ae aeVar) {
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
                com.baidu.tieba.data.ah ahVar = aeVar.e().get(i3);
                for (int i4 = 0; i4 < ahVar.a().size(); i4++) {
                    boolean equals = str.equals(ahVar.a().get(i4).g().getUserId());
                    if (this.a.a == null) {
                        bc bcVar = this.a;
                        context2 = this.a.y;
                        bcVar.a = new com.baidu.tbadk.editortool.ab(context2);
                        this.a.a.d(true);
                    }
                    context = this.a.y;
                    ahVar.a().get(i4).a(context, equals, this.a.a);
                }
            }
        }
    }

    private com.baidu.tieba.data.ae a() {
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
        com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
        context = this.a.y;
        aeVar.a((String) tVar.b, context);
        if (aeVar.a()) {
            return aeVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ae b() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.ae doInBackground(Object... objArr) {
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
        com.baidu.tieba.data.ae b = bg.a().b();
        if (b != null) {
            this.a.g = bg.a().d();
            this.a.f = bg.a().e();
            return b;
        }
        try {
            aeVar = this.a.v;
            ArrayList<com.baidu.tieba.data.ah> e = aeVar.e();
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
                        a = b();
                        break;
                    } else {
                        a = a();
                        break;
                    }
                case 4:
                    a = b();
                    break;
                default:
                    a = null;
                    break;
            }
            if (a != null) {
                this.e = a;
                b(this.e);
                publishProgress(0);
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
            afVar = bc.x;
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
                b(aeVar2);
                return aeVar2;
            } else if (this.b != null) {
                this.a.setErrorString(this.b.e());
                this.a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    afVar3 = bc.x;
                    afVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.a.A;
                    afVar4 = bc.x;
                    afVar4.a((int) ((nanoTime - j2) / 1000000));
                    afVar5 = bc.x;
                    afVar5.b(this.b.d());
                    return aeVar2;
                }
                afVar2 = bc.x;
                afVar2.c(1);
                return aeVar2;
            } else {
                return aeVar2;
            }
        } catch (Exception e2) {
            BdLog.e("PbAsyncTask", "doInBackground", "error = " + e2.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        bd bdVar;
        bd bdVar2;
        String str;
        bdVar = this.a.z;
        if (bdVar != null && this.e != null) {
            bdVar2 = this.a.z;
            int i = this.c;
            com.baidu.tieba.data.ae aeVar = this.e;
            str = this.a.mErrorString;
            bdVar2.a(true, 0, i, 0, aeVar, str, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fb, code lost:
        r0 = r14.a.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x013f, code lost:
        r0 = r14.a.C();
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(com.baidu.tieba.data.ae aeVar) {
        int i;
        com.baidu.tieba.data.ae aeVar2;
        int size;
        com.baidu.tieba.data.ae aeVar3;
        com.baidu.tieba.data.ae aeVar4;
        String C;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String C2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        com.baidu.tieba.data.ae aeVar5;
        bd bdVar;
        bd bdVar2;
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
        bd bdVar3;
        bd bdVar4;
        String str2;
        this.a.w = null;
        if (aeVar != null) {
            this.a.t = false;
            this.a.e(aeVar.f().d());
            this.a.n = aeVar.f().a();
            bc bcVar = this.a;
            i = this.a.n;
            bcVar.n = i < 1 ? 1 : this.a.n;
            aeVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.ah> e = aeVar2.e();
            switch (this.c) {
                case 1:
                    aeVar4 = this.a.v;
                    aeVar4.a(aeVar.f(), 1);
                    e.addAll(aeVar.e());
                    size = 0;
                    break;
                case 2:
                    size = aeVar.e().size() + 1;
                    aeVar3 = this.a.v;
                    aeVar3.a(aeVar.f(), 2);
                    e.addAll(0, aeVar.e());
                    break;
                case 3:
                    z = this.a.g;
                    if (!z) {
                        aeVar.f().c(aeVar.f().a());
                    }
                    c(aeVar);
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
                    c(aeVar);
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
                    c(aeVar);
                    size = 0;
                    break;
                case 6:
                    c(aeVar);
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
                    PraiseData j = aeVar8.d().j();
                    praiseData = this.a.I;
                    if (praiseData != null && !j.isPriaseDataValid()) {
                        aeVar11 = this.a.v;
                        com.baidu.tbadk.core.data.o d = aeVar11.d();
                        praiseData3 = this.a.I;
                        d.a(praiseData3);
                    } else {
                        bc bcVar2 = this.a;
                        aeVar9 = this.a.v;
                        bcVar2.I = aeVar9.d().j();
                        praiseData2 = this.a.I;
                        aeVar10 = this.a.v;
                        praiseData2.setPostId(aeVar10.d().D());
                    }
                }
            }
            bdVar = this.a.z;
            if (bdVar != null) {
                bdVar2 = this.a.z;
                int errorCode = this.a.getErrorCode();
                int i2 = this.c;
                aeVar6 = this.a.v;
                str = this.a.mErrorString;
                bdVar2.a(true, errorCode, i2, size, aeVar6, str, 1);
            }
        } else {
            bdVar3 = this.a.z;
            if (bdVar3 != null) {
                bdVar4 = this.a.z;
                int errorCode2 = this.a.getErrorCode();
                int i3 = this.c;
                str2 = this.a.mErrorString;
                bdVar4.a(false, errorCode2, i3, 0, null, str2, 1);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.ae aeVar) {
        this.a.v = aeVar;
        this.a.d(aeVar.f().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bd bdVar;
        bd bdVar2;
        super.cancel(true);
        this.a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bdVar = this.a.z;
        if (bdVar != null) {
            bdVar2 = this.a.z;
            bdVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null, 2);
        }
        this.a.w = null;
        this.d = null;
    }
}
