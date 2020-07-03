package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.personCenter.view.h;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<i, com.baidu.tieba.card.a.a<h>> {
    private TbPageContext<?> mPageContext;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<h> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new h(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, com.baidu.tieba.card.a.a<h> aVar) {
        aVar.bPg().a(iVar);
        return aVar.getView();
    }
}
