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
import d.b.b.a.j;
import d.b.i0.i1.d;
import d.b.i0.i1.p.e;
import d.b.i0.i1.q.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class ScrollFragmentTabHost extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18706e;

    /* renamed from: f  reason: collision with root package name */
    public CustomViewPager f18707f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i1.q.a f18708g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f18709h;
    public ScrollFragmentAdapter i;
    public List<e> j;
    public FrameLayout k;
    public c l;
    public BdUniqueId m;
    public View.OnClickListener n;
    public c.InterfaceC1306c o;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements c.InterfaceC1306c {
        public b() {
        }

        @Override // d.b.i0.i1.q.c.InterfaceC1306c
        public void a() {
            if (ScrollFragmentTabHost.this.f18708g != null) {
                ScrollFragmentTabHost.this.f18708g.d();
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

    public void d(List<e> list, int i) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null) {
                arrayList.add(new d.b.i0.i1.p.c(eVar));
            }
        }
        this.j = list;
        ScrollFragmentAdapter scrollFragmentAdapter = this.i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.p(arrayList);
            d.b.i0.i1.q.a aVar = this.f18708g;
            if (aVar != null) {
                aVar.i(this.f18707f, i);
            }
        }
    }

    public void e() {
        c cVar = this.l;
        if (cVar != null) {
            cVar.f(this.f18706e);
        }
    }

    public boolean f() {
        ScrollFragmentAdapter scrollFragmentAdapter = this.i;
        return scrollFragmentAdapter != null && scrollFragmentAdapter.getCount() > 0;
    }

    public final void g(Context context) {
        this.f18706e = context;
        LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_tabhost, (ViewGroup) this, true);
        this.f18709h = (NoNetworkView) findViewById(R.id.view_no_network);
        d.b.i0.i1.q.a aVar = new d.b.i0.i1.q.a(context, findViewById(R.id.tab_container));
        this.f18708g = aVar;
        aVar.h(this.n);
        this.k = (FrameLayout) findViewById(R.id.tab_widget_content_container);
    }

    public void h(d dVar, d.b.i0.i1.c cVar) {
        this.f18707f = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f18706e, dVar, cVar, this.m);
        this.i = scrollFragmentAdapter;
        this.f18707f.setAdapter(scrollFragmentAdapter);
    }

    public boolean i() {
        c cVar = this.l;
        return cVar != null && cVar.j();
    }

    public boolean j() {
        return ListUtils.getCount(this.j) <= 0;
    }

    public void k(int i) {
        d.b.i0.i1.q.a aVar = this.f18708g;
        if (aVar != null) {
            aVar.g(i);
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
        ScrollFragmentAdapter scrollFragmentAdapter = this.i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.i(i);
        }
        if (this.f18709h != null) {
            this.f18709h.c(j.a(getContext()), i);
        }
        c cVar = this.l;
        if (cVar != null) {
            cVar.k(i);
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
        this.l.m(this.f18706e, this.j, this.f18707f.getCurrentItem());
        d.b.i0.i1.q.a aVar = this.f18708g;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void m(long j, String str) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.l(j, str);
        }
    }

    public void n(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.i;
        if (scrollFragmentAdapter == null) {
            return;
        }
        scrollFragmentAdapter.o(z, j, str, dataRes, z2, i);
    }

    public void o(long j, String str, String str2, int i) {
        if (this.f18707f == null) {
            return;
        }
        this.i.m(j, str, str2, i);
    }

    public void p(long j, String str, DataRes dataRes, boolean z) {
        ScrollFragmentAdapter scrollFragmentAdapter = this.i;
        if (scrollFragmentAdapter != null) {
            scrollFragmentAdapter.n(j, str, dataRes, z);
        }
    }

    public void setCurrentTab(int i) {
        if (i < 0 || i >= this.i.getCount()) {
            return;
        }
        this.f18707f.setCurrentItem(i, false);
    }

    public void setFirstPosition(int i) {
        this.i.k(i);
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
