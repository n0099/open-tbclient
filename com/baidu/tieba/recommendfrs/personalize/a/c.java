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
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.c, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private com.baidu.tieba.card.p ebe;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.f.dZR);
        this.DV = tbPageContext;
        this.ebe = new com.baidu.tieba.card.p(this.DV);
        this.ebe.i("c10714", "c10739", "c10712", "c10738");
        this.ebe.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
        if (this.ebe != null) {
            this.ebe.i(this.aOT);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.c cVar, a aVar) {
        if (aVar.ebc == null) {
            return null;
        }
        aVar.ebc.a((com.baidu.tieba.card.a.i) cVar);
        bx.Ki().a(new aw("c10714").ac("obj_param3", au.Kc()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public a b(ViewGroup viewGroup) {
        if (this.ebe == null) {
            this.ebe = new com.baidu.tieba.card.p(this.DV);
            this.ebe.i(this.aOT);
            this.ebe.i("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.ebe);
    }

    public void onChangeSkinType(int i) {
        if (this.ebe != null) {
            this.ebe.d(this.DV, i);
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
