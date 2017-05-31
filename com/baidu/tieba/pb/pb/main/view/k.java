package com.baidu.tieba.pb.pb.main.view;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ h exs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.exs = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        x xVar2;
        PbActivity pbActivity;
        xVar = this.exs.exo;
        if (xVar != null) {
            xVar2 = this.exs.exo;
            pbActivity = this.exs.elf;
            com.baidu.adp.lib.g.j.a(xVar2, pbActivity.getPageContext().getPageActivity());
        }
    }
}
