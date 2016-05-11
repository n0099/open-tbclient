package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.f;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.k;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private by<f> boM;
    private k eaT;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = new c(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public a b(ViewGroup viewGroup) {
        this.eaT = new k(this.DV);
        this.eaT.aOC = false;
        this.eaT.j(this.aOT);
        return new a(this.eaT);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        aVar.eaV.a(fVar);
        aVar.eaV.a(this.boM);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public k eaV;

        public a(k kVar) {
            super(kVar.getView());
            this.eaV = kVar;
        }
    }
}
