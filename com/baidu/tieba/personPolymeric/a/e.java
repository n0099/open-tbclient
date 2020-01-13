package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.g, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.e>> {
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.e> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.e(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.e> aVar) {
        if (aVar == null || aVar.bue() == null || gVar == null) {
            return null;
        }
        aVar.bue().a(gVar);
        return aVar.bue().getView();
    }
}
