package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ca;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.a>> {
    private TbPageContext<?> GO;
    private ca baB;
    private com.baidu.adp.lib.f.b<com.baidu.tieba.personPolymeric.d.q> esR;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.eua);
        this.esR = new com.baidu.adp.lib.f.b<>(new d(this), 12, 0);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.a> a(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.GO);
        aVar.a(this.esR);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.Po().setOnCardStatisticsCallback(this.baB);
        aVar.Po().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Po().onBindDataToView(bVar);
        return aVar.getView();
    }
}
