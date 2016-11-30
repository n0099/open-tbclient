package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.by;
import com.baidu.tieba.tbadkCore.al;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.a, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b>> {
    private TbPageContext<?> GO;
    private x Gg;
    private by bbv;
    private al ePt;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.a.eQx);
        this.GO = tbPageContext;
        this.Gg = new x(tbPageContext);
        this.ePt = new al();
        this.ePt.a(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> a(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.GO);
        bVar.a(this.Gg);
        bVar.a(this.ePt);
        bVar.setOnCardStatisticsCallback(this.bbv);
        return new com.baidu.tieba.card.b.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.a aVar, com.baidu.tieba.card.b.a<com.baidu.tieba.personPolymeric.d.b> aVar2) {
        aVar2.PP().onBindDataToView(aVar);
        aVar2.PP().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar2.getView();
    }
}
