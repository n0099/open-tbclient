package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.an;
import com.baidu.tieba.card.ax;
import com.baidu.tieba.card.bb;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<r, a> {
    private TbPageContext<?> Nw;
    private BdUniqueId aPF;
    private an bJE;
    private bb dFY;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dFY = new e(this);
        this.Nw = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public a b(ViewGroup viewGroup) {
        this.bJE = new an(this.Nw);
        this.bJE.i(this.aPF);
        return new a(this.bJE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, r rVar, a aVar) {
        if (aVar == null || aVar.bJG == null) {
            return null;
        }
        if (rVar != null) {
            rVar.fB(i + 1);
            rVar.b(b(rVar));
            rVar.c(c(rVar));
            rVar.d(e(rVar));
            rVar.e(d(rVar));
        }
        aVar.bJG.a(rVar);
        if (rVar != null) {
            ax.Kc().a(rVar.KB());
        }
        aVar.bJG.a(this.dFY);
        return aVar.getView();
    }

    private au b(r rVar) {
        if (rVar == null || rVar.Ki() == null) {
            return null;
        }
        return new au("c10732").aa(ImageViewerConfig.FORUM_ID, String.valueOf(rVar.Ki().getFid())).aa("tid", String.valueOf(rVar.Ki().getTid())).aa("obj_param1", rVar.getWeight()).aa("obj_source", rVar.getSource()).r("obj_locate", rVar.Ke()).r("obj_type", rVar.Kz());
    }

    private au c(r rVar) {
        if (rVar == null || rVar.Ki() == null) {
            return null;
        }
        return new au("c10707").aa(ImageViewerConfig.FORUM_ID, String.valueOf(rVar.Ki().getFid())).aa("tid", String.valueOf(rVar.Ki().getTid())).aa("obj_param1", rVar.getWeight()).aa("obj_source", rVar.getSource()).r("obj_locate", rVar.Ke()).r("obj_type", rVar.Kz());
    }

    private au d(r rVar) {
        if (rVar == null || rVar.Ki() == null) {
            return null;
        }
        return new au("c10733").aa(ImageViewerConfig.FORUM_ID, String.valueOf(rVar.Ki().getFid())).aa("tid", String.valueOf(rVar.Ki().getTid())).aa("obj_param1", rVar.getWeight()).aa("obj_source", rVar.getSource()).r("obj_locate", rVar.Ke()).r("obj_type", rVar.Kz());
    }

    private au e(r rVar) {
        if (rVar == null || rVar.Ki() == null) {
            return null;
        }
        return new au("c10706").aa(ImageViewerConfig.FORUM_ID, String.valueOf(rVar.Ki().getFid())).aa("tid", String.valueOf(rVar.Ki().getTid())).aa("obj_param1", rVar.getWeight()).aa("obj_source", rVar.getSource()).r("obj_locate", rVar.Ke()).r("obj_type", rVar.Kz());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public an bJG;

        public a(an anVar) {
            super(anVar.getView());
            this.bJG = anVar;
        }
    }
}
