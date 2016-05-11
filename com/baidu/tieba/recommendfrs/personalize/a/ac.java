package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.q, a> {
    private TbPageContext<?> DV;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.q.aSr);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public a b(ViewGroup viewGroup) {
        bw bwVar = new bw(this.DV);
        bwVar.p("c10718", "c10719", "c10742");
        return new a(bwVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.q qVar, a aVar) {
        aVar.ebS.d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        aVar.ebS.a(qVar);
        bx.Kg().a(new aw("c10718").ac("obj_id", String.valueOf(qVar.aSs)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bw ebS;

        public a(bw bwVar) {
            super(bwVar.getView());
            this.ebS = bwVar;
        }
    }
}
