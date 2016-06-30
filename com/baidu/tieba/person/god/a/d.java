package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.bp;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.a.a<o, a> {
    private TbPageContext<?> Ea;
    private BdUniqueId aSq;
    private bx crx;
    private bp cyD;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.crx = new e(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public a a(ViewGroup viewGroup) {
        this.cyD = new bp(this.Ea);
        this.cyD.j(this.aSq);
        this.cyD.a(this.crx);
        return new a(this.cyD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, a aVar) {
        if (oVar != null) {
            oVar.fI(i + 1);
        }
        aVar.cyF.a(oVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bp cyF;

        public a(bp bpVar) {
            super(bpVar.getView());
            this.cyF = bpVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
    }
}
