package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ce;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a>> {
    private TbPageContext<?> ajF;
    private ce brh;
    private com.baidu.adp.lib.e.b<com.baidu.tieba.personPolymeric.d.q> eGo;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.eHw);
        this.eGo = new com.baidu.adp.lib.e.b<>(new d(this), 12, 0);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.ajF);
        aVar.a(this.eGo);
        return new com.baidu.tieba.card.b.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.Tb().setOnCardStatisticsCallback(this.brh);
        aVar.Tb().onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Tb().onBindDataToView(bVar);
        return aVar.getView();
    }
}
