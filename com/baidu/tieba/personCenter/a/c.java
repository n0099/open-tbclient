package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.c.g;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f>> {
    private aa<g> hAV;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f> b(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.f fVar = new com.baidu.tieba.personCenter.view.f(this.mPageContext);
        fVar.c(this.hAV);
        return new com.baidu.tieba.card.a.a<>(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f> aVar) {
        aVar.bLU().a(gVar);
        return aVar.getView();
    }

    public void c(aa<g> aaVar) {
        this.hAV = aaVar;
    }
}
