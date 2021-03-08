package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<a, CardViewHolder<c>> {
    private ab ajy;
    private TbPageContext<?> eWx;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.eWx = tbPageContext;
    }

    public void setOnCardSubClickListener(ab abVar) {
        this.ajy = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<c> e(ViewGroup viewGroup) {
        c cVar = new c(this.eWx, viewGroup);
        if (this.ajy != null) {
            cVar.c(this.ajy);
        }
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, a aVar, CardViewHolder<c> cardViewHolder) {
        if (aVar == null || cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        cardViewHolder.cto().a(aVar);
        return cardViewHolder.getView();
    }

    @Override // com.baidu.adp.widget.ListView.a
    public w qp() {
        return super.qp();
    }
}
