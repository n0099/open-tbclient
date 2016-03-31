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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.b, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private com.baidu.tieba.card.y dXS;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.b.dWF);
        this.ND = tbPageContext;
        this.dXS = new com.baidu.tieba.card.y(this.ND);
        this.dXS.i("c10715", "c10741", "c10713", "c10740");
        this.dXS.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
        if (this.dXS != null) {
            this.dXS.i(this.aSu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.b bVar, a aVar) {
        if (aVar.dXT == null) {
            return null;
        }
        aVar.dXT.a((com.baidu.tieba.card.a.n) bVar);
        cf.Lx().a(new aw("c10715").ac("obj_param3", bc.Lr()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public a b(ViewGroup viewGroup) {
        if (this.dXS == null) {
            this.dXS = new com.baidu.tieba.card.y(this.ND);
            this.dXS.i(this.aSu);
            this.dXS.i("c10715", "c10741", "c10713", "c10740");
        }
        return new a(this.dXS);
    }

    public void onChangeSkinType(int i) {
        if (this.dXS != null) {
            this.dXS.d(this.ND, i);
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
