package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.p;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.b, a> {
    private BdUniqueId dpv;
    private p dqe;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.e.dpe);
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dpv = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.b bVar, a aVar) {
        if (aVar.dqc == null) {
            return null;
        }
        aVar.dqc.setFrom("home");
        aVar.dqc.a((com.baidu.tieba.card.a.j) bVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public a a(ViewGroup viewGroup) {
        this.dqe = new p(this.mPageContext);
        this.dqe.i(this.dpv);
        this.dqe.h("c10714", "c10739", "c10712", "c10740");
        return new a(this.dqe);
    }

    public void onChangeSkinType(int i) {
        if (this.dqe != null) {
            this.dqe.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public p dqc;

        public a(p pVar) {
            super(pVar.getView());
            this.dqc = pVar;
        }
    }
}
