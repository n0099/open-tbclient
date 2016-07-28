package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ af eka;
    private final /* synthetic */ String ekc;
    private final /* synthetic */ String ekd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar, String str, String str2) {
        this.eka = afVar;
        this.ekc = str;
        this.ekd = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.eka.oy(this.ekc);
        pVar = this.eka.dhw;
        pVar.fG(this.ekd);
    }
}
