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
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.m0.r.q.o1;
import d.a.m0.r.q.z0;
import d.a.n0.d1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static String[] f18465g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18466h;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18467a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f18468b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18469c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f18470d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18471e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f18472f;

    static {
        String[] strArr = {"最热", "最新"};
        f18465g = strArr;
        f18466h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18467a = (TbPageContext) a2;
        }
        this.f18469c = new ArrayList();
        this.f18468b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.f18468b.add(hotTopicDetailFeedView);
        this.f18468b.add(hotTopicDetailFeedView2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f18469c.add(dVar);
        this.f18469c.add(dVar2);
    }

    public d b(int i2) {
        return (d) ListUtils.getItem(this.f18469c, f(i2) % f18466h);
    }

    public int c() {
        return this.f18472f == 1 ? 0 : 1;
    }

    public void d() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18468b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.e();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public final HotTopicDetailFeedView e() {
        return (HotTopicDetailFeedView) ListUtils.getItem(this.f18468b, this.f18472f % f18466h);
    }

    public final int f(int i2) {
        return i2 == 1 ? 0 : 1;
    }

    public void g(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f18465g.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return f18465g[i2];
    }

    public void h(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void i(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void j() {
        this.f18471e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: k */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.f18468b.get(i2 % f18465g.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    public void l(int i2) {
        for (int i3 = 0; i3 < this.f18469c.size(); i3++) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f18468b.get(i3);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.j(i2);
            }
        }
    }

    public void m() {
        HotTopicDetailFeedView e2 = e();
        if (e2 != null) {
            e2.k();
        }
    }

    public void n() {
        HotTopicDetailFeedView e2 = e();
        if (e2 != null) {
            e2.l();
        }
    }

    public void o(o1 o1Var) {
        this.f18470d = o1Var;
    }

    public void p(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18468b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }

    public void q(boolean z, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void r(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }

    public void s(@NonNull d dVar, boolean z, int i2) {
        d dVar2 = (d) ListUtils.getItem(this.f18469c, f(i2) % f18466h);
        if (dVar2 == null) {
            return;
        }
        if (z) {
            dVar2.K3 = dVar.K3;
        } else if (!ListUtils.isEmpty(dVar.K3)) {
            if (dVar2.K3 == null) {
                dVar2.K3 = new ArrayList();
            }
            dVar2.K3.addAll(dVar.K3);
        }
        z0 z0Var = dVar.H3;
        dVar2.H3 = z0Var;
        dVar2.I3 = dVar.I3;
        if ((z0Var == null || z0Var.b() == 0) ? false : true) {
            t(i2);
        } else {
            i(i2);
            u(i2);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f18468b, f(i2) % f18466h)).setData(dVar2.D4(this.f18470d));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        int i3;
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.f18471e && (i3 = this.f18472f) != i2) {
            this.f18472f = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f18468b, i3 % f18466h);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.k();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f18468b, this.f18472f % f18466h);
            d dVar = (d) ListUtils.getItem(this.f18469c, this.f18472f);
            if (hotTopicDetailFeedView2 == null || dVar == null) {
                return;
            }
            if (ListUtils.isEmpty(dVar.K3)) {
                this.f18467a.getOrignalPage().refreshFeedData(c());
            } else {
                hotTopicDetailFeedView2.l();
            }
        }
    }

    public final void t(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void u(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18468b == null || f(i2) >= this.f18468b.size() || (hotTopicDetailFeedView = this.f18468b.get(f(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }
}
