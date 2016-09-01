package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.j, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m>> {
    private TbPageContext<?> GM;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.j.eIn);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.m(this.GM));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.j jVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.m> aVar) {
        aVar.Ok().onBindDataToView(jVar);
        aVar.Ok().onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
