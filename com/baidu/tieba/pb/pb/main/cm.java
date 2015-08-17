package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cm implements a.b {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cb cbVar) {
        this.cfj = cbVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cfj.aeA();
        aVar.dismiss();
    }
}
