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
import d.a.c.j.e.n;
import d.a.i0.d0.g;
import d.a.i0.d0.h;
import d.a.j0.j2.i;
import d.a.j0.x1.d.c.l;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicDetailFeedView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f19271e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f19272f;

    /* renamed from: g  reason: collision with root package name */
    public l f19273g;

    /* renamed from: h  reason: collision with root package name */
    public g f19274h;

    /* renamed from: i  reason: collision with root package name */
    public h f19275i;
    public PbListView j;
    public RecyclerView.OnScrollListener k;
    public i l;
    public int m;
    public RecyclerView.OnScrollListener n;
    public e o;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f19276a;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && HotTopicDetailFeedView.this.l != null) {
                HotTopicDetailFeedView.this.l.n(HotTopicDetailFeedView.this.f19272f.getFirstVisiblePosition(), HotTopicDetailFeedView.this.f19272f.getLastVisiblePosition(), this.f19276a, true);
            }
            if (HotTopicDetailFeedView.this.k != null) {
                HotTopicDetailFeedView.this.k.onScrollStateChanged(recyclerView, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            this.f19276a = i3 <= 0;
            if (HotTopicDetailFeedView.this.k != null) {
                HotTopicDetailFeedView.this.k.onScrolled(recyclerView, i2, i3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (HotTopicDetailFeedView.this.f19272f != null) {
                HotTopicDetailFeedView.this.f19272f.stopScroll();
            }
            ((HotTopicDetailActivity) HotTopicDetailFeedView.this.f19271e.getOrignalPage()).onScrollToBottom();
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
                ((HotTopicDetailActivity) HotTopicDetailFeedView.this.f19271e.getOrignalPage()).refreshFeedData(HotTopicDetailFeedView.this.m);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f19272f;
        if (bdTypeRecyclerView == null || this.j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.j.i();
    }

    public void g() {
        g gVar = this.f19274h;
        if (gVar != null) {
            gVar.dettachView(this);
            this.f19274h = null;
        }
    }

    public void h() {
        h hVar = this.f19275i;
        if (hVar != null) {
            hVar.dettachView(this);
            this.f19275i = null;
        }
    }

    public final void i(Context context) {
        f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f19271e = (TbPageContext) a2;
        }
        if (this.f19271e == null) {
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
        this.f19272f = bdTypeRecyclerView;
        bdTypeRecyclerView.setFadingEdgeLength(0);
        this.f19272f.setOverScrollMode(2);
        this.f19272f.setVerticalScrollBarEnabled(false);
        this.f19272f.setLayoutManager(new LinearLayoutManager(context));
        this.f19272f.addOnScrollListener(this.n);
        this.f19272f.setOnSrollToBottomListener(new b());
        TbPageContext<HotTopicDetailActivity> tbPageContext = this.f19271e;
        this.f19273g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f19272f);
        addView(this.f19272f);
        ((FrameLayout.LayoutParams) this.f19272f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
        if (this.l == null) {
            i iVar = new i(this.f19271e, this.f19272f);
            this.l = iVar;
            iVar.p(1);
            this.l.t(this.f19271e.getUniqueId());
        }
        this.f19272f.setRecyclerListener(new c());
        PbListView pbListView = new PbListView(context);
        this.j = pbListView;
        pbListView.a();
        this.j.o(R.color.CAM_X0205);
        this.j.v();
        this.j.C(SkinManager.getColor(R.color.CAM_X0109));
        this.j.y(R.color.CAM_X0110);
        this.f19272f.setVisibility(0);
        setFocusableInTouchMode(true);
    }

    public void j(int i2) {
        g gVar = this.f19274h;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.f19275i;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.j.d(i2);
        }
        l lVar = this.f19273g;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f19272f;
            if (bdTypeRecyclerView != null) {
                this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f19272f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public HotTopicDetailFeedView m(int i2) {
        this.m = i2;
        this.f19273g.b(i2 == 0);
        return this;
    }

    public void n() {
        PbListView pbListView;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19272f;
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
        if (this.f19274h == null) {
            g gVar = new g(getContext());
            this.f19274h = gVar;
            gVar.h();
            this.f19274h.onChangeSkinType();
            this.f19274h.setWrapStyle(true);
        }
        this.f19274h.attachView(this, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public void p(boolean z) {
        if (this.f19275i == null) {
            h hVar = new h(getContext(), new d());
            this.f19275i = hVar;
            hVar.setWrapStyle(false);
        }
        this.f19275i.attachView(this, false);
        this.f19275i.o();
        if (z) {
            this.f19275i.m(getResources().getString(R.string.refresh_view_title_text));
        } else {
            this.f19275i.m(getResources().getString(R.string.hot_topic_no_data));
        }
        this.f19275i.b().setClickable(false);
    }

    public void q() {
        PbListView pbListView;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19272f;
        if (bdTypeRecyclerView == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.f();
        this.j.J(0);
        this.j.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public void setData(@NonNull List<n> list) {
        this.f19273g.d(list);
        i iVar = this.l;
        if (iVar != null) {
            iVar.n(this.f19272f.getFirstVisiblePosition(), this.f19272f.getLastVisiblePosition(), false, true);
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
