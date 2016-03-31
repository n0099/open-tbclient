package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.v, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private cj bKe;
    private com.baidu.tieba.recommendfrs.control.a.f dXZ;
    private au dYe;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKe = new k(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        this.dYe = new au(this.ND);
        this.dYe.j(this.aSu);
        return new a(this.dYe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.v vVar, a aVar) {
        if (vVar != null) {
            vVar.fP(i + 1);
        }
        aVar.dYg.a(vVar);
        aVar.dYg.a(this.bKe);
        if (vVar.aWf != null && vVar.aWf.getTid() != null) {
            cf.Lx().a(new aw("c11003").ac("tid", vVar.aWf.getTid()));
        }
        return aVar.getView();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }

    /* loaded from: classes.dex */
    public static class a extends x.a {
        public au dYg;

        public a(au auVar) {
            super(auVar.getView());
            this.dYg = auVar;
        }
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dXZ = fVar;
    }
}
