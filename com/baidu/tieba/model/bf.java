package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public final class bf extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.av> {
    protected com.baidu.tieba.b.g a = null;
    protected int b;
    final /* synthetic */ be c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.av a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.av avVar) {
        com.baidu.tieba.data.av avVar2 = avVar;
        this.c.g = null;
        if (avVar2 == null) {
            if (this.c.h != null) {
                this.c.h.a(false, this.a.c(), this.a.b(), null);
                return;
            }
            return;
        }
        if (avVar2.a() != null) {
            this.c.c = avVar2.a().d();
        }
        if (avVar2.l() != null) {
            this.c.b = avVar2.l().a();
        }
        if (this.b == 1) {
            this.c.f = avVar2;
        } else if (this.b == 2) {
            this.c.f.a(avVar2, true);
        } else if (this.b == 3) {
            this.c.f.a(avVar2);
        } else {
            this.c.f.a(avVar2, false);
        }
        if (this.c.h != null) {
            this.c.h.a(true, this.a.c(), this.a.b(), this.c.f);
        }
        this.a = null;
    }

    public bf(be beVar, int i) {
        this.c = beVar;
        this.b = 0;
        this.b = i;
    }

    private com.baidu.tieba.data.av d() {
        this.a = new com.baidu.tieba.b.g();
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
            com.baidu.tieba.data.av avVar = new com.baidu.tieba.data.av();
            avVar.a(a, this.c.e);
            String userId = (avVar.l() == null || avVar.l().i() == null) ? null : avVar.l().i().getUserId();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= avVar.c().size()) {
                    return avVar;
                }
                boolean equals = userId.equals(avVar.c().get(i2).g().getUserId());
                if (this.c.i == null) {
                    this.c.i = new com.baidu.tieba.util.i(this.c.e);
                    this.c.i.a(true);
                }
                avVar.c().get(i2).a(this.c.e, equals, this.c.i);
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.toString());
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
