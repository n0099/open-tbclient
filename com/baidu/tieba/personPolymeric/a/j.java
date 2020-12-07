package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes24.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.j, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.h>> {
    private TbPageContext<?> mPageContext;
    private com.baidu.tieba.personPolymeric.b.c mpy;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.j.mrX, bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.h> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.h(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.h> aVar) {
        com.baidu.tieba.personPolymeric.view.h csM = aVar.csM();
        csM.a(jVar);
        csM.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        csM.b(this.mpy);
        return aVar.getView();
    }

    public void a(com.baidu.tieba.personPolymeric.b.c cVar) {
        this.mpy = cVar;
    }
}
