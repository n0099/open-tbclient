package com.baidu.tieba.lego.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes8.dex */
public class LegoDelegateAdapter extends a<LegoDelegateViewHolder> {
    public BdUniqueId fEN;
    private ICardInfo kTl;
    private TbPageContext<?> mPageContext;

    public LegoDelegateAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.mBusinessType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ck */
    public LegoDelegateViewHolder e(ViewGroup viewGroup) {
        e a2 = b.cZu().a(this.mPageContext, this.kTl, this.mBusinessType);
        if (a2 == null) {
            return null;
        }
        a2.l(this.fEN);
        return new LegoDelegateViewHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, LegoDelegateViewHolder legoDelegateViewHolder) {
        e eVar = (e) legoDelegateViewHolder.getView();
        ICardInfo iCardInfo2 = this.kTl;
        if (eVar != null && iCardInfo2 != null) {
            eVar.setPosition(i);
            eVar.aN(iCardInfo2);
        }
        return (View) eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.kTl = iCardInfo;
        return super.getView(i, view, viewGroup, iCardInfo);
    }

    @Override // com.baidu.tieba.lego.f
    public final void setUniqueId(BdUniqueId bdUniqueId) {
        this.fEN = bdUniqueId;
    }

    /* loaded from: classes8.dex */
    public static class LegoDelegateViewHolder extends TypeAdapter.ViewHolder {
        e<?> jyt;

        public LegoDelegateViewHolder(e<?> eVar) {
            super((View) eVar);
            this.jyt = eVar;
        }
    }
}
