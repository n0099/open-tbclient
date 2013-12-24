package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.av> {
    protected com.baidu.tieba.a.g a = null;
    protected int b;
    final /* synthetic */ bp c;

    public bq(bp bpVar, int i) {
        this.c = bpVar;
        this.b = 0;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.av a(Object... objArr) {
        this.a = new com.baidu.tieba.a.g();
        try {
            String a = this.a.a(this.c.b, this.c.d, this.b, this.c.c, d());
            if (!this.a.a()) {
                return null;
            }
            com.baidu.tieba.data.av avVar = new com.baidu.tieba.data.av();
            avVar.a(a, this.c.e);
            String id = (avVar.m() == null || avVar.m().j() == null) ? null : avVar.m().j().getId();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= avVar.c().size()) {
                    return avVar;
                }
                avVar.c().get(i2).a(this.c.e, id.equals(avVar.c().get(i2).g().getId()));
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    protected int d() {
        int g = this.c.f.g();
        if (g == 0) {
            return g + 1;
        }
        if (this.b == 0) {
            return g + 1;
        }
        if (this.b == 2 && this.c.f.c().size() % this.c.f.f() == 0) {
            return g + 1;
        }
        if (this.b == 3 && g > 0) {
            return this.c.f.b() - 1;
        }
        return g;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.c.g = null;
        if (this.a != null) {
            this.a.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.av avVar) {
        this.c.g = null;
        if (avVar == null) {
            if (this.c.h != null) {
                this.c.h.a(false, this.a.c(), this.a.b(), null);
                return;
            }
            return;
        }
        if (avVar.a() != null) {
            this.c.c = avVar.a().d();
        }
        if (avVar.m() != null) {
            this.c.b = avVar.m().a();
        }
        if (this.b == 1) {
            this.c.f = avVar;
        } else if (this.b == 2) {
            this.c.f.b(avVar, true);
        } else if (this.b == 3) {
            this.c.f.a(avVar, false);
        } else {
            this.c.f.b(avVar, false);
        }
        if (this.c.h != null) {
            this.c.h.a(true, this.a.c(), this.a.b(), this.c.f);
        }
        this.a = null;
    }
}
