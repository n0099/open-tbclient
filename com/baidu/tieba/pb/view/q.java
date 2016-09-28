package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ PbInterviewStatusView ezW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbInterviewStatusView pbInterviewStatusView) {
        this.ezW = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.ezW.ezP;
        if (aVar != null) {
            aVar2 = this.ezW.ezP;
            aVar2.tm();
        }
    }
}
