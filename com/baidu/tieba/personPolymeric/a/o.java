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
    private com.baidu.tieba.person.a.a fhp;
    private n fmL;
    private b fmM;
    private i fmN;
    private a fmO;
    private c fmP;
    private h fmQ;
    private j fmR;
    private e fmS;
    private l fmT;
    private d fmU;
    private com.baidu.tieba.person.a.d fmV;
    private q fmW;
    private k fmX;
    private com.baidu.tieba.personPolymeric.b.b fmY;
    private BdPersonListView fmZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public o(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fmZ = bdPersonListView;
        this.fmL = new n(tbPageContext);
        this.fmM = new b(tbPageContext);
        this.fmN = new i(tbPageContext);
        this.fmO = new a(tbPageContext);
        this.fmP = new c(tbPageContext);
        this.fmQ = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fmR = new j(tbPageContext);
        this.fmS = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fpj);
        this.fmT = new l(tbPageContext);
        this.fmU = new d(tbPageContext);
        this.fmV = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fhq);
        this.fhp = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fgZ);
        this.fmW = new q(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.fmX = new k(tbPageContext, com.baidu.tieba.personPolymeric.c.k.fpt);
        this.fmY = new com.baidu.tieba.personPolymeric.b.j(tbPageContext, this, this.mBdUniqueId);
        this.fmX.a(this.fmY);
        this.mAdapters.add(this.fmX);
        this.mAdapters.add(this.fmL);
        this.mAdapters.add(this.fmM);
        this.mAdapters.add(this.fmN);
        this.mAdapters.add(this.fmO);
        this.mAdapters.add(this.fmP);
        this.mAdapters.add(this.fmQ);
        this.mAdapters.add(this.fmR);
        this.mAdapters.add(this.fmS);
        this.mAdapters.add(this.fmT);
        this.mAdapters.add(this.fmU);
        this.mAdapters.add(this.fmV);
        this.mAdapters.add(this.fhp);
        this.mAdapters.add(this.fmW);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.fmV != null) {
            this.fmV.I(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fmW.setIsHost(z);
        this.fmN.setIsHost(z);
    }

    public void qB(int i) {
        this.fmY.setData(i);
    }

    public void cE(List<com.baidu.tieba.person.data.f> list) {
        this.fmY.cE(list);
    }

    public void c(List<com.baidu.tieba.person.data.f> list, int i, boolean z) {
        ArrayList<com.baidu.adp.widget.ListView.f> aYj;
        com.baidu.adp.widget.ListView.f fVar;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) != null && (aYj = list.get(i2).aYj()) != null) {
                    if (v.v(aYj)) {
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.isHost = true;
                        aYj.add(iVar);
                    } else if (z) {
                        Iterator<com.baidu.adp.widget.ListView.f> it = aYj.iterator();
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
                            aYj.remove(fVar);
                        }
                    }
                }
            }
            if (list.get(i) != null && list.get(i).aYj() != null) {
                this.fmZ.setData(list.get(i).aYj());
            }
        }
    }
}
