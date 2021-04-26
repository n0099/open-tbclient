package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import d.a.c.e.p.j;
import d.a.j0.z2.c;
import d.a.j0.z2.d;
import d.a.j0.z2.e;
import d.a.j0.z2.h;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f21404e;

    /* renamed from: f  reason: collision with root package name */
    public h f21405f;

    /* renamed from: g  reason: collision with root package name */
    public a f21406g;

    /* renamed from: h  reason: collision with root package name */
    public c f21407h;

    /* renamed from: i  reason: collision with root package name */
    public String f21408i;
    public boolean isRunning;

    /* loaded from: classes5.dex */
    public interface a {
        void a(h hVar);

        void onNetError(String str);
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, h> {

        /* renamed from: a  reason: collision with root package name */
        public e f21409a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21410b = false;

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
                    this.f21409a = eVar;
                    eVar.d(SignAllForumModel.this.f21408i);
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
                        this.f21409a = eVar2;
                        eVar2.d(SignAllForumModel.this.f21408i);
                        if (j.z()) {
                            d(sb.toString());
                        }
                    }
                }
                return SignAllForumModel.this.f21405f;
            }
            return null;
        }

        public boolean c() {
            return this.f21410b;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.f21409a.a();
            this.f21409a = null;
            SignAllForumModel.this.f21404e = null;
            SignAllForumModel.this.isRunning = false;
        }

        public final h d(String str) {
            String e2 = this.f21409a.e(str);
            if (this.f21409a.c()) {
                SignAllForumModel.this.f21405f.i(e2);
                return SignAllForumModel.this.f21405f;
            }
            SignAllForumModel.this.f21405f = null;
            AuthTokenData.parse(e2);
            return null;
        }

        public final h e() {
            String f2 = this.f21409a.f();
            if (this.f21409a.c()) {
                SignAllForumModel.this.f21405f.i(f2);
                return SignAllForumModel.this.f21405f;
            }
            SignAllForumModel.this.f21405f = null;
            AuthTokenData.parse(f2);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(h hVar) {
            SignAllForumModel signAllForumModel = SignAllForumModel.this;
            signAllForumModel.isRunning = false;
            signAllForumModel.f21404e = null;
            if (SignAllForumModel.this.f21406g != null) {
                if (SignAllForumModel.this.f21405f != null) {
                    SignAllForumModel.this.f21406g.a(SignAllForumModel.this.f21405f);
                    return;
                }
                e eVar = this.f21409a;
                SignAllForumModel.this.f21406g.onNetError(eVar != null ? eVar.b() : null);
            }
        }

        public void g(boolean z) {
            this.f21410b = z;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SignAllForumModel.this.isRunning = true;
        }
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f21404e = null;
        this.f21405f = null;
        this.f21406g = null;
        this.f21405f = new h();
    }

    public void A(a aVar) {
        this.f21406g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f21404e != null) {
            return false;
        }
        this.f21404e = new b();
        boolean n = this.f21407h.n();
        String x = n ? null : x();
        this.f21404e.g(n);
        this.f21404e.execute(x);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f21404e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }

    public final String x() {
        ArrayList<d> x = this.f21407h.x();
        if (x == null) {
            return "";
        }
        if (!this.f21407h.B()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = x.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.i() < this.f21407h.l()) {
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
        return this.f21407h;
    }

    public void z(c cVar) {
        this.f21407h = cVar;
    }
}
