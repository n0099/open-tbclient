package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.a.j;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.o;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<j, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private cj<i> dXK;
    private o dXN;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dXK = new e(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public a b(ViewGroup viewGroup) {
        this.dXN = new o(this.ND);
        this.dXN.i(this.aSu);
        return new a(this.dXN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, a aVar) {
        aVar.dXP.a(jVar);
        if (aVar.dXP.Lh() != null) {
            aVar.dXP.Lh().a(this.dXK);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public o dXP;

        public a(o oVar) {
            super(oVar.getView());
            this.dXP = oVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }
}
