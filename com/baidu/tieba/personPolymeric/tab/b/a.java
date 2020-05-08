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
    private static final int eoI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int kcG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int kcH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<m> ed(List<m> list) {
        bj bjVar;
        m aX;
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
            if ((mVar instanceof CardPersonDynamicThreadData) && (bjVar = ((CardPersonDynamicThreadData) mVar).dqE) != null && (aX = aX(bjVar)) != null) {
                arrayList.add(aX);
            }
            i = i2 + 1;
        }
    }

    public static List<m> ee(List<bj> list) {
        m aX;
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
            if (bjVar != null && (aX = aX(bjVar)) != null) {
                arrayList.add(aX);
            }
            i = i2 + 1;
        }
    }

    public static bj i(m mVar) {
        if (mVar == null) {
            return null;
        }
        if (mVar instanceof e) {
            return ((e) mVar).dqE;
        }
        if (mVar instanceof f) {
            return ((f) mVar).dqE;
        }
        if (mVar instanceof k) {
            return ((k) mVar).dqE;
        }
        if (mVar instanceof l) {
            return ((l) mVar).dqE;
        }
        return null;
    }

    public static m aX(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.isShareThread) {
            k kVar = new k();
            kVar.dqE = bjVar;
            return kVar;
        } else if (e.ab(bjVar)) {
            return new e(bjVar);
        } else {
            if (f.ac(bjVar)) {
                return new f(bjVar);
            }
            if (k.ab(bjVar) || k.ad(bjVar)) {
                k kVar2 = new k();
                if (bjVar.isLinkThread()) {
                    kVar2.isLinkThread = true;
                } else if (bjVar.aLC()) {
                    kVar2.dqC = true;
                } else {
                    kVar2.isLinkThread = false;
                    if (bjVar.aKF()) {
                        kVar2.gsQ = true;
                    } else {
                        kVar2.gsQ = false;
                    }
                }
                kVar2.dqE = bjVar;
                kVar2.gsR = true;
                return kVar2;
            } else if (l.ab(bjVar)) {
                return new l(bjVar);
            } else {
                return null;
            }
        }
    }

    public static List<m> ef(List<bj> list) {
        m aX;
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.paddingBottom = kcH;
            kVar.paddingTop = kcG;
            kVar.paddingLeft = eoI;
            kVar.titleId = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                bj bjVar = list.get(i2);
                if (bjVar != null && (aX = aX(bjVar)) != null) {
                    arrayList.add(aX);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }
}
