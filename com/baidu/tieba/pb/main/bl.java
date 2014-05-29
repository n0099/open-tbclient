package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PraiseData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.af> {
    final /* synthetic */ bj a;
    private int c;
    private b b = null;
    private String d = null;
    private com.baidu.tieba.data.af e = null;

    public bl(bj bjVar, int i) {
        this.a = bjVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bjVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tieba.data.af afVar;
        com.baidu.tieba.data.af afVar2;
        com.baidu.tieba.data.af afVar3;
        bk bkVar;
        bk bkVar2;
        com.baidu.tieba.data.af afVar4;
        boolean z = false;
        super.onPreExecute();
        this.a.A = System.nanoTime();
        afVar = this.a.v;
        ArrayList<com.baidu.tieba.data.ai> e = afVar.e();
        if (this.c == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.d.f()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                afVar3 = this.a.v;
                afVar3.f().f(1);
                bkVar = this.a.z;
                if (bkVar != null) {
                    bkVar2 = this.a.z;
                    afVar4 = this.a.v;
                    bkVar2.a(afVar4);
                }
            }
        } else if (this.c == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.d.f()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                afVar2 = this.a.v;
                afVar2.f().e(1);
            }
        }
    }

    private void b(com.baidu.tieba.data.af afVar) {
        String str;
        int i;
        int i2;
        long j;
        Context context;
        Context context2;
        if (afVar != null) {
            if (afVar.d() == null || afVar.d().y() == null) {
                str = null;
            } else {
                str = afVar.d().y().getUserId();
            }
            com.baidu.tbadk.core.data.n d = afVar.d();
            i = this.a.h;
            d.d(i);
            i2 = this.a.i;
            d.c(i2);
            j = this.a.j;
            d.a(j);
            for (int i3 = 0; i3 < afVar.e().size(); i3++) {
                com.baidu.tieba.data.ai aiVar = afVar.e().get(i3);
                for (int i4 = 0; i4 < aiVar.i().size(); i4++) {
                    boolean equals = str.equals(aiVar.i().get(i4).o().getUserId());
                    if (this.a.a == null) {
                        bj bjVar = this.a;
                        context2 = this.a.y;
                        bjVar.a = new com.baidu.tbadk.editortool.ab(context2);
                        this.a.a.d(true);
                    }
                    context = this.a.y;
                    aiVar.i().get(i4).a(context, equals, this.a.a);
                }
            }
        }
    }

    private com.baidu.tieba.data.af a() {
        String D;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        D = this.a.D();
        this.a.C();
        sVar = this.a.C;
        if (sVar == null || D == null) {
            tVar = null;
        } else {
            sVar2 = this.a.C;
            tVar = sVar2.b(D);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
        context = this.a.y;
        afVar.a((String) tVar.b, context);
        if (afVar.a()) {
            return afVar;
        }
        return null;
    }

    private com.baidu.tieba.data.af b() {
        String D;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.t tVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        D = this.a.D();
        this.a.C();
        sVar = this.a.B;
        if (sVar == null || D == null) {
            tVar = null;
        } else {
            sVar2 = this.a.B;
            tVar = sVar2.b(D);
        }
        if (tVar == null || tVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
        context = this.a.y;
        afVar.a((String) tVar.b, context);
        if (afVar.a()) {
            if (afVar.j() != null) {
                String j = afVar.j();
                str = this.a.e;
                if (!j.equals(str)) {
                    return null;
                }
            }
            return afVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006b, code lost:
        if (r1 != false) goto L51;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tieba.data.af doInBackground(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.af afVar;
        boolean z2;
        com.baidu.tieba.data.af a;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        boolean z5;
        long j;
        boolean z6;
        com.baidu.tieba.data.ag agVar;
        boolean z7;
        Context context;
        com.baidu.tieba.data.ag agVar2;
        com.baidu.tieba.data.ag agVar3;
        long j2;
        com.baidu.tieba.data.ag agVar4;
        com.baidu.tieba.data.ag agVar5;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        com.baidu.tieba.data.af b = bn.a().b();
        if (b != null) {
            this.a.g = bn.a().d();
            this.a.f = bn.a().e();
            z10 = this.a.g;
            if (z10) {
                z11 = this.a.f;
                if (!z11) {
                    z12 = this.a.r;
                    if (!z12) {
                        return b;
                    }
                }
            }
            this.a.I = false;
            return b;
        }
        z = this.a.g;
        if (z) {
            z8 = this.a.f;
            if (!z8) {
                z9 = this.a.r;
            }
        }
        this.a.I = false;
        try {
            afVar = this.a.v;
            ArrayList<com.baidu.tieba.data.ai> e = afVar.e();
            switch (this.c) {
                case 1:
                    this.a.e = e.get(e.size() - 1).l();
                    a = null;
                    break;
                case 2:
                    this.a.e = e.get(0).l();
                    a = null;
                    break;
                case 3:
                    z2 = this.a.r;
                    if (z2) {
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
            z3 = this.a.g;
            z4 = this.a.f;
            int i5 = this.c;
            i3 = this.a.k;
            i4 = this.a.n;
            z5 = this.a.t;
            j = this.a.s;
            z6 = this.a.r;
            agVar = bj.x;
            z7 = this.a.I;
            this.d = bVar.a(str, str2, str3, i, i2, z3, z4, i5, i3, i4, z5, j, z6, agVar, z7);
            this.a.I = false;
            this.a.E = this.b.g();
            this.a.F = this.b.h();
            this.a.G = System.currentTimeMillis();
            com.baidu.tieba.data.af afVar2 = new com.baidu.tieba.data.af();
            String str4 = this.d;
            context = this.a.y;
            afVar2.a(str4, context);
            if (!this.b.b()) {
                afVar2 = null;
            }
            if (afVar2 != null) {
                b(afVar2);
                return afVar2;
            } else if (this.b != null) {
                this.a.setErrorString(this.b.e());
                this.a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    agVar3 = bj.x;
                    agVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.a.A;
                    agVar4 = bj.x;
                    agVar4.a((int) ((nanoTime - j2) / 1000000));
                    agVar5 = bj.x;
                    agVar5.b(this.b.d());
                    return afVar2;
                }
                agVar2 = bj.x;
                agVar2.c(1);
                return afVar2;
            } else {
                return afVar2;
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
        bk bkVar;
        bk bkVar2;
        String str;
        bkVar = this.a.z;
        if (bkVar != null && this.e != null) {
            bkVar2 = this.a.z;
            int i = this.c;
            com.baidu.tieba.data.af afVar = this.e;
            str = this.a.mErrorString;
            bkVar2.a(true, 0, i, 0, afVar, str, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0110, code lost:
        r0 = r14.a.D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0154, code lost:
        r0 = r14.a.D();
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(com.baidu.tieba.data.af afVar) {
        int i;
        com.baidu.tieba.data.af afVar2;
        int size;
        com.baidu.tieba.data.af afVar3;
        com.baidu.tieba.data.af afVar4;
        String D;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String D2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        com.baidu.tieba.data.af afVar5;
        bk bkVar;
        bk bkVar2;
        com.baidu.tieba.data.af afVar6;
        String str;
        com.baidu.tieba.data.af afVar7;
        com.baidu.tieba.data.af afVar8;
        PraiseData praiseData;
        com.baidu.tieba.data.af afVar9;
        PraiseData praiseData2;
        com.baidu.tieba.data.af afVar10;
        com.baidu.tieba.data.af afVar11;
        com.baidu.tieba.data.af afVar12;
        PraiseData praiseData3;
        bk bkVar3;
        bk bkVar4;
        String str2;
        this.a.w = null;
        if (afVar != null) {
            this.a.t = false;
            this.a.e(afVar.f().d());
            this.a.n = afVar.f().a();
            bj bjVar = this.a;
            i = this.a.n;
            bjVar.n = i < 1 ? 1 : this.a.n;
            afVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.ai> e = afVar2.e();
            switch (this.c) {
                case 1:
                    afVar4 = this.a.v;
                    afVar4.a(afVar.f(), 1);
                    e.addAll(afVar.e());
                    size = 0;
                    break;
                case 2:
                    size = afVar.e().size() + 1;
                    afVar3 = this.a.v;
                    afVar3.a(afVar.f(), 2);
                    e.addAll(0, afVar.e());
                    break;
                case 3:
                    z = this.a.g;
                    if (!z) {
                        afVar.f().c(afVar.f().a());
                    }
                    c(afVar);
                    if (this.d != null && D2 != null) {
                        this.a.C();
                        z2 = this.a.r;
                        if (z2) {
                            sVar3 = this.a.B;
                            sVar3.b(D2, this.d, 604800000L);
                            size = 0;
                            break;
                        } else {
                            sVar2 = this.a.C;
                            sVar2.b(D2, this.d, 86400000L);
                            size = 0;
                            break;
                        }
                    }
                    size = 0;
                    break;
                case 4:
                    c(afVar);
                    if (this.d != null && D != null) {
                        this.a.C();
                        sVar = this.a.B;
                        sVar.b(D, this.d, 2592000000L);
                        size = 0;
                        break;
                    }
                    size = 0;
                    break;
                case 5:
                    c(afVar);
                    size = 0;
                    break;
                case 6:
                    c(afVar);
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            afVar5 = this.a.v;
            if (afVar5 != null) {
                afVar7 = this.a.v;
                if (afVar7.d() != null) {
                    afVar8 = this.a.v;
                    PraiseData o = afVar8.d().o();
                    praiseData = this.a.J;
                    if (praiseData != null && !o.isPriaseDataValid()) {
                        afVar12 = this.a.v;
                        com.baidu.tbadk.core.data.n d = afVar12.d();
                        praiseData3 = this.a.J;
                        d.a(praiseData3);
                    } else {
                        bj bjVar2 = this.a;
                        afVar9 = this.a.v;
                        bjVar2.J = afVar9.d().o();
                        praiseData2 = this.a.J;
                        afVar10 = this.a.v;
                        praiseData2.setPostId(afVar10.d().I());
                    }
                    afVar11 = this.a.v;
                    afVar11.d().b(afVar.d().s());
                }
            }
            bkVar = this.a.z;
            if (bkVar != null) {
                bkVar2 = this.a.z;
                int errorCode = this.a.getErrorCode();
                int i2 = this.c;
                afVar6 = this.a.v;
                str = this.a.mErrorString;
                bkVar2.a(true, errorCode, i2, size, afVar6, str, 1);
            }
        } else {
            bkVar3 = this.a.z;
            if (bkVar3 != null) {
                bkVar4 = this.a.z;
                int errorCode2 = this.a.getErrorCode();
                int i3 = this.c;
                str2 = this.a.mErrorString;
                bkVar4.a(false, errorCode2, i3, 0, null, str2, 1);
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.af afVar) {
        this.a.v = afVar;
        this.a.d(afVar.f().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bk bkVar;
        bk bkVar2;
        super.cancel(true);
        this.a.setErrorString(null);
        if (this.b != null) {
            this.b.a();
        }
        bkVar = this.a.z;
        if (bkVar != null) {
            bkVar2 = this.a.z;
            bkVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null, 2);
        }
        this.a.w = null;
        this.d = null;
    }
}
