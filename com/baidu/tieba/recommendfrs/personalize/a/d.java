package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.y;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<n, a> {
    private BdUniqueId dpv;
    private y dqj;
    private com.baidu.tieba.recommendfrs.control.a.f dqk;
    private aq dql;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dql = new e(this);
        this.mPageContext = tbPageContext;
        ayK();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public a a(ViewGroup viewGroup) {
        this.dqj = new y(this.mPageContext);
        this.dqj.j(this.dpv);
        this.dqj.a(this.dql);
        return new a(this.dqj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar != null) {
            nVar.fc(i + 1);
        }
        aVar.dqn.a(nVar);
        return aVar.getView();
    }

    private void ayK() {
        n.aQd = "c10705";
        n.aQe = "c10730";
        n.aQf = "c10731";
        n.aQg = "c10704";
        n.aQh = "c10755";
        n.aQi = "c10710";
        n.aQj = "c10736";
        n.aQk = "c10737";
        n.aQl = "c10711";
        n.aQm = "c10758";
        n.aQn = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.dqj != null) {
            this.dqj.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public y dqn;

        public a(y yVar) {
            super(yVar.getView());
            this.dqn = yVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dpv = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dqk = fVar;
    }
}
