package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ PbEditor bWp;
    private final /* synthetic */ int bWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbEditor pbEditor, int i) {
        this.bWp = pbEditor;
        this.bWq = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bWp.a(this.bWq, new ac(this));
    }
}
