package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.ak;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<r, a> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), r.aQD);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public a a(ViewGroup viewGroup) {
        ak akVar = new ak(this.mPageContext);
        akVar.an("c10716", "c10717");
        return new a(akVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, r rVar, a aVar) {
        if (rVar != null) {
            rVar.aQH = i + 1;
            aVar.dqr.onChangeSkinType(this.mPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
        aVar.dqr.a(rVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ak dqr;

        public a(ak akVar) {
            super(akVar.getView());
            this.dqr = akVar;
        }
    }
}
