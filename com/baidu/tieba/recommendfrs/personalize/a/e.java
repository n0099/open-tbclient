package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.an;
import com.baidu.tieba.card.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements bb<r> {
    final /* synthetic */ d dGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dGl = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, r rVar) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        an anVar6;
        an anVar7;
        an anVar8;
        an anVar9;
        if (view != null) {
            anVar = this.dGl.bJE;
            if (anVar != null) {
                anVar2 = this.dGl.bJE;
                if (anVar2.getView() != null) {
                    anVar3 = this.dGl.bJE;
                    if (anVar3.aQw != null && rVar != null && rVar.Ki() != null && !StringUtils.isNull(rVar.Ki().getTid())) {
                        int id = view.getId();
                        anVar4 = this.dGl.bJE;
                        if (id != anVar4.getView().getId()) {
                            anVar5 = this.dGl.bJE;
                            if (anVar5.aQw.aQF != null) {
                                anVar8 = this.dGl.bJE;
                                if (anVar8.aQw.aQF.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    anVar9 = this.dGl.bJE;
                                    if (id2 == anVar9.aQw.aQF.getBarNameTv().getId()) {
                                        TiebaStatic.log(rVar.KC());
                                        return;
                                    }
                                }
                            }
                            anVar6 = this.dGl.bJE;
                            if (anVar6.aQw.aQB != null) {
                                int id3 = view.getId();
                                anVar7 = this.dGl.bJE;
                                if (id3 == anVar7.aQw.aQB.getId()) {
                                    TiebaStatic.log(rVar.KD());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(rVar.KA());
                    }
                }
            }
        }
    }
}
