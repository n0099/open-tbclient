package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<a, com.baidu.tieba.card.a.a<c>> {
    private ad eFa;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.mContext = tbPageContext;
    }

    public void e(ad adVar) {
        this.eFa = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<c> onCreateViewHolder(ViewGroup viewGroup) {
        c cVar = new c(this.mContext, viewGroup);
        if (this.eFa != null) {
            cVar.b(this.eFa);
        }
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, a aVar, com.baidu.tieba.card.a.a<c> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.aja() == null) {
            return null;
        }
        aVar2.aja().a(aVar);
        return aVar2.getView();
    }

    @Override // com.baidu.adp.widget.ListView.a
    public n getOnAdapterItemClickListener() {
        return super.getOnAdapterItemClickListener();
    }
}
