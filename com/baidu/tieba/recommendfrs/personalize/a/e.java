package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bt;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements cj<com.baidu.tieba.card.a.u> {
    final /* synthetic */ d dXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dXX = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.u uVar) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        bt btVar7;
        bt btVar8;
        bt btVar9;
        bt btVar10;
        bt btVar11;
        bt btVar12;
        cf.Lx().cc(true);
        if (view != null) {
            btVar = this.dXX.bUa;
            if (btVar != null) {
                btVar2 = this.dXX.bUa;
                if (btVar2.getView() != null) {
                    btVar3 = this.dXX.bUa;
                    if (btVar3.aUj != null && uVar != null && uVar.LC() != null && !StringUtils.isNull(uVar.LC().getTid())) {
                        int id = view.getId();
                        btVar4 = this.dXX.bUa;
                        if (id != btVar4.getView().getId()) {
                            btVar5 = this.dXX.bUa;
                            if (btVar5.aUj.aUs != null) {
                                btVar11 = this.dXX.bUa;
                                if (btVar11.aUj.aUs.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    btVar12 = this.dXX.bUa;
                                    if (id2 == btVar12.aUj.aUs.getBarNameTv().getId()) {
                                        TiebaStatic.log(uVar.LW());
                                        return;
                                    }
                                }
                            }
                            btVar6 = this.dXX.bUa;
                            if (btVar6.aUj.aTo != null) {
                                int id3 = view.getId();
                                btVar10 = this.dXX.bUa;
                                if (id3 == btVar10.aUj.aTo.getId()) {
                                    TiebaStatic.log(uVar.LX());
                                    return;
                                }
                            }
                            btVar7 = this.dXX.bUa;
                            if (btVar7.aUj.aTV != null) {
                                btVar8 = this.dXX.bUa;
                                if (btVar8.aUj.aTV.ahM != null) {
                                    btVar9 = this.dXX.bUa;
                                    if (btVar9.aUj.aTV.ahM.getId() == view.getId()) {
                                        TiebaStatic.log(uVar.LX());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(uVar.LU());
                    }
                }
            }
        }
    }
}
