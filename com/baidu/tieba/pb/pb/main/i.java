package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.view.PbInterviewStatusView;
/* loaded from: classes.dex */
class i implements PbInterviewStatusView.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
    public void p(boolean z) {
        gg ggVar;
        boolean z2;
        ggVar = this.ewh.euU;
        z2 = this.ewh.euP;
        ggVar.jk(!z2);
    }
}
