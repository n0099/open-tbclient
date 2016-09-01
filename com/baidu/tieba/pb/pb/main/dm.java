package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ dh epX;
    private final /* synthetic */ com.baidu.tieba.pb.data.h eqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dh dhVar, com.baidu.tieba.pb.data.h hVar) {
        this.epX = dhVar;
        this.eqb = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.epX.a(this.eqb, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.epX.aAl = false;
    }
}
