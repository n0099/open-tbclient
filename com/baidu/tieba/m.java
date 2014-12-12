package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ LogoActivity akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.akC = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.akC.Aj();
    }
}
