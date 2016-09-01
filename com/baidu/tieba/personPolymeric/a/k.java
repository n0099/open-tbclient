package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.br;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.b.a<br>> {
    private TbPageContext<?> GM;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUs;
    private com.baidu.adp.lib.f.b<TbImageView> bUt;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.bcm);
        this.bUs = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bUt = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<br> a(ViewGroup viewGroup) {
        br brVar = new br(this.GM);
        brVar.setConstrainLayoutPool(this.bUs);
        brVar.setConstrainImagePool(this.bUt);
        brVar.setOnSubCardOnClickListenner(new n(this));
        return new com.baidu.tieba.card.b.a<>(brVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.b.a<br> aVar) {
        aVar.Ok().onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Ok().onBindDataToView(cardPersonDynamicThreadData);
        return aVar.getView();
    }
}
