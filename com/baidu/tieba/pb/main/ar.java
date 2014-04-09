package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class ar implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.N = System.currentTimeMillis();
    }
}
