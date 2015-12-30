package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.p;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.a, C0078a> {
    private BdUniqueId dpv;
    private p dqb;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.a.dpc);
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dpv = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.a aVar, C0078a c0078a) {
        if (c0078a.dqc == null) {
            return null;
        }
        c0078a.dqc.setFrom("home");
        c0078a.dqc.a((com.baidu.tieba.card.a.j) aVar);
        return c0078a.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public C0078a a(ViewGroup viewGroup) {
        this.dqb = new p(this.mPageContext);
        this.dqb.i(this.dpv);
        this.dqb.h("c10715", "c10741", "c10713", "c10740");
        return new C0078a(this.dqb);
    }

    public void onChangeSkinType(int i) {
        if (this.dqb != null) {
            this.dqb.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recommendfrs.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0078a extends x.a {
        public p dqc;

        public C0078a(p pVar) {
            super(pVar.getView());
            this.dqc = pVar;
        }
    }
}
