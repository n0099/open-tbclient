package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ t cgt;
    private final /* synthetic */ String cgu;
    private final /* synthetic */ String cgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, String str, String str2) {
        this.cgt = tVar;
        this.cgu = str;
        this.cgv = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        this.cgt.jr(this.cgu);
        nVar = this.cgt.bWp;
        nVar.eR(this.cgv);
    }
}
