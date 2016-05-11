package com.baidu.tieba.person.god.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.bd;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements by<l> {
    final /* synthetic */ b dAj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dAj = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, l lVar) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        if (view != null) {
            bdVar = this.dAj.bUx;
            if (bdVar != null) {
                bdVar2 = this.dAj.bUx;
                if (bdVar2.getView() != null && lVar != null && lVar.aRG != null && lVar.aRG.getId() != null) {
                    int id = view.getId();
                    bdVar3 = this.dAj.bUx;
                    if (id == bdVar3.getView().getId()) {
                        TiebaStatic.log(new aw("c10806").s("obj_locate", 5).ac("tid", lVar.aRG.getId()));
                    }
                }
            }
        }
    }
}
