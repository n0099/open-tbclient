package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ PbInterviewStatusView eGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbInterviewStatusView pbInterviewStatusView) {
        this.eGF = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eGF.eGy;
        if (aVar != null) {
            aVar2 = this.eGF.eGy;
            aVar2.tq();
        }
    }
}
