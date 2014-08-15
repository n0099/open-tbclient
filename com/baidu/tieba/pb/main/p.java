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
        bl blVar;
        bs bsVar;
        bl blVar2;
        bs bsVar2;
        blVar = this.a.x;
        if (blVar.a(false)) {
            bsVar2 = this.a.D;
            bsVar2.w();
            TiebaStatic.eventStat(this.a, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bsVar = this.a.D;
        blVar2 = this.a.x;
        bsVar.c(blVar2.r());
    }
}
