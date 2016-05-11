package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.view.PbInterviewStatusView;
/* loaded from: classes.dex */
class h implements PbInterviewStatusView.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
    public void k(boolean z) {
        el elVar;
        boolean z2;
        elVar = this.djE.diR;
        z2 = this.djE.diL;
        elVar.gS(!z2);
    }
}
