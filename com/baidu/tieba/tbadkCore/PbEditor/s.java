package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ PbEditor cmW;
    private final /* synthetic */ int cmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbEditor pbEditor, int i) {
        this.cmW = pbEditor;
        this.cmX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cmW.a(this.cmX, new t(this));
    }
}
