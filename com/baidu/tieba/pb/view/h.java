package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ PbInterviewStatusView eyn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbInterviewStatusView pbInterviewStatusView) {
        this.eyn = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eyn.eyf;
        if (aVar != null) {
            aVar2 = this.eyn.eyf;
            aVar2.tQ();
        }
    }
}
