package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import d.b.c.e.d.l;
import d.b.i0.a3.j.f;
/* loaded from: classes4.dex */
public class SquareModel extends BdBaseModel<Object> {

    /* renamed from: e  reason: collision with root package name */
    public b f20961e;

    /* renamed from: f  reason: collision with root package name */
    public f f20962f;

    /* renamed from: g  reason: collision with root package name */
    public a f20963g;

    /* renamed from: h  reason: collision with root package name */
    public long f20964h;
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
        public int f20966b;

        /* renamed from: a  reason: collision with root package name */
        public d.b.i0.a3.g.a f20965a = null;

        /* renamed from: c  reason: collision with root package name */
        public l<String> f20967c = null;

        public b(int i) {
            this.f20966b = 1;
            this.f20966b = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar;
            this.f20965a = new d.b.i0.a3.g.a();
            l<String> g2 = d.b.h0.r.r.a.f().g("tb.square");
            this.f20967c = g2;
            String str = null;
            if (this.f20966b == 0) {
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
                this.f20966b = 1;
                str = str2;
                fVar = fVar2;
            } else {
                fVar = null;
            }
            if (this.f20966b == 1) {
                SquareModel.this.f20964h = System.currentTimeMillis();
                this.f20965a.a("prevtime", SquareModel.this.l + "");
                str = this.f20965a.i();
                SquareModel.this.i = this.f20965a.h();
                SquareModel.this.j = this.f20965a.g();
                SquareModel.this.k = System.currentTimeMillis();
            }
            if (this.f20965a.e()) {
                fVar = new f();
                fVar.j(str);
                Long valueOf = Long.valueOf(fVar.f());
                if (valueOf.longValue() > SquareModel.this.l) {
                    this.f20967c.e("square_cache_key", str, 86400000L);
                } else {
                    String str3 = this.f20967c.get("square_cache_key");
                    if (str3 != null) {
                        f fVar3 = new f();
                        fVar3.j(str3);
                        fVar3.m(fVar.e());
                        fVar3.n(valueOf.longValue());
                        this.f20967c.e("square_cache_key", fVar3.d(), 86400000L);
                        fVar = fVar3;
                    } else {
                        this.f20967c.e("square_cache_key", str, 86400000L);
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
            SquareModel.this.f20961e = null;
            SquareModel.this.f20962f = fVar;
            if (SquareModel.this.f20963g != null) {
                if (this.f20966b == 0 || this.f20965a.e()) {
                    SquareModel.this.f20963g.a(true, null, fVar);
                    return;
                }
                SquareModel.this.f20963g.a(false, this.f20965a.c(), fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.b.i0.a3.g.a aVar = this.f20965a;
            if (aVar != null) {
                aVar.b();
            }
            SquareModel.this.f20961e = null;
        }
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.f20961e = null;
        this.f20962f = null;
        this.f20963g = null;
        this.f20964h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.f20962f = new f();
    }

    public f B() {
        return this.f20962f;
    }

    public long C() {
        return this.k;
    }

    public long D() {
        return this.f20964h;
    }

    public long E() {
        return this.j;
    }

    public long F() {
        return this.i;
    }

    public boolean G(int i) {
        if (this.f20961e != null) {
            return false;
        }
        b bVar = new b(i);
        this.f20961e = bVar;
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
        this.f20963g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20961e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
