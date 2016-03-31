package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class aq implements c.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.dht.dhl != null) {
            if (i == 0) {
                this.dht.dhl.aN(this.dht.getPageContext().getPageActivity());
                this.dht.dhl = null;
            } else if (i == 1 && this.dht.checkUpIsLogin()) {
                this.dht.d(this.dht.dhl);
            }
        }
    }
}
