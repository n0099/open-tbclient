package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.x, a> {
    private TbPageContext<?> ND;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.x.aWt);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        cc ccVar = new cc(this.ND);
        ccVar.at("c10716", "c10717");
        return new a(ccVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.x xVar, a aVar) {
        if (xVar != null) {
            xVar.aWw = i + 1;
            aVar.bwB.d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        }
        aVar.bwB.a(xVar);
        cf.Lx().hd("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public cc bwB;

        public a(cc ccVar) {
            super(ccVar.getView());
            this.bwB = ccVar;
        }
    }
}
