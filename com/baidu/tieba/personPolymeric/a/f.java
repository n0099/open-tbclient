package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.n, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.o>> {
    private TbPageContext alI;
    private View.OnClickListener mOnClickListener;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.o> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.d.o(this.alI));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.o> aVar) {
        if (nVar == null || aVar == null || aVar.Xc() == null) {
            return null;
        }
        aVar.Xc().a(nVar);
        if (aVar.Xc().getView() != null) {
            aVar.Xc().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.Xc().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
