package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ch;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.d, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.e>> {
    private TbPageContext<?> ajP;
    private ch bAj;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.d.eWA);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.e> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.e(this.ajP));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.d dVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.e> aVar) {
        aVar.Wp().a(this.bAj);
        aVar.Wp().d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.Wp().a(dVar);
        return aVar.getView();
    }
}
