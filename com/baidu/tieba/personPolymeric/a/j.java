package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.i, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.k>> {
    private TbPageContext<?> ajh;
    private String eKB;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.i.eMz, bdUniqueId);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.k> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new com.baidu.tieba.personPolymeric.d.k(this.ajh));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.i iVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.k> aVar) {
        aVar.UY().setTip(this.eKB);
        aVar.UY().a(iVar);
        aVar.UY().d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }

    public void ou(String str) {
        this.eKB = str;
    }
}
