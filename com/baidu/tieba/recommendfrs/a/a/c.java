package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements cj<i> {
    final /* synthetic */ b dXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dXL = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, i iVar) {
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        p pVar5;
        p pVar6;
        p pVar7;
        p pVar8;
        p pVar9;
        pVar = this.dXL.dXJ;
        if (pVar != null) {
            pVar2 = this.dXL.dXJ;
            if (pVar2.getView() != null && iVar != null && iVar.aVJ != null && iVar.aVJ.getId() != null) {
                int id = view.getId();
                pVar3 = this.dXL.dXJ;
                if (id == pVar3.getView().getId()) {
                    TiebaStatic.log(new aw("c10806").r("obj_locate", 2).ac("tid", iVar.aVJ.getId()));
                    return;
                }
                int id2 = view.getId();
                pVar4 = this.dXL.dXJ;
                if (id2 == pVar4.aSi.getId()) {
                    TiebaStatic.log(new aw("c10803").ac("tid", iVar.aVJ.getTid()).r("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                pVar5 = this.dXL.dXJ;
                if (id3 != pVar5.ahM.getId()) {
                    int id4 = view.getId();
                    pVar6 = this.dXL.dXJ;
                    if (id4 != pVar6.aSg.getId()) {
                        int id5 = view.getId();
                        pVar7 = this.dXL.dXJ;
                        if (id5 != pVar7.aSf.getId()) {
                            int id6 = view.getId();
                            pVar8 = this.dXL.dXJ;
                            if (id6 == pVar8.aSm.getId()) {
                                TiebaStatic.log(new aw("c11008").r("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new aw("c11008").r("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                pVar9 = this.dXL.dXJ;
                                if (id7 == pVar9.aSp.getBarNameTv().getId()) {
                                    TiebaStatic.log(new aw("c11008").r("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new aw("c11008").r("obj_locate", 1));
            }
        }
    }
}
