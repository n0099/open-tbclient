package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1682a;
    private au b;
    private int c;
    private String d;

    public x(w wVar, int i, String str) {
        this.f1682a = wVar;
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
        yVar = this.f1682a.f1681a;
        if (yVar != null) {
            yVar2 = this.f1682a.f1681a;
            yVar2.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.n a(String... strArr) {
        String a2;
        switch (this.c) {
            case 0:
            case 2:
                this.b = new au(this.c == 0);
                a2 = this.b.a(this.d);
                break;
            case 1:
                com.baidu.adp.lib.cache.q bm = TiebaApplication.f().bm();
                if (bm != null) {
                    a2 = (String) bm.a("dailyrecommend");
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
                        this.f1682a.b(a2);
                    }
                    return a(a2);
                }
            } else if (this.c == 1) {
                return a(a2);
            }
        }
        return null;
    }

    private com.baidu.tieba.data.n a(String str) {
        com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
        nVar.a(str);
        if (this.c == 0 && nVar.b().size() > 0) {
            ((com.baidu.tieba.data.p) nVar.b().get(0)).a(true);
        }
        return nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.n nVar) {
        y yVar;
        y yVar2;
        com.baidu.tieba.data.n nVar2;
        y yVar3;
        com.baidu.tieba.data.n nVar3;
        boolean z;
        com.baidu.tieba.data.n nVar4;
        Context context;
        y yVar4;
        y yVar5;
        com.baidu.tieba.data.n nVar5;
        super.a((Object) nVar);
        if (nVar == null) {
            yVar = this.f1682a.f1681a;
            if (yVar != null) {
                if (this.c != 1) {
                    yVar3 = this.f1682a.f1681a;
                    String sb = new StringBuilder(String.valueOf(this.b.c())).toString();
                    nVar3 = this.f1682a.b;
                    yVar3.a(false, sb, nVar3, this.c);
                    return;
                }
                yVar2 = this.f1682a.f1681a;
                nVar2 = this.f1682a.b;
                yVar2.a(false, "db no data!", nVar2, this.c);
                return;
            }
            return;
        }
        if (this.c == 1) {
            this.f1682a.b = nVar;
            this.f1682a.e = true;
        } else {
            z = this.f1682a.e;
            if (z) {
                this.f1682a.b = new com.baidu.tieba.data.n();
                this.f1682a.e = false;
            }
            if (this.c == 0) {
                this.f1682a.b = nVar;
                TiebaApplication f = TiebaApplication.f();
                ArrayList b = nVar.b();
                if (b.size() > 0) {
                    f.p(((com.baidu.tieba.data.p) b.get(0)).d());
                    f.w(false);
                    context = this.f1682a.f;
                    context.sendBroadcast(new Intent("com.baidu.tieba.broadcast.newrecommends"));
                }
            } else {
                nVar4 = this.f1682a.b;
                nVar4.a(nVar);
            }
        }
        yVar4 = this.f1682a.f1681a;
        if (yVar4 != null) {
            yVar5 = this.f1682a.f1681a;
            nVar5 = this.f1682a.b;
            yVar5.a(true, null, nVar5, this.c);
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
