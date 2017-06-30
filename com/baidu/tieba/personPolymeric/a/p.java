package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.k, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m>> {
    private TbPageContext<?> ajP;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.k.eWM);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.m(this.ajP));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.k kVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m> aVar) {
        aVar.Wp().a(kVar);
        aVar.Wp().d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
