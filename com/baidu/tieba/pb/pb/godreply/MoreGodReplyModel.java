package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.b.a.f;
import d.b.b.j.e.n;
import d.b.i0.c2.h.e;
import d.b.i0.c2.h.s;
import d.b.i0.c2.k.e.c0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {

    /* renamed from: e  reason: collision with root package name */
    public PbModel f19494e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19495f;

    /* renamed from: g  reason: collision with root package name */
    public int f19496g;

    /* renamed from: h  reason: collision with root package name */
    public int f19497h;
    public c0.b i;
    public final c0.b j;

    /* loaded from: classes4.dex */
    public class a implements c0.b {
        public a() {
        }

        @Override // d.b.i0.c2.k.e.c0.b
        public void a(int i, String str, String str2) {
            MoreGodReplyModel.this.f19495f = false;
            if (MoreGodReplyModel.this.i != null) {
                MoreGodReplyModel.this.i.a(i, str, str2);
            }
        }

        @Override // d.b.i0.c2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
            s P;
            MoreGodReplyModel.this.f19495f = false;
            if (MoreGodReplyModel.this.f19494e != null && MoreGodReplyModel.this.f19494e.y0() != null && (P = MoreGodReplyModel.this.f19494e.y0().P()) != null) {
                List<PostData> list2 = P.f52471a;
                int size = list2.size();
                if (!ListUtils.isEmpty(list)) {
                    for (PostData postData : list) {
                        if (postData != null && !MoreGodReplyModel.y(list2, postData)) {
                            list2.add(postData);
                        }
                    }
                }
                MoreGodReplyModel.this.f19494e.z1(MoreGodReplyModel.this.f19494e.y0(), size);
            }
            if (MoreGodReplyModel.this.f19496g > 0) {
                MoreGodReplyModel moreGodReplyModel = MoreGodReplyModel.this;
                moreGodReplyModel.f19497h = moreGodReplyModel.f19496g;
            }
            if (MoreGodReplyModel.this.i != null) {
                MoreGodReplyModel.this.i.onSuccess(list);
            }
        }
    }

    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.f19495f = false;
        this.f19496g = -1;
        this.f19497h = -1;
        this.j = new a();
        if (pbModel == null) {
            return;
        }
        this.f19494e = pbModel;
        c0 u0 = pbModel.u0();
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
                if (postData2.D() != null && postData.D() != null && postData2.D().equals(postData.D())) {
                    return true;
                }
            }
        }
        return false;
    }

    public PbModel A() {
        return this.f19494e;
    }

    public boolean B() {
        e y0;
        s P;
        PbModel pbModel = this.f19494e;
        if (pbModel == null || (y0 = pbModel.y0()) == null || (P = y0.P()) == null) {
            return false;
        }
        if (this.f19497h < 0) {
            this.f19497h = P.a();
        }
        return P.f52472b.size() > this.f19497h && P.f52471a.size() < 100;
    }

    public boolean C() {
        return this.f19495f;
    }

    public boolean D() {
        s P;
        e y0 = this.f19494e.y0();
        if (y0 == null || (P = y0.P()) == null) {
            return false;
        }
        if (this.f19497h < 0) {
            this.f19497h = P.a();
        }
        List<Long> list = P.f52472b;
        int size = list.size();
        int i = this.f19497h;
        if (size <= i || P.f52471a.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.f19496g = min;
        this.f19495f = true;
        this.f19494e.u0().c(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public void E(c0.b bVar) {
        this.i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f19495f = false;
        return false;
    }

    public List<n> z() {
        PbModel pbModel = this.f19494e;
        ArrayList arrayList = null;
        if (pbModel == null) {
            return null;
        }
        e y0 = pbModel.y0();
        if (y0 != null && y0.P() != null && !ListUtils.isEmpty(y0.P().f52471a)) {
            s P = y0.P();
            arrayList = new ArrayList();
            List<PostData> list = P.f52471a;
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
