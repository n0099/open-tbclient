package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.f, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h>> {
    private TbPageContext GM;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.h(this.GM));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.f fVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h> aVar) {
        if (aVar == null || aVar.Ok() == null || fVar == null) {
            return null;
        }
        aVar.Ok().onBindDataToView(fVar);
        return aVar.Ok().getView();
    }
}
