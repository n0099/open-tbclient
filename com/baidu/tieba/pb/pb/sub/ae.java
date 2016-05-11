package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ y dqN;
    private final /* synthetic */ String dqP;
    private final /* synthetic */ String dqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar, String str, String str2) {
        this.dqN = yVar;
        this.dqP = str;
        this.dqQ = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.dqN.mk(this.dqP);
        pVar = this.dqN.czd;
        pVar.fC(this.dqQ);
    }
}
