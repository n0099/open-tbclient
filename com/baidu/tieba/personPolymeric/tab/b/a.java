package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.a.a.c;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final int eNF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int kaL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int kPB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> eA(List<q> list) {
        bu buVar;
        ArrayList arrayList = new ArrayList();
        if (w.isEmpty(list)) {
            return arrayList;
        }
        e aOa = c.aOa();
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) w.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (buVar = ((CardPersonDynamicThreadData) qVar).dLi) != null) {
                c.a(aOa, buVar);
                com.baidu.tieba.card.data.c aB = aB(buVar);
                if (aB != null) {
                    arrayList.add(aB);
                }
            }
        }
        c.a(aOa, arrayList);
        return arrayList;
    }

    public static List<q> eB(List<bu> list) {
        ArrayList arrayList = new ArrayList();
        if (w.isEmpty(list)) {
            return arrayList;
        }
        e aOa = c.aOa();
        for (int i = 0; i < list.size(); i++) {
            bu buVar = (bu) w.getItem(list, i);
            if (buVar != null) {
                c.a(aOa, buVar);
                com.baidu.tieba.card.data.c aB = aB(buVar);
                if (aB != null) {
                    arrayList.add(aB);
                }
            }
        }
        c.a(aOa, arrayList);
        return arrayList;
    }

    public static bu i(q qVar) {
        if (qVar != null && (qVar instanceof AbsThreadDataSupport)) {
            bu aPS = ((AbsThreadDataSupport) qVar).aPS();
            c.a(c.aOa(), aPS);
            return aPS;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static com.baidu.tieba.card.data.c aB(bu buVar) {
        k kVar = null;
        kVar = null;
        if (buVar != null) {
            buVar.dOB = true;
            buVar.aRR();
            if (buVar.isShareThread) {
                k kVar2 = new k();
                kVar2.dLi = buVar;
                kVar = kVar2;
            } else if (com.baidu.tieba.card.data.e.ad(buVar)) {
                kVar = new com.baidu.tieba.card.data.e(buVar);
            } else if (f.ae(buVar)) {
                kVar = new f(buVar);
            } else if (k.ad(buVar) || k.af(buVar)) {
                k kVar3 = new k();
                if (buVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (buVar.aTs()) {
                    kVar3.dLc = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (buVar.aSs()) {
                        kVar3.gUO = true;
                    } else {
                        kVar3.gUO = false;
                    }
                }
                kVar3.dLi = buVar;
                kVar3.gUP = true;
                kVar = kVar3;
            } else if (l.ad(buVar)) {
                kVar = new l(buVar);
            }
            if (kVar != null) {
                kVar.bOS();
                c.a(c.aOa(), kVar);
            }
        }
        return kVar;
    }

    public static List<q> eC(List<bu> list) {
        ArrayList arrayList = new ArrayList();
        if (!w.isEmpty(list)) {
            e aOa = c.aOa();
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = kPB;
            kVar.paddingTop = kaL;
            kVar.paddingLeft = eNF;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bu buVar = list.get(i);
                if (buVar != null) {
                    c.a(aOa, buVar);
                    com.baidu.tieba.card.data.c aB = aB(buVar);
                    if (aB != null) {
                        arrayList.add(aB);
                    }
                }
            }
            c.a(aOa, arrayList);
        }
        return arrayList;
    }
}
