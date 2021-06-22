package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.o0.e2.h.e;
import d.a.o0.e2.h.t;
import d.a.o0.e2.k.e.e0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {

    /* renamed from: e  reason: collision with root package name */
    public PbModel f19000e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19001f;

    /* renamed from: g  reason: collision with root package name */
    public int f19002g;

    /* renamed from: h  reason: collision with root package name */
    public int f19003h;

    /* renamed from: i  reason: collision with root package name */
    public e0.b f19004i;
    public final e0.b j;

    /* loaded from: classes5.dex */
    public class a implements e0.b {
        public a() {
        }

        @Override // d.a.o0.e2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            MoreGodReplyModel.this.f19001f = false;
            if (MoreGodReplyModel.this.f19004i != null) {
                MoreGodReplyModel.this.f19004i.a(i2, str, str2);
            }
        }

        @Override // d.a.o0.e2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            t Q;
            MoreGodReplyModel.this.f19001f = false;
            if (MoreGodReplyModel.this.f19000e != null && MoreGodReplyModel.this.f19000e.C0() != null && (Q = MoreGodReplyModel.this.f19000e.C0().Q()) != null) {
                List<PostData> list2 = Q.f56790a;
                int size = list2.size();
                if (!ListUtils.isEmpty(list)) {
                    for (PostData postData : list) {
                        if (postData != null && !MoreGodReplyModel.C(list2, postData)) {
                            list2.add(postData);
                        }
                    }
                }
                MoreGodReplyModel.this.f19000e.C1(MoreGodReplyModel.this.f19000e.C0(), size);
            }
            if (MoreGodReplyModel.this.f19002g > 0) {
                MoreGodReplyModel moreGodReplyModel = MoreGodReplyModel.this;
                moreGodReplyModel.f19003h = moreGodReplyModel.f19002g;
            }
            if (MoreGodReplyModel.this.f19004i != null) {
                MoreGodReplyModel.this.f19004i.onSuccess(list);
            }
        }
    }

    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.f19001f = false;
        this.f19002g = -1;
        this.f19003h = -1;
        this.j = new a();
        if (pbModel == null) {
            return;
        }
        this.f19000e = pbModel;
        e0 y0 = pbModel.y0();
        if (y0 != null) {
            y0.f(this.j);
        }
    }

    public static boolean C(List<PostData> list, PostData postData) {
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

    public List<n> D() {
        PbModel pbModel = this.f19000e;
        ArrayList arrayList = null;
        if (pbModel == null) {
            return null;
        }
        e C0 = pbModel.C0();
        if (C0 != null && C0.Q() != null && !ListUtils.isEmpty(C0.Q().f56790a)) {
            t Q = C0.Q();
            arrayList = new ArrayList();
            List<PostData> list = Q.f56790a;
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

    public PbModel E() {
        return this.f19000e;
    }

    public boolean F() {
        e C0;
        t Q;
        PbModel pbModel = this.f19000e;
        if (pbModel == null || (C0 = pbModel.C0()) == null || (Q = C0.Q()) == null) {
            return false;
        }
        if (this.f19003h < 0) {
            this.f19003h = Q.a();
        }
        return Q.f56791b.size() > this.f19003h && Q.f56790a.size() < 100;
    }

    public boolean G() {
        return this.f19001f;
    }

    public boolean H() {
        t Q;
        e C0 = this.f19000e.C0();
        if (C0 == null || (Q = C0.Q()) == null) {
            return false;
        }
        if (this.f19003h < 0) {
            this.f19003h = Q.a();
        }
        List<Long> list = Q.f56791b;
        int size = list.size();
        int i2 = this.f19003h;
        if (size <= i2 || Q.f56790a.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i2 + 20, size));
        this.f19002g = min;
        this.f19001f = true;
        this.f19000e.y0().c(list.subList(i2, min));
        Log.d("more_god_reply", "load from " + i2 + " to " + min);
        return true;
    }

    public void I(e0.b bVar) {
        this.f19004i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f19001f = false;
        return false;
    }
}
