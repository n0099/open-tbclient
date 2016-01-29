package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ q cKS;
    private final /* synthetic */ PraiseData cKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, PraiseData praiseData) {
        this.cKS = qVar;
        this.cKZ = praiseData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        if ((this.cKZ == null || this.cKZ.getIsLike() != 1) && this.cKS.cNL != null && bi.ah(this.cKS.cNL.getPageContext().getPageActivity())) {
            this.cKS.cNL.api();
            cVar = this.cKS.cJZ;
            if (cVar != null) {
                au auVar = new au("c10797");
                cVar2 = this.cKS.cJZ;
                TiebaStatic.log(auVar.aa("tid", cVar2.getThreadId()));
            }
        }
    }
}
