package com.baidu.tieba.personPolymeric.tab.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final int dOe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int jqz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int jqA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<m> dS(List<m> list) {
        bj bjVar;
        m aV;
        ArrayList arrayList = new ArrayList();
        if (v.isEmpty(list)) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            m mVar = (m) v.getItem(list, i2);
            if ((mVar instanceof CardPersonDynamicThreadData) && (bjVar = ((CardPersonDynamicThreadData) mVar).cRe) != null && (aV = aV(bjVar)) != null) {
                arrayList.add(aV);
            }
            i = i2 + 1;
        }
    }

    public static List<m> dT(List<bj> list) {
        m aV;
        ArrayList arrayList = new ArrayList();
        if (v.isEmpty(list)) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            bj bjVar = (bj) v.getItem(list, i2);
            if (bjVar != null && (aV = aV(bjVar)) != null) {
                arrayList.add(aV);
            }
            i = i2 + 1;
        }
    }

    public static bj i(m mVar) {
        if (mVar == null) {
            return null;
        }
        if (mVar instanceof e) {
            return ((e) mVar).cRe;
        }
        if (mVar instanceof f) {
            return ((f) mVar).cRe;
        }
        if (mVar instanceof k) {
            return ((k) mVar).cRe;
        }
        if (mVar instanceof l) {
            return ((l) mVar).cRe;
        }
        return null;
    }

    public static m aV(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.isShareThread) {
            k kVar = new k();
            kVar.cRe = bjVar;
            return kVar;
        } else if (e.aa(bjVar)) {
            return new e(bjVar);
        } else {
            if (f.ab(bjVar)) {
                return new f(bjVar);
            }
            if (k.aa(bjVar) || k.ac(bjVar)) {
                k kVar2 = new k();
                if (bjVar.isLinkThread()) {
                    kVar2.isLinkThread = true;
                } else if (bjVar.aDl()) {
                    kVar2.cRd = true;
                } else {
                    kVar2.isLinkThread = false;
                    if (bjVar.aCp()) {
                        kVar2.fNg = true;
                    } else {
                        kVar2.fNg = false;
                    }
                }
                kVar2.cRe = bjVar;
                kVar2.fNh = true;
                return kVar2;
            } else if (l.aa(bjVar)) {
                return new l(bjVar);
            } else {
                return null;
            }
        }
    }

    public static List<m> dU(List<bj> list) {
        m aV;
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = jqA;
            kVar.paddingTop = jqz;
            kVar.paddingLeft = dOe;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                bj bjVar = list.get(i2);
                if (bjVar != null && (aV = aV(bjVar)) != null) {
                    arrayList.add(aV);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }
}
