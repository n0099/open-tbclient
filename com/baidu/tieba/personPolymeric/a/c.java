package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ch;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.c, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a>> {
    private TbPageContext<?> ajh;
    private ch bzq;
    private com.baidu.adp.lib.e.b<com.baidu.tieba.personPolymeric.d.s> eKz;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.c.eMp);
        this.eKz = new com.baidu.adp.lib.e.b<>(new d(this), 12, 0);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.ajh);
        aVar.setForumCardItemViewPool(this.eKz);
        return new com.baidu.tieba.card.b.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.c cVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.UY().a(this.bzq);
        aVar.UY().d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.UY().a(cVar);
        return aVar.getView();
    }
}
