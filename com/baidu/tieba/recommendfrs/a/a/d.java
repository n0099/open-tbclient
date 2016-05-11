package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.f;
import com.baidu.tieba.card.a.g;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.j;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<g, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private by<f> boM;
    private j eaW;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = new e(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public a b(ViewGroup viewGroup) {
        this.eaW = new j(this.DV);
        this.eaW.i(this.aOT);
        return new a(this.eaW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        aVar.eaY.a(gVar);
        if (aVar.eaY.JQ() != null) {
            aVar.eaY.JQ().a(this.boM);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public j eaY;

        public a(j jVar) {
            super(jVar.getView());
            this.eaY = jVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }
}
