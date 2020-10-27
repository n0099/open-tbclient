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
    private static final int fCo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int liX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int lZx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> fi(List<q> list) {
        bw bwVar;
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) y.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (bwVar = ((CardPersonDynamicThreadData) qVar).erH) != null) {
                com.baidu.tbadk.a.a.a.a(bwVar);
                c aA = aA(bwVar);
                if (aA != null) {
                    arrayList.add(aA);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aX(arrayList);
        return arrayList;
    }

    public static List<q> fj(List<bw> list) {
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
        com.baidu.tbadk.a.a.a.aX(arrayList);
        return arrayList;
    }

    public static bw i(q qVar) {
        if (qVar != null && (qVar instanceof AbsThreadDataSupport)) {
            bw bhz = ((AbsThreadDataSupport) qVar).bhz();
            com.baidu.tbadk.a.a.a.a(bhz);
            return bhz;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static c aA(bw bwVar) {
        l lVar = null;
        lVar = null;
        if (bwVar != null) {
            bwVar.eBc = true;
            bwVar.bjC();
            if (bwVar.isShareThread) {
                l lVar2 = new l();
                lVar2.erH = bwVar;
                lVar = lVar2;
            } else if (f.ab(bwVar)) {
                lVar = new f(bwVar);
            } else if (g.ac(bwVar)) {
                lVar = new g(bwVar);
            } else if (l.ab(bwVar) || l.ad(bwVar)) {
                l lVar3 = new l();
                if (bwVar.isLinkThread()) {
                    lVar3.isLinkThread = true;
                } else if (bwVar.bld()) {
                    lVar3.exz = true;
                } else {
                    lVar3.isLinkThread = false;
                    if (bwVar.bkd()) {
                        lVar3.hVK = true;
                    } else {
                        lVar3.hVK = false;
                    }
                }
                lVar3.erH = bwVar;
                lVar3.hVL = true;
                lVar = lVar3;
            } else if (m.ab(bwVar)) {
                lVar = new m(bwVar);
            }
            if (lVar != null) {
                lVar.cmi();
                com.baidu.tbadk.a.a.a.a(lVar);
            }
        }
        return lVar;
    }

    public static List<q> fk(List<bw> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            k kVar = new k();
            kVar.paddingBottom = lZx;
            kVar.paddingTop = liX;
            kVar.paddingLeft = fCo;
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
            com.baidu.tbadk.a.a.a.aX(arrayList);
        }
        return arrayList;
    }
}
