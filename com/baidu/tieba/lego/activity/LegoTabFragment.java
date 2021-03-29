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
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import d.b.i0.i1.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class LegoTabFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public ScrollFragmentTabHost f18589e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.i1.s.a f18590f;

    /* renamed from: g  reason: collision with root package name */
    public h f18591g;

    /* renamed from: h  reason: collision with root package name */
    public g f18592h;
    public long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public j o;
    public List<d.b.i0.i1.p.d> n = new ArrayList();
    public d.b.i0.i1.d p = new a();
    public d.b.i0.i1.c q = new b();
    public CustomMessageListener r = new c(2016449);

    /* loaded from: classes3.dex */
    public class a implements d.b.i0.i1.d {
        public a() {
        }

        @Override // d.b.i0.i1.d
        public void a(int i, long j, String str, String str2) {
            LegoTabFragment.this.f18590f.c(2, j, str, i, str2);
        }

        @Override // d.b.i0.i1.d
        public void b(long j, String str) {
            LegoTabFragment.this.f18590f.a(j, str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.i0.i1.c {
        public b() {
        }

        @Override // d.b.i0.i1.c
        public void a() {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.R0(legoTabFragment.getView());
        }

        @Override // d.b.i0.i1.c
        public void b(List<d.b.i0.i1.p.d> list) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            List<d.b.i0.i1.p.d> list2 = legoTabFragment.n;
            if (list2 == null) {
                legoTabFragment.n = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.n.addAll(list);
            }
            LegoTabFragment.this.a1();
        }

        @Override // d.b.i0.i1.c
        public void c(long j, String str) {
            LegoTabFragment.this.f18590f.c(1, j, str, 1, "");
        }

        @Override // d.b.i0.i1.c
        public void d(String str, String str2, String str3, List<d.b.i0.i1.p.e> list) {
            LegoTabFragment.this.k = str;
            LegoTabFragment.this.l = str2;
            LegoTabFragment.this.m = str3;
            LegoTabFragment.this.V0();
            LegoTabFragment.this.U0(list);
        }

        @Override // d.b.i0.i1.c
        public void e(long j, String str, int i, String str2) {
            LegoTabFragment.this.f18590f.c(1, j, str, i, str2);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            LegoTabFragment.this.V0();
            LegoTabFragment.this.a1();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.i0.i1.s.b {
        public d() {
        }

        @Override // d.b.i0.i1.s.b
        public void a(long j, String str, String str2, int i) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.R0(legoTabFragment.getView());
            if (LegoTabFragment.this.f18589e.f()) {
                LegoTabFragment.this.f18589e.o(j, str, str2, i);
            } else if (LegoTabFragment.this.getPageContext() == null || LegoTabFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoTabFragment legoTabFragment2 = LegoTabFragment.this;
                legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
            }
        }

        @Override // d.b.i0.i1.s.b
        public void b(long j, String str, Message message, boolean z) {
            LegoTabFragment legoTabFragment = LegoTabFragment.this;
            legoTabFragment.R0(legoTabFragment.getView());
            LegoTabFragment.this.f18589e.p(j, str, (DataRes) message, z);
        }

        @Override // d.b.i0.i1.s.b
        public void c(boolean z, Message message, boolean z2, long j, String str, int i) {
            LegoTabFragment.this.V0();
            if (z) {
                LegoTabFragment legoTabFragment = LegoTabFragment.this;
                legoTabFragment.R0(legoTabFragment.getView());
            }
            DataRes dataRes = (DataRes) message;
            if (!z || LegoTabFragment.this.f18589e.f() || (dataRes != null && dataRes.cards != null)) {
                LegoTabFragment.this.f18589e.n(z, j, str, dataRes, z2, i);
            } else if (LegoTabFragment.this.getPageContext() == null || LegoTabFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoTabFragment legoTabFragment2 = LegoTabFragment.this;
                legoTabFragment2.showNetRefreshView(legoTabFragment2.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoTabFragment.this.f18590f != null) {
                LegoTabFragment.this.f18590f.c(1, LegoTabFragment.this.i, LegoTabFragment.this.j, 1, "");
                LegoTabFragment.this.S0();
                LegoTabFragment legoTabFragment = LegoTabFragment.this;
                legoTabFragment.Z0(legoTabFragment.getView(), false, LegoTabFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    public final void R0(View view) {
        g gVar = this.f18592h;
        if (gVar != null) {
            gVar.dettachView(view);
            this.f18592h = null;
        }
    }

    public final void S0() {
        h hVar = this.f18591g;
        if (hVar != null) {
            hVar.dettachView(getView());
            this.f18591g = null;
        }
    }

    public final void T0() {
        d.b.i0.i1.s.a a2 = d.b.i0.i1.r.b.d().a(getPageContext(), getUniqueId());
        this.f18590f = a2;
        a2.b(new d());
    }

    public final void U0(List<d.b.i0.i1.p.e> list) {
        int count = ListUtils.getCount(list);
        if (count > 0 && this.f18589e != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    break;
                } else if (list.get(i2).f56031a == this.i) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.f18589e.setFirstPosition(i);
            this.f18589e.d(list, i);
            this.f18589e.setCurrentTab(i);
        }
    }

    public final void V0() {
        if (this.o != null) {
            if (!TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.m)) {
                this.o.j(this.l, this.m);
            } else {
                this.o.i(this.k);
            }
        }
    }

    public void W0(String str) {
        this.j = str;
    }

    public void X0(j jVar) {
        this.o = jVar;
    }

    public void Y0(long j) {
        this.i = j;
    }

    public final void Z0(View view, boolean z, int i) {
        if (this.f18592h == null) {
            if (i < 0) {
                this.f18592h = new g(getActivity());
            } else {
                this.f18592h = new g(getActivity(), i);
            }
            this.f18592h.onChangeSkinType();
        }
        this.f18592h.attachView(view, z);
    }

    public final void a1() {
        j jVar = this.o;
        if (jVar != null) {
            jVar.g(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        T0();
        ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
        this.f18589e = scrollFragmentTabHost;
        scrollFragmentTabHost.setPageUniqueId(getUniqueId());
        this.f18589e.h(this.p, this.q);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ScrollFragmentTabHost scrollFragmentTabHost = this.f18589e;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.k(i);
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
        if (isPrimary() && (scrollFragmentTabHost = this.f18589e) != null && scrollFragmentTabHost.j()) {
            this.f18589e.m(this.i, this.j);
            Z0(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.f18591g == null) {
            this.f18591g = new h(getPageContext().getPageActivity(), new e());
        }
        this.f18591g.j(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.f18591g.l(str);
        this.f18591g.attachView(view, z);
        this.f18591g.o();
    }
}
