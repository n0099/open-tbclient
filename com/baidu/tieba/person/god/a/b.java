package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.bc;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.a.a<m, a> {
    private TbPageContext<?> Ea;
    private BdUniqueId aSq;
    private bx crx;
    private bc cyy;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.crx = new c(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public a a(ViewGroup viewGroup) {
        this.cyy = new bc(this.Ea);
        this.cyy.j(this.aSq);
        this.cyy.a(this.crx);
        return new a(this.cyy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, a aVar) {
        if (mVar != null) {
            mVar.fI(i + 1);
        }
        aVar.cyA.a(mVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bc cyA;

        public a(bc bcVar) {
            super(bcVar.getView());
            this.cyA = bcVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
    }
}
