package com.baidu.tieba.person.god.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.bq;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.person.a.c<n, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private bq bUF;
    private by bUy;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUy = new e(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        this.bUF = new bq(this.DV);
        this.bUF.j(this.aOT);
        this.bUF.a(this.bUy);
        return new a(this.bUF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar != null) {
            nVar.fw(i + 1);
        }
        aVar.bUH.a(nVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bq bUH;

        public a(bq bqVar) {
            super(bqVar.getView());
            this.bUH = bqVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }
}
