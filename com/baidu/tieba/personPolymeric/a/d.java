package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.e, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.d>> {
    private TbPageContext<?> alI;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.e.fko);
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.d> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.d.d(this.alI));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.d> aVar) {
        aVar.Xc().a(eVar);
        aVar.Xc().d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
