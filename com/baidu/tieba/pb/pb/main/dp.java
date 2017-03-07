package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements Runnable {
    final /* synthetic */ PbModel enW;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.enW = pbModel;
        this.eoa = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.enW.a(this.eoa, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.enW.isLoading = false;
    }
}
