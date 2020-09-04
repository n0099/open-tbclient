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
/* loaded from: classes18.dex */
public class a {
    private static final int feL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int kyQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int loT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> eO(List<q> list) {
        bw bwVar;
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) y.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (bwVar = ((CardPersonDynamicThreadData) qVar).dUW) != null) {
                com.baidu.tbadk.a.a.a.a(bwVar);
                c az = az(bwVar);
                if (az != null) {
                    arrayList.add(az);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aG(arrayList);
        return arrayList;
    }

    public static List<q> eP(List<bw> list) {
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            bw bwVar = (bw) y.getItem(list, i);
            if (bwVar != null) {
                com.baidu.tbadk.a.a.a.a(bwVar);
                c az = az(bwVar);
                if (az != null) {
                    arrayList.add(az);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aG(arrayList);
        return arrayList;
    }

    public static bw i(q qVar) {
        if (qVar != null && (qVar instanceof AbsThreadDataSupport)) {
            bw bce = ((AbsThreadDataSupport) qVar).bce();
            com.baidu.tbadk.a.a.a.a(bce);
            return bce;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static c az(bw bwVar) {
        l lVar = null;
        lVar = null;
        if (bwVar != null) {
            bwVar.eem = true;
            bwVar.beg();
            if (bwVar.isShareThread) {
                l lVar2 = new l();
                lVar2.dUW = bwVar;
                lVar = lVar2;
            } else if (f.aa(bwVar)) {
                lVar = new f(bwVar);
            } else if (g.ab(bwVar)) {
                lVar = new g(bwVar);
            } else if (l.aa(bwVar) || l.ac(bwVar)) {
                l lVar3 = new l();
                if (bwVar.isLinkThread()) {
                    lVar3.isLinkThread = true;
                } else if (bwVar.bfH()) {
                    lVar3.eaM = true;
                } else {
                    lVar3.isLinkThread = false;
                    if (bwVar.beH()) {
                        lVar3.hno = true;
                    } else {
                        lVar3.hno = false;
                    }
                }
                lVar3.dUW = bwVar;
                lVar3.hnp = true;
                lVar = lVar3;
            } else if (m.aa(bwVar)) {
                lVar = new m(bwVar);
            }
            if (lVar != null) {
                lVar.ccq();
                com.baidu.tbadk.a.a.a.a(lVar);
            }
        }
        return lVar;
    }

    public static List<q> eQ(List<bw> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            k kVar = new k();
            kVar.paddingBottom = loT;
            kVar.paddingTop = kyQ;
            kVar.paddingLeft = feL;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bw bwVar = list.get(i);
                if (bwVar != null) {
                    com.baidu.tbadk.a.a.a.a(bwVar);
                    c az = az(bwVar);
                    if (az != null) {
                        arrayList.add(az);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.aG(arrayList);
        }
        return arrayList;
    }
}
