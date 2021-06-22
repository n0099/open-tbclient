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
import d.a.n0.r.q.o1;
import d.a.n0.r.q.z0;
import d.a.o0.d1.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicDetailPagerAdapter extends PagerAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static String[] f18623g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18624h;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18625a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f18626b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18627c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f18628d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18629e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f18630f;

    static {
        String[] strArr = {"最热", "最新"};
        f18623g = strArr;
        f18624h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18625a = (TbPageContext) a2;
        }
        this.f18627c = new ArrayList();
        this.f18626b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.f18626b.add(hotTopicDetailFeedView);
        this.f18626b.add(hotTopicDetailFeedView2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f18627c.add(dVar);
        this.f18627c.add(dVar2);
    }

    public final void A(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void B(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f18623g.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return f18623g[i2];
    }

    public d i(int i2) {
        return (d) ListUtils.getItem(this.f18627c, m(i2) % f18624h);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public int j() {
        return this.f18630f == 1 ? 0 : 1;
    }

    public void k() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18626b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.e();
            }
        }
    }

    public final HotTopicDetailFeedView l() {
        return (HotTopicDetailFeedView) ListUtils.getItem(this.f18626b, this.f18630f % f18624h);
    }

    public final int m(int i2) {
        return i2 == 1 ? 0 : 1;
    }

    public void n(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    public void o(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void p(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    public void q() {
        this.f18629e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: r */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.f18626b.get(i2 % f18623g.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    public void s(int i2) {
        for (int i3 = 0; i3 < this.f18627c.size(); i3++) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f18626b.get(i3);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.j(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        int i3;
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.f18629e && (i3 = this.f18630f) != i2) {
            this.f18630f = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f18626b, i3 % f18624h);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.k();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f18626b, this.f18630f % f18624h);
            d dVar = (d) ListUtils.getItem(this.f18627c, this.f18630f);
            if (hotTopicDetailFeedView2 == null || dVar == null) {
                return;
            }
            if (ListUtils.isEmpty(dVar.N3)) {
                this.f18625a.getOrignalPage().refreshFeedData(j());
            } else {
                hotTopicDetailFeedView2.l();
            }
        }
    }

    public void t() {
        HotTopicDetailFeedView l = l();
        if (l != null) {
            l.k();
        }
    }

    public void u() {
        HotTopicDetailFeedView l = l();
        if (l != null) {
            l.l();
        }
    }

    public void v(o1 o1Var) {
        this.f18628d = o1Var;
    }

    public void w(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18626b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }

    public void x(boolean z, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void y(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18626b == null || m(i2) >= this.f18626b.size() || (hotTopicDetailFeedView = this.f18626b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }

    public void z(@NonNull d dVar, boolean z, int i2) {
        d dVar2 = (d) ListUtils.getItem(this.f18627c, m(i2) % f18624h);
        if (dVar2 == null) {
            return;
        }
        if (z) {
            dVar2.N3 = dVar.N3;
        } else if (!ListUtils.isEmpty(dVar.N3)) {
            if (dVar2.N3 == null) {
                dVar2.N3 = new ArrayList();
            }
            dVar2.N3.addAll(dVar.N3);
        }
        z0 z0Var = dVar.K3;
        dVar2.K3 = z0Var;
        dVar2.L3 = dVar.L3;
        if ((z0Var == null || z0Var.b() == 0) ? false : true) {
            A(i2);
        } else {
            p(i2);
            B(i2);
        }
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f18626b, m(i2) % f18624h)).setData(dVar2.E4(this.f18628d));
    }
}
