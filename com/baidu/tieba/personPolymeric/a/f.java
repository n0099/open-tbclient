package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.o, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.l>> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.l(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.o oVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.l> aVar) {
        if (oVar == null || aVar == null || aVar.aja() == null) {
            return null;
        }
        aVar.aja().a(oVar);
        if (aVar.aja().getView() != null) {
            aVar.aja().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.aja().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
