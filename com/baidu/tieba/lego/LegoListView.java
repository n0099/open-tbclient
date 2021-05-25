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
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.n0.g0.a;
import d.a.n0.k1.o.l.n;
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
    public d.a.m0.r.f0.g f17809e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f17810f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f17811g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.k1.n.a f17812h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17813i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public d.a.n0.k1.d n;
    public d.a.m0.d0.g o;
    public d.a.n0.k1.g p;
    public d.a.n0.k1.p.e q;
    public TbPageContext<?> r;
    public int s;
    public d.a.n0.k1.p.c t;
    public n u;
    public d.a.n0.g0.a v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12574a) {
                return;
            }
            LegoListView.this.k(updateAttentionMessage.getData());
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
            d.a.n0.k1.p.b bVar = new d.a.n0.k1.p.b();
            bVar.f56739a = String.valueOf(customResponsedMessage.getData());
            bVar.f56740b = true;
            LegoListView.this.k(bVar);
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
            d.a.n0.k1.p.b bVar = new d.a.n0.k1.p.b();
            bVar.f56739a = String.valueOf(customResponsedMessage.getData());
            bVar.f56740b = false;
            LegoListView.this.k(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
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

        @Override // d.a.n0.g0.a.b
        public void a(int i2, int i3) {
            LegoListView.this.y = false;
            LegoListView legoListView = LegoListView.this;
            legoListView.f17812h.H(legoListView.y);
        }

        @Override // d.a.n0.g0.a.b
        public void b(int i2, int i3) {
            LegoListView.this.y = true;
            LegoListView legoListView = LegoListView.this;
            legoListView.f17812h.H(legoListView.y);
        }

        @Override // d.a.n0.g0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.n0.g0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view != LegoListView.this.f17810f || LegoListView.this.v == null) {
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

        @Override // d.a.m0.r.f0.f.g
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
        if (this.f17810f == null || (pbListView = this.f17811g) == null) {
            return;
        }
        if (!this.f17813i) {
            pbListView.A("");
        } else if (z) {
            pbListView.A(getContext().getString(R.string.pb_load_more));
        } else {
            pbListView.A("");
        }
    }

    public BdListView getListView() {
        return this.f17810f;
    }

    public n getPlaySwitchController() {
        return this.u;
    }

    public final void k(Object obj) {
        d.a.n0.k1.p.c cVar;
        if (this.f17812h == null || (cVar = this.t) == null || cVar.e() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.t.e()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f17812h.notifyDataSetChanged();
        }
    }

    public final void l(View view) {
        d.a.m0.d0.g gVar = this.o;
        if (gVar != null) {
            gVar.dettachView(view);
            this.o = null;
        }
        d.a.m0.r.f0.g gVar2 = this.f17809e;
        if (gVar2 != null) {
            gVar2.B(true);
        }
        d.a.n0.k1.n.a aVar = this.f17812h;
        if (aVar != null) {
            aVar.G(true);
            this.f17812h.notifyDataSetChanged();
        }
    }

    public final void m(Context context, boolean z) {
        d.a.c.a.f<?> a2 = j.a(context);
        a2.registerListener(this.A);
        a2.registerListener(this.B);
        a2.registerListener(this.C);
        if (a2 instanceof TbPageContext) {
            this.r = (TbPageContext) a2;
        }
        BdListView bdListView = new BdListView(context);
        this.f17810f = bdListView;
        bdListView.setDividerHeight(0);
        this.f17810f.setSelector(17170445);
        addView(this.f17810f);
        if (!z) {
            this.f17810f.setVerticalScrollBarEnabled(true);
            n(context);
        } else {
            this.f17810f.setTranscriptMode(1);
            this.f17810f.setVerticalScrollBarEnabled(false);
        }
        this.f17810f.setOnSrollToBottomListener(this);
        this.f17810f.setOnScrollListener(this);
        o();
        d.a.n0.k1.n.a aVar = new d.a.n0.k1.n.a(this.r);
        this.f17812h = aVar;
        this.f17810f.setAdapter((ListAdapter) aVar);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
        s(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void n(Context context) {
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.r);
        this.f17809e = gVar;
        this.f17810f.setPullRefresh(gVar);
        PbListView pbListView = new PbListView(context);
        this.f17811g = pbListView;
        pbListView.a();
        this.f17811g.o(R.color.CAM_X0204);
        this.f17811g.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f17811g.d(TbadkCoreApplication.getInst().getSkinType());
        this.f17809e.a(new i(this, null));
    }

    public final void o() {
        this.u = new n(this.r, this.f17810f);
        d.a.n0.g0.a aVar = new d.a.n0.g0.a();
        this.v = aVar;
        aVar.d(this.E);
        this.f17810f.setOnTouchListener(this.F);
        this.f17810f.setRecyclerListener(new h());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.w = i2;
        this.x = (i2 + i3) - 1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        d.a.n0.k1.p.e eVar;
        if (i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            d.a.n0.k1.g gVar = this.p;
            if (gVar != null && (eVar = this.q) != null) {
                gVar.a(eVar, this.f17810f.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.l && l.D() && !this.m) {
            this.m = true;
            PbListView pbListView = this.f17811g;
            if (pbListView != null) {
                pbListView.O();
            }
            d.a.n0.k1.d dVar = this.n;
            if (dVar == null) {
                return;
            }
            if (this.f17812h == null) {
                d.a.n0.k1.p.e eVar = this.q;
                dVar.a(1, eVar.f56758a, eVar.f56759b, "");
                return;
            }
            d.a.n0.k1.p.c cVar = this.t;
            if (cVar != null) {
                d.a.n0.k1.d dVar2 = this.n;
                d.a.n0.k1.p.e eVar2 = this.q;
                dVar2.a(cVar.c() + 1, eVar2.f56758a, eVar2.f56759b, this.t.g());
            }
        }
    }

    public boolean p(long j, String str) {
        d.a.n0.k1.p.e eVar = this.q;
        return eVar != null && j == eVar.f56758a && TextUtils.equals(str, eVar.f56759b);
    }

    public final void q(boolean z) {
        if (this.f17810f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f17810f.getChildCount(); i2++) {
            View childAt = this.f17810f.getChildAt(i2);
            if (childAt instanceof d.a.n0.k1.o.l.e) {
                if (z) {
                    ((d.a.n0.k1.o.l.e) childAt).f();
                } else {
                    ((d.a.n0.k1.o.l.e) childAt).i();
                }
            }
        }
    }

    public final void r() {
        if (this.f17810f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f17810f.getChildCount(); i2++) {
            View childAt = this.f17810f.getChildAt(i2);
            if (childAt instanceof d.a.n0.k1.o.l.e) {
                ((d.a.n0.k1.o.l.e) childAt).h();
            }
        }
        n nVar = this.u;
        if (nVar != null) {
            nVar.j(this.w, this.x, this.y, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        d.a.m0.s0.a.a(this.r, this);
        SkinManager.setBackgroundColor(this.f17810f, R.color.CAM_X0204, i2);
        d.a.n0.k1.n.a aVar = this.f17812h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        d.a.m0.r.f0.g gVar = this.f17809e;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f17811g;
        if (pbListView != null) {
            pbListView.d(i2);
        }
    }

    public void setCallback(d.a.n0.k1.d dVar) {
        this.n = dVar;
    }

    public void setFriction(float f2) {
        BdListView bdListView = this.f17810f;
        if (bdListView != null) {
            bdListView.setFriction(f2);
        }
    }

    public void setImmersive(boolean z) {
    }

    public void setScrollCallback(d.a.n0.k1.g gVar) {
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
        if (this.f17813i && !l.D()) {
            if (this.f17812h.isEmpty()) {
                this.f17812h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.neterror), null, null);
                this.f17812h.notifyDataSetChanged();
            }
        } else if (this.z) {
            this.z = false;
            d.a.c.e.m.e.a().postDelayed(new e(), 200L);
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

    public void u(d.a.n0.k1.p.c cVar, boolean z) {
        BdListView bdListView = this.f17810f;
        if (bdListView != null) {
            bdListView.z();
        }
        PbListView pbListView = this.f17811g;
        if (pbListView != null) {
            pbListView.f();
        }
        if (cVar == null) {
            setHasMore(false);
            l(this);
            this.f17812h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
            this.f17812h.notifyDataSetChanged();
            return;
        }
        this.t = cVar;
        this.m = false;
        this.j = cVar.n();
        this.f17813i = cVar.m();
        this.k = cVar.o();
        this.q = cVar.i();
        setHasMore(cVar.a());
        List<ICardInfo> e2 = cVar.e();
        if (this.f17812h != null) {
            if (e2 != null && e2.size() > 0) {
                PbListView pbListView2 = this.f17811g;
                if (pbListView2 != null) {
                    if (pbListView2.b().getParent() == null) {
                        this.f17810f.setNextPage(this.f17811g);
                    }
                    if (this.l) {
                        this.f17811g.A(getContext().getString(R.string.pb_load_more));
                    } else if (e2.get(e2.size() - 1) instanceof WebViewCard) {
                        this.f17811g.A("");
                    } else {
                        this.f17811g.A(getContext().getString(R.string.list_no_more));
                    }
                }
            } else {
                if (this.f17813i && this.j) {
                    this.f17812h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.f17812h.F(null, null, null, null);
                }
                setHasMore(false);
            }
            this.f17812h.C(e2);
        }
        if (z) {
            this.f17810f.setSelection(cVar.h());
        }
        if (this.j || !(e2 == null || e2.isEmpty())) {
            l(this);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        d.a.m0.r.f0.g gVar = this.f17809e;
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
                this.o = new d.a.m0.d0.g(getContext());
            } else {
                this.o = new d.a.m0.d0.g(getContext(), i2);
            }
            this.o.onChangeSkinType();
        }
        this.o.attachView(view, z);
        d.a.m0.r.f0.g gVar = this.f17809e;
        if (gVar != null) {
            gVar.B(false);
        }
        d.a.n0.k1.n.a aVar = this.f17812h;
        if (aVar != null) {
            aVar.G(false);
            this.f17812h.notifyDataSetChanged();
        }
    }

    public final void y() {
        if (this.f17813i) {
            d.a.n0.k1.d dVar = this.n;
            d.a.n0.k1.p.e eVar = this.q;
            dVar.a(1, eVar.f56758a, eVar.f56759b, "");
            return;
        }
        d.a.n0.k1.d dVar2 = this.n;
        d.a.n0.k1.p.e eVar2 = this.q;
        dVar2.b(eVar2.f56758a, eVar2.f56759b);
    }

    public void z(String str) {
        BdListView bdListView = this.f17810f;
        if (bdListView != null) {
            bdListView.z();
        }
        this.m = false;
        PbListView pbListView = this.f17811g;
        if (pbListView != null) {
            pbListView.f();
        }
        if (this.f17812h.getCount() <= 0 && this.f17813i) {
            this.f17812h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.c(str), null, null);
            this.f17812h.C(new ArrayList());
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
