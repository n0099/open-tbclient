package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private TbPageContext<?> ND;
    private BdTypeListView dUY;
    private List<com.baidu.adp.widget.ListView.a> dYN = new ArrayList();
    private c dYO;
    private b dYP;
    private t dYQ;
    private ac dYR;
    private a dYS;
    private l dYT;
    private r dYU;
    private f dYV;
    private j dYW;
    private p dYX;
    private d dYY;
    private com.baidu.tieba.recommendfrs.a.a.b dYZ;
    private com.baidu.tieba.recommendfrs.a.a.d dZa;

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.dUY = bdTypeListView;
        this.ND = (TbPageContext) com.baidu.adp.base.l.s(context);
        aI(context);
        bdTypeListView.g(this.dYN);
    }

    private void aI(Context context) {
        this.dYO = new c(this.ND);
        this.dYP = new b(this.ND);
        this.dYQ = new t(this.ND);
        this.dYR = new ac(this.ND);
        this.dYS = new a(this.ND);
        this.dYT = new l(this.ND, com.baidu.tieba.card.a.t.TC);
        this.dYU = new r(this.ND, com.baidu.tieba.card.a.v.aWk);
        this.dYY = new d(this.ND, com.baidu.tieba.card.a.u.TC);
        this.dYV = new f(this.ND, com.baidu.tieba.card.a.t.aWc);
        this.dYW = new j(this.ND, com.baidu.tieba.card.a.v.aWl);
        this.dYZ = new com.baidu.tieba.recommendfrs.a.a.b(this.ND, com.baidu.tieba.card.a.i.TC);
        this.dZa = new com.baidu.tieba.recommendfrs.a.a.d(this.ND, com.baidu.tieba.card.a.j.TC);
        this.dYX = new p(this.ND);
        this.dYN.add(this.dYO);
        this.dYN.add(this.dYP);
        this.dYN.add(this.dYQ);
        this.dYN.add(this.dYR);
        this.dYN.add(this.dYS);
        this.dYN.add(this.dYU);
        this.dYN.add(this.dYT);
        this.dYN.add(this.dYY);
        this.dYN.add(new com.baidu.tieba.recommendfrs.a.a.a(this.ND.getPageActivity(), com.baidu.tieba.recommendfrs.data.g.dWI));
        this.dYN.add(this.dYZ);
        this.dYN.add(this.dZa);
        this.dYN.add(this.dYV);
        this.dYN.add(this.dYW);
        this.dYN.add(new y(this.ND.getPageActivity()));
        this.dYN.add(new v(this.ND.getPageActivity()));
        this.dYN.add(this.dYX);
    }

    public void b(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dYT.a(fVar);
        this.dYU.a(fVar);
        this.dYV.a(fVar);
        this.dYW.a(fVar);
    }

    public void cm(List<com.baidu.adp.widget.ListView.u> list) {
        this.dUY.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dYO.onChangeSkinType(i);
        this.dYP.onChangeSkinType(i);
        this.dYX.oF(i);
    }

    public void notifyDataSetChanged() {
        if (this.dUY != null && (this.dUY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.dUY.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dYT != null) {
            this.dYT.setFromCDN(z);
        }
        if (this.dYV != null) {
            this.dYV.setFromCDN(z);
        }
        if (this.dYS != null) {
            this.dYS.setFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dYZ != null) {
            this.dYZ.setPageUniqueId(bdUniqueId);
        }
        if (this.dZa != null) {
            this.dZa.setPageUniqueId(bdUniqueId);
        }
        if (this.dYT != null) {
            this.dYT.setPageUniqueId(bdUniqueId);
        }
        if (this.dYU != null) {
            this.dYU.setPageUniqueId(bdUniqueId);
        }
        if (this.dYY != null) {
            this.dYY.setPageUniqueId(bdUniqueId);
        }
        if (this.dYO != null) {
            this.dYO.setPageUniqueId(bdUniqueId);
        }
        if (this.dYP != null) {
            this.dYP.setPageUniqueId(bdUniqueId);
        }
        if (this.dYV != null) {
            this.dYV.setPageUniqueId(bdUniqueId);
        }
        if (this.dYW != null) {
            this.dYW.setPageUniqueId(bdUniqueId);
        }
        if (this.dYX != null) {
            this.dYX.setPageUniqueId(bdUniqueId);
        }
    }
}
