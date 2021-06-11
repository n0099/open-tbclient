package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.n0.k1.d;
import d.a.n0.k1.p.e;
import d.a.n0.k1.q.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18052e;

    /* renamed from: f  reason: collision with root package name */
    public CustomViewPager f18053f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.k1.q.a f18054g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f18055h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollFragmentAdapter f18056i;
    public List<e> j;
    public FrameLayout k;
    public c l;
    public BdUniqueId m;
    public View.OnClickListener n;
    public c.InterfaceC1470c o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScrollFragmentTabHost.this.i()) {
                ScrollFragmentTabHost.this.e();
            } else {
                ScrollFragmentTabHost.this.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.InterfaceC1470c {
        public b() {
        }

        @Override // d.a.n0.k1.q.c.InterfaceC1470c
        public void a() {
            if (ScrollFragmentTabHost.this.f18054g != null) {
                ScrollFragmentTabHost.this.f18054g.d();
            }
            if (ScrollFragmentTabHost.this.l != null) {
                ScrollFragmentTabHost.this.l.l(null);
                ScrollFragmentTabHost.this.l = null;
            }
        }
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.n = new a();
        this.o = new b();
        g(context);
    }

    public void d(List<e> list, int i2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null) {
                arrayList.add(new d.a.n0.k1.p.c(eVar));
            }
        }
        this.j = list;
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18056i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.p(arrayList);
            d.a.n0.k1.q.a aVar = this.f18054g;
            if (aVar != null) {
                aVar.i(this.f18053f, i2);
            }
        }
    }

    public void e() {
        c cVar = this.l;
        if (cVar != null) {
            cVar.f(this.f18052e);
        }
    }

    public boolean f() {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18056i;
        return scrollFragmentAdapter != null && scrollFragmentAdapter.getCount() > 0;
    }

    public final void g(Context context) {
        this.f18052e = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.f18055h = (NoNetworkView) findViewById(R.id.view_no_network);
        d.a.n0.k1.q.a aVar = new d.a.n0.k1.q.a(context, findViewById(R.id.tab_container));
        this.f18054g = aVar;
        aVar.h(this.n);
        this.k = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void h(d dVar, d.a.n0.k1.c cVar) {
        this.f18053f = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f18052e, dVar, cVar, this.m);
        this.f18056i = scrollFragmentAdapter;
        this.f18053f.setAdapter(scrollFragmentAdapter);
    }

    public boolean i() {
        c cVar = this.l;
        return cVar != null && cVar.j();
    }

    public boolean j() {
        return ListUtils.getCount(this.j) <= 0;
    }

    public void k(int i2) {
        d.a.n0.k1.q.a aVar = this.f18054g;
        if (aVar != null) {
            aVar.g(i2);
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18056i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.i(i2);
        }
        if (this.f18055h != null) {
            this.f18055h.c(j.a(getContext()), i2);
        }
        c cVar = this.l;
        if (cVar != null) {
            cVar.k(i2);
        }
    }

    public void l() {
        if (this.l == null) {
            c cVar = new c(this.k);
            this.l = cVar;
            cVar.l(this.o);
        }
        if (this.l.j()) {
            return;
        }
        this.l.m(this.f18052e, this.j, this.f18053f.getCurrentItem());
        d.a.n0.k1.q.a aVar = this.f18054g;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void m(long j, String str) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18056i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.l(j, str);
        }
    }

    public void n(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18056i;
        if (scrollFragmentAdapter == null) {
            return;
        }
        scrollFragmentAdapter.o(z, j, str, dataRes, z2, i2);
    }

    public void o(long j, String str, String str2, int i2) {
        if (this.f18053f == null) {
            return;
        }
        this.f18056i.m(j, str, str2, i2);
    }

    public void p(long j, String str, DataRes dataRes, boolean z) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.f18056i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.n(j, str, dataRes, z);
        }
    }

    public void setCurrentTab(int i2) {
        if (i2 < 0 || i2 >= this.f18056i.getCount()) {
            return;
        }
        this.f18053f.setCurrentItem(i2, false);
    }

    public void setFirstPosition(int i2) {
        this.f18056i.k(i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new a();
        this.o = new b();
        g(context);
    }
}
