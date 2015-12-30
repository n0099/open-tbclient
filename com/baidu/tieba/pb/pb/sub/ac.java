package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ w cLC;
    private final /* synthetic */ String cLE;
    private final /* synthetic */ String cLF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar, String str, String str2) {
        this.cLC = wVar;
        this.cLE = str;
        this.cLF = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.cLC.kL(this.cLE);
        pVar = this.cLC.cjc;
        pVar.fz(this.cLF);
    }
}
