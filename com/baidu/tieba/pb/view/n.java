package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ l eLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.eLV = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eLV.aTf();
    }
}
