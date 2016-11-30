package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements Runnable {
    final /* synthetic */ dj exP;
    private final /* synthetic */ com.baidu.tieba.pb.data.h exT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dj djVar, com.baidu.tieba.pb.data.h hVar) {
        this.exP = djVar;
        this.exT = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.exP.a(this.exT, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.exP.aAG = false;
    }
}
