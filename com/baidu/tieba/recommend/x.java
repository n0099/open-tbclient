package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, com.baidu.tieba.data.o> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2326a;
    private com.baidu.tieba.a.l b;
    private int c;
    private String d;

    public x(w wVar, int i, String str) {
        this.f2326a = wVar;
        this.c = i;
        this.d = str;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        y yVar;
        y yVar2;
        super.b();
        yVar = this.f2326a.b;
        if (yVar != null) {
            yVar2 = this.f2326a.b;
            yVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.o a(String... strArr) {
        String str;
        String a2;
        switch (this.c) {
            case 0:
            case 2:
                this.b = new com.baidu.tieba.a.l(this.c == 0);
                com.baidu.tieba.a.l lVar = this.b;
                String str2 = this.d;
                str = this.f2326a.g;
                a2 = lVar.a(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.s<String> bb = TiebaApplication.g().bb();
                if (bb != null) {
                    a2 = bb.a("dailyrecommend");
                    break;
                }
            default:
                a2 = null;
                break;
        }
        if (a2 != null) {
            if (this.c != 1 && this.b != null && this.b.b()) {
                if (this.b.c() == 0) {
                    if (this.c == 0) {
                        this.f2326a.b(a2);
                    }
                    return a(a2);
                }
            } else if (this.c == 1) {
                return a(a2);
            }
        }
        return null;
    }

    private com.baidu.tieba.data.o a(String str) {
        com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
        oVar.a(str);
        if (this.c == 0 && oVar.b().size() > 0) {
            oVar.b().get(0).a(true);
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.o oVar) {
        y yVar;
        y yVar2;
        com.baidu.tieba.data.o oVar2;
        y yVar3;
        com.baidu.tieba.data.o oVar3;
        boolean z;
        com.baidu.tieba.data.o oVar4;
        y yVar4;
        y yVar5;
        com.baidu.tieba.data.o oVar5;
        super.a((x) oVar);
        if (oVar == null) {
            yVar = this.f2326a.b;
            if (yVar != null) {
                if (this.c != 1) {
                    yVar3 = this.f2326a.b;
                    oVar3 = this.f2326a.c;
                    yVar3.a(false, this.b.c() + "", oVar3, this.c);
                    return;
                }
                yVar2 = this.f2326a.b;
                oVar2 = this.f2326a.c;
                yVar2.a(false, "db no data!", oVar2, this.c);
                return;
            }
            return;
        }
        if (this.c == 1) {
            this.f2326a.c = oVar;
            this.f2326a.f = true;
        } else {
            z = this.f2326a.f;
            if (z) {
                this.f2326a.c = new com.baidu.tieba.data.o();
                this.f2326a.f = false;
            }
            if (this.c == 0) {
                this.f2326a.c = oVar;
            } else {
                oVar4 = this.f2326a.c;
                oVar4.a(oVar);
            }
        }
        yVar4 = this.f2326a.b;
        if (yVar4 != null) {
            yVar5 = this.f2326a.b;
            oVar5 = this.f2326a.c;
            yVar5.a(true, null, oVar5, this.c);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }
}
