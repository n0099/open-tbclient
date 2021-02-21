package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes8.dex */
public class a {
    private static final int fWF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int mDY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int mDZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<n> fA(List<n> list) {
        cb cbVar;
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            n nVar = (n) y.getItem(list, i);
            if ((nVar instanceof CardPersonDynamicThreadData) && (cbVar = ((CardPersonDynamicThreadData) nVar).eJQ) != null) {
                com.baidu.tbadk.a.a.a.a(cbVar);
                b aE = aE(cbVar);
                if (aE != null) {
                    arrayList.add(aE);
                }
            }
        }
        com.baidu.tbadk.a.a.a.bj(arrayList);
        return arrayList;
    }

    public static List<n> fB(List<cb> list) {
        ArrayList arrayList = new ArrayList();
        if (y.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            cb cbVar = (cb) y.getItem(list, i);
            if (cbVar != null) {
                com.baidu.tbadk.a.a.a.a(cbVar);
                b aE = aE(cbVar);
                if (aE != null) {
                    arrayList.add(aE);
                }
            }
        }
        com.baidu.tbadk.a.a.a.bj(arrayList);
        return arrayList;
    }

    public static cb i(n nVar) {
        if (nVar != null && (nVar instanceof com.baidu.tbadk.core.data.a)) {
            cb bln = ((com.baidu.tbadk.core.data.a) nVar).bln();
            bln.eTH = true;
            com.baidu.tbadk.a.a.a.a(bln);
            return bln;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static b aE(cb cbVar) {
        k kVar = null;
        kVar = null;
        if (cbVar != null) {
            cbVar.eTH = true;
            cbVar.bns();
            if (cbVar.isShareThread) {
                k kVar2 = new k();
                kVar2.eJQ = cbVar;
                kVar = kVar2;
            } else if (e.ae(cbVar)) {
                kVar = new e(cbVar);
            } else if (f.af(cbVar)) {
                kVar = new f(cbVar);
            } else if (k.ae(cbVar) || k.ag(cbVar)) {
                k kVar3 = new k();
                if (cbVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (cbVar.boU()) {
                    kVar3.eQc = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (cbVar.bnT()) {
                        kVar3.iBj = true;
                    } else {
                        kVar3.iBj = false;
                    }
                }
                kVar3.eJQ = cbVar;
                kVar3.iBk = true;
                kVar = kVar3;
            } else if (l.ae(cbVar)) {
                kVar = new l(cbVar);
            }
            if (kVar != null) {
                com.baidu.tbadk.a.a.a.a(kVar);
            }
        }
        return kVar;
    }

    public static List<n> fC(List<cb> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = mDZ;
            kVar.paddingTop = mDY;
            kVar.paddingLeft = fWF;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                cb cbVar = list.get(i);
                if (cbVar != null) {
                    com.baidu.tbadk.a.a.a.a(cbVar);
                    b aE = aE(cbVar);
                    if (aE != null) {
                        arrayList.add(aE);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.bj(arrayList);
        }
        return arrayList;
    }
}
