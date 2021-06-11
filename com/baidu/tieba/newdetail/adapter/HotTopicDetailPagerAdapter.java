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
    public static String[] f18541g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18542h;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18543a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicDetailFeedView> f18544b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f18545c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f18546d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18547e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f18548f;

    static {
        String[] strArr = {"最热", "最新"};
        f18541g = strArr;
        f18542h = strArr.length;
    }

    public HotTopicDetailPagerAdapter(Context context) {
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18543a = (TbPageContext) a2;
        }
        this.f18545c = new ArrayList();
        this.f18544b = new ArrayList();
        HotTopicDetailFeedView hotTopicDetailFeedView = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView.m(1);
        HotTopicDetailFeedView hotTopicDetailFeedView2 = new HotTopicDetailFeedView(context);
        hotTopicDetailFeedView2.m(0);
        this.f18544b.add(hotTopicDetailFeedView);
        this.f18544b.add(hotTopicDetailFeedView2);
        d dVar = new d(1);
        d dVar2 = new d(0);
        this.f18545c.add(dVar);
        this.f18545c.add(dVar2);
    }

    public final void A(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.n();
    }

    public final void B(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.q();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f18541g.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return f18541g[i2];
    }

    public d i(int i2) {
        return (d) ListUtils.getItem(this.f18545c, m(i2) % f18542h);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public int j() {
        return this.f18548f == 1 ? 0 : 1;
    }

    public void k() {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18544b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.e();
            }
        }
    }

    public final HotTopicDetailFeedView l() {
        return (HotTopicDetailFeedView) ListUtils.getItem(this.f18544b, this.f18548f % f18542h);
    }

    public final int m(int i2) {
        return i2 == 1 ? 0 : 1;
    }

    public void n(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.h();
    }

    public void o(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.g();
    }

    public final void p(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.f();
    }

    public void q() {
        this.f18547e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: r */
    public HotTopicDetailFeedView instantiateItem(ViewGroup viewGroup, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView = this.f18544b.get(i2 % f18541g.length);
        if (hotTopicDetailFeedView.getParent() != null) {
            viewGroup.removeView(hotTopicDetailFeedView);
        }
        viewGroup.addView(hotTopicDetailFeedView);
        return hotTopicDetailFeedView;
    }

    public void s(int i2) {
        for (int i3 = 0; i3 < this.f18545c.size(); i3++) {
            HotTopicDetailFeedView hotTopicDetailFeedView = this.f18544b.get(i3);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.j(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        int i3;
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.f18547e && (i3 = this.f18548f) != i2) {
            this.f18548f = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicDetailFeedView hotTopicDetailFeedView = (HotTopicDetailFeedView) ListUtils.getItem(this.f18544b, i3 % f18542h);
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.k();
            }
            HotTopicDetailFeedView hotTopicDetailFeedView2 = (HotTopicDetailFeedView) ListUtils.getItem(this.f18544b, this.f18548f % f18542h);
            d dVar = (d) ListUtils.getItem(this.f18545c, this.f18548f);
            if (hotTopicDetailFeedView2 == null || dVar == null) {
                return;
            }
            if (ListUtils.isEmpty(dVar.N3)) {
                this.f18543a.getOrignalPage().refreshFeedData(j());
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
        this.f18546d = o1Var;
    }

    public void w(RecyclerView.OnScrollListener onScrollListener) {
        for (HotTopicDetailFeedView hotTopicDetailFeedView : this.f18544b) {
            if (hotTopicDetailFeedView != null) {
                hotTopicDetailFeedView.setScrollListener(onScrollListener);
            }
        }
    }

    public void x(boolean z, int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.p(z);
    }

    public void y(int i2) {
        HotTopicDetailFeedView hotTopicDetailFeedView;
        if (this.f18544b == null || m(i2) >= this.f18544b.size() || (hotTopicDetailFeedView = this.f18544b.get(m(i2))) == null) {
            return;
        }
        hotTopicDetailFeedView.o(true);
    }

    public void z(@NonNull d dVar, boolean z, int i2) {
        d dVar2 = (d) ListUtils.getItem(this.f18545c, m(i2) % f18542h);
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
        ((HotTopicDetailFeedView) ListUtils.getItem(this.f18544b, m(i2) % f18542h)).setData(dVar2.E4(this.f18546d));
    }
}
