package com.baidu.tieba.newdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailFeedView;
import d.b.c.a.f;
import d.b.c.a.j;
import d.b.i0.r.q.o1;
import d.b.i0.r.q.z0;
import d.b.j0.c1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static String[] f18825g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18826h;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18827a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f18828b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18829c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f18830d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18831e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f18832f;

    static {
        String[] strArr = {"最热", "最新"};
        f18825g = strArr;
        f18826h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18827a = (TbPageContext) a2;
        }
        this.f18829c = new ArrayList();
        this.f18828b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.f18828b.add(hotTopicDetailFeedView);
        this.f18828b.add(hotTopicDetailFeedView2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f18829c.add(dVar);
        this.f18829c.add(dVar2);
    }

    public void A(@NonNull d dVar, boolean z, int i) {
        d dVar2 = (d) ListUtils.getItem(this.f18829c, m(i) % f18826h);
        if (dVar2 == null) {
            return;
        }
        if (z) {
            dVar2.I3 = dVar.I3;
        } else if (!ListUtils.isEmpty(dVar.I3)) {
            if (dVar2.I3 == null) {
                dVar2.I3 = new ArrayList();
            }
            dVar2.I3.addAll(dVar.I3);
        }
        z0 z0Var = dVar.F3;
        dVar2.F3 = z0Var;
        dVar2.G3 = dVar.G3;
        if ((z0Var == null || z0Var.b() == 0) ? false : true) {
            B(i);
        } else {
            p(i);
            E(i);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f18828b, m(i) % f18826h)).setData(dVar2.A4(this.f18830d));
    }

    public final void B(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void E(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f18825g.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return f18825g[i];
    }

    public d i(int i) {
        return (d) ListUtils.getItem(this.f18829c, m(i) % f18826h);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public int j() {
        return this.f18832f == 1 ? 0 : 1;
    }

    public void k() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18828b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.e();
            }
        }
    }

    public final HotTopicDetailFeedView l() {
        return (HotTopicDetailFeedView) ListUtils.getItem(this.f18828b, this.f18832f % f18826h);
    }

    public final int m(int i) {
        return i == 1 ? 0 : 1;
    }

    public void n(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    public void o(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void p(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    public void q() {
        this.f18831e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: r */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.f18828b.get(i % f18825g.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    public void s(int i) {
        for (int i2 = 0; i2 < this.f18829c.size(); i2++) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f18828b.get(i2);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.j(i);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        int i2;
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.f18831e && (i2 = this.f18832f) != i) {
            this.f18832f = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f18828b, i2 % f18826h);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.k();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f18828b, this.f18832f % f18826h);
            d dVar = (d) ListUtils.getItem(this.f18829c, this.f18832f);
            if (hotTopicDetailFeedView2 == null || dVar == null) {
                return;
            }
            if (ListUtils.isEmpty(dVar.I3)) {
                this.f18827a.getOrignalPage().refreshFeedData(j());
            } else {
                hotTopicDetailFeedView2.l();
            }
        }
    }

    public void u() {
        HotTopicDetailFeedView l = l();
        if (l != null) {
            l.k();
        }
    }

    public void v() {
        HotTopicDetailFeedView l = l();
        if (l != null) {
            l.l();
        }
    }

    public void w(o1 o1Var) {
        this.f18830d = o1Var;
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18828b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }

    public void y(boolean z, int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void z(int i) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18828b == null || m(i) >= this.f18828b.size() || (hotTopicDetailFeedView = this.f18828b.get(m(i))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }
}
