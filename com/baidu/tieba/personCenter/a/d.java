package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.c.h;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.g>> {
    private aa<h> hOQ;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.g> b(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.g gVar = new com.baidu.tieba.personCenter.view.g(this.mPageContext);
        gVar.c(this.hOQ);
        return new com.baidu.tieba.card.a.a<>(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.g> aVar) {
        aVar.bPh().a(hVar);
        return aVar.getView();
    }

    public void c(aa<h> aaVar) {
        this.hOQ = aaVar;
    }
}
