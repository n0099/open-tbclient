package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.i, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.g>> {
    private String fkh;
    private TbPageContext<?> oW;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.i.fmr, bdUniqueId);
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.g> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.d.g(this.oW));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.i iVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.g> aVar) {
        aVar.Xv().setTip(this.fkh);
        aVar.Xv().a(iVar);
        aVar.Xv().d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
