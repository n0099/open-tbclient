package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bt btVar;
        btVar = this.a.D;
        btVar.A();
    }
}
