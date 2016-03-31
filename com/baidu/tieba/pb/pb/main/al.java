package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.s;
/* loaded from: classes.dex */
class al implements s.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        df dfVar;
        eu euVar;
        if (this.dht.awE()) {
            this.dht.finish();
        }
        dfVar = this.dht.dfV;
        if (!dfVar.gc(true)) {
            euVar = this.dht.dgF;
            euVar.ayI();
            return;
        }
        TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
