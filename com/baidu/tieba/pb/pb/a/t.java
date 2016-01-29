package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q cKS;
    private final /* synthetic */ am cKT;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cKU;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.m cKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, am amVar, com.baidu.tieba.tbadkCore.data.r rVar, com.baidu.tbadk.widget.richText.m mVar) {
        this.cKS = qVar;
        this.cKT = amVar;
        this.cKU = rVar;
        this.cKV = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        this.cKT.cLn.setVisibility(8);
        this.cKT.cLk.start();
        this.cKS.b(this.cKU, this.cKT);
        this.cKS.apc();
        this.cKS.c(this.cKV);
        this.cKS.a(this.cKT, this.cKV);
        cVar = this.cKS.cJZ;
        if (cVar != null) {
            au auVar = new au("c10795");
            cVar2 = this.cKS.cJZ;
            TiebaStatic.log(auVar.aa("tid", cVar2.getThreadId()));
        }
    }
}
