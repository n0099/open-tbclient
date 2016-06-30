package com.baidu.tieba.pb.pb.main.b;

import com.baidu.adp.lib.h.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e dWA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.dWA = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        s sVar2;
        PbActivity pbActivity;
        sVar = this.dWA.dWw;
        if (sVar != null) {
            sVar2 = this.dWA.dWw;
            pbActivity = this.dWA.dOg;
            j.a(sVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
