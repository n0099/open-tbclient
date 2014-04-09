package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class p implements com.baidu.adp.widget.ListView.t {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        bf bfVar;
        bm bmVar;
        bf bfVar2;
        bm bmVar2;
        bfVar = this.a.x;
        if (bfVar.a(false)) {
            bmVar2 = this.a.D;
            bmVar2.v();
            TiebaStatic.a(this.a, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bmVar = this.a.D;
        bfVar2 = this.a.x;
        bmVar.c(bfVar2.p());
    }
}
