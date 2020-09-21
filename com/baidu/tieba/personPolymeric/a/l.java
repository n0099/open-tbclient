package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes23.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.l, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.o>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.l.edC);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.o> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.o(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.o> aVar) {
        aVar.cfU().a(lVar);
        aVar.cfU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
