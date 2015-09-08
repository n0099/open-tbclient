package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ t chq;
    private final /* synthetic */ String chr;
    private final /* synthetic */ String chs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, String str, String str2) {
        this.chq = tVar;
        this.chr = str;
        this.chs = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.n nVar;
        this.chq.jz(this.chr);
        nVar = this.chq.bWV;
        nVar.eZ(this.chs);
    }
}
