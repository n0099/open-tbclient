package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private static final int eUa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int kjp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int kYx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<q> eG(List<q> list) {
        bv bvVar;
        ArrayList arrayList = new ArrayList();
        if (x.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            q qVar = (q) x.getItem(list, i);
            if ((qVar instanceof CardPersonDynamicThreadData) && (bvVar = ((CardPersonDynamicThreadData) qVar).dLK) != null) {
                com.baidu.tbadk.a.a.a.a(bvVar);
                c ay = ay(bvVar);
                if (ay != null) {
                    arrayList.add(ay);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aG(arrayList);
        return arrayList;
    }

    public static List<q> eH(List<bv> list) {
        ArrayList arrayList = new ArrayList();
        if (x.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            bv bvVar = (bv) x.getItem(list, i);
            if (bvVar != null) {
                com.baidu.tbadk.a.a.a.a(bvVar);
                c ay = ay(bvVar);
                if (ay != null) {
                    arrayList.add(ay);
                }
            }
        }
        com.baidu.tbadk.a.a.a.aG(arrayList);
        return arrayList;
    }

    public static bv i(q qVar) {
        if (qVar != null && (qVar instanceof AbsThreadDataSupport)) {
            bv aTN = ((AbsThreadDataSupport) qVar).aTN();
            com.baidu.tbadk.a.a.a.a(aTN);
            return aTN;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0016 */
    public static c ay(bv bvVar) {
        k kVar = null;
        kVar = null;
        if (bvVar != null) {
            bvVar.dUM = true;
            bvVar.aVN();
            if (bvVar.isShareThread) {
                k kVar2 = new k();
                kVar2.dLK = bvVar;
                kVar = kVar2;
            } else if (e.aa(bvVar)) {
                kVar = new e(bvVar);
            } else if (f.ab(bvVar)) {
                kVar = new f(bvVar);
            } else if (k.aa(bvVar) || k.ac(bvVar)) {
                k kVar3 = new k();
                if (bvVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (bvVar.aXo()) {
                    kVar3.dRo = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (bvVar.aWo()) {
                        kVar3.has = true;
                    } else {
                        kVar3.has = false;
                    }
                }
                kVar3.dLK = bvVar;
                kVar3.hat = true;
                kVar = kVar3;
            } else if (l.aa(bvVar)) {
                kVar = new l(bvVar);
            }
            if (kVar != null) {
                kVar.bSd();
                com.baidu.tbadk.a.a.a.a(kVar);
            }
        }
        return kVar;
    }

    public static List<q> eI(List<bv> list) {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = kYx;
            kVar.paddingTop = kjp;
            kVar.paddingLeft = eUa;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bv bvVar = list.get(i);
                if (bvVar != null) {
                    com.baidu.tbadk.a.a.a.a(bvVar);
                    c ay = ay(bvVar);
                    if (ay != null) {
                        arrayList.add(ay);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.aG(arrayList);
        }
        return arrayList;
    }
}
