package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ df dju;
    private final /* synthetic */ com.baidu.tieba.pb.data.e djy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(df dfVar, com.baidu.tieba.pb.data.e eVar) {
        this.dju = dfVar;
        this.djy = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dju.a(this.djy, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.dju.azx = false;
    }
}
