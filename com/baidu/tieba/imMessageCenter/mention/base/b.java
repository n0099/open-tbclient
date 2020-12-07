package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<a, com.baidu.tieba.card.a.a<c>> {
    private ab aix;
    private TbPageContext<?> eNx;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.eNx = tbPageContext;
    }

    public void setOnCardSubClickListener(ab abVar) {
        this.aix = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<c> c(ViewGroup viewGroup) {
        c cVar = new c(this.eNx, viewGroup);
        if (this.aix != null) {
            cVar.c(this.aix);
        }
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, a aVar, com.baidu.tieba.card.a.a<c> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.csM() == null) {
            return null;
        }
        aVar2.csM().a(aVar);
        return aVar2.getView();
    }

    @Override // com.baidu.adp.widget.ListView.a
    public com.baidu.adp.widget.ListView.ab qP() {
        return super.qP();
    }
}
