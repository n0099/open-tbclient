package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.am;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
import com.baidu.tieba.frs.fh;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.n, a> {
    private TbPageContext<?> DV;
    public BdUniqueId aOT;
    private by boZ;
    private com.baidu.tieba.recommendfrs.control.a.f ebi;
    private am ebl;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boZ = new k(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public a b(ViewGroup viewGroup) {
        this.ebl = new am(this.DV);
        this.ebl.j(this.aOT);
        return new a(this.ebl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.n nVar, a aVar) {
        if (nVar != null) {
            nVar.fw(i + 1);
        }
        aVar.ebn.a(nVar);
        aVar.ebn.a(this.boZ);
        if (nVar.aRZ != null && nVar.aRZ.getTid() != null) {
            bx.Ki().a(new aw("c11003").ac("tid", nVar.aRZ.getTid()));
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements fh {
        public am ebn;

        public a(am amVar) {
            super(amVar.getView());
            this.ebn = amVar;
        }

        @Override // com.baidu.tieba.frs.fh
        public void Kb() {
            this.ebn.Kb();
        }

        @Override // com.baidu.tieba.frs.fh
        public void RG() {
            this.ebn.ch(true);
        }

        @Override // com.baidu.tieba.frs.fh
        public void RH() {
            this.ebn.ch(false);
        }
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.ebi = fVar;
    }
}
