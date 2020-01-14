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
/* loaded from: classes9.dex */
public class a {
    private static final int dJZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int jpD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int jpE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds39);
    private static final int jpF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds106);

    public static List<m> dW(List<m> list) {
        bj bjVar;
        m aS;
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
            if ((mVar instanceof CardPersonDynamicThreadData) && (bjVar = ((CardPersonDynamicThreadData) mVar).cNb) != null && (aS = aS(bjVar)) != null) {
                arrayList.add(aS);
            }
            i = i2 + 1;
        }
    }

    public static List<m> dX(List<bj> list) {
        m aS;
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
            if (bjVar != null && (aS = aS(bjVar)) != null) {
                arrayList.add(aS);
            }
            i = i2 + 1;
        }
    }

    public static bj i(m mVar) {
        if (mVar == null) {
            return null;
        }
        if (mVar instanceof e) {
            return ((e) mVar).cNb;
        }
        if (mVar instanceof f) {
            return ((f) mVar).cNb;
        }
        if (mVar instanceof k) {
            return ((k) mVar).cNb;
        }
        if (mVar instanceof l) {
            return ((l) mVar).cNb;
        }
        return null;
    }

    public static m aS(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.isShareThread) {
            k kVar = new k();
            kVar.cNb = bjVar;
            return kVar;
        } else if (e.Z(bjVar)) {
            return new e(bjVar);
        } else {
            if (f.aa(bjVar)) {
                return new f(bjVar);
            }
            if (k.Z(bjVar) || k.ab(bjVar)) {
                k kVar2 = new k();
                if (bjVar.isLinkThread()) {
                    kVar2.isLinkThread = true;
                } else if (bjVar.aAY()) {
                    kVar2.cNa = true;
                } else {
                    kVar2.isLinkThread = false;
                    if (bjVar.aAa()) {
                        kVar2.fKK = true;
                    } else {
                        kVar2.fKK = false;
                    }
                }
                kVar2.cNb = bjVar;
                kVar2.fKL = true;
                return kVar2;
            } else if (l.Z(bjVar)) {
                return new l(bjVar);
            } else {
                return null;
            }
        }
    }

    public static List<m> u(List<bj> list, List<m> list2) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            com.baidu.tieba.personPolymeric.c.k kVar = new com.baidu.tieba.personPolymeric.c.k();
            kVar.job = jpE;
            kVar.fMd = jpD;
            kVar.paddingLeft = dJZ;
            kVar.titleId = R.string.person_center_list_title_dynamic_txt;
            arrayList.add(kVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                m aS = aS(list.get(i2));
                if (aS != null) {
                    arrayList.add(aS);
                }
                i = i2 + 1;
            }
        }
        List<m> dW = dW(list2);
        if (!v.isEmpty(dW)) {
            com.baidu.tieba.personPolymeric.c.k kVar2 = new com.baidu.tieba.personPolymeric.c.k();
            kVar2.job = jpE;
            if (v.isEmpty(list)) {
                kVar2.fMd = jpD;
            } else {
                kVar2.fMd = jpF;
            }
            kVar2.paddingLeft = dJZ;
            kVar2.titleId = R.string.person_center_list_title_thread_txt;
            arrayList.add(kVar2);
            arrayList.addAll(dW);
        }
        return arrayList;
    }
}
