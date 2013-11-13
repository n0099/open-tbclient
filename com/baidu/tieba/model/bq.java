package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.aw> {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.a.i f1918a = null;
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
    public com.baidu.tieba.data.aw a(Object... objArr) {
        this.f1918a = new com.baidu.tieba.a.i();
        try {
            String a2 = this.f1918a.a(this.c.b, this.c.d, this.b, this.c.c, d());
            if (!this.f1918a.a()) {
                return null;
            }
            com.baidu.tieba.data.aw awVar = new com.baidu.tieba.data.aw();
            awVar.a(a2, this.c.e);
            String id = (awVar.m() == null || awVar.m().j() == null) ? null : awVar.m().j().getId();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= awVar.c().size()) {
                    return awVar;
                }
                awVar.c().get(i2).a(this.c.e, id.equals(awVar.c().get(i2).g().getId()));
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.toString());
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
        if (this.f1918a != null) {
            this.f1918a.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aw awVar) {
        this.c.g = null;
        if (awVar == null) {
            if (this.c.h != null) {
                this.c.h.a(false, this.f1918a.c(), this.f1918a.b(), null);
                return;
            }
            return;
        }
        if (awVar.a() != null) {
            this.c.c = awVar.a().d();
        }
        if (awVar.m() != null) {
            this.c.b = awVar.m().a();
        }
        if (this.b == 1) {
            this.c.f = awVar;
        } else if (this.b == 2) {
            this.c.f.b(awVar, true);
        } else if (this.b == 3) {
            this.c.f.a(awVar, false);
        } else {
            this.c.f.b(awVar, false);
        }
        if (this.c.h != null) {
            this.c.h.a(true, this.f1918a.c(), this.f1918a.b(), this.c.f);
        }
        this.f1918a = null;
    }
}
