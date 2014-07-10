package com.baidu.tieba.pb.sub;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.data.at;
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, at> {
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
    public at doInBackground(Object... objArr) {
        this.a = new a();
        try {
            String a = this.a.a(this.c.b, this.c.d, this.b, this.c.c, a());
            if (!this.a.a()) {
                return null;
            }
            at atVar = new at();
            atVar.a(a, this.c.e);
            String userId = (atVar.m() == null || atVar.m().y() == null) ? null : atVar.m().y().getUserId();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= atVar.c().size()) {
                    return atVar;
                }
                boolean equals = userId.equals(atVar.c().get(i2).o().getUserId());
                if (this.c.i == null) {
                    this.c.i = new aa(this.c.e);
                    this.c.i.b(true);
                }
                atVar.c().get(i2).a(this.c.e, equals, this.c.i);
                i = i2 + 1;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
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
            this.a.e();
        }
        if (this.c.i != null) {
            this.c.i.d();
            this.c.i = null;
        }
        this.c.m();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(at atVar) {
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        this.c.g = null;
        if (this.a != null) {
            boolean a = this.a.a();
            int d = this.a.d();
            String b = this.a.b();
            int c = this.a.c();
            aVar = this.c.j;
            if (aVar != null) {
                aVar2 = this.c.j;
                aVar2.a(true, a, d, b, c);
                this.c.j = null;
            }
        }
        if (atVar == null) {
            if (this.c.h != null) {
                this.c.h.a(false, this.a.d(), this.a.b(), null);
                return;
            }
            return;
        }
        if (atVar.a() != null) {
            this.c.c = atVar.a().l();
        }
        if (atVar.m() != null) {
            this.c.b = atVar.m().p();
        }
        if (this.b == 1) {
            this.c.f = atVar;
        } else if (this.b == 2) {
            this.c.f.b(atVar, true);
        } else if (this.b == 3) {
            this.c.f.a(atVar, false);
        } else {
            this.c.f.b(atVar, false);
        }
        if (this.c.h != null) {
            this.c.h.a(true, this.a.d(), this.a.b(), this.c.f);
        }
        this.a = null;
    }
}
