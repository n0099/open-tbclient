package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, com.baidu.tieba.data.o> {
    final /* synthetic */ v a;
    private com.baidu.tieba.a.j b;
    private int c;
    private String d;

    public w(v vVar, int i, String str) {
        this.a = vVar;
        this.c = i;
        this.d = str;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        x xVar;
        x xVar2;
        super.b();
        xVar = this.a.b;
        if (xVar != null) {
            xVar2 = this.a.b;
            xVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.o a(String... strArr) {
        String str;
        String a;
        switch (this.c) {
            case 0:
            case 2:
                this.b = new com.baidu.tieba.a.j(this.c == 0);
                com.baidu.tieba.a.j jVar = this.b;
                String str2 = this.d;
                str = this.a.g;
                a = jVar.a(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.s<String> bi = TiebaApplication.h().bi();
                if (bi != null) {
                    a = bi.a("dailyrecommend");
                    break;
                }
            default:
                a = null;
                break;
        }
        if (a != null) {
            if (this.c != 1 && this.b != null && this.b.b()) {
                if (this.b.c() == 0) {
                    if (this.c == 0) {
                        this.a.b(a);
                    }
                    return a(a);
                }
            } else if (this.c == 1) {
                return a(a);
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
        x xVar;
        x xVar2;
        com.baidu.tieba.data.o oVar2;
        x xVar3;
        com.baidu.tieba.data.o oVar3;
        boolean z;
        com.baidu.tieba.data.o oVar4;
        x xVar4;
        x xVar5;
        com.baidu.tieba.data.o oVar5;
        super.a((w) oVar);
        if (oVar == null) {
            xVar = this.a.b;
            if (xVar != null) {
                if (this.c != 1) {
                    xVar3 = this.a.b;
                    oVar3 = this.a.c;
                    xVar3.a(false, this.b.c() + "", oVar3, this.c);
                    return;
                }
                xVar2 = this.a.b;
                oVar2 = this.a.c;
                xVar2.a(false, "db no data!", oVar2, this.c);
                return;
            }
            return;
        }
        if (this.c == 1) {
            this.a.c = oVar;
            this.a.f = true;
        } else {
            z = this.a.f;
            if (z) {
                this.a.c = new com.baidu.tieba.data.o();
                this.a.f = false;
            }
            if (this.c == 0) {
                this.a.c = oVar;
            } else {
                oVar4 = this.a.c;
                oVar4.a(oVar);
            }
        }
        xVar4 = this.a.b;
        if (xVar4 != null) {
            xVar5 = this.a.b;
            oVar5 = this.a.c;
            xVar5.a(true, null, oVar5, this.c);
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
