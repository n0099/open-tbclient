package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.ah;
import com.baidu.tieba.card.aq;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<p, a> {
    private BdUniqueId dpv;
    private com.baidu.tieba.recommendfrs.control.a.f dqk;
    private aq dql;
    private ah dqo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dql = new g(this);
        this.mPageContext = tbPageContext;
        ayK();
    }

    private void ayK() {
        p.aQv = "c10708";
        p.aQw = "c10735";
        p.aQx = "c10756";
        p.aQy = "c10709";
        p.aQz = "c1034";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public a a(ViewGroup viewGroup) {
        this.dqo = new ah(this.mPageContext);
        this.dqo.j(this.dpv);
        this.dqo.a(this.dql);
        return new a(this.dqo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, a aVar) {
        if (pVar != null) {
            pVar.fc(i + 1);
        }
        aVar.dqq.a(pVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ah dqq;

        public a(ah ahVar) {
            super(ahVar.getView());
            this.dqq = ahVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dpv = bdUniqueId;
    }

    public void a(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dqk = fVar;
    }
}
