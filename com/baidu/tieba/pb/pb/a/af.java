package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(r rVar) {
        this.dej = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dej.bjp = System.currentTimeMillis();
    }
}
