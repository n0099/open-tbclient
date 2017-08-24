package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.w;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.c, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.a>> {
    private w bGk;
    private com.baidu.adp.lib.e.b<com.baidu.tieba.personPolymeric.d.n> fkf;
    private TbPageContext<?> oW;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.c.fmg);
        this.fkf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.personPolymeric.d.n>() { // from class: com.baidu.tieba.personPolymeric.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aYE */
            public com.baidu.tieba.personPolymeric.d.n fT() {
                return new com.baidu.tieba.personPolymeric.d.n(b.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(com.baidu.tieba.personPolymeric.d.n nVar) {
                if (nVar != null) {
                    nVar.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.personPolymeric.d.n p(com.baidu.tieba.personPolymeric.d.n nVar) {
                return nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.personPolymeric.d.n q(com.baidu.tieba.personPolymeric.d.n nVar) {
                return nVar;
            }
        }, 12, 0);
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.d.a aVar = new com.baidu.tieba.personPolymeric.d.a(this.oW);
        aVar.setForumCardItemViewPool(this.fkf);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.d.a> aVar) {
        aVar.Xv().a(this.bGk);
        aVar.Xv().d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        aVar.Xv().a(cVar);
        return aVar.getView();
    }
}
