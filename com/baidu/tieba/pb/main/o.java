package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class o implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        bc bcVar;
        bj bjVar;
        bcVar = this.a.y;
        if (!bcVar.b(true)) {
            bjVar = this.a.E;
            bjVar.x();
            return;
        }
        TiebaStatic.eventStat(this.a, "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
