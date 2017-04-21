package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ce;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a>> {
    private TbPageContext<?> ajU;
    private ce btr;
    private com.baidu.adp.lib.e.b<com.baidu.tieba.personPolymeric.d.q> eGA;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.eHI);
        this.eGA = new com.baidu.adp.lib.e.b<>(new d(this), 12, 0);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.ajU);
        aVar.a(this.eGA);
        return new com.baidu.tieba.card.b.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.UB().setOnCardStatisticsCallback(this.btr);
        aVar.UB().onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.UB().onBindDataToView(bVar);
        return aVar.getView();
    }
}
