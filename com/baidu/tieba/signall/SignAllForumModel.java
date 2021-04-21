package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import d.b.c.e.p.j;
import d.b.j0.z2.c;
import d.b.j0.z2.d;
import d.b.j0.z2.e;
import d.b.j0.z2.h;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f20842e;

    /* renamed from: f  reason: collision with root package name */
    public h f20843f;

    /* renamed from: g  reason: collision with root package name */
    public a f20844g;

    /* renamed from: h  reason: collision with root package name */
    public c f20845h;
    public String i;
    public boolean isRunning;

    /* loaded from: classes4.dex */
    public interface a {
        void a(h hVar);

        void onNetError(String str);
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Integer, h> {

        /* renamed from: a  reason: collision with root package name */
        public e f20846a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20847b = false;

        public b() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public h doInBackground(String... strArr) {
            int i;
            if (c() || !(strArr == null || strArr.length == 0 || strArr[0] == null)) {
                if (c()) {
                    e eVar = new e();
                    this.f20846a = eVar;
                    eVar.d(SignAllForumModel.this.i);
                    if (j.z()) {
                        e();
                    }
                } else {
                    String[] split = strArr[0].split(",");
                    int ceil = (int) Math.ceil(split.length / 50.0f);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        int i3 = i2 * 50;
                        StringBuilder sb = new StringBuilder();
                        for (int i4 = 0; i4 < 50 && (i = i3 + i4) < split.length; i4++) {
                            if (i == split.length - 1) {
                                sb.append(split[i]);
                            } else {
                                sb.append(split[i] + ",");
                            }
                        }
                        e eVar2 = new e();
                        this.f20846a = eVar2;
                        eVar2.d(SignAllForumModel.this.i);
                        if (j.z()) {
                            d(sb.toString());
                        }
                    }
                }
                return SignAllForumModel.this.f20843f;
            }
            return null;
        }

        public boolean c() {
            return this.f20847b;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            this.f20846a.a();
            this.f20846a = null;
            SignAllForumModel.this.f20842e = null;
            SignAllForumModel.this.isRunning = false;
        }

        public final h d(String str) {
            String e2 = this.f20846a.e(str);
            if (this.f20846a.c()) {
                SignAllForumModel.this.f20843f.i(e2);
                return SignAllForumModel.this.f20843f;
            }
            SignAllForumModel.this.f20843f = null;
            AuthTokenData.parse(e2);
            return null;
        }

        public final h e() {
            String f2 = this.f20846a.f();
            if (this.f20846a.c()) {
                SignAllForumModel.this.f20843f.i(f2);
                return SignAllForumModel.this.f20843f;
            }
            SignAllForumModel.this.f20843f = null;
            AuthTokenData.parse(f2);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(h hVar) {
            SignAllForumModel signAllForumModel = SignAllForumModel.this;
            signAllForumModel.isRunning = false;
            signAllForumModel.f20842e = null;
            if (SignAllForumModel.this.f20844g != null) {
                if (SignAllForumModel.this.f20843f != null) {
                    SignAllForumModel.this.f20844g.a(SignAllForumModel.this.f20843f);
                    return;
                }
                e eVar = this.f20846a;
                SignAllForumModel.this.f20844g.onNetError(eVar != null ? eVar.b() : null);
            }
        }

        public void g(boolean z) {
            this.f20847b = z;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            SignAllForumModel.this.isRunning = true;
        }
    }

    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f20842e = null;
        this.f20843f = null;
        this.f20844g = null;
        this.f20843f = new h();
    }

    public void A(a aVar) {
        this.f20844g = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f20842e != null) {
            return false;
        }
        this.f20842e = new b();
        boolean n = this.f20845h.n();
        String x = n ? null : x();
        this.f20842e.g(n);
        this.f20842e.execute(x);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        b bVar = this.f20842e;
        if (bVar != null) {
            bVar.cancel();
            return true;
        }
        return false;
    }

    public final String x() {
        ArrayList<d> x = this.f20845h.x();
        if (x == null) {
            return "";
        }
        if (!this.f20845h.B()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = x.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.i() < this.f20845h.l()) {
                    arrayList.add(next);
                }
            }
            x.removeAll(arrayList);
        }
        int size = x.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = x.get(i);
            if (dVar.j()) {
                if (!dVar.k()) {
                    dVar.t(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(dVar.c());
        }
        return sb.toString();
    }

    public c y() {
        return this.f20845h;
    }

    public void z(c cVar) {
        this.f20845h = cVar;
    }
}
