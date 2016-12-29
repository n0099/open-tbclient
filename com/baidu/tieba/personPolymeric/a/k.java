package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bn;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.a.a<bn>> {
    private TbPageContext<?> GO;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bFm;
    private com.baidu.adp.lib.f.b<TbImageView> bFn;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.beU);
        this.bFm = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bFn = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a<bn> a(ViewGroup viewGroup) {
        bn bnVar = new bn(this.GO);
        bnVar.setConstrainLayoutPool(this.bFm);
        bnVar.setConstrainImagePool(this.bFn);
        bnVar.setOnSubCardOnClickListenner(new n(this));
        return new com.baidu.tieba.card.a.a<>(bnVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.a.a<bn> aVar) {
        aVar.Po().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Po().onBindDataToView(cardPersonDynamicThreadData);
        return aVar.getView();
    }
}
