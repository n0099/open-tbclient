package com.baidu.tieba.person.a;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aVK = new ArrayList();
    com.baidu.tieba.personInfo.d cQj;
    private BdPersonListView cQk;
    public v cQl;
    public f cQm;
    public r cQn;
    public af cQo;
    public i cQp;
    public aa cQq;
    public t cQr;
    public ac cQs;
    public ad cQt;
    public q cQu;
    public g cQv;
    public d cQw;
    public o cQx;
    public m cQy;
    BaseFragmentActivity mActivity;

    public b(com.baidu.tieba.personInfo.d dVar, BdPersonListView bdPersonListView) {
        this.cQj = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        a(this.mActivity, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.cQl = new v(baseFragmentActivity, com.baidu.tieba.person.data.m.cSg);
        this.cQm = new f(this.cQj, com.baidu.tieba.person.data.c.cRQ);
        this.cQn = new r(baseFragmentActivity, com.baidu.tieba.person.data.j.cSc);
        this.cQq = new aa(baseFragmentActivity, com.baidu.tieba.person.data.n.cSi);
        this.cQr = new t(baseFragmentActivity, com.baidu.tieba.person.data.k.cSe);
        this.cQs = new ac(baseFragmentActivity, com.baidu.tieba.person.data.o.cSj);
        this.cQo = new af(baseFragmentActivity, com.baidu.tieba.person.data.l.cSf);
        this.cQu = new q(baseFragmentActivity, com.baidu.tieba.person.data.i.cSb);
        this.cQp = new i(baseFragmentActivity, com.baidu.tieba.person.data.f.cRW);
        this.cQt = new ad(baseFragmentActivity, ae.cRq);
        this.cQw = new d(baseFragmentActivity, com.baidu.tieba.person.data.b.cRO);
        this.cQv = new g(baseFragmentActivity, com.baidu.tieba.person.data.e.cRU);
        this.cQx = new o(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.h.cSa);
        this.cQy = new m(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.g.cRZ);
        this.aVK.add(this.cQl);
        this.aVK.add(this.cQm);
        this.aVK.add(this.cQq);
        this.aVK.add(this.cQr);
        this.aVK.add(this.cQo);
        this.aVK.add(this.cQu);
        this.aVK.add(this.cQn);
        this.aVK.add(this.cQp);
        this.aVK.add(this.cQs);
        this.aVK.add(this.cQt);
        this.aVK.add(this.cQw);
        this.aVK.add(this.cQv);
        this.aVK.add(this.cQx);
        this.aVK.add(this.cQy);
        this.cQk = bdPersonListView;
        this.cQk.g(this.aVK);
    }

    public void Z(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList != null) {
            if (arrayList != null && arrayList.size() == 0) {
                arrayList.add(this.cQj.apO().aqD());
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.u next = it.next();
                    if (next instanceof com.baidu.tieba.person.data.a) {
                        com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                        if (!aVar.cRN && !z) {
                            aVar.cRM = false;
                        } else {
                            aVar.cRM = true;
                        }
                        z = aVar.cRN;
                    } else {
                        z = true;
                    }
                }
            }
            if (com.baidu.tbadk.core.util.y.l(this.aVK) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.aVK) {
                    if (aVar2 instanceof c) {
                        ((c) aVar2).aVr = true;
                    }
                }
            }
            if (this.cQk != null) {
                this.cQk.setData(arrayList);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.cQk.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.cQk.getAdapter()).notifyDataSetChanged();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cQp.b(vVar);
    }
}
