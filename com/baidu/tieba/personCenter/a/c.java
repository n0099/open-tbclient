package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f>> {
    private TbPageContext mPageContext;
    private ab<g> sH;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.f fVar = new com.baidu.tieba.personCenter.view.f(this.mPageContext);
        fVar.d(this.sH);
        return new com.baidu.tieba.card.a.a<>(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.f> aVar) {
        aVar.baX().a(gVar);
        return aVar.getView();
    }

    public void d(ab<g> abVar) {
        this.sH = abVar;
    }
}
