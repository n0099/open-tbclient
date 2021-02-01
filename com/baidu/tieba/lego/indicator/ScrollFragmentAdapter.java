package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes9.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private BdUniqueId fGZ;
    private LegoHotPageView lfH;
    private Context mContext;
    private int mPrimaryPosition = -1;
    private int mFirstPosition = -1;
    private g kZL = new g() { // from class: com.baidu.tieba.lego.indicator.ScrollFragmentAdapter.1
        @Override // com.baidu.tieba.lego.g
        public void a(e eVar, int i) {
            if (i >= 0 && ScrollFragmentAdapter.this.list != null && ScrollFragmentAdapter.this.list.size() > 0) {
                Iterator it = ScrollFragmentAdapter.this.list.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) it.next();
                    if (cVar != null && cVar.dcK() != null && eVar == cVar.dcK()) {
                        cVar.Eg(i);
                        return;
                    }
                }
            }
        }
    };
    private ArrayList<com.baidu.tieba.lego.c.c> list = new ArrayList<>();
    private ArrayList<LegoListView> gKQ = new ArrayList<>();

    public ScrollFragmentAdapter(Context context, d dVar, com.baidu.tieba.lego.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.fGZ = bdUniqueId;
        this.gKQ.add(a(dVar));
        this.gKQ.add(a(dVar));
        this.gKQ.add(a(dVar));
        this.lfH = new LegoHotPageView(context);
        this.lfH.setPageUniqueId(bdUniqueId);
        this.lfH.setCallback(cVar);
    }

    private LegoListView a(d dVar) {
        LegoListView legoListView = new LegoListView(this.mContext);
        legoListView.l(this.fGZ);
        legoListView.setCallback(dVar);
        legoListView.setScrollCallback(this.kZL);
        return legoListView;
    }

    public void ei(List<com.baidu.tieba.lego.c.c> list) {
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
                if (next != null && next.dcK() != null && j == next.dcK().lfE && TextUtils.equals(str, next.dcK().itemId)) {
                    next.a(z, dataRes, z2, i);
                    notifyDataSetChanged();
                    a(j, str, next);
                    return;
                }
            }
        }
    }

    public void c(long j, String str, String str2, int i) {
        if (j == this.lfH.getTagCode()) {
            this.lfH.bd(str2, i);
        } else if (this.gKQ != null) {
            Iterator<LegoListView> it = this.gKQ.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.u(j, str)) {
                    next.Ny(str2);
                    return;
                }
            }
        }
    }

    public void q(long j, String str) {
        if (this.lfH != null) {
            this.lfH.q(j, str);
        }
    }

    private void a(long j, String str, com.baidu.tieba.lego.c.c cVar) {
        if (this.gKQ != null) {
            Iterator<LegoListView> it = this.gKQ.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.u(j, str)) {
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

    private View dcQ() {
        int i = this.mPrimaryPosition;
        if (i == this.mFirstPosition) {
            return this.lfH;
        }
        return (View) y.getItem(this.gKQ, i % 3);
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void dcR() {
        View dcQ = dcQ();
        if (dcQ instanceof LegoHotPageView) {
            ((LegoHotPageView) dcQ).setViewBackGround();
        } else if (dcQ instanceof LegoListView) {
            ((LegoListView) dcQ).setViewBackGround();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            dcR();
            this.mPrimaryPosition = i;
            VoiceManager gY = com.baidu.tieba.tbadkCore.voice.b.gY(this.mContext);
            if (gY != null) {
                gY.stopPlay();
            }
            if (obj instanceof LegoListView) {
                ((LegoListView) obj).setViewForeground();
            } else if (obj instanceof LegoHotPageView) {
                ((LegoHotPageView) obj).setViewForeground();
            }
        }
    }

    public void a(long j, String str, DataRes dataRes, boolean z) {
        if (y.getCount(this.list) <= 0) {
            if (this.lfH != null) {
                this.lfH.a(dataRes, z);
            }
        } else if (j == 0 && ((com.baidu.tieba.lego.c.c) y.getItem(this.list, this.mFirstPosition)) != null) {
            this.lfH.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.lego.c.c> it = this.list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.lego.c.c next = it.next();
                if (next != null && next.dcK() != null && j == next.dcK().lfE && TextUtils.equals(str, next.dcK().itemId)) {
                    this.lfH.a(dataRes, z);
                    return;
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.mFirstPosition) {
            if (this.lfH.getParent() != null) {
                viewGroup.removeView(this.lfH);
            }
            com.baidu.tieba.lego.c.c cVar = (com.baidu.tieba.lego.c.c) y.getItem(this.list, i);
            if (cVar != null) {
                this.lfH.setTagInfo(cVar.dcK());
            }
            viewGroup.addView(this.lfH);
            return this.lfH;
        }
        LegoListView legoListView = this.gKQ.get(i % 3);
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
        if (this.list == null || this.list.get(i) == null || this.list.get(i).dcK() == null) {
            return null;
        }
        return this.list.get(i).dcK().tag_name;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void onChangeSkin(int i) {
        if (this.gKQ != null) {
            if (this.lfH != null) {
                this.lfH.onChangeSkinType(i);
            }
            Iterator<LegoListView> it = this.gKQ.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }
}
