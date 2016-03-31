package com.baidu.tieba.person.god.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.a.t;
import com.baidu.tieba.card.bl;
import com.baidu.tieba.card.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements cj<t> {
    final /* synthetic */ b dxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dxd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cj
    public void a(View view, t tVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        if (view != null) {
            blVar = this.dxd.bTV;
            if (blVar != null) {
                blVar2 = this.dxd.bTV;
                if (blVar2.getView() != null && tVar != null && tVar.aVJ != null && tVar.aVJ.getId() != null) {
                    int id = view.getId();
                    blVar3 = this.dxd.bTV;
                    if (id == blVar3.getView().getId()) {
                        TiebaStatic.log(new aw("c10806").r("obj_locate", 5).ac("tid", tVar.aVJ.getId()));
                    }
                }
            }
        }
    }
}
