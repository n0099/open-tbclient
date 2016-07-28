package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.view.PbInterviewStatusView;
/* loaded from: classes.dex */
class i implements PbInterviewStatusView.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
    public void m(boolean z) {
        ew ewVar;
        boolean z2;
        ewVar = this.ebT.ebb;
        z2 = this.ebT.eaX;
        ewVar.hX(!z2);
    }
}
