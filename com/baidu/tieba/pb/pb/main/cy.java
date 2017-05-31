package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements Runnable {
    final /* synthetic */ cx eoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar) {
        this.eoe = cxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cv cvVar;
        cvVar = this.eoe.eod;
        cvVar.notifyDataSetChanged();
    }
}
