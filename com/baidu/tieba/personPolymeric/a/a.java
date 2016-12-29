package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.tbadkCore.ak;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.a, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b>> {
    private TbPageContext<?> GO;
    private w Gg;
    private ca baB;
    private ak esP;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.a.etW);
        this.GO = tbPageContext;
        this.Gg = new w(tbPageContext);
        this.esP = new ak();
        this.esP.a(new b(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b> a(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.GO);
        bVar.a(this.Gg);
        bVar.a(this.esP);
        bVar.setOnCardStatisticsCallback(this.baB);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b> aVar2) {
        aVar2.Po().onBindDataToView(aVar);
        aVar2.Po().onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        return aVar2.getView();
    }
}
