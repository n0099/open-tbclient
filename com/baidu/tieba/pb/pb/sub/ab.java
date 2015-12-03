package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ w cHA;
    private final /* synthetic */ String cHB;
    private final /* synthetic */ String cHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar, String str, String str2) {
        this.cHA = wVar;
        this.cHB = str;
        this.cHC = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.cHA.kO(this.cHB);
        pVar = this.cHA.ceY;
        pVar.fv(this.cHC);
    }
}
