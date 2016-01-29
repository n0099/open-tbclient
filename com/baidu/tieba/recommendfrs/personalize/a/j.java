package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.a.u;
import com.baidu.tieba.card.av;
import com.baidu.tieba.card.ax;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<u, a> {
    private TbPageContext<?> Nw;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), u.aSH);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public a b(ViewGroup viewGroup) {
        av avVar = new av(this.Nw);
        avVar.an("c10716", "c10717");
        return new a(avVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, u uVar, a aVar) {
        if (uVar != null) {
            uVar.aSK = i + 1;
            aVar.brt.d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        }
        aVar.brt.a(uVar);
        ax.Kc().gQ("c10716");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public av brt;

        public a(av avVar) {
            super(avVar.getView());
            this.brt = avVar;
        }
    }
}
