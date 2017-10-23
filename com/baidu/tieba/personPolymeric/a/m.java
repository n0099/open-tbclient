package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.view.r;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.m, com.baidu.tieba.card.a.a<r>> {
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.m.XZ);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new r(this.mH));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.m mVar, com.baidu.tieba.card.a.a<r> aVar) {
        aVar.Yn().a(mVar);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
