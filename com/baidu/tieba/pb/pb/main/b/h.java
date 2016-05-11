package com.baidu.tieba.pb.pb.main.b;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e dqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.dqa = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        j jVar2;
        PbActivity pbActivity;
        jVar = this.dqa.dpY;
        if (jVar != null) {
            jVar2 = this.dqa.dpY;
            pbActivity = this.dqa.dhY;
            com.baidu.adp.lib.h.j.a(jVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
