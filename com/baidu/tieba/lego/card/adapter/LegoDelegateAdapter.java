package com.baidu.tieba.lego.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.j0.j1.o.b;
import d.b.j0.j1.o.g.a;
import d.b.j0.j1.o.l.e;
/* loaded from: classes4.dex */
public class LegoDelegateAdapter extends a<LegoDelegateViewHolder> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public ICardInfo p;

    /* loaded from: classes4.dex */
    public static class LegoDelegateViewHolder extends TypeAdapter.ViewHolder {
        public LegoDelegateViewHolder(e<?> eVar) {
            super((View) eVar);
        }
    }

    public LegoDelegateAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.o = tbPageContext;
        this.m = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View I(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.p = iCardInfo;
        return super.I(i, view, viewGroup, iCardInfo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public LegoDelegateViewHolder R(ViewGroup viewGroup) {
        e a2 = b.h().a(this.o, this.p, this.m);
        if (a2 == null) {
            return null;
        }
        a2.l(this.n);
        return new LegoDelegateViewHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, LegoDelegateViewHolder legoDelegateViewHolder) {
        e eVar = (e) legoDelegateViewHolder.a();
        ICardInfo iCardInfo2 = this.p;
        if (eVar != null && iCardInfo2 != null) {
            eVar.setPosition(i);
            eVar.c(iCardInfo2);
        }
        return (View) eVar;
    }

    @Override // d.b.j0.j1.f
    public final void setUniqueId(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }
}
