package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ag ewi;
    private final /* synthetic */ String ewk;
    private final /* synthetic */ String ewl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str, String str2) {
        this.ewi = agVar;
        this.ewk = str;
        this.ewl = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.ewi.ph(this.ewk);
        pVar = this.ewi.dtc;
        pVar.fJ(this.ewl);
    }
}
