package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import d.b.c.a.f;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import d.b.i0.j2.i;
import d.b.i0.x1.d.c.l;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicDetailFeedView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18825e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f18826f;

    /* renamed from: g  reason: collision with root package name */
    public l f18827g;

    /* renamed from: h  reason: collision with root package name */
    public g f18828h;
    public h i;
    public PbListView j;
    public RecyclerView.OnScrollListener k;
    public i l;
    public int m;
    public RecyclerView.OnScrollListener n;
    public e o;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f18829a;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && HotTopicDetailFeedView.this.l != null) {
                HotTopicDetailFeedView.this.l.n(HotTopicDetailFeedView.this.f18826f.getFirstVisiblePosition(), HotTopicDetailFeedView.this.f18826f.getLastVisiblePosition(), this.f18829a, true);
            }
            if (HotTopicDetailFeedView.this.k != null) {
                HotTopicDetailFeedView.this.k.onScrollStateChanged(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            this.f18829a = i2 <= 0;
            if (HotTopicDetailFeedView.this.k != null) {
                HotTopicDetailFeedView.this.k.onScrolled(recyclerView, i, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (HotTopicDetailFeedView.this.f18826f != null) {
                HotTopicDetailFeedView.this.f18826f.stopScroll();
            }
            ((HotTopicDetailActivity) HotTopicDetailFeedView.this.f18825e.getOrignalPage()).onScrollToBottom();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements RecyclerView.RecyclerListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view == null || HotTopicDetailFeedView.this.l == null) {
                return;
            }
            HotTopicDetailFeedView.this.l.k(view);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                ((HotTopicDetailActivity) HotTopicDetailFeedView.this.f18825e.getOrignalPage()).refreshFeedData(HotTopicDetailFeedView.this.m);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 1;
        this.n = new a();
        i(context);
    }

    public void e() {
        i iVar = this.l;
        if (iVar != null) {
            iVar.h();
        }
        d.b.c.e.m.e.a().removeCallbacks(this.o);
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f18826f;
        if (bdTypeRecyclerView == null || this.j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.j.i();
    }

    public void g() {
        g gVar = this.f18828h;
        if (gVar != null) {
            gVar.dettachView(this);
            this.f18828h = null;
        }
    }

    public void h() {
        h hVar = this.i;
        if (hVar != null) {
            hVar.dettachView(this);
            this.i = null;
        }
    }

    public final void i(Context context) {
        f<?> a2 = d.b.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18825e = (TbPageContext) a2;
        }
        if (this.f18825e == null) {
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f18826f = bdTypeRecyclerView;
        bdTypeRecyclerView.setFadingEdgeLength(0);
        this.f18826f.setOverScrollMode(2);
        this.f18826f.setVerticalScrollBarEnabled(false);
        this.f18826f.setLayoutManager(new LinearLayoutManager(context));
        this.f18826f.addOnScrollListener(this.n);
        this.f18826f.setOnSrollToBottomListener(new b());
        TbPageContext<HotTopicDetailActivity> tbPageContext = this.f18825e;
        this.f18827g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f18826f);
        addView(this.f18826f);
        ((FrameLayout.LayoutParams) this.f18826f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
        if (this.l == null) {
            i iVar = new i(this.f18825e, this.f18826f);
            this.l = iVar;
            iVar.p(1);
            this.l.t(this.f18825e.getUniqueId());
        }
        this.f18826f.setRecyclerListener(new c());
        PbListView pbListView = new PbListView(context);
        this.j = pbListView;
        pbListView.a();
        this.j.o(R.color.CAM_X0205);
        this.j.v();
        this.j.C(SkinManager.getColor(R.color.CAM_X0109));
        this.j.y(R.color.CAM_X0110);
        this.f18826f.setVisibility(0);
        setFocusableInTouchMode(true);
    }

    public void j(int i) {
        g gVar = this.f18828h;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.j.d(i);
        }
        l lVar = this.f18827g;
        if (lVar != null) {
            lVar.c();
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public void k() {
        i iVar = this.l;
        if (iVar != null) {
            iVar.x();
            this.l.q(false);
        }
    }

    public void l() {
        i iVar = this.l;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f18826f;
            if (bdTypeRecyclerView != null) {
                this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f18826f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public HotTopicDetailFeedView m(int i) {
        this.m = i;
        this.f18827g.b(i == 0);
        return this;
    }

    public void n() {
        PbListView pbListView;
        BdTypeRecyclerView bdTypeRecyclerView = this.f18826f;
        if (bdTypeRecyclerView == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.E(R.dimen.tbfontsize33);
        this.j.J(0);
        this.j.r(d.b.c.e.p.l.g(getContext(), R.dimen.tbds182));
        this.j.O();
    }

    public void o(boolean z) {
        if (this.f18828h == null) {
            g gVar = new g(getContext());
            this.f18828h = gVar;
            gVar.h();
            this.f18828h.onChangeSkinType();
            this.f18828h.setWrapStyle(true);
        }
        this.f18828h.attachView(this, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public void p(boolean z) {
        if (this.i == null) {
            h hVar = new h(getContext(), new d());
            this.i = hVar;
            hVar.setWrapStyle(false);
        }
        this.i.attachView(this, false);
        this.i.o();
        if (z) {
            this.i.m(getResources().getString(R.string.refresh_view_title_text));
        } else {
            this.i.m(getResources().getString(R.string.hot_topic_no_data));
        }
        this.i.b().setClickable(false);
    }

    public void q() {
        PbListView pbListView;
        BdTypeRecyclerView bdTypeRecyclerView = this.f18826f;
        if (bdTypeRecyclerView == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.f();
        this.j.J(0);
        this.j.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public void setData(@NonNull List<n> list) {
        this.f18827g.d(list);
        i iVar = this.l;
        if (iVar != null) {
            iVar.n(this.f18826f.getFirstVisiblePosition(), this.f18826f.getLastVisiblePosition(), false, true);
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.k = onScrollListener;
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 1;
        this.n = new a();
        i(context);
    }

    public HotTopicDetailFeedView(Context context) {
        super(context);
        this.m = 1;
        this.n = new a();
        i(context);
    }
}
