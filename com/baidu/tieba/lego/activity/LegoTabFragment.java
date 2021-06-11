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
import d.a.m0.d0.g;
import d.a.m0.d0.h;
import d.a.n0.k1.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoTabFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f17930e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.k1.s.a f17931f;

    /* renamed from: g  reason: collision with root package name */
    public h f17932g;

    /* renamed from: h  reason: collision with root package name */
    public g f17933h;

    /* renamed from: i  reason: collision with root package name */
    public long f17934i;
    public String j;
    public String k;
    public String l;
    public String m;
    public j o;
    public List<d.a.n0.k1.p.d> n = new ArrayList();
    public d.a.n0.k1.d p = new a();
    public d.a.n0.k1.c q = new b();
    public CustomMessageListener r = new c(2016449);

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.k1.d {
        public a() {
        }

        @Override // d.a.n0.k1.d
        public void a(int i2, long j, String str, String str2) {
            LegoTabFragment.this.f17931f.c(2, j, str, i2, str2);
        }

        @Override // d.a.n0.k1.d
        public void b(long j, String str) {
            LegoTabFragment.this.f17931f.a(j, str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.k1.c {
        public b() {
        }

        @Override // d.a.n0.k1.c
        public void a(List<d.a.n0.k1.p.d> list) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            List<d.a.n0.k1.p.d> list2 = legoTabFragment.n;
            if (list2 == null) {
                legoTabFragment.n = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.n.addAll(list);
            }
            LegoTabFragment.this.c1();
        }

        @Override // d.a.n0.k1.c
        public void b() {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.T0(legoTabFragment.getView());
        }

        @Override // d.a.n0.k1.c
        public void c(long j, String str) {
            LegoTabFragment.this.f17931f.c(1, j, str, 1, "");
        }

        @Override // d.a.n0.k1.c
        public void d(String str, String str2, String str3, List<d.a.n0.k1.p.e> list) {
            LegoTabFragment.this.k = str;
            LegoTabFragment.this.l = str2;
            LegoTabFragment.this.m = str3;
            LegoTabFragment.this.X0();
            LegoTabFragment.this.W0(list);
        }

        @Override // d.a.n0.k1.c
        public void e(long j, String str, int i2, String str2) {
            LegoTabFragment.this.f17931f.c(1, j, str, i2, str2);
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
            LegoTabFragment.this.X0();
            LegoTabFragment.this.c1();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.n0.k1.s.b {
        public d() {
        }

        @Override // d.a.n0.k1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            LegoTabFragment.this.X0();
            if (z) {
                LegoTabFragment legoTabFragment = LegoTabFragment.this;
                legoTabFragment.T0(legoTabFragment.getView());
            }
            DataRes dataRes = (DataRes) message;
            if (!z || LegoTabFragment.this.f17930e.f() || (dataRes != null && dataRes.cards != null)) {
                LegoTabFragment.this.f17930e.n(z, j, str, dataRes, z2, i2);
            } else if (LegoTabFragment.this.getPageContext() == null || LegoTabFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoTabFragment legoTabFragment2 = LegoTabFragment.this;
                legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
            }
        }

        @Override // d.a.n0.k1.s.b
        public void b(long j, String str, String str2, int i2) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.T0(legoTabFragment.getView());
            if (LegoTabFragment.this.f17930e.f()) {
                LegoTabFragment.this.f17930e.o(j, str, str2, i2);
            } else if (LegoTabFragment.this.getPageContext() == null || LegoTabFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoTabFragment legoTabFragment2 = LegoTabFragment.this;
                legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
            }
        }

        @Override // d.a.n0.k1.s.b
        public void c(long j, String str, Message message, boolean z) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.T0(legoTabFragment.getView());
            LegoTabFragment.this.f17930e.p(j, str, (DataRes) message, z);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoTabFragment.this.f17931f != null) {
                LegoTabFragment.this.f17931f.c(1, LegoTabFragment.this.f17934i, LegoTabFragment.this.j, 1, "");
                LegoTabFragment.this.U0();
                LegoTabFragment legoTabFragment = LegoTabFragment.this;
                legoTabFragment.b1(legoTabFragment.getView(), false, LegoTabFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    public final void T0(View view) {
        g gVar = this.f17933h;
        if (gVar != null) {
            gVar.dettachView(view);
            this.f17933h = null;
        }
    }

    public final void U0() {
        h hVar = this.f17932g;
        if (hVar != null) {
            hVar.dettachView(getView());
            this.f17932g = null;
        }
    }

    public final void V0() {
        d.a.n0.k1.s.a c2 = d.a.n0.k1.r.b.d().c(getPageContext(), getUniqueId());
        this.f17931f = c2;
        c2.b(new d());
    }

    public final void W0(List<d.a.n0.k1.p.e> list) {
        int count = ListUtils.getCount(list);
        if (count > 0 && this.f17930e != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= count) {
                    break;
                } else if (list.get(i3).f60447a == this.f17934i) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            this.f17930e.setFirstPosition(i2);
            this.f17930e.d(list, i2);
            this.f17930e.setCurrentTab(i2);
        }
    }

    public final void X0() {
        if (this.o != null) {
            if (!TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.m)) {
                this.o.j(this.l, this.m);
            } else {
                this.o.i(this.k);
            }
        }
    }

    public void Y0(String str) {
        this.j = str;
    }

    public void Z0(j jVar) {
        this.o = jVar;
    }

    public void a1(long j) {
        this.f17934i = j;
    }

    public final void b1(View view, boolean z, int i2) {
        if (this.f17933h == null) {
            if (i2 < 0) {
                this.f17933h = new g(getActivity());
            } else {
                this.f17933h = new g(getActivity(), i2);
            }
            this.f17933h.onChangeSkinType();
        }
        this.f17933h.attachView(view, z);
    }

    public final void c1() {
        j jVar = this.o;
        if (jVar != null) {
            jVar.g(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        V0();
        ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
        this.f17930e = scrollFragmentTabHost;
        scrollFragmentTabHost.setPageUniqueId(getUniqueId());
        this.f17930e.h(this.p, this.q);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f17930e;
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
        if (isPrimary() && (scrollFragmentTabHost = this.f17930e) != null && scrollFragmentTabHost.j()) {
            this.f17930e.m(this.f17934i, this.j);
            b1(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.f17932g == null) {
            this.f17932g = new h(getPageContext().getPageActivity(), new e());
        }
        this.f17932g.j(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.f17932g.l(str);
        this.f17932g.attachView(view, z);
        this.f17932g.o();
    }
}
