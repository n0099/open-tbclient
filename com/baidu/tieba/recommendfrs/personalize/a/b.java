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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.b, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private w dGg;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.recommendfrs.data.b.dEI);
        this.Nw = tbPageContext;
        this.dGg = new w(this.Nw);
        this.dGg.i("c10715", "c10741", "c10713", "c10740");
        this.dGg.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
        if (this.dGg != null) {
            this.dGg.i(this.aPF);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.b bVar, a aVar) {
        if (aVar.dGh == null) {
            return null;
        }
        aVar.dGh.a((m) bVar);
        ax.Kc().a(new au("c10715").aa("obj_param3", ae.JU()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public a b(ViewGroup viewGroup) {
        if (this.dGg == null) {
            this.dGg = new w(this.Nw);
            this.dGg.i(this.aPF);
            this.dGg.i("c10715", "c10741", "c10713", "c10740");
        }
        return new a(this.dGg);
    }

    public void onChangeSkinType(int i) {
        if (this.dGg != null) {
            this.dGg.d(this.Nw, i);
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
