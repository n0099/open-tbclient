package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g ehO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.ehO = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.pb.view.j jVar;
        com.baidu.tieba.pb.view.j jVar2;
        PbActivity pbActivity;
        jVar = this.ehO.ehL;
        if (jVar != null) {
            jVar2 = this.ehO.ehL;
            pbActivity = this.ehO.dYB;
            com.baidu.adp.lib.h.j.a(jVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
