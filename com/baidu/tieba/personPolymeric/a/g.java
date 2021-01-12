package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes7.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.h, CardViewHolder<com.baidu.tieba.personPolymeric.view.f>> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personPolymeric.view.f> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personPolymeric.view.f(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.h hVar, CardViewHolder<com.baidu.tieba.personPolymeric.view.f> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.crP() == null || hVar == null) {
            return null;
        }
        cardViewHolder.crP().a(hVar);
        if (cardViewHolder.crP().getView() != null) {
            cardViewHolder.crP().getView().setOnClickListener(this.mOnClickListener);
        }
        return cardViewHolder.crP().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
