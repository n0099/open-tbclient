package com.baidu.tieba.pb.sub;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.ap;
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, ap> {
    protected a a = null;
    protected int b;
    final /* synthetic */ f c;

    public g(f fVar, int i) {
        this.c = fVar;
        this.b = 0;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ap doInBackground(Object... objArr) {
        this.a = new a();
        try {
            String a = this.a.a(this.c.b, this.c.d, this.b, this.c.c, a());
            if (!this.a.a()) {
                return null;
            }
            ap apVar = new ap();
            apVar.a(a, this.c.e);
            String userId = (apVar.m() == null || apVar.m().y() == null) ? null : apVar.m().y().getUserId();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= apVar.c().size()) {
                    return apVar;
                }
                boolean equals = userId.equals(apVar.c().get(i2).o().getUserId());
                if (this.c.i == null) {
                    this.c.i = new ab(this.c.e);
                    this.c.i.d(true);
                }
                apVar.c().get(i2).a(this.c.e, equals, this.c.i);
                i = i2 + 1;
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    protected int a() {
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
        if (this.c.i != null) {
            this.c.i.d();
            this.c.i = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ap apVar) {
        this.c.g = null;
        if (apVar == null) {
            if (this.c.h != null) {
                this.c.h.a(false, this.a.c(), this.a.b(), null);
                return;
            }
            return;
        }
        if (apVar.a() != null) {
            this.c.c = apVar.a().l();
        }
        if (apVar.m() != null) {
            this.c.b = apVar.m().p();
        }
        if (this.b == 1) {
            this.c.f = apVar;
        } else if (this.b == 2) {
            this.c.f.b(apVar, true);
        } else if (this.b == 3) {
            this.c.f.a(apVar, false);
        } else {
            this.c.f.b(apVar, false);
        }
        if (this.c.h != null) {
            this.c.h.a(true, this.a.c(), this.a.b(), this.c.f);
        }
        this.a = null;
    }
}
