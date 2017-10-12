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
    private n feJ;
    private b feK;
    private i feL;
    private a feM;
    private c feN;
    private h feO;
    private j feP;
    private e feQ;
    private l feR;
    private d feS;
    private com.baidu.tieba.person.a.d feT;
    private q feU;
    private k feV;
    private com.baidu.tieba.personPolymeric.b.b feW;
    private BdPersonListView feX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public o(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.feX = bdPersonListView;
        this.feJ = new n(tbPageContext);
        this.feK = new b(tbPageContext);
        this.feL = new i(tbPageContext);
        this.feM = new a(tbPageContext);
        this.feN = new c(tbPageContext);
        this.feO = new h(tbPageContext, tbPageContext.getUniqueId());
        this.feP = new j(tbPageContext);
        this.feQ = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fgZ);
        this.feR = new l(tbPageContext);
        this.feS = new d(tbPageContext);
        this.feT = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.eZn);
        this.eZm = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYX);
        this.feU = new q(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.feV = new k(tbPageContext, com.baidu.tieba.personPolymeric.c.k.fhi);
        this.feW = new com.baidu.tieba.personPolymeric.b.j(tbPageContext, this, this.mBdUniqueId);
        this.feV.a(this.feW);
        this.mAdapters.add(this.feV);
        this.mAdapters.add(this.feJ);
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
        this.mAdapters.add(this.eZm);
        this.mAdapters.add(this.feU);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.feT != null) {
            this.feT.H(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.feU.setIsHost(z);
        this.feL.setIsHost(z);
    }

    public void qm(int i) {
        this.feW.setData(i);
    }

    public void cD(List<com.baidu.tieba.person.data.f> list) {
        this.feW.cD(list);
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
                this.feX.setData(list.get(i).aVl());
            }
        }
    }
}
