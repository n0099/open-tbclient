package com.baidu.tieba.lego.card.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.lego.card.a.a<a> {
    public BdUniqueId cnX;
    private ICardInfo gGB;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.gGA = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        e a2 = com.baidu.tieba.lego.card.b.bzH().a(this.mPageContext, this.gGB, this.gGA);
        if (a2 == null) {
            return null;
        }
        a2.i(this.cnX);
        return new a(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, a aVar) {
        e eVar = (e) aVar.getView();
        ICardInfo iCardInfo2 = this.gGB;
        if (eVar != null && iCardInfo2 != null) {
            eVar.setPosition(i);
            eVar.aq(iCardInfo2);
        }
        return (View) eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.gGB = iCardInfo;
        return super.getView(i, view, viewGroup, iCardInfo);
    }

    @Override // com.baidu.tieba.lego.f
    public final void setUniqueId(BdUniqueId bdUniqueId) {
        this.cnX = bdUniqueId;
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        e<?> fqm;

        public a(e<?> eVar) {
            super((View) eVar);
            this.fqm = eVar;
        }
    }
}
