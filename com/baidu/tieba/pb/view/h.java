package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ PbInterviewStatusView dsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbInterviewStatusView pbInterviewStatusView) {
        this.dsp = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        aVar = this.dsp.dsi;
        aVar.rU();
    }
}
