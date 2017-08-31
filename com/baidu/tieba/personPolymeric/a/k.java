package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.k, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.i>> {
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.k.fkQ);
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.i> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.d.i(this.mF));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.i> aVar) {
        aVar.Yy().a(kVar);
        aVar.Yy().d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
