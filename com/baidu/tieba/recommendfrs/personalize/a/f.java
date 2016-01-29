package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.ax;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<q, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private bb bJA;
    private af bJz;
    private com.baidu.tieba.recommendfrs.control.a.f dGm;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJA = new g(this);
        this.Nw = tbPageContext;
        aFS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public a b(ViewGroup viewGroup) {
        this.bJz = new af(this.Nw);
        this.bJz.j(this.aPF);
        return new a(this.bJz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, q qVar, a aVar) {
        if (qVar != null) {
            qVar.fB(i + 1);
        }
        ax.Kc().a(qVar.Kt());
        aVar.bJC.a(qVar);
        aVar.bJC.a(this.bJA);
        return aVar.getView();
    }

    private void aFS() {
        q.aSi = "c10705";
        q.aSj = "c10730";
        q.aSk = "c10731";
        q.aSl = "c10704";
        q.aSm = "c10755";
        q.aSn = "c10710";
        q.aSo = "c10736";
        q.aSp = "c10737";
        q.aSq = "c10711";
        q.aSr = "c10758";
        q.aSs = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.bJz != null) {
            this.bJz.setFromCDN(z);
        }
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

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dGm = fVar;
    }
}
