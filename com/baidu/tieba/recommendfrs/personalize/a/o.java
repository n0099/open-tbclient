package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements cj<com.baidu.tieba.card.a.t> {
    final /* synthetic */ l dYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.dYj = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.t tVar) {
        bd bdVar;
        bd bdVar2;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        bd bdVar3;
        bd bdVar4;
        bd bdVar5;
        bd bdVar6;
        bd bdVar7;
        bd bdVar8;
        bd bdVar9;
        bd bdVar10;
        bd bdVar11;
        bd bdVar12;
        bd bdVar13;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        cf.Lx().cc(true);
        if (view != null) {
            bdVar = this.dYj.dYh;
            if (bdVar != null) {
                bdVar2 = this.dYj.dYh;
                if (bdVar2.getView() != null) {
                    fVar = this.dYj.dYi;
                    if (fVar != null && tVar != null && tVar.LC() != null && !StringUtils.isNull(tVar.LC().getTid())) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(tVar.LC().getTid(), 0L))) {
                            com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(tVar.LC().getTid(), 0L));
                            fVar2 = this.dYj.dYi;
                            fVar2.a(com.baidu.adp.lib.h.b.c(tVar.LC().getTid(), 0L), tVar.getWeight(), tVar.getSource(), tVar.Ly(), tVar.LA(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        bdVar3 = this.dYj.dYh;
                        if (id != bdVar3.getView().getId()) {
                            bdVar4 = this.dYj.dYh;
                            if (bdVar4.aTU != null) {
                                int id2 = view.getId();
                                bdVar13 = this.dYj.dYh;
                                if (id2 == bdVar13.aTU.getId()) {
                                    TiebaStatic.log(tVar.LS());
                                    return;
                                }
                            }
                            bdVar5 = this.dYj.dYh;
                            if (bdVar5.aTT != null) {
                                int id3 = view.getId();
                                bdVar12 = this.dYj.dYh;
                                if (id3 == bdVar12.aTT.getId()) {
                                    TiebaStatic.log(tVar.LQ());
                                    return;
                                }
                            }
                            bdVar6 = this.dYj.dYh;
                            if (bdVar6.aTV != null) {
                                bdVar10 = this.dYj.dYh;
                                if (bdVar10.aTV.ahM != null) {
                                    int id4 = view.getId();
                                    bdVar11 = this.dYj.dYh;
                                    if (id4 == bdVar11.aTV.ahM.getId()) {
                                        TiebaStatic.log(tVar.LQ());
                                        return;
                                    }
                                }
                            }
                            bdVar7 = this.dYj.dYh;
                            if (bdVar7.aSp != null) {
                                bdVar8 = this.dYj.dYh;
                                if (bdVar8.aSp.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    bdVar9 = this.dYj.dYh;
                                    if (id5 == bdVar9.aSp.getBarNameTv().getId()) {
                                        TiebaStatic.log(tVar.LP());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(tVar.LR());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(tVar.LO());
                    }
                }
            }
        }
    }
}
