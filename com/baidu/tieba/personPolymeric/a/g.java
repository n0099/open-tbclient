package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.f, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h>> {
    private TbPageContext GO;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.h(this.GO));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.f fVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.h> aVar) {
        if (aVar == null || aVar.PP() == null || fVar == null) {
            return null;
        }
        aVar.PP().onBindDataToView(fVar);
        return aVar.PP().getView();
    }
}
