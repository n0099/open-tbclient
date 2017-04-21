package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.emk.elJ = System.currentTimeMillis();
    }
}
