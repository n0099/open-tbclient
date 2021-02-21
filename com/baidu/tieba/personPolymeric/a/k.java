package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes8.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.k, CardViewHolder<com.baidu.tieba.personPolymeric.view.i>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.k.mBY);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personPolymeric.view.i> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personPolymeric.view.i(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.k kVar, CardViewHolder<com.baidu.tieba.personPolymeric.view.i> cardViewHolder) {
        cardViewHolder.cti().a(kVar);
        cardViewHolder.cti().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.getView();
    }
}
