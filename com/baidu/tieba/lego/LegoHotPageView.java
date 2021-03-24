package com.baidu.tieba.lego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.b.e.p.j;
import d.b.h0.r.f0.f;
import d.b.i0.i1.h;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i1.p.e f18535e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.f0.g f18536f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f18537g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f18538h;
    public d.b.i0.i1.n.a i;
    public TbPageContext<?> j;
    public d.b.i0.i1.c k;
    public h l;
    public d.b.h0.d0.g m;
    public d.b.h0.d0.h n;
    public long o;
    public String p;
    public boolean q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public h.c u;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f13692a) {
                return;
            }
            LegoHotPageView.this.p(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.b.i0.i1.p.b bVar = new d.b.i0.i1.p.b();
            bVar.f56012a = String.valueOf(customResponsedMessage.getData());
            bVar.f56013b = true;
            LegoHotPageView.this.p(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.b.i0.i1.p.b bVar = new d.b.i0.i1.p.b();
            bVar.f56012a = String.valueOf(customResponsedMessage.getData());
            bVar.f56013b = false;
            LegoHotPageView.this.p(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements h.c {
        public d() {
        }

        @Override // d.b.i0.i1.h.c
        public void a(long j, String str) {
            boolean t = LegoHotPageView.this.t();
            LegoHotPageView.this.r();
            if (t) {
                LegoHotPageView legoHotPageView = LegoHotPageView.this;
                legoHotPageView.x(true, legoHotPageView.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
            if (LegoHotPageView.this.k != null) {
                LegoHotPageView.this.k.c(j, str);
            }
        }

        @Override // d.b.i0.i1.h.c
        public void b(List<d.b.i0.i1.p.d> list) {
            if (LegoHotPageView.this.k != null) {
                LegoHotPageView.this.k.b(list);
            }
        }

        @Override // d.b.i0.i1.h.c
        public void c(int i, String str) {
            if (LegoHotPageView.this.k == null || LegoHotPageView.this.f18535e == null) {
                return;
            }
            LegoHotPageView.this.k.e(LegoHotPageView.this.f18535e.f56030a, LegoHotPageView.this.f18535e.f56031b, i, str);
        }

        @Override // d.b.i0.i1.h.c
        public void d(String str, String str2, String str3, List<d.b.i0.i1.p.e> list) {
            if (LegoHotPageView.this.k != null) {
                LegoHotPageView.this.k.d(str, str2, str3, list);
            }
        }

        @Override // d.b.i0.i1.h.c
        public void onError(int i, String str) {
            LegoHotPageView.this.q();
            if (i != 1) {
                LegoHotPageView.this.f18538h.setVisibility(8);
                LegoHotPageView legoHotPageView = LegoHotPageView.this;
                legoHotPageView.y(legoHotPageView, str, true);
            } else if (j.z()) {
                LegoHotPageView.this.j.showToast(str);
            }
        }

        @Override // d.b.i0.i1.h.c
        public void onSuccess() {
            LegoHotPageView.this.q();
            LegoHotPageView.this.r();
            LegoHotPageView.this.f18538h.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            LegoHotPageView.this.l.m(LegoHotPageView.this.o, LegoHotPageView.this.p);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (LegoHotPageView.this.q) {
                if (LegoHotPageView.this.f18537g != null) {
                    LegoHotPageView.this.f18537g.O();
                }
                LegoHotPageView.this.l.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoHotPageView.this.l == null) {
                return;
            }
            if (LegoHotPageView.this.f18535e != null) {
                LegoHotPageView.this.l.m(LegoHotPageView.this.f18535e.f56030a, LegoHotPageView.this.f18535e.f56031b);
            } else {
                LegoHotPageView.this.l.m(LegoHotPageView.this.o, LegoHotPageView.this.p);
            }
        }
    }

    public LegoHotPageView(Context context) {
        super(context);
        this.r = new a(2001115);
        this.s = new b(2001335);
        this.t = new c(2001336);
        this.u = new d();
        s(context);
    }

    private void setHasMore(boolean z) {
        this.q = z;
        if (this.f18538h == null) {
            return;
        }
        if (this.f18537g.b().getParent() == null) {
            this.f18538h.setNextPage(this.f18537g);
        }
        if (this.q) {
            this.f18537g.A(getContext().getString(R.string.pb_load_more));
        } else {
            this.f18537g.A("");
        }
    }

    public void A(DataRes dataRes, boolean z) {
        PbListView pbListView = this.f18537g;
        if (pbListView != null) {
            pbListView.f();
        }
        this.l.i(z, dataRes, 0, null);
        setHasMore(this.l.c());
    }

    public void B(String str, int i) {
        PbListView pbListView = this.f18537g;
        if (pbListView != null) {
            pbListView.f();
        }
        this.l.i(true, null, i, str);
    }

    public long getTagCode() {
        d.b.i0.i1.p.e eVar = this.f18535e;
        if (eVar == null) {
            return 0L;
        }
        return eVar.f56030a;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            v();
        }
    }

    public final void p(Object obj) {
        h hVar;
        if (this.i == null || (hVar = this.l) == null || hVar.b() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.l.b()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.i.notifyDataSetChanged();
        }
    }

    public final void q() {
        d.b.h0.d0.g gVar = this.m;
        if (gVar != null) {
            gVar.dettachView(this);
            this.m = null;
        }
        d.b.i0.i1.c cVar = this.k;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void r() {
        d.b.h0.d0.h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this);
            this.n = null;
        }
    }

    public final void s(Context context) {
        d.b.b.a.f<?> a2 = d.b.b.a.j.a(context);
        a2.registerListener(this.r);
        a2.registerListener(this.s);
        a2.registerListener(this.t);
        if (a2 instanceof TbPageContext) {
            this.j = (TbPageContext) a2;
        }
        BdListView bdListView = new BdListView(context);
        this.f18538h = bdListView;
        bdListView.setDividerHeight(0);
        this.f18538h.setSelector(17170445);
        d.b.i0.i1.n.a aVar = new d.b.i0.i1.n.a(this.j);
        this.i = aVar;
        this.f18538h.setAdapter((ListAdapter) aVar);
        PbListView pbListView = new PbListView(context);
        this.f18537g = pbListView;
        pbListView.a();
        this.f18537g.o(R.color.CAM_X0204);
        this.f18537g.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f18537g.d(TbadkCoreApplication.getInst().getSkinType());
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.j);
        this.f18536f = gVar;
        this.f18538h.setPullRefresh(gVar);
        this.f18536f.B(true);
        this.f18536f.b(new e());
        this.f18538h.setOnSrollToBottomListener(new f());
        this.f18538h.setOnScrollListener(this);
        h hVar = new h(this.f18538h, this.i);
        this.l = hVar;
        hVar.l(this.u);
        addView(this.f18538h);
    }

    public void setCallback(d.b.i0.i1.c cVar) {
        this.k = cVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.b.h0.r.f0.g gVar = this.f18536f;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
    }

    public void setTagInfo(d.b.i0.i1.p.e eVar) {
        this.f18535e = eVar;
    }

    public void setViewBackGround() {
        u(true);
    }

    public void setViewForeground() {
        u(false);
    }

    public final boolean t() {
        d.b.h0.d0.h hVar = this.n;
        return hVar != null && hVar.isViewAttached();
    }

    public void u(boolean z) {
        if (this.f18538h == null) {
            return;
        }
        for (int i = 0; i < this.f18538h.getChildCount(); i++) {
            View childAt = this.f18538h.getChildAt(i);
            if (childAt instanceof d.b.i0.i1.o.l.e) {
                if (z) {
                    ((d.b.i0.i1.o.l.e) childAt).f();
                } else {
                    ((d.b.i0.i1.o.l.e) childAt).h();
                }
            }
        }
    }

    public final void v() {
        if (this.f18538h == null) {
            return;
        }
        for (int i = 0; i < this.f18538h.getChildCount(); i++) {
            View childAt = this.f18538h.getChildAt(i);
            if (childAt instanceof d.b.i0.i1.o.l.e) {
                ((d.b.i0.i1.o.l.e) childAt).e();
            }
        }
    }

    public void w(int i) {
        d.b.h0.d0.g gVar = this.m;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        d.b.h0.d0.h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.b.h0.r.f0.g gVar2 = this.f18536f;
        if (gVar2 != null) {
            gVar2.I(i);
        }
        BdListView bdListView = this.f18538h;
        if (bdListView != null) {
            SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204, i);
        }
        PbListView pbListView = this.f18537g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f18537g.d(i);
        }
    }

    public final void x(boolean z, int i) {
        if (this.m == null) {
            if (i < 0) {
                this.m = new d.b.h0.d0.g(getContext());
            } else {
                this.m = new d.b.h0.d0.g(getContext(), i);
            }
            this.m.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public final void y(View view, String str, boolean z) {
        if (this.n == null) {
            this.n = new d.b.h0.d0.h(getContext(), new g());
        }
        this.n.j(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.n.l(str);
        this.n.attachView(view, z);
        this.n.o();
    }

    public void z(long j, String str) {
        this.o = j;
        this.p = str;
        h hVar = this.l;
        if (hVar != null) {
            hVar.m(j, str);
        }
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = new a(2001115);
        this.s = new b(2001335);
        this.t = new c(2001336);
        this.u = new d();
        s(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = new a(2001115);
        this.s = new b(2001335);
        this.t = new c(2001336);
        this.u = new d();
        s(context);
    }
}
