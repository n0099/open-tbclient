package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bp;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bp>> {
    private TbPageContext<?> ajr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSJ;
    private com.baidu.adp.lib.e.b<TbImageView> bSK;
    private boolean bjW;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.bxS);
        this.bSJ = new com.baidu.adp.lib.e.b<>(new l(this), 6, 0);
        this.bSK = new com.baidu.adp.lib.e.b<>(new m(this), 12, 0);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<bp> onCreateViewHolder(ViewGroup viewGroup) {
        bp bpVar = new bp(this.ajr);
        bpVar.setConstrainLayoutPool(this.bSJ);
        bpVar.setConstrainImagePool(this.bSK);
        bpVar.setOnSubCardOnClickListenner(new n(this));
        return new com.baidu.tieba.card.b.a<>(bpVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bp> aVar) {
        aVar.TU().onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.TU().onBindDataToView(cardPersonDynamicThreadData);
        return aVar.getView();
    }

    public void setIsHost(boolean z) {
        this.bjW = z;
    }
}
