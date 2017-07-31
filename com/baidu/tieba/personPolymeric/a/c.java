package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.w;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.d, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.c>> {
    private TbPageContext<?> alI;
    private w bFA;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.d.fkn);
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.c> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.d.c(this.alI));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.c> aVar) {
        aVar.Xc().a(this.bFA);
        aVar.Xc().d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        aVar.Xc().a(dVar);
        return aVar.getView();
    }
}
