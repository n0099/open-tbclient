package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements Runnable {
    private final /* synthetic */ com.baidu.tieba.pb.data.f eoB;
    final /* synthetic */ PbModel eox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.eox = pbModel;
        this.eoB = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eox.a(this.eoB, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.eox.isLoading = false;
    }
}
