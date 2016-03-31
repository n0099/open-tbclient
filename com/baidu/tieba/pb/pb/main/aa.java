package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aa implements a.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        df dfVar;
        eu euVar;
        eu euVar2;
        eu euVar3;
        df dfVar2;
        eu euVar4;
        this.dht.QY();
        dfVar = this.dht.dfV;
        com.baidu.tbadk.core.data.ac abt = dfVar.abt();
        euVar = this.dht.dgF;
        int pageNum = euVar.getPageNum();
        if (pageNum <= 0) {
            this.dht.showToast(t.j.pb_page_error);
        } else if (abt == null || pageNum <= abt.sl()) {
            euVar2 = this.dht.dgF;
            euVar2.amI();
            this.dht.Qn();
            euVar3 = this.dht.dgF;
            euVar3.ayE();
            dfVar2 = this.dht.dfV;
            euVar4 = this.dht.dgF;
            dfVar2.lY(euVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.dht.showToast(t.j.pb_page_error);
        }
    }
}
