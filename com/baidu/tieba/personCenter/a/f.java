package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.personCenter.c.k;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, CardViewHolder<com.baidu.tieba.personCenter.view.d>> {
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personCenter.view.d> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personCenter.view.d(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, CardViewHolder<com.baidu.tieba.personCenter.view.d> cardViewHolder) {
        cardViewHolder.crP().a(kVar);
        return cardViewHolder.getView();
    }
}
