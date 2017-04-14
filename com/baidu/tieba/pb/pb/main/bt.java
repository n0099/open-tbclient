package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ejU.ejt = System.currentTimeMillis();
    }
}
