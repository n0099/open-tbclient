package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ PbEditor cqV;
    private final /* synthetic */ int cqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbEditor pbEditor, int i) {
        this.cqV = pbEditor;
        this.cqW = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cqV.a(this.cqW, new t(this));
    }
}
