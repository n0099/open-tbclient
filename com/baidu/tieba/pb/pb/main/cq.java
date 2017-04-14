package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements Runnable {
    final /* synthetic */ cp ekJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar) {
        this.ekJ = cpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn cnVar;
        cnVar = this.ekJ.ekI;
        cnVar.notifyDataSetChanged();
    }
}
