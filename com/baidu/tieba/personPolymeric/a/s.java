package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private List<com.baidu.adp.widget.ListView.a> bbV = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eoc;
    private r esU;
    private c esV;
    private k esW;
    private a esX;
    private e esY;
    private j esZ;
    private o eta;
    private g etb;
    private p etd;
    private f ete;
    private com.baidu.tieba.person.a.e etf;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.esU = new r(tbPageContext);
        this.esV = new c(tbPageContext);
        this.esW = new k(tbPageContext);
        this.esX = new a(tbPageContext);
        this.esY = new e(tbPageContext);
        this.esZ = new j(tbPageContext);
        this.eta = new o(tbPageContext);
        this.etb = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eug);
        this.etd = new p(tbPageContext);
        this.ete = new f(tbPageContext);
        this.etf = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.eod);
        this.eoc = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.epy);
        this.bbV.add(this.esU);
        this.bbV.add(this.esV);
        this.bbV.add(this.esW);
        this.bbV.add(this.esX);
        this.bbV.add(this.esY);
        this.bbV.add(this.esZ);
        this.bbV.add(this.eta);
        this.bbV.add(this.etb);
        this.bbV.add(this.etd);
        this.bbV.add(this.ete);
        this.bbV.add(this.etf);
        this.bbV.add(this.eoc);
        bdPersonListView.g(this.bbV);
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.etf != null) {
            this.etf.H(onClickListener);
        }
    }
}
