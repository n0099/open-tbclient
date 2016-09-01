package com.baidu.tieba.pb.pb.main.b;

import com.baidu.adp.lib.h.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e evj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.evj = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        s sVar2;
        PbActivity pbActivity;
        sVar = this.evj.evg;
        if (sVar != null) {
            sVar2 = this.evj.evg;
            pbActivity = this.evj.emy;
            j.a(sVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
