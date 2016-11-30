package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g eDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.eDO = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        q qVar;
        q qVar2;
        PbActivity pbActivity;
        qVar = this.eDO.eDK;
        if (qVar != null) {
            qVar2 = this.eDO.eDK;
            pbActivity = this.eDO.eug;
            com.baidu.adp.lib.h.j.a(qVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
