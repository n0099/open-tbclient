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
import d.b.i0.c3.p0.b;
import d.b.i0.i1.d;
import d.b.i0.i1.g;
import d.b.i0.i1.p.c;
import d.b.i0.i1.p.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f18696a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18697b;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f18701f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f18702g;

    /* renamed from: c  reason: collision with root package name */
    public int f18698c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f18699d = -1;

    /* renamed from: h  reason: collision with root package name */
    public g f18703h = new a();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f18700e = new ArrayList<>();

    /* loaded from: classes4.dex */
    public class a implements g {
        public a() {
        }

        @Override // d.b.i0.i1.g
        public void a(e eVar, int i) {
            if (i >= 0 && ScrollFragmentAdapter.this.f18700e != null && ScrollFragmentAdapter.this.f18700e.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.f18700e.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar != null && cVar.i() != null && eVar == cVar.i()) {
                        cVar.q(i);
                        return;
                    }
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, d.b.i0.i1.c cVar, BdUniqueId bdUniqueId) {
        this.f18696a = context;
        this.f18697b = bdUniqueId;
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f18701f = arrayList;
        arrayList.add(f(dVar));
        this.f18701f.add(f(dVar));
        this.f18701f.add(f(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f18702g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f18702g.setCallback(cVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public final View e() {
        int i = this.f18698c;
        if (i == this.f18699d) {
            return this.f18702g;
        }
        return (View) ListUtils.getItem(this.f18701f, i % 3);
    }

    public final LegoListView f(d dVar) {
        LegoListView legoListView = new LegoListView(this.f18696a);
        legoListView.v(this.f18697b);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.f18703h);
        return legoListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<c> arrayList = this.f18700e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        ArrayList<c> arrayList;
        int count = getCount();
        if (i < 0 || i >= count || (arrayList = this.f18700e) == null || arrayList.get(i) == null || this.f18700e.get(i).i() == null) {
            return null;
        }
        return this.f18700e.get(i).i().f56032c;
    }

    public void i(int i) {
        if (this.f18701f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f18702g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i);
        }
        Iterator<LegoListView> it = this.f18701f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.f18699d) {
            if (this.f18702g.getParent() != null) {
                viewGroup.removeView(this.f18702g);
            }
            c cVar = (c) ListUtils.getItem(this.f18700e, i);
            if (cVar != null) {
                this.f18702g.setTagInfo(cVar.i());
            }
            viewGroup.addView(this.f18702g);
            return this.f18702g;
        }
        LegoListView legoListView = this.f18701f.get(i % 3);
        if (legoListView.getParent() != null) {
            viewGroup.removeView(legoListView);
        }
        legoListView.u(this.f18700e.get(i), true);
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

    public void k(int i) {
        this.f18699d = i;
    }

    public void l(long j, String str) {
        LegoHotPageView legoHotPageView = this.f18702g;
        if (legoHotPageView != null) {
            legoHotPageView.z(j, str);
        }
    }

    public void m(long j, String str, String str2, int i) {
        if (j == this.f18702g.getTagCode()) {
            this.f18702g.B(str2, i);
            return;
        }
        ArrayList<LegoListView> arrayList = this.f18701f;
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
        if (ListUtils.getCount(this.f18700e) <= 0) {
            LegoHotPageView legoHotPageView = this.f18702g;
            if (legoHotPageView != null) {
                legoHotPageView.A(dataRes, z);
            }
        } else if (j == 0 && ((c) ListUtils.getItem(this.f18700e, this.f18699d)) != null) {
            this.f18702g.A(dataRes, z);
        } else {
            Iterator<c> it = this.f18700e.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && next.i() != null && j == next.i().f56030a && TextUtils.equals(str, next.i().f56031b)) {
                    this.f18702g.A(dataRes, z);
                    return;
                }
            }
        }
    }

    public void o(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        ArrayList<c> arrayList = this.f18700e;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f18700e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.i() != null && j == next.i().f56030a && TextUtils.equals(str, next.i().f56031b)) {
                next.d(z, dataRes, z2, i);
                notifyDataSetChanged();
                q(j, str, next);
                return;
            }
        }
    }

    public void p(List<c> list) {
        if (this.f18700e == null) {
            this.f18700e = new ArrayList<>();
        }
        this.f18700e.clear();
        if (list != null && list.size() > 0) {
            this.f18700e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void q(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList = this.f18701f;
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
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.f18698c != i) {
            j();
            this.f18698c = i;
            VoiceManager a2 = b.a(this.f18696a);
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
