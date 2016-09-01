package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ce;
import com.baidu.tieba.tbadkCore.am;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.a, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b>> {
    private TbPageContext<?> GM;
    private x Ge;
    private ce aXI;
    private am eGQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.a.eHV);
        this.GM = tbPageContext;
        this.Ge = new x(tbPageContext);
        this.eGQ = new am();
        this.eGQ.a(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> a(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.GM);
        bVar.a(this.Ge);
        bVar.a(this.eGQ);
        bVar.setOnCardStatisticsCallback(this.aXI);
        return new com.baidu.tieba.card.b.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.a aVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> aVar2) {
        aVar2.Ok().onBindDataToView(aVar);
        aVar2.Ok().onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar2.getView();
    }
}
