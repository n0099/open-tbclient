package com.baidu.tieba.person.god.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.bc;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements bx<m> {
    final /* synthetic */ b eiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eiP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, m mVar) {
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        if (view != null) {
            bcVar = this.eiP.cyy;
            if (bcVar != null) {
                bcVar2 = this.eiP.cyy;
                if (bcVar2.getView() != null && mVar != null && mVar.threadData != null && mVar.threadData.getId() != null) {
                    int id = view.getId();
                    bcVar3 = this.eiP.cyy;
                    if (id == bcVar3.getView().getId()) {
                        TiebaStatic.log(new ay("c10806").s("obj_locate", 5).ab("tid", mVar.threadData.getId()));
                    }
                }
            }
        }
    }
}
