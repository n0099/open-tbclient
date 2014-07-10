package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.pb.history.RequestPbHistoryWriteMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.ai> {
    final /* synthetic */ bm a;
    private int c;
    private b b = null;
    private String d = null;
    private com.baidu.tieba.data.ai e = null;

    public bo(bm bmVar, int i) {
        this.a = bmVar;
        this.c = 3;
        this.c = i;
        setSelfExecute(true);
        bmVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tieba.data.ai aiVar;
        com.baidu.tieba.data.ai aiVar2;
        com.baidu.tieba.data.ai aiVar3;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.ai aiVar4;
        boolean z = false;
        super.onPreExecute();
        this.a.A = System.nanoTime();
        aiVar = this.a.v;
        ArrayList<com.baidu.tieba.data.am> d = aiVar.d();
        if (this.c == 1) {
            boolean z2 = false;
            while (d.size() + 30 > com.baidu.tieba.data.e.f()) {
                d.remove(0);
                z2 = true;
            }
            if (z2) {
                aiVar3 = this.a.v;
                aiVar3.e().f(1);
                bnVar = this.a.z;
                if (bnVar != null) {
                    bnVar2 = this.a.z;
                    aiVar4 = this.a.v;
                    bnVar2.a(aiVar4);
                }
            }
        } else if (this.c == 2) {
            while (d.size() + 30 > com.baidu.tieba.data.e.f()) {
                d.remove(d.size() - 1);
                z = true;
            }
            if (z) {
                aiVar2 = this.a.v;
                aiVar2.e().e(1);
            }
        }
    }

    private void b(com.baidu.tieba.data.ai aiVar) {
        String str;
        int i;
        int i2;
        long j;
        Context context;
        Context context2;
        if (aiVar != null) {
            if (aiVar.c() == null || aiVar.c().y() == null) {
                str = null;
            } else {
                str = aiVar.c().y().getUserId();
            }
            com.baidu.tbadk.core.data.m c = aiVar.c();
            i = this.a.h;
            c.d(i);
            i2 = this.a.i;
            c.c(i2);
            j = this.a.j;
            c.a(j);
            for (int i3 = 0; i3 < aiVar.d().size(); i3++) {
                com.baidu.tieba.data.am amVar = aiVar.d().get(i3);
                for (int i4 = 0; i4 < amVar.i().size(); i4++) {
                    boolean equals = str.equals(amVar.i().get(i4).o().getUserId());
                    if (this.a.a == null) {
                        bm bmVar = this.a;
                        context2 = this.a.y;
                        bmVar.a = new com.baidu.tbadk.editortool.aa(context2);
                        this.a.a.b(true);
                    }
                    context = this.a.y;
                    amVar.i().get(i4).a(context, equals, this.a.a);
                }
            }
        }
    }

    private com.baidu.tieba.data.ai a() {
        String H;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.u uVar;
        Context context;
        com.baidu.adp.lib.cache.s sVar2;
        H = this.a.H();
        this.a.F();
        sVar = this.a.C;
        if (sVar == null || H == null) {
            uVar = null;
        } else {
            sVar2 = this.a.C;
            uVar = sVar2.b(H);
        }
        if (uVar == null || uVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
        context = this.a.y;
        aiVar.a((String) uVar.b, context);
        if (aiVar.a()) {
            return aiVar;
        }
        return null;
    }

    private com.baidu.tieba.data.ai b() {
        String H;
        com.baidu.adp.lib.cache.s sVar;
        com.baidu.adp.lib.cache.u uVar;
        Context context;
        String str;
        com.baidu.adp.lib.cache.s sVar2;
        H = this.a.H();
        this.a.F();
        sVar = this.a.B;
        if (sVar == null || H == null) {
            uVar = null;
        } else {
            sVar2 = this.a.B;
            uVar = sVar2.b(H);
        }
        if (uVar == null || uVar.b == 0) {
            return null;
        }
        com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
        context = this.a.y;
        aiVar.a((String) uVar.b, context);
        if (aiVar.a()) {
            if (aiVar.i() != null) {
                String i = aiVar.i();
                str = this.a.e;
                if (!i.equals(str)) {
                    return null;
                }
            }
            return aiVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006b, code lost:
        if (r1 != false) goto L53;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tieba.data.ai doInBackground(Object... objArr) {
        boolean z;
        com.baidu.tieba.data.ai aiVar;
        com.baidu.tieba.data.ai aiVar2;
        boolean z2;
        com.baidu.tieba.data.ai a;
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
        com.baidu.tieba.data.ak akVar;
        boolean z7;
        Context context;
        com.baidu.tieba.data.ak akVar2;
        com.baidu.tieba.data.ak akVar3;
        long j2;
        com.baidu.tieba.data.ak akVar4;
        com.baidu.tieba.data.ak akVar5;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        com.baidu.tieba.data.ai b = bq.a().b();
        if (b != null) {
            this.a.g = bq.a().d();
            this.a.f = bq.a().e();
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
            aiVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.am> d = aiVar2.d();
            switch (this.c) {
                case 1:
                    this.a.e = d.get(d.size() - 1).l();
                    a = null;
                    break;
                case 2:
                    this.a.e = d.get(0).l();
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
            akVar = bm.x;
            z7 = this.a.I;
            this.d = bVar.a(str, str2, str3, i, i2, z3, z4, i5, i3, i4, z5, j, z6, akVar, z7);
            this.a.I = false;
            this.a.E = this.b.g();
            this.a.F = this.b.h();
            this.a.G = System.currentTimeMillis();
            aiVar = new com.baidu.tieba.data.ai();
            String str4 = this.d;
            context = this.a.y;
            aiVar.a(str4, context);
            if (!this.b.b()) {
                aiVar = null;
            }
            if (aiVar != null) {
                b(aiVar);
            } else if (this.b != null) {
                this.a.setErrorString(this.b.e());
                this.a.setErrorCode(this.b.f());
                if (this.b.c()) {
                    akVar3 = bm.x;
                    akVar3.a();
                    long nanoTime = System.nanoTime();
                    j2 = this.a.A;
                    akVar4 = bm.x;
                    akVar4.a((int) ((nanoTime - j2) / 1000000));
                    akVar5 = bm.x;
                    akVar5.b(this.b.d());
                } else {
                    akVar2 = bm.x;
                    akVar2.c(1);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            aiVar = null;
        }
        if (aiVar == null && this.e != null) {
            return this.e;
        }
        return aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        bn bnVar;
        bn bnVar2;
        String str;
        bnVar = this.a.z;
        if (bnVar != null && this.e != null) {
            bnVar2 = this.a.z;
            int i = this.c;
            com.baidu.tieba.data.ai aiVar = this.e;
            str = this.a.mErrorString;
            bnVar2.a(true, 0, i, 0, aiVar, str, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01b1, code lost:
        r0 = r8.a.H();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01f2, code lost:
        r0 = r8.a.H();
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(com.baidu.tieba.data.ai aiVar) {
        int i;
        com.baidu.tieba.data.ai aiVar2;
        com.baidu.tieba.data.ai aiVar3;
        com.baidu.tieba.data.ai aiVar4;
        String H;
        com.baidu.adp.lib.cache.s sVar;
        boolean z;
        String H2;
        boolean z2;
        com.baidu.adp.lib.cache.s sVar2;
        com.baidu.adp.lib.cache.s sVar3;
        com.baidu.tieba.data.ai aiVar5;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.ai aiVar6;
        String str;
        com.baidu.tieba.data.ai aiVar7;
        com.baidu.tieba.data.ai aiVar8;
        PraiseData praiseData;
        com.baidu.tieba.data.ai aiVar9;
        PraiseData praiseData2;
        com.baidu.tieba.data.ai aiVar10;
        com.baidu.tieba.data.ai aiVar11;
        com.baidu.tieba.data.ai aiVar12;
        PraiseData praiseData3;
        com.baidu.tieba.data.ai aiVar13;
        com.baidu.tieba.data.ai aiVar14;
        com.baidu.tieba.data.ai aiVar15;
        com.baidu.tieba.data.ai aiVar16;
        com.baidu.tieba.data.ai aiVar17;
        com.baidu.tieba.data.ai aiVar18;
        bn bnVar3;
        bn bnVar4;
        String str2;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        this.a.w = null;
        if (this.b != null) {
            boolean b = this.b.b();
            int f = this.b.f();
            String e = this.b.e();
            int d = this.b.d();
            aVar = this.a.J;
            if (aVar != null) {
                aVar2 = this.a.J;
                aVar2.a(true, b, f, e, d);
                this.a.J = null;
            }
        }
        if (aiVar != null) {
            this.a.t = false;
            this.a.e(aiVar.e().c());
            this.a.n = aiVar.e().a();
            bm bmVar = this.a;
            i = this.a.n;
            bmVar.n = i < 1 ? 1 : this.a.n;
            int i2 = 0;
            aiVar2 = this.a.v;
            ArrayList<com.baidu.tieba.data.am> d2 = aiVar2.d();
            switch (this.c) {
                case 1:
                    aiVar4 = this.a.v;
                    aiVar4.a(aiVar.e(), 1);
                    d2.addAll(aiVar.d());
                    break;
                case 2:
                    i2 = aiVar.d().size() + 1;
                    aiVar3 = this.a.v;
                    aiVar3.a(aiVar.e(), 2);
                    d2.addAll(0, aiVar.d());
                    break;
                case 3:
                    z = this.a.g;
                    if (!z) {
                        aiVar.e().c(aiVar.e().a());
                    }
                    c(aiVar);
                    if (this.d != null && H2 != null) {
                        this.a.F();
                        z2 = this.a.r;
                        if (z2) {
                            sVar3 = this.a.B;
                            sVar3.b(H2, this.d, 604800000L);
                            break;
                        } else {
                            sVar2 = this.a.C;
                            sVar2.b(H2, this.d, 86400000L);
                            break;
                        }
                    }
                    break;
                case 4:
                    c(aiVar);
                    if (this.d != null && H != null) {
                        this.a.F();
                        sVar = this.a.B;
                        sVar.b(H, this.d, 2592000000L);
                        break;
                    }
                    break;
                case 5:
                    c(aiVar);
                    break;
                case 6:
                    c(aiVar);
                    break;
            }
            aiVar5 = this.a.v;
            if (aiVar5 != null) {
                aiVar7 = this.a.v;
                if (aiVar7.c() != null) {
                    aiVar8 = this.a.v;
                    PraiseData o = aiVar8.c().o();
                    praiseData = this.a.K;
                    if (praiseData != null && !o.isPriaseDataValid()) {
                        aiVar12 = this.a.v;
                        com.baidu.tbadk.core.data.m c = aiVar12.c();
                        praiseData3 = this.a.K;
                        c.a(praiseData3);
                    } else {
                        bm bmVar2 = this.a;
                        aiVar9 = this.a.v;
                        bmVar2.K = aiVar9.c().o();
                        praiseData2 = this.a.K;
                        aiVar10 = this.a.v;
                        praiseData2.setPostId(aiVar10.c().I());
                    }
                    aiVar11 = this.a.v;
                    aiVar11.c().b(aiVar.c().s());
                }
            }
            bnVar = this.a.z;
            if (bnVar != null) {
                bnVar2 = this.a.z;
                int errorCode = this.a.getErrorCode();
                int i3 = this.c;
                aiVar6 = this.a.v;
                str = this.a.mErrorString;
                bnVar2.a(true, errorCode, i3, i2, aiVar6, str, 1);
            }
        } else {
            bnVar3 = this.a.z;
            if (bnVar3 != null) {
                bnVar4 = this.a.z;
                int errorCode2 = this.a.getErrorCode();
                int i4 = this.c;
                str2 = this.a.mErrorString;
                bnVar4.a(false, errorCode2, i4, 0, null, str2, 1);
            }
        }
        aiVar13 = this.a.v;
        if (aiVar13 != null) {
            aiVar14 = this.a.v;
            if (aiVar14.c() != null) {
                aiVar15 = this.a.v;
                if (aiVar15.b() != null) {
                    RequestPbHistoryWriteMessage requestPbHistoryWriteMessage = new RequestPbHistoryWriteMessage();
                    com.baidu.tieba.data.aj ajVar = new com.baidu.tieba.data.aj();
                    aiVar16 = this.a.v;
                    ajVar.a(aiVar16.c().p());
                    aiVar17 = this.a.v;
                    ajVar.c(aiVar17.b().getName());
                    aiVar18 = this.a.v;
                    ajVar.b(aiVar18.c().r());
                    requestPbHistoryWriteMessage.setData(ajVar);
                    MessageManager.getInstance().sendMessageFromBackground(requestPbHistoryWriteMessage);
                }
            }
        }
        this.d = null;
    }

    private void c(com.baidu.tieba.data.ai aiVar) {
        this.a.v = aiVar;
        this.a.d(aiVar.e().c());
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
            bnVar2.a(false, this.a.getErrorCode(), this.c, 0, null, null, 2);
        }
        this.a.G();
        this.a.w = null;
        this.d = null;
    }
}
