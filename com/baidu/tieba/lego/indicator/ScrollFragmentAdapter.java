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
import d.a.n0.e3.p0.b;
import d.a.n0.k1.d;
import d.a.n0.k1.g;
import d.a.n0.k1.p.c;
import d.a.n0.k1.p.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f18043a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18044b;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f18048f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f18049g;

    /* renamed from: c  reason: collision with root package name */
    public int f18045c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f18046d = -1;

    /* renamed from: h  reason: collision with root package name */
    public g f18050h = new a();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f18047e = new ArrayList<>();

    /* loaded from: classes4.dex */
    public class a implements g {
        public a() {
        }

        @Override // d.a.n0.k1.g
        public void a(e eVar, int i2) {
            if (i2 >= 0 && ScrollFragmentAdapter.this.f18047e != null && ScrollFragmentAdapter.this.f18047e.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.f18047e.iterator();
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

    public ScrollFragmentAdapter(Context context, d dVar, d.a.n0.k1.c cVar, BdUniqueId bdUniqueId) {
        this.f18043a = context;
        this.f18044b = bdUniqueId;
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f18048f = arrayList;
        arrayList.add(f(dVar));
        this.f18048f.add(f(dVar));
        this.f18048f.add(f(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f18049g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f18049g.setCallback(cVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public final View e() {
        int i2 = this.f18045c;
        if (i2 == this.f18046d) {
            return this.f18049g;
        }
        return (View) ListUtils.getItem(this.f18048f, i2 % 3);
    }

    public final LegoListView f(d dVar) {
        LegoListView legoListView = new LegoListView(this.f18043a);
        legoListView.v(this.f18044b);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.f18050h);
        return legoListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<c> arrayList = this.f18047e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        ArrayList<c> arrayList;
        int count = getCount();
        if (i2 < 0 || i2 >= count || (arrayList = this.f18047e) == null || arrayList.get(i2) == null || this.f18047e.get(i2).i() == null) {
            return null;
        }
        return this.f18047e.get(i2).i().f60449c;
    }

    public void i(int i2) {
        if (this.f18048f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f18049g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i2);
        }
        Iterator<LegoListView> it = this.f18048f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (i2 == this.f18046d) {
            if (this.f18049g.getParent() != null) {
                viewGroup.removeView(this.f18049g);
            }
            c cVar = (c) ListUtils.getItem(this.f18047e, i2);
            if (cVar != null) {
                this.f18049g.setTagInfo(cVar.i());
            }
            viewGroup.addView(this.f18049g);
            return this.f18049g;
        }
        LegoListView legoListView = this.f18048f.get(i2 % 3);
        if (legoListView.getParent() != null) {
            viewGroup.removeView(legoListView);
        }
        legoListView.u(this.f18047e.get(i2), true);
        viewGroup.addView(legoListView);
        return legoListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j() {
        View e2 = e();
        if (e2 instanceof LegoHotPageView) {
            ((LegoHotPageView) e2).setViewBackGround();
        } else if (e2 instanceof LegoListView) {
            ((LegoListView) e2).setViewBackGround();
        }
    }

    public void k(int i2) {
        this.f18046d = i2;
    }

    public void l(long j, String str) {
        LegoHotPageView legoHotPageView = this.f18049g;
        if (legoHotPageView != null) {
            legoHotPageView.z(j, str);
        }
    }

    public void m(long j, String str, String str2, int i2) {
        if (j == this.f18049g.getTagCode()) {
            this.f18049g.B(str2, i2);
            return;
        }
        ArrayList<LegoListView> arrayList = this.f18048f;
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

    public void n(long j, String str, DataRes dataRes, boolean z) {
        if (ListUtils.getCount(this.f18047e) <= 0) {
            LegoHotPageView legoHotPageView = this.f18049g;
            if (legoHotPageView != null) {
                legoHotPageView.A(dataRes, z);
            }
        } else if (j == 0 && ((c) ListUtils.getItem(this.f18047e, this.f18046d)) != null) {
            this.f18049g.A(dataRes, z);
        } else {
            Iterator<c> it = this.f18047e.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && next.i() != null && j == next.i().f60447a && TextUtils.equals(str, next.i().f60448b)) {
                    this.f18049g.A(dataRes, z);
                    return;
                }
            }
        }
    }

    public void o(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ArrayList<c> arrayList = this.f18047e;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f18047e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.i() != null && j == next.i().f60447a && TextUtils.equals(str, next.i().f60448b)) {
                next.d(z, dataRes, z2, i2);
                notifyDataSetChanged();
                q(j, str, next);
                return;
            }
        }
    }

    public void p(List<c> list) {
        if (this.f18047e == null) {
            this.f18047e = new ArrayList<>();
        }
        this.f18047e.clear();
        if (list != null && list.size() > 0) {
            this.f18047e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void q(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList = this.f18048f;
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
        if (this.f18045c != i2) {
            j();
            this.f18045c = i2;
            VoiceManager a2 = b.a(this.f18043a);
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
