package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements by<com.baidu.tieba.card.a.l> {
    final /* synthetic */ l ebq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.ebq = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.l lVar) {
        av avVar;
        av avVar2;
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        av avVar3;
        av avVar4;
        av avVar5;
        av avVar6;
        av avVar7;
        av avVar8;
        av avVar9;
        av avVar10;
        av avVar11;
        av avVar12;
        av avVar13;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        bx.Kg().ci(true);
        if (view != null) {
            avVar = this.ebq.ebo;
            if (avVar != null) {
                avVar2 = this.ebq.ebo;
                if (avVar2.getView() != null) {
                    fVar = this.ebq.ebp;
                    if (fVar != null && lVar != null && lVar.Kl() != null && !StringUtils.isNull(lVar.Kl().getTid())) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.e.bR(com.baidu.adp.lib.h.b.c(lVar.Kl().getTid(), 0L))) {
                            com.baidu.tieba.recommendfrs.e.bQ(com.baidu.adp.lib.h.b.c(lVar.Kl().getTid(), 0L));
                            fVar2 = this.ebq.ebp;
                            fVar2.a(com.baidu.adp.lib.h.b.c(lVar.Kl().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Kh(), lVar.Kj(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        avVar3 = this.ebq.ebo;
                        if (id != avVar3.getView().getId()) {
                            avVar4 = this.ebq.ebo;
                            if (avVar4.aQo != null) {
                                int id2 = view.getId();
                                avVar13 = this.ebq.ebo;
                                if (id2 == avVar13.aQo.getId()) {
                                    TiebaStatic.log(lVar.KB());
                                    return;
                                }
                            }
                            avVar5 = this.ebq.ebo;
                            if (avVar5.aQn != null) {
                                int id3 = view.getId();
                                avVar12 = this.ebq.ebo;
                                if (id3 == avVar12.aQn.getId()) {
                                    TiebaStatic.log(lVar.Kz());
                                    return;
                                }
                            }
                            avVar6 = this.ebq.ebo;
                            if (avVar6.aQp != null) {
                                avVar10 = this.ebq.ebo;
                                if (avVar10.aQp.adG != null) {
                                    int id4 = view.getId();
                                    avVar11 = this.ebq.ebo;
                                    if (id4 == avVar11.aQp.adG.getId()) {
                                        TiebaStatic.log(lVar.Kz());
                                        return;
                                    }
                                }
                            }
                            avVar7 = this.ebq.ebo;
                            if (avVar7.aOO != null) {
                                avVar8 = this.ebq.ebo;
                                if (avVar8.aOO.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    avVar9 = this.ebq.ebo;
                                    if (id5 == avVar9.aOO.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Ky());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(lVar.KA());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(lVar.Kx());
                    }
                }
            }
        }
    }
}
