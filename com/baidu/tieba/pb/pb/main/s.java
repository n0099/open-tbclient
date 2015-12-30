package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class s implements PbActivity.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void fa(boolean z) {
        cf cfVar;
        dk dkVar;
        cf cfVar2;
        dk dkVar2;
        cfVar = this.cFS.cFl;
        if (cfVar.fd(true)) {
            dkVar2 = this.cFS.cFq;
            dkVar2.amM();
            return;
        }
        dkVar = this.cFS.cFq;
        dkVar.ang();
        cfVar2 = this.cFS.cFl;
        cfVar2.kq(1);
    }
}
