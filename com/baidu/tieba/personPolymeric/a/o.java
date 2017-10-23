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
    private com.baidu.tieba.person.a.a eYY;
    private h feA;
    private j feB;
    private e feC;
    private l feD;
    private d feE;
    private com.baidu.tieba.person.a.d feF;
    private q feG;
    private k feH;
    private com.baidu.tieba.personPolymeric.b.b feI;
    private BdPersonListView feJ;
    private n fev;
    private b few;
    private i fex;
    private a fey;
    private c fez;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public o(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.feJ = bdPersonListView;
        this.fev = new n(tbPageContext);
        this.few = new b(tbPageContext);
        this.fex = new i(tbPageContext);
        this.fey = new a(tbPageContext);
        this.fez = new c(tbPageContext);
        this.feA = new h(tbPageContext, tbPageContext.getUniqueId());
        this.feB = new j(tbPageContext);
        this.feC = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fgL);
        this.feD = new l(tbPageContext);
        this.feE = new d(tbPageContext);
        this.feF = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.eYZ);
        this.eYY = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYJ);
        this.feG = new q(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.feH = new k(tbPageContext, com.baidu.tieba.personPolymeric.c.k.fgU);
        this.feI = new com.baidu.tieba.personPolymeric.b.j(tbPageContext, this, this.mBdUniqueId);
        this.feH.a(this.feI);
        this.mAdapters.add(this.feH);
        this.mAdapters.add(this.fev);
        this.mAdapters.add(this.few);
        this.mAdapters.add(this.fex);
        this.mAdapters.add(this.fey);
        this.mAdapters.add(this.fez);
        this.mAdapters.add(this.feA);
        this.mAdapters.add(this.feB);
        this.mAdapters.add(this.feC);
        this.mAdapters.add(this.feD);
        this.mAdapters.add(this.feE);
        this.mAdapters.add(this.feF);
        this.mAdapters.add(this.eYY);
        this.mAdapters.add(this.feG);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.feF != null) {
            this.feF.H(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.feG.setIsHost(z);
        this.fex.setIsHost(z);
    }

    public void ql(int i) {
        this.feI.setData(i);
    }

    public void cD(List<com.baidu.tieba.person.data.f> list) {
        this.feI.cD(list);
    }

    public void c(List<com.baidu.tieba.person.data.f> list, int i, boolean z) {
        ArrayList<com.baidu.adp.widget.ListView.f> aVg;
        com.baidu.adp.widget.ListView.f fVar;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) != null && (aVg = list.get(i2).aVg()) != null) {
                    if (v.u(aVg)) {
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.isHost = true;
                        aVg.add(iVar);
                    } else if (z) {
                        Iterator<com.baidu.adp.widget.ListView.f> it = aVg.iterator();
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
                            aVg.remove(fVar);
                        }
                    }
                }
            }
            if (list.get(i) != null && list.get(i).aVg() != null) {
                this.feJ.setData(list.get(i).aVg());
            }
        }
    }
}
