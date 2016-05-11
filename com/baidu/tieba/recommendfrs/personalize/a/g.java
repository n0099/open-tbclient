package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements by {
    final /* synthetic */ f ebj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.ebj = fVar;
    }

    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        aq aqVar;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        aq aqVar2;
        aq aqVar3;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        bx.Kg().ci(true);
        aqVar = this.ebj.ebh;
        if (aqVar != null && view != null && (bVar instanceof com.baidu.tieba.card.a.l)) {
            fVar = this.ebj.ebi;
            if (fVar != null) {
                com.baidu.tieba.card.a.l lVar = (com.baidu.tieba.card.a.l) bVar;
                if (lVar.aRG != null) {
                    if ((view.getTag() instanceof String) && lVar.Kl() != null && lVar.Kl().getId() != null && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(lVar.Kl().getTid(), 0L))) {
                        com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(lVar.Kl().getTid(), 0L));
                        fVar2 = this.ebj.ebi;
                        fVar2.a(com.baidu.adp.lib.h.b.c(lVar.Kl().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Kh(), lVar.Kj(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new aw("c11004").ac("tid", lVar.aRG.getTid()));
                        return;
                    }
                    int id = view.getId();
                    aqVar2 = this.ebj.ebh;
                    if (id == aqVar2.aOX.getId()) {
                        TiebaStatic.log(new aw("c10803").s("obj_locate", 7).ac("tid", lVar.aRG.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    aqVar3 = this.ebj.ebh;
                    if (id2 == aqVar3.getView().getId()) {
                        TiebaStatic.log(new aw("c11004").ac("tid", lVar.aRG.getTid()));
                        TiebaStatic.log(new aw("c10806").s("obj_locate", 1).ac("tid", lVar.aRG.getId()));
                        return;
                    }
                    TiebaStatic.log(new aw("c11004").ac("tid", lVar.aRG.getTid()));
                }
            }
        }
    }
}
