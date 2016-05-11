package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.l, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> boU;
    private com.baidu.adp.lib.f.b<TbImageView> boV;
    private by boZ;
    private aq ebh;
    private com.baidu.tieba.recommendfrs.control.a.f ebi;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boZ = new g(this);
        this.boU = new com.baidu.adp.lib.f.b<>(new h(this), 6, 0);
        this.boV = new com.baidu.adp.lib.f.b<>(new i(this), 12, 0);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public a b(ViewGroup viewGroup) {
        this.ebh = new aq(this.DV);
        this.ebh.setConstrainLayoutPool(this.boU);
        this.ebh.setConstrainImagePool(this.boV);
        this.ebh.j(this.aOT);
        return new a(this.ebh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.l lVar, a aVar) {
        if (lVar != null) {
            lVar.fx(i + 1);
        }
        aVar.ebk.a(lVar);
        aVar.ebk.a(this.boZ);
        if (lVar.aRG != null && lVar.aRG.getTid() != null) {
            bx.Kg().a(new aw("c11003").ac("tid", lVar.aRG.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.ebh != null) {
            this.ebh.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public aq ebk;

        public a(aq aqVar) {
            super(aqVar.getView());
            this.ebk = aqVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.ebi = fVar;
    }
}
