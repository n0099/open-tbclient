package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f euG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.euG = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.pb.view.j jVar;
        com.baidu.tieba.pb.view.j jVar2;
        PbActivity pbActivity;
        jVar = this.euG.euC;
        if (jVar != null) {
            jVar2 = this.euG.euC;
            pbActivity = this.euG.ekw;
            com.baidu.adp.lib.g.j.a(jVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
