package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.h, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.f>> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext oW;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.f> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.d.f(this.oW));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.f> aVar) {
        if (aVar == null || aVar.Xv() == null || hVar == null) {
            return null;
        }
        aVar.Xv().a(hVar);
        if (aVar.Xv().getView() != null) {
            aVar.Xv().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.Xv().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
