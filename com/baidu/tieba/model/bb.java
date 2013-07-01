package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1033a;
    private com.baidu.tieba.a.f b = null;
    private int c;

    public bb(ba baVar, int i) {
        this.f1033a = baVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.aw a(Object... objArr) {
        com.baidu.tieba.data.aw awVar;
        com.baidu.tieba.data.aw awVar2;
        com.baidu.tieba.data.aw awVar3;
        String str;
        String str2;
        String str3;
        Context context;
        Context context2;
        this.b = new com.baidu.tieba.a.f();
        try {
            awVar = this.f1033a.e;
            int f = awVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                awVar2 = this.f1033a.e;
                int size = awVar2.b().size();
                awVar3 = this.f1033a.e;
                if (size % awVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.a.f fVar = this.b;
            str = this.f1033a.f1032a;
            str2 = this.f1033a.c;
            int i = this.c;
            str3 = this.f1033a.b;
            String a2 = fVar.a(str, str2, i, str3, f);
            if (!this.b.a()) {
                return null;
            }
            com.baidu.tieba.data.aw awVar4 = new com.baidu.tieba.data.aw();
            context = this.f1033a.d;
            awVar4.a(a2, context);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= awVar4.b().size()) {
                    return awVar4;
                }
                context2 = this.f1033a.d;
                ((com.baidu.tieba.data.an) awVar4.b().get(i3)).a(context2);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1033a.f = null;
        if (this.b != null) {
            this.b.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aw awVar) {
        com.baidu.tieba.data.aw awVar2;
        com.baidu.tieba.data.aw awVar3;
        bc bcVar;
        bc bcVar2;
        com.baidu.tieba.data.aw awVar4;
        bc bcVar3;
        bc bcVar4;
        this.f1033a.f = null;
        if (awVar == null) {
            bcVar3 = this.f1033a.g;
            if (bcVar3 != null) {
                bcVar4 = this.f1033a.g;
                bcVar4.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (awVar.a() != null) {
            this.f1033a.b = awVar.a().d();
        }
        if (awVar.l() != null) {
            this.f1033a.f1032a = awVar.l().a();
        }
        if (this.c == 1) {
            this.f1033a.e = awVar;
        } else if (this.c == 2) {
            awVar3 = this.f1033a.e;
            awVar3.a(awVar, true);
        } else {
            awVar2 = this.f1033a.e;
            awVar2.a(awVar, false);
        }
        bcVar = this.f1033a.g;
        if (bcVar != null) {
            bcVar2 = this.f1033a.g;
            int c = this.b.c();
            String b = this.b.b();
            awVar4 = this.f1033a.e;
            bcVar2.a(true, c, b, awVar4);
        }
        this.b = null;
    }
}
