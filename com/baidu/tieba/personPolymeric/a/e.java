package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.g, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.e>> {
    private TbPageContext mH;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.personPolymeric.view.e(this.mH));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.e> aVar) {
        if (aVar == null || aVar.Yn() == null || gVar == null) {
            return null;
        }
        aVar.Yn().a(gVar);
        return aVar.Yn().getView();
    }
}
