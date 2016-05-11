package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bl;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.m, a> {
    private TbPageContext<?> DV;
    private BdUniqueId aOT;
    private bl bUC;
    private by boM;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = new e(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public a b(ViewGroup viewGroup) {
        this.bUC = new bl(this.DV);
        this.bUC.i(this.aOT);
        return new a(this.bUC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.m mVar, a aVar) {
        if (aVar == null || aVar.bUE == null) {
            return null;
        }
        if (mVar != null) {
            mVar.fx(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.bUE.a(mVar);
        if (mVar != null) {
            bx.Kg().a(mVar.KE());
        }
        aVar.bUE.a(this.boM);
        return aVar.getView();
    }

    private aw b(com.baidu.tieba.card.a.m mVar) {
        if (mVar == null || mVar.Kl() == null) {
            return null;
        }
        return new aw("c10732").ac("fid", String.valueOf(mVar.Kl().getFid())).ac("tid", String.valueOf(mVar.Kl().getTid())).ac("obj_param1", mVar.getWeight()).ac("obj_source", mVar.getSource()).s("obj_locate", mVar.Kh()).s("obj_type", mVar.KC());
    }

    private aw c(com.baidu.tieba.card.a.m mVar) {
        if (mVar == null || mVar.Kl() == null) {
            return null;
        }
        return new aw("c10707").ac("fid", String.valueOf(mVar.Kl().getFid())).ac("tid", String.valueOf(mVar.Kl().getTid())).ac("obj_param1", mVar.getWeight()).ac("obj_source", mVar.getSource()).s("obj_locate", mVar.Kh()).s("obj_type", mVar.KC());
    }

    private aw d(com.baidu.tieba.card.a.m mVar) {
        if (mVar == null || mVar.Kl() == null) {
            return null;
        }
        return new aw("c10733").ac("fid", String.valueOf(mVar.Kl().getFid())).ac("tid", String.valueOf(mVar.Kl().getTid())).ac("obj_param1", mVar.getWeight()).ac("obj_source", mVar.getSource()).s("obj_locate", mVar.Kh()).s("obj_type", mVar.KC());
    }

    private aw e(com.baidu.tieba.card.a.m mVar) {
        if (mVar == null || mVar.Kl() == null) {
            return null;
        }
        return new aw("c10706").ac("fid", String.valueOf(mVar.Kl().getFid())).ac("tid", String.valueOf(mVar.Kl().getTid())).ac("obj_param1", mVar.getWeight()).ac("obj_source", mVar.getSource()).s("obj_locate", mVar.Kh()).s("obj_type", mVar.KC());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bl bUE;

        public a(bl blVar) {
            super(blVar.getView());
            this.bUE = blVar;
        }
    }
}
