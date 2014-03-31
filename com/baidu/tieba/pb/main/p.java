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
        bd bdVar;
        bk bkVar;
        bd bdVar2;
        bk bkVar2;
        bdVar = this.a.x;
        if (bdVar.a(false)) {
            bkVar2 = this.a.D;
            bkVar2.v();
            TiebaStatic.a(this.a, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bkVar = this.a.D;
        bdVar2 = this.a.x;
        bkVar.c(bdVar2.p());
    }
}
