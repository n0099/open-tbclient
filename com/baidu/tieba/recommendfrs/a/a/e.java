package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.f;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements by<f> {
    final /* synthetic */ d eaX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.eaX = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, f fVar) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        j jVar8;
        j jVar9;
        jVar = this.eaX.eaW;
        if (jVar != null) {
            jVar2 = this.eaX.eaW;
            if (jVar2.aOB != null && fVar != null && fVar.aRG != null && fVar.aRG.getId() != null) {
                int id = view.getId();
                jVar3 = this.eaX.eaW;
                if (id == jVar3.aOB.getView().getId()) {
                    TiebaStatic.log(new aw("c10806").s("obj_locate", 2).ac("tid", fVar.aRG.getId()));
                    return;
                }
                int id2 = view.getId();
                jVar4 = this.eaX.eaW;
                if (id2 == jVar4.aOB.aOH.getId()) {
                    TiebaStatic.log(new aw("c10803").ac("tid", fVar.aRG.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                jVar5 = this.eaX.eaW;
                if (id3 != jVar5.aOB.adG.getId()) {
                    int id4 = view.getId();
                    jVar6 = this.eaX.eaW;
                    if (id4 != jVar6.aOB.aOF.getId()) {
                        int id5 = view.getId();
                        jVar7 = this.eaX.eaW;
                        if (id5 != jVar7.aOB.aOE.getId()) {
                            int id6 = view.getId();
                            jVar8 = this.eaX.eaW;
                            if (id6 == jVar8.aOB.aOL.getId()) {
                                TiebaStatic.log(new aw("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new aw("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                jVar9 = this.eaX.eaW;
                                if (id7 == jVar9.aOB.aOO.getBarNameTv().getId()) {
                                    TiebaStatic.log(new aw("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new aw("c11008").s("obj_locate", 1));
            }
        }
    }
}
