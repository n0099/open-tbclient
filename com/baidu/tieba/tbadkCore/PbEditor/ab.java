package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ PbEditor bUy;
    private final /* synthetic */ int bUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbEditor pbEditor, int i) {
        this.bUy = pbEditor;
        this.bUz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bUy.a(this.bUz, new ac(this));
    }
}
