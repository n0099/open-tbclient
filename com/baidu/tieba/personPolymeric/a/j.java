package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes7.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.j, CardViewHolder<com.baidu.tieba.personPolymeric.view.h>> {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.personPolymeric.b.c mqh;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.j.msI, bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.personPolymeric.view.h> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.personPolymeric.view.h(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.j jVar, CardViewHolder<com.baidu.tieba.personPolymeric.view.h> cardViewHolder) {
        com.baidu.tieba.personPolymeric.view.h crP = cardViewHolder.crP();
        crP.a(jVar);
        crP.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        crP.b(this.mqh);
        return cardViewHolder.getView();
    }

    public void a(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.mqh = cVar;
    }
}
