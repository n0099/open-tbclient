package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.l, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private by bUy;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> boU;
    private com.baidu.adp.lib.f.b<TbImageView> boV;
    private av ebo;
    private com.baidu.tieba.recommendfrs.control.a.f ebp;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boU = new com.baidu.adp.lib.f.b<>(new m(this), 6, 0);
        this.boV = new com.baidu.adp.lib.f.b<>(new n(this), 12, 0);
        this.bUy = new o(this);
        this.DV = tbPageContext;
        aMK();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public a b(ViewGroup viewGroup) {
        this.ebo = new av(this.DV);
        this.ebo.setConstrainLayoutPool(this.boU);
        this.ebo.setConstrainImagePool(this.boV);
        this.ebo.j(this.aOT);
        return new a(this.ebo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.l lVar, a aVar) {
        if (lVar != null) {
            lVar.fx(i + 1);
        }
        bx.Kg().a(lVar.Kw());
        aVar.ebr.a(lVar);
        aVar.ebr.a(this.bUy);
        return aVar.getView();
    }

    private void aMK() {
        com.baidu.tieba.card.a.l.aRL = "c10705";
        com.baidu.tieba.card.a.l.aRM = "c10730";
        com.baidu.tieba.card.a.l.aRN = "c10731";
        com.baidu.tieba.card.a.l.aRO = "c10704";
        com.baidu.tieba.card.a.l.aRP = "c10755";
        com.baidu.tieba.card.a.l.aRQ = "c10710";
        com.baidu.tieba.card.a.l.aRR = "c10736";
        com.baidu.tieba.card.a.l.aRS = "c10737";
        com.baidu.tieba.card.a.l.aRT = "c10711";
        com.baidu.tieba.card.a.l.aRU = "c10758";
        com.baidu.tieba.card.a.l.aRV = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.ebo != null) {
            this.ebo.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public av ebr;

        public a(av avVar) {
            super(avVar.getView());
            this.ebr = avVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.ebp = fVar;
    }
}
