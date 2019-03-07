package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.lego.LegoHotPageView;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private BdUniqueId cnX;
    private LegoHotPageView gKZ;
    private Context mContext;
    private int mPrimaryPosition = -1;
    private int mFirstPosition = -1;
    private g gEU = new g() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentAdapter.1
        @Override // com.baidu.tieba.lego.g
        public void a(e eVar, int i) {
            if (i >= 0 && ScrollFragmentAdapter.this.list != null && ScrollFragmentAdapter.this.list.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.list.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) it.next();
                    if (cVar != null && cVar.bBc() != null && eVar == cVar.bBc()) {
                        cVar.vb(i);
                        return;
                    }
                }
            }
        }
    };
    private ArrayList<com.baidu.tieba.lego.c.c> list = new ArrayList<>();
    private ArrayList<LegoListView> gKY = new ArrayList<>();

    public ScrollFragmentAdapter(Context context, d dVar, com.baidu.tieba.lego.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.cnX = bdUniqueId;
        this.gKY.add(a(dVar));
        this.gKY.add(a(dVar));
        this.gKY.add(a(dVar));
        this.gKZ = new LegoHotPageView(context);
        this.gKZ.setPageUniqueId(bdUniqueId);
        this.gKZ.setCallback(cVar);
    }

    private LegoListView a(d dVar) {
        LegoListView legoListView = new LegoListView(this.mContext);
        legoListView.i(this.cnX);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.gEU);
        return legoListView;
    }

    public void ax(List<com.baidu.tieba.lego.c.c> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.clear();
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        if (this.list != null && !this.list.isEmpty()) {
            Iterator<com.baidu.tieba.lego.c.c> it = this.list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.lego.c.c next = it.next();
                if (next != null && next.bBc() != null && j == next.bBc().gKV && TextUtils.equals(str, next.bBc().itemId)) {
                    next.a(z, dataRes, z2, i);
                    notifyDataSetChanged();
                    a(j, str, next);
                    return;
                }
            }
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (j == this.gKZ.getTagCode()) {
            this.gKZ.aC(str2, i);
        } else if (this.gKY != null) {
            Iterator<LegoListView> it = this.gKY.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.n(j, str)) {
                    next.xQ(str2);
                    return;
                }
            }
        }
    }

    public void j(long j, String str) {
        if (this.gKZ != null) {
            this.gKZ.j(j, str);
        }
    }

    private void a(long j, String str, com.baidu.tieba.lego.c.c cVar) {
        if (this.gKY != null) {
            Iterator<LegoListView> it = this.gKY.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.n(j, str)) {
                    next.a(cVar, false);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    private View bBi() {
        int i = this.mPrimaryPosition;
        if (i == this.mFirstPosition) {
            return this.gKZ;
        }
        return (View) v.c(this.gKY, i % 3);
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void bBj() {
        View bBi = bBi();
        if (bBi instanceof LegoHotPageView) {
            ((LegoHotPageView) bBi).setViewBackGround();
        } else if (bBi instanceof LegoListView) {
            ((LegoListView) bBi).setViewBackGround();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            bBj();
            this.mPrimaryPosition = i;
            VoiceManager ex = com.baidu.tieba.tbadkCore.voice.b.ex(this.mContext);
            if (ex != null) {
                ex.stopPlay();
            }
            if (obj instanceof LegoListView) {
                ((LegoListView) obj).setViewForeground();
            } else if (obj instanceof LegoHotPageView) {
                ((LegoHotPageView) obj).setViewForeground();
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (v.S(this.list) <= 0) {
            if (this.gKZ != null) {
                this.gKZ.a(dataRes, z);
            }
        } else if (j == 0 && ((com.baidu.tieba.lego.c.c) v.c(this.list, this.mFirstPosition)) != null) {
            this.gKZ.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.lego.c.c> it = this.list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.lego.c.c next = it.next();
                if (next != null && next.bBc() != null && j == next.bBc().gKV && TextUtils.equals(str, next.bBc().itemId)) {
                    this.gKZ.a(dataRes, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.mFirstPosition) {
            if (this.gKZ.getParent() != null) {
                viewGroup.removeView(this.gKZ);
            }
            com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) v.c(this.list, i);
            if (cVar != null) {
                this.gKZ.setTagInfo(cVar.bBc());
            }
            viewGroup.addView(this.gKZ);
            return this.gKZ;
        }
        LegoListView legoListView = this.gKY.get(i % 3);
        if (legoListView.getParent() != null) {
            viewGroup.removeView(legoListView);
        }
        legoListView.a(this.list.get(i), true);
        viewGroup.addView(legoListView);
        return legoListView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        if (this.list == null || this.list.get(i) == null || this.list.get(i).bBc() == null) {
            return null;
        }
        return this.list.get(i).bBc().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ij(int i) {
        if (this.gKY != null) {
            if (this.gKZ != null) {
                this.gKZ.onChangeSkinType(i);
            }
            Iterator<LegoListView> it = this.gKY.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }
}
