package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements Runnable {
    final /* synthetic */ de exk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.exk = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dc dcVar;
        dcVar = this.exk.exj;
        dcVar.notifyDataSetChanged();
    }
}
