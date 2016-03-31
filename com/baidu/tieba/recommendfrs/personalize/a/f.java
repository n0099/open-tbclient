package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ay;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.t, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private cj bKe;
    private ay dXY;
    private com.baidu.tieba.recommendfrs.control.a.f dXZ;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> dYa;
    private com.baidu.adp.lib.f.b<TbImageView> dYb;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKe = new g(this);
        this.dYa = new com.baidu.adp.lib.f.b<>(new h(this), 6, 0);
        this.dYb = new com.baidu.adp.lib.f.b<>(new i(this), 12, 0);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public a b(ViewGroup viewGroup) {
        this.dXY = new ay(this.ND);
        this.dXY.setConstrainLayoutPool(this.dYa);
        this.dXY.a(this.dYb);
        this.dXY.j(this.aSu);
        return new a(this.dXY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.t tVar, a aVar) {
        if (tVar != null) {
            tVar.fP(i + 1);
        }
        aVar.dYd.a(tVar);
        aVar.dYd.a(this.bKe);
        if (tVar.aVJ != null && tVar.aVJ.getTid() != null) {
            cf.Lx().a(new aw("c11003").ac("tid", tVar.aVJ.getTid()));
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.dXY != null) {
            this.dXY.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ay dYd;

        public a(ay ayVar) {
            super(ayVar.getView());
            this.dYd = ayVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dXZ = fVar;
    }
}
