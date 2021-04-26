package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.lego.LegoHotPageView;
import com.baidu.tieba.lego.LegoListView;
import d.a.j0.d3.p0.b;
import d.a.j0.j1.d;
import d.a.j0.j1.g;
import d.a.j0.j1.p.c;
import d.a.j0.j1.p.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f18742a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18743b;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f18747f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f18748g;

    /* renamed from: c  reason: collision with root package name */
    public int f18744c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f18745d = -1;

    /* renamed from: h  reason: collision with root package name */
    public g f18749h = new a();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f18746e = new ArrayList<>();

    /* loaded from: classes4.dex */
    public class a implements g {
        public a() {
        }

        @Override // d.a.j0.j1.g
        public void a(e eVar, int i2) {
            if (i2 >= 0 && ScrollFragmentAdapter.this.f18746e != null && ScrollFragmentAdapter.this.f18746e.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.f18746e.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar != null && cVar.i() != null && eVar == cVar.i()) {
                        cVar.q(i2);
                        return;
                    }
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, d.a.j0.j1.c cVar, BdUniqueId bdUniqueId) {
        this.f18742a = context;
        this.f18743b = bdUniqueId;
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f18747f = arrayList;
        arrayList.add(d(dVar));
        this.f18747f.add(d(dVar));
        this.f18747f.add(d(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f18748g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f18748g.setCallback(cVar);
    }

    public final View c() {
        int i2 = this.f18744c;
        if (i2 == this.f18745d) {
            return this.f18748g;
        }
        return (View) ListUtils.getItem(this.f18747f, i2 % 3);
    }

    public final LegoListView d(d dVar) {
        LegoListView legoListView = new LegoListView(this.f18742a);
        legoListView.v(this.f18743b);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.f18749h);
        return legoListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public void e(int i2) {
        if (this.f18747f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f18748g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i2);
        }
        Iterator<LegoListView> it = this.f18747f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i2);
            }
        }
    }

    public void f() {
        View c2 = c();
        if (c2 instanceof LegoHotPageView) {
            ((LegoHotPageView) c2).setViewBackGround();
        } else if (c2 instanceof LegoListView) {
            ((LegoListView) c2).setViewBackGround();
        }
    }

    public void g(int i2) {
        this.f18745d = i2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<c> arrayList = this.f18746e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        ArrayList<c> arrayList;
        int count = getCount();
        if (i2 < 0 || i2 >= count || (arrayList = this.f18746e) == null || arrayList.get(i2) == null || this.f18746e.get(i2).i() == null) {
            return null;
        }
        return this.f18746e.get(i2).i().f55873c;
    }

    public void h(long j, String str) {
        LegoHotPageView legoHotPageView = this.f18748g;
        if (legoHotPageView != null) {
            legoHotPageView.z(j, str);
        }
    }

    public void i(long j, String str, String str2, int i2) {
        if (j == this.f18748g.getTagCode()) {
            this.f18748g.B(str2, i2);
            return;
        }
        ArrayList<LegoListView> arrayList = this.f18747f;
        if (arrayList == null) {
            return;
        }
        Iterator<LegoListView> it = arrayList.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null && next.p(j, str)) {
                next.z(str2);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (i2 == this.f18745d) {
            if (this.f18748g.getParent() != null) {
                viewGroup.removeView(this.f18748g);
            }
            c cVar = (c) ListUtils.getItem(this.f18746e, i2);
            if (cVar != null) {
                this.f18748g.setTagInfo(cVar.i());
            }
            viewGroup.addView(this.f18748g);
            return this.f18748g;
        }
        LegoListView legoListView = this.f18747f.get(i2 % 3);
        if (legoListView.getParent() != null) {
            viewGroup.removeView(legoListView);
        }
        legoListView.u(this.f18746e.get(i2), true);
        viewGroup.addView(legoListView);
        return legoListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(long j, String str, DataRes dataRes, boolean z) {
        if (ListUtils.getCount(this.f18746e) <= 0) {
            LegoHotPageView legoHotPageView = this.f18748g;
            if (legoHotPageView != null) {
                legoHotPageView.A(dataRes, z);
            }
        } else if (j == 0 && ((c) ListUtils.getItem(this.f18746e, this.f18745d)) != null) {
            this.f18748g.A(dataRes, z);
        } else {
            Iterator<c> it = this.f18746e.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && next.i() != null && j == next.i().f55871a && TextUtils.equals(str, next.i().f55872b)) {
                    this.f18748g.A(dataRes, z);
                    return;
                }
            }
        }
    }

    public void k(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ArrayList<c> arrayList = this.f18746e;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f18746e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.i() != null && j == next.i().f55871a && TextUtils.equals(str, next.i().f55872b)) {
                next.d(z, dataRes, z2, i2);
                notifyDataSetChanged();
                m(j, str, next);
                return;
            }
        }
    }

    public void l(List<c> list) {
        if (this.f18746e == null) {
            this.f18746e = new ArrayList<>();
        }
        this.f18746e.clear();
        if (list != null && list.size() > 0) {
            this.f18746e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void m(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList = this.f18747f;
        if (arrayList == null) {
            return;
        }
        Iterator<LegoListView> it = arrayList.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null && next.p(j, str)) {
                next.u(cVar, false);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.f18744c != i2) {
            f();
            this.f18744c = i2;
            VoiceManager a2 = b.a(this.f18742a);
            if (a2 != null) {
                a2.stopPlay();
            }
            if (obj instanceof LegoListView) {
                ((LegoListView) obj).setViewForeground();
            } else if (obj instanceof LegoHotPageView) {
                ((LegoHotPageView) obj).setViewForeground();
            }
        }
    }
}
