package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements cj<com.baidu.tieba.card.a.v> {
    final /* synthetic */ r dYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.dYq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.v vVar) {
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        al alVar;
        al alVar2;
        al alVar3;
        al alVar4;
        al alVar5;
        al alVar6;
        al alVar7;
        al alVar8;
        al alVar9;
        al alVar10;
        al alVar11;
        al alVar12;
        al alVar13;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        cf.Lx().cc(true);
        fVar = this.dYq.dYi;
        if (fVar != null && vVar != null && vVar.LC() != null && !StringUtils.isNull(vVar.LC().getTid())) {
            alVar = this.dYq.dYp;
            if (alVar != null) {
                alVar2 = this.dYq.dYp;
                if (alVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(vVar.LC().getTid(), 0L))) {
                        com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(vVar.LC().getTid(), 0L));
                        fVar2 = this.dYq.dYi;
                        fVar2.a(com.baidu.adp.lib.h.b.c(vVar.LC().getTid(), 0L), vVar.getWeight(), vVar.getSource(), vVar.Ly(), vVar.LA(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    alVar3 = this.dYq.dYp;
                    if (id != alVar3.getView().getId()) {
                        alVar4 = this.dYq.dYp;
                        if (alVar4.aTp != null) {
                            alVar12 = this.dYq.dYp;
                            if (alVar12.aTp.getBarNameTv() != null) {
                                int id2 = view.getId();
                                alVar13 = this.dYq.dYp;
                                if (id2 == alVar13.aTp.getBarNameTv().getId()) {
                                    TiebaStatic.log(vVar.LP());
                                    return;
                                }
                            }
                        }
                        alVar5 = this.dYq.dYp;
                        if (alVar5.aTo != null) {
                            int id3 = view.getId();
                            alVar11 = this.dYq.dYp;
                            if (id3 == alVar11.aTo.getId()) {
                                TiebaStatic.log(vVar.LQ());
                                return;
                            }
                        }
                        alVar6 = this.dYq.dYp;
                        if (alVar6.aTr != null) {
                            alVar9 = this.dYq.dYp;
                            if (alVar9.aTr.ahM != null) {
                                int id4 = view.getId();
                                alVar10 = this.dYq.dYp;
                                if (id4 == alVar10.aTr.ahM.getId()) {
                                    TiebaStatic.log(vVar.LQ());
                                    return;
                                }
                            }
                        }
                        alVar7 = this.dYq.dYp;
                        if (alVar7.aTq != null) {
                            int id5 = view.getId();
                            alVar8 = this.dYq.dYp;
                            if (id5 == alVar8.aTq.getId()) {
                                TiebaStatic.log(vVar.LY());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(vVar.LO());
                }
            }
        }
    }
}
