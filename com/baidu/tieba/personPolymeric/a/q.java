package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.d.y;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.k, com.baidu.tieba.card.b.a<y>> {
    private TbPageContext<?> ajT;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.k.Yc);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<y> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new y(this.ajT));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.k kVar, com.baidu.tieba.card.b.a<y> aVar) {
        aVar.Tz().onBindDataToView(kVar);
        aVar.Tz().onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
