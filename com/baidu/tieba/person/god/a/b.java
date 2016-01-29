package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.person.a.c<q, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private bb bJA;
    private af bJz;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJA = new c(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public a b(ViewGroup viewGroup) {
        this.bJz = new af(this.Nw);
        this.bJz.j(this.aPF);
        this.bJz.a(this.bJA);
        return new a(this.bJz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, q qVar, a aVar) {
        if (qVar != null) {
            qVar.fB(i + 1);
        }
        aVar.bJC.a(qVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public af bJC;

        public a(af afVar) {
            super(afVar.getView());
            this.bJC = afVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }
}
