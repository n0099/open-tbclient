package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.ce;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.y, a> {
    private TbPageContext<?> ND;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.y.aWx);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public a b(ViewGroup viewGroup) {
        ce ceVar = new ce(this.ND);
        ceVar.p("c10718", "c10719", "c10742");
        return new a(ceVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.y yVar, a aVar) {
        aVar.dYL.d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        aVar.dYL.a(yVar);
        cf.Lx().a(new aw("c10718").ac("obj_id", String.valueOf(yVar.aWy)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ce dYL;

        public a(ce ceVar) {
            super(ceVar.getView());
            this.dYL = ceVar;
        }
    }
}
