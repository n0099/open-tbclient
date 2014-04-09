package com.baidu.tieba.pb.sub;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.am;
/* loaded from: classes.dex */
public final class g extends BdAsyncTask<Object, Integer, am> {
    protected a a = null;
    protected int b;
    final /* synthetic */ f c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ am a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(am amVar) {
        am amVar2 = amVar;
        this.c.g = null;
        if (amVar2 == null) {
            if (this.c.h != null) {
                this.c.h.a(false, this.a.c(), this.a.b(), null);
                return;
            }
            return;
        }
        if (amVar2.a() != null) {
            this.c.c = amVar2.a().d();
        }
        if (amVar2.l() != null) {
            this.c.b = amVar2.l().l();
        }
        if (this.b == 1) {
            this.c.f = amVar2;
        } else if (this.b == 2) {
            this.c.f.a(amVar2, true);
        } else if (this.b == 3) {
            this.c.f.a(amVar2);
        } else {
            this.c.f.a(amVar2, false);
        }
        if (this.c.h != null) {
            this.c.h.a(true, this.a.c(), this.a.b(), this.c.f);
        }
        this.a = null;
    }

    public g(f fVar, int i) {
        this.c = fVar;
        this.b = 0;
        this.b = i;
    }

    private am a() {
        this.a = new a();
        try {
            int f = this.c.f.f();
            if (f == 0) {
                f++;
            } else if (this.b == 0) {
                f++;
            } else if (this.b == 2 && this.c.f.c().size() % this.c.f.e() == 0) {
                f++;
            } else if (this.b == 3 && f > 0) {
                f = this.c.f.b() - 1;
            }
            String a = this.a.a(this.c.b, this.c.d, this.b, this.c.c, f);
            if (!this.a.a()) {
                return null;
            }
            am amVar = new am();
            amVar.a(a, this.c.e);
            String userId = (amVar.l() == null || amVar.l().t() == null) ? null : amVar.l().t().getUserId();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= amVar.c().size()) {
                    return amVar;
                }
                boolean equals = userId.equals(amVar.c().get(i2).g().getUserId());
                if (this.c.i == null) {
                    this.c.i = new ab(this.c.e);
                    this.c.i.a(true);
                }
                amVar.c().get(i2).a(this.c.e, equals, this.c.i);
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.c.g = null;
        if (this.a != null) {
            this.a.d();
        }
        if (this.c.i != null) {
            this.c.i.c();
            this.c.i = null;
        }
    }
}
