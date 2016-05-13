package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements by<com.baidu.tieba.card.a.n> {
    final /* synthetic */ r ebx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.ebx = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.n nVar) {
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        com.baidu.tieba.card.z zVar;
        com.baidu.tieba.card.z zVar2;
        com.baidu.tieba.card.z zVar3;
        com.baidu.tieba.card.z zVar4;
        com.baidu.tieba.card.z zVar5;
        com.baidu.tieba.card.z zVar6;
        com.baidu.tieba.card.z zVar7;
        com.baidu.tieba.card.z zVar8;
        com.baidu.tieba.card.z zVar9;
        com.baidu.tieba.card.z zVar10;
        com.baidu.tieba.card.z zVar11;
        com.baidu.tieba.card.z zVar12;
        com.baidu.tieba.card.z zVar13;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        bx.Ki().ci(true);
        fVar = this.ebx.ebp;
        if (fVar != null && nVar != null && nVar.Kn() != null && !StringUtils.isNull(nVar.Kn().getTid())) {
            zVar = this.ebx.ebw;
            if (zVar != null) {
                zVar2 = this.ebx.ebw;
                if (zVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(nVar.Kn().getTid(), 0L))) {
                        com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(nVar.Kn().getTid(), 0L));
                        fVar2 = this.ebx.ebp;
                        fVar2.a(com.baidu.adp.lib.h.b.c(nVar.Kn().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Kj(), nVar.Kl(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    zVar3 = this.ebx.ebw;
                    if (id != zVar3.getView().getId()) {
                        zVar4 = this.ebx.ebw;
                        if (zVar4.aPD != null) {
                            zVar12 = this.ebx.ebw;
                            if (zVar12.aPD.getBarNameTv() != null) {
                                int id2 = view.getId();
                                zVar13 = this.ebx.ebw;
                                if (id2 == zVar13.aPD.getBarNameTv().getId()) {
                                    TiebaStatic.log(nVar.KA());
                                    return;
                                }
                            }
                        }
                        zVar5 = this.ebx.ebw;
                        if (zVar5.aPC != null) {
                            int id3 = view.getId();
                            zVar11 = this.ebx.ebw;
                            if (id3 == zVar11.aPC.getId()) {
                                TiebaStatic.log(nVar.KB());
                                return;
                            }
                        }
                        zVar6 = this.ebx.ebw;
                        if (zVar6.aPF != null) {
                            zVar9 = this.ebx.ebw;
                            if (zVar9.aPF.adG != null) {
                                int id4 = view.getId();
                                zVar10 = this.ebx.ebw;
                                if (id4 == zVar10.aPF.adG.getId()) {
                                    TiebaStatic.log(nVar.KB());
                                    return;
                                }
                            }
                        }
                        zVar7 = this.ebx.ebw;
                        if (zVar7.aPE != null) {
                            int id5 = view.getId();
                            zVar8 = this.ebx.ebw;
                            if (id5 == zVar8.aPE.getId()) {
                                TiebaStatic.log(nVar.KJ());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(nVar.Kz());
                }
            }
        }
    }
}
