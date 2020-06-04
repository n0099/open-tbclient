package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.a.a.c;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final int eDv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int jHa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int kvE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<o> em(List<o> list) {
        bk bkVar;
        ArrayList arrayList = new ArrayList();
        if (v.isEmpty(list)) {
            return arrayList;
        }
        e aMx = c.aMx();
        for (int i = 0; i < list.size(); i++) {
            o oVar = (o) v.getItem(list, i);
            if ((oVar instanceof CardPersonDynamicThreadData) && (bkVar = ((CardPersonDynamicThreadData) oVar).dEA) != null) {
                c.a(aMx, bkVar);
                com.baidu.tieba.card.data.c aB = aB(bkVar);
                if (aB != null) {
                    arrayList.add(aB);
                }
            }
        }
        c.a(aMx, arrayList);
        return arrayList;
    }

    public static List<o> en(List<bk> list) {
        ArrayList arrayList = new ArrayList();
        if (v.isEmpty(list)) {
            return arrayList;
        }
        e aMx = c.aMx();
        for (int i = 0; i < list.size(); i++) {
            bk bkVar = (bk) v.getItem(list, i);
            if (bkVar != null) {
                c.a(aMx, bkVar);
                com.baidu.tieba.card.data.c aB = aB(bkVar);
                if (aB != null) {
                    arrayList.add(aB);
                }
            }
        }
        c.a(aMx, arrayList);
        return arrayList;
    }

    public static bk i(o oVar) {
        if (oVar != null && (oVar instanceof AbsThreadDataSupport)) {
            bk aOi = ((AbsThreadDataSupport) oVar).aOi();
            c.a(c.aMx(), aOi);
            return aOi;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0013 */
    public static com.baidu.tieba.card.data.c aB(bk bkVar) {
        k kVar = null;
        kVar = null;
        if (bkVar != null) {
            bkVar.dHP = true;
            if (bkVar.isShareThread) {
                k kVar2 = new k();
                kVar2.dEA = bkVar;
                kVar = kVar2;
            } else if (com.baidu.tieba.card.data.e.ac(bkVar)) {
                kVar = new com.baidu.tieba.card.data.e(bkVar);
            } else if (f.ad(bkVar)) {
                kVar = new f(bkVar);
            } else if (k.ac(bkVar) || k.ae(bkVar)) {
                k kVar3 = new k();
                if (bkVar.isLinkThread()) {
                    kVar3.isLinkThread = true;
                } else if (bkVar.aRB()) {
                    kVar3.dEy = true;
                } else {
                    kVar3.isLinkThread = false;
                    if (bkVar.aQA()) {
                        kVar3.gHO = true;
                    } else {
                        kVar3.gHO = false;
                    }
                }
                kVar3.dEA = bkVar;
                kVar3.gHP = true;
                kVar = kVar3;
            } else if (l.ac(bkVar)) {
                kVar = new l(bkVar);
            }
            if (kVar != null) {
                kVar.bLH();
                c.a(c.aMx(), kVar);
            }
        }
        return kVar;
    }

    public static List<o> eo(List<bk> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            e aMx = c.aMx();
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = kvE;
            kVar.paddingTop = jHa;
            kVar.paddingLeft = eDv;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                bk bkVar = list.get(i);
                if (bkVar != null) {
                    c.a(aMx, bkVar);
                    com.baidu.tieba.card.data.c aB = aB(bkVar);
                    if (aB != null) {
                        arrayList.add(aB);
                    }
                }
            }
            c.a(aMx, arrayList);
        }
        return arrayList;
    }
}
