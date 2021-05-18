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
import d.a.c.e.p.j;
import d.a.j0.r.f0.f;
import d.a.k0.j1.h;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.j1.p.e f17887e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.r.f0.g f17888f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f17889g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f17890h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.j1.n.a f17891i;
    public TbPageContext<?> j;
    public d.a.k0.j1.c k;
    public h l;
    public d.a.j0.d0.g m;
    public d.a.j0.d0.h n;
    public long o;
    public String p;
    public boolean q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public h.c u;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12666a) {
                return;
            }
            LegoHotPageView.this.p(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.a.k0.j1.p.b bVar = new d.a.k0.j1.p.b();
            bVar.f56559a = String.valueOf(customResponsedMessage.getData());
            bVar.f56560b = true;
            LegoHotPageView.this.p(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            d.a.k0.j1.p.b bVar = new d.a.k0.j1.p.b();
            bVar.f56559a = String.valueOf(customResponsedMessage.getData());
            bVar.f56560b = false;
            LegoHotPageView.this.p(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements h.c {
        public d() {
        }

        @Override // d.a.k0.j1.h.c
        public void a(List<d.a.k0.j1.p.d> list) {
            if (LegoHotPageView.this.k != null) {
                LegoHotPageView.this.k.a(list);
            }
        }

        @Override // d.a.k0.j1.h.c
        public void b(long j, String str) {
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

        @Override // d.a.k0.j1.h.c
        public void c(int i2, String str) {
            if (LegoHotPageView.this.k == null || LegoHotPageView.this.f17887e == null) {
                return;
            }
            LegoHotPageView.this.k.e(LegoHotPageView.this.f17887e.f56578a, LegoHotPageView.this.f17887e.f56579b, i2, str);
        }

        @Override // d.a.k0.j1.h.c
        public void d(String str, String str2, String str3, List<d.a.k0.j1.p.e> list) {
            if (LegoHotPageView.this.k != null) {
                LegoHotPageView.this.k.d(str, str2, str3, list);
            }
        }

        @Override // d.a.k0.j1.h.c
        public void onError(int i2, String str) {
            LegoHotPageView.this.q();
            if (i2 != 1) {
                LegoHotPageView.this.f17890h.setVisibility(8);
                LegoHotPageView legoHotPageView = LegoHotPageView.this;
                legoHotPageView.y(legoHotPageView, str, true);
            } else if (j.z()) {
                LegoHotPageView.this.j.showToast(str);
            }
        }

        @Override // d.a.k0.j1.h.c
        public void onSuccess() {
            LegoHotPageView.this.q();
            LegoHotPageView.this.r();
            LegoHotPageView.this.f17890h.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.j0.r.f0.f.g
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
                if (LegoHotPageView.this.f17889g != null) {
                    LegoHotPageView.this.f17889g.O();
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
            if (LegoHotPageView.this.f17887e != null) {
                LegoHotPageView.this.l.m(LegoHotPageView.this.f17887e.f56578a, LegoHotPageView.this.f17887e.f56579b);
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
        if (this.f17890h == null) {
            return;
        }
        if (this.f17889g.b().getParent() == null) {
            this.f17890h.setNextPage(this.f17889g);
        }
        if (this.q) {
            this.f17889g.A(getContext().getString(R.string.pb_load_more));
        } else {
            this.f17889g.A("");
        }
    }

    public void A(DataRes dataRes, boolean z) {
        PbListView pbListView = this.f17889g;
        if (pbListView != null) {
            pbListView.f();
        }
        this.l.i(z, dataRes, 0, null);
        setHasMore(this.l.c());
    }

    public void B(String str, int i2) {
        PbListView pbListView = this.f17889g;
        if (pbListView != null) {
            pbListView.f();
        }
        this.l.i(true, null, i2, str);
    }

    public long getTagCode() {
        d.a.k0.j1.p.e eVar = this.f17887e;
        if (eVar == null) {
            return 0L;
        }
        return eVar.f56578a;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            v();
        }
    }

    public final void p(Object obj) {
        h hVar;
        if (this.f17891i == null || (hVar = this.l) == null || hVar.b() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.l.b()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f17891i.notifyDataSetChanged();
        }
    }

    public final void q() {
        d.a.j0.d0.g gVar = this.m;
        if (gVar != null) {
            gVar.dettachView(this);
            this.m = null;
        }
        d.a.k0.j1.c cVar = this.k;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void r() {
        d.a.j0.d0.h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this);
            this.n = null;
        }
    }

    public final void s(Context context) {
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(context);
        a2.registerListener(this.r);
        a2.registerListener(this.s);
        a2.registerListener(this.t);
        if (a2 instanceof TbPageContext) {
            this.j = (TbPageContext) a2;
        }
        BdListView bdListView = new BdListView(context);
        this.f17890h = bdListView;
        bdListView.setDividerHeight(0);
        this.f17890h.setSelector(17170445);
        d.a.k0.j1.n.a aVar = new d.a.k0.j1.n.a(this.j);
        this.f17891i = aVar;
        this.f17890h.setAdapter((ListAdapter) aVar);
        PbListView pbListView = new PbListView(context);
        this.f17889g = pbListView;
        pbListView.a();
        this.f17889g.o(R.color.CAM_X0204);
        this.f17889g.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f17889g.d(TbadkCoreApplication.getInst().getSkinType());
        d.a.j0.r.f0.g gVar = new d.a.j0.r.f0.g(this.j);
        this.f17888f = gVar;
        this.f17890h.setPullRefresh(gVar);
        this.f17888f.B(true);
        this.f17888f.a(new e());
        this.f17890h.setOnSrollToBottomListener(new f());
        this.f17890h.setOnScrollListener(this);
        h hVar = new h(this.f17890h, this.f17891i);
        this.l = hVar;
        hVar.l(this.u);
        addView(this.f17890h);
    }

    public void setCallback(d.a.k0.j1.c cVar) {
        this.k = cVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.a.j0.r.f0.g gVar = this.f17888f;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
    }

    public void setTagInfo(d.a.k0.j1.p.e eVar) {
        this.f17887e = eVar;
    }

    public void setViewBackGround() {
        u(true);
    }

    public void setViewForeground() {
        u(false);
    }

    public final boolean t() {
        d.a.j0.d0.h hVar = this.n;
        return hVar != null && hVar.isViewAttached();
    }

    public void u(boolean z) {
        if (this.f17890h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f17890h.getChildCount(); i2++) {
            View childAt = this.f17890h.getChildAt(i2);
            if (childAt instanceof d.a.k0.j1.o.l.e) {
                if (z) {
                    ((d.a.k0.j1.o.l.e) childAt).f();
                } else {
                    ((d.a.k0.j1.o.l.e) childAt).i();
                }
            }
        }
    }

    public final void v() {
        if (this.f17890h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f17890h.getChildCount(); i2++) {
            View childAt = this.f17890h.getChildAt(i2);
            if (childAt instanceof d.a.k0.j1.o.l.e) {
                ((d.a.k0.j1.o.l.e) childAt).h();
            }
        }
    }

    public void w(int i2) {
        d.a.j0.d0.g gVar = this.m;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        d.a.j0.d0.h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.j0.r.f0.g gVar2 = this.f17888f;
        if (gVar2 != null) {
            gVar2.I(i2);
        }
        BdListView bdListView = this.f17890h;
        if (bdListView != null) {
            SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204, i2);
        }
        PbListView pbListView = this.f17889g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17889g.d(i2);
        }
    }

    public final void x(boolean z, int i2) {
        if (this.m == null) {
            if (i2 < 0) {
                this.m = new d.a.j0.d0.g(getContext());
            } else {
                this.m = new d.a.j0.d0.g(getContext(), i2);
            }
            this.m.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public final void y(View view, String str, boolean z) {
        if (this.n == null) {
            this.n = new d.a.j0.d0.h(getContext(), new g());
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

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = new a(2001115);
        this.s = new b(2001335);
        this.t = new c(2001336);
        this.u = new d();
        s(context);
    }
}
