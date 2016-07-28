package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ PbInterviewStatusView elJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbInterviewStatusView pbInterviewStatusView) {
        this.elJ = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.elJ.elC;
        if (aVar != null) {
            aVar2 = this.elJ.elC;
            aVar2.rS();
        }
    }
}
