package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ PbInterviewStatusView etW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbInterviewStatusView pbInterviewStatusView) {
        this.etW = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.etW.etP;
        if (aVar != null) {
            aVar2 = this.etW.etP;
            aVar2.td();
        }
    }
}
