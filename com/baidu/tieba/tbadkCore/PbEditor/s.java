package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ PbEditor cqW;
    private final /* synthetic */ int cqX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbEditor pbEditor, int i) {
        this.cqW = pbEditor;
        this.cqX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cqW.a(this.cqX, new t(this));
    }
}
