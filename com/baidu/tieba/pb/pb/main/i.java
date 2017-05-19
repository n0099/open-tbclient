package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.view.PbInterviewStatusView;
/* loaded from: classes.dex */
class i implements PbInterviewStatusView.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
    public void p(boolean z) {
        fm fmVar;
        boolean z2;
        fmVar = this.ehy.egt;
        z2 = this.ehy.egp;
        fmVar.iy(!z2);
    }
}
