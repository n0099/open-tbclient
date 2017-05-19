package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.cc;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a>> {
    private TbPageContext<?> ajr;
    private cc btK;
    private com.baidu.adp.lib.e.b<com.baidu.tieba.personPolymeric.d.s> eBN;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.eDc);
        this.eBN = new com.baidu.adp.lib.e.b<>(new d(this), 12, 0);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.ajr);
        aVar.setForumCardItemViewPool(this.eBN);
        return new com.baidu.tieba.card.b.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.TU().setOnCardStatisticsCallback(this.btK);
        aVar.TU().onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.TU().onBindDataToView(bVar);
        return aVar.getView();
    }
}
