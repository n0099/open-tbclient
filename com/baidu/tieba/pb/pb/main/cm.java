package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements Runnable {
    final /* synthetic */ cl eqH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
        this.eqH = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cj cjVar;
        cjVar = this.eqH.eqG;
        cjVar.notifyDataSetChanged();
    }
}
