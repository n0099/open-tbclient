package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bl;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements by<com.baidu.tieba.card.a.m> {
    final /* synthetic */ d ebg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ebg = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.m mVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        bl blVar10;
        bl blVar11;
        bl blVar12;
        bx.Kg().ci(true);
        if (view != null) {
            blVar = this.ebg.bUC;
            if (blVar != null) {
                blVar2 = this.ebg.bUC;
                if (blVar2.getView() != null) {
                    blVar3 = this.ebg.bUC;
                    if (blVar3.aQD != null && mVar != null && mVar.Kl() != null && !StringUtils.isNull(mVar.Kl().getTid())) {
                        int id = view.getId();
                        blVar4 = this.ebg.bUC;
                        if (id != blVar4.getView().getId()) {
                            blVar5 = this.ebg.bUC;
                            if (blVar5.aQD.aQM != null) {
                                blVar11 = this.ebg.bUC;
                                if (blVar11.aQD.aQM.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    blVar12 = this.ebg.bUC;
                                    if (id2 == blVar12.aQD.aQM.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.KF());
                                        return;
                                    }
                                }
                            }
                            blVar6 = this.ebg.bUC;
                            if (blVar6.aQD.aPC != null) {
                                int id3 = view.getId();
                                blVar10 = this.ebg.bUC;
                                if (id3 == blVar10.aQD.aPC.getId()) {
                                    TiebaStatic.log(mVar.KG());
                                    return;
                                }
                            }
                            blVar7 = this.ebg.bUC;
                            if (blVar7.aQD.aQp != null) {
                                blVar8 = this.ebg.bUC;
                                if (blVar8.aQD.aQp.adG != null) {
                                    blVar9 = this.ebg.bUC;
                                    if (blVar9.aQD.aQp.adG.getId() == view.getId()) {
                                        TiebaStatic.log(mVar.KG());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.KD());
                    }
                }
            }
        }
    }
}
