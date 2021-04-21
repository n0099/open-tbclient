package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import d.b.c.e.d.l;
import d.b.j0.a3.j.f;
/* loaded from: classes4.dex */
public class SquareModel extends BdBaseModel<Object> {

    /* renamed from: e  reason: collision with root package name */
    public b f20969e;

    /* renamed from: f  reason: collision with root package name */
    public f f20970f;

    /* renamed from: g  reason: collision with root package name */
    public a f20971g;

    /* renamed from: h  reason: collision with root package name */
    public long f20972h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, f, f> {

        /* renamed from: b  reason: collision with root package name */
        public int f20974b;

        /* renamed from: a  reason: collision with root package name */
        public d.b.j0.a3.g.a f20973a = null;

        /* renamed from: c  reason: collision with root package name */
        public l<String> f20975c = null;

        public b(int i) {
            this.f20974b = 1;
            this.f20974b = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar;
            this.f20973a = new d.b.j0.a3.g.a();
            l<String> g2 = d.b.i0.r.r.a.f().g("tb.square");
            this.f20975c = g2;
            String str = null;
            if (this.f20974b == 0) {
                String str2 = g2.get("square_cache_key");
                if (str2 == null) {
                    return null;
                }
                f fVar2 = new f();
                fVar2.j(str2);
                SquareModel.this.l = fVar2.f();
                if (fVar2.g()) {
                    SquareModel.this.l = 0L;
                }
                if (fVar2.c()) {
                    return fVar2;
                }
                this.f20974b = 1;
                str = str2;
                fVar = fVar2;
            } else {
                fVar = null;
            }
            if (this.f20974b == 1) {
                SquareModel.this.f20972h = System.currentTimeMillis();
                this.f20973a.a("prevtime", SquareModel.this.l + "");
                str = this.f20973a.i();
                SquareModel.this.i = this.f20973a.h();
                SquareModel.this.j = this.f20973a.g();
                SquareModel.this.k = System.currentTimeMillis();
            }
            if (this.f20973a.e()) {
                fVar = new f();
                fVar.j(str);
                Long valueOf = Long.valueOf(fVar.f());
                if (valueOf.longValue() > SquareModel.this.l) {
                    this.f20975c.e("square_cache_key", str, 86400000L);
                } else {
                    String str3 = this.f20975c.get("square_cache_key");
                    if (str3 != null) {
                        f fVar3 = new f();
                        fVar3.j(str3);
                        fVar3.m(fVar.e());
                        fVar3.n(valueOf.longValue());
                        this.f20975c.e("square_cache_key", fVar3.d(), 86400000L);
                        fVar = fVar3;
                    } else {
                        this.f20975c.e("square_cache_key", str, 86400000L);
                    }
                }
                SquareModel.this.l = valueOf.longValue();
            }
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            SquareModel.this.f20969e = null;
            SquareModel.this.f20970f = fVar;
            if (SquareModel.this.f20971g != null) {
                if (this.f20974b == 0 || this.f20973a.e()) {
                    SquareModel.this.f20971g.a(true, null, fVar);
                    return;
                }
                SquareModel.this.f20971g.a(false, this.f20973a.c(), fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.b.j0.a3.g.a aVar = this.f20973a;
            if (aVar != null) {
                aVar.b();
            }
            SquareModel.this.f20969e = null;
        }
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.f20969e = null;
        this.f20970f = null;
        this.f20971g = null;
        this.f20972h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.f20970f = new f();
    }

    public f B() {
        return this.f20970f;
    }

    public long C() {
        return this.k;
    }

    public long D() {
        return this.f20972h;
    }

    public long E() {
        return this.j;
    }

    public long F() {
        return this.i;
    }

    public boolean G(int i) {
        if (this.f20969e != null) {
            return false;
        }
        b bVar = new b(i);
        this.f20969e = bVar;
        bVar.execute(new Object[0]);
        return true;
    }

    public boolean H() {
        return G(0);
    }

    public boolean I() {
        return G(1);
    }

    public void J(a aVar) {
        this.f20971g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20969e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
