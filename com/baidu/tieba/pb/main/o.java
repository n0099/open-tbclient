package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class o implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        bf bfVar;
        bm bmVar;
        bfVar = this.a.x;
        if (!bfVar.b(true)) {
            bmVar = this.a.D;
            bmVar.x();
            return;
        }
        TiebaStatic.a(this.a, "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
