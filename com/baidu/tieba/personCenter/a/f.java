package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.c.k;
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.d>> {
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.d> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personCenter.view.d(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.d> aVar) {
        aVar.coY().a(kVar);
        return aVar.getView();
    }
}
