package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements Runnable {
    final /* synthetic */ cp ena;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar) {
        this.ena = cpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn cnVar;
        cnVar = this.ena.emZ;
        cnVar.notifyDataSetChanged();
    }
}
