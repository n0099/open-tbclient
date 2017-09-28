package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.person.a.a eZm;
    private n feK;
    private b feL;
    private i feM;
    private a feN;
    private c feO;
    private h feP;
    private j feQ;
    private e feR;
    private l feS;
    private d feT;
    private com.baidu.tieba.person.a.d feU;
    private q feV;
    private k feW;
    private com.baidu.tieba.personPolymeric.b.b feX;
    private BdPersonListView feY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public o(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.feY = bdPersonListView;
        this.feK = new n(tbPageContext);
        this.feL = new b(tbPageContext);
        this.feM = new i(tbPageContext);
        this.feN = new a(tbPageContext);
        this.feO = new c(tbPageContext);
        this.feP = new h(tbPageContext, tbPageContext.getUniqueId());
        this.feQ = new j(tbPageContext);
        this.feR = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fha);
        this.feS = new l(tbPageContext);
        this.feT = new d(tbPageContext);
        this.feU = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.eZn);
        this.eZm = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYX);
        this.feV = new q(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.feW = new k(tbPageContext, com.baidu.tieba.personPolymeric.c.k.fhj);
        this.feX = new com.baidu.tieba.personPolymeric.b.j(tbPageContext, this, this.mBdUniqueId);
        this.feW.a(this.feX);
        this.mAdapters.add(this.feW);
        this.mAdapters.add(this.feK);
        this.mAdapters.add(this.feL);
        this.mAdapters.add(this.feM);
        this.mAdapters.add(this.feN);
        this.mAdapters.add(this.feO);
        this.mAdapters.add(this.feP);
        this.mAdapters.add(this.feQ);
        this.mAdapters.add(this.feR);
        this.mAdapters.add(this.feS);
        this.mAdapters.add(this.feT);
        this.mAdapters.add(this.feU);
        this.mAdapters.add(this.eZm);
        this.mAdapters.add(this.feV);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.feU != null) {
            this.feU.H(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.feV.setIsHost(z);
        this.feM.setIsHost(z);
    }

    public void qm(int i) {
        this.feX.setData(i);
    }

    public void cD(List<com.baidu.tieba.person.data.f> list) {
        this.feX.cD(list);
    }

    public void c(List<com.baidu.tieba.person.data.f> list, int i, boolean z) {
        ArrayList<com.baidu.adp.widget.ListView.f> aVl;
        com.baidu.adp.widget.ListView.f fVar;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) != null && (aVl = list.get(i2).aVl()) != null) {
                    if (v.u(aVl)) {
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.isHost = true;
                        aVl.add(iVar);
                    } else if (z) {
                        Iterator<com.baidu.adp.widget.ListView.f> it = aVl.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                fVar = null;
                                break;
                            }
                            fVar = it.next();
                            if (fVar instanceof com.baidu.tieba.personPolymeric.c.i) {
                                break;
                            }
                        }
                        if (fVar != null) {
                            aVl.remove(fVar);
                        }
                    }
                }
            }
            if (list.get(i) != null && list.get(i).aVl() != null) {
                this.feY.setData(list.get(i).aVl());
            }
        }
    }
}
