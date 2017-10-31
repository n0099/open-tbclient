package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.n, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.k>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.n.fpv);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.k> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.k(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.k> aVar) {
        aVar.aax().a(nVar);
        aVar.aax().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
