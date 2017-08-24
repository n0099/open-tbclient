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
    private LikeModel bGM;
    private w bGk;
    private u fkd;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.fmd);
        this.oW = tbPageContext;
        this.bGM = new LikeModel(tbPageContext);
        this.fkd = new u();
        this.fkd.a(new u.a() { // from class: com.baidu.tieba.personPolymeric.a.a.1
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
        com.baidu.tieba.personPolymeric.d.b bVar = new com.baidu.tieba.personPolymeric.d.b(this.oW);
        bVar.a(this.bGM);
        bVar.a(this.fkd);
        bVar.a(this.bGk);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.b> aVar) {
        aVar.Xv().a(bVar);
        aVar.Xv().d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
