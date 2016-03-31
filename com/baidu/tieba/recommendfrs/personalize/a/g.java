package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ay;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements cj {
    final /* synthetic */ f dYc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dYc = fVar;
    }

    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        ay ayVar;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        ay ayVar2;
        ay ayVar3;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        cf.Lx().cc(true);
        ayVar = this.dYc.dXY;
        if (ayVar != null && view != null && (bVar instanceof com.baidu.tieba.card.a.t)) {
            fVar = this.dYc.dXZ;
            if (fVar != null) {
                com.baidu.tieba.card.a.t tVar = (com.baidu.tieba.card.a.t) bVar;
                if (tVar.aVJ != null) {
                    if ((view.getTag() instanceof String) && tVar.LC() != null && tVar.LC().getId() != null && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(tVar.LC().getTid(), 0L))) {
                        com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(tVar.LC().getTid(), 0L));
                        fVar2 = this.dYc.dXZ;
                        fVar2.a(com.baidu.adp.lib.h.b.c(tVar.LC().getTid(), 0L), tVar.getWeight(), tVar.getSource(), tVar.Ly(), tVar.LA(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new aw("c11004").ac("tid", tVar.aVJ.getTid()));
                        return;
                    }
                    int id = view.getId();
                    ayVar2 = this.dYc.dXY;
                    if (id == ayVar2.aSy.getId()) {
                        TiebaStatic.log(new aw("c10803").r("obj_locate", 7).ac("tid", tVar.aVJ.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    ayVar3 = this.dYc.dXY;
                    if (id2 == ayVar3.getView().getId()) {
                        TiebaStatic.log(new aw("c11004").ac("tid", tVar.aVJ.getTid()));
                        TiebaStatic.log(new aw("c10806").r("obj_locate", 1).ac("tid", tVar.aVJ.getId()));
                        return;
                    }
                    TiebaStatic.log(new aw("c11004").ac("tid", tVar.aVJ.getTid()));
                }
            }
        }
    }
}
