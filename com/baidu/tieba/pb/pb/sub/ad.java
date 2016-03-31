package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ x dpf;
    private final /* synthetic */ String dph;
    private final /* synthetic */ String dpj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar, String str, String str2) {
        this.dpf = xVar;
        this.dph = str;
        this.dpj = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.dpf.mg(this.dph);
        pVar = this.dpf.cye;
        pVar.fF(this.dpj);
    }
}
