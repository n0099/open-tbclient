package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.l, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.n>> {
    private TbPageContext<?> GM;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.l.eIo);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.n> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.n(this.GM));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.l lVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.n> aVar) {
        aVar.Ok().onBindDataToView(lVar);
        aVar.Ok().onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
