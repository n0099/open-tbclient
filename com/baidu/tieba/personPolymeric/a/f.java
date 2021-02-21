package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.o, CardViewHolder<com.baidu.tieba.personPolymeric.view.n>> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personPolymeric.view.n> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personPolymeric.view.n(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.o oVar, CardViewHolder<com.baidu.tieba.personPolymeric.view.n> cardViewHolder) {
        if (oVar == null || cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        cardViewHolder.cti().a(oVar);
        if (cardViewHolder.cti().getView() != null) {
            cardViewHolder.cti().getView().setOnClickListener(this.mOnClickListener);
        }
        return cardViewHolder.cti().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
