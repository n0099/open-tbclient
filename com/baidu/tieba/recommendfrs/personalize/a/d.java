package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bt;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.u, a> {
    private TbPageContext<?> ND;
    private BdUniqueId aSu;
    private bt bUa;
    private cj dXK;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dXK = new e(this);
        this.ND = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public a b(ViewGroup viewGroup) {
        this.bUa = new bt(this.ND);
        this.bUa.i(this.aSu);
        return new a(this.bUa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.u uVar, a aVar) {
        if (aVar == null || aVar.bUc == null) {
            return null;
        }
        if (uVar != null) {
            uVar.fP(i + 1);
            uVar.b(b(uVar));
            uVar.c(c(uVar));
            uVar.d(e(uVar));
            uVar.e(d(uVar));
        }
        aVar.bUc.a(uVar);
        if (uVar != null) {
            cf.Lx().a(uVar.LV());
        }
        aVar.bUc.a(this.dXK);
        return aVar.getView();
    }

    private aw b(com.baidu.tieba.card.a.u uVar) {
        if (uVar == null || uVar.LC() == null) {
            return null;
        }
        return new aw("c10732").ac("fid", String.valueOf(uVar.LC().getFid())).ac("tid", String.valueOf(uVar.LC().getTid())).ac("obj_param1", uVar.getWeight()).ac("obj_source", uVar.getSource()).r("obj_locate", uVar.Ly()).r("obj_type", uVar.LT());
    }

    private aw c(com.baidu.tieba.card.a.u uVar) {
        if (uVar == null || uVar.LC() == null) {
            return null;
        }
        return new aw("c10707").ac("fid", String.valueOf(uVar.LC().getFid())).ac("tid", String.valueOf(uVar.LC().getTid())).ac("obj_param1", uVar.getWeight()).ac("obj_source", uVar.getSource()).r("obj_locate", uVar.Ly()).r("obj_type", uVar.LT());
    }

    private aw d(com.baidu.tieba.card.a.u uVar) {
        if (uVar == null || uVar.LC() == null) {
            return null;
        }
        return new aw("c10733").ac("fid", String.valueOf(uVar.LC().getFid())).ac("tid", String.valueOf(uVar.LC().getTid())).ac("obj_param1", uVar.getWeight()).ac("obj_source", uVar.getSource()).r("obj_locate", uVar.Ly()).r("obj_type", uVar.LT());
    }

    private aw e(com.baidu.tieba.card.a.u uVar) {
        if (uVar == null || uVar.LC() == null) {
            return null;
        }
        return new aw("c10706").ac("fid", String.valueOf(uVar.LC().getFid())).ac("tid", String.valueOf(uVar.LC().getTid())).ac("obj_param1", uVar.getWeight()).ac("obj_source", uVar.getSource()).r("obj_locate", uVar.Ly()).r("obj_type", uVar.LT());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public bt bUc;

        public a(bt btVar) {
            super(btVar.getView());
            this.bUc = btVar;
        }
    }
}
