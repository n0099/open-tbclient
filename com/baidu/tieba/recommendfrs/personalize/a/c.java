package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.c, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private com.baidu.tieba.card.y dXV;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.f.dWH);
        this.ND = tbPageContext;
        this.dXV = new com.baidu.tieba.card.y(this.ND);
        this.dXV.i("c10714", "c10739", "c10712", "c10738");
        this.dXV.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
        if (this.dXV != null) {
            this.dXV.i(this.aSu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.c cVar, a aVar) {
        if (aVar.dXT == null) {
            return null;
        }
        aVar.dXT.a((com.baidu.tieba.card.a.n) cVar);
        cf.Lx().a(new aw("c10714").ac("obj_param3", bc.Lr()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a b(ViewGroup viewGroup) {
        if (this.dXV == null) {
            this.dXV = new com.baidu.tieba.card.y(this.ND);
            this.dXV.i(this.aSu);
            this.dXV.i("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.dXV);
    }

    public void onChangeSkinType(int i) {
        if (this.dXV != null) {
            this.dXV.d(this.ND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public com.baidu.tieba.card.y dXT;

        public a(com.baidu.tieba.card.y yVar) {
            super(yVar.getView());
            this.dXT = yVar;
        }
    }
}
