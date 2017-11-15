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
    private com.baidu.tieba.person.a.a fhL;
    private n fni;
    private b fnj;
    private i fnk;
    private a fnl;
    private c fnm;
    private h fnn;
    private j fno;
    private e fnp;
    private l fnq;
    private d fnr;
    private com.baidu.tieba.person.a.d fns;
    private q fnt;
    private k fnu;
    private com.baidu.tieba.personPolymeric.b.b fnv;
    private BdPersonListView fnw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public o(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fnw = bdPersonListView;
        this.fni = new n(tbPageContext);
        this.fnj = new b(tbPageContext);
        this.fnk = new i(tbPageContext);
        this.fnl = new a(tbPageContext);
        this.fnm = new c(tbPageContext);
        this.fnn = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fno = new j(tbPageContext);
        this.fnp = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fpH);
        this.fnq = new l(tbPageContext);
        this.fnr = new d(tbPageContext);
        this.fns = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fhM);
        this.fhL = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fhv);
        this.fnt = new q(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.fnu = new k(tbPageContext, com.baidu.tieba.personPolymeric.c.k.fpQ);
        this.fnv = new com.baidu.tieba.personPolymeric.b.j(tbPageContext, this, this.mBdUniqueId);
        this.fnu.a(this.fnv);
        this.mAdapters.add(this.fnu);
        this.mAdapters.add(this.fni);
        this.mAdapters.add(this.fnj);
        this.mAdapters.add(this.fnk);
        this.mAdapters.add(this.fnl);
        this.mAdapters.add(this.fnm);
        this.mAdapters.add(this.fnn);
        this.mAdapters.add(this.fno);
        this.mAdapters.add(this.fnp);
        this.mAdapters.add(this.fnq);
        this.mAdapters.add(this.fnr);
        this.mAdapters.add(this.fns);
        this.mAdapters.add(this.fhL);
        this.mAdapters.add(this.fnt);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.fns != null) {
            this.fns.I(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fnt.setIsHost(z);
        this.fnk.setIsHost(z);
    }

    public void qC(int i) {
        this.fnv.setData(i);
    }

    public void cF(List<com.baidu.tieba.person.data.f> list) {
        this.fnv.cF(list);
    }

    public void c(List<com.baidu.tieba.person.data.f> list, int i, boolean z) {
        ArrayList<com.baidu.adp.widget.ListView.f> aYr;
        com.baidu.adp.widget.ListView.f fVar;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) != null && (aYr = list.get(i2).aYr()) != null) {
                    if (v.v(aYr)) {
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.isHost = true;
                        aYr.add(iVar);
                    } else if (z) {
                        Iterator<com.baidu.adp.widget.ListView.f> it = aYr.iterator();
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
                            aYr.remove(fVar);
                        }
                    }
                }
            }
            if (list.get(i) != null && list.get(i).aYr() != null) {
                this.fnw.setData(list.get(i).aYr());
            }
        }
    }
}
