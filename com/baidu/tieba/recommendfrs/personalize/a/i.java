package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.a.s;
import com.baidu.tieba.card.al;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<s, a> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), s.aQI);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aD */
    public a a(ViewGroup viewGroup) {
        al alVar = new al(this.mPageContext);
        alVar.n("c10718", "c10719", "c10742");
        return new a(alVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        aVar.dqt.onChangeSkinType(this.mPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        aVar.dqt.a(sVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public al dqt;

        public a(al alVar) {
            super(alVar.getView());
            this.dqt = alVar;
        }
    }
}
