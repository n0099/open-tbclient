package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.acP = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acP.wa();
    }
}
