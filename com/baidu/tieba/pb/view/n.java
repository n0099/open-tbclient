package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ l eCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.eCy = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eCy.aPg();
    }
}
