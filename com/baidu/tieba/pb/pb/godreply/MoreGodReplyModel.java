package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.i0.d2.h.e;
import d.b.i0.d2.h.s;
import d.b.i0.d2.k.e.e0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {

    /* renamed from: e  reason: collision with root package name */
    public PbModel f19174e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19175f;

    /* renamed from: g  reason: collision with root package name */
    public int f19176g;

    /* renamed from: h  reason: collision with root package name */
    public int f19177h;
    public e0.b i;
    public final e0.b j;

    /* loaded from: classes3.dex */
    public class a implements e0.b {
        public a() {
        }

        @Override // d.b.i0.d2.k.e.e0.b
        public void a(int i, String str, String str2) {
            MoreGodReplyModel.this.f19175f = false;
            if (MoreGodReplyModel.this.i != null) {
                MoreGodReplyModel.this.i.a(i, str, str2);
            }
        }

        @Override // d.b.i0.d2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            s Q;
            MoreGodReplyModel.this.f19175f = false;
            if (MoreGodReplyModel.this.f19174e != null && MoreGodReplyModel.this.f19174e.y0() != null && (Q = MoreGodReplyModel.this.f19174e.y0().Q()) != null) {
                List<PostData> list2 = Q.f53866a;
                int size = list2.size();
                if (!ListUtils.isEmpty(list)) {
                    for (PostData postData : list) {
                        if (postData != null && !MoreGodReplyModel.y(list2, postData)) {
                            list2.add(postData);
                        }
                    }
                }
                MoreGodReplyModel.this.f19174e.z1(MoreGodReplyModel.this.f19174e.y0(), size);
            }
            if (MoreGodReplyModel.this.f19176g > 0) {
                MoreGodReplyModel moreGodReplyModel = MoreGodReplyModel.this;
                moreGodReplyModel.f19177h = moreGodReplyModel.f19176g;
            }
            if (MoreGodReplyModel.this.i != null) {
                MoreGodReplyModel.this.i.onSuccess(list);
            }
        }
    }

    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.f19175f = false;
        this.f19176g = -1;
        this.f19177h = -1;
        this.j = new a();
        if (pbModel == null) {
            return;
        }
        this.f19174e = pbModel;
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
        return this.f19174e;
    }

    public boolean B() {
        e y0;
        s Q;
        PbModel pbModel = this.f19174e;
        if (pbModel == null || (y0 = pbModel.y0()) == null || (Q = y0.Q()) == null) {
            return false;
        }
        if (this.f19177h < 0) {
            this.f19177h = Q.a();
        }
        return Q.f53867b.size() > this.f19177h && Q.f53866a.size() < 100;
    }

    public boolean C() {
        return this.f19175f;
    }

    public boolean D() {
        s Q;
        e y0 = this.f19174e.y0();
        if (y0 == null || (Q = y0.Q()) == null) {
            return false;
        }
        if (this.f19177h < 0) {
            this.f19177h = Q.a();
        }
        List<Long> list = Q.f53867b;
        int size = list.size();
        int i = this.f19177h;
        if (size <= i || Q.f53866a.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.f19176g = min;
        this.f19175f = true;
        this.f19174e.u0().c(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public void E(e0.b bVar) {
        this.i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f19175f = false;
        return false;
    }

    public List<n> z() {
        PbModel pbModel = this.f19174e;
        ArrayList arrayList = null;
        if (pbModel == null) {
            return null;
        }
        e y0 = pbModel.y0();
        if (y0 != null && y0.Q() != null && !ListUtils.isEmpty(y0.Q().f53866a)) {
            s Q = y0.Q();
            arrayList = new ArrayList();
            List<PostData> list = Q.f53866a;
            int size = list.size();
            int i = 0;
            while (i < size) {
                PostData postData = list.get(i);
                if (postData != null) {
                    arrayList.add(postData);
                    postData.P = i < size + (-1);
                }
                i++;
            }
        }
        return arrayList;
    }
}
