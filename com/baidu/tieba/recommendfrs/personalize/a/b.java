package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.b, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private com.baidu.tieba.card.p ebb;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.b.dZP);
        this.DV = tbPageContext;
        this.ebb = new com.baidu.tieba.card.p(this.DV);
        this.ebb.i("c10715", "c10741", "c10713", "c10740");
        this.ebb.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
        if (this.ebb != null) {
            this.ebb.i(this.aOT);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.b bVar, a aVar) {
        if (aVar.ebc == null) {
            return null;
        }
        aVar.ebc.a((com.baidu.tieba.card.a.i) bVar);
        bx.Ki().a(new aw("c10715").ac("obj_param3", au.Kc()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public a b(ViewGroup viewGroup) {
        if (this.ebb == null) {
            this.ebb = new com.baidu.tieba.card.p(this.DV);
            this.ebb.i(this.aOT);
            this.ebb.i("c10715", "c10741", "c10713", "c10740");
        }
        return new a(this.ebb);
    }

    public void onChangeSkinType(int i) {
        if (this.ebb != null) {
            this.ebb.d(this.DV, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.p ebc;

        public a(com.baidu.tieba.card.p pVar) {
            super(pVar.getView());
            this.ebc = pVar;
        }
    }
}
