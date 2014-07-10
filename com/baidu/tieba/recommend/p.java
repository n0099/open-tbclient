package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, com.baidu.tieba.data.l> {
    final /* synthetic */ o a;
    private com.baidu.tieba.a.f b;
    private int c;
    private String d;

    public p(o oVar, int i, String str) {
        this.a = oVar;
        this.c = i;
        this.d = str;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        q qVar;
        q qVar2;
        super.onPreExecute();
        qVar = this.a.b;
        if (qVar != null) {
            qVar2 = this.a.b;
            qVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.l doInBackground(String... strArr) {
        String str;
        String a;
        switch (this.c) {
            case 0:
            case 2:
                this.b = new com.baidu.tieba.a.f(this.c == 0);
                com.baidu.tieba.a.f fVar = this.b;
                String str2 = this.d;
                str = this.a.g;
                a = fVar.a(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.s<String> H = ai.c().H();
                if (H != null) {
                    a = H.a("dailyrecommend");
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

    private com.baidu.tieba.data.l a(String str) {
        com.baidu.tieba.data.l lVar = new com.baidu.tieba.data.l();
        lVar.a(str);
        if (this.c == 0 && lVar.a().size() > 0) {
            lVar.a().get(0).a(true);
        }
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.l lVar) {
        q qVar;
        q qVar2;
        com.baidu.tieba.data.l lVar2;
        q qVar3;
        com.baidu.tieba.data.l lVar3;
        boolean z;
        com.baidu.tieba.data.l lVar4;
        q qVar4;
        q qVar5;
        com.baidu.tieba.data.l lVar5;
        super.onPostExecute(lVar);
        if (lVar == null) {
            qVar = this.a.b;
            if (qVar != null) {
                if (this.c != 1) {
                    qVar3 = this.a.b;
                    String sb = new StringBuilder(String.valueOf(this.b.c())).toString();
                    lVar3 = this.a.c;
                    qVar3.a(false, sb, lVar3, this.c);
                    return;
                }
                qVar2 = this.a.b;
                lVar2 = this.a.c;
                qVar2.a(false, "db no data!", lVar2, this.c);
                return;
            }
            return;
        }
        if (this.c == 1) {
            this.a.c = lVar;
            this.a.f = true;
        } else {
            z = this.a.f;
            if (z) {
                this.a.c = new com.baidu.tieba.data.l();
                this.a.f = false;
            }
            if (this.c == 0) {
                this.a.c = lVar;
            } else {
                lVar4 = this.a.c;
                lVar4.a(lVar);
            }
        }
        qVar4 = this.a.b;
        if (qVar4 != null) {
            qVar5 = this.a.b;
            lVar5 = this.a.c;
            qVar5.a(true, null, lVar5, this.c);
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
