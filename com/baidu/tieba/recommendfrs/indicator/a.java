package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId aOT;
    private com.baidu.tieba.recommendfrs.f eap;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String awr = null;
    private com.baidu.tieba.recommendfrs.d dYe = new b(this);
    private CustomMessageListener eaq = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener ear = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private ArrayList<com.baidu.tieba.recommendfrs.data.l> eao = new ArrayList<>();
    private ArrayList<com.baidu.tieba.recommendfrs.o> aNw = new ArrayList<>();

    public void a(com.baidu.tieba.recommendfrs.control.m mVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.eap != null) {
            this.eap.a(mVar, onTouchListener, viewGroup);
        }
        if (this.aNw != null) {
            Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.o next = it.next();
                if (next != null) {
                    next.a(mVar, onTouchListener);
                }
            }
        }
    }

    public void jx() {
        if (this.eap != null) {
            this.eap.jx();
        }
        if (this.aNw != null) {
            Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.o next = it.next();
                if (next != null) {
                    next.jx();
                }
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eap != null) {
            this.eap.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.aNw != null) {
            Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.o next = it.next();
                if (next != null) {
                    next.b(view, i, i2, i3, i4);
                }
            }
        }
        if (this.eap != null) {
            this.eap.b(view, i, i2, i3, i4);
        }
    }

    public a(Context context, com.baidu.tieba.recommendfrs.b bVar, com.baidu.tieba.recommendfrs.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aOT = bdUniqueId;
        this.aNw.add(a(bVar));
        this.aNw.add(a(bVar));
        this.aNw.add(a(bVar));
        this.eap = new com.baidu.tieba.recommendfrs.f(context);
        this.eap.setPageUniqueId(bdUniqueId);
        this.eap.setCallback(cVar);
        this.eaq.setTag(bdUniqueId);
        this.ear.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaq);
        MessageManager.getInstance().registerListener(this.ear);
    }

    private com.baidu.tieba.recommendfrs.o a(com.baidu.tieba.recommendfrs.b bVar) {
        com.baidu.tieba.recommendfrs.o oVar = new com.baidu.tieba.recommendfrs.o(this.mContext);
        oVar.j(this.aOT);
        oVar.setCallback(bVar);
        oVar.setScrollCallback(this.dYe);
        return oVar;
    }

    public void an(List<com.baidu.tieba.recommendfrs.data.l> list) {
        if (this.eao == null) {
            this.eao = new ArrayList<>();
        }
        this.eao.clear();
        if (list != null && list.size() > 0) {
            this.eao.addAll(list);
        }
        notifyDataSetChanged();
        aMI();
    }

    private void aMI() {
        int size = this.aNw.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.recommendfrs.o oVar = this.aNw.get(i % size);
            com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) y.c(this.eao, i);
            if (oVar != null && lVar != null) {
                oVar.a(lVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2) {
        if (this.eao != null && !this.eao.isEmpty()) {
            Iterator<com.baidu.tieba.recommendfrs.data.l> it = this.eao.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.l next = it.next();
                if (next != null && next.aMt() != null && j == next.aMt().tag_code.longValue()) {
                    next.a(z, nVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void b(long j, String str, int i) {
        if (j == this.eap.getTagCode()) {
            this.eap.an(str, i);
        } else if (this.aNw != null) {
            Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.o next = it.next();
                if (next != null && next.bS(j)) {
                    next.an(str, i);
                    return;
                }
            }
        }
    }

    public void aLR() {
        if (this.eap != null) {
            this.eap.aLR();
            aMJ();
        }
    }

    private void a(long j, com.baidu.tieba.recommendfrs.data.l lVar, boolean z) {
        if (this.aNw != null) {
            Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.o next = it.next();
                if (next != null && next.bS(j)) {
                    next.a(lVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eao == null) {
            return 0;
        }
        return this.eao.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC != i) {
            iL(true);
            com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC = i;
            aMJ();
            VoiceManager aV = com.baidu.tieba.tbadkCore.voice.b.aV(this.mContext);
            if (aV != null) {
                aV.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.recommendfrs.o) {
                com.baidu.tieba.recommendfrs.o oVar = (com.baidu.tieba.recommendfrs.o) obj;
                oVar.anC();
                oVar.RS();
                if (i == com.baidu.tieba.recommendfrs.control.a.q.aMs().dZI) {
                    TiebaStatic.log(new aw("c10952"));
                    if (com.baidu.tieba.recommendfrs.control.a.q.aMs().dZJ != 0 || com.baidu.tieba.recommendfrs.control.a.q.aMs().dZL) {
                        com.baidu.tieba.recommendfrs.control.a.q.aMs().dZL = false;
                        iR(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.recommendfrs.f) {
                com.baidu.tieba.recommendfrs.f fVar = (com.baidu.tieba.recommendfrs.f) obj;
                fVar.anC();
                fVar.RS();
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.recommendfrs.data.l lVar;
        if (y.r(this.eao) <= 0) {
            if (this.eap != null) {
                this.eap.a(dataRes, z);
            }
        } else if (j == 0 && (lVar = (com.baidu.tieba.recommendfrs.data.l) y.c(this.eao, 0)) != null) {
            lVar.c(dataRes);
            this.eap.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.recommendfrs.data.l> it = this.eao.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.l next = it.next();
                if (next != null && next.aMt() != null && j == next.aMt().tag_code.longValue()) {
                    next.c(dataRes);
                    next.fs(z);
                    this.eap.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bV(long j) {
        if (this.eao == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.recommendfrs.data.l lVar = this.eao.get(i);
            if (lVar != null && lVar.aMt() != null && lVar.aMt().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.eap.getParent() != null) {
                viewGroup.removeView(this.eap);
            }
            com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) y.c(this.eao, i);
            if (lVar != null) {
                this.eap.setTagInfo(lVar.aMt());
            }
            viewGroup.addView(this.eap);
            return this.eap;
        }
        com.baidu.tieba.recommendfrs.o oVar = this.aNw.get(i % 3);
        if (oVar.getParent() != null) {
            viewGroup.removeView(oVar);
        }
        oVar.a(this.eao.get(i), true, false);
        viewGroup.addView(oVar);
        return oVar;
    }

    private void aMJ() {
        this.lastResumeTime = System.currentTimeMillis();
        if (com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC >= 0) {
            if (com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC == 0) {
                this.awr = "a002";
            } else if (com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC == com.baidu.tieba.recommendfrs.control.a.q.aMs().dZI) {
                this.awr = "a003";
            } else {
                this.awr = "a004";
            }
        }
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
        if (this.eao == null || this.eao.get(i) == null || this.eao.get(i).aMt() == null) {
            return null;
        }
        return this.eao.get(i).aMt().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void cV(int i) {
        if (this.aNw != null) {
            if (this.eap != null) {
                this.eap.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.o next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        aMJ();
        if (i == 0) {
            this.eap.anC();
            return;
        }
        com.baidu.tieba.recommendfrs.o oVar = (com.baidu.tieba.recommendfrs.o) y.c(this.aNw, i % 3);
        if (oVar != null) {
            if (i == com.baidu.tieba.recommendfrs.control.a.q.aMs().dZI) {
                TiebaStatic.log(new aw("c10952"));
            }
            if (i == com.baidu.tieba.recommendfrs.control.a.q.aMs().dZI && com.baidu.tieba.recommendfrs.control.a.q.aMs().dZL) {
                com.baidu.tieba.recommendfrs.control.a.q.aMs().dZL = false;
                iR(false);
                return;
            }
            oVar.anC();
        }
    }

    public void iR(boolean z) {
        int i = com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC;
        if (i == 0) {
            if (this.eap != null) {
                this.eap.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.o oVar = (com.baidu.tieba.recommendfrs.o) y.c(this.aNw, i % 3);
        if (oVar != null) {
            oVar.iH(z);
        }
    }

    private View aMK() {
        int i = com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC;
        if (i == 0) {
            return this.eap;
        }
        return (View) y.c(this.aNw, i % 3);
    }

    public void onDestroy() {
        this.eap.onDestroy();
        Iterator<com.baidu.tieba.recommendfrs.o> it = this.aNw.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.recommendfrs.o next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void iL(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.P(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Ek().a(this.mContext, pageStayDurationItem);
        }
        View aMK = aMK();
        if (aMK instanceof com.baidu.tieba.recommendfrs.o) {
            ((com.baidu.tieba.recommendfrs.o) aMK).aLS();
        } else if (aMK instanceof com.baidu.tieba.recommendfrs.f) {
            ((com.baidu.tieba.recommendfrs.f) aMK).aLS();
        }
    }

    public void aML() {
        int i = com.baidu.tieba.recommendfrs.control.a.q.aMs().cyC;
        if (i == 0) {
            if (this.eap != null) {
                this.eap.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.o oVar = (com.baidu.tieba.recommendfrs.o) y.c(this.aNw, i % 3);
        if (oVar != null) {
            oVar.anC();
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.awr;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!y.s(arrayList2)) {
            arrayList.addAll(arrayList2);
        }
        arrayList.add("a001");
        return arrayList;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (y.s(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Ee()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
        }
        this.pageStayDurationItem.C(getCurrentPageSourceKeyList());
        this.pageStayDurationItem.fW(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
