package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.t, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private cj bTW;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> dYa;
    private com.baidu.adp.lib.f.b<TbImageView> dYb;
    private bd dYh;
    private com.baidu.tieba.recommendfrs.control.a.f dYi;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dYa = new com.baidu.adp.lib.f.b<>(new m(this), 6, 0);
        this.dYb = new com.baidu.adp.lib.f.b<>(new n(this), 12, 0);
        this.bTW = new o(this);
        this.ND = tbPageContext;
        aMA();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        this.dYh = new bd(this.ND);
        this.dYh.setConstrainLayoutPool(this.dYa);
        this.dYh.a(this.dYb);
        this.dYh.j(this.aSu);
        return new a(this.dYh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.t tVar, a aVar) {
        if (tVar != null) {
            tVar.fP(i + 1);
        }
        cf.Lx().a(tVar.LN());
        aVar.dYk.a(tVar);
        aVar.dYk.a(this.bTW);
        return aVar.getView();
    }

    private void aMA() {
        com.baidu.tieba.card.a.t.aVR = "c10705";
        com.baidu.tieba.card.a.t.aVS = "c10730";
        com.baidu.tieba.card.a.t.aVT = "c10731";
        com.baidu.tieba.card.a.t.aVU = "c10704";
        com.baidu.tieba.card.a.t.aVV = "c10755";
        com.baidu.tieba.card.a.t.aVW = "c10710";
        com.baidu.tieba.card.a.t.aVX = "c10736";
        com.baidu.tieba.card.a.t.aVY = "c10737";
        com.baidu.tieba.card.a.t.aVZ = "c10711";
        com.baidu.tieba.card.a.t.aWa = "c10758";
        com.baidu.tieba.card.a.t.aWb = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dYh != null) {
            this.dYh.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public bd dYk;

        public a(bd bdVar) {
            super(bdVar.getView());
            this.dYk = bdVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dYi = fVar;
    }
}
