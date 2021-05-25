package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import d.a.c.e.p.j;
import d.a.n0.a3.c;
import d.a.n0.a3.d;
import d.a.n0.a3.e;
import d.a.n0.a3.h;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f20568e;

    /* renamed from: f  reason: collision with root package name */
    public h f20569f;

    /* renamed from: g  reason: collision with root package name */
    public a f20570g;

    /* renamed from: h  reason: collision with root package name */
    public c f20571h;

    /* renamed from: i  reason: collision with root package name */
    public String f20572i;
    public boolean isRunning;

    /* loaded from: classes5.dex */
    public interface a {
        void a(h hVar);

        void onNetError(String str);
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, h> {

        /* renamed from: a  reason: collision with root package name */
        public e f20573a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20574b = false;

        public b() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public h doInBackground(String... strArr) {
            int i2;
            if (c() || !(strArr == null || strArr.length == 0 || strArr[0] == null)) {
                if (c()) {
                    e eVar = new e();
                    this.f20573a = eVar;
                    eVar.d(SignAllForumModel.this.f20572i);
                    if (j.z()) {
                        e();
                    }
                } else {
                    String[] split = strArr[0].split(",");
                    int ceil = (int) Math.ceil(split.length / 50.0f);
                    for (int i3 = 0; i3 < ceil; i3++) {
                        int i4 = i3 * 50;
                        StringBuilder sb = new StringBuilder();
                        for (int i5 = 0; i5 < 50 && (i2 = i4 + i5) < split.length; i5++) {
                            if (i2 == split.length - 1) {
                                sb.append(split[i2]);
                            } else {
                                sb.append(split[i2] + ",");
                            }
                        }
                        e eVar2 = new e();
                        this.f20573a = eVar2;
                        eVar2.d(SignAllForumModel.this.f20572i);
                        if (j.z()) {
                            d(sb.toString());
                        }
                    }
                }
                return SignAllForumModel.this.f20569f;
            }
            return null;
        }

        public boolean c() {
            return this.f20574b;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.f20573a.a();
            this.f20573a = null;
            SignAllForumModel.this.f20568e = null;
            SignAllForumModel.this.isRunning = false;
        }

        public final h d(String str) {
            String e2 = this.f20573a.e(str);
            if (this.f20573a.c()) {
                SignAllForumModel.this.f20569f.i(e2);
                return SignAllForumModel.this.f20569f;
            }
            SignAllForumModel.this.f20569f = null;
            AuthTokenData.parse(e2);
            return null;
        }

        public final h e() {
            String f2 = this.f20573a.f();
            if (this.f20573a.c()) {
                SignAllForumModel.this.f20569f.i(f2);
                return SignAllForumModel.this.f20569f;
            }
            SignAllForumModel.this.f20569f = null;
            AuthTokenData.parse(f2);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(h hVar) {
            SignAllForumModel signAllForumModel = SignAllForumModel.this;
            signAllForumModel.isRunning = false;
            signAllForumModel.f20568e = null;
            if (SignAllForumModel.this.f20570g != null) {
                if (SignAllForumModel.this.f20569f != null) {
                    SignAllForumModel.this.f20570g.a(SignAllForumModel.this.f20569f);
                    return;
                }
                e eVar = this.f20573a;
                SignAllForumModel.this.f20570g.onNetError(eVar != null ? eVar.b() : null);
            }
        }

        public void g(boolean z) {
            this.f20574b = z;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SignAllForumModel.this.isRunning = true;
        }
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f20568e = null;
        this.f20569f = null;
        this.f20570g = null;
        this.f20569f = new h();
    }

    public void A(a aVar) {
        this.f20570g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f20568e != null) {
            return false;
        }
        this.f20568e = new b();
        boolean n = this.f20571h.n();
        String x = n ? null : x();
        this.f20568e.g(n);
        this.f20568e.execute(x);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20568e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }

    public final String x() {
        ArrayList<d> x = this.f20571h.x();
        if (x == null) {
            return "";
        }
        if (!this.f20571h.B()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = x.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.i() < this.f20571h.l()) {
                    arrayList.add(next);
                }
            }
            x.removeAll(arrayList);
        }
        int size = x.size();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = x.get(i2);
            if (dVar.j()) {
                if (!dVar.k()) {
                    dVar.t(true);
                }
            }
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(dVar.c());
        }
        return sb.toString();
    }

    public c y() {
        return this.f20571h;
    }

    public void z(c cVar) {
        this.f20571h = cVar;
    }
}
