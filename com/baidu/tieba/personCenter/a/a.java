package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.d, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a>> {
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personCenter.view.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a> aVar) {
        aVar.bvQ().a(dVar);
        return aVar.getView();
    }

    public void cvx() {
    }

    public void destroy() {
    }
}
