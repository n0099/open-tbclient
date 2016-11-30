package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bl;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<CardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bl>> {
    private TbPageContext<?> GO;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bXs;
    private com.baidu.adp.lib.f.b<TbImageView> bXt;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.bfF);
        this.bXs = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bXt = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.card.b.a<bl> a(ViewGroup viewGroup) {
        bl blVar = new bl(this.GO);
        blVar.setConstrainLayoutPool(this.bXs);
        blVar.setConstrainImagePool(this.bXt);
        blVar.setOnSubCardOnClickListenner(new n(this));
        return new com.baidu.tieba.card.b.a<>(blVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.b.a<bl> aVar) {
        aVar.PP().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.PP().onBindDataToView(cardPersonDynamicThreadData);
        return aVar.getView();
    }
}
