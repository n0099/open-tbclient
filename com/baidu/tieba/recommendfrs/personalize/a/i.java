package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.s;
import com.baidu.tieba.card.ar;
import com.baidu.tieba.card.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bb<s> {
    final /* synthetic */ h dGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dGo = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, s sVar) {
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        ar arVar;
        ar arVar2;
        ar arVar3;
        ar arVar4;
        ar arVar5;
        ar arVar6;
        ar arVar7;
        ar arVar8;
        ar arVar9;
        ar arVar10;
        ar arVar11;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        fVar = this.dGo.dGm;
        if (fVar != null && sVar != null && sVar.Ki() != null && !StringUtils.isNull(sVar.Ki().getTid())) {
            arVar = this.dGo.bJH;
            if (arVar != null) {
                arVar2 = this.dGo.bJH;
                if (arVar2.aQH != null) {
                    arVar3 = this.dGo.bJH;
                    if (arVar3.getView() != null) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.e.bH(com.baidu.adp.lib.h.b.c(sVar.Ki().getTid(), 0L))) {
                            com.baidu.tieba.recommendfrs.e.bG(com.baidu.adp.lib.h.b.c(sVar.Ki().getTid(), 0L));
                            fVar2 = this.dGo.dGm;
                            fVar2.a(com.baidu.adp.lib.h.b.c(sVar.Ki().getTid(), 0L), sVar.getWeight(), sVar.getSource(), sVar.Ke(), sVar.Kg(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        arVar4 = this.dGo.bJH;
                        if (id != arVar4.getView().getId()) {
                            arVar5 = this.dGo.bJH;
                            if (arVar5.aQH.aQP != null) {
                                arVar10 = this.dGo.bJH;
                                if (arVar10.aQH.aQP.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    arVar11 = this.dGo.bJH;
                                    if (id2 == arVar11.aQH.aQP.getBarNameTv().getId()) {
                                        TiebaStatic.log(sVar.Kv());
                                        return;
                                    }
                                }
                            }
                            arVar6 = this.dGo.bJH;
                            if (arVar6.aQH.aQB != null) {
                                int id3 = view.getId();
                                arVar9 = this.dGo.bJH;
                                if (id3 == arVar9.aQH.aQB.getId()) {
                                    TiebaStatic.log(sVar.Kw());
                                    return;
                                }
                            }
                            arVar7 = this.dGo.bJH;
                            if (arVar7.aQH.aQM != null) {
                                int id4 = view.getId();
                                arVar8 = this.dGo.bJH;
                                if (id4 == arVar8.aQH.aQM.getId()) {
                                    TiebaStatic.log(sVar.KE());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(sVar.Ku());
                    }
                }
            }
        }
    }
}
