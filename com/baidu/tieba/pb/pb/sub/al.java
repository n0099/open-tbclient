package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    private final /* synthetic */ String dXA;
    private final /* synthetic */ String dXB;
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar, String str, String str2) {
        this.dXy = afVar;
        this.dXA = str;
        this.dXB = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.dXy.nL(this.dXA);
        pVar = this.dXy.deA;
        pVar.fI(this.dXB);
    }
}
