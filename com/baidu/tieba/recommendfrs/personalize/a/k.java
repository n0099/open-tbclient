package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.am;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements by {
    final /* synthetic */ j ebm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ebm = jVar;
    }

    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        am amVar;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        am amVar2;
        am amVar3;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        bx.Ki().ci(true);
        amVar = this.ebm.ebl;
        if (amVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.a.n)) {
            fVar = this.ebm.ebi;
            if (fVar != null) {
                com.baidu.tieba.card.a.n nVar = (com.baidu.tieba.card.a.n) bVar;
                if (nVar.aRZ != null) {
                    if ((view.getTag() instanceof String) && nVar.Kn() != null && nVar.Kn().getId() != null && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(nVar.Kn().getTid(), 0L))) {
                        com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(nVar.Kn().getTid(), 0L));
                        fVar2 = this.ebm.ebi;
                        fVar2.a(com.baidu.adp.lib.h.b.c(nVar.Kn().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Kj(), nVar.Kl(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new aw("c11004").ac("tid", nVar.aRZ.getTid()));
                        return;
                    }
                    int id = view.getId();
                    amVar2 = this.ebm.ebl;
                    if (id == amVar2.aOX.getId()) {
                        TiebaStatic.log(new aw("c10803").s("obj_locate", 7).ac("tid", nVar.aRZ.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    amVar3 = this.ebm.ebl;
                    if (id2 == amVar3.getView().getId()) {
                        TiebaStatic.log(new aw("c11004").ac("tid", nVar.aRZ.getTid()));
                        TiebaStatic.log(new aw("c10806").s("obj_locate", 1).ac("tid", nVar.aRZ.getId()));
                        return;
                    }
                    TiebaStatic.log(new aw("c11004").ac("tid", nVar.aRZ.getTid()));
                }
            }
        }
    }
}
