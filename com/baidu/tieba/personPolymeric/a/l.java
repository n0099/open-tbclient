package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.d.r;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.l, com.baidu.tieba.card.a.a<r>> {
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.l.Zg);
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new r(this.oW));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        aVar.Xv().a(lVar);
        aVar.Xv().d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
