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
    public void g_() {
        bm bmVar;
        bt btVar;
        bm bmVar2;
        bt btVar2;
        bmVar = this.a.x;
        if (bmVar.a(false)) {
            btVar2 = this.a.D;
            btVar2.w();
            TiebaStatic.eventStat(this.a, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        btVar = this.a.D;
        bmVar2 = this.a.x;
        btVar.c(bmVar2.r());
    }
}
