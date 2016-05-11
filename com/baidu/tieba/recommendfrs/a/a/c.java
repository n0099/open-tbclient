package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.f;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements by<f> {
    final /* synthetic */ b eaU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eaU = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, f fVar) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        k kVar8;
        k kVar9;
        kVar = this.eaU.eaT;
        if (kVar != null) {
            kVar2 = this.eaU.eaT;
            if (kVar2.getView() != null && fVar != null && fVar.aRG != null && fVar.aRG.getId() != null) {
                int id = view.getId();
                kVar3 = this.eaU.eaT;
                if (id == kVar3.getView().getId()) {
                    TiebaStatic.log(new aw("c10806").s("obj_locate", 2).ac("tid", fVar.aRG.getId()));
                    return;
                }
                int id2 = view.getId();
                kVar4 = this.eaU.eaT;
                if (id2 == kVar4.aOH.getId()) {
                    TiebaStatic.log(new aw("c10803").ac("tid", fVar.aRG.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                kVar5 = this.eaU.eaT;
                if (id3 != kVar5.adG.getId()) {
                    int id4 = view.getId();
                    kVar6 = this.eaU.eaT;
                    if (id4 != kVar6.aOF.getId()) {
                        int id5 = view.getId();
                        kVar7 = this.eaU.eaT;
                        if (id5 != kVar7.aOE.getId()) {
                            int id6 = view.getId();
                            kVar8 = this.eaU.eaT;
                            if (id6 == kVar8.aOL.getId()) {
                                TiebaStatic.log(new aw("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new aw("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                kVar9 = this.eaU.eaT;
                                if (id7 == kVar9.aOO.getBarNameTv().getId()) {
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
