package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.v, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private cj bTW;
    private com.baidu.tieba.recommendfrs.control.a.f dYi;
    private al dYp;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bTW = new s(this);
        this.ND = tbPageContext;
        aMA();
    }

    private void aMA() {
        com.baidu.tieba.card.a.v.aWm = "c10708";
        com.baidu.tieba.card.a.v.aWn = "c10735";
        com.baidu.tieba.card.a.v.aWo = "c10756";
        com.baidu.tieba.card.a.v.aWp = "c10709";
        com.baidu.tieba.card.a.v.aWq = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public a b(ViewGroup viewGroup) {
        this.dYp = new al(this.ND);
        this.dYp.j(this.aSu);
        this.dYp.a(this.bTW);
        return new a(this.dYp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.v vVar, a aVar) {
        if (vVar != null) {
            vVar.fP(i + 1);
        }
        aVar.dYr.a(vVar);
        if (vVar != null) {
            cf.Lx().a(vVar.LN());
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends x.a {
        public al dYr;

        public a(al alVar) {
            super(alVar.getView());
            this.dYr = alVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dYi = fVar;
    }
}
