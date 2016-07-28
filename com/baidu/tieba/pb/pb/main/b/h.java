package com.baidu.tieba.pb.pb.main.b;

import com.baidu.adp.lib.h.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e ejc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.ejc = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        s sVar2;
        PbActivity pbActivity;
        sVar = this.ejc.eiZ;
        if (sVar != null) {
            sVar2 = this.ejc.eiZ;
            pbActivity = this.ejc.eat;
            j.a(sVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
