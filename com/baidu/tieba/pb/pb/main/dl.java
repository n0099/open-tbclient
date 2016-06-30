package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements Runnable {
    final /* synthetic */ dg dRE;
    private final /* synthetic */ com.baidu.tieba.pb.data.h dRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(dg dgVar, com.baidu.tieba.pb.data.h hVar) {
        this.dRE = dgVar;
        this.dRI = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dRE.a(this.dRI, 3, false, 0, "", false, 0, 0L, 0L, true);
        this.dRE.awp = false;
    }
}
