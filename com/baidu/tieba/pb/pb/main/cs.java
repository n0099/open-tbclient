package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Runnable {
    final /* synthetic */ cr emC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.emC = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cp cpVar;
        cpVar = this.emC.emB;
        cpVar.notifyDataSetChanged();
    }
}
