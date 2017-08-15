package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.w;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b>> {
    private LikeModel bGL;
    private w bGj;
    private u fkb;
    private TbPageContext<?> oV;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.fmb);
        this.oV = tbPageContext;
        this.bGL = new LikeModel(tbPageContext);
        this.fkb = new u();
        this.fkb.a(new u.a() { // from class: com.baidu.tieba.personPolymeric.a.a.1
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void j(String str, long j) {
            }

            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.oV);
        bVar.a(this.bGL);
        bVar.a(this.fkb);
        bVar.a(this.bGj);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b> aVar) {
        aVar.Xy().a(bVar);
        aVar.Xy().d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
