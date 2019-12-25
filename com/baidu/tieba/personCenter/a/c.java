package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f>> {
    private z<g> gwj;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f> b(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.f fVar = new com.baidu.tieba.personCenter.view.f(this.mPageContext);
        fVar.c(this.gwj);
        return new com.baidu.tieba.card.a.a<>(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f> aVar) {
        aVar.btc().a(gVar);
        return aVar.getView();
    }

    public void c(z<g> zVar) {
        this.gwj = zVar;
    }
}
