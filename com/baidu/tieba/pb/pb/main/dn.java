package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements Runnable {
    final /* synthetic */ PbModel eme;
    private final /* synthetic */ com.baidu.tieba.pb.data.f emi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.eme = pbModel;
        this.emi = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eme.a(this.emi, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.eme.isLoading = false;
    }
}
