package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.v;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.person.a.c<v, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private cj bTW;
    private by bUd;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bTW = new e(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public a b(ViewGroup viewGroup) {
        this.bUd = new by(this.ND);
        this.bUd.j(this.aSu);
        this.bUd.a(this.bTW);
        return new a(this.bUd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, v vVar, a aVar) {
        if (vVar != null) {
            vVar.fP(i + 1);
        }
        aVar.bUf.a(vVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public by bUf;

        public a(by byVar) {
            super(byVar.getView());
            this.bUf = byVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }
}
