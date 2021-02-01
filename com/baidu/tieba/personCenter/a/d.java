package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.personCenter.c.h;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, CardViewHolder<com.baidu.tieba.personCenter.view.g>> {
    private ab<h> jze;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personCenter.view.g> e(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.g gVar = new com.baidu.tieba.personCenter.view.g(this.mPageContext);
        gVar.c(this.jze);
        return new CardViewHolder<>(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, CardViewHolder<com.baidu.tieba.personCenter.view.g> cardViewHolder) {
        cardViewHolder.ctb().a(hVar);
        return cardViewHolder.getView();
    }

    public void c(ab<h> abVar) {
        this.jze = abVar;
    }
}
