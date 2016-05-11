package com.baidu.tieba.view;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AudioAnimationView eVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AudioAnimationView audioAnimationView) {
        this.eVX = audioAnimationView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eVX.aLb();
    }
}
