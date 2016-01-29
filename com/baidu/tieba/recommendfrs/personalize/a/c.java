package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.card.ax;
import com.baidu.tieba.card.w;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.c, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private w dGj;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.f.dEK);
        this.Nw = tbPageContext;
        this.dGj = new w(this.Nw);
        this.dGj.i("c10714", "c10739", "c10712", "c10738");
        this.dGj.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
        if (this.dGj != null) {
            this.dGj.i(this.aPF);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.c cVar, a aVar) {
        if (aVar.dGh == null) {
            return null;
        }
        aVar.dGh.a((m) cVar);
        ax.Kc().a(new au("c10714").aa("obj_param3", ae.JU()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public a b(ViewGroup viewGroup) {
        if (this.dGj == null) {
            this.dGj = new w(this.Nw);
            this.dGj.i(this.aPF);
            this.dGj.i("c10714", "c10739", "c10712", "c10738");
        }
        return new a(this.dGj);
    }

    public void onChangeSkinType(int i) {
        if (this.dGj != null) {
            this.dGj.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public w dGh;

        public a(w wVar) {
            super(wVar.getView());
            this.dGh = wVar;
        }
    }
}
