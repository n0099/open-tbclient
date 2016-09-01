package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ PbInterviewStatusView exP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbInterviewStatusView pbInterviewStatusView) {
        this.exP = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.exP.exI;
        if (aVar != null) {
            aVar2 = this.exP.exI;
            aVar2.sX();
        }
    }
}
