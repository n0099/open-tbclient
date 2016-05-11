package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
import com.baidu.tieba.frs.fh;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.n, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private by bUy;
    private com.baidu.tieba.recommendfrs.control.a.f ebp;
    private com.baidu.tieba.card.z ebw;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUy = new s(this);
        this.DV = tbPageContext;
        aMK();
    }

    private void aMK() {
        com.baidu.tieba.card.a.n.aSg = "c10708";
        com.baidu.tieba.card.a.n.aSh = "c10735";
        com.baidu.tieba.card.a.n.aSi = "c10756";
        com.baidu.tieba.card.a.n.aSj = "c10709";
        com.baidu.tieba.card.a.n.aSk = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public a b(ViewGroup viewGroup) {
        this.ebw = new com.baidu.tieba.card.z(this.DV);
        this.ebw.j(this.aOT);
        this.ebw.a(this.bUy);
        return new a(this.ebw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.n nVar, a aVar) {
        if (nVar != null) {
            nVar.fx(i + 1);
        }
        aVar.eby.a(nVar);
        if (nVar != null) {
            bx.Kg().a(nVar.Kw());
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements fh {
        public com.baidu.tieba.card.z eby;

        public a(com.baidu.tieba.card.z zVar) {
            super(zVar.getView());
            this.eby = zVar;
        }

        @Override // com.baidu.tieba.frs.fh
        public void JZ() {
            this.eby.JZ();
        }

        @Override // com.baidu.tieba.frs.fh
        public void RG() {
            this.eby.ch(true);
        }

        @Override // com.baidu.tieba.frs.fh
        public void RH() {
            this.eby.ch(false);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.ebp = fVar;
    }
}
