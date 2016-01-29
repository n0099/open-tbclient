package com.baidu.tieba.recommendfrs.a.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.card.bb;
import com.baidu.tieba.card.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements bb<i> {
    final /* synthetic */ d dGc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dGc = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bb
    public void a(View view, i iVar) {
        o oVar;
        o oVar2;
        o oVar3;
        oVar = this.dGc.dGb;
        if (oVar != null) {
            oVar2 = this.dGc.dGb;
            if (oVar2.getView() != null && iVar != null && iVar.aSc != null && iVar.aSc.getId() != null) {
                int id = view.getId();
                oVar3 = this.dGc.dGb;
                if (id == oVar3.getView().getId()) {
                    TiebaStatic.log(new au(com.baidu.tieba.card.b.a.aSX).r("obj_locate", com.baidu.tieba.card.b.a.aSU).aa("tid", iVar.aSc.getId()));
                }
            }
        }
    }
}
