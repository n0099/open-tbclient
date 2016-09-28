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
    private TbPageContext<?> GM;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUl;
    private com.baidu.adp.lib.f.b<TbImageView> bUm;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.bcG);
        this.bUl = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bUm = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public com.baidu.tieba.card.b.a<bp> a(ViewGroup viewGroup) {
        bp bpVar = new bp(this.GM);
        bpVar.setConstrainLayoutPool(this.bUl);
        bpVar.setConstrainImagePool(this.bUm);
        bpVar.setOnSubCardOnClickListenner(new n(this));
        return new com.baidu.tieba.card.b.a<>(bpVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bp> aVar) {
        aVar.OM().onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.OM().onBindDataToView(cardPersonDynamicThreadData);
        return aVar.getView();
    }
}
