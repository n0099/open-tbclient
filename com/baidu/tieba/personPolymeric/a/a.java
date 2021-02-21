package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, CardViewHolder<com.baidu.tieba.personPolymeric.view.b>> {
    private LikeModel fnw;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.mBJ);
        this.mPageContext = tbPageContext;
        this.fnw = new LikeModel(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personPolymeric.view.b> e(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.view.b bVar = new com.baidu.tieba.personPolymeric.view.b(this.mPageContext);
        bVar.a(this.fnw);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, CardViewHolder<com.baidu.tieba.personPolymeric.view.b> cardViewHolder) {
        cardViewHolder.cti().a(bVar);
        cardViewHolder.cti().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.getView();
    }
}
