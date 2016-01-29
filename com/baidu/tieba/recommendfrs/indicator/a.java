package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends PagerAdapter {
    private BdUniqueId aPF;
    private com.baidu.tieba.recommendfrs.f dFh;
    private Context mContext;
    private com.baidu.tieba.recommendfrs.d dDt = new b(this);
    private CustomMessageListener dFi = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener dFj = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private ArrayList<com.baidu.tieba.recommendfrs.data.h> dFf = new ArrayList<>();
    private ArrayList<com.baidu.tieba.recommendfrs.m> dFg = new ArrayList<>();

    public a(Context context, com.baidu.tieba.recommendfrs.b bVar, com.baidu.tieba.recommendfrs.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aPF = bdUniqueId;
        this.dFg.add(a(bVar));
        this.dFg.add(a(bVar));
        this.dFg.add(a(bVar));
        this.dFh = new com.baidu.tieba.recommendfrs.f(context);
        this.dFh.setPageUniqueId(bdUniqueId);
        this.dFh.setCallback(cVar);
        this.dFi.setTag(bdUniqueId);
        this.dFj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dFi);
        MessageManager.getInstance().registerListener(this.dFj);
    }

    private com.baidu.tieba.recommendfrs.m a(com.baidu.tieba.recommendfrs.b bVar) {
        com.baidu.tieba.recommendfrs.m mVar = new com.baidu.tieba.recommendfrs.m(this.mContext);
        mVar.j(this.aPF);
        mVar.setCallback(bVar);
        mVar.setScrollCallback(this.dDt);
        return mVar;
    }

    public void al(List<com.baidu.tieba.recommendfrs.data.h> list) {
        if (this.dFf == null) {
            this.dFf = new ArrayList<>();
        }
        this.dFf.clear();
        if (list != null && list.size() > 0) {
            this.dFf.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z, long j, com.baidu.tieba.recommendfrs.data.j jVar, boolean z2) {
        if (this.dFf != null && !this.dFf.isEmpty()) {
            Iterator<com.baidu.tieba.recommendfrs.data.h> it = this.dFf.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.h next = it.next();
                if (next != null && next.aFr() != null && j == next.aFr().tag_code.longValue()) {
                    next.a(z, jVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void b(long j, String str, int i) {
        if (j == this.dFh.getTagCode()) {
            this.dFh.ah(str, i);
        } else if (this.dFg != null) {
            Iterator<com.baidu.tieba.recommendfrs.m> it = this.dFg.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.m next = it.next();
                if (next != null && next.bI(j)) {
                    next.ah(str, i);
                    return;
                }
            }
        }
    }

    public void aEV() {
        if (this.dFh != null) {
            this.dFh.aEV();
        }
    }

    private void a(long j, com.baidu.tieba.recommendfrs.data.h hVar, boolean z) {
        if (this.dFg != null) {
            Iterator<com.baidu.tieba.recommendfrs.m> it = this.dFg.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.m next = it.next();
                if (next != null && next.bI(j)) {
                    next.a(hVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.dFf == null) {
            return 0;
        }
        return this.dFf.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.recommendfrs.control.a.n.aFn().cnb != i) {
            aFl();
            com.baidu.tieba.recommendfrs.control.a.n.aFn().cnb = i;
            VoiceManager aV = com.baidu.tieba.tbadkCore.voice.b.aV(this.mContext);
            if (aV != null) {
                aV.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.recommendfrs.m) {
                ((com.baidu.tieba.recommendfrs.m) obj).aEU();
                if (i == com.baidu.tieba.recommendfrs.control.a.n.aFn().dEB) {
                    if (com.baidu.tieba.recommendfrs.control.a.n.aFn().dEC != 0 || com.baidu.tieba.recommendfrs.control.a.n.aFn().dEE) {
                        com.baidu.tieba.recommendfrs.control.a.n.aFn().dEE = false;
                        hp(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.recommendfrs.f) {
                ((com.baidu.tieba.recommendfrs.f) obj).aEU();
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.recommendfrs.data.h hVar;
        if (x.o(this.dFf) <= 0) {
            if (this.dFh != null) {
                this.dFh.a(dataRes, z);
            }
        } else if (j == 0 && (hVar = (com.baidu.tieba.recommendfrs.data.h) x.b(this.dFf, 0)) != null) {
            hVar.c(dataRes);
            this.dFh.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.recommendfrs.data.h> it = this.dFf.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.h next = it.next();
                if (next != null && next.aFr() != null && j == next.aFr().tag_code.longValue()) {
                    next.c(dataRes);
                    next.ho(z);
                    this.dFh.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bL(long j) {
        if (this.dFf == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.recommendfrs.data.h hVar = this.dFf.get(i);
            if (hVar != null && hVar.aFr() != null && hVar.aFr().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.dFh.getParent() != null) {
                viewGroup.removeView(this.dFh);
            }
            com.baidu.tieba.recommendfrs.data.h hVar = (com.baidu.tieba.recommendfrs.data.h) x.b(this.dFf, i);
            if (hVar != null) {
                this.dFh.setTagInfo(hVar.aFr());
            }
            viewGroup.addView(this.dFh);
            return this.dFh;
        }
        com.baidu.tieba.recommendfrs.m mVar = this.dFg.get(i % 3);
        if (mVar.getParent() != null) {
            viewGroup.removeView(mVar);
        }
        mVar.a(this.dFf.get(i), true, false);
        viewGroup.addView(mVar);
        return mVar;
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
        if (this.dFf == null || this.dFf.get(i) == null || this.dFf.get(i).aFr() == null) {
            return null;
        }
        return this.dFf.get(i).aFr().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dk(int i) {
        if (this.dFg != null) {
            if (this.dFh != null) {
                this.dFh.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.recommendfrs.m> it = this.dFg.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.m next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        if (i == 0) {
            this.dFh.aEU();
            return;
        }
        com.baidu.tieba.recommendfrs.m mVar = (com.baidu.tieba.recommendfrs.m) x.b(this.dFg, i % 3);
        if (mVar != null) {
            if (i == com.baidu.tieba.recommendfrs.control.a.n.aFn().dEB && com.baidu.tieba.recommendfrs.control.a.n.aFn().dEE) {
                com.baidu.tieba.recommendfrs.control.a.n.aFn().dEE = false;
                hp(false);
                return;
            }
            mVar.aEU();
        }
    }

    public void hp(boolean z) {
        int i = com.baidu.tieba.recommendfrs.control.a.n.aFn().cnb;
        if (i == 0) {
            if (this.dFh != null) {
                this.dFh.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.m mVar = (com.baidu.tieba.recommendfrs.m) x.b(this.dFg, i % 3);
        if (mVar != null) {
            mVar.hl(z);
        }
    }

    private View aFG() {
        int i = com.baidu.tieba.recommendfrs.control.a.n.aFn().cnb;
        if (i == 0) {
            return this.dFh;
        }
        return (View) x.b(this.dFg, i % 3);
    }

    public void onDestroy() {
        this.dFh.onDestroy();
        Iterator<com.baidu.tieba.recommendfrs.m> it = this.dFg.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.recommendfrs.m next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void aFl() {
        View aFG = aFG();
        if (aFG instanceof com.baidu.tieba.recommendfrs.m) {
            ((com.baidu.tieba.recommendfrs.m) aFG).aEW();
        } else if (aFG instanceof com.baidu.tieba.recommendfrs.f) {
            ((com.baidu.tieba.recommendfrs.f) aFG).aEW();
        }
    }

    public void aFH() {
        int i = com.baidu.tieba.recommendfrs.control.a.n.aFn().cnb;
        if (i == 0) {
            if (this.dFh != null) {
                this.dFh.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.m mVar = (com.baidu.tieba.recommendfrs.m) x.b(this.dFg, i % 3);
        if (mVar != null) {
            mVar.aEU();
        }
    }
}
