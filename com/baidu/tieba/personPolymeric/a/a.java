package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ch;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b>> {
    private TbPageContext<?> ajh;
    private LikeModel bzS;
    private ch bzq;
    private ae eKx;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.eMm);
        this.ajh = tbPageContext;
        this.bzS = new LikeModel(tbPageContext);
        this.eKx = new ae();
        this.eKx.a(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.ajh);
        bVar.a(this.bzS);
        bVar.a(this.eKx);
        bVar.a(this.bzq);
        return new com.baidu.tieba.card.b.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> aVar) {
        aVar.UY().a(bVar);
        aVar.UY().d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
