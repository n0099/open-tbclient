package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.j, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m>> {
    private TbPageContext<?> ajU;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.j.eHW);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.m(this.ajU));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.j jVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m> aVar) {
        aVar.UB().onBindDataToView(jVar);
        aVar.UB().onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
