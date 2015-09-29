package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ t cmM;
    private final /* synthetic */ String cmN;
    private final /* synthetic */ String cmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, String str, String str2) {
        this.cmM = tVar;
        this.cmN = str;
        this.cmO = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        this.cmM.jU(this.cmN);
        nVar = this.cmM.caJ;
        nVar.fe(this.cmO);
    }
}
