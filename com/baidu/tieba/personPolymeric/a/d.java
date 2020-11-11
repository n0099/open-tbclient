package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes24.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.e, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.d>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.e.mdq);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.d> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.d(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.d> aVar) {
        aVar.coY().a(eVar);
        aVar.coY().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
