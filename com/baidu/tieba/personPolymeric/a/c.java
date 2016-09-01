package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ce;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a>> {
    private TbPageContext<?> GM;
    private ce aXI;
    private com.baidu.adp.lib.f.b<com.baidu.tieba.personPolymeric.d.q> eGS;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.eHZ);
        this.eGS = new com.baidu.adp.lib.f.b<>(new d(this), 12, 0);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> a(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.GM);
        aVar.a(this.eGS);
        return new com.baidu.tieba.card.b.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.Ok().setOnCardStatisticsCallback(this.aXI);
        aVar.Ok().onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Ok().onBindDataToView(bVar);
        return aVar.getView();
    }
}
