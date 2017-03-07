package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f eul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.eul = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.pb.view.j jVar;
        com.baidu.tieba.pb.view.j jVar2;
        PbActivity pbActivity;
        jVar = this.eul.euh;
        if (jVar != null) {
            jVar2 = this.eul.euh;
            pbActivity = this.eul.eka;
            com.baidu.adp.lib.g.j.a(jVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
