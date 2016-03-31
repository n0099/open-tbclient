package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ah implements a.InterfaceC0041a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0041a
    public void a(boolean z, boolean z2, String str) {
        eu euVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        df dfVar;
        df dfVar2;
        eu euVar2;
        df dfVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        euVar = this.dht.dgF;
        euVar.ayH();
        if (z) {
            aVar = this.dht.cOZ;
            if (aVar != null) {
                aVar4 = this.dht.cOZ;
                aVar4.X(z2);
            }
            dfVar = this.dht.dfV;
            dfVar.gd(z2);
            dfVar2 = this.dht.dfV;
            if (!dfVar2.pu()) {
                euVar2 = this.dht.dgF;
                dfVar3 = this.dht.dfV;
                euVar2.j(dfVar3.getPbData());
            } else {
                this.dht.awv();
            }
            if (z2) {
                aVar2 = this.dht.cOZ;
                if (aVar2 != null) {
                    aVar3 = this.dht.cOZ;
                    MarkData px = aVar3.px();
                    if (px != null) {
                        this.dht.showToast(MessageFormat.format(this.dht.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(px.getFloor())));
                        return;
                    } else {
                        this.dht.showToast(this.dht.getPageContext().getString(t.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.dht.showToast(this.dht.getPageContext().getString(t.j.remove_mark));
            return;
        }
        this.dht.showToast(this.dht.getPageContext().getString(t.j.update_mark_failed));
    }
}
