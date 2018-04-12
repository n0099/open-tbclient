package com.baidu.tieba.personCenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.d>> {
    private ab<e> lC;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personCenter.view.d dVar = new com.baidu.tieba.personCenter.view.d(this.mPageContext);
        dVar.b(this.lC);
        return new com.baidu.tieba.card.a.a<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personCenter.view.d> aVar) {
        aVar.afY().a(eVar);
        return aVar.getView();
    }

    public void b(ab<e> abVar) {
        this.lC = abVar;
    }
}
