package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.a, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a>> {
    private TbPageContext mH;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personCenter.view.a(this.mH));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.a> aVar2) {
        aVar2.Yn().a(aVar);
        return aVar2.getView();
    }

    public void aVh() {
    }

    public void destroy() {
    }
}
