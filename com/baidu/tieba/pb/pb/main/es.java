package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class es implements Runnable {
    final /* synthetic */ PbModel ezs;
    private final /* synthetic */ com.baidu.tieba.pb.data.f ezw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        this.ezs = pbModel;
        this.ezw = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ezs.a(this.ezw, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.ezs.isLoading = false;
    }
}
