package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.n0.e2.h.e;
import d.a.n0.e2.h.t;
import d.a.n0.e2.k.e.e0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {

    /* renamed from: e  reason: collision with root package name */
    public PbModel f18841e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18842f;

    /* renamed from: g  reason: collision with root package name */
    public int f18843g;

    /* renamed from: h  reason: collision with root package name */
    public int f18844h;

    /* renamed from: i  reason: collision with root package name */
    public e0.b f18845i;
    public final e0.b j;

    /* loaded from: classes3.dex */
    public class a implements e0.b {
        public a() {
        }

        @Override // d.a.n0.e2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            MoreGodReplyModel.this.f18842f = false;
            if (MoreGodReplyModel.this.f18845i != null) {
                MoreGodReplyModel.this.f18845i.a(i2, str, str2);
            }
        }

        @Override // d.a.n0.e2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            t Q;
            MoreGodReplyModel.this.f18842f = false;
            if (MoreGodReplyModel.this.f18841e != null && MoreGodReplyModel.this.f18841e.y0() != null && (Q = MoreGodReplyModel.this.f18841e.y0().Q()) != null) {
                List<PostData> list2 = Q.f52976a;
                int size = list2.size();
                if (!ListUtils.isEmpty(list)) {
                    for (PostData postData : list) {
                        if (postData != null && !MoreGodReplyModel.y(list2, postData)) {
                            list2.add(postData);
                        }
                    }
                }
                MoreGodReplyModel.this.f18841e.z1(MoreGodReplyModel.this.f18841e.y0(), size);
            }
            if (MoreGodReplyModel.this.f18843g > 0) {
                MoreGodReplyModel moreGodReplyModel = MoreGodReplyModel.this;
                moreGodReplyModel.f18844h = moreGodReplyModel.f18843g;
            }
            if (MoreGodReplyModel.this.f18845i != null) {
                MoreGodReplyModel.this.f18845i.onSuccess(list);
            }
        }
    }

    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.f18842f = false;
        this.f18843g = -1;
        this.f18844h = -1;
        this.j = new a();
        if (pbModel == null) {
            return;
        }
        this.f18841e = pbModel;
        e0 u0 = pbModel.u0();
        if (u0 != null) {
            u0.f(this.j);
        }
    }

    public static boolean y(List<PostData> list, PostData postData) {
        if (list == null || postData == null) {
            return false;
        }
        for (PostData postData2 : list) {
            if (postData2 != null) {
                if (postData2 == postData) {
                    return true;
                }
                if (postData2.E() != null && postData.E() != null && postData2.E().equals(postData.E())) {
                    return true;
                }
            }
        }
        return false;
    }

    public PbModel A() {
        return this.f18841e;
    }

    public boolean B() {
        e y0;
        t Q;
        PbModel pbModel = this.f18841e;
        if (pbModel == null || (y0 = pbModel.y0()) == null || (Q = y0.Q()) == null) {
            return false;
        }
        if (this.f18844h < 0) {
            this.f18844h = Q.a();
        }
        return Q.f52977b.size() > this.f18844h && Q.f52976a.size() < 100;
    }

    public boolean C() {
        return this.f18842f;
    }

    public boolean D() {
        t Q;
        e y0 = this.f18841e.y0();
        if (y0 == null || (Q = y0.Q()) == null) {
            return false;
        }
        if (this.f18844h < 0) {
            this.f18844h = Q.a();
        }
        List<Long> list = Q.f52977b;
        int size = list.size();
        int i2 = this.f18844h;
        if (size <= i2 || Q.f52976a.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i2 + 20, size));
        this.f18843g = min;
        this.f18842f = true;
        this.f18841e.u0().c(list.subList(i2, min));
        Log.d("more_god_reply", "load from " + i2 + " to " + min);
        return true;
    }

    public void E(e0.b bVar) {
        this.f18845i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f18842f = false;
        return false;
    }

    public List<n> z() {
        PbModel pbModel = this.f18841e;
        ArrayList arrayList = null;
        if (pbModel == null) {
            return null;
        }
        e y0 = pbModel.y0();
        if (y0 != null && y0.Q() != null && !ListUtils.isEmpty(y0.Q().f52976a)) {
            t Q = y0.Q();
            arrayList = new ArrayList();
            List<PostData> list = Q.f52976a;
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                PostData postData = list.get(i2);
                if (postData != null) {
                    arrayList.add(postData);
                    postData.P = i2 < size + (-1);
                }
                i2++;
            }
        }
        return arrayList;
    }
}
