package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.by;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements by<com.baidu.tieba.card.a.j> {
    final /* synthetic */ p ebu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.ebu = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.j jVar) {
        com.baidu.tieba.card.u uVar;
        com.baidu.tieba.card.u uVar2;
        com.baidu.tieba.card.u uVar3;
        com.baidu.tieba.card.u uVar4;
        com.baidu.tieba.card.u uVar5;
        com.baidu.tieba.card.u uVar6;
        com.baidu.tieba.card.u uVar7;
        com.baidu.tieba.card.u uVar8;
        if (view != null) {
            uVar = this.ebu.ebs;
            if (uVar != null) {
                uVar2 = this.ebu.ebs;
                if (uVar2.aPu != null) {
                    uVar3 = this.ebu.ebs;
                    if (uVar3.aPu.aPz != null) {
                        uVar4 = this.ebu.ebs;
                        if (uVar4.aPu.aPx != null) {
                            uVar5 = this.ebu.ebs;
                            if (uVar5.aPu.getView() != null) {
                                int id = view.getId();
                                uVar6 = this.ebu.ebs;
                                if (id == uVar6.aPu.aPz.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new aw("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                uVar7 = this.ebu.ebs;
                                if (id2 != uVar7.aPu.getView().getId()) {
                                    int id3 = view.getId();
                                    uVar8 = this.ebu.ebs;
                                    if (id3 != uVar8.aPu.aPx.getId()) {
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
