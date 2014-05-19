package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements com.baidu.adp.widget.ListView.u {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public void f_() {
        bc bcVar;
        bj bjVar;
        bc bcVar2;
        bj bjVar2;
        bcVar = this.a.y;
        if (bcVar.a(false)) {
            bjVar2 = this.a.E;
            bjVar2.v();
            TiebaStatic.eventStat(this.a, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bjVar = this.a.E;
        bcVar2 = this.a.y;
        bjVar.c(bcVar2.p());
    }
}
