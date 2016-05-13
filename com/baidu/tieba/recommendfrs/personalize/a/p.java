package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.j, a> {
    private TbPageContext<?> DV;
    public BdUniqueId aOT;
    private com.baidu.tieba.card.u ebs;
    private by<com.baidu.tieba.card.a.j> ebt;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.j.Oq);
        this.ebt = new q(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public a b(ViewGroup viewGroup) {
        this.ebs = new com.baidu.tieba.card.u(this.DV, this.aOT);
        return new a(this.ebs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.j jVar, a aVar) {
        this.ebs = aVar.ebv;
        aVar.ebv.d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        aVar.ebv.a(jVar);
        aVar.ebv.a(this.ebt);
        bx.Ki().a(new aw("c11006"));
        return aVar.getView();
    }

    public void oy(int i) {
        if (this.ebs != null) {
            this.ebs.d(this.DV, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.u ebv;

        public a(com.baidu.tieba.card.u uVar) {
            super(uVar.getView());
            this.ebv = uVar;
        }
    }
}
