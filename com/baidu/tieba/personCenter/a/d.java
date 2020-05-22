package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.tieba.personCenter.view.g;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, com.baidu.tieba.card.a.a<g>> {
    private TbPageContext<?> mPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<g> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new g(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, com.baidu.tieba.card.a.a<g> aVar) {
        aVar.bLU().a(hVar);
        return aVar.getView();
    }
}
