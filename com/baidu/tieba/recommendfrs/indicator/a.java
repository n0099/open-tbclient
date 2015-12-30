package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends PagerAdapter {
    private BdUniqueId dpv;
    private com.baidu.tieba.recommendfrs.e dpw;
    private Context mContext;
    private int mPrimaryPosition = -1;
    private com.baidu.tieba.recommendfrs.c doh = new b(this);
    private ArrayList<com.baidu.tieba.recommendfrs.data.f> rN = new ArrayList<>();
    private ArrayList<com.baidu.tieba.recommendfrs.k> bGA = new ArrayList<>();

    public a(Context context, com.baidu.tieba.recommendfrs.a aVar, com.baidu.tieba.recommendfrs.b bVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.dpv = bdUniqueId;
        this.bGA.add(a(aVar));
        this.bGA.add(a(aVar));
        this.bGA.add(a(aVar));
        this.dpw = new com.baidu.tieba.recommendfrs.e(context);
        this.dpw.setPageUniqueId(bdUniqueId);
        this.dpw.setCallback(bVar);
    }

    private com.baidu.tieba.recommendfrs.k a(com.baidu.tieba.recommendfrs.a aVar) {
        com.baidu.tieba.recommendfrs.k kVar = new com.baidu.tieba.recommendfrs.k(this.mContext);
        kVar.j(this.dpv);
        kVar.setCallback(aVar);
        kVar.setScrollCallback(this.doh);
        return kVar;
    }

    public void an(List<com.baidu.tieba.recommendfrs.data.f> list) {
        if (this.rN == null) {
            this.rN = new ArrayList<>();
        }
        this.rN.clear();
        if (list != null && list.size() > 0) {
            this.rN.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z, long j, com.baidu.tieba.recommendfrs.data.h hVar, boolean z2) {
        if (this.rN != null && !this.rN.isEmpty()) {
            Iterator<com.baidu.tieba.recommendfrs.data.f> it = this.rN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.f next = it.next();
                if (next != null && next.ayn() != null && j == next.ayn().tag_code.longValue()) {
                    next.a(z, hVar, z2);
                    notifyDataSetChanged();
                    a(j, next);
                    return;
                }
            }
        }
    }

    public void b(long j, String str, int i) {
        if (j == this.dpw.getTagCode()) {
            this.dpw.af(str, i);
        } else if (this.bGA != null) {
            Iterator<com.baidu.tieba.recommendfrs.k> it = this.bGA.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.k next = it.next();
                if (next != null && next.bF(j)) {
                    next.af(str, i);
                    return;
                }
            }
        }
    }

    public void axX() {
        if (this.dpw != null) {
            this.dpw.axX();
        }
    }

    private void a(long j, com.baidu.tieba.recommendfrs.data.f fVar) {
        if (this.bGA != null) {
            Iterator<com.baidu.tieba.recommendfrs.k> it = this.bGA.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.k next = it.next();
                if (next != null && next.bF(j)) {
                    next.a(fVar, false);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.rN == null) {
            return 0;
        }
        return this.rN.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof com.baidu.tieba.recommendfrs.k) {
                VoiceManager aT = com.baidu.tieba.tbadkCore.voice.b.aT(this.mContext);
                if (aT != null) {
                    aT.stopPlay();
                }
                ((com.baidu.tieba.recommendfrs.k) obj).axW();
            } else if (obj instanceof com.baidu.tieba.recommendfrs.e) {
                ((com.baidu.tieba.recommendfrs.e) obj).axW();
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.recommendfrs.data.f fVar;
        if (y.l(this.rN) <= 0) {
            if (this.dpw != null) {
                this.dpw.a(dataRes, z);
            }
        } else if (j == 0 && (fVar = (com.baidu.tieba.recommendfrs.data.f) y.b(this.rN, 0)) != null) {
            fVar.c(dataRes);
            this.dpw.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.recommendfrs.data.f> it = this.rN.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.f next = it.next();
                if (next != null && next.ayn() != null && j == next.ayn().tag_code.longValue()) {
                    next.c(dataRes);
                    next.gP(z);
                    this.dpw.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bI(long j) {
        if (this.rN == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.recommendfrs.data.f fVar = this.rN.get(i);
            if (fVar != null && fVar.ayn() != null && fVar.ayn().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.dpw.getParent() != null) {
                viewGroup.removeView(this.dpw);
            }
            com.baidu.tieba.recommendfrs.data.f fVar = (com.baidu.tieba.recommendfrs.data.f) y.b(this.rN, i);
            if (fVar != null) {
                this.dpw.setTagInfo(fVar.ayn());
            }
            viewGroup.addView(this.dpw);
            return this.dpw;
        }
        com.baidu.tieba.recommendfrs.k kVar = this.bGA.get(i % 3);
        if (kVar.getParent() != null) {
            viewGroup.removeView(kVar);
        }
        kVar.a(this.rN.get(i), true);
        viewGroup.addView(kVar);
        return kVar;
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
        if (this.rN == null || this.rN.get(i) == null || this.rN.get(i).ayn() == null) {
            return null;
        }
        return this.rN.get(i).ayn().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void cR(int i) {
        if (this.bGA != null) {
            if (this.dpw != null) {
                this.dpw.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.recommendfrs.k> it = this.bGA.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.k next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        if (i == 0) {
            this.dpw.axW();
        }
    }

    public void ayA() {
        int i = this.mPrimaryPosition;
        if (i == 0) {
            if (this.dpw != null) {
                this.dpw.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.k kVar = (com.baidu.tieba.recommendfrs.k) y.b(this.bGA, i % 3);
        if (kVar != null) {
            kVar.reload();
        }
    }

    public void onDestroy() {
        this.dpw.onDestroy();
        Iterator<com.baidu.tieba.recommendfrs.k> it = this.bGA.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.recommendfrs.k next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }
}
