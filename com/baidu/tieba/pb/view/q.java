package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ PbInterviewStatusView dZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbInterviewStatusView pbInterviewStatusView) {
        this.dZh = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        aVar = this.dZh.dZa;
        aVar.rT();
    }
}
