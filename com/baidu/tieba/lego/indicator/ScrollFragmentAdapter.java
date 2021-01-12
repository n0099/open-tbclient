package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes8.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private BdUniqueId fEN;
    private LegoHotPageView kXD;
    private Context mContext;
    private int mPrimaryPosition = -1;
    private int mFirstPosition = -1;
    private g kRJ = new g() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentAdapter.1
        @Override // com.baidu.tieba.lego.g
        public void a(e eVar, int i) {
            if (i >= 0 && ScrollFragmentAdapter.this.list != null && ScrollFragmentAdapter.this.list.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.list.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) it.next();
                    if (cVar != null && cVar.daM() != null && eVar == cVar.daM()) {
                        cVar.DO(i);
                        return;
                    }
                }
            }
        }
    };
    private ArrayList<com.baidu.tieba.lego.c.c> list = new ArrayList<>();
    private ArrayList<LegoListView> gIg = new ArrayList<>();

    public ScrollFragmentAdapter(Context context, d dVar, com.baidu.tieba.lego.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.fEN = bdUniqueId;
        this.gIg.add(a(dVar));
        this.gIg.add(a(dVar));
        this.gIg.add(a(dVar));
        this.kXD = new LegoHotPageView(context);
        this.kXD.setPageUniqueId(bdUniqueId);
        this.kXD.setCallback(cVar);
    }

    private LegoListView a(d dVar) {
        LegoListView legoListView = new LegoListView(this.mContext);
        legoListView.l(this.fEN);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.kRJ);
        return legoListView;
    }

    public void ek(List<com.baidu.tieba.lego.c.c> list) {
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
                if (next != null && next.daM() != null && j == next.daM().kXA && TextUtils.equals(str, next.daM().itemId)) {
                    next.a(z, dataRes, z2, i);
                    notifyDataSetChanged();
                    a(j, str, next);
                    return;
                }
            }
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (j == this.kXD.getTagCode()) {
            this.kXD.bc(str2, i);
        } else if (this.gIg != null) {
            Iterator<LegoListView> it = this.gIg.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.t(j, str)) {
                    next.MJ(str2);
                    return;
                }
            }
        }
    }

    public void p(long j, String str) {
        if (this.kXD != null) {
            this.kXD.p(j, str);
        }
    }

    private void a(long j, String str, com.baidu.tieba.lego.c.c cVar) {
        if (this.gIg != null) {
            Iterator<LegoListView> it = this.gIg.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.t(j, str)) {
                    next.a(cVar, false);
                    return;
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    private View daS() {
        int i = this.mPrimaryPosition;
        if (i == this.mFirstPosition) {
            return this.kXD;
        }
        return (View) x.getItem(this.gIg, i % 3);
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void daT() {
        View daS = daS();
        if (daS instanceof LegoHotPageView) {
            ((LegoHotPageView) daS).setViewBackGround();
        } else if (daS instanceof LegoListView) {
            ((LegoListView) daS).setViewBackGround();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            daT();
            this.mPrimaryPosition = i;
            VoiceManager gV = com.baidu.tieba.tbadkCore.voice.b.gV(this.mContext);
            if (gV != null) {
                gV.stopPlay();
            }
            if (obj instanceof LegoListView) {
                ((LegoListView) obj).setViewForeground();
            } else if (obj instanceof LegoHotPageView) {
                ((LegoHotPageView) obj).setViewForeground();
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (x.getCount(this.list) <= 0) {
            if (this.kXD != null) {
                this.kXD.a(dataRes, z);
            }
        } else if (j == 0 && ((com.baidu.tieba.lego.c.c) x.getItem(this.list, this.mFirstPosition)) != null) {
            this.kXD.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.lego.c.c> it = this.list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.lego.c.c next = it.next();
                if (next != null && next.daM() != null && j == next.daM().kXA && TextUtils.equals(str, next.daM().itemId)) {
                    this.kXD.a(dataRes, z);
                    return;
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.mFirstPosition) {
            if (this.kXD.getParent() != null) {
                viewGroup.removeView(this.kXD);
            }
            com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) x.getItem(this.list, i);
            if (cVar != null) {
                this.kXD.setTagInfo(cVar.daM());
            }
            viewGroup.addView(this.kXD);
            return this.kXD;
        }
        LegoListView legoListView = this.gIg.get(i % 3);
        if (legoListView.getParent() != null) {
            viewGroup.removeView(legoListView);
        }
        legoListView.a(this.list.get(i), true);
        viewGroup.addView(legoListView);
        return legoListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        if (this.list == null || this.list.get(i) == null || this.list.get(i).daM() == null) {
            return null;
        }
        return this.list.get(i).daM().tag_name;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void onChangeSkin(int i) {
        if (this.gIg != null) {
            if (this.kXD != null) {
                this.kXD.onChangeSkinType(i);
            }
            Iterator<LegoListView> it = this.gIg.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }
}
