package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.a.j;
import com.baidu.tieba.card.bb;
import com.baidu.tieba.card.o;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<j, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private bb<i> dFY;
    private o dGb;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dFY = new e(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public a b(ViewGroup viewGroup) {
        this.dGb = new o(this.Nw);
        this.dGb.i(this.aPF);
        return new a(this.dGb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, a aVar) {
        aVar.dGd.a(jVar);
        if (aVar.dGd.JP() != null) {
            aVar.dGd.JP().a(this.dFY);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public o dGd;

        public a(o oVar) {
            super(oVar.getView());
            this.dGd = oVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }
}
