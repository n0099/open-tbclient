package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ dh edS;
    private final /* synthetic */ com.baidu.tieba.pb.data.h edW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dh dhVar, com.baidu.tieba.pb.data.h hVar) {
        this.edS = dhVar;
        this.edW = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.edS.a(this.edW, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.edS.axe = false;
    }
}
