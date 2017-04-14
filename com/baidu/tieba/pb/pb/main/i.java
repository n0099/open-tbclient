package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.view.PbInterviewStatusView;
/* loaded from: classes.dex */
class i implements PbInterviewStatusView.a {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
    public void p(boolean z) {
        ey eyVar;
        boolean z2;
        eyVar = this.ejU.eiS;
        z2 = this.ejU.eiO;
        eyVar.iJ(!z2);
    }
}
