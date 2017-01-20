package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements Runnable {
    final /* synthetic */ PbModel ekY;
    private final /* synthetic */ com.baidu.tieba.pb.data.f elc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.ekY = pbModel;
        this.elc = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ekY.a(this.elc, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.ekY.isLoading = false;
    }
}
