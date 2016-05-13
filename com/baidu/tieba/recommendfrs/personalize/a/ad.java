package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private TbPageContext<?> DV;
    private BdTypeListView dXQ;
    private List<com.baidu.adp.widget.ListView.a> ebU = new ArrayList();
    private c ebV;
    private b ebW;
    private t ebX;
    private ac ebY;
    private a ebZ;
    private l eca;
    private r ecb;
    private f ecc;
    private j ecd;
    private p ece;
    private d ecf;
    private com.baidu.tieba.recommendfrs.a.a.b ecg;
    private com.baidu.tieba.recommendfrs.a.a.d ech;

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.dXQ = bdTypeListView;
        this.DV = (TbPageContext) com.baidu.adp.base.l.s(context);
        aO(context);
        bdTypeListView.g(this.ebU);
    }

    private void aO(Context context) {
        this.ebV = new c(this.DV);
        this.ebW = new b(this.DV);
        this.ebX = new t(this.DV);
        this.ebY = new ac(this.DV);
        this.ebZ = new a(this.DV);
        this.eca = new l(this.DV, com.baidu.tieba.card.a.l.Oq);
        this.ecb = new r(this.DV, com.baidu.tieba.card.a.n.aSe);
        this.ecf = new d(this.DV, com.baidu.tieba.card.a.m.Oq);
        this.ecc = new f(this.DV, com.baidu.tieba.card.a.l.aRW);
        this.ecd = new j(this.DV, com.baidu.tieba.card.a.n.aSf);
        this.ecg = new com.baidu.tieba.recommendfrs.a.a.b(this.DV, com.baidu.tieba.card.a.f.Oq);
        this.ech = new com.baidu.tieba.recommendfrs.a.a.d(this.DV, com.baidu.tieba.card.a.g.Oq);
        this.ece = new p(this.DV);
        this.ebU.add(this.ebV);
        this.ebU.add(this.ebW);
        this.ebU.add(this.ebX);
        this.ebU.add(this.ebY);
        this.ebU.add(this.ebZ);
        this.ebU.add(this.ecb);
        this.ebU.add(this.eca);
        this.ebU.add(this.ecf);
        this.ebU.add(new com.baidu.tieba.recommendfrs.a.a.a(this.DV.getPageActivity(), com.baidu.tieba.recommendfrs.data.g.dZS));
        this.ebU.add(this.ecg);
        this.ebU.add(this.ech);
        this.ebU.add(this.ecc);
        this.ebU.add(this.ecd);
        this.ebU.add(new y(this.DV.getPageActivity()));
        this.ebU.add(new v(this.DV.getPageActivity()));
        this.ebU.add(this.ece);
    }

    public void b(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.eca.a(fVar);
        this.ecb.a(fVar);
        this.ecc.a(fVar);
        this.ecd.a(fVar);
    }

    public void co(List<com.baidu.adp.widget.ListView.v> list) {
        this.dXQ.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ebV.onChangeSkinType(i);
        this.ebW.onChangeSkinType(i);
        this.ece.oy(i);
    }

    public void notifyDataSetChanged() {
        if (this.dXQ != null && (this.dXQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.dXQ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.eca != null) {
            this.eca.setFromCDN(z);
        }
        if (this.ecc != null) {
            this.ecc.setFromCDN(z);
        }
        if (this.ebZ != null) {
            this.ebZ.setFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ecg != null) {
            this.ecg.aOT = bdUniqueId;
        }
        if (this.ech != null) {
            this.ech.aOT = bdUniqueId;
        }
        if (this.eca != null) {
            this.eca.aOT = bdUniqueId;
        }
        if (this.ecb != null) {
            this.ecb.aOT = bdUniqueId;
        }
        if (this.ecf != null) {
            this.ecf.aOT = bdUniqueId;
        }
        if (this.ebV != null) {
            this.ebV.setPageUniqueId(bdUniqueId);
        }
        if (this.ebW != null) {
            this.ebW.setPageUniqueId(bdUniqueId);
        }
        if (this.ecc != null) {
            this.ecc.aOT = bdUniqueId;
        }
        if (this.ecd != null) {
            this.ecd.aOT = bdUniqueId;
        }
        if (this.ece != null) {
            this.ece.aOT = bdUniqueId;
        }
    }
}
