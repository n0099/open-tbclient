package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements Runnable {
    final /* synthetic */ dc ech;
    private final /* synthetic */ com.baidu.tieba.pb.data.f ecl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dc dcVar, com.baidu.tieba.pb.data.f fVar) {
        this.ech = dcVar;
        this.ecl = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ech.a(this.ecl, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.ech.aAd = false;
    }
}
