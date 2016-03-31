package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements cj {
    final /* synthetic */ j dYf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dYf = jVar;
    }

    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        au auVar;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        au auVar2;
        au auVar3;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        cf.Lx().cc(true);
        auVar = this.dYf.dYe;
        if (auVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.a.v)) {
            fVar = this.dYf.dXZ;
            if (fVar != null) {
                com.baidu.tieba.card.a.v vVar = (com.baidu.tieba.card.a.v) bVar;
                if (vVar.aWf != null) {
                    if ((view.getTag() instanceof String) && vVar.LC() != null && vVar.LC().getId() != null && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(vVar.LC().getTid(), 0L))) {
                        com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(vVar.LC().getTid(), 0L));
                        fVar2 = this.dYf.dXZ;
                        fVar2.a(com.baidu.adp.lib.h.b.c(vVar.LC().getTid(), 0L), vVar.getWeight(), vVar.getSource(), vVar.Ly(), vVar.LA(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new aw("c11004").ac("tid", vVar.aWf.getTid()));
                        return;
                    }
                    int id = view.getId();
                    auVar2 = this.dYf.dYe;
                    if (id == auVar2.aSy.getId()) {
                        TiebaStatic.log(new aw("c10803").r("obj_locate", 7).ac("tid", vVar.aWf.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    auVar3 = this.dYf.dYe;
                    if (id2 == auVar3.getView().getId()) {
                        TiebaStatic.log(new aw("c11004").ac("tid", vVar.aWf.getTid()));
                        TiebaStatic.log(new aw("c10806").r("obj_locate", 1).ac("tid", vVar.aWf.getId()));
                        return;
                    }
                    TiebaStatic.log(new aw("c11004").ac("tid", vVar.aWf.getTid()));
                }
            }
        }
    }
}
