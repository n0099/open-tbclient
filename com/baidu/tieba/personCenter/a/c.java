package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.e>> {
    private TbPageContext mPageContext;
    private ad<f> vf;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.e eVar = new com.baidu.tieba.personCenter.view.e(this.mPageContext);
        eVar.b(this.vf);
        return new com.baidu.tieba.card.a.a<>(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.e> aVar) {
        aVar.aoP().a(fVar);
        return aVar.getView();
    }

    public void b(ad<f> adVar) {
        this.vf = adVar;
    }
}
