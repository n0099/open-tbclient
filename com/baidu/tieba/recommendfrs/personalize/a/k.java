package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.a.v;
import com.baidu.tieba.card.aw;
import com.baidu.tieba.card.ax;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<v, a> {
    private TbPageContext<?> Nw;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.aSL);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public a b(ViewGroup viewGroup) {
        aw awVar = new aw(this.Nw);
        awVar.n("c10718", "c10719", "c10742");
        return new a(awVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, v vVar, a aVar) {
        aVar.dGq.d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        aVar.dGq.a(vVar);
        ax.Kc().a(new au("c10718").aa("obj_id", String.valueOf(vVar.aSM)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public aw dGq;

        public a(aw awVar) {
            super(awVar.getView());
            this.dGq = awVar;
        }
    }
}
