package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.g, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.j>> {
    private TbPageContext GO;
    private View.OnClickListener mOnClickListener;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.j> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.j(this.GO));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.g gVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.j> aVar) {
        if (aVar == null || aVar.PP() == null || gVar == null) {
            return null;
        }
        aVar.PP().onBindDataToView(gVar);
        if (aVar.PP().getView() != null) {
            aVar.PP().getView().setOnClickListener(this.mOnClickListener);
        }
        return aVar.PP().getView();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
