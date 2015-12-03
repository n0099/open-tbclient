package com.baidu.tieba.person.a;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aRI = new ArrayList();
    com.baidu.tieba.personInfo.d cLT;
    private BdPersonListView cLU;
    public r cLV;
    public f cLW;
    public n cLX;
    public ab cLY;
    public i cLZ;
    public w cMa;
    public p cMb;
    public y cMc;
    public z cMd;
    public m cMe;
    public g cMf;
    public d cMg;
    BaseFragmentActivity mActivity;

    public b(com.baidu.tieba.personInfo.d dVar, BdPersonListView bdPersonListView) {
        this.cLT = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        a(this.mActivity, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.cLV = new r(baseFragmentActivity, com.baidu.tieba.person.data.k.cNA);
        this.cLW = new f(this.cLT, com.baidu.tieba.person.data.c.cNm);
        this.cLX = new n(baseFragmentActivity, com.baidu.tieba.person.data.h.cNw);
        this.cMa = new w(baseFragmentActivity, com.baidu.tieba.person.data.l.cNC);
        this.cMb = new p(baseFragmentActivity, com.baidu.tieba.person.data.i.cNy);
        this.cMc = new y(baseFragmentActivity, com.baidu.tieba.person.data.m.cND);
        this.cLY = new ab(baseFragmentActivity, com.baidu.tieba.person.data.j.cNz);
        this.cMe = new m(baseFragmentActivity, com.baidu.tieba.person.data.g.cNv);
        this.cLZ = new i(baseFragmentActivity, com.baidu.tieba.person.data.f.cNs);
        this.cMd = new z(baseFragmentActivity, aa.cMM);
        this.cMg = new d(baseFragmentActivity, com.baidu.tieba.person.data.b.cNk);
        this.cMf = new g(baseFragmentActivity, com.baidu.tieba.person.data.e.cNq);
        this.aRI.add(this.cLV);
        this.aRI.add(this.cLW);
        this.aRI.add(this.cMa);
        this.aRI.add(this.cMb);
        this.aRI.add(this.cLY);
        this.aRI.add(this.cMe);
        this.aRI.add(this.cLX);
        this.aRI.add(this.cLZ);
        this.aRI.add(this.cMc);
        this.aRI.add(this.cMd);
        this.aRI.add(this.cMg);
        this.aRI.add(this.cMf);
        this.cLU = bdPersonListView;
        this.cLU.g(this.aRI);
    }

    public void J(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList != null) {
            if (arrayList != null && arrayList.size() == 0) {
                arrayList.add(this.cLT.aoE().apo());
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.u next = it.next();
                    if (next instanceof com.baidu.tieba.person.data.a) {
                        com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                        if (!aVar.cNj && !z) {
                            aVar.cNi = false;
                        } else {
                            aVar.cNi = true;
                        }
                        z = aVar.cNj;
                    } else {
                        z = true;
                    }
                }
            }
            if (com.baidu.tbadk.core.util.y.k(this.aRI) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.aRI) {
                    if (aVar2 instanceof c) {
                        ((c) aVar2).aRB = true;
                    }
                }
            }
            if (this.cLU != null) {
                this.cLU.setData(arrayList);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.cLU.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.cLU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cLZ.b(vVar);
    }
}
