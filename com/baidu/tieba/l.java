package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atC.DU();
    }
}
