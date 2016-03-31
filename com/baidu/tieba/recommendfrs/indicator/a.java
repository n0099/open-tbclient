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
import com.baidu.tieba.recommendfrs.control.a.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends PagerAdapter implements com.baidu.tbadk.pageStayDuration.a {
    private BdUniqueId aSu;
    private com.baidu.tieba.recommendfrs.f dXg;
    private long lastResumeTime;
    private Context mContext;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private String aAo = null;
    private com.baidu.tieba.recommendfrs.d dVl = new b(this);
    private CustomMessageListener dXh = new c(this, CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK);
    private CustomMessageListener dXi = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private ArrayList<com.baidu.tieba.recommendfrs.data.l> dXf = new ArrayList<>();
    private ArrayList<com.baidu.tieba.recommendfrs.n> cIa = new ArrayList<>();

    public a(Context context, com.baidu.tieba.recommendfrs.b bVar, com.baidu.tieba.recommendfrs.c cVar, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aSu = bdUniqueId;
        this.cIa.add(a(bVar));
        this.cIa.add(a(bVar));
        this.cIa.add(a(bVar));
        this.dXg = new com.baidu.tieba.recommendfrs.f(context);
        this.dXg.setPageUniqueId(bdUniqueId);
        this.dXg.setCallback(cVar);
        this.dXh.setTag(bdUniqueId);
        this.dXi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dXh);
        MessageManager.getInstance().registerListener(this.dXi);
    }

    private com.baidu.tieba.recommendfrs.n a(com.baidu.tieba.recommendfrs.b bVar) {
        com.baidu.tieba.recommendfrs.n nVar = new com.baidu.tieba.recommendfrs.n(this.mContext);
        nVar.j(this.aSu);
        nVar.setCallback(bVar);
        nVar.setScrollCallback(this.dVl);
        return nVar;
    }

    public void ap(List<com.baidu.tieba.recommendfrs.data.l> list) {
        if (this.dXf == null) {
            this.dXf = new ArrayList<>();
        }
        this.dXf.clear();
        if (list != null && list.size() > 0) {
            this.dXf.addAll(list);
        }
        notifyDataSetChanged();
        aMu();
    }

    private void aMu() {
        int size = this.cIa.size();
        for (int i = 1; i < size; i++) {
            com.baidu.tieba.recommendfrs.n nVar = this.cIa.get(i % size);
            com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) y.b(this.dXf, i);
            if (nVar != null && lVar != null) {
                nVar.a(lVar, true, false);
            }
        }
    }

    public void a(boolean z, long j, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2) {
        if (this.dXf != null && !this.dXf.isEmpty()) {
            Iterator<com.baidu.tieba.recommendfrs.data.l> it = this.dXf.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.l next = it.next();
                if (next != null && next.aMf() != null && j == next.aMf().tag_code.longValue()) {
                    next.a(z, nVar, z2);
                    notifyDataSetChanged();
                    a(j, next, z2);
                    return;
                }
            }
        }
    }

    public void b(long j, String str, int i) {
        if (j == this.dXg.getTagCode()) {
            this.dXg.ai(str, i);
        } else if (this.cIa != null) {
            Iterator<com.baidu.tieba.recommendfrs.n> it = this.cIa.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.n next = it.next();
                if (next != null && next.bS(j)) {
                    next.ai(str, i);
                    return;
                }
            }
        }
    }

    public void aLK() {
        if (this.dXg != null) {
            this.dXg.aLK();
            aMv();
        }
    }

    private void a(long j, com.baidu.tieba.recommendfrs.data.l lVar, boolean z) {
        if (this.cIa != null) {
            Iterator<com.baidu.tieba.recommendfrs.n> it = this.cIa.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.n next = it.next();
                if (next != null && next.bS(j)) {
                    next.a(lVar, false, z);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.dXf == null) {
            return 0;
        }
        return this.dXf.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (q.aMe().cxD != i) {
            ib(true);
            q.aMe().cxD = i;
            aMv();
            VoiceManager aP = com.baidu.tieba.tbadkCore.voice.b.aP(this.mContext);
            if (aP != null) {
                aP.stopPlay();
            }
            if (obj instanceof com.baidu.tieba.recommendfrs.n) {
                ((com.baidu.tieba.recommendfrs.n) obj).anC();
                if (i == q.aMe().dWy) {
                    TiebaStatic.log(new aw("c10952"));
                    if (q.aMe().dWz != 0 || q.aMe().dWB) {
                        q.aMe().dWB = false;
                        ic(false);
                    }
                }
            } else if (obj instanceof com.baidu.tieba.recommendfrs.f) {
                ((com.baidu.tieba.recommendfrs.f) obj).anC();
            }
        }
    }

    public void c(long j, DataRes dataRes, boolean z) {
        com.baidu.tieba.recommendfrs.data.l lVar;
        if (y.p(this.dXf) <= 0) {
            if (this.dXg != null) {
                this.dXg.a(dataRes, z);
            }
        } else if (j == 0 && (lVar = (com.baidu.tieba.recommendfrs.data.l) y.b(this.dXf, 0)) != null) {
            lVar.c(dataRes);
            this.dXg.a(dataRes, z);
        } else {
            Iterator<com.baidu.tieba.recommendfrs.data.l> it = this.dXf.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.l next = it.next();
                if (next != null && next.aMf() != null && j == next.aMf().tag_code.longValue()) {
                    next.c(dataRes);
                    next.eU(z);
                    this.dXg.a(dataRes, z);
                    return;
                }
            }
        }
    }

    public int bV(long j) {
        if (this.dXf == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.recommendfrs.data.l lVar = this.dXf.get(i);
            if (lVar != null && lVar.aMf() != null && lVar.aMf().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            if (this.dXg.getParent() != null) {
                viewGroup.removeView(this.dXg);
            }
            com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) y.b(this.dXf, i);
            if (lVar != null) {
                this.dXg.setTagInfo(lVar.aMf());
            }
            viewGroup.addView(this.dXg);
            return this.dXg;
        }
        com.baidu.tieba.recommendfrs.n nVar = this.cIa.get(i % 3);
        if (nVar.getParent() != null) {
            viewGroup.removeView(nVar);
        }
        nVar.a(this.dXf.get(i), true, false);
        viewGroup.addView(nVar);
        return nVar;
    }

    private void aMv() {
        this.lastResumeTime = System.currentTimeMillis();
        if (q.aMe().cxD >= 0) {
            if (q.aMe().cxD == 0) {
                this.aAo = "a002";
            } else if (q.aMe().cxD == q.aMe().dWy) {
                this.aAo = "a003";
            } else {
                this.aAo = "a004";
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
        if (this.dXf == null || this.dXf.get(i) == null || this.dXf.get(i).aMf() == null) {
            return null;
        }
        return this.dXf.get(i).aMf().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dn(int i) {
        if (this.cIa != null) {
            if (this.dXg != null) {
                this.dXg.onChangeSkinType(i);
            }
            Iterator<com.baidu.tieba.recommendfrs.n> it = this.cIa.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.n next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }

    public void setItemForeGround(int i) {
        aMv();
        if (i == 0) {
            this.dXg.anC();
            return;
        }
        com.baidu.tieba.recommendfrs.n nVar = (com.baidu.tieba.recommendfrs.n) y.b(this.cIa, i % 3);
        if (nVar != null) {
            if (i == q.aMe().dWy) {
                TiebaStatic.log(new aw("c10952"));
            }
            if (i == q.aMe().dWy && q.aMe().dWB) {
                q.aMe().dWB = false;
                ic(false);
                return;
            }
            nVar.anC();
        }
    }

    public void ic(boolean z) {
        int i = q.aMe().cxD;
        if (i == 0) {
            if (this.dXg != null) {
                this.dXg.reload();
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.n nVar = (com.baidu.tieba.recommendfrs.n) y.b(this.cIa, i % 3);
        if (nVar != null) {
            nVar.hX(z);
        }
    }

    private View aMw() {
        int i = q.aMe().cxD;
        if (i == 0) {
            return this.dXg;
        }
        return (View) y.b(this.cIa, i % 3);
    }

    public void onDestroy() {
        this.dXg.onDestroy();
        Iterator<com.baidu.tieba.recommendfrs.n> it = this.cIa.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.recommendfrs.n next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
    }

    public void ib(boolean z) {
        if (this.lastResumeTime != 0 && z) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.O(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Gr().a(this.mContext, pageStayDurationItem);
        }
        View aMw = aMw();
        if (aMw instanceof com.baidu.tieba.recommendfrs.n) {
            ((com.baidu.tieba.recommendfrs.n) aMw).aLL();
        } else if (aMw instanceof com.baidu.tieba.recommendfrs.f) {
            ((com.baidu.tieba.recommendfrs.f) aMw).aLL();
        }
    }

    public void aMx() {
        int i = q.aMe().cxD;
        if (i == 0) {
            if (this.dXg != null) {
                this.dXg.setViewForeground(true);
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.n nVar = (com.baidu.tieba.recommendfrs.n) y.b(this.cIa, i % 3);
        if (nVar != null) {
            nVar.anC();
        }
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return this.aAo;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.mContext instanceof com.baidu.tbadk.pageStayDuration.a) {
            arrayList2 = (ArrayList) ((com.baidu.tbadk.pageStayDuration.a) this.mContext).getCurrentPageSourceKeyList();
        }
        if (!y.q(arrayList2)) {
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
        if (y.q(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Gl()) && !StringUtils.isNull(currentPageKey)) {
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
        this.pageStayDurationItem.A(getCurrentPageSourceKeyList());
        this.pageStayDurationItem.fZ(getCurrentPageKey());
        return this.pageStayDurationItem;
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }
}
