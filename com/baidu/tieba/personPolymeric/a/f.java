package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.d, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.g>> {
    private TbPageContext<?> ajT;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.d.eFv);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.g> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.g(this.ajT));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.d dVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.g> aVar) {
        aVar.Tz().onBindDataToView(dVar);
        aVar.Tz().onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
