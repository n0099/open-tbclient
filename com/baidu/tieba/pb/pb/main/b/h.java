package com.baidu.tieba.pb.pb.main.b;

import com.baidu.adp.lib.h.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e exp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.exp = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        s sVar2;
        PbActivity pbActivity;
        sVar = this.exp.exm;
        if (sVar != null) {
            sVar2 = this.exp.exm;
            pbActivity = this.exp.eow;
            j.a(sVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
