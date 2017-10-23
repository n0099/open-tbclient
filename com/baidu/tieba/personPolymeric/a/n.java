package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.n, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.k>> {
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.n.fgW);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.k> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.k(this.mH));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.n nVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.k> aVar) {
        aVar.Yn().a(nVar);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
