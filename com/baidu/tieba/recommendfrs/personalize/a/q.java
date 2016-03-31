package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements cj<com.baidu.tieba.card.a.q> {
    final /* synthetic */ p dYn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.dYn = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.q qVar) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        af afVar5;
        af afVar6;
        af afVar7;
        af afVar8;
        if (view != null) {
            afVar = this.dYn.dYl;
            if (afVar != null) {
                afVar2 = this.dYn.dYl;
                if (afVar2.aTg != null) {
                    afVar3 = this.dYn.dYl;
                    if (afVar3.aTg.aTl != null) {
                        afVar4 = this.dYn.dYl;
                        if (afVar4.aTg.aTj != null) {
                            afVar5 = this.dYn.dYl;
                            if (afVar5.aTg.getView() != null) {
                                int id = view.getId();
                                afVar6 = this.dYn.dYl;
                                if (id == afVar6.aTg.aTl.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new aw("c10803").r("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                afVar7 = this.dYn.dYl;
                                if (id2 != afVar7.aTg.getView().getId()) {
                                    int id3 = view.getId();
                                    afVar8 = this.dYn.dYl;
                                    if (id3 != afVar8.aTg.aTj.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(t.g.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new aw("c11005").ac("obj_id", (String) view.getTag(t.g.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
