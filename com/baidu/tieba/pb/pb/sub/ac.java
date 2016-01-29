package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ w cUl;
    private final /* synthetic */ String cUn;
    private final /* synthetic */ String cUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar, String str, String str2) {
        this.cUl = wVar;
        this.cUn = str;
        this.cUo = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.d.p pVar;
        this.cUl.kS(this.cUn);
        pVar = this.cUl.cnC;
        pVar.fx(this.cUo);
    }
}
