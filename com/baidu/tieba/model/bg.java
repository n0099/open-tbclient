package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bf f1350a;
    private com.baidu.tieba.a.i b = null;
    private int c;

    public bg(bf bfVar, int i) {
        this.f1350a = bfVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.bh a(Object... objArr) {
        com.baidu.tieba.data.bh bhVar;
        com.baidu.tieba.data.bh bhVar2;
        com.baidu.tieba.data.bh bhVar3;
        String str;
        String str2;
        String str3;
        Context context;
        Context context2;
        this.b = new com.baidu.tieba.a.i();
        try {
            bhVar = this.f1350a.e;
            int f = bhVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                bhVar2 = this.f1350a.e;
                int size = bhVar2.b().size();
                bhVar3 = this.f1350a.e;
                if (size % bhVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.a.i iVar = this.b;
            str = this.f1350a.f1349a;
            str2 = this.f1350a.c;
            int i = this.c;
            str3 = this.f1350a.b;
            String a2 = iVar.a(str, str2, i, str3, f);
            if (!this.b.a()) {
                return null;
            }
            com.baidu.tieba.data.bh bhVar4 = new com.baidu.tieba.data.bh();
            context = this.f1350a.d;
            bhVar4.a(a2, context);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bhVar4.b().size()) {
                    return bhVar4;
                }
                context2 = this.f1350a.d;
                ((com.baidu.tieba.data.aw) bhVar4.b().get(i3)).a(context2);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1350a.f = null;
        if (this.b != null) {
            this.b.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bh bhVar) {
        com.baidu.tieba.data.bh bhVar2;
        com.baidu.tieba.data.bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        com.baidu.tieba.data.bh bhVar6;
        bh bhVar7;
        bh bhVar8;
        this.f1350a.f = null;
        if (bhVar == null) {
            bhVar7 = this.f1350a.g;
            if (bhVar7 != null) {
                bhVar8 = this.f1350a.g;
                bhVar8.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (bhVar.a() != null) {
            this.f1350a.b = bhVar.a().d();
        }
        if (bhVar.l() != null) {
            this.f1350a.f1349a = bhVar.l().a();
        }
        if (this.c == 1) {
            this.f1350a.e = bhVar;
        } else if (this.c == 2) {
            bhVar3 = this.f1350a.e;
            bhVar3.a(bhVar, true);
        } else {
            bhVar2 = this.f1350a.e;
            bhVar2.a(bhVar, false);
        }
        bhVar4 = this.f1350a.g;
        if (bhVar4 != null) {
            bhVar5 = this.f1350a.g;
            int c = this.b.c();
            String b = this.b.b();
            bhVar6 = this.f1350a.e;
            bhVar5.a(true, c, b, bhVar6);
        }
        this.b = null;
    }
}
