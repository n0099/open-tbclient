package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements Runnable {
    final /* synthetic */ cw dlN;
    private final /* synthetic */ com.baidu.tieba.pb.data.e dlR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cw cwVar, com.baidu.tieba.pb.data.e eVar) {
        this.dlN = cwVar;
        this.dlR = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dlN.a(this.dlR, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.dlN.avz = false;
    }
}
