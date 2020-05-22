package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.o, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.n>> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.n> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.n(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.o oVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.n> aVar) {
        if (oVar == null || aVar == null || aVar.bLU() == null) {
            return null;
        }
        aVar.bLU().a(oVar);
        if (aVar.bLU().getView() != null) {
            aVar.bLU().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.bLU().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
