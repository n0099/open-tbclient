package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private static final int fHI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int mfP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int mfQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> fq(List<q> list) {
        bx bxVar;
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) y.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (bxVar = ((CardPersonDynamicThreadData) qVar).evQ) != null) {
                com.baidu.tbadk.a.a.a.a(bxVar);
                b aC = aC(bxVar);
                if (aC != null) {
                    arrayList.add(aC);
                }
            }
        }
        com.baidu.tbadk.a.a.a.be(arrayList);
        return arrayList;
    }

    public static List<q> fr(List<bx> list) {
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            bx bxVar = (bx) y.getItem(list, i);
            if (bxVar != null) {
                com.baidu.tbadk.a.a.a.a(bxVar);
                b aC = aC(bxVar);
                if (aC != null) {
                    arrayList.add(aC);
                }
            }
        }
        com.baidu.tbadk.a.a.a.be(arrayList);
        return arrayList;
    }

    public static bx i(q qVar) {
        if (qVar != null && (qVar instanceof com.baidu.tbadk.core.data.a)) {
            bx bjd = ((com.baidu.tbadk.core.data.a) qVar).bjd();
            com.baidu.tbadk.a.a.a.a(bjd);
            return bjd;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static b aC(bx bxVar) {
        k kVar = null;
        kVar = null;
        if (bxVar != null) {
            bxVar.eFj = true;
            bxVar.ble();
            if (bxVar.isShareThread) {
                k kVar2 = new k();
                kVar2.evQ = bxVar;
                kVar = kVar2;
            } else if (e.ad(bxVar)) {
                kVar = new e(bxVar);
            } else if (f.ae(bxVar)) {
                kVar = new f(bxVar);
            } else if (k.ad(bxVar) || k.af(bxVar)) {
                k kVar3 = new k();
                if (bxVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (bxVar.bmH()) {
                    kVar3.eBH = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (bxVar.blF()) {
                        kVar3.icy = true;
                    } else {
                        kVar3.icy = false;
                    }
                }
                kVar3.evQ = bxVar;
                kVar3.icz = true;
                kVar = kVar3;
            } else if (l.ad(bxVar)) {
                kVar = new l(bxVar);
            }
            if (kVar != null) {
                com.baidu.tbadk.a.a.a.a(kVar);
            }
        }
        return kVar;
    }

    public static List<q> fs(List<bx> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = mfQ;
            kVar.paddingTop = mfP;
            kVar.paddingLeft = fHI;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bx bxVar = list.get(i);
                if (bxVar != null) {
                    com.baidu.tbadk.a.a.a.a(bxVar);
                    b aC = aC(bxVar);
                    if (aC != null) {
                        arrayList.add(aC);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.be(arrayList);
        }
        return arrayList;
    }
}
