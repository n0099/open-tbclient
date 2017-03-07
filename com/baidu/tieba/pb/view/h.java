package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ PbInterviewStatusView exQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbInterviewStatusView pbInterviewStatusView) {
        this.exQ = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.exQ.exJ;
        if (aVar != null) {
            aVar2 = this.exQ.exJ;
            aVar2.ts();
        }
    }
}
