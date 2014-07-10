package com.baidu.tieba.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ m a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(m mVar, String str) {
        this.a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b);
    }
}
