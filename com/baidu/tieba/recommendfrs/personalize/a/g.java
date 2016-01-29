package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements bb<q> {
    final /* synthetic */ f dGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dGn = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, q qVar) {
        af afVar;
        af afVar2;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        af afVar3;
        af afVar4;
        af afVar5;
        af afVar6;
        af afVar7;
        af afVar8;
        af afVar9;
        af afVar10;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        if (view != null) {
            afVar = this.dGn.bJz;
            if (afVar != null) {
                afVar2 = this.dGn.bJz;
                if (afVar2.getView() != null) {
                    fVar = this.dGn.dGm;
                    if (fVar != null && qVar != null && qVar.Ki() != null && !StringUtils.isNull(qVar.Ki().getTid())) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.e.bH(com.baidu.adp.lib.h.b.c(qVar.Ki().getTid(), 0L))) {
                            com.baidu.tieba.recommendfrs.e.bG(com.baidu.adp.lib.h.b.c(qVar.Ki().getTid(), 0L));
                            fVar2 = this.dGn.dGm;
                            fVar2.a(com.baidu.adp.lib.h.b.c(qVar.Ki().getTid(), 0L), qVar.getWeight(), qVar.getSource(), qVar.Ke(), qVar.Kg(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        afVar3 = this.dGn.bJz;
                        if (id != afVar3.getView().getId()) {
                            afVar4 = this.dGn.bJz;
                            if (afVar4.aPw != null) {
                                int id2 = view.getId();
                                afVar10 = this.dGn.bJz;
                                if (id2 == afVar10.aPw.getId()) {
                                    TiebaStatic.log(qVar.Ky());
                                    return;
                                }
                            }
                            afVar5 = this.dGn.bJz;
                            if (afVar5.aQk != null) {
                                int id3 = view.getId();
                                afVar9 = this.dGn.bJz;
                                if (id3 == afVar9.aQk.getId()) {
                                    TiebaStatic.log(qVar.Kw());
                                    return;
                                }
                            }
                            afVar6 = this.dGn.bJz;
                            if (afVar6.aPz != null) {
                                afVar7 = this.dGn.bJz;
                                if (afVar7.aPz.getBarNameTv() != null) {
                                    int id4 = view.getId();
                                    afVar8 = this.dGn.bJz;
                                    if (id4 == afVar8.aPz.getBarNameTv().getId()) {
                                        TiebaStatic.log(qVar.Kv());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(qVar.Kx());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(qVar.Ku());
                    }
                }
            }
        }
    }
}
