package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.c.h;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.g>> {
    private ab<h> iRv;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.g> c(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.g gVar = new com.baidu.tieba.personCenter.view.g(this.mPageContext);
        gVar.c(this.iRv);
        return new com.baidu.tieba.card.a.a<>(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.g> aVar) {
        aVar.cmx().a(hVar);
        return aVar.getView();
    }

    public void c(ab<h> abVar) {
        this.iRv = abVar;
    }
}
