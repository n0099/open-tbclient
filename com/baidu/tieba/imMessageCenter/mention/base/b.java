package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<a, com.baidu.tieba.card.a.a<c>> {
    private ab ahv;
    private TbPageContext<?> eIc;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.eIc = tbPageContext;
    }

    public void setOnCardSubClickListener(ab abVar) {
        this.ahv = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<c> c(ViewGroup viewGroup) {
        c cVar = new c(this.eIc, viewGroup);
        if (this.ahv != null) {
            cVar.c(this.ahv);
        }
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, a aVar, com.baidu.tieba.card.a.a<c> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.coY() == null) {
            return null;
        }
        aVar2.coY().a(aVar);
        return aVar2.getView();
    }

    @Override // com.baidu.adp.widget.ListView.a
    public com.baidu.adp.widget.ListView.ab qN() {
        return super.qN();
    }
}
