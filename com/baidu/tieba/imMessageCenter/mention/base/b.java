package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.widget.ListView.a<a, com.baidu.tieba.card.a.a<c>> {
    private z Lh;
    private TbPageContext<?> cRe;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.cRe = tbPageContext;
    }

    public void setOnCardSubClickListener(z zVar) {
        this.Lh = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<c> b(ViewGroup viewGroup) {
        c cVar = new c(this.cRe, viewGroup);
        if (this.Lh != null) {
            cVar.c(this.Lh);
        }
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, a aVar, com.baidu.tieba.card.a.a<c> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.bue() == null) {
            return null;
        }
        aVar2.bue().a(aVar);
        return aVar2.getView();
    }

    @Override // com.baidu.adp.widget.ListView.a
    public s jU() {
        return super.jU();
    }
}
