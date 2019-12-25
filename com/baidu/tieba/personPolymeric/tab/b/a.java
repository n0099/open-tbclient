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
/* loaded from: classes8.dex */
public class a {
    private static final int dJS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    private static final int jlV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
    private static final int jlW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds39);
    private static final int jlX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds106);

    public static List<m> dW(List<m> list) {
        bj bjVar;
        m aR;
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
            if ((mVar instanceof CardPersonDynamicThreadData) && (bjVar = ((CardPersonDynamicThreadData) mVar).cMR) != null && (aR = aR(bjVar)) != null) {
                arrayList.add(aR);
            }
            i = i2 + 1;
        }
    }

    public static List<m> dX(List<bj> list) {
        m aR;
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
            if (bjVar != null && (aR = aR(bjVar)) != null) {
                arrayList.add(aR);
            }
            i = i2 + 1;
        }
    }

    public static bj i(m mVar) {
        if (mVar == null) {
            return null;
        }
        if (mVar instanceof e) {
            return ((e) mVar).cMR;
        }
        if (mVar instanceof f) {
            return ((f) mVar).cMR;
        }
        if (mVar instanceof k) {
            return ((k) mVar).cMR;
        }
        if (mVar instanceof l) {
            return ((l) mVar).cMR;
        }
        return null;
    }

    public static m aR(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.isShareThread) {
            k kVar = new k();
            kVar.cMR = bjVar;
            return kVar;
        } else if (e.Y(bjVar)) {
            return new e(bjVar);
        } else {
            if (f.Z(bjVar)) {
                return new f(bjVar);
            }
            if (k.Y(bjVar) || k.aa(bjVar)) {
                k kVar2 = new k();
                if (bjVar.isLinkThread()) {
                    kVar2.isLinkThread = true;
                } else if (bjVar.aAF()) {
                    kVar2.cMQ = true;
                } else {
                    kVar2.isLinkThread = false;
                    if (bjVar.azH()) {
                        kVar2.fHA = true;
                    } else {
                        kVar2.fHA = false;
                    }
                }
                kVar2.cMR = bjVar;
                kVar2.fHB = true;
                return kVar2;
            } else if (l.Y(bjVar)) {
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
            kVar.jku = jlW;
            kVar.fIT = jlV;
            kVar.paddingLeft = dJS;
            kVar.titleId = R.string.person_center_list_title_dynamic_txt;
            arrayList.add(kVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                m aR = aR(list.get(i2));
                if (aR != null) {
                    arrayList.add(aR);
                }
                i = i2 + 1;
            }
        }
        List<m> dW = dW(list2);
        if (!v.isEmpty(dW)) {
            com.baidu.tieba.personPolymeric.c.k kVar2 = new com.baidu.tieba.personPolymeric.c.k();
            kVar2.jku = jlW;
            if (v.isEmpty(list)) {
                kVar2.fIT = jlV;
            } else {
                kVar2.fIT = jlX;
            }
            kVar2.paddingLeft = dJS;
            kVar2.titleId = R.string.person_center_list_title_thread_txt;
            arrayList.add(kVar2);
            arrayList.addAll(dW);
        }
        return arrayList;
    }
}
