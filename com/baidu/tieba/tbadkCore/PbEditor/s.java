package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ PbEditor cmG;
    private final /* synthetic */ int cmH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbEditor pbEditor, int i) {
        this.cmG = pbEditor;
        this.cmH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cmG.a(this.cmH, new t(this));
    }
}
