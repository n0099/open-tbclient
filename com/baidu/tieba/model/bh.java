package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.bd> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1419a;
    private com.baidu.tieba.a.j b = null;
    private int c;

    public bh(bg bgVar, int i) {
        this.f1419a = bgVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bd a(Object... objArr) {
        com.baidu.tieba.data.bd bdVar;
        com.baidu.tieba.data.bd bdVar2;
        com.baidu.tieba.data.bd bdVar3;
        String str;
        String str2;
        String str3;
        Context context;
        Context context2;
        this.b = new com.baidu.tieba.a.j();
        try {
            bdVar = this.f1419a.e;
            int f = bdVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                bdVar2 = this.f1419a.e;
                int size = bdVar2.b().size();
                bdVar3 = this.f1419a.e;
                if (size % bdVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.a.j jVar = this.b;
            str = this.f1419a.f1418a;
            str2 = this.f1419a.c;
            int i = this.c;
            str3 = this.f1419a.b;
            String a2 = jVar.a(str, str2, i, str3, f);
            if (!this.b.a()) {
                return null;
            }
            com.baidu.tieba.data.bd bdVar4 = new com.baidu.tieba.data.bd();
            context = this.f1419a.d;
            bdVar4.a(a2, context);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bdVar4.b().size()) {
                    return bdVar4;
                }
                context2 = this.f1419a.d;
                bdVar4.b().get(i3).a(context2);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1419a.f = null;
        if (this.b != null) {
            this.b.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bd bdVar) {
        com.baidu.tieba.data.bd bdVar2;
        com.baidu.tieba.data.bd bdVar3;
        bi biVar;
        bi biVar2;
        com.baidu.tieba.data.bd bdVar4;
        bi biVar3;
        bi biVar4;
        this.f1419a.f = null;
        if (bdVar == null) {
            biVar3 = this.f1419a.g;
            if (biVar3 != null) {
                biVar4 = this.f1419a.g;
                biVar4.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (bdVar.a() != null) {
            this.f1419a.b = bdVar.a().d();
        }
        if (bdVar.l() != null) {
            this.f1419a.f1418a = bdVar.l().a();
        }
        if (this.c == 1) {
            this.f1419a.e = bdVar;
        } else if (this.c == 2) {
            bdVar3 = this.f1419a.e;
            bdVar3.a(bdVar, true);
        } else {
            bdVar2 = this.f1419a.e;
            bdVar2.a(bdVar, false);
        }
        biVar = this.f1419a.g;
        if (biVar != null) {
            biVar2 = this.f1419a.g;
            int c = this.b.c();
            String b = this.b.b();
            bdVar4 = this.f1419a.e;
            biVar2.a(true, c, b, bdVar4);
        }
        this.b = null;
    }
}
