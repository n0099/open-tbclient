package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ce;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ah;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.a, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b>> {
    private TbPageContext<?> FY;
    private LikeModel Fq;
    private ce bkp;
    private ah eCK;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.a.eDQ);
        this.FY = tbPageContext;
        this.Fq = new LikeModel(tbPageContext);
        this.eCK = new ah();
        this.eCK.a(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.FY);
        bVar.a(this.Fq);
        bVar.a(this.eCK);
        bVar.setOnCardStatisticsCallback(this.bkp);
        return new com.baidu.tieba.card.b.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.a aVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> aVar2) {
        aVar2.Sd().onBindDataToView(aVar);
        aVar2.Sd().onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar2.getView();
    }
}
