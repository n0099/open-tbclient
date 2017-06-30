package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class as implements c.b {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ewh.evW != null) {
            if (i == 0) {
                this.ewh.evW.bN(this.ewh.getPageContext().getPageActivity());
                this.ewh.evW = null;
            } else if (i == 1 && this.ewh.checkUpIsLogin()) {
                this.ewh.h(this.ewh.evW);
            }
        }
    }
}
