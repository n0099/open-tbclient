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
    private TbPageContext<?> ajF;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSK;
    private com.baidu.adp.lib.e.b<TbImageView> bSL;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), CardPersonDynamicThreadData.bvK);
        this.bSK = new com.baidu.adp.lib.e.b<>(new l(this), 6, 0);
        this.bSL = new com.baidu.adp.lib.e.b<>(new m(this), 12, 0);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<br> onCreateViewHolder(ViewGroup viewGroup) {
        br brVar = new br(this.ajF);
        brVar.setConstrainLayoutPool(this.bSK);
        brVar.setConstrainImagePool(this.bSL);
        brVar.setOnSubCardOnClickListenner(new n(this));
        return new com.baidu.tieba.card.b.a<>(brVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardPersonDynamicThreadData cardPersonDynamicThreadData, com.baidu.tieba.card.b.a<br> aVar) {
        aVar.Tb().onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Tb().onBindDataToView(cardPersonDynamicThreadData);
        return aVar.getView();
    }
}
