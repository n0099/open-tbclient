package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.widget.ListView.a<a, com.baidu.tieba.card.a.a<c>> {
    private aa afy;
    private TbPageContext<?> dVN;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.dVN = tbPageContext;
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.afy = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<c> b(ViewGroup viewGroup) {
        c cVar = new c(this.dVN, viewGroup);
        if (this.afy != null) {
            cVar.c(this.afy);
        }
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, a aVar, com.baidu.tieba.card.a.a<c> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.bSs() == null) {
            return null;
        }
        aVar2.bSs().a(aVar);
        return aVar2.getView();
    }

    @Override // com.baidu.adp.widget.ListView.a
    public z pj() {
        return super.pj();
    }
}
