package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static final int fUr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int muF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int muG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<n> fC(List<n> list) {
        bz bzVar;
        ArrayList arrayList = new ArrayList();
        if (x.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            n nVar = (n) x.getItem(list, i);
            if ((nVar instanceof CardPersonDynamicThreadData) && (bzVar = ((CardPersonDynamicThreadData) nVar).eHK) != null) {
                com.baidu.tbadk.a.a.a.a(bzVar);
                b aD = aD(bzVar);
                if (aD != null) {
                    arrayList.add(aD);
                }
            }
        }
        com.baidu.tbadk.a.a.a.bo(arrayList);
        return arrayList;
    }

    public static List<n> fD(List<bz> list) {
        ArrayList arrayList = new ArrayList();
        if (x.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            bz bzVar = (bz) x.getItem(list, i);
            if (bzVar != null) {
                com.baidu.tbadk.a.a.a.a(bzVar);
                b aD = aD(bzVar);
                if (aD != null) {
                    arrayList.add(aD);
                }
            }
        }
        com.baidu.tbadk.a.a.a.bo(arrayList);
        return arrayList;
    }

    public static bz i(n nVar) {
        if (nVar != null && (nVar instanceof com.baidu.tbadk.core.data.a)) {
            bz bkV = ((com.baidu.tbadk.core.data.a) nVar).bkV();
            com.baidu.tbadk.a.a.a.a(bkV);
            return bkV;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static b aD(bz bzVar) {
        k kVar = null;
        kVar = null;
        if (bzVar != null) {
            bzVar.eRv = true;
            bzVar.bmZ();
            if (bzVar.isShareThread) {
                k kVar2 = new k();
                kVar2.eHK = bzVar;
                kVar = kVar2;
            } else if (e.ad(bzVar)) {
                kVar = new e(bzVar);
            } else if (f.ae(bzVar)) {
                kVar = new f(bzVar);
            } else if (k.ad(bzVar) || k.af(bzVar)) {
                k kVar3 = new k();
                if (bzVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (bzVar.boC()) {
                    kVar3.eNQ = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (bzVar.bnA()) {
                        kVar3.ivl = true;
                    } else {
                        kVar3.ivl = false;
                    }
                }
                kVar3.eHK = bzVar;
                kVar3.ivm = true;
                kVar = kVar3;
            } else if (l.ad(bzVar)) {
                kVar = new l(bzVar);
            }
            if (kVar != null) {
                com.baidu.tbadk.a.a.a.a(kVar);
            }
        }
        return kVar;
    }

    public static List<n> fE(List<bz> list) {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = muG;
            kVar.paddingTop = muF;
            kVar.paddingLeft = fUr;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bz bzVar = list.get(i);
                if (bzVar != null) {
                    com.baidu.tbadk.a.a.a.a(bzVar);
                    b aD = aD(bzVar);
                    if (aD != null) {
                        arrayList.add(aD);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.bo(arrayList);
        }
        return arrayList;
    }
}
