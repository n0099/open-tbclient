package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ PbEditor bWq;
    private final /* synthetic */ int bWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbEditor pbEditor, int i) {
        this.bWq = pbEditor;
        this.bWr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bWq.a(this.bWr, new ac(this));
    }
}
