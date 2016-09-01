package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.m, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.s>> {
    private TbPageContext GM;
    private View.OnClickListener mOnClickListener;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.s> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.s(this.GM));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.m mVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.s> aVar) {
        if (mVar == null || aVar == null || aVar.Ok() == null) {
            return null;
        }
        aVar.Ok().onBindDataToView(mVar);
        if (aVar.Ok().getView() != null) {
            aVar.Ok().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.Ok().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
