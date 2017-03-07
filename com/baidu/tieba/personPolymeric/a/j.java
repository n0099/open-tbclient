package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.h, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.k>> {
    private TbPageContext<?> ajF;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.h.eHG);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.k> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.k(this.ajF));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.h hVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.k> aVar) {
        aVar.Tb().onBindDataToView(hVar);
        aVar.Tb().onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
