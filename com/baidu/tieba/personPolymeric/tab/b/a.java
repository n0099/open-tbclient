package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.personPolymeric.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private static final int ftT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int kWy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int lNb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> eZ(List<q> list) {
        bw bwVar;
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) y.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (bwVar = ((CardPersonDynamicThreadData) qVar).eji) != null) {
                com.baidu.tbadk.a.a.a.a(bwVar);
                c aA = aA(bwVar);
                if (aA != null) {
                    arrayList.add(aA);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aN(arrayList);
        return arrayList;
    }

    public static List<q> fa(List<bw> list) {
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            bw bwVar = (bw) y.getItem(list, i);
            if (bwVar != null) {
                com.baidu.tbadk.a.a.a.a(bwVar);
                c aA = aA(bwVar);
                if (aA != null) {
                    arrayList.add(aA);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aN(arrayList);
        return arrayList;
    }

    public static bw i(q qVar) {
        if (qVar != null && (qVar instanceof AbsThreadDataSupport)) {
            bw bfG = ((AbsThreadDataSupport) qVar).bfG();
            com.baidu.tbadk.a.a.a.a(bfG);
            return bfG;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static c aA(bw bwVar) {
        l lVar = null;
        lVar = null;
        if (bwVar != null) {
            bwVar.esC = true;
            bwVar.bhJ();
            if (bwVar.isShareThread) {
                l lVar2 = new l();
                lVar2.eji = bwVar;
                lVar = lVar2;
            } else if (f.ab(bwVar)) {
                lVar = new f(bwVar);
            } else if (g.ac(bwVar)) {
                lVar = new g(bwVar);
            } else if (l.ab(bwVar) || l.ad(bwVar)) {
                l lVar3 = new l();
                if (bwVar.isLinkThread()) {
                    lVar3.isLinkThread = true;
                } else if (bwVar.bjk()) {
                    lVar3.epb = true;
                } else {
                    lVar3.isLinkThread = false;
                    if (bwVar.bik()) {
                        lVar3.hJn = true;
                    } else {
                        lVar3.hJn = false;
                    }
                }
                lVar3.eji = bwVar;
                lVar3.hJo = true;
                lVar = lVar3;
            } else if (m.ab(bwVar)) {
                lVar = new m(bwVar);
            }
            if (lVar != null) {
                lVar.cjb();
                com.baidu.tbadk.a.a.a.a(lVar);
            }
        }
        return lVar;
    }

    public static List<q> fb(List<bw> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            k kVar = new k();
            kVar.paddingBottom = lNb;
            kVar.paddingTop = kWy;
            kVar.paddingLeft = ftT;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bw bwVar = list.get(i);
                if (bwVar != null) {
                    com.baidu.tbadk.a.a.a.a(bwVar);
                    c aA = aA(bwVar);
                    if (aA != null) {
                        arrayList.add(aA);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.aN(arrayList);
        }
        return arrayList;
    }
}
