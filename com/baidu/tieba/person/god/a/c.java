package com.baidu.tieba.person.god.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.af;
import com.baidu.tieba.card.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bb<q> {
    final /* synthetic */ b dcB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dcB = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, q qVar) {
        af afVar;
        af afVar2;
        af afVar3;
        if (view != null) {
            afVar = this.dcB.bJz;
            if (afVar != null) {
                afVar2 = this.dcB.bJz;
                if (afVar2.getView() != null && qVar != null && qVar.aSc != null && qVar.aSc.getId() != null) {
                    int id = view.getId();
                    afVar3 = this.dcB.bJz;
                    if (id == afVar3.getView().getId()) {
                        TiebaStatic.log(new au(com.baidu.tieba.card.b.a.aSX).r("obj_locate", com.baidu.tieba.card.b.a.aSW).aa("tid", qVar.aSc.getId()));
                    }
                }
            }
        }
    }
}
