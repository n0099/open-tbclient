package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements Runnable {
    final /* synthetic */ cl eoJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
        this.eoJ = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cj cjVar;
        cjVar = this.eoJ.eoI;
        cjVar.notifyDataSetChanged();
    }
}
