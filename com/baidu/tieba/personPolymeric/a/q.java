package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.d.w;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.k, com.baidu.tieba.card.b.a<w>> {
    private TbPageContext<?> GO;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.k.TP);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.card.b.a<w> a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a<>(new w(this.GO));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.k kVar, com.baidu.tieba.card.b.a<w> aVar) {
        aVar.PP().onBindDataToView(kVar);
        aVar.PP().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar.getView();
    }
}
