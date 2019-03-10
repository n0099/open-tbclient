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
    private LegoHotPageView gLa;
    private Context mContext;
    private int mPrimaryPosition = -1;
    private int mFirstPosition = -1;
    private g gEV = new g() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentAdapter.1
        @Override // com.baidu.tieba.lego.g
        public void a(e eVar, int i) {
            if (i >= 0 && ScrollFragmentAdapter.this.list != null && ScrollFragmentAdapter.this.list.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.list.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) it.next();
                    if (cVar != null && cVar.bBd() != null && eVar == cVar.bBd()) {
                        cVar.vb(i);
                        return;
                    }
                }
            }
        }
    };
    private ArrayList<com.baidu.tieba.lego.c.c> list = new ArrayList<>();
    private ArrayList<LegoListView> gKZ = new ArrayList<>();

    public ScrollFragmentAdapter(Context context, d dVar, com.baidu.tieba.lego.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.cnX = bdUniqueId;
        this.gKZ.add(a(dVar));
        this.gKZ.add(a(dVar));
        this.gKZ.add(a(dVar));
        this.gLa = new LegoHotPageView(context);
        this.gLa.setPageUniqueId(bdUniqueId);
        this.gLa.setCallback(cVar);
    }

    private LegoListView a(d dVar) {
        LegoListView legoListView = new LegoListView(this.mContext);
        legoListView.i(this.cnX);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.gEV);
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
                if (next != null && next.bBd() != null && j == next.bBd().gKW && TextUtils.equals(str, next.bBd().itemId)) {
                    next.a(z, dataRes, z2, i);
                    notifyDataSetChanged();
                    a(j, str, next);
                    return;
                }
            }
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (j == this.gLa.getTagCode()) {
            this.gLa.aC(str2, i);
        } else if (this.gKZ != null) {
            Iterator<LegoListView> it = this.gKZ.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.n(j, str)) {
                    next.xR(str2);
                    return;
                }
            }
        }
    }

    public void j(long j, String str) {
        if (this.gLa != null) {
            this.gLa.j(j, str);
        }
    }

    private void a(long j, String str, com.baidu.tieba.lego.c.c cVar) {
        if (this.gKZ != null) {
            Iterator<LegoListView> it = this.gKZ.iterator();
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

    private View bBj() {
        int i = this.mPrimaryPosition;
        if (i == this.mFirstPosition) {
            return this.gLa;
        }
        return (View) v.c(this.gKZ, i % 3);
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void bBk() {
        View bBj = bBj();
        if (bBj instanceof LegoHotPageView) {
            ((LegoHotPageView) bBj).setViewBackGround();
        } else if (bBj instanceof LegoListView) {
            ((LegoListView) bBj).setViewBackGround();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            bBk();
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
            if (this.gLa != null) {
                this.gLa.a(dataRes, z);
            }
        } else if (j == 0 && ((com.baidu.tieba.lego.c.c) v.c(this.list, this.mFirstPosition)) != null) {
            this.gLa.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.lego.c.c> it = this.list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.lego.c.c next = it.next();
                if (next != null && next.bBd() != null && j == next.bBd().gKW && TextUtils.equals(str, next.bBd().itemId)) {
                    this.gLa.a(dataRes, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.mFirstPosition) {
            if (this.gLa.getParent() != null) {
                viewGroup.removeView(this.gLa);
            }
            com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) v.c(this.list, i);
            if (cVar != null) {
                this.gLa.setTagInfo(cVar.bBd());
            }
            viewGroup.addView(this.gLa);
            return this.gLa;
        }
        LegoListView legoListView = this.gKZ.get(i % 3);
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
        if (this.list == null || this.list.get(i) == null || this.list.get(i).bBd() == null) {
            return null;
        }
        return this.list.get(i).bBd().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ij(int i) {
        if (this.gKZ != null) {
            if (this.gLa != null) {
                this.gLa.onChangeSkinType(i);
            }
            Iterator<LegoListView> it = this.gKZ.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }
}
