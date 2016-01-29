package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.bb;
import com.baidu.tieba.card.p;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<i, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private p dFX;
    private bb<i> dFY;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dFY = new c(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a b(ViewGroup viewGroup) {
        this.dFX = new p(this.Nw);
        this.dFX.aPn = false;
        this.dFX.j(this.aPF);
        return new a(this.dFX);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, a aVar) {
        aVar.dGa.a(iVar);
        aVar.dGa.a(this.dFY);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public p dGa;

        public a(p pVar) {
            super(pVar.getView());
            this.dGa = pVar;
        }
    }
}
