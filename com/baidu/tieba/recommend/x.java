package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, com.baidu.tieba.data.p> {
    final /* synthetic */ w a;
    private com.baidu.tieba.b.j b;
    private int c;
    private String d;

    public x(w wVar, int i, String str) {
        this.a = wVar;
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
        yVar = this.a.b;
        if (yVar != null) {
            yVar2 = this.a.b;
            yVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.p a(String... strArr) {
        String str;
        String a;
        switch (this.c) {
            case 0:
            case 2:
                this.b = new com.baidu.tieba.b.j(this.c == 0);
                com.baidu.tieba.b.j jVar = this.b;
                String str2 = this.d;
                str = this.a.g;
                a = jVar.a(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.s<String> bf = TiebaApplication.g().bf();
                if (bf != null) {
                    a = bf.a("dailyrecommend");
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

    private com.baidu.tieba.data.p a(String str) {
        com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
        pVar.a(str);
        if (this.c == 0 && pVar.b().size() > 0) {
            pVar.b().get(0).a(true);
        }
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.p pVar) {
        y yVar;
        y yVar2;
        com.baidu.tieba.data.p pVar2;
        y yVar3;
        com.baidu.tieba.data.p pVar3;
        boolean z;
        com.baidu.tieba.data.p pVar4;
        y yVar4;
        y yVar5;
        com.baidu.tieba.data.p pVar5;
        super.a((x) pVar);
        if (pVar == null) {
            yVar = this.a.b;
            if (yVar != null) {
                if (this.c != 1) {
                    yVar3 = this.a.b;
                    String sb = new StringBuilder(String.valueOf(this.b.c())).toString();
                    pVar3 = this.a.c;
                    yVar3.a(false, sb, pVar3, this.c);
                    return;
                }
                yVar2 = this.a.b;
                pVar2 = this.a.c;
                yVar2.a(false, "db no data!", pVar2, this.c);
                return;
            }
            return;
        }
        if (this.c == 1) {
            this.a.c = pVar;
            this.a.f = true;
        } else {
            z = this.a.f;
            if (z) {
                this.a.c = new com.baidu.tieba.data.p();
                this.a.f = false;
            }
            if (this.c == 0) {
                this.a.c = pVar;
            } else {
                pVar4 = this.a.c;
                pVar4.a(pVar);
            }
        }
        yVar4 = this.a.b;
        if (yVar4 != null) {
            yVar5 = this.a.b;
            pVar5 = this.a.c;
            yVar5.a(true, null, pVar5, this.c);
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
