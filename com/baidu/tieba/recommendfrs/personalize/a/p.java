package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.q, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private af dYl;
    private cj<com.baidu.tieba.card.a.q> dYm;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.q.TC);
        this.dYm = new q(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a b(ViewGroup viewGroup) {
        this.dYl = new af(this.ND, this.aSu);
        return new a(this.dYl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.q qVar, a aVar) {
        this.dYl = aVar.dYo;
        aVar.dYo.d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        aVar.dYo.a(qVar);
        aVar.dYo.a(this.dYm);
        cf.Lx().a(new aw("c11006"));
        return aVar.getView();
    }

    public void oF(int i) {
        if (this.dYl != null) {
            this.dYl.d(this.ND, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public af dYo;

        public a(af afVar) {
            super(afVar.getView());
            this.dYo = afVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }
}
