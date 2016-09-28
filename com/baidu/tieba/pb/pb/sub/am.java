package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ag eyq;
    private final /* synthetic */ String eys;
    private final /* synthetic */ String eyt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str, String str2) {
        this.eyq = agVar;
        this.eys = str;
        this.eyt = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.e.p pVar;
        this.eyq.px(this.eys);
        pVar = this.eyq.duz;
        pVar.fN(this.eyt);
    }
}
