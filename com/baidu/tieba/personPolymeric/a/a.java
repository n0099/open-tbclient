package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.w;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.b, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.b>> {
    private w bQQ;
    private LikeModel bRr;
    private v fnb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.b.fpx);
        this.mPageContext = tbPageContext;
        this.bRr = new LikeModel(tbPageContext);
        this.fnb = new v();
        this.fnb.a(new v.a() { // from class: com.baidu.tieba.personPolymeric.a.a.1
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void l(String str, long j) {
            }

            @Override // com.baidu.tieba.tbadkCore.v.a
            public void m(String str, long j) {
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.view.b bVar = new com.baidu.tieba.personPolymeric.view.b(this.mPageContext);
        bVar.a(this.bRr);
        bVar.a(this.fnb);
        bVar.a(this.bQQ);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.b> aVar) {
        aVar.aaJ().a(bVar);
        aVar.aaJ().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
