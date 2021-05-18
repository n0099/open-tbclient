package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.ScrollFragmentTabHost;
import com.squareup.wire.Message;
import d.a.j0.d0.g;
import d.a.j0.d0.h;
import d.a.k0.j1.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoTabFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f17944e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.j1.s.a f17945f;

    /* renamed from: g  reason: collision with root package name */
    public h f17946g;

    /* renamed from: h  reason: collision with root package name */
    public g f17947h;

    /* renamed from: i  reason: collision with root package name */
    public long f17948i;
    public String j;
    public String k;
    public String l;
    public String m;
    public j o;
    public List<d.a.k0.j1.p.d> n = new ArrayList();
    public d.a.k0.j1.d p = new a();
    public d.a.k0.j1.c q = new b();
    public CustomMessageListener r = new c(2016449);

    /* loaded from: classes4.dex */
    public class a implements d.a.k0.j1.d {
        public a() {
        }

        @Override // d.a.k0.j1.d
        public void a(int i2, long j, String str, String str2) {
            LegoTabFragment.this.f17945f.c(2, j, str, i2, str2);
        }

        @Override // d.a.k0.j1.d
        public void b(long j, String str) {
            LegoTabFragment.this.f17945f.a(j, str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.k0.j1.c {
        public b() {
        }

        @Override // d.a.k0.j1.c
        public void a(List<d.a.k0.j1.p.d> list) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            List<d.a.k0.j1.p.d> list2 = legoTabFragment.n;
            if (list2 == null) {
                legoTabFragment.n = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.n.addAll(list);
            }
            LegoTabFragment.this.Z0();
        }

        @Override // d.a.k0.j1.c
        public void b() {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.Q0(legoTabFragment.getView());
        }

        @Override // d.a.k0.j1.c
        public void c(long j, String str) {
            LegoTabFragment.this.f17945f.c(1, j, str, 1, "");
        }

        @Override // d.a.k0.j1.c
        public void d(String str, String str2, String str3, List<d.a.k0.j1.p.e> list) {
            LegoTabFragment.this.k = str;
            LegoTabFragment.this.l = str2;
            LegoTabFragment.this.m = str3;
            LegoTabFragment.this.U0();
            LegoTabFragment.this.T0(list);
        }

        @Override // d.a.k0.j1.c
        public void e(long j, String str, int i2, String str2) {
            LegoTabFragment.this.f17945f.c(1, j, str, i2, str2);
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
            LegoTabFragment.this.U0();
            LegoTabFragment.this.Z0();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.k0.j1.s.b {
        public d() {
        }

        @Override // d.a.k0.j1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            LegoTabFragment.this.U0();
            if (z) {
                LegoTabFragment legoTabFragment = LegoTabFragment.this;
                legoTabFragment.Q0(legoTabFragment.getView());
            }
            DataRes dataRes = (DataRes) message;
            if (!z || LegoTabFragment.this.f17944e.f() || (dataRes != null && dataRes.cards != null)) {
                LegoTabFragment.this.f17944e.n(z, j, str, dataRes, z2, i2);
            } else if (LegoTabFragment.this.getPageContext() == null || LegoTabFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoTabFragment legoTabFragment2 = LegoTabFragment.this;
                legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
            }
        }

        @Override // d.a.k0.j1.s.b
        public void b(long j, String str, String str2, int i2) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.Q0(legoTabFragment.getView());
            if (LegoTabFragment.this.f17944e.f()) {
                LegoTabFragment.this.f17944e.o(j, str, str2, i2);
            } else if (LegoTabFragment.this.getPageContext() == null || LegoTabFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoTabFragment legoTabFragment2 = LegoTabFragment.this;
                legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
            }
        }

        @Override // d.a.k0.j1.s.b
        public void c(long j, String str, Message message, boolean z) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.Q0(legoTabFragment.getView());
            LegoTabFragment.this.f17944e.p(j, str, (DataRes) message, z);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoTabFragment.this.f17945f != null) {
                LegoTabFragment.this.f17945f.c(1, LegoTabFragment.this.f17948i, LegoTabFragment.this.j, 1, "");
                LegoTabFragment.this.R0();
                LegoTabFragment legoTabFragment = LegoTabFragment.this;
                legoTabFragment.Y0(legoTabFragment.getView(), false, LegoTabFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    public final void Q0(View view) {
        g gVar = this.f17947h;
        if (gVar != null) {
            gVar.dettachView(view);
            this.f17947h = null;
        }
    }

    public final void R0() {
        h hVar = this.f17946g;
        if (hVar != null) {
            hVar.dettachView(getView());
            this.f17946g = null;
        }
    }

    public final void S0() {
        d.a.k0.j1.s.a c2 = d.a.k0.j1.r.b.d().c(getPageContext(), getUniqueId());
        this.f17945f = c2;
        c2.b(new d());
    }

    public final void T0(List<d.a.k0.j1.p.e> list) {
        int count = ListUtils.getCount(list);
        if (count > 0 && this.f17944e != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= count) {
                    break;
                } else if (list.get(i3).f56578a == this.f17948i) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            this.f17944e.setFirstPosition(i2);
            this.f17944e.d(list, i2);
            this.f17944e.setCurrentTab(i2);
        }
    }

    public final void U0() {
        if (this.o != null) {
            if (!TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.m)) {
                this.o.j(this.l, this.m);
            } else {
                this.o.i(this.k);
            }
        }
    }

    public void V0(String str) {
        this.j = str;
    }

    public void W0(j jVar) {
        this.o = jVar;
    }

    public void X0(long j) {
        this.f17948i = j;
    }

    public final void Y0(View view, boolean z, int i2) {
        if (this.f17947h == null) {
            if (i2 < 0) {
                this.f17947h = new g(getActivity());
            } else {
                this.f17947h = new g(getActivity(), i2);
            }
            this.f17947h.onChangeSkinType();
        }
        this.f17947h.attachView(view, z);
    }

    public final void Z0() {
        j jVar = this.o;
        if (jVar != null) {
            jVar.g(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        S0();
        ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
        this.f17944e = scrollFragmentTabHost;
        scrollFragmentTabHost.setPageUniqueId(getUniqueId());
        this.f17944e.h(this.p, this.q);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f17944e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.k(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.r);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lego_tab_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        super.onPrimary();
        if (isPrimary() && (scrollFragmentTabHost = this.f17944e) != null && scrollFragmentTabHost.j()) {
            this.f17944e.m(this.f17948i, this.j);
            Y0(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.f17946g == null) {
            this.f17946g = new h(getPageContext().getPageActivity(), new e());
        }
        this.f17946g.j(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.f17946g.l(str);
        this.f17946g.attachView(view, z);
        this.f17946g.o();
    }
}
