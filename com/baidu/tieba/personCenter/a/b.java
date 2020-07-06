package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.e, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.b>> {
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.b> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personCenter.view.b(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.b> aVar) {
        aVar.bPh().a(eVar);
        return aVar.getView();
    }
}
