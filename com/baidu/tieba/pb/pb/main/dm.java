package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ dh erV;
    private final /* synthetic */ com.baidu.tieba.pb.data.h erZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dh dhVar, com.baidu.tieba.pb.data.h hVar) {
        this.erV = dhVar;
        this.erZ = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.erV.a(this.erZ, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.erV.azO = false;
    }
}
