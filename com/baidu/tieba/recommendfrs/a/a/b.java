package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.p;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<i, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private p dXJ;
    private cj<i> dXK;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dXK = new c(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public a b(ViewGroup viewGroup) {
        this.dXJ = new p(this.ND);
        this.dXJ.aSd = false;
        this.dXJ.j(this.aSu);
        return new a(this.dXJ);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        aVar.dXM.a(iVar);
        aVar.dXM.a(this.dXK);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public p dXM;

        public a(p pVar) {
            super(pVar.getView());
            this.dXM = pVar;
        }
    }
}
