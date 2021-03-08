package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.personCenter.c.n;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<n, CardViewHolder<com.baidu.tieba.personCenter.view.e>> {
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personCenter.view.e> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personCenter.view.e(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, CardViewHolder<com.baidu.tieba.personCenter.view.e> cardViewHolder) {
        cardViewHolder.cto().a(nVar);
        return cardViewHolder.getView();
    }
}
