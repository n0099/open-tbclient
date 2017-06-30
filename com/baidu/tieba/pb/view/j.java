package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ PbInterviewStatusView eLH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbInterviewStatusView pbInterviewStatusView) {
        this.eLH = pbInterviewStatusView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eLH.eLA;
        if (aVar != null) {
            aVar2 = this.eLH.eLA;
            aVar2.ta();
        }
    }
}
