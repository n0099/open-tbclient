package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ PbInterviewStatusView eCk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbInterviewStatusView pbInterviewStatusView) {
        this.eCk = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eCk.eCd;
        if (aVar != null) {
            aVar2 = this.eCk.eCd;
            aVar2.tc();
        }
    }
}
