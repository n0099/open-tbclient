package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes24.dex */
public class a {
    private static final int fPv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int mtV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int mtW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> fC(List<q> list) {
        by byVar;
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) y.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (byVar = ((CardPersonDynamicThreadData) qVar).eCR) != null) {
                com.baidu.tbadk.a.a.a.a(byVar);
                b aC = aC(byVar);
                if (aC != null) {
                    arrayList.add(aC);
                }
            }
        }
        com.baidu.tbadk.a.a.a.bh(arrayList);
        return arrayList;
    }

    public static List<q> fD(List<by> list) {
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            by byVar = (by) y.getItem(list, i);
            if (byVar != null) {
                com.baidu.tbadk.a.a.a.a(byVar);
                b aC = aC(byVar);
                if (aC != null) {
                    arrayList.add(aC);
                }
            }
        }
        com.baidu.tbadk.a.a.a.bh(arrayList);
        return arrayList;
    }

    public static by i(q qVar) {
        if (qVar != null && (qVar instanceof com.baidu.tbadk.core.data.a)) {
            by bmn = ((com.baidu.tbadk.core.data.a) qVar).bmn();
            com.baidu.tbadk.a.a.a.a(bmn);
            return bmn;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static b aC(by byVar) {
        k kVar = null;
        kVar = null;
        if (byVar != null) {
            byVar.eMl = true;
            byVar.bor();
            if (byVar.isShareThread) {
                k kVar2 = new k();
                kVar2.eCR = byVar;
                kVar = kVar2;
            } else if (e.ad(byVar)) {
                kVar = new e(byVar);
            } else if (f.ae(byVar)) {
                kVar = new f(byVar);
            } else if (k.ad(byVar) || k.af(byVar)) {
                k kVar3 = new k();
                if (byVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (byVar.bpU()) {
                    kVar3.eII = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (byVar.boS()) {
                        kVar3.inw = true;
                    } else {
                        kVar3.inw = false;
                    }
                }
                kVar3.eCR = byVar;
                kVar3.inx = true;
                kVar = kVar3;
            } else if (l.ad(byVar)) {
                kVar = new l(byVar);
            }
            if (kVar != null) {
                com.baidu.tbadk.a.a.a.a(kVar);
            }
        }
        return kVar;
    }

    public static List<q> fE(List<by> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = mtW;
            kVar.paddingTop = mtV;
            kVar.paddingLeft = fPv;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                by byVar = list.get(i);
                if (byVar != null) {
                    com.baidu.tbadk.a.a.a.a(byVar);
                    b aC = aC(byVar);
                    if (aC != null) {
                        arrayList.add(aC);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.bh(arrayList);
        }
        return arrayList;
    }
}
