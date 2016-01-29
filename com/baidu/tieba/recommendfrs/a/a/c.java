package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.bb;
import com.baidu.tieba.card.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bb<i> {
    final /* synthetic */ b dFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dFZ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, i iVar) {
        p pVar;
        p pVar2;
        p pVar3;
        pVar = this.dFZ.dFX;
        if (pVar != null) {
            pVar2 = this.dFZ.dFX;
            if (pVar2.getView() != null && iVar != null && iVar.aSc != null && iVar.aSc.getId() != null) {
                int id = view.getId();
                pVar3 = this.dFZ.dFX;
                if (id == pVar3.getView().getId()) {
                    TiebaStatic.log(new au(com.baidu.tieba.card.b.a.aSX).r("obj_locate", com.baidu.tieba.card.b.a.aSU).aa("tid", iVar.aSc.getId()));
                }
            }
        }
    }
}
