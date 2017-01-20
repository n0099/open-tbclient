package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ cq ejI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cq cqVar) {
        this.ejI = cqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        cq cqVar = this.ejI;
        fVar = this.ejI.egj;
        cqVar.b(fVar);
        this.ejI.notifyDataSetChanged();
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11926"));
    }
}
