package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ j eGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.eGR = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        x xVar2;
        PbActivity pbActivity;
        xVar = this.eGR.eGN;
        if (xVar != null) {
            xVar2 = this.eGR.eGN;
            pbActivity = this.eGR.euf;
            com.baidu.adp.lib.g.j.a(xVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
