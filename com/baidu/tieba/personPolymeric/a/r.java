package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.m, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.n>> {
    private TbPageContext<?> ajh;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.m.eME);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.n> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.n(this.ajh));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.m mVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.n> aVar) {
        aVar.UY().a(mVar);
        aVar.UY().d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
