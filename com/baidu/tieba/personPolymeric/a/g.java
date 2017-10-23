package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.h, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.f>> {
    private TbPageContext mH;
    private View.OnClickListener mOnClickListener;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.f> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.f(this.mH));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.f> aVar) {
        if (aVar == null || aVar.Yn() == null || hVar == null) {
            return null;
        }
        aVar.Yn().a(hVar);
        if (aVar.Yn().getView() != null) {
            aVar.Yn().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.Yn().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
