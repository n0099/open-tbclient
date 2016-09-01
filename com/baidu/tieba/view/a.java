package com.baidu.tieba.view;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AudioAnimationView fVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AudioAnimationView audioAnimationView) {
        this.fVB = audioAnimationView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fVB.baP();
    }
}
