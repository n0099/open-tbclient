package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.d, CardViewHolder<com.baidu.tieba.personCenter.view.a>> {
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personCenter.view.a> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personCenter.view.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.d dVar, CardViewHolder<com.baidu.tieba.personCenter.view.a> cardViewHolder) {
        cardViewHolder.cti().a(dVar);
        return cardViewHolder.getView();
    }

    public void dwF() {
    }

    public void destroy() {
    }
}
