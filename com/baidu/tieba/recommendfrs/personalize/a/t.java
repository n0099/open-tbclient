package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.bu;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.p, a> {
    private TbPageContext<?> DV;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.p.aSn);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public a b(ViewGroup viewGroup) {
        bu buVar = new bu(this.DV);
        buVar.ax("c10716", "c10717");
        return new a(buVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.p pVar, a aVar) {
        if (pVar != null) {
            pVar.aSq = i + 1;
            aVar.bwl.d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        }
        aVar.bwl.a(pVar);
        bx.Kg().he("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bu bwl;

        public a(bu buVar) {
            super(buVar.getView());
            this.bwl = buVar;
        }
    }
}
