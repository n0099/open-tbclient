package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f eso;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.eso = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.pb.view.j jVar;
        com.baidu.tieba.pb.view.j jVar2;
        PbActivity pbActivity;
        jVar = this.eso.esk;
        if (jVar != null) {
            jVar2 = this.eso.esk;
            pbActivity = this.eso.eig;
            com.baidu.adp.lib.g.j.a(jVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
