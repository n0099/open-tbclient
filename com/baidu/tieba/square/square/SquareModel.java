package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import d.a.c.e.d.l;
import d.a.j0.a3.j.f;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {

    /* renamed from: e  reason: collision with root package name */
    public b f21544e;

    /* renamed from: f  reason: collision with root package name */
    public f f21545f;

    /* renamed from: g  reason: collision with root package name */
    public a f21546g;

    /* renamed from: h  reason: collision with root package name */
    public long f21547h;

    /* renamed from: i  reason: collision with root package name */
    public long f21548i;
    public long j;
    public long k;
    public long l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {

        /* renamed from: b  reason: collision with root package name */
        public int f21550b;

        /* renamed from: a  reason: collision with root package name */
        public d.a.j0.a3.g.a f21549a = null;

        /* renamed from: c  reason: collision with root package name */
        public l<String> f21551c = null;

        public b(int i2) {
            this.f21550b = 1;
            this.f21550b = i2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar;
            this.f21549a = new d.a.j0.a3.g.a();
            l<String> g2 = d.a.i0.r.r.a.f().g("tb.square");
            this.f21551c = g2;
            String str = null;
            if (this.f21550b == 0) {
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
                this.f21550b = 1;
                str = str2;
                fVar = fVar2;
            } else {
                fVar = null;
            }
            if (this.f21550b == 1) {
                SquareModel.this.f21547h = System.currentTimeMillis();
                this.f21549a.a("prevtime", SquareModel.this.l + "");
                str = this.f21549a.i();
                SquareModel.this.f21548i = this.f21549a.h();
                SquareModel.this.j = this.f21549a.g();
                SquareModel.this.k = System.currentTimeMillis();
            }
            if (this.f21549a.e()) {
                fVar = new f();
                fVar.j(str);
                Long valueOf = Long.valueOf(fVar.f());
                if (valueOf.longValue() > SquareModel.this.l) {
                    this.f21551c.e("square_cache_key", str, 86400000L);
                } else {
                    String str3 = this.f21551c.get("square_cache_key");
                    if (str3 != null) {
                        f fVar3 = new f();
                        fVar3.j(str3);
                        fVar3.m(fVar.e());
                        fVar3.n(valueOf.longValue());
                        this.f21551c.e("square_cache_key", fVar3.d(), 86400000L);
                        fVar = fVar3;
                    } else {
                        this.f21551c.e("square_cache_key", str, 86400000L);
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
            SquareModel.this.f21544e = null;
            SquareModel.this.f21545f = fVar;
            if (SquareModel.this.f21546g != null) {
                if (this.f21550b == 0 || this.f21549a.e()) {
                    SquareModel.this.f21546g.a(true, null, fVar);
                    return;
                }
                SquareModel.this.f21546g.a(false, this.f21549a.c(), fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.a.j0.a3.g.a aVar = this.f21549a;
            if (aVar != null) {
                aVar.b();
            }
            SquareModel.this.f21544e = null;
        }
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.f21544e = null;
        this.f21545f = null;
        this.f21546g = null;
        this.f21547h = 0L;
        this.f21548i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.f21545f = new f();
    }

    public f B() {
        return this.f21545f;
    }

    public long C() {
        return this.k;
    }

    public long D() {
        return this.f21547h;
    }

    public long E() {
        return this.j;
    }

    public long F() {
        return this.f21548i;
    }

    public boolean G(int i2) {
        if (this.f21544e != null) {
            return false;
        }
        b bVar = new b(i2);
        this.f21544e = bVar;
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
        this.f21546g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f21544e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
