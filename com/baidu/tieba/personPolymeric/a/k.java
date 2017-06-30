package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bu;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bu>> {
    private TbPageContext<?> ajP;
    private boolean boT;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> cgJ;
    private com.baidu.adp.lib.e.b<TbImageView> cgK;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.bEG);
        this.cgJ = new com.baidu.adp.lib.e.b<>(new l(this), 6, 0);
        this.cgK = new com.baidu.adp.lib.e.b<>(new m(this), 12, 0);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<bu> onCreateViewHolder(ViewGroup viewGroup) {
        bu buVar = new bu(this.ajP);
        buVar.setConstrainLayoutPool(this.cgJ);
        buVar.setConstrainImagePool(this.cgK);
        buVar.a(new n(this));
        return new com.baidu.tieba.card.b.a<>(buVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bu> aVar) {
        aVar.Wp().d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Wp().a(cardPersonDynamicThreadData);
        return aVar.getView();
    }

    public void setIsHost(boolean z) {
        this.boT = z;
    }
}
