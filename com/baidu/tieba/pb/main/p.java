package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void f_() {
        bj bjVar;
        bq bqVar;
        bj bjVar2;
        bq bqVar2;
        bjVar = this.a.x;
        if (bjVar.a(false)) {
            bqVar2 = this.a.D;
            bqVar2.v();
            TiebaStatic.eventStat(this.a, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bqVar = this.a.D;
        bjVar2 = this.a.x;
        bqVar.c(bjVar2.p());
    }
}
