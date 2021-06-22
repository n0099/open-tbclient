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
import d.a.c.a.f;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.n0.d0.g;
import d.a.n0.d0.h;
import d.a.o0.k2.i;
import d.a.o0.y1.d.c.l;
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicDetailFeedView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18631e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f18632f;

    /* renamed from: g  reason: collision with root package name */
    public l f18633g;

    /* renamed from: h  reason: collision with root package name */
    public g f18634h;

    /* renamed from: i  reason: collision with root package name */
    public h f18635i;
    public PbListView j;
    public RecyclerView.OnScrollListener k;
    public i l;
    public int m;
    public RecyclerView.OnScrollListener n;
    public e o;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f18636a;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && HotTopicDetailFeedView.this.l != null) {
                HotTopicDetailFeedView.this.l.n(HotTopicDetailFeedView.this.f18632f.getFirstVisiblePosition(), HotTopicDetailFeedView.this.f18632f.getLastVisiblePosition(), this.f18636a, true);
            }
            if (HotTopicDetailFeedView.this.k != null) {
                HotTopicDetailFeedView.this.k.onScrollStateChanged(recyclerView, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            this.f18636a = i3 <= 0;
            if (HotTopicDetailFeedView.this.k != null) {
                HotTopicDetailFeedView.this.k.onScrolled(recyclerView, i2, i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (HotTopicDetailFeedView.this.f18632f != null) {
                HotTopicDetailFeedView.this.f18632f.stopScroll();
            }
            ((HotTopicDetailActivity) HotTopicDetailFeedView.this.f18631e.getOrignalPage()).onScrollToBottom();
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                ((HotTopicDetailActivity) HotTopicDetailFeedView.this.f18631e.getOrignalPage()).refreshFeedData(HotTopicDetailFeedView.this.m);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
    }

    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 1;
        this.n = new a();
        i(context);
    }

    public void e() {
        i iVar = this.l;
        if (iVar != null) {
            iVar.h();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.o);
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f18632f;
        if (bdTypeRecyclerView == null || this.j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.j.i();
    }

    public void g() {
        g gVar = this.f18634h;
        if (gVar != null) {
            gVar.dettachView(this);
            this.f18634h = null;
        }
    }

    public void h() {
        h hVar = this.f18635i;
        if (hVar != null) {
            hVar.dettachView(this);
            this.f18635i = null;
        }
    }

    public final void i(Context context) {
        f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f18631e = (TbPageContext) a2;
        }
        if (this.f18631e == null) {
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f18632f = bdTypeRecyclerView;
        bdTypeRecyclerView.setFadingEdgeLength(0);
        this.f18632f.setOverScrollMode(2);
        this.f18632f.setVerticalScrollBarEnabled(false);
        this.f18632f.setLayoutManager(new LinearLayoutManager(context));
        this.f18632f.addOnScrollListener(this.n);
        this.f18632f.setOnSrollToBottomListener(new b());
        TbPageContext<HotTopicDetailActivity> tbPageContext = this.f18631e;
        this.f18633g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f18632f);
        addView(this.f18632f);
        ((FrameLayout.LayoutParams) this.f18632f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
        if (this.l == null) {
            i iVar = new i(this.f18631e, this.f18632f);
            this.l = iVar;
            iVar.p(1);
            this.l.t(this.f18631e.getUniqueId());
        }
        this.f18632f.setRecyclerListener(new c());
        PbListView pbListView = new PbListView(context);
        this.j = pbListView;
        pbListView.a();
        this.j.o(R.color.CAM_X0205);
        this.j.v();
        this.j.C(SkinManager.getColor(R.color.CAM_X0109));
        this.j.y(R.color.CAM_X0110);
        this.f18632f.setVisibility(0);
        setFocusableInTouchMode(true);
    }

    public void j(int i2) {
        g gVar = this.f18634h;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.f18635i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.j.d(i2);
        }
        l lVar = this.f18633g;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f18632f;
            if (bdTypeRecyclerView != null) {
                this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f18632f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public HotTopicDetailFeedView m(int i2) {
        this.m = i2;
        this.f18633g.b(i2 == 0);
        return this;
    }

    public void n() {
        PbListView pbListView;
        BdTypeRecyclerView bdTypeRecyclerView = this.f18632f;
        if (bdTypeRecyclerView == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.E(R.dimen.tbfontsize33);
        this.j.J(0);
        this.j.r(d.a.c.e.p.l.g(getContext(), R.dimen.tbds182));
        this.j.O();
    }

    public void o(boolean z) {
        if (this.f18634h == null) {
            g gVar = new g(getContext());
            this.f18634h = gVar;
            gVar.h();
            this.f18634h.onChangeSkinType();
            this.f18634h.setWrapStyle(true);
        }
        this.f18634h.attachView(this, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public void p(boolean z) {
        if (this.f18635i == null) {
            h hVar = new h(getContext(), new d());
            this.f18635i = hVar;
            hVar.setWrapStyle(false);
        }
        this.f18635i.attachView(this, false);
        this.f18635i.o();
        if (z) {
            this.f18635i.m(getResources().getString(R.string.refresh_view_title_text));
        } else {
            this.f18635i.m(getResources().getString(R.string.hot_topic_no_data));
        }
        this.f18635i.b().setClickable(false);
    }

    public void q() {
        PbListView pbListView;
        BdTypeRecyclerView bdTypeRecyclerView = this.f18632f;
        if (bdTypeRecyclerView == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.f();
        this.j.J(0);
        this.j.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public void setData(@NonNull List<n> list) {
        this.f18633g.d(list);
        i iVar = this.l;
        if (iVar != null) {
            iVar.n(this.f18632f.getFirstVisiblePosition(), this.f18632f.getLastVisiblePosition(), false, true);
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
