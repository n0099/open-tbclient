package com.baidu.tieba.square.square;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import d.a.c.e.d.l;
import d.a.o0.b3.j.f;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {

    /* renamed from: e  reason: collision with root package name */
    public b f20867e;

    /* renamed from: f  reason: collision with root package name */
    public f f20868f;

    /* renamed from: g  reason: collision with root package name */
    public a f20869g;

    /* renamed from: h  reason: collision with root package name */
    public long f20870h;

    /* renamed from: i  reason: collision with root package name */
    public long f20871i;
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
        public int f20873b;

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.b3.g.a f20872a = null;

        /* renamed from: c  reason: collision with root package name */
        public l<String> f20874c = null;

        public b(int i2) {
            this.f20873b = 1;
            this.f20873b = i2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar;
            this.f20872a = new d.a.o0.b3.g.a();
            l<String> g2 = d.a.n0.r.r.a.f().g("tb.square");
            this.f20874c = g2;
            String str = null;
            if (this.f20873b == 0) {
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
                this.f20873b = 1;
                str = str2;
                fVar = fVar2;
            } else {
                fVar = null;
            }
            if (this.f20873b == 1) {
                SquareModel.this.f20870h = System.currentTimeMillis();
                this.f20872a.a("prevtime", SquareModel.this.l + "");
                str = this.f20872a.i();
                SquareModel.this.f20871i = this.f20872a.h();
                SquareModel.this.j = this.f20872a.g();
                SquareModel.this.k = System.currentTimeMillis();
            }
            if (this.f20872a.e()) {
                fVar = new f();
                fVar.j(str);
                Long valueOf = Long.valueOf(fVar.f());
                if (valueOf.longValue() > SquareModel.this.l) {
                    this.f20874c.e("square_cache_key", str, 86400000L);
                } else {
                    String str3 = this.f20874c.get("square_cache_key");
                    if (str3 != null) {
                        f fVar3 = new f();
                        fVar3.j(str3);
                        fVar3.m(fVar.e());
                        fVar3.n(valueOf.longValue());
                        this.f20874c.e("square_cache_key", fVar3.d(), 86400000L);
                        fVar = fVar3;
                    } else {
                        this.f20874c.e("square_cache_key", str, 86400000L);
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
            SquareModel.this.f20867e = null;
            SquareModel.this.f20868f = fVar;
            if (SquareModel.this.f20869g != null) {
                if (this.f20873b == 0 || this.f20872a.e()) {
                    SquareModel.this.f20869g.a(true, null, fVar);
                    return;
                }
                SquareModel.this.f20869g.a(false, this.f20872a.c(), fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.a.o0.b3.g.a aVar = this.f20872a;
            if (aVar != null) {
                aVar.b();
            }
            SquareModel.this.f20867e = null;
        }
    }

    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        this.f20867e = null;
        this.f20868f = null;
        this.f20869g = null;
        this.f20870h = 0L;
        this.f20871i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.f20868f = new f();
    }

    public f F() {
        return this.f20868f;
    }

    public long G() {
        return this.k;
    }

    public long H() {
        return this.f20870h;
    }

    public long I() {
        return this.j;
    }

    public long J() {
        return this.f20871i;
    }

    public boolean K(int i2) {
        if (this.f20867e != null) {
            return false;
        }
        b bVar = new b(i2);
        this.f20867e = bVar;
        bVar.execute(new Object[0]);
        return true;
    }

    public boolean L() {
        return K(0);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public boolean M() {
        return K(1);
    }

    public void N(a aVar) {
        this.f20869g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20867e;
        if (bVar != null) {
            bVar.cancel();
            return false;
        }
        return false;
    }
}
