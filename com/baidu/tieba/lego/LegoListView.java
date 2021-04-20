package com.baidu.tieba.lego;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.WebViewCard;
import d.b.c.a.j;
import d.b.c.e.p.l;
import d.b.h0.r.f0.f;
import d.b.i0.f0.a;
import d.b.i0.j1.o.l.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public a.b E;
    public View.OnTouchListener F;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f18224e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f18225f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f18226g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.j1.n.a f18227h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public d.b.i0.j1.d n;
    public d.b.h0.d0.g o;
    public d.b.i0.j1.g p;
    public d.b.i0.j1.p.e q;
    public TbPageContext<?> r;
    public int s;
    public d.b.i0.j1.p.c t;
    public n u;
    public d.b.i0.f0.a v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f13354a) {
                return;
            }
            LegoListView.this.k(updateAttentionMessage.getData());
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
            d.b.i0.j1.p.b bVar = new d.b.i0.j1.p.b();
            bVar.f57460a = String.valueOf(customResponsedMessage.getData());
            bVar.f57461b = true;
            LegoListView.this.k(bVar);
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
            d.b.i0.j1.p.b bVar = new d.b.i0.j1.p.b();
            bVar.f57460a = String.valueOf(customResponsedMessage.getData());
            bVar.f57461b = false;
            LegoListView.this.k(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            LegoListView.this.z = true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LegoListView.this.w();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.b {
        public f() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            LegoListView.this.y = false;
            LegoListView legoListView = LegoListView.this;
            legoListView.f18227h.H(legoListView.y);
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            LegoListView.this.y = true;
            LegoListView legoListView = LegoListView.this;
            legoListView.f18227h.H(legoListView.y);
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view != LegoListView.this.f18225f || LegoListView.this.v == null) {
                return false;
            }
            LegoListView.this.v.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements AbsListView.RecyclerListener {
        public h() {
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            if (LegoListView.this.u != null) {
                LegoListView.this.u.h(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements f.g {
        public i() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (LegoListView.this.n == null) {
                return;
            }
            LegoListView.this.y();
        }

        public /* synthetic */ i(LegoListView legoListView, a aVar) {
            this();
        }
    }

    public LegoListView(Context context) {
        this(context, false);
    }

    private void setHasMore(boolean z) {
        PbListView pbListView;
        this.l = z;
        if (this.f18225f == null || (pbListView = this.f18226g) == null) {
            return;
        }
        if (!this.i) {
            pbListView.A("");
        } else if (z) {
            pbListView.A(getContext().getString(R.string.pb_load_more));
        } else {
            pbListView.A("");
        }
    }

    public BdListView getListView() {
        return this.f18225f;
    }

    public n getPlaySwitchController() {
        return this.u;
    }

    public final void k(Object obj) {
        d.b.i0.j1.p.c cVar;
        if (this.f18227h == null || (cVar = this.t) == null || cVar.e() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.t.e()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f18227h.notifyDataSetChanged();
        }
    }

    public final void l(View view) {
        d.b.h0.d0.g gVar = this.o;
        if (gVar != null) {
            gVar.dettachView(view);
            this.o = null;
        }
        d.b.h0.r.f0.g gVar2 = this.f18224e;
        if (gVar2 != null) {
            gVar2.B(true);
        }
        d.b.i0.j1.n.a aVar = this.f18227h;
        if (aVar != null) {
            aVar.G(true);
            this.f18227h.notifyDataSetChanged();
        }
    }

    public final void m(Context context, boolean z) {
        d.b.c.a.f<?> a2 = j.a(context);
        a2.registerListener(this.A);
        a2.registerListener(this.B);
        a2.registerListener(this.C);
        if (a2 instanceof TbPageContext) {
            this.r = (TbPageContext) a2;
        }
        BdListView bdListView = new BdListView(context);
        this.f18225f = bdListView;
        bdListView.setDividerHeight(0);
        this.f18225f.setSelector(17170445);
        addView(this.f18225f);
        if (!z) {
            this.f18225f.setVerticalScrollBarEnabled(true);
            n(context);
        } else {
            this.f18225f.setTranscriptMode(1);
            this.f18225f.setVerticalScrollBarEnabled(false);
        }
        this.f18225f.setOnSrollToBottomListener(this);
        this.f18225f.setOnScrollListener(this);
        o();
        d.b.i0.j1.n.a aVar = new d.b.i0.j1.n.a(this.r);
        this.f18227h = aVar;
        this.f18225f.setAdapter((ListAdapter) aVar);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
        s(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void n(Context context) {
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.r);
        this.f18224e = gVar;
        this.f18225f.setPullRefresh(gVar);
        PbListView pbListView = new PbListView(context);
        this.f18226g = pbListView;
        pbListView.a();
        this.f18226g.o(R.color.CAM_X0204);
        this.f18226g.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f18226g.d(TbadkCoreApplication.getInst().getSkinType());
        this.f18224e.b(new i(this, null));
    }

    public final void o() {
        this.u = new n(this.r, this.f18225f);
        d.b.i0.f0.a aVar = new d.b.i0.f0.a();
        this.v = aVar;
        aVar.d(this.E);
        this.f18225f.setOnTouchListener(this.F);
        this.f18225f.setRecyclerListener(new h());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.w = i2;
        this.x = (i2 + i3) - 1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        d.b.i0.j1.p.e eVar;
        if (i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            d.b.i0.j1.g gVar = this.p;
            if (gVar != null && (eVar = this.q) != null) {
                gVar.a(eVar, this.f18225f.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.l && l.C() && !this.m) {
            this.m = true;
            PbListView pbListView = this.f18226g;
            if (pbListView != null) {
                pbListView.O();
            }
            d.b.i0.j1.d dVar = this.n;
            if (dVar == null) {
                return;
            }
            if (this.f18227h == null) {
                d.b.i0.j1.p.e eVar = this.q;
                dVar.a(1, eVar.f57478a, eVar.f57479b, "");
                return;
            }
            d.b.i0.j1.p.c cVar = this.t;
            if (cVar != null) {
                d.b.i0.j1.d dVar2 = this.n;
                d.b.i0.j1.p.e eVar2 = this.q;
                dVar2.a(cVar.a() + 1, eVar2.f57478a, eVar2.f57479b, this.t.g());
            }
        }
    }

    public boolean p(long j, String str) {
        d.b.i0.j1.p.e eVar = this.q;
        return eVar != null && j == eVar.f57478a && TextUtils.equals(str, eVar.f57479b);
    }

    public final void q(boolean z) {
        if (this.f18225f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18225f.getChildCount(); i2++) {
            View childAt = this.f18225f.getChildAt(i2);
            if (childAt instanceof d.b.i0.j1.o.l.e) {
                if (z) {
                    ((d.b.i0.j1.o.l.e) childAt).f();
                } else {
                    ((d.b.i0.j1.o.l.e) childAt).h();
                }
            }
        }
    }

    public final void r() {
        if (this.f18225f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18225f.getChildCount(); i2++) {
            View childAt = this.f18225f.getChildAt(i2);
            if (childAt instanceof d.b.i0.j1.o.l.e) {
                ((d.b.i0.j1.o.l.e) childAt).e();
            }
        }
        n nVar = this.u;
        if (nVar != null) {
            nVar.j(this.w, this.x, this.y, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        d.b.h0.s0.a.a(this.r, this);
        SkinManager.setBackgroundColor(this.f18225f, R.color.CAM_X0204, i2);
        d.b.i0.j1.n.a aVar = this.f18227h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        d.b.h0.r.f0.g gVar = this.f18224e;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f18226g;
        if (pbListView != null) {
            pbListView.d(i2);
        }
    }

    public void setCallback(d.b.i0.j1.d dVar) {
        this.n = dVar;
    }

    public void setFriction(float f2) {
        BdListView bdListView = this.f18225f;
        if (bdListView != null) {
            bdListView.setFriction(f2);
        }
    }

    public void setImmersive(boolean z) {
    }

    public void setScrollCallback(d.b.i0.j1.g gVar) {
        this.p = gVar;
    }

    public void setViewBackGround() {
        q(true);
    }

    public void setViewForeground() {
        q(false);
        n nVar = this.u;
        if (nVar != null) {
            nVar.n(true);
            this.u.k(this.w, this.x, this.y, true);
        }
        if (this.k || this.j) {
            return;
        }
        if (this.i && !l.C()) {
            if (this.f18227h.isEmpty()) {
                this.f18227h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.neterror), null, null);
                this.f18227h.notifyDataSetChanged();
            }
        } else if (this.z) {
            this.z = false;
            d.b.c.e.m.e.a().postDelayed(new e(), 200L);
        } else {
            w();
        }
    }

    public void t() {
        n nVar = this.u;
        if (nVar != null) {
            nVar.c();
        }
    }

    public void u(d.b.i0.j1.p.c cVar, boolean z) {
        BdListView bdListView = this.f18225f;
        if (bdListView != null) {
            bdListView.z();
        }
        PbListView pbListView = this.f18226g;
        if (pbListView != null) {
            pbListView.f();
        }
        if (cVar == null) {
            setHasMore(false);
            l(this);
            this.f18227h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
            this.f18227h.notifyDataSetChanged();
            return;
        }
        this.t = cVar;
        this.m = false;
        this.j = cVar.n();
        this.i = cVar.m();
        this.k = cVar.o();
        this.q = cVar.i();
        setHasMore(cVar.b());
        List<ICardInfo> e2 = cVar.e();
        if (this.f18227h != null) {
            if (e2 != null && e2.size() > 0) {
                PbListView pbListView2 = this.f18226g;
                if (pbListView2 != null) {
                    if (pbListView2.b().getParent() == null) {
                        this.f18225f.setNextPage(this.f18226g);
                    }
                    if (this.l) {
                        this.f18226g.A(getContext().getString(R.string.pb_load_more));
                    } else if (e2.get(e2.size() - 1) instanceof WebViewCard) {
                        this.f18226g.A("");
                    } else {
                        this.f18226g.A(getContext().getString(R.string.list_no_more));
                    }
                }
            } else {
                if (this.i && this.j) {
                    this.f18227h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.f18227h.F(null, null, null, null);
                }
                setHasMore(false);
            }
            this.f18227h.C(e2);
        }
        if (z) {
            this.f18225f.setSelection(cVar.h());
        }
        if (this.j || !(e2 == null || e2.isEmpty())) {
            l(this);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        d.b.h0.r.f0.g gVar = this.f18224e;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
        this.D.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.D);
    }

    public final void w() {
        x(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
        y();
    }

    public final void x(View view, boolean z, int i2) {
        if (this.o == null) {
            if (i2 < 0) {
                this.o = new d.b.h0.d0.g(getContext());
            } else {
                this.o = new d.b.h0.d0.g(getContext(), i2);
            }
            this.o.onChangeSkinType();
        }
        this.o.attachView(view, z);
        d.b.h0.r.f0.g gVar = this.f18224e;
        if (gVar != null) {
            gVar.B(false);
        }
        d.b.i0.j1.n.a aVar = this.f18227h;
        if (aVar != null) {
            aVar.G(false);
            this.f18227h.notifyDataSetChanged();
        }
    }

    public final void y() {
        if (this.i) {
            d.b.i0.j1.d dVar = this.n;
            d.b.i0.j1.p.e eVar = this.q;
            dVar.a(1, eVar.f57478a, eVar.f57479b, "");
            return;
        }
        d.b.i0.j1.d dVar2 = this.n;
        d.b.i0.j1.p.e eVar2 = this.q;
        dVar2.b(eVar2.f57478a, eVar2.f57479b);
    }

    public void z(String str) {
        BdListView bdListView = this.f18225f;
        if (bdListView != null) {
            bdListView.z();
        }
        this.m = false;
        PbListView pbListView = this.f18226g;
        if (pbListView != null) {
            pbListView.f();
        }
        if (this.f18227h.getCount() <= 0 && this.i) {
            this.f18227h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.c(str), null, null);
            this.f18227h.C(new ArrayList());
        }
        l(this);
    }

    public LegoListView(Context context, boolean z) {
        super(context);
        this.w = 0;
        this.x = 0;
        this.z = false;
        this.A = new a(2001115);
        this.B = new b(2001335);
        this.C = new c(2001336);
        this.D = new d(2016448);
        this.E = new f();
        this.F = new g();
        m(context, z);
    }
}
