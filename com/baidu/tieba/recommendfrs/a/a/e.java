package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements cj<i> {
    final /* synthetic */ d dXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dXO = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, i iVar) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        o oVar5;
        o oVar6;
        o oVar7;
        o oVar8;
        o oVar9;
        oVar = this.dXO.dXN;
        if (oVar != null) {
            oVar2 = this.dXO.dXN;
            if (oVar2.aSc != null && iVar != null && iVar.aVJ != null && iVar.aVJ.getId() != null) {
                int id = view.getId();
                oVar3 = this.dXO.dXN;
                if (id == oVar3.aSc.getView().getId()) {
                    TiebaStatic.log(new aw("c10806").r("obj_locate", 2).ac("tid", iVar.aVJ.getId()));
                    return;
                }
                int id2 = view.getId();
                oVar4 = this.dXO.dXN;
                if (id2 == oVar4.aSc.aSi.getId()) {
                    TiebaStatic.log(new aw("c10803").ac("tid", iVar.aVJ.getTid()).r("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                oVar5 = this.dXO.dXN;
                if (id3 != oVar5.aSc.ahM.getId()) {
                    int id4 = view.getId();
                    oVar6 = this.dXO.dXN;
                    if (id4 != oVar6.aSc.aSg.getId()) {
                        int id5 = view.getId();
                        oVar7 = this.dXO.dXN;
                        if (id5 != oVar7.aSc.aSf.getId()) {
                            int id6 = view.getId();
                            oVar8 = this.dXO.dXN;
                            if (id6 == oVar8.aSc.aSm.getId()) {
                                TiebaStatic.log(new aw("c11008").r("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new aw("c11008").r("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                oVar9 = this.dXO.dXN;
                                if (id7 == oVar9.aSc.aSp.getBarNameTv().getId()) {
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
