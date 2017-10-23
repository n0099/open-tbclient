package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.w;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.c, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.a>> {
    private w bIX;
    private com.baidu.adp.lib.e.b<com.baidu.tieba.personPolymeric.view.n> feq;
    private TbPageContext<?> mH;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.c.fgF);
        this.feq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.personPolymeric.view.n>() { // from class: com.baidu.tieba.personPolymeric.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aWq */
            public com.baidu.tieba.personPolymeric.view.n fI() {
                return new com.baidu.tieba.personPolymeric.view.n(b.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(com.baidu.tieba.personPolymeric.view.n nVar) {
                if (nVar != null) {
                    nVar.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.personPolymeric.view.n o(com.baidu.tieba.personPolymeric.view.n nVar) {
                return nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.personPolymeric.view.n p(com.baidu.tieba.personPolymeric.view.n nVar) {
                return nVar;
            }
        }, 12, 0);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.view.a aVar = new com.baidu.tieba.personPolymeric.view.a(this.mH);
        aVar.setForumCardItemViewPool(this.feq);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.a> aVar) {
        aVar.Yn().a(this.bIX);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        aVar.Yn().a(cVar);
        return aVar.getView();
    }
}
