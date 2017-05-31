package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.n, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.u>> {
    private TbPageContext ajh;
    private View.OnClickListener mOnClickListener;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.u> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.u(this.ajh));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.n nVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.u> aVar) {
        if (nVar == null || aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().a(nVar);
        if (aVar.UY().getView() != null) {
            aVar.UY().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.UY().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
