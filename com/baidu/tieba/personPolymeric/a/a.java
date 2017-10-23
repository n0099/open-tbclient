package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.w;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.b>> {
    private w bIX;
    private LikeModel bJy;
    private u feo;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.fgB);
        this.mH = tbPageContext;
        this.bJy = new LikeModel(tbPageContext);
        this.feo = new u();
        this.feo.a(new u.a() { // from class: com.baidu.tieba.personPolymeric.a.a.1
            @Override // com.baidu.tieba.tbadkCore.u.a
            public void k(String str, long j) {
            }

            @Override // com.baidu.tieba.tbadkCore.u.a
            public void l(String str, long j) {
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.view.b bVar = new com.baidu.tieba.personPolymeric.view.b(this.mH);
        bVar.a(this.bJy);
        bVar.a(this.feo);
        bVar.a(this.bIX);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.b> aVar) {
        aVar.Yn().a(bVar);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
