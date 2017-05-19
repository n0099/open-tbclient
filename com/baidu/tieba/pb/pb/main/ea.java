package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea implements Runnable {
    final /* synthetic */ PbModel eku;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.eku = pbModel;
        this.eky = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eku.a(this.eky, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.eku.isLoading = false;
    }
}
