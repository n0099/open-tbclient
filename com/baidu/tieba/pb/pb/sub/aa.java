package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ v coo;
    private final /* synthetic */ String cop;
    private final /* synthetic */ String coq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar, String str, String str2) {
        this.coo = vVar;
        this.cop = str;
        this.coq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.c.p pVar;
        this.coo.jX(this.cop);
        pVar = this.coo.cbv;
        pVar.fg(this.coq);
    }
}
