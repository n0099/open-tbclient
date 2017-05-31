package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej implements Runnable {
    final /* synthetic */ PbModel eqh;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ej(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.eqh = pbModel;
        this.eql = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eqh.a(this.eql, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.eqh.isLoading = false;
    }
}
