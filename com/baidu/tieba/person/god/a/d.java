package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.s;
import com.baidu.tieba.card.ar;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.person.a.c<s, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private bb bJA;
    private ar bJH;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJA = new e(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a b(ViewGroup viewGroup) {
        this.bJH = new ar(this.Nw);
        this.bJH.j(this.aPF);
        this.bJH.a(this.bJA);
        return new a(this.bJH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        if (sVar != null) {
            sVar.fB(i + 1);
        }
        aVar.bJJ.a(sVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ar bJJ;

        public a(ar arVar) {
            super(arVar.getView());
            this.bJJ = arVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }
}
