package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ t cmX;
    private final /* synthetic */ String cmY;
    private final /* synthetic */ String cmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, String str, String str2) {
        this.cmX = tVar;
        this.cmY = str;
        this.cmZ = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        this.cmX.jU(this.cmY);
        nVar = this.cmX.caU;
        nVar.fe(this.cmZ);
    }
}
