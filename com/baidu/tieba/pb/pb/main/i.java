package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.view.PbInterviewStatusView;
/* loaded from: classes.dex */
class i implements PbInterviewStatusView.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
    public void k(boolean z) {
        es esVar;
        boolean z2;
        esVar = this.dPF.dOO;
        z2 = this.dPF.dOK;
        esVar.hL(!z2);
    }
}
