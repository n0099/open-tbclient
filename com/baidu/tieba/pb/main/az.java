package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bvu.azc = System.currentTimeMillis();
    }
}
