package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.t;
import com.baidu.tieba.card.bl;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.person.a.c<t, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private bl bTV;
    private cj bTW;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bTW = new c(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public a b(ViewGroup viewGroup) {
        this.bTV = new bl(this.ND);
        this.bTV.j(this.aSu);
        this.bTV.a(this.bTW);
        return new a(this.bTV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, t tVar, a aVar) {
        if (tVar != null) {
            tVar.fP(i + 1);
        }
        aVar.bTY.a(tVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public bl bTY;

        public a(bl blVar) {
            super(blVar.getView());
            this.bTY = blVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }
}
