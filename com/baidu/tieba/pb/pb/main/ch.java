package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Runnable {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dht.bjp = System.currentTimeMillis();
    }
}
