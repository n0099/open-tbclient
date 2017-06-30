package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.g, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h>> {
    private TbPageContext ajP;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.h(this.ajP));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.g gVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h> aVar) {
        if (aVar == null || aVar.Wp() == null || gVar == null) {
            return null;
        }
        aVar.Wp().a(gVar);
        return aVar.Wp().getView();
    }
}
