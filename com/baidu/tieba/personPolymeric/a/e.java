package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ce;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.c, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.e>> {
    private TbPageContext<?> ajT;
    private ce bqZ;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.c.eFu);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.e> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.e(this.ajT));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.c cVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.e> aVar) {
        aVar.Tz().setOnCardStatisticsCallback(this.bqZ);
        aVar.Tz().onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Tz().onBindDataToView(cVar);
        return aVar.getView();
    }
}
